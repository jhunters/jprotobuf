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
package com.baidu.bjf.remoting.protobuf.descriptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.DynamicMessage;

/**
 * Test class for descriptor.
 * 
 * @author xiemalin
 * @since 1.8.1
 */
public class DescritporTest {

    Codec<DescriptorProtoPOJO> codec = ProtobufProxy.create(DescriptorProtoPOJO.class, false);

    Codec<FileDescriptorProtoPOJO> codec2 = ProtobufProxy.create(FileDescriptorProtoPOJO.class, false);

    @Test
    public void testPOJODescriptorWorksWell() throws IOException {
        Descriptor descriptor2 =
                com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos.AddressBook.getDescriptor();
        DescriptorProto proto = descriptor2.toProto();
        byte[] byteArray = proto.toByteArray();

        DescriptorProtoPOJO decode = codec.decode(byteArray);

        byte[] encode = codec.encode(decode);

        Assert.assertArrayEquals(byteArray, encode);

    }

    private byte[] getProtoBytes2() throws IOException {
        Codec<AddressBookProtosPOJO> simpleMapPojoCodec = ProtobufProxy.create(AddressBookProtosPOJO.class, false);

        // initialize

        AddressBookProtosPOJO addressBook = new AddressBookProtosPOJO();
        List<PersonPOJO> list = new ArrayList<PersonPOJO>();
        addressBook.setList(list);

        PersonPOJO pojo = new PersonPOJO();
        pojo.name = "xiemalin";
        pojo.id = 100;
        list.add(pojo);

        byte[] bytes = simpleMapPojoCodec.encode(addressBook);
        return bytes;
    }

    @Test
    public void testGetDescriptor() throws IOException {
        Descriptor descriptor2 = AddressBookProtos.AddressBook.getDescriptor();

        FieldDescriptor stringMapFD = descriptor2.findFieldByName("person");
        byte[] bytes = getProtoBytes2();
        DynamicMessage parseFrom = DynamicMessage.parseFrom(descriptor2, bytes);
        Object field = parseFrom.getField(stringMapFD);
        Assert.assertTrue(field instanceof List);
        
        Codec<AddressBookProtosPOJO> codec = ProtobufProxy.create(AddressBookProtosPOJO.class, false);
        Descriptor descriptor = codec.getDescriptor();
        
        stringMapFD = descriptor.findFieldByName("list");

        bytes = getProtoBytes2();

        parseFrom = DynamicMessage.parseFrom(descriptor, bytes);

        Object field2 = parseFrom.getField(stringMapFD);
        Assert.assertTrue(field2 instanceof List);

    }
}
