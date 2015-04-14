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
package com.baidu.bjf.remoting.protobuf.idlgenerate;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJOWithDefault;
import com.baidu.bjf.remoting.protobuf.complex.PersonPOJO;
import com.baidu.bjf.remoting.protobuf.complex.PersonPOJOWithDefault;
import com.baidu.bjf.remoting.protobuf.enumeration.EnumPOJOClass;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypesDojoClass;
import com.google.protobuf.InvalidProtocolBufferException;
import com.squareup.protoparser.MessageType;
import com.squareup.protoparser.MessageType.Field;
import com.squareup.protoparser.MessageType.Label;
import com.squareup.protoparser.ProtoFile;
import com.squareup.protoparser.ProtoSchemaParser;
import com.squareup.protoparser.Type;

/**
 * Test IDL script generate tool
 *
 * @author xiemalin
 * @since 1.0.1
 */
public class ComplexIDLGenerateTest {
    
    protected Type getByName(String name, List<Type> types) {
        for (Type type : types) {
            String typeName = type.getName();
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
        ProtoFile protoFile = ProtoSchemaParser.parse("autogenerate", code);
        Assert.assertNotNull(protoFile);
        
        Assert.assertEquals(AddressBookProtosPOJO.class.getPackage().getName(), 
                protoFile.getPackageName());
        
        Assert.assertEquals(2, protoFile.getTypes().size());
        
        List<Type> types = protoFile.getTypes();
        Type type = getByName(AddressBookProtosPOJO.class.getSimpleName(), types);
        
        
        Assert.assertNotNull(type);
        
        MessageType messageType = (MessageType) type;
        System.out.println(messageType.getExtensions());
        
        List<Field> fields = messageType.getFields();
        Assert.assertEquals(2, fields.size());
        
        Assert.assertEquals("list", fields.get(0).getName());
        Assert.assertEquals(PersonPOJO.class.getSimpleName(), fields.get(0).getType());
        Assert.assertEquals(Label.OPTIONAL, fields.get(0).getLabel());
        
        type = getByName(PersonPOJO.class.getSimpleName(), types);
        Assert.assertNotNull(type);
        
        messageType = (MessageType) type;
        fields = messageType.getFields();
        Assert.assertEquals(7, fields.size());
        
        for (Field field : fields) {
            System.out.println(field.getTag());
        }
    }
  
    @Test
    public void TestGenerateIDLComplexListWithDefalut() throws InvalidProtocolBufferException {
        
        String code = ProtobufIDLGenerator.getIDL(AddressBookProtosPOJOWithDefault.class);

        Assert.assertNotNull(code);
        ProtoFile protoFile = ProtoSchemaParser.parse("autogenerate", code);
        Assert.assertNotNull(protoFile);
        
        Assert.assertEquals(AddressBookProtosPOJOWithDefault.class.getPackage().getName(), 
                protoFile.getPackageName());
        
        Assert.assertEquals(2, protoFile.getTypes().size());
        
        List<Type> types = protoFile.getTypes();
        Type type = getByName(AddressBookProtosPOJOWithDefault.class.getSimpleName(), types);
        
        
        Assert.assertNotNull(type);
        
        MessageType messageType = (MessageType) type;
        System.out.println(messageType.getExtensions());
        
        List<Field> fields = messageType.getFields();
        Assert.assertEquals(2, fields.size());
        
        Assert.assertEquals("list", fields.get(0).getName());
        Assert.assertEquals(PersonPOJOWithDefault.class.getSimpleName(), fields.get(0).getType());
        Assert.assertEquals(Label.OPTIONAL, fields.get(0).getLabel());
        
        type = getByName(PersonPOJOWithDefault.class.getSimpleName(), types);
        Assert.assertNotNull(type);
        
        messageType = (MessageType) type;
        fields = messageType.getFields();
        Assert.assertEquals(7, fields.size());
        
        for (Field field : fields) {
            System.out.println(field.getTag());
        }
    }
    
    
    @Test
    public void testGenerateIDLSimpleType() throws InvalidProtocolBufferException {
        
        String code = ProtobufIDLGenerator.getIDL(AllTypesDojoClass.class);
        Assert.assertNotNull(code);
        
    }
    
    @Test
    public void testGenerateIDLEnumType() {
        
        String code = ProtobufIDLGenerator.getIDL(EnumPOJOClass.class);
        Assert.assertNotNull(code);
        
    }
}
