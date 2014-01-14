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
import java.util.ArrayList;
import java.util.List;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
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
        List<Field> fields = findMatchedFields(cls);
        if (fields.isEmpty()) {
            throw new IllegalArgumentException("Invalid class ["
                    + cls.getName() + "] no field use annotation @"
                    + Protobuf.class.getName());
        }

        CodeGenerator cg = new CodeGenerator(fields, cls);

        String code = cg.getCode();

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

    /**
     * find matched field.
     * 
     * @param targetClass target class
     * @return found field list
     */
    private static List<Field> findMatchedFields(Class targetClass) {

        Class cls = targetClass;
        List<Field> ret = new ArrayList<Field>();
        // Keep backing up the inheritance hierarchy.
        do {
            // Copy each field declared on this class unless it's static or
            // file.
            Field[] fields = cls.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Protobuf protobuf = fields[i].getAnnotation(Protobuf.class);
                if (protobuf != null) {
                    ret.add(fields[i]);
                }
            }
            cls = targetClass.getSuperclass();
        } while (cls != null && cls != Object.class);

        return ret;
    }

}
