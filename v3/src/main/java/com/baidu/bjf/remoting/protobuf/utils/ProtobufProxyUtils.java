/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.bjf.remoting.protobuf.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.annotation.Packed;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

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
    private static final Logger LOGGER = Logger.getLogger(ProtobufProxy.class.getName());

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
     * to process default value of <code>@Protobuf</code> value on field.
     *
     * @param fields all field to process
     * @param ignoreNoAnnotation the ignore no annotation
     * @return list of fields
     */
    public static List<FieldInfo> processDefaultValue(List<Field> fields, boolean ignoreNoAnnotation) {
        if (fields == null) {
            return null;
        }

        List<FieldInfo> ret = new ArrayList<FieldInfo>(fields.size());

        int maxOrder = 0;
        List<FieldInfo> unorderFields = new ArrayList<FieldInfo>(fields.size());
        Set<Integer> orders = new HashSet<Integer>();
        for (Field field : fields) {
            Protobuf protobuf = field.getAnnotation(Protobuf.class);
            if (protobuf == null && !ignoreNoAnnotation) {
                throw new RuntimeException("Field '" + field.getName() + "' has no @Protobuf annotation");
            }

            // check field is support for protocol buffer
            // any array except byte array is not support
            String simpleName = field.getType().getName();
            if (simpleName.startsWith("[")) {
                if ((!simpleName.equals(byte[].class.getName())) && (!simpleName.equals(Byte[].class.getName()))) {
                    throw new RuntimeException("Array type of field '" + field.getName() + "' on class '"
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

                FieldType fieldType = TYPE_MAPPING.get(fieldTypeClass);
                if (fieldType == null) {
                    // check if type is enum
                    if (Enum.class.isAssignableFrom(fieldTypeClass)) {
                        fieldType = FieldType.ENUM;
                    } else {
                        fieldType = FieldType.OBJECT;
                    }
                }
                fieldInfo.setFieldType(fieldType);
            } else {
                fieldInfo.setFieldType(annFieldType);
            }

            if (order > 0) {
                if (orders.contains(order)) {
                    throw new RuntimeException(
                            "order id '" + order + "' from field name '" + field.getName() + "'  is duplicate");
                }
                orders.add(order);
                fieldInfo.setOrder(order);
                if (order > maxOrder) {
                    maxOrder = order;
                }
            } else {
                unorderFields.add(fieldInfo);
            }

            if (fieldInfo.isList() && fieldInfo.getFieldType().isPrimitive()) {
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

            LOGGER.warning("Field '" + fieldInfo.getField().getName() + "' from "
                    + fieldInfo.getField().getDeclaringClass().getName()
                    + " with @Protobuf annotation but not set order or order is 0," + " It will set order value to "
                    + maxOrder);
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
