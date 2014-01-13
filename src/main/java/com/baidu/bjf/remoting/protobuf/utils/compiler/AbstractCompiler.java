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
package com.baidu.bjf.remoting.protobuf.utils.compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;

/**
 * Abstract compiler. (SPI, Prototype, ThreadSafe)
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public abstract class AbstractCompiler implements Compiler {

    /**
     * java package pattern string
     */
    private static final Pattern PACKAGE_PATTERN = Pattern
            .compile("package\\s+([$_a-zA-Z][$_a-zA-Z0-9\\.]*);");

    /**
     * java class name pattern string
     */
    private static final Pattern CLASS_PATTERN = Pattern
            .compile("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s+");

    /**
     * do compile action
     * @param code java source code
     * @param classLoader class loader
     * @return compiled class
     */
    public Class<?> compile(String code, ClassLoader classLoader) {
        String sourceCode = code.trim();
        Matcher matcher = PACKAGE_PATTERN.matcher(sourceCode);
        String pkg;
        if (matcher.find()) {
            pkg = matcher.group(1);
        } else {
            pkg = "";
        }
        matcher = CLASS_PATTERN.matcher(sourceCode);
        String cls;
        if (matcher.find()) {
            cls = matcher.group(1);
        } else {
            throw new IllegalArgumentException("No such class name in " + sourceCode);
        }
        String className = pkg != null && pkg.length() > 0 ? pkg + "." + cls
                : cls;
        try {
            return Class.forName(className, true,
                    ClassHelper.getCallerClassLoader(getClass()));
        } catch (ClassNotFoundException e) {
            if (!sourceCode.endsWith("}")) {
                throw new IllegalStateException(
                        "The java code not endsWith \"}\", code: \n" + sourceCode
                                + "\n");
            }
            try {
                return doCompile(className, sourceCode);
            } catch (RuntimeException t) {
                throw t;
            } catch (Throwable t) {
                throw new IllegalStateException(
                        "Failed to compile class, cause: " + t.getMessage()
                                + ", class: " + className + ", code: \n" + sourceCode
                                + "\n, stack: " + ClassUtils.toString(t));
            }
        }
    }

    /**
     * Compile method to be implemented.
     * 
     * @param name class name
     * @param source java source code
     * @return compiled class
     * @throws Throwable compile failed exception
     */
    protected abstract Class<?> doCompile(String name, String source)
        throws Throwable;

}
