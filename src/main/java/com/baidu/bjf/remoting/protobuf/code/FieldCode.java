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

import com.baidu.bjf.remoting.protobuf.utils.StringUtils;

/**
 * Java field code creator.
 *
 * @author xiemalin
 * @since 1.10.3
 */
public class FieldCode {

    /** The scope. */
    private String scope;
    
    /** The name. */
    private String name;
    
    /** The type. */
    private String type;
    
    /** The default value. */
    private String defaultValue;
    
    /**
     * Instantiates a new {@link FieldCode} instance.
     *
     * @param scope the scope
     * @param name the name
     * @param type the type
     * @param defaultValue the default value
     */
    public FieldCode(String scope, String name, String type, String defaultValue) {
        super();
        this.scope = scope;
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
    }


    /**
     * Gets the scope.
     *
     * @return the scope
     */
    public String getScope() {
        return scope;
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
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
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
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }


    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * Gets the default value.
     *
     * @return the default value
     */
    public String getDefaultValue() {
        return defaultValue;
    }


    /**
     * Sets the default value.
     *
     * @param defaultValue the new default value
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }


    /**
     * To code.
     *
     * @return the string
     */
    public String toCode() {
        String ret = "";
        if (StringUtils.isEmpty(scope)) {
            ret = "private ";
        } else {
            ret = scope + ClassCode.BLANK_STRING;
        }
        
        ret += type + ClassCode.BLANK_STRING + name;
        
        if (!StringUtils.isEmpty(defaultValue)) {
            ret += "=" + defaultValue;
        }
        
        return ret;
    }
}
