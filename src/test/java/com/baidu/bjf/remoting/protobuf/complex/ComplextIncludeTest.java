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
package com.baidu.bjf.remoting.protobuf.complex;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 *
 * @author xiemalin
 *
 */
public class ComplextIncludeTest {

 
    /**
     * test encode and decode with JProtobuf and Protobuf java
     */
    @Test
    public void testEncodeDecode() {

        Person p = Person.newBuilder().
        setName("xiemalin").setId(100).build();
        
        AddressBook book = AddressBook.newBuilder().setPerson(p).build();
        
        byte[] bb = book.toByteArray();
        System.out.println(Arrays.toString(bb));
        
        Codec<AddressBookProtosPOJO> codec = ProtobufProxy.create(AddressBookProtosPOJO.class, true);
        
        AddressBookProtosPOJO pojo = new AddressBookProtosPOJO();
        
        PersonPOJO person = new PersonPOJO();
        person.name = "xiemalin";
        person.id = 100;
/*        person.boolF = true;
        person.bytesF = new byte[]{1,2};
        person.email = "xiemalin@baidu.com";*/
        
        pojo.list = person;
        
        bb =  null;
        try {
            bb = codec.encode(pojo);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        try {
            AddressBook parseFrom = AddressBook.parseFrom(bb);
            Assert.assertEquals("xiemalin", parseFrom.getPerson().getName());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        
/*        try {
            AddressBookProtosPOJO decode = codec.decode(bb);
            Assert.assertEquals(1, decode.list.size());
            Assert.assertEquals("xiemalin", decode.list.get(0).name);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
