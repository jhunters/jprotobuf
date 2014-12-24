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

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.JDKCompilerHelper;
import com.baidu.bjf.remoting.protobuf.utils.ProtobufProxyUtils;

/**
 * Proxy tools for protobuf.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public final class ProtobufProxy {

    private static final Map<String, Codec> CACHED = new HashMap<String, Codec>();
    
    /**
     * To create a protobuf proxy class for target class.
     * @param <T>
     * @param cls
     * @return
     */
    public static <T> Codec<T> create(Class<T> cls) {
        return create(cls, false);
    }
    
    /**
     * To generate a protobuf proxy java source code for target class.
     * 
     * @param os to generate java source code
     * @param cls target class
     * @param charset charset type
     * @throws IOException in case of any io relative exception.
     */
    public static void dynamicCodeGenerate(OutputStream os, Class cls, Charset charset) throws IOException {
        if (cls == null) {
            throw new NullPointerException("Parameter cls is null");
        }
        if (os == null) {
            throw new NullPointerException("Parameter os is null");
        }
        if (charset == null) {
            charset = Charset.defaultCharset();
        }
        
        CodeGenerator cg = getCodeGenerator(cls);
        String code = cg.getCode();
        
        os.write(code.getBytes(charset));
    }

    private static CodeGenerator getCodeGenerator(Class cls) {
        // check if has default constructor
        try {
            cls.getConstructor(new Class<?>[0]);
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class must has default constructor method with no parameters.", e2);
        } catch (SecurityException e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }

        List<Field> fields = FieldUtils.findMatchedFields(cls, Protobuf.class);
        if (fields.isEmpty()) {
            throw new IllegalArgumentException("Invalid class [" + cls.getName() + "] no field use annotation @"
                    + Protobuf.class.getName());
        }

        List<FieldInfo> fieldInfos = ProtobufProxyUtils.processDefaultValue(fields);
        CodeGenerator cg = new CodeGenerator(fieldInfos, cls);
        
        return cg;
    }
    
    /**
     * To create a protobuf proxy class for target class.
     * 
     * @param <T>
     *            target object type to be proxied.
     * @param cls
     *            target object class
     * @param debug true will print generate java source code
     * @return proxy instance object.
     */
    public static <T> Codec<T> create(Class<T> cls, boolean debug) {
        if (cls == null) {
            throw new NullPointerException("Parameter cls is null");
        }

        String cn = CodeGenerator.getFullClassName(cls);
        Codec codec = CACHED.get(cn);
        if (codec != null) {
            return codec;
        }

        CodeGenerator cg = getCodeGenerator(cls);

        // try to load first
        String className = cg.getFullClassName();
        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e1) {
            // if class not found so should generate a new java source class.
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
        if (debug) {
            System.out.println("--------------------------generate code begin--------------------------");
            System.out.println(code);
            System.out.println("--------------------------generate code end--------------------------");
        }
        Class<?> newClass = JDKCompilerHelper.COMPILER.compile(code, cls.getClassLoader());
        try {
            Codec<T> newInstance = (Codec<T>) newClass.newInstance();
            if (!CACHED.containsKey(newClass.getName())) {
                CACHED.put(newClass.getName(), newInstance);
            }
            return newInstance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static void clearCache() {
        CACHED.clear();
    }

}
