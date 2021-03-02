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
package com.baidu.bjf.remoting.protobuf.v3.complexmap;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person;
import com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType;

/**
 * Complex map usage test for encode/decode
 * 
 * @author xiemalin
 * @since 2.0.0
 */
public class ComplexMapTest {

    @Test
    public void testOriginalMap() {
        java.util.Map<java.lang.String, AddressBookProtos.Person.PhoneNumber> personMap;
        personMap = new HashMap<java.lang.String, AddressBookProtos.Person.PhoneNumber>();

        personMap.put("a", AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("10000000000")
                .setType(PhoneType.HOME).build());

        java.util.Map<java.lang.String, AddressBookProtos.Person.PhoneType> personTypeMap;
        personTypeMap = new HashMap<java.lang.String, AddressBookProtos.Person.PhoneType>();

        personTypeMap.put("key1", AddressBookProtos.Person.PhoneType.MOBILE);

        Person person = AddressBookProtos.Person.newBuilder().putAllPhoneNumberObjectValueMap(personMap)
                .setName("xiemalin").putAllPhoneTypeEnumValueMap(personTypeMap).build();
        
        byte[] bytes = person.toByteArray();
        System.out.println(Arrays.toString(bytes));
        
        Codec<ComplexMapPOJO> complexMapPOJOCodec = ProtobufProxy.create(ComplexMapPOJO.class, false);
        
        try {
            ComplexMapPOJO decode = complexMapPOJOCodec.decode(bytes);
            Assert.assertEquals("xiemalin", decode.name);
            Assert.assertEquals(1, decode.phoneNumberObjectValueMap.size());
            Assert.assertEquals("10000000000", decode.phoneNumberObjectValueMap.get("a").number);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void testPOJOEncode() throws IOException {

        Codec<ComplexMapPOJO> complexMapPOJOCodec = ProtobufProxy.create(ComplexMapPOJO.class, false);

        // initialize POJO value
        ComplexMapPOJO pojo = new ComplexMapPOJO();

        pojo.name = "xiemalin";

        pojo.phoneTypeEnumValueMap = new HashMap<String, PhoneTypeEnumPOJO>();
        pojo.phoneTypeEnumValueMap.put("a", PhoneTypeEnumPOJO.HOME);
        pojo.phoneTypeEnumValueMap.put("b", PhoneTypeEnumPOJO.MOBILE);
        pojo.phoneTypeEnumValueMap.put("c", PhoneTypeEnumPOJO.WORK);

        pojo.phoneNumberObjectValueMap = new HashMap<String, PhoneNumberPOJO>();

        PhoneNumberPOJO phoneNumberPOJO = new PhoneNumberPOJO();
        phoneNumberPOJO.number = "10000000000";
        phoneNumberPOJO.type = PhoneTypeEnumPOJO.MOBILE;

        pojo.phoneNumberObjectValueMap.put("key1", phoneNumberPOJO);

        byte[] bytes = complexMapPOJOCodec.encode(pojo);

        Person person = AddressBookProtos.Person.parseFrom(bytes);
        Assert.assertEquals(pojo.name, person.getName());

        Assert.assertEquals(pojo.phoneTypeEnumValueMap.size(), person.getPhoneTypeEnumValueMap().size());
        Assert.assertEquals(pojo.phoneTypeEnumValueMap.get("a").name(),
                person.getPhoneTypeEnumValueMap().get("a").name());

        Assert.assertEquals(pojo.phoneNumberObjectValueMap.size(), person.getPhoneNumberObjectValueMap().size());

        Assert.assertEquals(pojo.phoneNumberObjectValueMap.get("key1").number,
                person.getPhoneNumberObjectValueMap().get("key1").getNumber());
    }

    
    @Test
    public void testPOJOCodec() throws IOException {

        Codec<ComplexMapPOJO> complexMapPOJOCodec = ProtobufProxy.create(ComplexMapPOJO.class, false);

        // initialize POJO value
        ComplexMapPOJO pojo = new ComplexMapPOJO();

        pojo.name = "xiemalin";

        pojo.phoneTypeEnumValueMap = new HashMap<String, PhoneTypeEnumPOJO>();
        pojo.phoneTypeEnumValueMap.put("a", PhoneTypeEnumPOJO.HOME);
        pojo.phoneTypeEnumValueMap.put("b", PhoneTypeEnumPOJO.MOBILE);
        pojo.phoneTypeEnumValueMap.put("c", PhoneTypeEnumPOJO.WORK);

        pojo.phoneNumberObjectValueMap = new HashMap<String, PhoneNumberPOJO>();

        PhoneNumberPOJO phoneNumberPOJO = new PhoneNumberPOJO();
        phoneNumberPOJO.number = "10000000000";
        phoneNumberPOJO.type = PhoneTypeEnumPOJO.MOBILE;

        pojo.phoneNumberObjectValueMap.put("key1", phoneNumberPOJO);
        
        byte[] bb = new byte[] {1, 2, 3};
        byte[] bbKey = new byte[] {4, 5, 6};
        pojo.bytesMap = new HashMap<byte[], byte[]>();
        pojo.bytesMap.put(bbKey, bb);

        byte[] bytes = complexMapPOJOCodec.encode(pojo);
        
        ComplexMapPOJO decode = complexMapPOJOCodec.decode(bytes);
        Assert.assertEquals(1, decode.bytesMap.size());
        Assert.assertEquals(bb.length, decode.bytesMap.values().iterator().next().length);
        Assert.assertArrayEquals(bb, decode.bytesMap.values().iterator().next());
        
        Iterator<Entry<byte[], byte[]>> iterator = decode.bytesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey());
        }
        

    }
}
