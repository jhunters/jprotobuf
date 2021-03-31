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

import java.io.IOException;
import java.util.Arrays;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.utils.compiler.ClassUtils;

/**
 * <pre>
 *  * `Any` contains an arbitrary serialized protocol buffer message along with a
 * URL that describes the type of the serialized message.
 * Protobuf library provides support to pack/unpack Any values in the form
 * of utility functions or additional generated methods of the Any type.
 * 
 *     Foo foo = ...;
 *     Any any = Any.pack(foo);
 *     ...
 *     if (any.is(Foo.class)) {
 *       foo = any.unpack(Foo.class);
 *     }
 *     
 * </pre>
 * @since 2.4.3
 */
public class Any {
    
    /** The Constant PB_URL_PREFIX. */
    private static final String PB_URL_PREFIX = "type.googleapis.com/";

    /** The codec class. */
    @Protobuf(order = 1)
    private String codecClass;
    
    
    /** The byte array. */
    @Protobuf(order = 2)
    private byte[] byteArray;
    
    
    /**
     * Gets the codec class.
     *
     * @return the codec class
     */
    public String getCodecClass() {
        return codecClass;
    }
    
    /**
     * Sets the codec class.
     *
     * @param codecClass the new codec class
     */
    public void setCodecClass(String codecClass) {
        this.codecClass = codecClass;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Any [codecClass=" + codecClass + ", byteArray=" + Arrays.toString(byteArray) + "]";
    }

    /**
     * Gets the as class.
     *
     * @return the as class
     */
    protected Class<?> getAsClass() {
        Class<?> cls = ClassUtils.forName(codecClass);
        return cls;
    }
    
    /**
     * Gets the byte array.
     *
     * @return the byte array
     */
    public byte[] getByteArray() {
        return byteArray;
    }
    
    /**
     * Sets the byte array.
     *
     * @param byteArray the new byte array
     */
    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }
    
    /**
     * Pack the target object to {@link Any} object
     *
     * @param o the o
     * @param mappingClsName the mapping class name for origin protobuf 
     * @return the any
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Any pack(Object o, String mappingClsName) throws IOException {
        if (o == null) {
            throw new NullPointerException("Param 'o' is null.");
        }
        
        Class cls = o.getClass();
        Codec codec = ProtobufProxy.create(cls);
        byte[] bs = codec.encode(o);
        
        Any any = new Any();
        if (mappingClsName != null) {
            any.codecClass = PB_URL_PREFIX + mappingClsName;
        } else {
            any.codecClass = PB_URL_PREFIX + cls.getName();
        }
        any.byteArray = bs;
        
        return any;
    }
    
    /**
     * Pack the target object to {@link Any} object
     *
     * @param o the o
     * @return the any
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Any pack(Object o) throws IOException {
        return pack(o, null);
    }
    
    
    /**
     * Checks if is.
     *
     * @param <T> the generic type
     * @param cls the cls
     * @return true, if successful
     */
    public <T> boolean is(Class<T> cls) {
        if (cls == null) {
            return false;
        }
        return (PB_URL_PREFIX + cls.getName()).equals(codecClass);
    }

    /**
     * Unpack.
     *
     * @param <T> the generic type
     * @param cls the cls
     * @return the t
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public <T> T unpack(Class<T> cls) throws IOException {
        if (cls== null) {
            throw new NullPointerException("Param 'cls' is null.");
        }
        
        if (byteArray == null) {
            throw new NullPointerException("field 'byteArray' is null.");
        }
        
        Codec<T> codec = ProtobufProxy.create(cls);
        T result = codec.decode(byteArray);
        
        return result;
    }
    
}
