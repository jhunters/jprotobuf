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

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;

/**
 * Codec interface include encode and decode support.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public interface Codec<T> {

    /**
     * Do byte encode action
     * 
     * @param t generic target object
     * @return encoded byte array
     * @throws IOException if target object is invalid
     */
    byte[] encode(T t) throws IOException;

    /**
     * Do decode action from byte array
     * 
     * @param bytes encoded byte array
     * @return parse byte array to target object
     * @throws IOException if byte array is invalid
     */
    T decode(byte[] bytes) throws IOException;
    
    /**
     * Calculate size of target object
     * 
     * @param t target object
     * @return size of 
     * @throws IOException if target object is invalid
     */
    int size(T t) throws IOException;
    
    /**
     * Write target object to byte array
     * 
     * @param t target object
     * @param out target {@link CodedOutputStream} 
     * @throws IOException if target object is invalid
     */
    void writeTo(T t, CodedOutputStream out) throws IOException;
    
    /**
     * Read object from target byte array input stream
     * 
     * @param intput target input stream object
     * @return unserialize object
     * @throws IOException if byte array is invalid
     */
    T readFrom(CodedInputStream intput) throws IOException;
    
}
