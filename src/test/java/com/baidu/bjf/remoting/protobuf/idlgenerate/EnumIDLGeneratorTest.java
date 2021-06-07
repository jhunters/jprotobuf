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
package com.baidu.bjf.remoting.protobuf.idlgenerate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.IDLProxyObject;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.enumeration.EnumAttrPOJO;
import com.baidu.bjf.remoting.protobuf.enumeration.EnumPOJOClass;

/**
 * 
 * Test class for enum idl proxy
 *
 * @author xiemalin
 * @since 1.4.0
 */
public class EnumIDLGeneratorTest {

    public List<String> methoda(int a, long b, float c, double d, Map<String, String> map) {
        return null;
    }

    @Test
    public void testEnumIDLProxy() throws IOException {
        String idl = ProtobufIDLGenerator.getIDL(EnumPOJOClass.class);
        IDLProxyObject idlProxyObject = ProtobufIDLProxy.createSingle(idl);

        idlProxyObject.put("enumAttr", "STRING");

        byte[] bytes = idlProxyObject.encode();
        Codec<EnumPOJOClass> codec = ProtobufProxy.create(EnumPOJOClass.class);
        EnumPOJOClass enumPOJOClass = codec.decode(bytes);
        Assert.assertEquals(enumPOJOClass.enumAttr.value(), EnumAttrPOJO.STRING.value());
    }

    private Map<String, IDLProxyObject> initialFromProtofile(String fileName) throws IOException {
        File file = new File(EnumIDLGeneratorTest.class.getResource(fileName).getFile());

        Map<String, IDLProxyObject> map = ProtobufIDLProxy.create(file, false);
        Assert.assertNotNull(map);
        Assert.assertEquals(24, map.size());

        return map;
    }
    
    @Ignore
    @Test
    public void testMostComplexIDLSourceGenerate2() throws IOException {
        File file = new File(EnumIDLGeneratorTest.class.getResource("test.proto").getFile());
        ProtobufIDLProxy.create(file, true);
    }
    

    @Ignore
    @Test
    public void testMostComplexIDLSourceGenerate() throws IOException {
        File file = new File(EnumIDLGeneratorTest.class.getResource("si_product_biz.proto").getFile());
        ProtobufIDLProxy.generateSource(file, new File("D:\\test"));
    }

    @Ignore
    @Test
    public void testMostComplexIDLProxy() throws IOException {
        Map<String, IDLProxyObject> map = initialFromProtofile("si_product_biz.proto");

        boolean containsKey = map.containsKey("ProductTemplateResponse");
        Assert.assertTrue(containsKey);

        byte[] bytes;
        IDLProxyObject idlProxyObject;
        idlProxyObject = map.get("ProductTemplateResponse");

        idlProxyObject.put("product_template.property_product_mapping.usage", "TUWEN_ICON");
        idlProxyObject.put("product_template.property_product_mapping.no", 1001);
        idlProxyObject.put("product_template.property_product_mapping.type", "IMG");
        idlProxyObject.put("product_template.property_product_mapping.value", new byte[] { 10, 20 });
        idlProxyObject.put("product_template.property_product_mapping.editable", true);
        idlProxyObject.put("product_template.property_product_mapping.max_length", 10000);
        idlProxyObject.put("product_template.property_product_mapping.literal", new byte[] { 10, 20 });
        idlProxyObject.put("product_template.property_product_mapping.enable_url", false);
        idlProxyObject.put("product_template.property_product_mapping.name", "matthew".getBytes("utf-8"));

        idlProxyObject.put("head.result.status", 101);
        idlProxyObject.put("product_template.id", 1);
        idlProxyObject.put("product_template.name", "matthew".getBytes("utf-8"));

        idlProxyObject.put("product_template.type", "USER_DEFINE");
        idlProxyObject.put("product_template.thumbnail.width", 111);
        idlProxyObject.put("product_template.thumbnail.height", 112);
        idlProxyObject.put("product_template.thumbnail.url", "http://test.com");

        idlProxyObject.put("product_template.preview.width", 111);
        idlProxyObject.put("product_template.preview.height", 112);
        idlProxyObject.put("product_template.preview.url", "http://test.com");

        idlProxyObject.put("product_template.template_size.type", 2);
        idlProxyObject.put("product_template.template_size.width", 333);
        idlProxyObject.put("product_template.template_size.height", 444);

        bytes = idlProxyObject.encode();
        Assert.assertNotNull(bytes);

        IDLProxyObject idlProxyObject2 = idlProxyObject.decode(bytes);

        Assert.assertEquals(idlProxyObject2.get("product_template.property_product_mapping.usage") + "", "TUWEN_ICON");
        Assert.assertEquals(idlProxyObject2.get("product_template.property_product_mapping.no"), 1001);
        Assert.assertEquals(idlProxyObject2.get("product_template.property_product_mapping.type") + "", "IMG");
        Assert.assertArrayEquals((byte[]) idlProxyObject2.get("product_template.property_product_mapping.value"),
                new byte[] { 10, 20 });
        Assert.assertEquals(idlProxyObject2.get("product_template.property_product_mapping.editable"), true);
        Assert.assertEquals(idlProxyObject2.get("product_template.property_product_mapping.max_length"), 10000);
        Assert.assertArrayEquals((byte[]) idlProxyObject2.get("product_template.property_product_mapping.literal"),
                new byte[] { 10, 20 });
        Assert.assertEquals(idlProxyObject2.get("product_template.property_product_mapping.enable_url"), false);
        Assert.assertArrayEquals((byte[]) idlProxyObject2.get("product_template.property_product_mapping.name"),
                "matthew".getBytes("utf-8"));
        Assert.assertEquals(idlProxyObject2.get("head.result.status"), 101);
        Assert.assertEquals(idlProxyObject2.get("product_template.id"), 1);
        Assert.assertArrayEquals((byte[]) idlProxyObject2.get("product_template.name"), "matthew".getBytes("utf-8"));
        Assert.assertEquals(idlProxyObject2.get("product_template.type") + "", "USER_DEFINE");
        Assert.assertEquals(idlProxyObject2.get("product_template.thumbnail.width"), 111);
        Assert.assertEquals(idlProxyObject2.get("product_template.thumbnail.height"), 112);
        Assert.assertEquals(idlProxyObject2.get("product_template.thumbnail.url"), "http://test.com");
        Assert.assertEquals(idlProxyObject2.get("product_template.preview.width"), 111);
        Assert.assertEquals(idlProxyObject2.get("product_template.preview.height"), 112);
        Assert.assertEquals(idlProxyObject2.get("product_template.preview.url"), "http://test.com");
        Assert.assertEquals(idlProxyObject2.get("product_template.template_size.type"), 2);
        Assert.assertEquals(idlProxyObject2.get("product_template.template_size.width"), 333);
        Assert.assertEquals(idlProxyObject2.get("product_template.template_size.height"), 444);
    }

    @Ignore
    @Test
    public void testComplexIDLProxy() throws IOException {
        Map<String, IDLProxyObject> map = initialFromProtofile("si_product_biz.proto");

        boolean containsKey = map.containsKey("ProductAuditRejectRequest");
        Assert.assertTrue(containsKey);

        byte[] bytes;
        IDLProxyObject idlProxyObject;

        idlProxyObject = map.get("ProductAuditRejectRequest");

        idlProxyObject.put("userid", 500);
        idlProxyObject.put("head.reserved", 100);

        bytes = idlProxyObject.encode();

        IDLProxyObject decodeProxyObject = idlProxyObject.decode(bytes);
        Assert.assertEquals(500, decodeProxyObject.get("userid"));
        Assert.assertEquals(100, decodeProxyObject.get("head.reserved"));

        idlProxyObject = map.get("ProductPropertyRequest");
        Assert.assertNotNull(idlProxyObject);

        idlProxyObject.put("userid", 200);
        idlProxyObject.put("head.request_type", "USER_DEFINED");
        idlProxyObject.put("head.appid", "DSP");

        bytes = idlProxyObject.encode();

        decodeProxyObject = idlProxyObject.decode(bytes);
        Assert.assertEquals(200, decodeProxyObject.get("userid"));
        Assert.assertEquals(decodeProxyObject.get("head.request_type") + "", "USER_DEFINED");
        Assert.assertEquals(decodeProxyObject.get("head.appid") + "", "DSP");
    }

    @Ignore
    @Test
    public void testComplexIDLProxyOnError() throws IOException {
        Map<String, IDLProxyObject> map = initialFromProtofile("si_product_biz.proto");

        boolean containsKey = map.containsKey("ProductAuditRejectRequest");
        Assert.assertTrue(containsKey);

        IDLProxyObject idlProxyObject;

        idlProxyObject = map.get("ProductAuditRejectRequest");

        // this field name not exist should throw exception

        try {
            idlProxyObject.get("userid_notexist");
            Assert.fail();
        } catch (Exception e) {
            Assert.assertNotNull(e);
        }
    }

    @Ignore
    @Test
    public void testIDLImportReferenceProxy() throws IOException {
        File file = new File(EnumIDLGeneratorTest.class.getResource("addressbook.proto").getFile());

        Map<String, IDLProxyObject> map = ProtobufIDLProxy.create(file, false);

        Assert.assertEquals(2, map.size());
    }
    
    @Test
    public void testMapRefrenceObjectIDLGenerator() {
        String idl = ProtobufIDLGenerator.getIDL(MapPojo.class);
        System.out.println(idl);
    }
}
