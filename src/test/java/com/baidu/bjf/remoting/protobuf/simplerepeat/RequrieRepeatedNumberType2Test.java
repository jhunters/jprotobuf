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
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName;

/**
 * RequrieRepeatedNumberType2Test
 * @author xiemalin
 * @since 1.0
 */
public class RequrieRepeatedNumberType2Test {

    @Test
    public void testEncodeDecode() {
        
        InterClassName icn = InterClassName.newBuilder().addList1(10000).addList1(20000).build();
        
        byte[] oldbb = icn.toByteArray();
        System.out.println(Arrays.toString(oldbb));
        
        
        RequrieRepeatedNumberTypePOJOClass2 type = new RequrieRepeatedNumberTypePOJOClass2();
        
        type.list1 = new ArrayList<Integer>();
        type.list1.add(10000);
        type.list1.add(20000);
        
        
        Codec<RequrieRepeatedNumberTypePOJOClass2> proxy;
        proxy = ProtobufProxy.create(RequrieRepeatedNumberTypePOJOClass2.class, false);
        try {
            byte[] bb = proxy.encode(type);
            Assert.assertArrayEquals(oldbb, bb);
            System.out.println(Arrays.toString(bb));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
