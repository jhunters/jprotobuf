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
package com.baidu.bjf.remoting.protobuf.v3;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person;
import com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person.Builder;

/**
 * Map test
 * 
 * @author xiemalin
 * @since 2.0.0
 */
public class MapTest {

    @Test
    public void testMap() throws Exception {

        Codec<AddressBookPOJO> codec = ProtobufProxy.create(AddressBookPOJO.class);

        Builder builder = AddressBookProtos.Person.newBuilder();

        builder = builder.setName("matthew");

        builder.getMutableValues().put("a", "b");
        builder.getMutableValues().put("c", "d");

        Person person = builder.build();
        
        System.out.println(person.getSerializedSize());

        byte[] byteArray = person.toByteArray();

        Person p = Person.parseFrom(byteArray);

        System.out.println(p.getValues());

        AddressBookPOJO decode = codec.decode(byteArray);
        
        System.out.println(decode.map);
        
        System.out.println(codec.size(decode));
        
        byte[] newBytes = codec.encode(decode);
        Person parseFrom = AddressBookProtos.Person.parseFrom(newBytes);
        System.out.println(parseFrom);
    }
}
