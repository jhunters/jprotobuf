/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
 * The Class RequrieRepeatedDojoClassWithLargeIndexTest.
 *
 * @author xiemalin
 * @since 1.2.6
 */
public class RequrieRepeatedDojoClassWithLargeIndexTest {
    
    
    /**
     * Decode by jprotobuf.
     *
     * @return the byte[]
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private byte[] decodeByJprotobuf() throws IOException {
        Codec<RequrieRepeatedDojoClassWithLargeIndex> codec = ProtobufProxy.create(RequrieRepeatedDojoClassWithLargeIndex.class);
        
        RequrieRepeatedDojoClassWithLargeIndex pojo = new RequrieRepeatedDojoClassWithLargeIndex();
        pojo.list = new ArrayList<String>(2);
        pojo.list.add("hello");
        pojo.list.add("world");
        
        byte[] byteArray = codec.encode(pojo);
        
        return byteArray;
    }
    
    /**
     * Encode by jprotobuf.
     *
     * @param byteArray the byte array
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void encodeByJprotobuf(byte[] byteArray) throws IOException {
        Codec<RequrieRepeatedDojoClassWithLargeIndex> codec = ProtobufProxy.create(RequrieRepeatedDojoClassWithLargeIndex.class);
        
        RequrieRepeatedDojoClassWithLargeIndex decodedPojo = codec.decode(byteArray);
        Assert.assertEquals(2, decodedPojo.list.size());
        
        Assert.assertEquals("hello", decodedPojo.list.get(0));
        Assert.assertEquals("world", decodedPojo.list.get(1));
    }

    /**
     * Decode by protobuf.
     *
     * @return the byte[]
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private byte[] decodeByprotobuf() throws IOException {
        
        InterClassName icn = InterClassName.newBuilder().addList("hello").addList("world").build();
        return icn.toByteArray();
    }
    
    /**
     * Encode by protobuf.
     *
     * @param byteArray the byte array
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void encodeByprotobuf(byte[] byteArray) throws IOException {
        InterClassName icn = InterClassName.parseFrom(byteArray);
        
        Assert.assertEquals(2, icn.getListCount());
        
        Assert.assertEquals("hello", icn.getList(0));
        Assert.assertEquals("world", icn.getList(1));
    }
    
    /**
     * Test list string with large index.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testListStringWithLargeIndex() throws IOException {
        
        byte[] byteArray = decodeByJprotobuf();
        encodeByJprotobuf(byteArray);
        encodeByprotobuf(byteArray);
    }
    
    /**
     * Test list string with large index2.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testListStringWithLargeIndex2() throws IOException {
        
        byte[] byteArray = decodeByprotobuf();
        encodeByJprotobuf(byteArray);
        encodeByprotobuf(byteArray);
    }
}
