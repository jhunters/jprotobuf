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
package com.baidu.bjf.remoting.protobuf;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.ProtobufProxyUtils;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.WireFormat;

/**
 * Code generator utility class.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public class CodeGenerator implements ICodeGenerator {

    /**
     * line break for editor
     */
    public static final String LINE_BREAK = "\n";

    /**
     * java line end
     */
    public static final String JAVA_END = ";";

    /**
     * line break for JAVA
     */
    public static final String JAVA_LINE_BREAK = JAVA_END + LINE_BREAK;

    /**
     * auto proxied suffix class name
     */
    private static final String DEFAULT_SUFFIX_CLASSNAME = "$$JProtoBufClass";

    public static final String PACKAGE_SPLIT = ".";
    
    public static final String CLASS_JOINER = "$";

    /**
     * 
     */
    public static final String JAVA_CLASS_FILE_SUFFIX = ".class";

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(CodeGenerator.class.getName());

    /**
     * target fields which marked <code> @Protofuf </code> annotation
     */
    private List<FieldInfo> fields;

    /**
     * enable debug mode
     */
    private boolean debug = false;

    /**
     * static path for output dynamic compiled class file.
     */
    private File outputPath;

    private Set<Class<?>> relativeProxyClasses = new HashSet<Class<?>>();

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.ICodeGenerator#getRelativeProxyClasses()
     */
    @Override
    public Set<Class<?>> getRelativeProxyClasses() {
        return relativeProxyClasses;
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.ICodeGenerator#setOutputPath(java.io.File)
     */
    @Override
    public void setOutputPath(File outputPath) {
        this.outputPath = outputPath;
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.ICodeGenerator#isDebug()
     */
    @Override
    public boolean isDebug() {
        return debug;
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.ICodeGenerator#setDebug(boolean)
     */
    @Override
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * target class to parse <code>@Protobuf</code> annotation to generate code
     */
    private Class<?> cls;

    /**
     * Constructor method
     * 
     * @param fields protobuf mapped fields
     * @param cls protobuf mapped class
     */
    public CodeGenerator(Class<?> cls) {
        super();
        this.cls = cls;
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.ICodeGenerator#getClassName()
     */
    @Override
    public String getClassName() {
        return ClassHelper.getClassName(cls) + DEFAULT_SUFFIX_CLASSNAME;
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.ICodeGenerator#getPackage()
     */
    @Override
    public String getPackage() {
        return ClassHelper.getPackage(cls);
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.ICodeGenerator#getFullClassName()
     */
    @Override
    public String getFullClassName() {
        return getPackage() + ClassHelper.PACKAGE_SEPARATOR + getClassName();
    }

    /**
     * generate package code
     * 
     * @param code
     */
    private void genPackageCode(StringBuilder code) {
        if (getPackage().length() > 0) {
            code.append("package " + getPackage() + JAVA_LINE_BREAK);
        }

    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.ICodeGenerator#getCode()
     */
    @Override
    public String getCode() {
        
        if (fields == null) {
            fields = fetchFieldInfos();
        }
        
        StringBuilder code = new StringBuilder();

        String className = getClassName();
        genPackageCode(code);
        genImportCode(code);

        // define class code
        code.append("public class " + className + " implements com.baidu.bjf.remoting.protobuf.Codec");
        code.append("<").append(ClassHelper.getInternalName(cls.getCanonicalName())).append("> {" + LINE_BREAK);

        // define Descriptor field
        String descriptorClsName = ClassHelper.getInternalName(Descriptor.class.getCanonicalName());
        code.append("private ").append(descriptorClsName).append(" descriptor").append(JAVA_LINE_BREAK);

        code.append(getEncodeMethodCode());
        code.append(getDecodeMethodCode());
        code.append(getSizeMethodCode());
        code.append(getWriteToMethodCode());
        code.append(getReadFromMethodCode());
        code.append(getGetDescriptorMethodCode());
        code.append("}");

        return code.toString();
    }
    
    /**
     * Fetch field infos.
     *
     * @return the list
     */
    protected List<FieldInfo> fetchFieldInfos() {
        // if set ProtobufClass annotation
        Annotation annotation = cls.getAnnotation(ProtobufClass.class);
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
        
        List<FieldInfo> fieldInfos = ProtobufProxyUtils.processDefaultValue(fields, typeDefined);
        return fieldInfos;
    }

    /**
     * generate import code
     * 
     * @param code
     */
    private void genImportCode(StringBuilder code) {
        code.append("import com.google.protobuf.*").append(JAVA_LINE_BREAK);
        code.append("import java.io.IOException").append(JAVA_LINE_BREAK);
        code.append("import com.baidu.bjf.remoting.protobuf.utils.*").append(JAVA_LINE_BREAK);
        code.append("import java.lang.reflect.*").append(JAVA_LINE_BREAK);
        code.append("import com.baidu.bjf.remoting.protobuf.*").append(JAVA_LINE_BREAK);
        code.append("import java.util.*").append(JAVA_LINE_BREAK);

        if (!StringUtils.isEmpty(getPackage())) {
            code.append("import ").append(ClassHelper.getInternalName(cls.getCanonicalName())).append(JAVA_LINE_BREAK);
        }
    }

    /**
     * To generate parse google protocol buffer byte array parser code.
     * 
     * @param code add new generated code to the builder.
     */
    private void getParseBytesMethodCode(StringBuilder code) {
        code.append(ClassHelper.getInternalName(cls.getCanonicalName())).append(" ret = new ");
        code.append(ClassHelper.getInternalName(cls.getCanonicalName())).append("()" + JAVA_LINE_BREAK);

        // 执行初始化，主要针对枚举类型
        for (FieldInfo field : fields) {
            boolean isList = field.isList();
            if (field.getFieldType() == FieldType.ENUM) {
                String clsName = ClassHelper.getInternalName(field.getField().getType().getCanonicalName());
                if (!isList) {
                    String express =
                            "java.lang.Enum.valueOf(" + clsName + ".class, " + clsName + ".values()[0].name())";
                    code.append(getSetToField("ret", field.getField(), cls, express, isList, field.isMap(), false))
                            .append(JAVA_LINE_BREAK);
                }
            }
        }

        code.append("try {").append(LINE_BREAK);
        code.append("boolean done = false").append(JAVA_LINE_BREAK);
        code.append("Codec codec = null").append(JAVA_LINE_BREAK);
        code.append("while (!done) {").append(LINE_BREAK);
        code.append("int tag = input.readTag()").append(JAVA_LINE_BREAK);
        code.append("if (tag == 0) { break;}").append(LINE_BREAK);

        for (FieldInfo field : fields) {
            boolean isList = field.isList();

            if (field.getFieldType() != FieldType.DEFAULT) {
                code.append("if (tag == ").append(CodedConstant.makeTag(field.getOrder(),
                        field.getFieldType().getInternalFieldType().getWireType()));
                code.append(") {").append(LINE_BREAK);
            } else {
                code.append("if (tag == CodedConstant.makeTag(").append(field.getOrder());
                code.append(",WireFormat.").append(field.getFieldType().getWireFormat()).append(")) {")
                        .append(LINE_BREAK);
            }

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
                express = "java.lang.Enum.valueOf(" + clsName + ".class, CodedConstant.getEnumName(" + clsName
                        + ".values()," + "input.read" + t + "()))";
            } else {
                express = "input.read" + t + "()";
            }

            // if List type and element is object message type
            if (isList && field.getFieldType() == FieldType.OBJECT) {
                if (field.getGenericKeyType() != null) {
                    Class cls = field.getGenericKeyType();

                    String name = ClassHelper.getInternalName(cls.getCanonicalName()); // need to parse nested class
                    code.append("codec = ProtobufProxy.create(").append(name).append(".class");
                    if (debug) {
                        code.append(", true");
                    } else {
                        code.append(", false");
                    }

                    String spath = "null";
                    if (outputPath != null) {
                        spath = "new java.io.File(\"" + outputPath.getAbsolutePath().replace('\\', '/') + "\")";
                    }
                    code.append(",").append(spath);

                    code.append(")").append(JAVA_LINE_BREAK);
                    code.append("int length = input.readRawVarint32()").append(JAVA_LINE_BREAK);
                    code.append("final int oldLimit = input.pushLimit(length)").append(JAVA_LINE_BREAK);
                    listTypeCheck = true;
                    express = "(" + name + ") codec.readFrom(input)";

                }
            } else if (field.isMap()) {

                String getMapCommand = getMapCommand(field);
                
                if (field.isEnumValueType()) {
                    String enumClassName = field.getGenericeValueType().getCanonicalName();
                    code.append("EnumHandler<").append(enumClassName).append("> handler");
                    code.append("= new EnumHandler");
                    code.append("<").append(enumClassName).append(">() {");
                    code.append(LINE_BREAK);
                    code.append("public ").append(enumClassName).append(" handle(int value) {");
                    code.append(LINE_BREAK);
                    code.append("String enumName = CodedConstant.getEnumName(").append(enumClassName).append(".values(), value)");
                    code.append(JAVA_LINE_BREAK);
                    code.append("return ").append(enumClassName).append(".valueOf(enumName)");
                    code.append(JAVA_LINE_BREAK);
                    code.append("}}");
                    code.append(JAVA_LINE_BREAK);
                    
                }

                express = "CodedConstant.putMapValue(input, " + getMapCommand + ",";
                express += CodedConstant.getMapFieldGenericParameterString(field);
                if (field.isEnumValueType()) {
                    express += ", handler";
                }
                express += ")";

            } else if (field.getFieldType() == FieldType.OBJECT) { // if object message type
                Class cls = field.getField().getType();
                String name = ClassHelper.getInternalName(cls.getCanonicalName()); // need to parse nested class
                code.append("codec = ProtobufProxy.create(").append(name).append(".class");
                if (debug) {
                    code.append(", true");
                } else {
                    code.append(", false");
                }

                String spath = "null";
                if (outputPath != null) {
                    spath = "new java.io.File(\"" + outputPath.getAbsolutePath().replace('\\', '/') + "\")";
                }
                code.append(",").append(spath);
                code.append(")").append(JAVA_LINE_BREAK);
                code.append("int length = input.readRawVarint32()").append(JAVA_LINE_BREAK);
                code.append("final int oldLimit = input.pushLimit(length)").append(JAVA_LINE_BREAK);
                listTypeCheck = true;
                express = "(" + name + ") codec.readFrom(input)";
            }

            if (field.getFieldType() == FieldType.BYTES) {
                express += ".toByteArray()";
            }
            code.append(getSetToField("ret", field.getField(), cls, express, isList, field.isMap(), false));

            code.append(JAVA_LINE_BREAK);

            if (listTypeCheck) {
                code.append("input.checkLastTagWas(0)").append(JAVA_LINE_BREAK);
                code.append("input.popLimit(oldLimit)").append(JAVA_LINE_BREAK);
            }

            code.append("continue").append(JAVA_LINE_BREAK);
            code.append("}").append(LINE_BREAK);

            // read packed type
            if (isList) {
                FieldType fieldType = field.getFieldType();
                if (fieldType.isPrimitive()) {
                    code.append("if (tag == ").append(CodedConstant.makeTag(field.getOrder(),
                            WireFormat.WIRETYPE_LENGTH_DELIMITED));
                    code.append(") {").append(LINE_BREAK);
                    
                    
                    code.append("int length = input.readRawVarint32()").append(JAVA_LINE_BREAK);
                    code.append("int limit = input.pushLimit(length)").append(JAVA_LINE_BREAK);
                    
                    code.append(getSetToField("ret", field.getField(), cls, express, isList, field.isMap(), true));
                    
                    code.append("input.popLimit(limit)").append(JAVA_LINE_BREAK);
                    
                    code.append("continue").append(JAVA_LINE_BREAK);
                    code.append("}").append(LINE_BREAK);
                }
            }

        }

        code.append("input.skipField(tag)").append(JAVA_LINE_BREAK);
        code.append("}").append(LINE_BREAK);
        code.append("} catch (com.google.protobuf.InvalidProtocolBufferException e) {").append(LINE_BREAK);
        code.append("throw e").append(JAVA_LINE_BREAK);
        code.append("} catch (java.io.IOException e) {").append(LINE_BREAK);
        code.append("throw e").append(JAVA_LINE_BREAK);
        code.append("}").append(LINE_BREAK);

        for (FieldInfo field : fields) {
            if (field.isRequired()) {
                code.append(CodedConstant.getRetRequiredCheck(getAccessByField("ret", field.getField(), cls),
                        field.getField()));
            }
        }

        code.append("return ret").append(JAVA_LINE_BREAK);

        code.append("}").append(LINE_BREAK);
    }

    /**
     * generate <code>decode</code> method source code
     * 
     * @return
     */
    private String getDecodeMethodCode() {
        StringBuilder code = new StringBuilder();

        code.append("public ").append(ClassHelper.getInternalName(cls.getCanonicalName()));
        code.append(" decode(byte[] bb) throws IOException {").append(LINE_BREAK);
        code.append("CodedInputStream input = CodedInputStream.newInstance(bb, 0, bb.length)").append(JAVA_LINE_BREAK);
        getParseBytesMethodCode(code);
        return code.toString();
    }

    /**
     * generate <code>getDescriptor</code> method code
     * 
     * @return source code
     */
    private Object getGetDescriptorMethodCode() {
        StringBuilder code = new StringBuilder();

        String descriptorClsName = ClassHelper.getInternalName(Descriptor.class.getCanonicalName());
        code.append("public ").append(descriptorClsName);
        code.append(" getDescriptor() throws IOException {").append(LINE_BREAK);
        code.append("if (this.descriptor != null) {").append(LINE_BREAK);
        code.append("return this.descriptor").append(JAVA_LINE_BREAK);
        code.append("}").append(LINE_BREAK);
        code.append(descriptorClsName).append(" descriptor = ");
        code.append("CodedConstant.getDescriptor(").append(ClassHelper.getInternalName(cls.getCanonicalName()))
                .append(JAVA_CLASS_FILE_SUFFIX).append(")").append(JAVA_LINE_BREAK);
        code.append("return (this.descriptor = descriptor)").append(JAVA_LINE_BREAK);
        code.append("}").append(LINE_BREAK);
        return code.toString();
    }

    /**
     * @param field
     * @return
     */
    private String getMapCommand(FieldInfo field) {
        String keyGeneric;
        keyGeneric = field.getGenericKeyType().getCanonicalName();

        String valueGeneric;
        valueGeneric = field.getGenericeValueType().getCanonicalName();
        String getMapCommand = "(Map<" + keyGeneric;
        getMapCommand = getMapCommand + ", " + valueGeneric + ">)";
        getMapCommand = getMapCommand + getAccessByField("ret", field.getField(), cls);
        return getMapCommand;
    }

    /**
     * generate <code>readFrom</code> method source code
     * 
     * @return
     */
    private String getReadFromMethodCode() {
        StringBuilder code = new StringBuilder();

        code.append("public ").append(ClassHelper.getInternalName(cls.getCanonicalName()))
                .append(" readFrom(CodedInputStream input) throws IOException {").append(LINE_BREAK);

        getParseBytesMethodCode(code);

        return code.toString();
    }

    /**
     * Check {@link FieldType} is validate to class type of {@link Field}
     * 
     * @param type
     * @param field
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
     * get error message info by type not matched
     * 
     * @param type
     * @param field
     * @return error message for mismatch type
     */
    private String getMismatchTypeErroMessage(FieldType type, Field field) {
        return "Type mismatch. @Protobuf required type '" + type.getJavaType() + "' but field type is '"
                + field.getType().getSimpleName() + "' of field name '" + field.getName() + "' on class "
                + field.getDeclaringClass().getCanonicalName();
    }

    /**
     * generate <code>encode</code> method source code
     * 
     * @return encode method code
     */
    private String getEncodeMethodCode() {
        StringBuilder code = new StringBuilder();
        Set<Integer> orders = new HashSet<Integer>();
        // encode method
        code.append("public byte[] encode(").append(ClassHelper.getInternalName(cls.getCanonicalName()));
        code.append(" t) throws IOException {").append(LINE_BREAK);
        code.append("int size = 0").append(JAVA_END);
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
            code.append(CodedConstant.getMappedTypeDefined(field.getOrder(), field.getFieldType(),
                    getAccessByField("t", field.getField(), cls), isList, field.isMap()));
            // compute size
            code.append("if (!CodedConstant.isNull(").append(getAccessByField("t", field.getField(), cls)).append("))")
                    .append("{").append(LINE_BREAK);
            code.append("size += ");
            code.append(CodedConstant.getMappedTypeSize(field, field.getOrder(), field.getFieldType(), isList,
                    field.isMap(), debug, outputPath)).append(LINE_BREAK);
            code.append("}").append(LINE_BREAK);
            if (field.isRequired()) {
                code.append(CodedConstant.getRequiredCheck(field.getOrder(), field.getField()));
            }
        }

        code.append("final byte[] result = new byte[size]").append(JAVA_LINE_BREAK);
        code.append("final CodedOutputStream output = CodedOutputStream.newInstance(result)").append(JAVA_LINE_BREAK);

        // call writeTo method
        code.append("writeTo(t, output)").append(JAVA_LINE_BREAK);

        code.append("return result").append(JAVA_LINE_BREAK);
        code.append("}").append(LINE_BREAK);

        return code.toString();
    }

    /**
     * generate <code>writeTo</code> method source code
     * 
     * @return
     */
    private String getWriteToMethodCode() {
        StringBuilder code = new StringBuilder();
        Set<Integer> orders = new HashSet<Integer>();
        // encode method
        code.append("public void writeTo(").append(ClassHelper.getInternalName(cls.getCanonicalName()))
                .append(" t, CodedOutputStream output) throws IOException {").append(LINE_BREAK);
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
            code.append(CodedConstant.getMappedTypeDefined(field.getOrder(), field.getFieldType(),
                    getAccessByField("t", field.getField(), cls), isList, field.isMap()));
            if (field.isRequired()) {
                code.append(CodedConstant.getRequiredCheck(field.getOrder(), field.getField()));
            }
        }

        for (FieldInfo field : fields) {
            boolean isList = field.isList();
            // set write to byte
            code.append(CodedConstant.getMappedWriteCode(field, "output", field.getOrder(), field.getFieldType(),
                    isList, field.isMap()));
        }

        code.append("output.flush()").append(JAVA_LINE_BREAK);
        code.append("}").append(LINE_BREAK);

        return code.toString();
    }

    /**
     * generate <code>size</code> method source code
     * 
     * @return
     */
    private String getSizeMethodCode() {
        StringBuilder code = new StringBuilder();
        Set<Integer> orders = new HashSet<Integer>();
        // encode method
        code.append("public int size(").append(ClassHelper.getInternalName(cls.getCanonicalName()));
        code.append(" t) throws IOException {").append(LINE_BREAK);
        code.append("int size = 0").append(JAVA_LINE_BREAK);
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
            code.append(CodedConstant.getMappedTypeDefined(field.getOrder(), field.getFieldType(),
                    getAccessByField("t", field.getField(), cls), isList, field.isMap()));
            // compute size
            code.append("if (!CodedConstant.isNull(").append(getAccessByField("t", field.getField(), cls)).append("))")
                    .append("{").append(LINE_BREAK);
            code.append("size += ");
            code.append(CodedConstant.getMappedTypeSize(field, field.getOrder(), field.getFieldType(), isList,
                    field.isMap(), debug, outputPath));
            code.append("}").append(LINE_BREAK);
            if (field.isRequired()) {
                code.append(CodedConstant.getRequiredCheck(field.getOrder(), field.getField()));
            }
        }

        code.append("return size").append(JAVA_LINE_BREAK);
        code.append("}").append(LINE_BREAK);

        return code.toString();
    }

    /**
     * get field access code
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
            LOGGER.log(Level.FINE, e.getMessage(), e);
        }

        String type = field.getType().getCanonicalName();
        if ("[B".equals(type) || "[Ljava.lang.Byte;".equals(type) || "java.lang.Byte[]".equals(type)) {
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
     * @param target
     * @param field
     * @param cls
     * @param express
     * @param isList
     * @return
     */
    protected String getSetToField(String target, Field field, Class<?> cls, String express, boolean isList,
            boolean isMap, boolean packed) {
        StringBuilder ret = new StringBuilder();
        if (isList || isMap) {
            ret.append("if ((").append(getAccessByField(target, field, cls)).append(") == null) {").append(LINE_BREAK);
        }
        // if field of public modifier we can access directly
        if (Modifier.isPublic(field.getModifiers())) {
            if (isList) {
                // should initialize list
                ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(field.getName())
                        .append("= new ArrayList()").append(JAVA_LINE_BREAK).append("}").append(LINE_BREAK);
                if (express != null) {
                    if (packed) {
                        ret.append("while (input.getBytesUntilLimit() > 0) {").append(LINE_BREAK);
                    }
                    ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(field.getName()).append(".add(")
                            .append(express).append(")");
                    if (packed) {
                        ret.append(";}").append(LINE_BREAK);
                    }
                }
                return ret.toString();
            } else if (isMap) {
                ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(field.getName())
                        .append("= new HashMap()").append(JAVA_LINE_BREAK).append("}").append(LINE_BREAK);
                return ret.append(express).toString();
            }
            return target + ClassHelper.PACKAGE_SEPARATOR + field.getName() + "=" + express + LINE_BREAK;
        }
        String setter = "set" + CodedConstant.capitalize(field.getName());
        // check method exist
        try {
            cls.getMethod(setter, new Class<?>[] { field.getType() });
            if (isList) {
                ret.append("List __list = new ArrayList()").append(JAVA_LINE_BREAK);
                ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(setter).append("(__list)")
                        .append(JAVA_LINE_BREAK).append("}").append(LINE_BREAK);

                if (express != null) {
                    if (packed) {
                        ret.append("while (input.getBytesUntilLimit() > 0) {").append(LINE_BREAK);
                    }
                    ret.append("(").append(getAccessByField(target, field, cls)).append(").add(").append(express)
                            .append(")");
                    if (packed) {
                        ret.append(";}").append(LINE_BREAK);
                    }
                }
                return ret.toString();
            } else if (isMap) {
                ret.append("Map __map = new HashMap()").append(JAVA_LINE_BREAK);
                ret.append(target).append(ClassHelper.PACKAGE_SEPARATOR).append(setter).append("(__map)")
                        .append(JAVA_LINE_BREAK).append("}").append(LINE_BREAK);
                return ret + express;
            }
            return target + ClassHelper.PACKAGE_SEPARATOR + setter + "(" + express + ")\n";
        } catch (Exception e) {
            LOGGER.log(Level.FINE, e.getMessage(), e);
        }

        if (isList) {
            ret.append("List __list = new ArrayList()").append(JAVA_LINE_BREAK);
            ret.append("FieldUtils.setField(").append(target).append(", \"").append(field.getName())
                    .append("\", __list)").append(JAVA_LINE_BREAK).append("}").append(LINE_BREAK);
            if (express != null) {
                if (packed) {
                    ret.append("while (input.getBytesUntilLimit() > 0) {").append(LINE_BREAK);
                }
                ret.append("(").append(getAccessByField(target, field, cls)).append(").add(").append(express)
                        .append(")");
                if (packed) {
                    ret.append(";}").append(LINE_BREAK);
                }
            }
            return ret.toString();
        } else if (isMap) {
            ret.append("Map __map = new HashMap()").append(JAVA_LINE_BREAK);
            ret.append("FieldUtils.setField(").append(target).append(", \"").append(field.getName())
                    .append("\", __map)").append(JAVA_LINE_BREAK).append("}").append(LINE_BREAK);
            return ret + express;
        }

        // use reflection to get value
        String code = "";
        if (express != null) {
            code = "FieldUtils.setField(" + target + ", \"" + field.getName() + "\", " + express + ")" + LINE_BREAK;
        }
        return code;
    }

}
