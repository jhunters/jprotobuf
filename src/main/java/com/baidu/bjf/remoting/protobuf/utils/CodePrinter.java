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
package com.baidu.bjf.remoting.protobuf.utils;

/**
 * Utility class to print code
 *
 * @author xiemalin
 * @since 1.5.7
 */
public class CodePrinter {

    
    /**
     * print code to console
     * 
     * @param code code in string
     * @param desc code description
     */
    public static void printCode(String code, String desc) {
        System.out.println("--------------------------" + desc + " begin--------------------------");
        System.out.println(code);
        System.out.println("--------------------------" + desc + " end--------------------------");
    }
    
}
