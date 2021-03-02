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
package com.baidu.bjf.remoting.protobuf.utils.compiler;

import java.io.OutputStream;

/**
 * Compiler.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public interface Compiler {

    /**
     * do compile java source.
     * 
     * @param code Java source code
     * @param classLoader current classloader
     * @param os target output compiled byte code
     * @param timestamp time stamp of class file
     * @return Compiled class
     */
    Class<?> compile(String className, String code, ClassLoader classLoader, OutputStream os, long timestamp);

    
    /**
     * do load java byte code by class name
     * 
     * @param className full class name
     * @return byte code as byte array 
     */
    byte[] loadBytes(String className);
}
