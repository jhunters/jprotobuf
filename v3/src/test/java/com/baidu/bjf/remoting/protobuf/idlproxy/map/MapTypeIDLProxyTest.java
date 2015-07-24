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
package com.baidu.bjf.remoting.protobuf.idlproxy.map;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.IDLProxyObject;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import junit.framework.Assert;

/**
 * Test class for map type from google protocol buffer v3 
 * 
 * @author xiemalin
 * @since 2.0.0
 */
public class MapTypeIDLProxyTest {

    @Ignore
    @Test
    public void testSimpleMap() throws IOException {
        InputStream is = MapTypeIDLProxyTest.class.getResourceAsStream("simple-map.proto");
        IDLProxyObject idlProxyMap = ProtobufIDLProxy.createSingle(is, true);
        
        
        idlProxyMap.put("name", "hello");
        Map<String, String> map = new HashMap<>();
        
        map.put("hello", "world");
        idlProxyMap.put("stringMap", map);
        
        byte[] bytes = idlProxyMap.encode();
        
        Codec<SimpleMapPOJO> codec = ProtobufProxy.create(SimpleMapPOJO.class);
        SimpleMapPOJO simpleMapPOJO = codec.decode(bytes);
        Assert.assertEquals("hello", simpleMapPOJO.name);
        Assert.assertEquals(1, simpleMapPOJO.getStringMap().size());
    }
    
}
