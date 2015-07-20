/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.v3.complexmap;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person;

/**
 * Complex map usage test for encode/decode
 * 
 * @author xiemalin
 * @since 2.0.0
 */
public class ComplexMapTest {

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
        Assert.assertEquals(pojo.phoneTypeEnumValueMap.get("a").name(), person.getPhoneTypeEnumValueMap().get("a")
                .name());

        Assert.assertEquals(pojo.phoneNumberObjectValueMap.size(), person.getPhoneNumberObjectValueMap().size());

        Assert.assertEquals(pojo.phoneNumberObjectValueMap.get("key1").number, 
                person.getPhoneNumberObjectValueMap().get("key1").getNumber());
    }

}
