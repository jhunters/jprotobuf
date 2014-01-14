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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * code generator utility class
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public class CodeGenerator {
    /**
     * method invoke action mark
     */
    private static final String METHOD_INVOKE_MARK = ".";

    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(CodeGenerator.class);

    /**
     * all related field list
     */
    private List<Field> fields;
    /**
     * wrapped class
     */
    private Class<?> cls;

    /**
     * Constructor
     * 
     * @param fields
     *            protobuf mapped fields
     * @param cls
     *            protobuf mapped class
     */
    public CodeGenerator(List<Field> fields, Class<?> cls) {
        super();
        this.fields = fields;
        this.cls = cls;
    }

    /**
     * get full java class code.
     * 
     * @return full java class code
     */
    public String getCode() {
        StringBuilder code = new StringBuilder();

        String className = cls.getSimpleName() + "$$BJFProtoBufClass";

        code.append("package " + cls.getPackage().getName() + ";\n");
        code.append("import com.google.protobuf.*;\n");
        code.append("import java.io.IOException;\n");
        code.append("import com.baidu.bjf.remoting.protobuf.utils.*;\n");
        code.append("import java.lang.reflect.*;\n");
        code.append("import com.baidu.bjf.remoting.protobuf.*;\n");
        code.append("import java.util.*;\n");

        code.append("public class " + className
                + " implements com.baidu.bjf.remoting.protobuf.Codec");
        code.append("<").append(cls.getName()).append("> {\n");

        code.append(getEncodeMethodCode());
        code.append(getDecodeMethodCode());
        code.append("}");

        return code.toString();
    }

    /**
     * get decode method source code
     * @return decode method source code
     */
    private String getDecodeMethodCode() {
        StringBuilder code = new StringBuilder();

        code.append("public ").append(cls.getSimpleName())
                .append(" decode(byte[] bb) throws IOException {\n");
        code.append(cls.getName()).append(" ret = new ")
                .append(cls.getName()).append("();");
        code.append("CodedInputStream input = CodedInputStream.newInstance(bb, 0, bb.length);\n");
        code.append("try {\n");
        code.append("boolean done = false;\n");
        code.append("while (!done) {\n");
        code.append("int tag = input.readTag();\n");
        code.append("if (tag == 0) { break;}\n");

        for (Field field : fields) {
            boolean isList = isListType(field);
            
            Protobuf protobuf = field.getAnnotation(Protobuf.class);
            code.append("if (tag == CodedConstant.makeTag(").append(
                    protobuf.order());
            code.append(",WireFormat.")
                    .append(protobuf.fieldType().getWireFormat())
                    .append(")) {\n");
            String t = protobuf.fieldType().getType();
            t = CodedConstant.capitalize(t);
            code.append(
                    getSetToField("ret", field, cls, "input.read" + t + "()", isList));
            if (protobuf.fieldType() == FieldType.BYTES) {
                code.append(".toByteArray()");
            }
                    
            code.append(";\n");
            code.append("continue;\n");
            code.append("}");

        }

        code.append("input.skipField(tag);\n");
        code.append("}");
        code.append("} catch (com.google.protobuf.InvalidProtocolBufferException e) {");
        code.append("throw e;");
        code.append("} catch (java.io.IOException e) {");
        code.append("throw e;");
        code.append("}");

        for (Field field : fields) {
            Protobuf protobuf = field.getAnnotation(Protobuf.class);
            if (protobuf.required()) {
                code.append(CodedConstant.getRetRequiredCheck(
                        getAccessByField("ret", field, cls), field));
            }

        }

        code.append("return ret;\n");

        code.append("}\n");

        return code.toString();
    }
    
    /**
     * check if field type is a list
     * @param field field to check
     * @return true if is a list
     */
    private boolean isListType(Field field) {
        Class<?> cls = field.getType();
        if (List.class.isAssignableFrom(cls)) {
            //if check is list ignore check
            return true;
        }
        return false;
    }

    /**
     * check field type is illegal with field class
     * 
     * @param type field type
     * @param field field instance
     */
    private void checkType(FieldType type, Field field) {
        Class<?> cls = field.getType();
        
        String javaType = type.getJavaType();
        if ("Integer".equals(javaType)) {
            if ("int".equals(cls.getSimpleName()) || 
                    "Integer".equals(cls.getSigners())) {
                return;
            }
            throw new IllegalArgumentException(getErroMessage(type, field));
        }
        if (!javaType.equalsIgnoreCase(cls.getSimpleName())) {
            throw new IllegalArgumentException(getErroMessage(type, field));
        }
    }

    /**
     * get error message
     *  
     * @param type field type
     * @param field field instance
     * @return error message
     */
    private String getErroMessage(FieldType type, Field field) {
        return "Type mismatch. @Protobuf required type '" + type.getJavaType()
                + "' but field type is '" + field.getType().getSimpleName()
                + "'";
    }

    /**
     * get encode method source code
     * 
     * @return encode method source code
     */
    private String getEncodeMethodCode() {
        StringBuilder code = new StringBuilder();
        Set<Integer> orders = new HashSet<Integer>();
        // encode method
        code.append("public byte[] encode(").append(cls.getName())
                .append(" t) throws IOException {\n");
        code.append("int size = 0;");
        for (Field field : fields) {
            Protobuf protobuf = field.getAnnotation(Protobuf.class);
            
            boolean isList = isListType(field);
            
            // check type
            if (!isList) {
                checkType(protobuf.fieldType(), field);
            }

            if (orders.contains(protobuf.order())) {
                throw new IllegalArgumentException("Field order '"
                        + protobuf.order() + "' on field" + field.getName()
                        + " already exsit.");
            }
            // define field
            code.append(CodedConstant.getMappedTypeDefined(protobuf.order(),
                    protobuf.fieldType(), getAccessByField("t", field, cls), isList));
            // compute size
            code.append("if (!CodedConstant.isNull(")
                    .append(getAccessByField("t", field, cls)).append("))\n");
            code.append("{\nsize+=");
            code.append(CodedConstant.getMappedTypeSize(protobuf.order(),
                    protobuf.fieldType(), isList));
            code.append("}\n");
            if (protobuf.required()) {
                code.append(CodedConstant.getRequiredCheck(protobuf.order(),
                        field));
            }
        }

        code.append("final byte[] result = new byte[size];\n");
        code.append("final CodedOutputStream output = CodedOutputStream.newInstance(result);\n");
        for (Field field : fields) {
            boolean isList = isListType(field);
            Protobuf protobuf = field.getAnnotation(Protobuf.class);
            // set write to byte
            code.append(CodedConstant.getMappedWriteCode("output", protobuf.order(),
                    protobuf.fieldType(), isList));
        }

        code.append("return result;\n");
        code.append("}\n");

        return code.toString();
    }

    /**
     * get field access code
     * 
     * @param target
     *            target instance name
     * @param field
     *            java field instance
     * @param cls
     *            mapped class
     * @return full field access java code
     */
    protected String getAccessByField(String target, Field field, Class<?> cls) {
        if (field.getModifiers() == Modifier.PUBLIC) {
            return target + METHOD_INVOKE_MARK + field.getName();
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
            return target + METHOD_INVOKE_MARK + getter + "()";
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }
        // use reflection to get value
        String code = "(" + field.getType().getName() + ") ";
        code += "FieldUtils.getField(" + target + ", \"" + field.getName()
                + "\")";

        return code;
    }

    /**
     * get set to field method source code
     * 
     * @param target target object name
     * @param field field object
     * @param cls target class
     * @param express java express
     * @param isList true if field is type of {@link List}
     * @return source code
     */
    protected String getSetToField(String target, Field field, Class<?> cls,
            String express, boolean isList) {
        String ret = "";
        if (isList) {
            ret = "if ((" + getAccessByField(target, field, cls) + ") == null) {\n";
        }
        if (field.getModifiers() == Modifier.PUBLIC) {
            if (isList) {
                ret += target + METHOD_INVOKE_MARK + field.getName() + "= new ArrayList();\n}";  
                ret +=  target + METHOD_INVOKE_MARK + field.getName() + ".add(" + express + ")";
                return ret;
            }
            return target + METHOD_INVOKE_MARK + field.getName() + "=" + express + "\n";
        }
        String setter = "set" + CodedConstant.capitalize(field.getName());
        // check method exist
        try {
            cls.getMethod(setter, new Class<?>[]{field.getType()});
            if (isList) {
                ret += "List __list = new ArrayList();\n";
                ret += target + METHOD_INVOKE_MARK + setter + "(__list);\n}";
                
                ret += "(" + getAccessByField(target, field, cls) + ").add(" + express + ")";
                return ret;
            }
            
            return target + METHOD_INVOKE_MARK + setter + "(" + express + ")\n";
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }

        if (isList) {
            ret += "List __list = new ArrayList();\n";
            ret += "FieldUtils.setField(" + target + ", \"" + 
                    field.getName() + "\", __list);\n}";
            
            ret += "(" + getAccessByField(target, field, cls) + ").add(" + express + ")";
            return ret;
        }
        
        // use reflection to get value
        String code = "FieldUtils.setField(" + target + ", \"" + 
            field.getName() + "\", " + express + ")\n";
        return code;
    }

}
