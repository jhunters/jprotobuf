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
package com.baidu.bjf.remoting.protobuf.ignore;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

/**
 * The Class IngoredAnnotationTests.
 *
 * @author xiemalin
 * @since 1.11.6
 */
public class IgnoredAnnotationTests {

    
    /**
     * Test ingored POJO class.
     */
    @Test
    public void testProxybufProxyOnIngoredPOJOClass() {
        Codec<IgnoredPOJOClass> codec = ProtobufProxy.create(IgnoredPOJOClass.class);
        Assert.assertNull(codec);
    }
    
    /**
     * Test ingored POJO class 2.
     */
    @Test
    public void testProxybufProxyOnIngoredPOJOClass2() {
        Codec<IgnoredPOJOClass2> codec = ProtobufProxy.create(IgnoredPOJOClass2.class);
        Assert.assertNull(codec);
    }
    
    /**
     * Test protobuf IDL generator on ingored POJO class.
     */
    @Test
    public void testProtobufIDLGeneratorOnIngoredPOJOClass() {
        String idl = ProtobufIDLGenerator.getIDL(IgnoredPOJOClass.class);
        Assert.assertNull(idl);
    }
    
    /**
     * Test protobuf IDL generator on ingored POJO class 2.
     */
    @Test
    public void testProtobufIDLGeneratorOnIngoredPOJOClass2() {
        String idl = ProtobufIDLGenerator.getIDL(IgnoredPOJOClass2.class);
        Assert.assertNull(idl);
    }
}
