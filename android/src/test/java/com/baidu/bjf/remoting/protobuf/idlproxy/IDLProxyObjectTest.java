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
package com.baidu.bjf.remoting.protobuf.idlproxy;

import junit.framework.Assert;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.IDLProxyObject;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

/**
 * IDLProxyObjectTest
 *
 * @author xiemalin
 * @since 1.0.6
 */
public class IDLProxyObjectTest {

    @Test
    public void testSimplePOJO() {
        
        Codec codec = ProtobufProxy.create(SimplePOJO.class);
        
        SimplePOJO  target = new SimplePOJO();
        
        IDLProxyObject idlProxyObject = new IDLProxyObject(codec, target, SimplePOJO.class);
        
        idlProxyObject.put("name", "hello");
        Assert.assertEquals("hello", idlProxyObject.get("name"));
        Assert.assertEquals("hello", target.getName());
        Assert.assertEquals("hello", ((SimplePOJO) idlProxyObject.getTarget()).getName());
        
        
        idlProxyObject.put("age", 100);
        Assert.assertEquals(100, idlProxyObject.get("age"));
        Assert.assertEquals(100, target.getAge());
        Assert.assertEquals(100, ((SimplePOJO) idlProxyObject.getTarget()).getAge());
    }
    
    @Test
    public void testComplexPOJO() {
        Codec codec = ProtobufProxy.create(ComplexPOJO.class);
        
        ComplexPOJO  target = new ComplexPOJO();
        
        IDLProxyObject idlProxyObject = new IDLProxyObject(codec, target, ComplexPOJO.class);
        
        idlProxyObject.put("name", "hello");
        Assert.assertEquals("hello", idlProxyObject.get("name"));
        Assert.assertEquals("hello", target.getName());
        Assert.assertEquals("hello", ((ComplexPOJO) idlProxyObject.getTarget()).getName());
        
        
        idlProxyObject.put("age", 100);
        Assert.assertEquals(100, idlProxyObject.get("age"));
        Assert.assertEquals(100, target.getAge());
        Assert.assertEquals(100, ((ComplexPOJO) idlProxyObject.getTarget()).getAge());
        
        //test sub
        idlProxyObject.put("simplePOJO.name", "hello");
        Assert.assertEquals("hello", idlProxyObject.get("simplePOJO.name"));
        Assert.assertEquals("hello", target.getSimplePOJO().getName());
        Assert.assertEquals("hello", ((ComplexPOJO) idlProxyObject.getTarget()).getSimplePOJO().getName());
    }
}
