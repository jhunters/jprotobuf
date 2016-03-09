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
package com.baidu.bjf.remoting.protobuf.idlproxy;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.IDLProxyObject;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypesDojoClass;

import junit.framework.Assert;

/**
 * Test class for {@link ProtobufIDLProxy}
 * 
 * @author xiemalin
 * @since 1.0.2
 */
public class ProtobufIDLProxyTest {

	@Test
	public void testDecode() throws Exception {

		String protoCotent = "package mypackage.test; "
				+ "option java_package = \"com.baidu.bjf.remoting.protobuf.simplestring\";"
				+ "option java_outer_classname = \"StringTypeClass\";  " + "message StringMessage { "
				+ "  required string message = 1; }";
		IDLProxyObject object = ProtobufIDLProxy.createSingle(protoCotent, true);

		// 动态设置字段值
		object.put("message", "hello你好");
		// protobuf 序列化
		byte[] bb = object.encode();

		// protobuf 反序列化
		IDLProxyObject newObject = object.decode(bb);
		Assert.assertEquals("hello你好", newObject.get("message"));
	}

	@Test
	public void testDecodeComplex() throws Exception {
		String code = ProtobufIDLGenerator.getIDL(AllTypesDojoClass.class);
		IDLProxyObject object = ProtobufIDLProxy.create(code).entrySet().iterator().next().getValue();

		object.put("boolF", false);
		object.put("bytesF", new byte[] { 1, 2 });
		object.put("doubleF", 101D);
		object.put("fixed32F", 1);
		object.put("fixed64F", 2L);
		object.put("floatF", 102F);
		object.put("int32F", 3);
		object.put("int64F", 4L);
		object.put("sfixed32F", 5);
		object.put("sfixed64F", 6L);
		object.put("sint32F", 7);
		object.put("sint64F", 8L);
		object.put("stringF", "hello");
		object.put("uint32F", 9);
		object.put("uint64F", 10L);

		byte[] bb = object.encode();

		InterClassName icn = InterClassName.parseFrom(bb);

		Assert.assertEquals(false, icn.getBoolF());
		Assert.assertEquals(2, icn.getBytesF().toByteArray().length);
		Assert.assertEquals(101D, icn.getDoubleF());
		Assert.assertEquals(1, icn.getFixed32F());
		Assert.assertEquals(2L, icn.getFixed64F());
		Assert.assertEquals(102F, icn.getFloatF());
		Assert.assertEquals(3, icn.getInt32F());
		Assert.assertEquals(4L, icn.getInt64F());
		Assert.assertEquals(5, icn.getSfixed32F());
		Assert.assertEquals(6L, icn.getSfixed64F());
		Assert.assertEquals(7, icn.getSint32F());
		Assert.assertEquals(8L, icn.getSint64F());
		Assert.assertEquals("hello", icn.getStringF());
		Assert.assertEquals(9, icn.getUint32F());
		Assert.assertEquals(10L, icn.getUint64F());
	}

	@Test
	public void testMultiDecode() throws IOException {
		String code = ProtobufIDLGenerator.getIDL(AddressBookProtosPOJO.class);
		Map<String, IDLProxyObject> idlProxyObjects = ProtobufIDLProxy.create(code);

		IDLProxyObject idlProxyObject = idlProxyObjects.get(AddressBookProtosPOJO.class.getSimpleName());

		idlProxyObject.put("name", "hello");
		idlProxyObject.put("list.name", "yes");
		idlProxyObject.put("list.id", 10);

		try {
			idlProxyObject.put("notexitfield", null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertNotNull(e);
		}
		byte[] bb = idlProxyObject.encode();

		IDLProxyObject newObject = idlProxyObject.decode(bb);
		Assert.assertEquals("hello", newObject.get("name"));
		Assert.assertEquals("yes", newObject.get("list.name"));

	}

	@Test
	public void testInnerIncludingServiceIDLGenerateSource() {
		StringBuilder idl = new StringBuilder();
		idl.append("package mypkg;\n");
		idl.append("message DataInfo {\n");
		idl.append("   enum DataVisibility {\n");
		
		idl.append("   PUBLIC = 1;\n");
		idl.append("   PRIVATE = 2;\n");
		idl.append("   }");
		idl.append("    optional DataVisibility v = 1;\n");
		idl.append("   message SubDataInfo {\n");
		idl.append("      optional string name =1;\n");
		idl.append("      message Sub2DataInfo {\n");
		idl.append("        required int32 age = 1;\n");
		idl.append("      }\n");
		idl.append("   }\n");
		
		idl.append("}\n");
		
		
		idl.append("message DataStatus {\n");
		idl.append("   optional DataInfo.DataVisibility visibility = 1; \n");
		idl.append("   optional DataInfo.SubDataInfo subDataInfo = 2;\n");
		idl.append("   optional DataInfo.SubDataInfo.Sub2DataInfo sub2DataInfo = 3;\n");
		idl.append("}");
		
		Map<String, IDLProxyObject> map = ProtobufIDLProxy.create(idl.toString());
		
		IDLProxyObject idlProxyObject = map.get("DataStatus");
		
		idlProxyObject.put("subDataInfo.name", "abc");
		
		try {
			byte[] bytes = idlProxyObject.encode();
			
			System.out.println(Arrays.toString(bytes));
			
			IDLProxyObject idlProxyObject2 = idlProxyObject.decode(bytes);
			Assert.assertEquals(idlProxyObject2.get("subDataInfo.name"), "abc");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void testFileImportWithDiffPackageIDLGenerateSource() {
		try {
		    ProtobufIDLProxy.generateSource(new File("D:/qq/Pk2.proto"), new File("D:/qq"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

}
