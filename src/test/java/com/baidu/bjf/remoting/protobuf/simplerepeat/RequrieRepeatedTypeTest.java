/*
 * Copyright (c) Baidu Inc. All rights reserved.
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName;



public class RequrieRepeatedTypeTest {
    
    @Test
    public void testDecodeListFields2() throws IOException {
        InterClassName icn = InterClassName.newBuilder().addList("abc").build();
        byte[] byteArray = icn.toByteArray();
        
        Codec<RequrieRepeatedDojoClass2> create = ProtobufProxy.create(RequrieRepeatedDojoClass2.class);
        RequrieRepeatedDojoClass2 decode = create.decode(byteArray);
        
        Assert.assertEquals(1, decode.getList().size());
        Assert.assertEquals("abc", decode.getList().get(0)); 
    }
    
    @Test
    public void testEncodeListFields2() throws IOException {
        
        
        Codec<RequrieRepeatedDojoClass2> create = ProtobufProxy.create(RequrieRepeatedDojoClass2.class);
        
        
        RequrieRepeatedDojoClass2 dc = new RequrieRepeatedDojoClass2();
        dc.setList( new ArrayList<String>());
        dc.getList().add("abc");
        
        byte[] bb = create.encode(dc);
        
        InterClassName parseFrom = InterClassName.parseFrom(bb);
        List<String> listList = parseFrom.getListList();
        
        Assert.assertEquals(1, listList.size());
        Assert.assertEquals("abc", listList.get(0));
        
        
    }
 
    @Test
    public void testDecodeListFields3() throws IOException {
        InterClassName icn = InterClassName.newBuilder().addList("abc").build();
        byte[] byteArray = icn.toByteArray();
        
        Codec<RequrieRepeatedDojoClass3> create = ProtobufProxy.create(RequrieRepeatedDojoClass3.class);
        RequrieRepeatedDojoClass3 decode = create.decode(byteArray);
        
        Assert.assertEquals(1, decode.getList().size());
        Assert.assertEquals("abc", decode.getList().get(0)); 
    }
    
    @Test
    public void testEncodeListFields3() throws IOException {
        
        
        Codec<RequrieRepeatedDojoClass3> create = ProtobufProxy.create(RequrieRepeatedDojoClass3.class);
        
        
        RequrieRepeatedDojoClass3 dc = new RequrieRepeatedDojoClass3();
        dc.setList( new ArrayList<String>());
        dc.getList().add("abc");
        
        byte[] bb = create.encode(dc);
        
        InterClassName parseFrom = InterClassName.parseFrom(bb);
        List<String> listList = parseFrom.getListList();
        
        Assert.assertEquals(1, listList.size());
        Assert.assertEquals("abc", listList.get(0));
        
        
    }
    
    
    @Test
    public void testDecodeListFields() throws IOException {
        InterClassName icn = InterClassName.newBuilder().addList("abc").build();
        byte[] byteArray = icn.toByteArray();
        
        Codec<RequrieRepeatedDojoClass> create = ProtobufProxy.create(RequrieRepeatedDojoClass.class);
        RequrieRepeatedDojoClass decode = create.decode(byteArray);
        
        Assert.assertEquals(1, decode.list.size());
        Assert.assertEquals("abc", decode.list.get(0));
    }

    
    @Test
    public void testEncodeListFields() throws IOException {
        
        
        Codec<RequrieRepeatedDojoClass> create = ProtobufProxy.create(RequrieRepeatedDojoClass.class);
        
        
        RequrieRepeatedDojoClass dc = new RequrieRepeatedDojoClass();
        dc.list = new ArrayList<String>();
        dc.list.add("abc");
        
        byte[] bb = create.encode(dc);
        
        InterClassName parseFrom = InterClassName.parseFrom(bb);
        List<String> listList = parseFrom.getListList();
        
        Assert.assertEquals(1, listList.size());
        Assert.assertEquals("abc", listList.get(0));
        
        
    }
}
