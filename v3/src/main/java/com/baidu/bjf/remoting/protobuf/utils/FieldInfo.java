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
package com.baidu.bjf.remoting.protobuf.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.baidu.bjf.remoting.protobuf.FieldType;

/**
 * combined class of {@link Field} and @Protobuf annotation value.
 * 
 * @author xiemalin
 * @since 1.0.7
 */
public class FieldInfo {

    private Field field;

    boolean required;

    /**
     * field description
     */
    private String description;

    /**
     * Set field order. It starts at 1;
     * 
     * @return field order.
     */
    int order;

    /**
     * the type used for List or Map key generic type
     */
    private Class<?> genericKeyType;

    /**
     * the type used for Map value generic type
     */
    private Class<?> genericeValueType;

    /**
     * field type
     * 
     * @return field type
     */
    FieldType fieldType;

    private boolean isList;
    private boolean isMap;

    /**
     * To check if type of {@link Field} is assignable from {@link List}
     * 
     * @param field
     * @return true if is assignable from {@link List}
     */
    private void checkListMapType(Field field) {
        Class<?> cls = field.getType();
        boolean needCheckGenericType = false;
        if (List.class.isAssignableFrom(cls)) {
            // if check is list ignore check
            isList = true;
            needCheckGenericType = true;
        }
        if (Map.class.isAssignableFrom(cls)) {
            // if check is list ignore check
            isMap = true;
            needCheckGenericType = true;
        }

        if (!needCheckGenericType) {
            return;
        }

        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType) type;

            Type[] actualTypeArguments = ptype.getActualTypeArguments();

            if (actualTypeArguments != null) {

                int length = actualTypeArguments.length;
                // validate
                if (isList) {
                    if (length != 1) {
                        throw new RuntimeException(
                                "List must use generic definiation like List<String>, please check  field name '"
                                        + field.getName() + " at class " + field.getDeclaringClass().getName());
                    }
                } else if (isMap) {
                    if (length != 2) {
                        throw new RuntimeException(
                                "Map must use generic definiation like Map<String, String>, please check  field name '"
                                        + field.getName() + " at class " + field.getDeclaringClass().getName());
                    }
                }

                Type targetType = actualTypeArguments[0];
                if (targetType instanceof Class) {
                    genericKeyType = (Class) targetType;
                }

                if (actualTypeArguments.length > 1) {
                    targetType = actualTypeArguments[1];
                    if (targetType instanceof Class) {
                        genericeValueType = (Class) targetType;
                    }
                }

            }
        }

    }

    /**
     * @param field
     */
    public FieldInfo(Field field) {
        super();
        this.field = field;
        checkListMapType(field);
    }

    /**
     * get the isList
     * 
     * @return the isList
     */
    public boolean isList() {
        return isList;
    }

    /**
     * set isList value to isList
     * 
     * @param isList the isList to set
     */
    public void setList(boolean isList) {
        this.isList = isList;
    }

    /**
     * get the isMap
     * 
     * @return the isMap
     */
    public boolean isMap() {
        return isMap;
    }

    /**
     * set isMap value to isMap
     * 
     * @param isMap the isMap to set
     */
    public void setMap(boolean isMap) {
        this.isMap = isMap;
    }

    /**
     * get the field
     * 
     * @return the field
     */
    public Field getField() {
        return field;
    }

    /**
     * get the required
     * 
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * set required value to required
     * 
     * @param required the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * get the order
     * 
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * set order value to order
     * 
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * get the fieldType
     * 
     * @return the fieldType
     */
    public FieldType getFieldType() {
        return fieldType;
    }

    /**
     * set fieldType value to fieldType
     * 
     * @param fieldType the fieldType to set
     */
    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * get the description
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description value to description
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean hasDescription() {
        if (description == null || description.trim().length() == 0) {
            return false;
        }
        return true;
    }

    /**
     * get the genericKeyType
     * 
     * @return the genericKeyType
     */
    public Class<?> getGenericKeyType() {
        return genericKeyType;
    }

    /**
     * set genericKeyType value to genericKeyType
     * 
     * @param genericKeyType the genericKeyType to set
     */
    public void setGenericKeyType(Class<?> genericKeyType) {
        this.genericKeyType = genericKeyType;
    }

    /**
     * get the genericeValueType
     * 
     * @return the genericeValueType
     */
    public Class<?> getGenericeValueType() {
        return genericeValueType;
    }

    /**
     * set genericeValueType value to genericeValueType
     * 
     * @param genericeValueType the genericeValueType to set
     */
    public void setGenericeValueType(Class<?> genericeValueType) {
        this.genericeValueType = genericeValueType;
    }

}
