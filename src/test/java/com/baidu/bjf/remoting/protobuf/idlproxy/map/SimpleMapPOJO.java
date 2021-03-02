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
package com.baidu.bjf.remoting.protobuf.idlproxy.map;

import java.util.Map;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Simple pojo use map for key/value using String, Integer, Long and Boolean
 *
 * @author xiemalin
 * @since 2.0.0
 */
public class SimpleMapPOJO {

    @Protobuf(required = true)
    public String name;
    
    @Protobuf(fieldType = FieldType.MAP)
    private Map<String, String> stringMap;
    
    @Protobuf(fieldType = FieldType.MAP)
    private Map<String, byte[]>  bytesMap;
    
    /**
     * get the stringMap
     * @return the stringMap
     */
    public Map<String, String> getStringMap() {
        return stringMap;
    }

    /**
     * set stringMap value to stringMap
     * @param stringMap the stringMap to set
     */
    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    /**
     * getter method for property bytesMap
     * @return the bytesMap
     */
    public Map<String, byte[]> getBytesMap() {
        return bytesMap;
    }

    /**
     * setter method for property bytesMap
     * @param bytesMap the bytesMap to set
     */
    public void setBytesMap(Map<String, byte[]> bytesMap) {
        this.bytesMap = bytesMap;
    }

    
    
}
