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

import junit.framework.Assert;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedTypeWithLargeIndex.InterClassName;

/**
 *
 * @author xiemalin
 * @since 1.2.6
 */
public class RequrieRepeatedDojoClassWithLargeIndexTest {
    
    
    private byte[] decodeByJprotobuf() throws IOException {
        Codec codec = ProtobufProxy.create(RequrieRepeatedDojoClassWithLargeIndex.class);
        
        RequrieRepeatedDojoClassWithLargeIndex pojo = new RequrieRepeatedDojoClassWithLargeIndex();
        pojo.list = new ArrayList<String>(2);
        pojo.list.add("hello");
        pojo.list.add("world");
        
        System.out.println(codec.size(pojo));
        
        byte[] byteArray = codec.encode(pojo);
        
        return byteArray;
    }
    
    private void encodeByJprotobuf(byte[] byteArray) throws IOException {
        Codec codec = ProtobufProxy.create(RequrieRepeatedDojoClassWithLargeIndex.class);
        
        RequrieRepeatedDojoClassWithLargeIndex decodedPojo = (RequrieRepeatedDojoClassWithLargeIndex) codec.decode(byteArray);
        Assert.assertEquals(2, decodedPojo.list.size());
        
        Assert.assertEquals("hello", decodedPojo.list.get(0));
        Assert.assertEquals("world", decodedPojo.list.get(1));
    }

    private byte[] decodeByprotobuf() throws IOException {
        
        InterClassName icn = InterClassName.newBuilder().addList("hello").addList("world").build();
        return icn.toByteArray();
    }
    
    private void encodeByprotobuf(byte[] byteArray) throws IOException {
        InterClassName icn = InterClassName.parseFrom(byteArray);
        
        Assert.assertEquals(2, icn.getListCount());
        
        Assert.assertEquals("hello", icn.getList(0));
        Assert.assertEquals("world", icn.getList(1));
    }
    
    @Test
    public void testListStringWithLargeIndex() throws IOException {
        
        byte[] byteArray = decodeByJprotobuf();
        encodeByJprotobuf(byteArray);
        encodeByprotobuf(byteArray);
    }
    
    @Test
    public void testListStringWithLargeIndex2() throws IOException {
        
        byte[] byteArray = decodeByprotobuf();
        encodeByJprotobuf(byteArray);
        encodeByprotobuf(byteArray);
    }
}
