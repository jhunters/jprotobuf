/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.simplestring;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage;
import com.google.protobuf.CodedOutputStream;

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

        Codec<StringTypePOJOClass> codec = ProtobufProxy.create(StringTypePOJOClass.class, false);
        try {
            byte[] bb = codec.encode(pojo);
            System.out.println(Arrays.toString(bb));
            Assert.assertArrayEquals(byteArray, bb);

            StringTypePOJOClass newPojo = codec.decode(bb);
            System.out.println(newPojo.getStr());
            Assert.assertEquals("你好!", newPojo.getStr());

            OutputStream os = new ByteArrayOutputStream();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(os);
            codec.writeTo(newPojo, newInstance);
            newInstance.flush();
            System.out.println(os.toString());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
