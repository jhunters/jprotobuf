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
package com.baidu.bjf.remoting.protobuf.ignore;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

/**
 * The Class IngoredAnnotationTests.
 *
 * @author xiemalin
 * @since 1.11.6
 */
public class IgnoredAnnotationTests {

    
    /**
     * Test ignore POJO class.
     */
    @Test
    public void testProxybufProxyOnIgnoredPOJOClass() {
        Codec<IgnoredPOJOClass> codec = ProtobufProxy.create(IgnoredPOJOClass.class);
        Assert.assertNull(codec);
    }
    
    /**
     * Test ignore POJO class 2.
     */
    @Test
    public void testProxybufProxyOnIgnoredPOJOClass2() {
        Codec<IgnoredPOJOClass2> codec = ProtobufProxy.create(IgnoredPOJOClass2.class);
        Assert.assertNull(codec);
    }
    
    /**
     * Test ignore POJO class 3.
     */
    @Test
    public void testProxybufProxyOnIgnoredPOJOClass3() {
        Codec<IgnoredPOJOClass3> codec = ProtobufProxy.create(IgnoredPOJOClass3.class);
        
        IgnoredPOJOClass3 pojo = new IgnoredPOJOClass3();
        pojo.name = "abc";
        
        IgnoredPOJOClass3 pojo2 = new IgnoredPOJOClass3();
        pojo2.name = "abc";
        pojo2.address = "hello";
        
        try {
            byte[] encode = codec.encode(pojo2);
            byte[] encode2 = codec.encode(pojo);
            Assert.assertArrayEquals(encode, encode2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * Test protobuf IDL generator on ingored POJO class.
     */
    @Test
    public void testProtobufIDLGeneratorOnIngoredPOJOClass() {
        String idl = ProtobufIDLGenerator.getIDL(IgnoredPOJOClass.class);
        Assert.assertNull(idl);
    }
    
    /**
     * Test protobuf IDL generator on ingored POJO class 2.
     */
    @Test
    public void testProtobufIDLGeneratorOnIngoredPOJOClass2() {
        String idl = ProtobufIDLGenerator.getIDL(IgnoredPOJOClass2.class);
        Assert.assertNull(idl);
    }
}
