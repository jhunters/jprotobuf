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
package com.baidu.bjf.remoting.protobuf.utils;

import com.baidu.bjf.remoting.protobuf.utils.compiler.Compiler;
import com.baidu.bjf.remoting.protobuf.utils.compiler.JdkCompiler;

/**
 * static access for {@link JdkCompiler}.
 *
 * @author xiemalin
 * @since 1.0.2
 */
public class JDKCompilerHelper {

    /** singleton instance for {@link JdkCompiler}. */
    public static Compiler COMPILER = new JdkCompiler(JdkCompiler.class.getClassLoader());

    /**
     * Gets the jdk compiler.
     *
     * @return the jdk compiler
     */
    public static Compiler getJdkCompiler() {
        return COMPILER;
    }

    /**
     * Sets the compiler.
     *
     * @param compiler the new compiler
     */
    public static void setCompiler(Compiler compiler) {
        COMPILER = compiler;
    }

    /**
     * Gets the jdk compiler.
     *
     * @param cl the cl
     * @return the jdk compiler
     */
    public static Compiler getJdkCompiler(ClassLoader cl) {
        return  new JdkCompiler(cl);
    }
}
