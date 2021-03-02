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
package com.baidu.bjf.remoting.protobuf.subclasses;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;


/**
 * The Class SubClassPOJOTest.
 *
 * @author xiemalin
 * @since 2.3.1
 */
public class SubClassPOJOTest {

    
    /**
     * Test sub class POJO.
     */
    @Test
    public void testSubClassPOJO() {
        
        SubOne subOne = new SubOne();
        subOne.setSubOneName("stringOneName");
        subOne.setName("hello");
        subOne.setAge(100);
        
        ParentClassPOJO subClassPOJO = new ParentClassPOJO();
        subClassPOJO.add(subOne);
        
        
        Codec<ParentClassPOJO> codec = ProtobufProxy.create(ParentClassPOJO.class, false);
        
        Codec<SubClassPOJO> codec2 = ProtobufProxy.create(SubClassPOJO.class, false);
        try {
            byte[] encode = codec.encode(subClassPOJO);
            
            SubClassPOJO decode = codec2.decode(encode);
            
            Assert.assertEquals(subClassPOJO.parents, decode.parents);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
