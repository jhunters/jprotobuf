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
package com.baidu.bjf.remoting.protobuf.v3.date;

import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

/**
 * The Class SimpleDatePOJOTest.
 *
 * @author xiemalin
 * @since 3.2.1
 */
public class SimpleDatePOJOTest {

    /** The test simple date. */
    @Test
    public void testSimpleDate() {
        Codec<SimpleDatePOJO> create = ProtobufProxy.create(SimpleDatePOJO.class, false);
        
        SimpleDatePOJO pojo = new SimpleDatePOJO();
        
        pojo.setDate1(new Date());
        pojo.date = new Date();
        
        try {
            byte[] encode = create.encode(pojo);
            SimpleDatePOJO decode = create.decode(encode);
            Assert.assertEquals(pojo.getDate1().getTime(), decode.getDate1().getTime());
            Assert.assertEquals(pojo.date.getTime(), decode.date.getTime());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
    
}
