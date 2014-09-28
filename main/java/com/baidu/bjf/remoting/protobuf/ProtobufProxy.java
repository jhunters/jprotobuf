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
import java.util.List;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.compiler.Compiler;
import com.baidu.bjf.remoting.protobuf.utils.compiler.JdkCompiler;

/**
 * Proxy tools for protobuf.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public final class ProtobufProxy {

    /**
     * To create a protobuf proxy class for target class.
     * 
     * @param <T> target object type to be proxied.
     * @param cls target object class 
     * @return proxy instance object.
     */
    public static <T> Codec<T> create(Class<T> cls) {
        if (cls == null) {
            throw new NullPointerException("Parameter cls is null");
        }
        List<Field> fields = FieldUtils.findMatchedFields(cls, Protobuf.class);
        if (fields.isEmpty()) {
            throw new IllegalArgumentException("Invalid class ["
                    + cls.getName() + "] no field use annotation @"
                    + Protobuf.class.getName());
        }

        CodeGenerator cg = new CodeGenerator(fields, cls);
        
        //try to load first
        String className = cg.getFullClassName();
        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e1) {
            c = null;
        }
        
        if (c != null) {
            try {
                Codec<T> newInstance = (Codec<T>) c.newInstance();
                return newInstance;
            } catch (InstantiationException e) {
                throw new RuntimeException(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        String code = cg.getCode();
        //System.out.println(code);
        Compiler compiler = new JdkCompiler();
        Class<?> newClass = compiler.compile(code, cg.getClass()
                .getClassLoader());

        try {
            Codec<T> newInstance = (Codec<T>) newClass.newInstance();
            return newInstance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
