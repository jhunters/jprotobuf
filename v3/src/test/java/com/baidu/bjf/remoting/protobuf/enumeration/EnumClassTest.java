/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.enumeration;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal;

/**
 * Test class for enum type
 *
 * @author xiemalin
 * @since 1.4.0
 */
public class EnumClassTest {

    @Test
    public void testEnum() throws IOException {

        Codec<EnumPOJOClass> codec = ProtobufProxy.create(EnumPOJOClass.class, false);
        EnumPOJOClass ec = new EnumPOJOClass();
        ec.enumAttr = EnumAttrPOJO.INT;

        byte[] bytes = codec.encode(ec);
        System.out.println(Arrays.toString(bytes));
        EnumPOJOClass decode = codec.decode(bytes);
        Assert.assertEquals(EnumAttrPOJO.INT, decode.enumAttr);

        byte[] byteArray = EnumClassInternal.newBuilder()
                .setStatus(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.INT).build().toByteArray();
        Assert.assertArrayEquals(bytes, byteArray);

        EnumClassInternal enumClass =
                com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.parseFrom(bytes);

        Assert.assertEquals(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.INT, enumClass.getStatus());
        
        // process default
        decode = codec.decode(new byte[0]);
        Assert.assertEquals(EnumAttrPOJO.STRING, decode.enumAttr);
    }

    /**
     * Test enum notexist.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testEnumNotexist() throws IOException {
        byte[] byteArray = EnumClassInternal.newBuilder()
                .setStatus(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.NOTEXIST).build()
                .toByteArray();

        Codec<EnumPOJOClass> codec = ProtobufProxy.create(EnumPOJOClass.class);
        EnumPOJOClass decode = codec.decode(byteArray);

        Assert.assertNull(decode.enumAttr);
        
        EnumClassInternal build = EnumClassInternal.newBuilder().build();
        Assert.assertNotNull(build.getStatus());
    }

    @Test
    public void testEnumNull() throws IOException {
        Codec<EnumPOJOClass> codec = ProtobufProxy.create(EnumPOJOClass.class, true);
        
        EnumPOJOClass enumPOJOClass = new EnumPOJOClass();
        
        byte[] bs = codec.encode(enumPOJOClass);
        
        EnumPOJOClass enumPOJOClass2 = codec.decode(bs);
        
        
        Assert.assertNotNull(enumPOJOClass2.enumAttr);
    }

    @Test
    public void testEnum2() throws IOException {

        Codec<EnumPOJOClass2> codec = ProtobufProxy.create(EnumPOJOClass2.class);
        EnumPOJOClass2 ec = new EnumPOJOClass2();
        ec.setEnumAttr(EnumAttrPOJO.INT);

        byte[] bytes = codec.encode(ec);
        EnumPOJOClass2 decode = codec.decode(bytes);
        Assert.assertEquals(EnumAttrPOJO.INT, decode.getEnumAttr());

        byte[] byteArray = EnumClassInternal.newBuilder()
                .setStatus(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.INT).build().toByteArray();
        Assert.assertArrayEquals(bytes, byteArray);
        EnumClassInternal enumClass =
                com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.parseFrom(bytes);

        Assert.assertEquals(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.INT, enumClass.getStatus());
    }
}
