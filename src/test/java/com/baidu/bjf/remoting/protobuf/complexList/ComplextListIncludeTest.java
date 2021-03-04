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
package com.baidu.bjf.remoting.protobuf.complexList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos.AddressBook;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos.Person;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos.TypeDef;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * The Class ComplextListIncludeTest.
 *
 * @author xiemalin
 */
public class ComplextListIncludeTest {

    /**
     * test encode and decode with JProtobuf and Protobuf java.
     */
    @Test
    public void testEncodeDecode() {

        // protobuf -> jprotobuf
        Person p = Person.newBuilder().setName("xiemalin").setId(100).build();

        AddressBook book = AddressBook.newBuilder().addPerson(p).addPerson(p).addTypeDef(TypeDef.DECIMAL)
                .addTypeDef(TypeDef.URL).build();

        byte[] bb = book.toByteArray();

        Codec<AddressBookProtosPOJO> codec = ProtobufProxy.create(AddressBookProtosPOJO.class);
        try {
            AddressBookProtosPOJO decode = codec.decode(bb);
            Assert.assertEquals(2, decode.getList().size());
            Assert.assertEquals("xiemalin", decode.getList().get(0).name);
            Assert.assertEquals(2, decode.typeList.size());
            Assert.assertEquals(TypeDefEnum.DECIMAL.value(), decode.typeList.get(0).value());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // jprotobuf -> protobuf
        AddressBookProtosPOJO pojo = new AddressBookProtosPOJO();

        PersonPOJO person = new PersonPOJO();
        person.name = "xiemalin";
        person.id = 100;
        person.boolF = true;
        person.bytesF = new byte[] { 1, 2 };
        person.email = "xiemalin@baidu.com";

        List<PersonPOJO> list = new ArrayList<PersonPOJO>();
        list.add(person);
        list.add(person);
        pojo.setList(list);
        
        pojo.typeList = new ArrayList<TypeDefEnum>();
        pojo.typeList.add(TypeDefEnum.DECIMAL);
        pojo.typeList.add(TypeDefEnum.URL);

        bb = null;
        try {
            bb = codec.encode(pojo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            AddressBook parseFrom = AddressBook.parseFrom(bb);
            Assert.assertEquals(2, parseFrom.getPersonCount());
            Assert.assertEquals("xiemalin", parseFrom.getPerson(0).getName());
            Assert.assertEquals(2, parseFrom.getTypeDefCount());
            Assert.assertEquals(TypeDefEnum.DECIMAL.value(), parseFrom.getTypeDef(0).getNumber());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }
    
    
    /**
     * test encode and decode with JProtobuf and Protobuf java.
     */
    @Test
    public void testEncode() {

        Codec<AddressBookProtosPOJO> codec = ProtobufProxy.create(AddressBookProtosPOJO.class, false);

        // jprotobuf -> protobuf
        AddressBookProtosPOJO pojo = new AddressBookProtosPOJO();

        PersonPOJO person = new PersonPOJO();
        person.name = "xiemalin";
        person.id = 100;
        person.boolF = true;
        person.bytesF = new byte[] { 1, 2 };
        person.email = "xiemalin@baidu.com";

        List<PersonPOJO> list = new ArrayList<PersonPOJO>();
        list.add(person);
        list.add(person);
        pojo.setList(list);
        
        pojo.typeList = new ArrayList<TypeDefEnum>();
        pojo.typeList.add(TypeDefEnum.DECIMAL);
        pojo.typeList.add(TypeDefEnum.URL);

        byte[] bb = null;
        try {
            bb = codec.encode(pojo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    
    
    /**
     * Test empty list case.
     */
    @Test
    public void testEmptyListCase() {
        ListWithNull listWithNull = new ListWithNull();
        listWithNull.list = new ArrayList();
        
        Codec<ListWithNull> codec = ProtobufProxy.create(ListWithNull.class, false);
        try {
            
            byte[] encode = codec.encode(listWithNull);
            Assert.assertTrue(encode.length == 0);
            ListWithNull listWithNull2 = codec.decode(encode);
            Assert.assertTrue(listWithNull2.list.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
            org.junit.Assert.fail(e.getMessage());
        }
    }

    
    /**
     * Test empty map case.
     */
    @Test
    public void testEmptyMapCase() {
        ListWithNull listWithNull = new ListWithNull();
        listWithNull.map = new HashMap<String, String>();
        
        Codec<ListWithNull> codec = ProtobufProxy.create(ListWithNull.class);
        try {
            
            byte[] encode = codec.encode(listWithNull);
            Assert.assertTrue(encode.length == 0);
            ListWithNull listWithNull2 = codec.decode(encode);
            Assert.assertTrue(listWithNull2.map.isEmpty());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
