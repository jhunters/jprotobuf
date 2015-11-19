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
import java.lang.reflect.Type;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * A description class for protobuf field message.
 *
 * @author xiemalin
 * @since 1.0.2
 */
public class ProtobufField {

    private Protobuf annotation;
    private String name;
    private Class<?> type;
    
    private Class<?> declaredClass;
    private Type genericType;
    
    public ProtobufField(Field field) {
        annotation = field.getAnnotation(Protobuf.class);
        name = field.getName();
        type = field.getType();
        declaredClass = field.getDeclaringClass();
        genericType = field.getGenericType();
    }

    /**
     * get the annotation
     * @return the annotation
     */
    public Protobuf getAnnotation() {
        return annotation;
    }

    /**
     * get the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * get the type
     * @return the type
     */
    public Class<?> getType() {
        return type;
    }

    /**
     * get the declaredClass
     * @return the declaredClass
     */
    public Class<?> getDeclaredClass() {
        return declaredClass;
    }

    /**
     * get the genericType
     * @return the genericType
     */
    public Type getGenericType() {
        return genericType;
    }
    
    
}
