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
import java.util.HashSet;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import junit.framework.Assert;

/**
 * The Class StringSetTest.
 *
 * @author xiemalin
 * @since 3.4.0
 */
public class StringSetTest {

    
    @Test
    public void testStringSetPOJO() {
        Codec<StringSetDojoClass> codec = ProtobufProxy.create(StringSetDojoClass.class, false);
        
        StringSetDojoClass stringSet = new StringSetDojoClass();
        stringSet.list = new HashSet<String>();
        
        stringSet.list.add("hello");
        stringSet.list.add("world");
        stringSet.list.add("xiemalin");
        
        
        try {
            byte[] bs = codec.encode(stringSet);
            StringSetDojoClass stringSetDojoClass = codec.decode(bs);
            Assert.assertEquals(3, stringSetDojoClass.list.size());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
