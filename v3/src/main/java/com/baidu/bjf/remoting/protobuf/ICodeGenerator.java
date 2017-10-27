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

import java.io.File;
import java.util.Set;

/**
 * The Interface ICodeGenerator.
 * @author xiemalin
 * @since 2.1.3
 */
public interface ICodeGenerator {

    /**
     * Sets the output path. if set should write generated source code to target path
     *
     * @param outputPath the new output path
     */
    void setOutputPath(File outputPath);

    /**
     * Checks if is debug.
     *
     * @return true, if is debug
     */
    boolean isDebug();

    /**
     * Sets the debug. if enabled print out source code after generated
     * @see #getCode()
     *
     * @param debug the new debug
     */
    void setDebug(boolean debug);

    /**
     * Gets the class name.
     *
     * @return the class name
     */
    String getClassName();

    /**
     * Gets the package.
     *
     * @return the package
     */
    String getPackage();

    /**
     * Gets the full class name.
     *
     * @return the full class name
     */
    String getFullClassName();

    /**
     * Gets the code.
     *
     * @return the code
     */
    String getCode();

    /**
     * Gets the relative proxy classes.
     *
     * @return the relative proxy classes
     */
    Set<Class<?>> getRelativeProxyClasses();

}