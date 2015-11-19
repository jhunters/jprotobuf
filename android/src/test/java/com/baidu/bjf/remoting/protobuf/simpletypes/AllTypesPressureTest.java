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
package com.baidu.bjf.remoting.protobuf.simpletypes;

import java.io.IOException;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName;
import com.google.protobuf.ByteString;

/**
 * Performance test for encode and decode
 *
 * @author xiemalin
 * @since 1.0.8
 */
public class AllTypesPressureTest {
    int times = 5000;

    @Test
    public void testDynamiceEncode() throws IOException {
        long time = System.currentTimeMillis();
        Codec dojoClassProxy = ProtobufProxy.create(AllTypesDojoClass.class);
        //AllTypesDojoClass$$BJFProtoBufClass dojoClassProxy = new AllTypesDojoClass$$BJFProtoBufClass();
        AllTypesDojoClass c = new AllTypesDojoClass();
        c.boolF = false;
        c.bytesF = new byte[] {1,2};
        c.doubleF = 101D;
        c.fixed32F = 1;
        c.fixed64F = 2L;
        c.floatF = 102F;
        c.int32F = 3;
        c.int64F = 4L;
        c.sfixed32F = 5;
        c.sfixed64F = 6L;
        c.sint32F = 7;
        c.sint64F = 8L;
        c.stringF = "hello";
        c.uint32F = 9;
        c.uint64F = 10L;
        
        long averageEncode = 0;
        
        for (int i = 0; i < times; i++) {
            byte[] bb = dojoClassProxy.encode(c);
            
        }
        averageEncode = System.currentTimeMillis() - time;
        System.out.println("dynamic encode average time:" + (averageEncode / times));
    }
    
    @Test
    public void testDynamiceDecode() throws IOException {
        long time = System.currentTimeMillis();
        InterClassName icn = InterClassName.newBuilder()
        .setBoolF(true)
        .setBytesF(ByteString.copyFrom(new byte[] {1, 2}))
        .setDoubleF(202D)
        .setFixed32F(1)
        .setFixed64F(2L)
        .setFloatF(303F)
        .setInt32F(4)
        .setInt64F(5L)
        .setSfixed32F(6)
        .setSfixed64F(7L)
        .setSint32F(8)
        .setSint64F(9L)
        .setStringF("world")
        .setUint32F(10)
        .setUint64F(11L)
        .build();
    
        long averageEncode = 0;
        byte[] bb = icn.toByteArray();
        
        Codec dojoClassProxy = ProtobufProxy.create(AllTypesDojoClassWithDefault.class);
        for (int i = 0; i < times; i++) {
            dojoClassProxy.decode(bb);
        }
        averageEncode = System.currentTimeMillis() - time;
        System.out.println("dynamic decode average time:" + (averageEncode / times));
    }
    
    @Test
    public void testCommonEncode() throws IOException {
        long time = System.currentTimeMillis();
        InterClassName icn = InterClassName.newBuilder()
        .setBoolF(true)
        .setBytesF(ByteString.copyFrom(new byte[] {1, 2}))
        .setDoubleF(202D)
        .setFixed32F(1)
        .setFixed64F(2L)
        .setFloatF(303F)
        .setInt32F(4)
        .setInt64F(5L)
        .setSfixed32F(6)
        .setSfixed64F(7L)
        .setSint32F(8)
        .setSint64F(9L)
        .setStringF("world")
        .setUint32F(10)
        .setUint64F(11L)
        .build();
    
        long averageEncode = 0;
        
        for (int i = 0; i < times; i++) {
            byte[] bb = icn.toByteArray();
        }
        averageEncode = System.currentTimeMillis() - time;
        
        System.out.println("common encode average time:" + (averageEncode / times));
    }
    
    @Test
    public void testCommonDecode() throws IOException {
        long time = System.currentTimeMillis();
        InterClassName icn = InterClassName.newBuilder()
        .setBoolF(true)
        .setBytesF(ByteString.copyFrom(new byte[] {1, 2}))
        .setDoubleF(202D)
        .setFixed32F(1)
        .setFixed64F(2L)
        .setFloatF(303F)
        .setInt32F(4)
        .setInt64F(5L)
        .setSfixed32F(6)
        .setSfixed64F(7L)
        .setSint32F(8)
        .setSint64F(9L)
        .setStringF("world")
        .setUint32F(10)
        .setUint64F(11L)
        .build();
    
        long averageEncode = 0;
        byte[] bb = icn.toByteArray();
        
        for (int i = 0; i < times; i++) {
            InterClassName.parseFrom(bb);
        }
        averageEncode = System.currentTimeMillis() - time;
        
        System.out.println("common decode average time:" + (averageEncode / times));
    }
}
