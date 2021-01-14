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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.annotation.Ignore;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.ProtobufProxyUtils;

/**
 * Utility class for generate protobuf IDL content from @{@link Protobuf}.
 *
 * @author xiemalin
 * @since 1.0.1
 */
public class ProtobufIDLGenerator {
    
    /** Logger for this class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProtobufIDLGenerator.class.getName());

    /** The Constant JPROTOBUF_CLASS_NAME_SUFFIX. */
    public static final String JPROTOBUF_CLASS_NAME_SUFFIX = "$$ByJProtobuf";

    /**
     * get IDL content from class.
     * 
     * @param cls target class to parse for IDL message.
     * @param cachedTypes if type already in set will not generate IDL. if a new type found will add to set
     * @param cachedEnumTypes if enum already in set will not generate IDL. if a new enum found will add to set
     * @param ignoreJava set true to ignore generate package and class name
     * @return protobuf IDL content in string
     * @see Protobuf
     */
    public static String getIDL(final Class<?> cls, final Set<Class<?>> cachedTypes,
            final Set<Class<?>> cachedEnumTypes, boolean ignoreJava) {
        
        Ignore ignore = cls.getAnnotation(Ignore.class);
        if (ignore != null) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("class '{}' marked as @Ignore annotation, create IDL ignored.", cls.getName());
            }
            return null;
        }
        
        Set<Class<?>> types = cachedTypes;
        if (types == null) {
            types = new HashSet<Class<?>>();
        }

        Set<Class<?>> enumTypes = cachedEnumTypes;
        if (enumTypes == null) {
            enumTypes = new HashSet<Class<?>>();
        }

        if (types.contains(cls)) {
            return null;
        }

        StringBuilder code = new StringBuilder();

        if (!ignoreJava) {
            // define package
            code.append("package ").append(cls.getPackage().getName()).append(";\n");
            code.append("option java_outer_classname = \"").append(cls.getSimpleName())
                    .append(JPROTOBUF_CLASS_NAME_SUFFIX + "\";\n");
        }

        // define outer name class

        types.add(cls);

        generateIDL(code, cls, types, enumTypes);

        return code.toString();
    }

    /**
     * get IDL content from class.
     * 
     * @param cls target class to parse for IDL message.
     * @param cachedTypes if type already in set will not generate IDL. if a new type found will add to set
     * @param cachedEnumTypes if enum already in set will not generate IDL. if a new enum found will add to set
     * @return protobuf IDL content in string
     * @see Protobuf
     */
    public static String getIDL(final Class<?> cls, final Set<Class<?>> cachedTypes,
            final Set<Class<?>> cachedEnumTypes) {

        return getIDL(cls, cachedTypes, cachedEnumTypes, false);

    }

    /**
     * get IDL content from class.
     * 
     * @param cls target protobuf class to parse
     * @return protobuf IDL content in string
     */
    public static String getIDL(final Class<?> cls) {
        return getIDL(cls, null, null);
    }

    /**
     * Generate idl.
     *
     * @param code the code
     * @param cls the cls
     * @param cachedTypes the cached types
     * @param cachedEnumTypes the cached enum types
     * @return sub message class list
     */
    private static void generateIDL(StringBuilder code, Class<?> cls, Set<Class<?>> cachedTypes,
            Set<Class<?>> cachedEnumTypes) {

        Set<Class<?>> subTypes = new HashSet<Class<?>>();
        Set<Class<Enum>> enumTypes = new HashSet<Class<Enum>>();
        Annotation annotation = cls.getAnnotation(ProtobufClass.class);
        if (annotation != null && ((ProtobufClass)annotation).description() != null) {
            code.append("//").append(((ProtobufClass)annotation).description()).append("\n");
        }
        
        code.append("message ").append(cls.getSimpleName()).append(" {  \n");

        List<FieldInfo> fieldInfos = ProtobufProxyUtils.fetchFieldInfos(cls, false);
        for (FieldInfo field : fieldInfos) {
            if (field.hasDescription()) {
                code.append("// ").append(field.getDescription()).append("\n");
            }
            if (field.getFieldType() == FieldType.OBJECT || field.getFieldType() == FieldType.ENUM) {
                if (field.isList()) {
                    Type type = field.getField().getGenericType();
                    if (type instanceof ParameterizedType) {
                        ParameterizedType ptype = (ParameterizedType) type;

                        Type[] actualTypeArguments = ptype.getActualTypeArguments();
                        if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                            Type targetType = actualTypeArguments[0];
                            if (targetType instanceof Class) {
                                Class c = (Class) targetType;

                                String fieldTypeName;
                                if (ProtobufProxyUtils.isScalarType(c)) {

                                    FieldType fieldType = ProtobufProxyUtils.TYPE_MAPPING.get(c);
                                    fieldTypeName = fieldType.getType();

                                } else {
                                    if (field.getFieldType() == FieldType.ENUM) {
                                        if (!cachedEnumTypes.contains(c)) {
                                            cachedEnumTypes.add(c);
                                            enumTypes.add(c);
                                        }
                                    } else {

                                        if (!cachedTypes.contains(c)) {
                                            cachedTypes.add(c);
                                            subTypes.add(c);
                                        }
                                    }

                                    fieldTypeName = c.getSimpleName();
                                }

                                code.append("repeated ").append(fieldTypeName).append(" ")
                                        .append(field.getField().getName()).append("=").append(field.getOrder())
                                        .append(";\n");
                            }
                        }
                    }
                } else {
                    Class c = field.getField().getType();
                    code.append(getFieldRequired(field.isRequired())).append(" ").append(c.getSimpleName()).append(" ")
                            .append(field.getField().getName()).append("=").append(field.getOrder()).append(";\n");
                    if (field.getFieldType() == FieldType.ENUM) {
                        if (!cachedEnumTypes.contains(c)) {
                            cachedEnumTypes.add(c);
                            enumTypes.add(c);
                        }
                    } else {

                        if (!cachedTypes.contains(c)) {
                            cachedTypes.add(c);
                            subTypes.add(c);
                        }
                    }
                }
            } else {
                String type = field.getFieldType().getType().toLowerCase();

                if (field.getFieldType() == FieldType.ENUM) {
                    // if enum type
                    Class c = field.getField().getType();
                    if (Enum.class.isAssignableFrom(c)) {
                        type = c.getSimpleName();
                        if (!cachedEnumTypes.contains(c)) {
                            cachedEnumTypes.add(c);
                            enumTypes.add(c);
                        }
                    }
                }

                String required = getFieldRequired(field.isRequired());

                if (field.isList()) {
                    required = "repeated";
                }

                code.append(required).append(" ").append(type).append(" ").append(field.getField().getName())
                        .append("=").append(field.getOrder()).append(";\n");
            }

        }

        code.append("}\n");

        for (Class<Enum> subType : enumTypes) {
            generateEnumIDL(code, subType);
        }

        if (subTypes.isEmpty()) {
            return;
        }

        for (Class<?> subType : subTypes) {
            generateIDL(code, subType, cachedTypes, cachedEnumTypes);
        }

    }

    /**
     * Generate enum idl.
     *
     * @param code the code
     * @param cls the cls
     */
    private static void generateEnumIDL(StringBuilder code, Class<Enum> cls) {
        code.append("enum ").append(cls.getSimpleName()).append(" {  \n");

        Field[] fields = cls.getFields();
        for (Field field : fields) {

            String name = field.getName();
            code.append(name).append("=");
            try {
                Enum value = Enum.valueOf(cls, name);
                if (value instanceof EnumReadable) {
                    code.append(((EnumReadable) value).value());
                } else {
                    code.append(value.ordinal());
                }
                code.append(";\n");
            } catch (Exception e) {
                continue;
            }
        }

        code.append("}\n ");
    }

    /**
     * Gets the field required.
     *
     * @param required the required
     * @return the field required
     */
    private static String getFieldRequired(boolean required) {
        if (required) {
            return "required";
        }

        return "optional";
    }
}
