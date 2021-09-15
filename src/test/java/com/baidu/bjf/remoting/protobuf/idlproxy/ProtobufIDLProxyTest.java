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
package com.baidu.bjf.remoting.protobuf.idlproxy;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.IDLProxyObject;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypesPojoClass;

/**
 * Test class for {@link ProtobufIDLProxy}
 * 
 * @author xiemalin
 * @since 1.0.2
 */
public class ProtobufIDLProxyTest {
    
    @Test
    public void testCodeGenerateFromIDL() {
        String protoCotent = "package mypackage.test; "
                + "option java_package = \"com.baidu.bjf.remoting.protobuf.simplestring\";"
                + "option java_outer_classname = \"StringTypeClassToIDLGenerator\";  " + "message StringMessage { "
                + "  required string message = 1 [default = \"hello\"]; }";
        ProtobufIDLProxy.generateSource(protoCotent, new File("."));
        
    }

    @Test
    public void testDecode() throws Exception {

        String protoCotent = "package mypackage.test; "
                + "option java_package = \"com.baidu.bjf.remoting.protobuf.simplestring\";"
                + "option java_outer_classname = \"StringTypeClass\";  " + "message StringMessage { "
                + "  required string message = 1 [default = \"hello\"];"
                + "optional int64 age = 10 [default = 0]; "
                + "optional float age1 = 11 [default = 0];"
                + "optional double age2 = 12 [default = 0]; }";
        IDLProxyObject object = ProtobufIDLProxy.createSingle(protoCotent);

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
        String code = ProtobufIDLGenerator.getIDL(AllTypesPojoClass.class);
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
        Assert.assertEquals(9, icn.getUint32F());
        Assert.assertEquals(10L, icn.getUint64F());
    }
    
    @Test
    public void testDyanmicIDLChange() throws Exception {

        String protoCotent =
                "package mypackage.test; " + "option java_package = \"com.baidu.bjf.remoting.protobuf.simplestring\";"
                        + "option java_outer_classname = \"StringTypeClass\";  " + "message StringMessage { "
                        + "  required string message = 1; }";
        IDLProxyObject object = ProtobufIDLProxy.createSingle(protoCotent);

        String expected = "hello你好";
        // 动态设置字段值
        object.put("message", expected);
        
        Object result = object.get("message");
        Assert.assertEquals(expected, result);
        
        protoCotent =
                "package mypackage.test; " + "option java_package = \"com.baidu.bjf.remoting.protobuf.simplestring\";"
                        + "option java_outer_classname = \"StringTypeClass\";  " + "message StringMessage { "
                        + "  required string message1 = 1; }";
  
        object = ProtobufIDLProxy.createSingle(protoCotent);

        // 动态设置字段值
        object.put("message1", expected);
        
        result = object.get("message1");
        Assert.assertEquals(expected, result);
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
    /**
     * Test inner including service idl generate source.
     */
    @Test
    public void testInnerIncludingServiceIDLGenerateSource2() {
        String protoCotent = "package so_rtrs_req_res; " +
                "option java_package = \"com.rtrs.proto\"; " +
                "option java_outer_classname = \"ReqRes\"; " +
                " " +
                "message Http " +
                "{ " +
                "message KeyVal " +
                "{ " +
                " optional string key = 1; " +
                " optional string val = 2; " +
                "} " +
                " " +
                " " +
                " optional string uri = 1; " +
                " optional uint32 type = 2; " +
                " optional KeyVal param_addon = 3; " +
                " optional string name = 4; " +
                "} " +
                " " +
                " "
                ;
        
        Map<String, IDLProxyObject> idlProxyObjects = ProtobufIDLProxy.create(protoCotent);
        System.out.println(idlProxyObjects);
        
        idlProxyObjects.get("Http").put("param_addon.key", "abc");
        Assert.assertEquals("abc", idlProxyObjects.get("Http").get("param_addon.key"));
    }

}
