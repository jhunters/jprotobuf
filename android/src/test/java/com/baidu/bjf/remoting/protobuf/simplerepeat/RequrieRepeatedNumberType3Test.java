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
 *
 * @author xiemalin
 *
 */
public class RequrieRepeatedNumberType3Test {

    @Test
    public void testEncodeDecode() {
        
        InterClassName icn = InterClassName.newBuilder().addList2(10000D).addList2(20000.1D).build();
        
        byte[] oldbb = icn.toByteArray();
        System.out.println(Arrays.toString(oldbb));
        
        
        RequrieRepeatedNumberTypePOJOClass3 type = new RequrieRepeatedNumberTypePOJOClass3();
        
        type.list2 = new ArrayList<Double>();
        type.list2.add(10000D);
        type.list2.add(20000.1D);
        
        
        Codec proxy = ProtobufProxy.create(RequrieRepeatedNumberTypePOJOClass3.class);
        try {
            byte[] bb = proxy.encode(type);
            System.out.println(Arrays.toString(bb));
            Assert.assertArrayEquals(oldbb, bb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
