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
package com.baidu.bjf.remoting.protobuf.math;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;


/**
 * The Class BigLongTest. 
 * @author xiemalin
 */
public class BigLongTest {
    
    /**
     * Test encode decode.
     */
    @Test
    public void testEncodeDecode() {
        Codec<BigLongPOJO> codec = ProtobufProxy.create(BigLongPOJO.class);
        BigLongPOJO t = new BigLongPOJO();
         t.value = new BigDecimal(10322.134d);
         t.value2 =new BigInteger("100000000000000000001111111111111111");
        //t.date = new Date();
        try {
            byte[] bs = codec.encode(t);
            BigLongPOJO bigLongPOJO = codec.decode(bs);
            Assert.assertEquals(t, bigLongPOJO);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Test default encode decode.
     */
    @Test
    public void testDefaultEncodeDecode() {
        Codec<BigLongPOJOWithDefault> codec = ProtobufProxy.create(BigLongPOJOWithDefault.class);
        BigLongPOJOWithDefault t = new BigLongPOJOWithDefault();
         t.value = new BigDecimal(10322.134d);
         t.value2 =new BigInteger("100000000000000000001111111111111111");
        //t.date = new Date();
        try {
            byte[] bs = codec.encode(t);
            BigLongPOJOWithDefault bigLongPOJO = codec.decode(bs);
            Assert.assertEquals(t, bigLongPOJO);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Test big number object IDL generator.
     */
    @Test
    public void testBigNumberObjectIDLGenerator() {
        String idl = ProtobufIDLGenerator.getIDL(BigLongPOJO.class);
        Assert.assertTrue(idl.contains("string value="));
    }
    
    /**
     * Test big number object IDL generator.
     */
    @Test
    public void testBigNumberObjectIDLDefaultWayGenerator() {
        String idl = ProtobufIDLGenerator.getIDL(BigLongPOJOWithDefault.class);
        Assert.assertTrue(idl.contains("string value="));
    }
}
