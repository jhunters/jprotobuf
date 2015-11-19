/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.simplestring;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage;

/**
 *
 * @author xiemalin
 *
 */
public class StringTypeClassTest {

    @Test
    public void testEncodeDecode() {
        
        StringMessage message = StringMessage.newBuilder().setList("你好!").build();
        
        byte[] byteArray = message.toByteArray();
        System.out.println(Arrays.toString(byteArray));
        
        StringTypePOJOClass pojo = new StringTypePOJOClass();
        pojo.setStr("你好!");
        
        Codec codec = ProtobufProxy.create(StringTypePOJOClass.class);
        try {
            byte[] bb = codec.encode(pojo);
            System.out.println(Arrays.toString(bb));
            Assert.assertArrayEquals(byteArray, bb);
            
            StringTypePOJOClass newPojo = (StringTypePOJOClass) codec.decode(bb);
            System.out.println(newPojo.getStr());
            Assert.assertEquals("你好!", newPojo.getStr());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
