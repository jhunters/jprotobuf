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
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Test all single field class encode and decode.
 *
 * @author xiemalin
 * @since 1.0.9
 */
public class ByteTypeTest {
    
    /**
     * The Class A.
     */
    public static class A {
        
        /** The a. */
        @Protobuf
        private int a;
        
        /** The b. */
        @Protobuf
        private long b;
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        A a = new A();
        a.a = 100;
        a.b = 200;
        
        Codec<A> codec = ProtobufProxy.create(A.class);
        try {
            byte[] encode = codec.encode(a);
            System.out.println(Arrays.toString(encode));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    /**
     * Test type class1.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testTypeClass1() throws IOException  {
        Codec<ByteTypeClass1> codec = ProtobufProxy.create(ByteTypeClass1.class);
        
        ByteTypeClass1 o = new ByteTypeClass1();
        byte[] bb = codec.encode(o);
        
        ByteTypeClass1 class1 = codec.decode(bb);
    }
    
    /**
     * Test type class4.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testTypeClass4() throws IOException  {
        Codec<ByteTypeClass4> codec = ProtobufProxy.create(ByteTypeClass4.class);
        
        ByteTypeClass4 o = new ByteTypeClass4();
        byte[] bb = codec.encode(o);
        
        ByteTypeClass4 class1 = codec.decode(bb);
    }
    
    /**
     * Test type class2.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testTypeClass2() throws IOException  {
        Codec<ByteTypeClass2> codec = ProtobufProxy.create(ByteTypeClass2.class);
        
        ByteTypeClass2 o = new ByteTypeClass2();
        o.bytes = new byte[] {1, 2};
        byte[] bb = codec.encode(o);
        
        ByteTypeClass2 class1 = codec.decode(bb);
        Assert.assertArrayEquals(o.bytes, class1.bytes);
    }
    
    /**
     * Test type class3.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Test
    public void testTypeClass3() throws IOException  {
        Codec<ByteTypeClass3> codec = ProtobufProxy.create(ByteTypeClass3.class);
        
        ByteTypeClass3 o = new ByteTypeClass3();
        o.setBytes(new byte[] {1, 2});
        byte[] bb = codec.encode(o);
        
        ByteTypeClass3 class1 = codec.decode(bb);
        Assert.assertArrayEquals(o.getBytes(), class1.getBytes());
    }
    
}
