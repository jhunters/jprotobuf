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
package com.baidu.bjf.remoting.protobuf.v3.complexmap;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.enumeration.EnumAttrPOJO;


/**
 * The Class EnumMapPOJOTest.
 *
 * @author xiemalin
 */
public class EnumMapPOJOTest {

    
    /**
     * Test enum map.
     */
    @Test
    public void testEnumMap() {
        EnumMapPOJO pojo = new EnumMapPOJO();
        
        pojo.keyEnumMap = new HashMap<EnumAttrPOJO, String>();
        pojo.valEnumMap =  new HashMap<String, EnumAttrPOJO>();
        pojo.enumMap = new HashMap<EnumAttrPOJO, EnumAttrPOJO>();
        
        pojo.keyEnumMap.put(EnumAttrPOJO.INT, "matthew");
        pojo.valEnumMap.put("matthew", EnumAttrPOJO.INT);
        pojo.enumMap.put(EnumAttrPOJO.INT, EnumAttrPOJO.INT);
        
        Codec<EnumMapPOJO> codec = ProtobufProxy.create(EnumMapPOJO.class);
        try {
            byte[] bb = codec.encode(pojo);
            EnumMapPOJO pojo2 = codec.decode(bb);
            
            Assert.assertEquals(pojo2.keyEnumMap, pojo.keyEnumMap);
            Assert.assertEquals(pojo2.valEnumMap, pojo.valEnumMap);
            Assert.assertEquals(pojo2.enumMap, pojo.enumMap);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
        
        
    }
}
