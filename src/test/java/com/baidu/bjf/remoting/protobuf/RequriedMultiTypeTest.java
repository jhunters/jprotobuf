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
package com.baidu.bjf.remoting.protobuf;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.RequriedMultiType.InterClassName;
import com.google.protobuf.UninitializedMessageException;

/**
 * @author xiemalin
 *
 */
public class RequriedMultiTypeTest {
	
	@Test
	public void  testRequiredMutliTypeMissRequiredField() throws IOException {
		
		Codec<RequriedMultiDojoClass> dojoClassProxy = ProtobufProxy.create(RequriedMultiDojoClass.class);
		
		RequriedMultiDojoClass c = new RequriedMultiDojoClass();
		c.doubleF = 101D;
		
		try {
			dojoClassProxy.encode(c);
			Assert.fail("should throw excpetion. required field must set.");
		} catch (UninitializedMessageException e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void  testRequiredMutliTypeEncode() throws IOException {
		Codec<RequriedMultiDojoClass> dojoClassProxy = ProtobufProxy.create(RequriedMultiDojoClass.class);
		
		RequriedMultiDojoClass c = new RequriedMultiDojoClass();
		c.doubleF = 101D;
		c.setSex(false);
		c.setStringF("hello");
		
		byte[] bb = dojoClassProxy.encode(c);
		
		InterClassName icn = InterClassName.parseFrom(bb);
		Assert.assertEquals(c.doubleF, icn.getDoubleF());
		Assert.assertEquals(false, icn.getSex());
		Assert.assertEquals("hello", icn.getStringF());
		
	}
	
	@Test
	public void  testRequiredMutliTypeDecode() throws IOException {
		InterClassName icn = InterClassName.newBuilder().setDoubleF(101D)
		.setSex(false).setStringF("world").build();
		
		byte[] bb = icn.toByteArray();
		
		Codec<RequriedMultiDojoClass> dojoClassProxy = ProtobufProxy.create(RequriedMultiDojoClass.class);
		RequriedMultiDojoClass decode = dojoClassProxy.decode(bb);
		
		Assert.assertEquals(101D, decode.doubleF);
		Assert.assertEquals(false, decode.isSex());
		Assert.assertEquals("world", decode.getStringF());

		
	}
	
}
