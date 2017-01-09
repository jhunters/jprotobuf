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
package com.baidu.bjf.remoting.protobuf.enumeration;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal;


/**
 * Test class for enum type.
 *
 * @author xiemalin
 * @since 1.4.0
 */
public class EnumClassTest {

    /**
     * Test enum.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testEnum() throws IOException {
        
        
        Codec<EnumPOJOClass> codec = ProtobufProxy.create(EnumPOJOClass.class);
        EnumPOJOClass ec = new EnumPOJOClass();
        ec.enumAttr = EnumAttrPOJO.INT;
        
        byte[] bytes = codec.encode(ec);
        
        EnumPOJOClass decode = codec.decode(bytes);
        Assert.assertEquals(EnumAttrPOJO.INT, decode.enumAttr);
        
        byte[] byteArray = EnumClassInternal.newBuilder().setStatus(
                com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.INT).build().toByteArray();
        Assert.assertArrayEquals(bytes, byteArray);
        
        EnumClassInternal enumClass = com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.parseFrom(bytes);
 
        Assert.assertEquals(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.INT, enumClass.getStatus());
        
        // process default
        decode = codec.decode(new byte[0]);
        Assert.assertEquals(EnumAttrPOJO.STRING, decode.enumAttr);
    }
    
    /**
     * Test enum2.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testEnum2() throws IOException {
        
        
        Codec<EnumPOJOClass2> codec = ProtobufProxy.create(EnumPOJOClass2.class);
        EnumPOJOClass2 ec = new EnumPOJOClass2();
        ec.setEnumAttr(EnumAttrPOJO.INT);
        
        byte[] bytes = codec.encode(ec);
        EnumPOJOClass2 decode = codec.decode(bytes);
        Assert.assertEquals(EnumAttrPOJO.INT, decode.getEnumAttr());
        
        byte[] byteArray = EnumClassInternal.newBuilder().setStatus(
                com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.INT).build().toByteArray();
        Assert.assertArrayEquals(bytes, byteArray);
        EnumClassInternal enumClass = com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.parseFrom(bytes);
 
        Assert.assertEquals(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.INT, enumClass.getStatus());
    }
}
