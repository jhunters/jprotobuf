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
package com.baidu.bjf.remoting.protobuf.simpletypes;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef;
import com.google.protobuf.ByteString;


/**
 * @author xiemalin
 *
 */
public class AllTypesTest {
	
	@Test
	public void  testRequiredMutliTypeEncode() throws IOException {
		Codec<AllTypesPojoClass> dojoClassProxy = ProtobufProxy.create(AllTypesPojoClass.class);
	    //AllTypesDojoClass$$BJFProtoBufClass dojoClassProxy = new AllTypesDojoClass$$BJFProtoBufClass();
		AllTypesPojoClass c = new AllTypesPojoClass();
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
		c.typeDefEnum = TypeDefEnum.DECIMAL;
		
		byte[] bb = dojoClassProxy.encode(c);
		
		InterClassName icn = InterClassName.parseFrom(bb);
		Assert.assertEquals(c.doubleF.doubleValue(), icn.getDoubleF(), 0f);
		byte[] bbb = icn.getBytesF().toByteArray();
		Assert.assertEquals(2, bbb.length);
		Assert.assertEquals(1, bbb[0]);
		Assert.assertEquals(2, bbb[1]);
		Assert.assertEquals(101D, icn.getDoubleF(), 0d);
		Assert.assertEquals(1, icn.getFixed32F());
		Assert.assertEquals(2L, icn.getFixed64F());
		Assert.assertEquals(102F, icn.getFloatF(), 0f);
		Assert.assertEquals(3, icn.getInt32F());
		Assert.assertEquals(4L, icn.getInt64F());
	    Assert.assertEquals(5, icn.getSfixed32F());
	    Assert.assertEquals(6L, icn.getSfixed64F());
        Assert.assertEquals(7, icn.getSint32F());
        Assert.assertEquals(8L, icn.getSint64F());
        Assert.assertEquals("hello", icn.getStringF());
        Assert.assertEquals(false, icn.getBoolF());
        Assert.assertEquals(9, icn.getUint32F());
        Assert.assertEquals(10L, icn.getUint64F());
        Assert.assertEquals(TypeDefEnum.DECIMAL.value(), icn.getEnumT().getNumber());
	}
	
    @Test
    public void testRequiredMutliTypeEncode2() throws IOException {
        Codec<AllTypesWithProtobufClassDojoClass> dojoClassProxy =
                ProtobufProxy.create(AllTypesWithProtobufClassDojoClass.class, false);
        // AllTypesDojoClass$$BJFProtoBufClass dojoClassProxy = new AllTypesDojoClass$$BJFProtoBufClass();
        AllTypesWithProtobufClassDojoClass c = new AllTypesWithProtobufClassDojoClass();
        c.boolF = false;
        c.bytesF = new byte[] { 1, 2 }; 
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
        c.typeDefEnum = TypeDefEnum.DECIMAL;
        c.strings = new ArrayList<String>();
        c.strings.add("hello");
        c.strings.add("matthew");
        c.intergers = new ArrayList<Integer>();
        c.intergers.add(1);
        c.intergers.add(2);

        c.allTypesDojoClasses = new ArrayList<AllTypesPojoClass>();
        c.allTypesDojoClasses.add(new AllTypesPojoClass());

        byte[] bb = dojoClassProxy.encode(c);

        AllTypesWithProtobufClassDojoClass icn = dojoClassProxy.decode(bb);

        Assert.assertEquals(c.doubleF.doubleValue(), icn.getDoubleF(), 0d);
        byte[] bbb = icn.getBytesF();
        Assert.assertEquals(2, bbb.length);
        Assert.assertEquals(1, bbb[0]);
        Assert.assertEquals(2, bbb[1]);
        Assert.assertEquals(101D, icn.getDoubleF(), 0d);
        Assert.assertEquals(1, icn.getFixed32F());
        Assert.assertEquals(2L, icn.getFixed64F());
        Assert.assertEquals(102F, icn.getFloatF(), 0f);
        Assert.assertEquals(3, icn.getInt32F());
        Assert.assertEquals(4L, icn.getInt64F());
        Assert.assertEquals(5, icn.getSfixed32F());
        Assert.assertEquals(6L, icn.getSfixed64F());
        Assert.assertEquals(7, icn.getSint32F());
        Assert.assertEquals(8L, icn.getSint64F());
        Assert.assertEquals("hello", icn.getStringF());
        Assert.assertEquals(false, icn.getBoolF());
        Assert.assertEquals(9, icn.getUint32F());
        Assert.assertEquals(10L, icn.getUint64F());
        Assert.assertEquals(TypeDefEnum.DECIMAL.value(), icn.getTypeDefEnum().value());

        Assert.assertEquals(2, icn.strings.size());
        Assert.assertEquals(2, icn.intergers.size());
        Assert.assertEquals(1, icn.allTypesDojoClasses.size());
    }
	
	@Test
	public void  testRequiredMutliTypeDecode() throws IOException {
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
		    .setEnumT(TypeDef.ID)
		    .build();
		
		byte[] bb = icn.toByteArray();
		
		Codec<AllTypesPojoClass> dojoClassProxy = ProtobufProxy.create(AllTypesPojoClass.class);
		AllTypesPojoClass decode = dojoClassProxy.decode(bb);
		
        Assert.assertEquals(2, decode.bytesF.length);
        Assert.assertEquals(1, decode.bytesF[0]);
        Assert.assertEquals(2, decode.bytesF[1]);
        Assert.assertEquals(202D, decode.doubleF.doubleValue(), 0d);
        Assert.assertEquals(1, decode.fixed32F.intValue());
        Assert.assertEquals(2L, decode.fixed64F.longValue());
        Assert.assertEquals(303F, decode.floatF.floatValue(), 0f);
        Assert.assertEquals(4, decode.int32F.intValue());
        Assert.assertEquals(5L, decode.int64F.intValue());
        Assert.assertEquals(6, decode.sfixed32F.longValue());
        Assert.assertEquals(7L, decode.sfixed64F.longValue());
        Assert.assertEquals(8, decode.sint32F.intValue());
        Assert.assertEquals(9L, decode.sint64F.longValue());
        Assert.assertEquals("world", decode.stringF);
        Assert.assertEquals(true, decode.boolF.booleanValue());
        Assert.assertEquals(10, decode.uint32F.intValue());
        Assert.assertEquals(11L, decode.uint64F.longValue());
        Assert.assertEquals(TypeDefEnum.ID.value(), decode.typeDefEnum.value());
        
        Codec<AllTypesPrimitivePojoClass> pojoClassProxy = ProtobufProxy.create(AllTypesPrimitivePojoClass.class);
        AllTypesPrimitivePojoClass decode2 = pojoClassProxy.decode(bb);
        boolean r =
                decode2.check(decode.doubleF, decode.floatF, decode.int32F, decode.int64F, decode.uint32F,
                        decode.uint64F, decode.sint32F, decode.sint64F, decode.fixed32F, decode.fixed64F,
                        decode.sfixed32F, decode.sfixed64F, decode.boolF, decode.stringF, decode.bytesF,
                        decode.typeDefEnum);
        Assert.assertTrue(r);
        
        
	}
	
	@Test
    public void  testMutliTypeDefaultTypeEncodeDecode() throws IOException {
        Codec<AllTypesDojoClassWithDefault> dojoClassProxy = ProtobufProxy.create(AllTypesDojoClassWithDefault.class);
        //AllTypesDojoClass$$BJFProtoBufClass dojoClassProxy = new AllTypesDojoClass$$BJFProtoBufClass();
        AllTypesDojoClassWithDefault c = new AllTypesDojoClassWithDefault();
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
        c.typeDefEnum = TypeDefEnum.DECIMAL;
        
        byte[] bb = dojoClassProxy.encode(c);
        
        AllTypesDojoClassWithDefault decode = dojoClassProxy.decode(bb);
        
        Assert.assertEquals(2, decode.bytesF.length);
        Assert.assertEquals(1, decode.bytesF[0]);
        Assert.assertEquals(2, decode.bytesF[1]);
        Assert.assertEquals(101D, decode.doubleF.doubleValue(), 0d);
        Assert.assertEquals(1, decode.fixed32F.intValue());
        Assert.assertEquals(2L, decode.fixed64F.longValue());
        Assert.assertEquals(102F, decode.floatF.floatValue(), 0d);
        Assert.assertEquals(3, decode.int32F.intValue());
        Assert.assertEquals(4L, decode.int64F.intValue());
        Assert.assertEquals(5, decode.sfixed32F.longValue());
        Assert.assertEquals(6L, decode.sfixed64F.longValue());
        Assert.assertEquals(7, decode.sint32F.intValue());
        Assert.assertEquals(8L, decode.sint64F.longValue());
        Assert.assertEquals("hello", decode.stringF);
        Assert.assertEquals(false, decode.boolF.booleanValue());
        Assert.assertEquals(9, decode.uint32F.intValue());
        Assert.assertEquals(10L, decode.uint64F.longValue());
        Assert.assertEquals(TypeDefEnum.DECIMAL.value(), decode.typeDefEnum.value());
    }
	
}
