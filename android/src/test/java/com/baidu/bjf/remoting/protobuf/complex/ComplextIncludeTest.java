/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.complex;

import java.io.IOException;
import java.util.Arrays;

import junit.framework.Assert;

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
        System.out.println(bb.length);
        
        Codec codec = ProtobufProxy.create(AddressBookProtosPOJO.class);
        
        AddressBookProtosPOJO pojo = new AddressBookProtosPOJO();
        
        PersonPOJO person = new PersonPOJO();
        person.name = "xiemalin";
        person.id = 100;
        person.boolF = true;
        person.bytesF = new byte[]{1,2};
        person.email = "xiemalin@baidu.com";
        
        pojo.list = person;
        
        
        bb =  null;
        try {
        	System.out.println(codec.size(pojo));
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

    }

}
