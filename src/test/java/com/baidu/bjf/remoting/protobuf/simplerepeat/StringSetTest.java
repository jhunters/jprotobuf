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
package com.baidu.bjf.remoting.protobuf.simplerepeat;

import java.io.IOException;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.complex.PersonPOJO;

/**
 * The Class StringSetTest.
 *
 * @author xiemalin
 * @since 3.4.0
 */
public class StringSetTest {

    
    /**
     * Test string set POJO.
     */
    @Test
    public void testStringSetPOJO() {
        Codec<StringSetDojoClass> codec = ProtobufProxy.create(StringSetDojoClass.class, false);
        
        StringSetDojoClass stringSet = new StringSetDojoClass();
        stringSet.stringSet = new HashSet<String>();
        
        stringSet.stringSet.add("hello");
        stringSet.stringSet.add("world");
        stringSet.stringSet.add("xiemalin");
        
        
        try {
            byte[] bs = codec.encode(stringSet);
            StringSetDojoClass stringSetDojoClass = codec.decode(bs);
            Assert.assertEquals(3, stringSetDojoClass.stringSet.size());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Test string set POJO 2.
     */
    @Test
    public void testStringSetPOJO2() {
        Codec<StringSetDojoClass> codec = ProtobufProxy.create(StringSetDojoClass.class, false);
        
        StringSetDojoClass stringSet = new StringSetDojoClass();
        stringSet.personSet = new HashSet<PersonPOJO>();
        stringSet.stringSet = new HashSet<String>();
        
        PersonPOJO  pojo = new PersonPOJO();
        pojo.name = "hello";
        pojo.id = 100;
        
        stringSet.personSet.add(pojo);
        
        stringSet.stringSet.add("hello");
        stringSet.stringSet.add("world");
        stringSet.stringSet.add("xiemalin");
        
        
        try {
            byte[] bs = codec.encode(stringSet);
            StringSetDojoClass stringSetDojoClass = codec.decode(bs);
            Assert.assertEquals(3, stringSetDojoClass.stringSet.size());
            
            Assert.assertEquals(1, stringSetDojoClass.personSet.size());
            Assert.assertEquals("hello", stringSetDojoClass.personSet.iterator().next().name);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
