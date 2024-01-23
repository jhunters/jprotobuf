/*
 * Copyright (c) Baidu Inc. All rights reserved.
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.bjf.remoting.protobuf.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.annotation.EnableZigZap;
import com.baidu.bjf.remoting.protobuf.annotation.Ignore;
import com.baidu.bjf.remoting.protobuf.annotation.Packed;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
 
/**
 * 
 * Utility class for probuf proxy.
 * 
 * @author xiemalin
 * @since 1.0.7
 */
public class ProtobufProxyUtils {

    /** The Constant TYPE_MAPPING. */
    public static final Map<Class<?>, FieldType> TYPE_MAPPING;

    /** Logger for this class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProtobufProxy.class.getName());
    
    /** The Constant FIELD_FILTER_STARTS. */
    public static final List<String> FIELD_FILTER_STARTS = new ArrayList<>();

    static {
        TYPE_MAPPING = new HashMap<Class<?>, FieldType>();

        TYPE_MAPPING.put(int.class, FieldType.INT32);
        TYPE_MAPPING.put(Integer.class, FieldType.INT32);
        TYPE_MAPPING.put(short.class, FieldType.INT32);
        TYPE_MAPPING.put(Short.class, FieldType.INT32);
        TYPE_MAPPING.put(Byte.class, FieldType.INT32);
        TYPE_MAPPING.put(byte.class, FieldType.INT32);
        TYPE_MAPPING.put(long.class, FieldType.INT64);
        TYPE_MAPPING.put(Long.class, FieldType.INT64);
        TYPE_MAPPING.put(String.class, FieldType.STRING);
        TYPE_MAPPING.put(byte[].class, FieldType.BYTES);
        TYPE_MAPPING.put(Byte[].class, FieldType.BYTES);
        TYPE_MAPPING.put(Float.class, FieldType.FLOAT);
        TYPE_MAPPING.put(float.class, FieldType.FLOAT);
        TYPE_MAPPING.put(double.class, FieldType.DOUBLE);
        TYPE_MAPPING.put(Double.class, FieldType.DOUBLE);
        TYPE_MAPPING.put(Boolean.class, FieldType.BOOL);
        TYPE_MAPPING.put(boolean.class, FieldType.BOOL);
        TYPE_MAPPING.put(Date.class, FieldType.DATE);
        TYPE_MAPPING.put(BigDecimal.class, FieldType.BIGDECIMAL);
        TYPE_MAPPING.put(BigInteger.class, FieldType.BIGINTEGER);
        
        FIELD_FILTER_STARTS.add("$jacoco");
    }

    /**
     * Test if target type is from protocol buffer default type.
     *
     * @param cls target type
     * @return true if is from protocol buffer default type
     */
    public static boolean isScalarType(Class<?> cls) {
        return TYPE_MAPPING.containsKey(cls);
    }

    /**
     * Fetch field infos.
     *
     * @return the list
     */
    public static List<FieldInfo> fetchFieldInfos(Class cls, boolean ignoreNoAnnotation) {
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
            if (fields.isEmpty() && ignoreNoAnnotation) {
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
     * to process default value of <code>@Protobuf</code> value on field.
     *
     * @param fields all field to process
     * @param ignoreNoAnnotation the ignore no annotation
     * @param isZipZap the is zip zap
     * @return list of fields
     */
    public static List<FieldInfo> processDefaultValue(List<Field> fields, boolean ignoreNoAnnotation,
            boolean isZipZap) {
        if (fields == null) {
            return null;
        }

        List<FieldInfo> ret = new ArrayList<FieldInfo>(fields.size());
        
        String[] filterFields = null;
        if (FIELD_FILTER_STARTS != null) {
            filterFields = FIELD_FILTER_STARTS.toArray(new String[FIELD_FILTER_STARTS.size()]);
        }

        int maxOrder = 0;
        List<FieldInfo> unorderFields = new ArrayList<FieldInfo>(fields.size());
        Set<Integer> orders = new HashSet<Integer>();
        for (Field field : fields) {
            Ignore ignore = field.getAnnotation(Ignore.class);
            if (ignore != null) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Field name '{}' marked @Ignore annotation will be ignored.", field.getName());
                }
                continue;
            }
            //判断 transient
            if (Modifier.isTransient(field.getModifiers())) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Field name '{}' marked transient will be ignored.", field.getName());
                }
                continue;
            }
            
            String fName = field.getName();
            if (filterFields != null) {
                boolean filtered = StringUtils.startsWithAny(fName, filterFields);
                if (filtered) {
                    LOGGER.warn("Field '" + fName + "' is filtered due to matched filter list. " + filterFields);
                    continue;
                }
            }
            

            Protobuf protobuf = field.getAnnotation(Protobuf.class);
            if (protobuf == null && !ignoreNoAnnotation) {
                throw new RuntimeException("Field '" + fName + "' has no @Protobuf annotation");
            }

            // check field is support for protocol buffer
            // any array except byte array is not support
            String simpleName = field.getType().getName();
            if (simpleName.startsWith("[")) {
                if ((!simpleName.equals(byte[].class.getName())) && (!simpleName.equals(Byte[].class.getName()))) {
                    throw new RuntimeException("Array type of field '" + fName + "' on class '"
                            + field.getDeclaringClass().getName() + "' is not support,  please use List instead.");
                }
            }

            FieldInfo fieldInfo = new FieldInfo(field);
            FieldType annFieldType = FieldType.DEFAULT;
            int order = -1;
            if (protobuf != null) {
                fieldInfo.setRequired(protobuf.required());
                fieldInfo.setDescription(protobuf.description());
                annFieldType = protobuf.fieldType();
                order = protobuf.order();
            } else {
                fieldInfo.setRequired(false);
            }

            // process type
            if (annFieldType == FieldType.DEFAULT) {

                Class fieldTypeClass = field.getType();

                // if list
                boolean isList = fieldInfo.isList();
                if (isList) {
                    fieldTypeClass = fieldInfo.getGenericKeyType();
                }
                if (fieldTypeClass == null) {
                    fieldTypeClass = Object.class;
                }

                FieldType fieldType = TYPE_MAPPING.get(fieldTypeClass);
                if (fieldType == null) {
                    // check if type is enum
                    if (Enum.class.isAssignableFrom(fieldTypeClass)) {
                        fieldType = FieldType.ENUM;
                    } else if (fieldInfo.isMap()) {
                        fieldType = FieldType.MAP;
                    } else {
                        fieldType = FieldType.OBJECT;
                    }
                }
                
                // check if enable zagzip
                if (isZipZap) {
                    if (fieldType == FieldType.INT32) {
                        fieldType = FieldType.SINT32; // to convert to sint32 to enable zagzip
                    } else if (fieldType == FieldType.INT64) {
                        fieldType = FieldType.SINT64; // to convert to sint64 to enable zagzip
                    }
                }
                
                
                
                fieldInfo.setFieldType(fieldType);
            } else {
                fieldInfo.setFieldType(annFieldType);
            }

            if (order > 0) {
                if (orders.contains(order)) {
                    throw new RuntimeException(
                            "order id '" + order + "' from field name '" + fName + "'  is duplicate");
                }
                orders.add(order);
                fieldInfo.setOrder(order);
                if (order > maxOrder) {
                    maxOrder = order;
                }
            } else {
                unorderFields.add(fieldInfo);
            }

            if (fieldInfo.isList() && (fieldInfo.getFieldType().isPrimitive() || fieldInfo.getFieldType().isEnum())) {
                Packed packed = field.getAnnotation(Packed.class);
                if (packed == null) {
                    fieldInfo.setPacked(true);
                } else {
                    fieldInfo.setPacked(packed.value());
                }
            }
            

            ret.add(fieldInfo);
        }

        if (unorderFields.isEmpty()) {
            return ret;
        }

        for (FieldInfo fieldInfo : unorderFields) {
            maxOrder++;
            fieldInfo.setOrder(maxOrder);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(
                        "Field '{}' from {} with @Protobuf annotation but not set order or order is 0,"
                                + " It will set order value to {}",
                        fieldInfo.getField().getName(), fieldInfo.getField().getDeclaringClass().getName(), maxOrder);
            }
        }

        return ret;
    }

    /**
     * Checks if is object type.
     *
     * @param cls the cls
     * @return true, if is object type
     */
    public static boolean isObjectType(Class<?> cls) {
        FieldType fieldType = TYPE_MAPPING.get(cls);
        if (fieldType != null) {
            return false;
        }

        return true;
    }

    /**
     * Process protobuf type.
     *
     * @param cls the cls
     * @return the string
     */
    public static String processProtobufType(Class<?> cls) {
        FieldType fieldType = TYPE_MAPPING.get(cls);
        if (fieldType != null) {
            return fieldType.getType();
        }

        return cls.getSimpleName();
    }

}
