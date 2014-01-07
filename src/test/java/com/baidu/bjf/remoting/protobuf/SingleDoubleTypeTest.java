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

import com.baidu.bjf.remoting.protobuf.SingleDoubleType.InterClassName;

/**
 * @author xiemalin
 *
 */
public class SingleDoubleTypeTest {
	
	@Test
	public void testSingleDoubleType() throws IOException {
		SingleDouleDojoClass c = new SingleDouleDojoClass();
		c.gender = 101L;
		
		Codec<SingleDouleDojoClass> dojoClassProxy = ProtobufProxy.create(SingleDouleDojoClass.class);
		if (dojoClassProxy != null) {
			byte[] bb = dojoClassProxy.encode(c);
			InterClassName parseFrom = InterClassName.parseFrom(bb);
			Assert.assertEquals(c.gender, parseFrom.getDoubleF());
			
			InterClassName tcn = InterClassName.newBuilder().setDoubleF(222.0).build();
			bb = tcn.toByteArray();
			SingleDouleDojoClass decode = dojoClassProxy.decode(bb);
			Assert.assertEquals(222.0, decode.gender);
		}
	}

}
