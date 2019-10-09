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
package com.baidu.jprotobuf.plugin;

import java.io.OutputStream;

/**
 * Abstract compiler. (SPI, Prototype, ThreadSafe)
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public abstract class AbstractCompiler implements Compiler {
    
    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.utils.compiler.Compiler#compile(java.lang.String, java.lang.String,
     * java.lang.ClassLoader, java.io.OutputStream, long)
     */
    public Class<?> compile(String className, String code, ClassLoader classLoader, OutputStream os, long lastModify) {
        code = code.trim();
        try {
            return Class.forName(className, true, classLoader);
        } catch (ClassNotFoundException e) {
            if (!code.endsWith("}")) {
                throw new IllegalStateException("The java code not endsWith \"}\", code: \n" + code + "\n");
            }
            try {
                return doCompile(className, code, os);
            } catch (RuntimeException t) {
                throw t;
            } catch (Throwable t) {
                throw new IllegalStateException("Failed to compile class, cause: " + t.getMessage() + ", class: "
                        + className + ", code: \n" + code + "\n, stack: " + ClassUtils.toString(t));
            }
        }
    }

    /**
     * Do compile action.
     *
     * @param name the name
     * @param source the java source code to compile
     * @param os the {@link OutputStream} instance
     * @return the class
     * @throws Throwable the throwable
     */
    protected abstract Class<?> doCompile(String name, String source, OutputStream os) throws Throwable;

}
