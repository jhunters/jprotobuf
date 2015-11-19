/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.simplerepeat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName;

/**
 * RequrieRepeatedNumberType2Test
 * @author xiemalin
 * @since 1.0
 */
public class RequrieRepeatedNumberType2Test {

    @Test
    public void testEncodeDecode() {
        
        InterClassName icn = InterClassName.newBuilder().addList1(10000).addList1(20000).build();
        
        byte[] oldbb = icn.toByteArray();
        System.out.println(Arrays.toString(oldbb));
        
        
        RequrieRepeatedNumberTypePOJOClass2 type = new RequrieRepeatedNumberTypePOJOClass2();
        
        type.list1 = new ArrayList<Integer>();
        type.list1.add(10000);
        type.list1.add(20000);
        
        
        Codec proxy;
        proxy = ProtobufProxy.create(RequrieRepeatedNumberTypePOJOClass2.class);
        try {
            byte[] bb = proxy.encode(type);
            Assert.assertArrayEquals(oldbb, bb);
            System.out.println(Arrays.toString(bb));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
