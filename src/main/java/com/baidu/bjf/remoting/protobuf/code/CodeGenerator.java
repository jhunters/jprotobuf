/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.bjf.remoting.protobuf.code;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.EnableZigZap;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.ProtobufProxyUtils;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;

/**
 * Code generator utility class.
 * 
 * @author xiemalin
 * @since 1.0.0
 */ 
public class CodeGenerator extends AbstractCodeGenerator {

    /** auto proxied suffix class name. */
    public static final String DEFAULT_SUFFIX_CLASSNAME = "$$JProtoBufClass";

    /** The Constant JAVA_CLASS_FILE_SUFFIX. */
    public static final String JAVA_CLASS_FILE_SUFFIX = ".class";

    /** Logger for this class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeGenerator.class.getCanonicalName());

    /** The relative proxy classes. */
    private Set<Class<?>> relativeProxyClasses = new HashSet<Class<?>>();
    
    /** The fields. */
    protected List<FieldInfo> fields;

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#getRelativeProxyClasses()
     */
    public Set<Class<?>> getRelativeProxyClasses() {
        return relativeProxyClasses;
    }

    /**
     * Constructor method.
     *
     * @param cls protobuf mapped class
     */
    public CodeGenerator(Class<?> cls) {
        super(cls);
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#getClassName()
     */
    @Override
    public String getClassName() {
        return ClassHelper.getClassName(cls) + DEFAULT_SUFFIX_CLASSNAME;
    }


    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#getCode()
     */
    @Override
    public String getCode() {
        ClassCode code = getClassCode();
        return code.toCode();
    }
    
    /**
     * Gets the class code.
     *
     * @return the class code
     */
    public ClassCode getClassCode() {
        if (fields == null) {
            fields = fetchFieldInfos();
        }
        
        String className = getClassName();
        
        ClassCode code = new ClassCode(ClassCode.SCOPE_PUBLIC, className);
        // to implements Codec interface
        InterfaceCode interfaceCode = new InterfaceCode(Codec.class.getName());
        interfaceCode.addGeneric(ClassHelper.getInternalName(cls.getCanonicalName()));
        code.addInteface(interfaceCode);
        
        // package
        code.setPkg(getPackage());
        // import classes
        genImportCode(code);
        
        // define Descriptor field
        code.addField(ClassCode.SCOPE_DEFAULT, Descriptor.class, "descriptor", null);
        
        // define class
        code.addMethod(getWriteToMethodCode());
        code.addMethod(getEncodeMethodCode());
        code.addMethod(getDecodeMethodCode());
        code.addMethod(getSizeMethodCode());
        code.addMethod(getReadFromMethodCode());
        code.addMethod(getGetDescriptorMethodCode());
        return code;
    }
    
    /**
     * Fetch field infos.
     *
     * @return the list
     */
    protected List<FieldInfo> fetchFieldInfos() {
        // if set ProtobufClass annotation
        Annotation annotation = cls.getAnnotation(ProtobufClass.class);
        
        Annotation zipZap = cls.getAnnotation(EnableZigZap.class);
        boolean isZipZap = false;
        if (zipZap != null) {
            isZipZap = true;
        }
        
        boolean typeDefined = false;
        List<Field> fields = null;
        if (annotation == null) {
            fields = FieldUtils.findMatchedFields(cls, Protobuf.class);
            if (fields.isEmpty()) {
                throw new IllegalArgumentException("Invalid class [" + cls.getName() + "] no field use annotation @"
                        + Protobuf.class.getName() + " at class " + cls.getName());
            }
        } else {
            typeDefined = true;
            
            fields = FieldUtils.findMatchedFields(cls, null);
        }
        
        List<FieldInfo> fieldInfos = ProtobufProxyUtils.processDefaultValue(fields, typeDefined, isZipZap);
        return fieldInfos;
    }

    /**
     * generate import code.
     *
     * @param code the code
     */
    private void genImportCode(ClassCode code) {
        code.importClass("java.util.*");
        code.importClass("java.io.IOException");
        code.importClass("java.lang.reflect.*");
        code.importClass("com.baidu.bjf.remoting.protobuf.code.*");
        code.importClass("com.baidu.bjf.remoting.protobuf.utils.*");
        code.importClass("com.baidu.bjf.remoting.protobuf.*");
        code.importClass("com.google.protobuf.*");
        code.importClass("com.baidu.bjf.remoting.protobuf.code.*");
        code.importClass("com.baidu.bjf.remoting.protobuf.utils.*");
        code.importClass("com.baidu.bjf.remoting.protobuf");

        if (!StringUtils.isEmpty(getPackage())) {
            code.importClass(ClassHelper.getInternalName(cls.getCanonicalName()));
        }
    }

    /**
     * To generate parse google protocol buffer byte array parser code.
     *
     * @param mc the mc
     * @return the parses the bytes method code
     */
    private void getParseBytesMethodCode(MethodCode mc, String paramName) {

        StringBuilder code = new StringBuilder();
        // define return
        code.append(ClassHelper.getInternalName(cls.getCanonicalName())).append(" ret = new ");
        code.append(ClassHelper.getInternalName(cls.getCanonicalName())).append("()");
        mc.appendLineCode1(code.toString());
        code.setLength(0);

        // 执行初始化，主要针对枚举类型
        for (FieldInfo field : fields) {
            boolean isList = field.isList();
            if (field.getFieldType() == FieldType.ENUM) {
                String clsName = ClassHelper.getInternalName(field.getField().getType().getCanonicalName());
                if (!isList) {
                    String express =
                            "CodedConstant.getEnumValue(" + clsName + ".class, " + clsName + ".values()[0].name())";
                    // add set get method
                    mc.appendLineCode1(getSetToField("ret", field.getField(), cls, express, isList, field.isMap()));

                }
            }
        }

        // add parse method code here
        mc.appendLineCode0("try {");
        mc.appendLineCode1(ClassCode.CODE_FORMAT + "boolean done = false");
        mc.appendLineCode1(ClassCode.CODE_FORMAT + "Codec codec = null");
        mc.appendLineCode0(ClassCode.CODE_FORMAT + "while (!done) {");
        mc.appendLineCode1(ClassCode.CODE_FORMAT + "int tag =  " + paramName + ".readTag()");
        mc.appendLineCode0(ClassCode.CODE_FORMAT + "if (tag == 0) { break;}");

        for (FieldInfo field : fields) {
            boolean isList = field.isList();

            if (field.getFieldType() != FieldType.DEFAULT) {
                code.append("if (tag == ").append(CodedConstant.makeTag(field.getOrder(),
                        field.getFieldType().getInternalFieldType().getWireType()));
                code.append(") {");

                mc.appendLineCode0(code.toString());
            } else {
                code.append("if (tag == CodedConstant.makeTag(").append(field.getOrder());
                code.append(",WireFormat.").append(field.getFieldType().getWireFormat()).append(")) {");
                mc.appendLineCode0(code.toString());
            }
            code.setLength(0);

            String t = field.getFieldType().getType();
            t = CodedConstant.capitalize(t);

            boolean listTypeCheck = false;
            String express;

            // enumeration type
            if (field.getFieldType() == FieldType.ENUM) {
                String clsName = ClassHelper.getInternalName(field.getField().getType().getCanonicalName());
                if (isList) {
                    if (field.getGenericKeyType() != null) {
                        Class cls = field.getGenericKeyType();
                        clsName = ClassHelper.getInternalName(cls.getCanonicalName());
                    }
                }
                express = "CodedConstant.getEnumValue(" + clsName + ".class, CodedConstant.getEnumName(" + clsName
                        + ".values()," + paramName + ".read" + t + "()))";
            } else {
                express = paramName + ".read" + t + "()";
            }

            // if List type and element is object message type
            if (isList && field.getFieldType() == FieldType.OBJECT) {
                if (field.getGenericKeyType() != null) {
                    Class cls = field.getGenericKeyType();

                    String name = ClassHelper.getInternalName(cls.getCanonicalName()); // need
                                                                              // to
                                                                              // parse
                                                                              // nested
                                                                              // class
                    code.append("codec = ProtobufProxy.create(").append(name).append(".class");
                    if (debug) {
                        code.append(", true");
                    } else {
                        code.append(", false");
                    }

                    String spath = "ProtobufProxy.OUTPUT_PATH.get()";
                    code.append(",").append(spath);
                    code.append(")");
                    mc.appendLineCode1(code.toString());
                    code.setLength(0);

                    mc.appendLineCode1("int length =  " + paramName + ".readRawVarint32()");
                    mc.appendLineCode1("final int oldLimit =  " + paramName + ".pushLimit(length)");
                    listTypeCheck = true;
                    express = "(" + name + ") codec.readFrom( " + paramName + ")";

                }
            } else if (field.getFieldType() == FieldType.OBJECT) { // if object
                                                                   // message
                                                                   // type
                Class cls = field.getField().getType();
                String name = ClassHelper.getInternalName(cls.getCanonicalName()); // need
                                                                          // to
                                                                          // parse
                                                                          // nested
                                                                          // class
                code.append("codec = ProtobufProxy.create(").append(name).append(".class");
                if (debug) {
                    code.append(", true");
                } else {
                    code.append(", false");
                }

                String spath = "ProtobufProxy.OUTPUT_PATH.get()";
                code.append(",").append(spath);
                code.append(")");
                mc.appendLineCode1(code.toString());
                code.setLength(0);

                mc.appendLineCode1("int length =  " + paramName + ".readRawVarint32()");
                mc.appendLineCode1("final int oldLimit =  " + paramName + ".pushLimit(length)");

                listTypeCheck = true;
                express = "(" + name + ") codec.readFrom( " + paramName + ")";
            }

            if (field.getFieldType() == FieldType.BYTES) {
                express += ".toByteArray()";
            }

            mc.appendLineCode1(getSetToField("ret", field.getField(), cls, express, isList, field.isMap()));

            if (listTypeCheck) {
                mc.appendLineCode1(paramName + ".checkLastTagWas(0)");
                mc.appendLineCode1(paramName + ".popLimit(oldLimit)");
            }

            mc.appendLineCode1("continue");
            mc.appendLineCode0("}");

        }

        mc.appendLineCode1(paramName + ".skipField(tag)");
        mc.appendLineCode0("}");
        mc.appendLineCode0("} catch (com.google.protobuf.InvalidProtocolBufferException e) {");
        mc.appendLineCode1("throw e");
        mc.appendLineCode0("} catch (java.io.IOException e) {");
        mc.appendLineCode1("throw e");
        mc.appendLineCode0("}");

        for (FieldInfo field : fields) {
            if (field.isRequired()) {
                mc.appendLineCode0(CodedConstant.getRetRequiredCheck(getAccessByField("ret", field.getField(), cls),
                        field.getField()));
            }
        }

        mc.appendLineCode1("return ret");
    }

    /**
     * Gets the decode method code.
     *
     * @return the decode method code
     */
    private MethodCode getDecodeMethodCode() {
        MethodCode mc = new MethodCode();
        mc.setName("decode");
        mc.setScope(ClassCode.SCOPE_PUBLIC);
        mc.setReturnType("java.lang.Object");
        mc.addParameter("byte[]", "$1");
        mc.addException(IOException.class.getName());

        // add method code
        mc.appendLineCode1("CodedInputStream input = CodedInputStream.newInstance($1, 0, $1.length)");

        getParseBytesMethodCode(mc, "input");

        return mc;
    }

    /**
     * Gets the gets the descriptor method code.
     *
     * @return the gets the descriptor method code
     */
    private MethodCode getGetDescriptorMethodCode() {
        String descriptorClsName = ClassHelper.getInternalName(Descriptor.class.getName());

        MethodCode mc = new MethodCode();
        mc.setName("getDescriptor");
        mc.setReturnType(descriptorClsName);
        mc.setScope(ClassCode.SCOPE_PUBLIC);
        mc.addException(IOException.class.getName());

        String methodSource = CodeTemplate.descriptorMethodSource(cls);

        mc.appendLineCode0(methodSource);
        return mc;
    }

    /**
     * Gets the read from method code.
     *
     * @return the read from method code
     */
    private MethodCode getReadFromMethodCode() {
        MethodCode mc = new MethodCode();
        mc.setName("readFrom");
        mc.setReturnType("java.lang.Object");
        mc.setScope(ClassCode.SCOPE_PUBLIC);
        mc.addParameter(CodedInputStream.class.getName(), "$1");
        mc.addException(IOException.class.getName());

        getParseBytesMethodCode(mc, "$1");

        return mc;
    }


    /**
     * Gets the encode method code.
     *
     * @return the encode method code
     */
    private MethodCode getEncodeMethodCode() {
        MethodCode mc = new MethodCode();
        mc.setName("encode");
        mc.setScope(ClassCode.SCOPE_PUBLIC);
        mc.setReturnType("byte[]");
        mc.addParameter("java.lang.Object", "$1");
        mc.addException(IOException.class.getName());
        
        String pNameType = ClassHelper.getInternalName(cls.getCanonicalName());
        mc.appendLineCode1(pNameType + " t = (" + pNameType + ") $1");

        // add method code
        mc.appendLineCode1("int size = 0");
        Set<Integer> orders = new HashSet<Integer>();
        // encode method
        for (FieldInfo field : fields) {
            boolean isList = field.isList();
            // check type
            if (!isList) {
                checkType(field.getFieldType(), field.getField());
            }

            if (orders.contains(field.getOrder())) {
                throw new IllegalArgumentException("Field order '" + field.getOrder() + "' on field"
                        + field.getField().getName() + " already exsit.");
            }
            // define field
            String checkParameterLine = CodedConstant.getMappedTypeDefined(field.getOrder(), field.getFieldType(),
                    getAccessByField("t", field.getField(), cls), isList);
            mc.appendLineCode0(checkParameterLine);

            // compute size
            StringBuilder code = new StringBuilder();
            code.append("if (!CodedConstant.isNull(").append(getAccessByField("t", field.getField(), cls)).append("))")
                    .append("{");

            mc.appendLineCode0(code.toString());

            code.setLength(0); // clear old code
            code.append("size += ");
            code.append(CodedConstant.getMappedTypeSize(field, field.getOrder(), field.getFieldType(), isList, debug,
                    outputPath));
            mc.appendLineCode0(code.toString());
            mc.appendLineCode0("}");

            if (field.isRequired()) {
                mc.appendLineCode0(CodedConstant.getRequiredCheck(field.getOrder(), field.getField()));
            }
        }

        mc.appendLineCode1("final byte[] result = new byte[size]");
        mc.appendLineCode1("final CodedOutputStream output = CodedOutputStream.newInstance(result)");
        // call writeTo method
        mc.appendLineCode1("writeTo($1, output)");
        mc.appendLineCode1("return result");

        return mc;
    }

    /**
     * Gets the write to method code.
     *
     * @return the write to method code
     */
    private MethodCode getWriteToMethodCode() {
        MethodCode mc = new MethodCode();
        mc.setName("writeTo");
        mc.setReturnType("void");
        mc.setScope(ClassCode.SCOPE_PUBLIC);
        mc.addParameter("java.lang.Object", "$1");
        mc.addParameter(CodedOutputStream.class.getName(), "$2");
        mc.addException(IOException.class.getName());
        
        String pNameType = ClassHelper.getInternalName(cls.getCanonicalName());
        mc.appendLineCode1(pNameType + " t = (" + pNameType + ") $1");

        Set<Integer> orders = new HashSet<Integer>();
        for (FieldInfo field : fields) {

            boolean isList = field.isList();

            // check type
            if (!isList) {
                checkType(field.getFieldType(), field.getField());
            }

            if (orders.contains(field.getOrder())) {
                throw new IllegalArgumentException("Field order '" + field.getOrder() + "' on field"
                        + field.getField().getName() + " already exsit.");
            }
            // define field
            mc.appendLineCode0(CodedConstant.getMappedTypeDefined(field.getOrder(), field.getFieldType(),
                    getAccessByField("t", field.getField(), cls), isList));
            if (field.isRequired()) {
                mc.appendLineCode0(CodedConstant.getRequiredCheck(field.getOrder(), field.getField()));
            }
        }

        for (FieldInfo field : fields) {
            boolean isList = field.isList();
            // set write to byte
            mc.appendLineCode0(
                    CodedConstant.getMappedWriteCode(field, "$2", field.getOrder(), field.getFieldType(), isList));
        }
        
        mc.appendLineCode1("$2.flush()");

        return mc;
    }

    /**
     * Gets the size method code.
     *
     * @return the size method code
     */
    private MethodCode getSizeMethodCode() {
        MethodCode mc = new MethodCode();
        mc.setName("size");
        mc.setScope(ClassCode.SCOPE_PUBLIC);
        mc.setReturnType("int");
        mc.addParameter(ClassHelper.getInternalName(cls.getCanonicalName()), "$1");
        mc.addException(IOException.class.getName());

        // add method code
        mc.appendLineCode1("int size = 0");

        Set<Integer> orders = new HashSet<Integer>();
        // encode method
        for (FieldInfo field : fields) {

            boolean isList = field.isList();

            // check type
            if (!isList) {
                checkType(field.getFieldType(), field.getField());
            }

            if (orders.contains(field.getOrder())) {
                throw new IllegalArgumentException("Field order '" + field.getOrder() + "' on field"
                        + field.getField().getName() + " already exsit.");
            }
            // define field
            mc.appendLineCode0(CodedConstant.getMappedTypeDefined(field.getOrder(), field.getFieldType(),
                    getAccessByField("$1", field.getField(), cls), isList));
            // compute size
            StringBuilder code = new StringBuilder();
            code.append("if (!CodedConstant.isNull(").append(getAccessByField("$1", field.getField(), cls)).append("))")
                    .append("{");
            mc.appendLineCode0(code.toString());

            code.setLength(0);
            code.append("size += ");
            code.append(CodedConstant.getMappedTypeSize(field, field.getOrder(), field.getFieldType(), isList, debug,
                    outputPath));
            code.append("}");
            mc.appendLineCode0(code.toString());

            if (field.isRequired()) {
                mc.appendLineCode0(CodedConstant.getRequiredCheck(field.getOrder(), field.getField()));
            }
        }

        mc.appendLineCode1("return size");

        return mc;
    }

    /**
     * get field access code.
     *
     * @param target target instance name
     * @param field java field instance
     * @param cls mapped class
     * @return full field access java code
     */
    protected String getAccessByField(String target, Field field, Class<?> cls) {
        if (field.getModifiers() == Modifier.PUBLIC) {
            return target + ClassHelper.PACKAGE_SEPARATOR + field.getName();
        }
        // check if has getter method
        String getter;
        if ("boolean".equalsIgnoreCase(field.getType().getCanonicalName())) {
            getter = "is" + CodedConstant.capitalize(field.getName());
        } else {
            getter = "get" + CodedConstant.capitalize(field.getName());
        }
        // check method exist
        try {
            cls.getMethod(getter, new Class<?>[0]);
            return target + ClassHelper.PACKAGE_SEPARATOR + getter + "()";
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }

        String type = field.getType().getCanonicalName();
        if ("[B".equals(type)) {
            type = "byte[]";
        }
        
        if ("[Ljava.lang.Byte;".equals(type) || "java.lang.Byte[]".equals(type)) {
            type = "byte[]";
        }

        // use reflection to get value
        String code = "(" + FieldUtils.toObjectType(type) + ") ";
        code += "FieldUtils.getField(" + target + ", \"" + field.getName() + "\")";

        return code;
    }

    /**
     * generate access {@link Field} value source code. support public field access, getter method access and reflection
     * access.
     *
     * @param target the target
     * @param field the field
     * @param cls the cls
     * @param express the express
     * @param isList the is list
     * @param isMap the is map
     * @return the sets the to field
     */
    protected String getSetToField(String target, Field field, Class<?> cls, String express, boolean isList,
            boolean isMap) {
        StringBuilder ret = new StringBuilder();
        if (isList || isMap) {
            ret.append("if ((").append(getAccessByField(target, field, cls)).append(") == null) {")
                    .append(ClassCode.LINE_BREAK);
        }
        // if field of public modifier we can access directly
        if (Modifier.isPublic(field.getModifiers())) {
            if (isList) {
                // should initialize list
                ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(field.getName())
                        .append("= new ArrayList()").append(ClassCode.JAVA_LINE_BREAK).append("}")
                        .append(ClassCode.LINE_BREAK);
                if (express != null) {
                    ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(field.getName()).append(".add(")
                            .append(express).append(")");
                }
                return ret.toString();
            } else if (isMap) {
                ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(field.getName())
                        .append("= new HashMap()").append(ClassCode.JAVA_LINE_BREAK).append("}")
                        .append(ClassCode.LINE_BREAK);
                return ret.append(express).toString();
            }
            return target + ClassHelper.PACKAGE_SEPARATOR + field.getName() + "=" + express + ClassCode.LINE_BREAK;
        }
        String setter = "set" + CodedConstant.capitalize(field.getName());
        // check method exist
        try {
            cls.getMethod(setter, new Class<?>[] { field.getType() });
            if (isList) {
                ret.append("List __list = new ArrayList()").append(ClassCode.JAVA_LINE_BREAK);
                ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(setter).append("(__list)")
                        .append(ClassCode.JAVA_LINE_BREAK).append("}").append(ClassCode.LINE_BREAK);

                if (express != null) {
                    ret.append("(").append(getAccessByField(target, field, cls)).append(").add(").append(express)
                            .append(")");
                }
                return ret.toString();
            } else if (isMap) {
                ret.append("Map __map = new HashMap()").append(ClassCode.JAVA_LINE_BREAK);
                ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(setter).append("(__map)")
                        .append(ClassCode.JAVA_LINE_BREAK).append("}").append(ClassCode.LINE_BREAK);
                return ret + express;
            }
            return target + ClassHelper.PACKAGE_SEPARATOR + setter + "(" + express + ")\n";
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }

        if (isList) {
            ret.append("List __list = new ArrayList()").append(ClassCode.JAVA_LINE_BREAK);
            ret.append("FieldUtils.setField(").append(target).append(", \"").append(field.getName())
                    .append("\", __list)").append(ClassCode.JAVA_LINE_BREAK).append("}").append(ClassCode.LINE_BREAK);
            if (express != null) {
                ret.append("(").append(getAccessByField(target, field, cls)).append(").add(").append(express)
                        .append(")");
            }
            return ret.toString();
        } else if (isMap) {
            ret.append("Map __map = new HashMap()").append(ClassCode.JAVA_LINE_BREAK);
            ret.append("FieldUtils.setField(").append(target).append(", \"").append(field.getName())
                    .append("\", __map)").append(ClassCode.JAVA_LINE_BREAK).append("}").append(ClassCode.LINE_BREAK);
            return ret + express;
        }

        // use reflection to get value
        String code = "";
        if (express != null) {
            code = "FieldUtils.setField(" + target + ", \"" + field.getName() + "\", " + express + ")"
                    + ClassCode.LINE_BREAK;
        }
        return code;
    }

}
