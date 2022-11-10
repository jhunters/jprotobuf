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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.IDLProxyObject;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJOWithDefault;
import com.baidu.bjf.remoting.protobuf.complex.PersonPOJO;
import com.baidu.bjf.remoting.protobuf.complex.PersonPOJOWithDefault;
import com.baidu.bjf.remoting.protobuf.enumeration.EnumPOJOClass;
import com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberTypePOJOClass2;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypesPojoClass;
import com.baidu.jprotobuf.com.squareup.protoparser.FieldElement;
import com.baidu.jprotobuf.com.squareup.protoparser.MessageElement;
import com.baidu.jprotobuf.com.squareup.protoparser.ProtoFile;
import com.baidu.jprotobuf.com.squareup.protoparser.ProtoParser;
import com.baidu.jprotobuf.com.squareup.protoparser.TypeElement;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Test IDL script generate tool
 *
 * @author xiemalin
 * @since 1.0.1
 */
public class ComplexIDLGenerateTest {
    
    protected TypeElement getByName(String name, List<TypeElement> types) {
        for (TypeElement type : types) {
            String typeName = type.name();
            if (typeName.equals(name)) {
                return type;
            }
        }
        return null;
    }

    @Test
    public void TestGenerateIDLComplexList() throws InvalidProtocolBufferException {
        
        String code = ProtobufIDLGenerator.getIDL(AddressBookProtosPOJO.class);

        Assert.assertNotNull(code);
        ProtoFile protoFile = ProtoParser.parse("autogenerate", code);
        Assert.assertNotNull(protoFile);
        
        Assert.assertEquals(AddressBookProtosPOJO.class.getPackage().getName(), 
                protoFile.packageName());
        
        Assert.assertEquals(2, protoFile.typeElements().size());
        
        List<TypeElement> types = protoFile.typeElements();
        TypeElement type = getByName(AddressBookProtosPOJO.class.getSimpleName(), types);
        
        
        Assert.assertNotNull(type);
        
        MessageElement messageType = (MessageElement) type;
        System.out.println(messageType.extensions());
        
        List<FieldElement> fields = messageType.fields();
        Assert.assertEquals(2, fields.size());
        
        Assert.assertEquals("list", fields.get(0).name());
        Assert.assertEquals(PersonPOJO.class.getSimpleName(), fields.get(0).type().toString());
        Assert.assertEquals(FieldElement.Label.OPTIONAL, fields.get(0).label());
        
        type = getByName(PersonPOJO.class.getSimpleName(), types);
        Assert.assertNotNull(type);
        
        messageType = (MessageElement) type;
        fields = messageType.fields();
        Assert.assertEquals(7, fields.size());
        
        for (FieldElement field : fields) {
            System.out.println(field.tag());
        }
    }
  
    @Test
    public void TestGenerateIDLComplexListWithDefalut() throws InvalidProtocolBufferException {
        
        String code = ProtobufIDLGenerator.getIDL(AddressBookProtosPOJOWithDefault.class);

        Assert.assertNotNull(code);
        ProtoFile protoFile = ProtoParser.parse("autogenerate", code);
        Assert.assertNotNull(protoFile);
        
        Assert.assertEquals(AddressBookProtosPOJOWithDefault.class.getPackage().getName(), 
                protoFile.packageName());
        
        Assert.assertEquals(2, protoFile.typeElements().size());
        
        List<TypeElement> types = protoFile.typeElements();
        TypeElement type = getByName(AddressBookProtosPOJOWithDefault.class.getSimpleName(), types);
        
        
        Assert.assertNotNull(type);
        
        MessageElement messageType = (MessageElement) type;
        System.out.println(messageType.extensions());
        
        List<FieldElement> fields = messageType.fields();
        Assert.assertEquals(2, fields.size());
        
        Assert.assertEquals("list", fields.get(0).name());
        Assert.assertEquals(PersonPOJOWithDefault.class.getSimpleName(), fields.get(0).type().toString());
        Assert.assertEquals(FieldElement.Label.OPTIONAL, fields.get(0).label());
        
        type = getByName(PersonPOJOWithDefault.class.getSimpleName(), types);
        Assert.assertNotNull(type);
        
        messageType = (MessageElement) type;
        fields = messageType.fields();
        Assert.assertEquals(8, fields.size());
        
        for (FieldElement field : fields) {
            System.out.println(field.tag());
        }
    }
    
    @Test
    public void testDefaultValue() {
        
        String idl = "package tutorial;" +
            "option java_package = \"com.example.tutorial\";" +
            "option java_outer_classname = \"AddressBookProtos\";" +
            "enum PhoneType { MOBILE = 0; HOME = 1; WORK = 2;}" +
            " message PhoneNumberAA {" +
                "optional PhoneType type = 1 [default = HOME]; //abc\n" +
                "optional int32 name = 2 [default = 10];" +
                "optional string vName = 3 [default = \"hello world\"];" +
          "}"; 
        
        IDLProxyObject idlProxyObject = ProtobufIDLProxy.createSingle(idl, false);
        
        Object type = idlProxyObject.get("type"); 
        
        Assert.assertEquals(type + "", "HOME");
        Assert.assertEquals(10, idlProxyObject.get("name"));
        Assert.assertEquals("hello world", idlProxyObject.get("vName"));
        
    }
    
    @Test
    public void testNoOptionalMark() {
        
        String idl = "syntax = \"proto3\";package tutorial;" +
            "option java_package = \"com.example.tutorial\";" +
            "option java_outer_classname = \"AddressBookProtos\";" +
            "enum PhoneType { MOBILE = 0; HOME = 1; WORK = 2;}" +
            " message PhoneNumber {" +
                " int32 type = 1; " +
                " int32 name = 2 [default = 10];" +
                " string vName = 3 [default = \"hello world\"];" +
          "}"; 
        
        try {
           ProtobufIDLProxy.createSingle(idl);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
    
    
    @Test
    public void testGenerateIDLSimpleType() throws InvalidProtocolBufferException {
        String code = ProtobufIDLGenerator.getIDL(AllTypesPojoClass.class);
        Assert.assertNotNull(code);
        
    }
    
    @Test
    public void testGenerateIDLEnumTypeAndTypesReturns() {
        final Set<Class<?>> cachedTypes = new HashSet<Class<?>>();
        final Set<Class<?>> cachedEnumTypes = new HashSet<Class<?>>();
        
        String code = ProtobufIDLGenerator.getIDL(EnumPOJOClass.class, cachedTypes, cachedEnumTypes);
        Assert.assertNotNull(code);
        
        Assert.assertEquals(1, cachedTypes.size());
        Assert.assertEquals(1, cachedEnumTypes.size());
    }
    
    @Test
    public void testListIDLGenerate() {
        String code = ProtobufIDLGenerator.getIDL(RequrieRepeatedNumberTypePOJOClass2.class, null, null, false);
        Assert.assertTrue(code.indexOf("repeated int32") != -1);
    }
    
    @Test
    public void testEmptyClass() {
        String code = ProtobufIDLGenerator.getIDL(EmptyClass.class);
        Assert.assertTrue(code.indexOf("message") !=  -1);
    }
    
    private static class EmptyClass {
        
    }
    
    @Test
    public void testProtobufIDLGeneratorGetIDLTypesReturns() {
        
        final Set<Class<?>> cachedTypes = new HashSet<Class<?>>();
        final Set<Class<?>> cachedEnumTypes = new HashSet<Class<?>>();
        
        String code = ProtobufIDLGenerator.getIDL(EmptyClass.class, cachedTypes, cachedEnumTypes);
        Assert.assertTrue(code.indexOf("message") !=  -1);
        
        Assert.assertEquals(1, cachedTypes.size());
        Assert.assertEquals(0, cachedEnumTypes.size());
        code = ProtobufIDLGenerator.getIDL(EmptyClass.class, cachedTypes, cachedEnumTypes);
        Assert.assertNull(code);
    }
}
