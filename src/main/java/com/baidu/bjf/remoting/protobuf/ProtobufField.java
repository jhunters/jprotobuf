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

    /** The annotation. */
    private Protobuf annotation;
    
    /** The name. */
    private String name;
    
    /** The type. */
    private Class<?> type;
    
    /** The declared class. */
    private Class<?> declaredClass;
    
    /** The generic type. */
    private Type genericType;
    
    /**
     * Instantiates a new protobuf field.
     *
     * @param field the field
     */
    public ProtobufField(Field field) {
        annotation = field.getAnnotation(Protobuf.class);
        name = field.getName();
        type = field.getType();
        declaredClass = field.getDeclaringClass();
        genericType = field.getGenericType();
    }

    /**
     * Gets the annotation.
     *
     * @return the annotation
     */
    public Protobuf getAnnotation() {
        return annotation;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public Class<?> getType() {
        return type;
    }

    /**
     * Gets the declared class.
     *
     * @return the declared class
     */
    public Class<?> getDeclaredClass() {
        return declaredClass;
    }

    /**
     * Gets the generic type.
     *
     * @return the generic type
     */
    public Type getGenericType() {
        return genericType;
    }
    
    
}
