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
package com.baidu.bjf.remoting.protobuf.simplestring;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage;

/**
 * The Class StringTypeClassTest.
 *
 * @author xiemalin
 */
public class StringTypeClassTest {

    /**
     * Test encode decode.
     */
    @Test
    public void testEncodeDecode() {
        
        StringMessage message = StringMessage.newBuilder().setList("你好!").build();
        
        byte[] byteArray = message.toByteArray();
        System.out.println(Arrays.toString(byteArray));
        
        StringTypePOJOClass pojo = new StringTypePOJOClass();
        pojo.setStr("你好!");
        
        Codec<StringTypePOJOClass> codec = ProtobufProxy.create(StringTypePOJOClass.class);
        try {
            byte[] bb = codec.encode(pojo);
            System.out.println(Arrays.toString(bb));
            Assert.assertArrayEquals(byteArray, bb);
            
            StringTypePOJOClass newPojo = codec.decode(bb);
            System.out.println(newPojo.getStr());
            Assert.assertEquals("你好!", newPojo.getStr());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
