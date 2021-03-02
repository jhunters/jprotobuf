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
package com.baidu.bjf.remoting.protobuf.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.baidu.bjf.remoting.protobuf.utils.StringUtils;

/**
 * Java method code creator.
 *
 * @author xiemalin
 * @since 1.10.3
 */
public class MethodCode {
    
    /** The scope. */
    private String scope;
    
    /** The name. */
    private String name;
    
    /** The return type. */
    private String returnType;
    
    /** The exceptions. */
    private List<String> exceptions = new ArrayList<String>();
    
    /** The code. */
    private List<String> code = new ArrayList<String>();
    
    /** The parameters. */
    private LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();

    /**
     * To code.
     *
     * @return the string
     */
    public String toCode() {
        StringBuilder source = new StringBuilder();
        source.append(StringUtils.trimToEmpty(scope)).append(ClassCode.BLANK_STRING);
        if (StringUtils.isEmpty(returnType)) {
            source.append("void ");
        } else {
            source.append(returnType).append(ClassCode.BLANK_STRING);
        }
        
        source.append(name).append("(");
        
        if (!parameters.isEmpty()) {
            Iterator<Entry<String, String>> iter = parameters.entrySet().iterator();
            while (iter.hasNext()) {
                Entry<String, String> entry = iter.next();
                source.append(entry.getKey()).append(ClassCode.BLANK_STRING).append(entry.getValue());
                if (iter.hasNext()) {
                    source.append(ClassCode.SENTENCE_COMMA);
                }
            }
        }
        
        source.append(") ");
        
        if (!exceptions.isEmpty()) {
            source.append("throws ");
            Iterator<String> iter = exceptions.iterator();
            while (iter.hasNext()) {
                String exception = iter.next();
                source.append(exception);
                if (iter.hasNext()) {
                    source.append(ClassCode.SENTENCE_COMMA);
                }
            }
        }
        source.append("{").append(ClassCode.LINE_BREAK);
        
        for (String c : code) {
            source.append(ClassCode.CODE_FORMAT).append(c);
        }
        
        source.append("}").append(ClassCode.LINE_BREAK);
        
        return source.toString();
    }
    
    
    
    /**
     * Sets the scope.
     *
     * @param scope the new scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }



    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }



    /**
     * Sets the return type.
     *
     * @param returnType the new return type
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }



    /**
     * Adds the parameter.
     *
     * @param type the type
     * @param name the name
     */
    public void addParameter(String type, String name) {
        parameters.put(type, name);
    }
    
    /**
     * Adds the exception.
     *
     * @param exception the exception
     */
    public void addException(String exception) {
        exceptions.add(exception);
    }
    
    /**
     * append a new line code to method without need to append ";" to the end.
     *
     * @param line the line
     */
    public void appendLineCode0(String line) {
        code.add(line + ClassCode.LINE_BREAK);
    }
    
    /**
     * append a new line code to method with end with ";" .
     *
     * @param line the line
     */
    public void appendLineCode1(String line) {
        code.add(line + ClassCode.JAVA_LINE_BREAK);
    }
}
