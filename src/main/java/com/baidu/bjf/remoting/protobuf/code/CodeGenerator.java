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

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.google.protobuf.Descriptors.Descriptor;

/**
 * Code generator utility class.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public class CodeGenerator {

    /** auto proxied suffix class name. */
    public static final String DEFAULT_SUFFIX_CLASSNAME = "$$JProtoBufClass";

    /** The Constant JAVA_CLASS_FILE_SUFFIX. */
    public static final String JAVA_CLASS_FILE_SUFFIX = ".class";

    /** Logger for this class. */
    private static final Logger LOGGER = Logger.getLogger(CodeGenerator.class.getName());

    /** target fields which marked <code> @Protofuf </code> annotation. */
    private List<FieldInfo> fields;

    /** enable debug mode. */
    private boolean debug = false;

    /**
     * static path for output dynamic compiled class file.
     */
    private File outputPath;

    /** The relative proxy classes. */
    private Set<Class<?>> relativeProxyClasses = new HashSet<Class<?>>();

    /**
     * Gets the relative proxy classes.
     *
     * @return the relative proxy classes
     */
    public Set<Class<?>> getRelativeProxyClasses() {
        return relativeProxyClasses;
    }

    /**
     * Sets the static path for output dynamic compiled class file.
     *
     * @param outputPath the new static path for output dynamic compiled class file
     */
    public void setOutputPath(File outputPath) {
        this.outputPath = outputPath;
    }

    /**
     * Checks if is enable debug mode.
     *
     * @return the enable debug mode
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * Sets the enable debug mode.
     *
     * @param debug the new enable debug mode
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /** target class to parse <code>@Protobuf</code> annotation to generate code. */
    private Class<?> cls;

    /**
     * Constructor method.
     *
     * @param fields protobuf mapped fields
     * @param cls protobuf mapped class
     */
    public CodeGenerator(List<FieldInfo> fields, Class<?> cls) {
        super();
        this.fields = fields;
        this.cls = cls;
    }

    /**
     * Gets the class name.
     *
     * @return the class name
     */
    public String getClassName() {
        return ClassHelper.getClassName(cls) + DEFAULT_SUFFIX_CLASSNAME;
    }

    /**
     * Gets the package.
     *
     * @return the package
     */
    public String getPackage() {
        return ClassHelper.getPackage(cls);
    }

    /**
     * Gets the full class name.
     *
     * @return the full class name
     */
    public String getFullClassName() {
        if (StringUtils.isEmpty(getPackage())) {
            return getClassName();
        }

        return getPackage() + ClassHelper.PACKAGE_SEPARATOR + getClassName();
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {

        String className = getClassName();

        ClassCode code = new ClassCode(ClassCode.SCOPE_PUBLIC, className);
        // to implements Codec interface
        code.addInteface(Codec.class.getName() + "<" + ClassHelper.getInternalName(cls.getName()) + ">");

        // package
        code.setPkg(getPackage());
        // import classes
        genImportCode(code);

        // define Descriptor field
        String descriptorClsName = ClassHelper.getInternalName(Descriptor.class.getName());
        code.addField(ClassCode.SCOPE_DEFAULT, descriptorClsName, "descriptor", null);

        // define class
        code.addMethod(getEncodeMethodCode());
        code.addMethod(getDecodeMethodCode());
        code.addMethod(getSizeMethodCode());
        code.addMethod(getWriteToMethodCode());
        code.addMethod(getReadFromMethodCode());
        code.addMethod(getGetDescriptorMethodCode());

        return code.toCode();
    }

    /**
     * generate import code.
     *
     * @param code the code
     */
    private void genImportCode(ClassCode code) {
        code.importClass("com.google.protobuf.*");
        code.importClass("com.baidu.bjf.remoting.protobuf.code.*");
        code.importClass("java.io.IOException");
        code.importClass("com.baidu.bjf.remoting.protobuf.utils.*");
        code.importClass("java.lang.reflect.*");
        code.importClass("com.baidu.bjf.remoting.protobuf.*");
        code.importClass("java.util.*");

        if (!StringUtils.isEmpty(getPackage())) {
            code.importClass(ClassHelper.getInternalName(cls.getName()));
        }
    }

    /**
     * To generate parse google protocol buffer byte array parser code.
     *
     * @param code add new generated code to the builder.
     * @return the parses the bytes method code
     */
    private void getParseBytesMethodCode(MethodCode mc) {

        StringBuilder code = new StringBuilder();
        // define return
        code.append(ClassHelper.getInternalName(cls.getName())).append(" ret = new ");
        code.append(ClassHelper.getInternalName(cls.getName())).append("()");
        mc.appendLineCode1(code.toString());
        code.setLength(0);

        // 执行初始化，主要针对枚举类型
        for (FieldInfo field : fields) {
            boolean isList = field.isList();
            if (field.getFieldType() == FieldType.ENUM) {
                String clsName = ClassHelper.getInternalName(field.getField().getType().getName());
                if (!isList) {
                    String express =
                            "java.lang.Enum.valueOf(" + clsName + ".class, " + clsName + ".values()[0].name())";
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
        mc.appendLineCode1(ClassCode.CODE_FORMAT + "int tag = input.readTag()");
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
                String clsName = ClassHelper.getInternalName(field.getField().getType().getName());
                if (isList) {
                    if (field.getGenericKeyType() != null) {
                        Class cls = field.getGenericKeyType();
                        clsName = ClassHelper.getInternalName(cls.getName());
                    }
                }
                express = "java.lang.Enum.valueOf(" + clsName + ".class, CodedConstant.getEnumName(" + clsName
                        + ".values()," + "input.read" + t + "()))";
            } else {
                express = "input.read" + t + "()";
            }

            // if List type and element is object message type
            if (isList && field.getFieldType() == FieldType.OBJECT) {
                if (field.getGenericKeyType() != null) {
                    Class cls = field.getGenericKeyType();

                    String name = ClassHelper.getInternalName(cls.getName()); // need
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

                    mc.appendLineCode1("int length = input.readRawVarint32()");
                    mc.appendLineCode1("final int oldLimit = input.pushLimit(length)");
                    listTypeCheck = true;
                    express = "(" + name + ") codec.readFrom(input)";

                }
            } else if (field.getFieldType() == FieldType.OBJECT) { // if object
                                                                   // message
                                                                   // type
                Class cls = field.getField().getType();
                String name = ClassHelper.getInternalName(cls.getName()); // need
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

                mc.appendLineCode1("int length = input.readRawVarint32()");
                mc.appendLineCode1("final int oldLimit = input.pushLimit(length)");

                listTypeCheck = true;
                express = "(" + name + ") codec.readFrom(input)";
            }

            if (field.getFieldType() == FieldType.BYTES) {
                express += ".toByteArray()";
            }

            mc.appendLineCode1(getSetToField("ret", field.getField(), cls, express, isList, field.isMap()));

            if (listTypeCheck) {
                mc.appendLineCode1("input.checkLastTagWas(0)");
                mc.appendLineCode1("input.popLimit(oldLimit)");
            }

            mc.appendLineCode1("continue");
            mc.appendLineCode0("}");

        }

        mc.appendLineCode1("input.skipField(tag)");
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
        mc.setReturnType(ClassHelper.getInternalName(cls.getName()));
        mc.addParameter("byte[]", "bb");
        mc.addException("IOException");

        // add method code
        mc.appendLineCode1("CodedInputStream input = CodedInputStream.newInstance(bb, 0, bb.length)");

        getParseBytesMethodCode(mc);

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
        mc.addException("IOException");

        mc.appendLineCode0("if (this.descriptor != null) {");
        mc.appendLineCode1("return this.descriptor");
        mc.appendLineCode0("}");

        StringBuilder code = new StringBuilder();
        code.append(descriptorClsName).append(" descriptor = ");
        code.append("CodedConstant.getDescriptor(").append(ClassHelper.getInternalName(cls.getName()))
                .append(JAVA_CLASS_FILE_SUFFIX).append(")");
        mc.appendLineCode1(code.toString());

        mc.appendLineCode1("return (this.descriptor = descriptor)");
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
        mc.setReturnType(ClassHelper.getInternalName(cls.getName()));
        mc.setScope(ClassCode.SCOPE_PUBLIC);
        mc.addParameter("CodedInputStream", "input");
        mc.addException("IOException");

        getParseBytesMethodCode(mc);

        return mc;
    }

    /**
     * Check {@link FieldType} is validate to class type of {@link Field}.
     *
     * @param type the type
     * @param field the field
     */
    private void checkType(FieldType type, Field field) {
        Class<?> cls = field.getType();

        if (type == FieldType.OBJECT || type == FieldType.ENUM) {
            return;
        }

        String javaType = type.getJavaType();
        if (Integer.class.getSimpleName().equals(javaType)) {
            if (cls.getSimpleName().equals("int") || Integer.class.getSimpleName().equals(cls.getSimpleName())) {
                return;
            }
            throw new IllegalArgumentException(getMismatchTypeErroMessage(type, field));
        }
        if (!javaType.equalsIgnoreCase(cls.getSimpleName())) {
            throw new IllegalArgumentException(getMismatchTypeErroMessage(type, field));
        }
    }

    /**
     * get error message info by type not matched.
     *
     * @param type the type
     * @param field the field
     * @return error message for mismatch type
     */
    private String getMismatchTypeErroMessage(FieldType type, Field field) {
        return "Type mismatch. @Protobuf required type '" + type.getJavaType() + "' but field type is '"
                + field.getType().getSimpleName() + "' of field name '" + field.getName() + "' on class "
                + field.getDeclaringClass().getName();
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
        mc.addParameter(ClassHelper.getInternalName(cls.getName()), "t");
        mc.addException("IOException");

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
        mc.appendLineCode1("writeTo(t, output)");
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
        mc.addParameter(ClassHelper.getInternalName(cls.getName()), "t");
        mc.addParameter("CodedOutputStream", "output");
        mc.addException("IOException");

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
                    CodedConstant.getMappedWriteCode(field, "output", field.getOrder(), field.getFieldType(), isList));
        }

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
        mc.addParameter(ClassHelper.getInternalName(cls.getName()), "t");
        mc.addException("IOException");

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
                    getAccessByField("t", field.getField(), cls), isList));
            // compute size
            StringBuilder code = new StringBuilder();
            code.append("if (!CodedConstant.isNull(").append(getAccessByField("t", field.getField(), cls)).append("))")
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
        if ("boolean".equalsIgnoreCase(field.getType().getName())) {
            getter = "is" + CodedConstant.capitalize(field.getName());
        } else {
            getter = "get" + CodedConstant.capitalize(field.getName());
        }
        // check method exist
        try {
            cls.getMethod(getter, new Class<?>[0]);
            return target + ClassHelper.PACKAGE_SEPARATOR + getter + "()";
        } catch (Exception e) {
            LOGGER.log(Level.FINE, e.getMessage(), e);
        }

        String type = field.getType().getName();
        if ("[B".equals(type) || "[Ljava.lang.Byte;".equals(type)) {
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
            LOGGER.log(Level.FINE, e.getMessage(), e);
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
