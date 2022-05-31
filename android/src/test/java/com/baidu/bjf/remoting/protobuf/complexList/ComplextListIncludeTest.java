/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.complexList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos.AddressBook;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos.Person;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos.TypeDef;
import com.google.protobuf.InvalidProtocolBufferException;

import junit.framework.Assert;

/**
 * 
 * @author xiemalin
 * 
 */
public class ComplextListIncludeTest {

    /**
     * test encode and decode with JProtobuf and Protobuf java
     */
    @Test
    public void testEncodeDecode() {

        // protobuf -> jprotobuf
        Person p = Person.newBuilder().setName("xiemalin").setId(100).build();

        AddressBook book = AddressBook.newBuilder().addPerson(p).addPerson(p).addTypeDef(TypeDef.DECIMAL)
                .addTypeDef(TypeDef.URL).build();

        byte[] bb = book.toByteArray();

        Codec codec = ProtobufProxy.create(AddressBookProtosPOJO.class);
        try {
            AddressBookProtosPOJO decode = (AddressBookProtosPOJO) codec.decode(bb);
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
//        person.id = 100;
//        person.boolF = true;
//        person.bytesF = new byte[] { 1, 2 };
//        person.email = "xiemalin@baidu.com";

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
        
        
        try {
            AddressBookProtosPOJO decode = (AddressBookProtosPOJO) codec.decode(bb);
            Assert.assertEquals("xiemalin", decode.getList().get(0).name);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
