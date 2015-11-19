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
package com.baidu.bjf.remoting.protobuf.bytestest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

/**
 * Test all single field class encode and decode
 * 
 * @author xiemalin
 * @since 1.0.9
 */
public class ByteTypeTest {

    @Test
    public void testTypeClass1() throws IOException  {
        Codec codec = ProtobufProxy.create(ByteTypeClass1.class);
        
        ByteTypeClass1 o = new ByteTypeClass1();
        byte[] bb = codec.encode(o);
        
        ByteTypeClass1 class1 = (ByteTypeClass1) codec.decode(bb);
    }
    
    @Test
    public void testTypeClass4() throws IOException  {
        Codec<ByteTypeClass4> codec = ProtobufProxy.create(ByteTypeClass4.class);
        
        ByteTypeClass4 o = new ByteTypeClass4();
        byte[] bb = codec.encode(o);
        
        ByteTypeClass4 class1 =  codec.decode(bb);
    }
    
    @Test
    public void testTypeClass2() throws IOException  {
        Codec codec = ProtobufProxy.create(ByteTypeClass2.class);
        
        ByteTypeClass2 o = new ByteTypeClass2();
        o.bytes = new byte[] {1, 2};
        byte[] bb = codec.encode(o);
        
        ByteTypeClass2 class1 = (ByteTypeClass2) codec.decode(bb);
        Assert.assertArrayEquals(o.bytes, class1.bytes);
    }
    
    @Test
    public void testTypeClass3() throws IOException  {
        Codec codec = ProtobufProxy.create(ByteTypeClass3.class);
        
        ByteTypeClass3 o = new ByteTypeClass3();
        o.setBytes(new byte[] {1, 2});
        byte[] bb = codec.encode(o);
        
        ByteTypeClass3 class1 = (ByteTypeClass3) codec.decode(bb);
        Assert.assertArrayEquals(o.getBytes(), class1.getBytes());
    }
    
}
