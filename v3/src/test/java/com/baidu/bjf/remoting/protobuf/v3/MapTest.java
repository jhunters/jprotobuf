/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
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

        Codec<AddressBookPOJO> codec = ProtobufProxy.create(AddressBookPOJO.class, true);

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
