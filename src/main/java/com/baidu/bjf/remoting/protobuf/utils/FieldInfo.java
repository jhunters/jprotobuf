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
     * field type
     * @return field type
     */
    FieldType fieldType;

    /**
     * get the field
     * @return the field
     */
    public Field getField() {
        return field;
    }

    /**
     * set field value to field
     * @param field the field to set
     */
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * get the required
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * set required value to required
     * @param required the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * get the order
     * @return the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * set order value to order
     * @param order the order to set
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * get the fieldType
     * @return the fieldType
     */
    public FieldType getFieldType() {
        return fieldType;
    }

    /**
     * set fieldType value to fieldType
     * @param fieldType the fieldType to set
     */
    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * get the description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description value to description
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
    
}
