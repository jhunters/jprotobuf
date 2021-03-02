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
package com.baidu.bjf.remoting.protobuf.complexList;

import java.util.List;
import java.util.Map;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class ListWithNull.
 *
 * @author xiemalin
 * @since 1.10.9
 */
public class ListWithNull {
    
    /** The list. */
    @Protobuf(fieldType = FieldType.STRING)
    public List<String> list;
    
    
    /** The list 2. */
    @Protobuf(fieldType = FieldType.STRING)
    private List<String> list2;
    
    /** The list 2. */
    @Protobuf(fieldType = FieldType.STRING)
    private List<String> list3;
    
    /** The list. */
    @Protobuf(fieldType = FieldType.MAP)
    public Map<String, String> map;
    
    
    /** The list 2. */
    @Protobuf(fieldType = FieldType.MAP)
    private Map<String, String> map2;
    
    /** The list 2. */
    @Protobuf(fieldType = FieldType.MAP)
    private Map<String, String> map3;
    
    /**
     * Sets the list 2.
     *
     * @param list2 the new list 2
     */
    public void setList2(List<String> list2) {
        this.list2 = list2;
    }
    
    /**
     * Gets the list 2.
     *
     * @return the list 2
     */
    public List<String> getList2() {
        return list2;
    }
    
    
    /**
     * Sets the map 2.
     *
     * @param map2 the map 2
     */
    public void setMap2(Map<String, String> map2) {
        this.map2 = map2;
    }
    
    /**
     * Gets the map 2.
     *
     * @return the map 2
     */
    public Map<String, String> getMap2() {
        return map2;
    }
    
}
