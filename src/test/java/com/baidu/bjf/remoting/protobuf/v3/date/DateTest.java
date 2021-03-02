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
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person;
import com.google.protobuf.Timestamp;

/**
 * The Class DateTest.
 */
public class DateTest {

    /**
     * Test date encode with orignal PB class.
     */
    @Test
    public void testDateEncodeWithOrignalPBClass() {

        long secs = System.currentTimeMillis() / 1000;
        int nanos = (int) (System.currentTimeMillis() % 1000) * 1000000;

        Timestamp ts = Timestamp.newBuilder().setSeconds(secs).setNanos(nanos).build();

        Person person = Person.newBuilder().setTs(ts).build();

        byte[] byteArray = person.toByteArray();

        String expected = Arrays.toString(byteArray);

        DatePOJO datePojo = new DatePOJO();
        com.baidu.bjf.remoting.protobuf.Timestamp ts2 = new com.baidu.bjf.remoting.protobuf.Timestamp();
        ts2.setSeconds(secs);
        ts2.setNanos(nanos);
        datePojo.setTimeStamp(ts2);

        Codec<DatePOJO> codec = ProtobufProxy.create(DatePOJO.class);
        try {
            byte[] encode = codec.encode(datePojo);
            String actual = Arrays.toString(encode);
            DatePOJO decode = codec.decode(byteArray);
            Assert.assertEquals(expected, actual);
            Assert.assertEquals(decode.getTimeStamp().getSeconds().longValue(), person.getTs().getSeconds());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Test time stamp.
     */
    @Test
    public void testTimeStamp() {
        long secs = System.currentTimeMillis() / 1000;
        int nanos = (int) (System.currentTimeMillis() % 1000) * 1000000;

        Timestamp ts = Timestamp.newBuilder().setSeconds(secs).setNanos(nanos).build();

        com.baidu.bjf.remoting.protobuf.Timestamp ts2 = new com.baidu.bjf.remoting.protobuf.Timestamp();
        ts2.setSeconds(secs);
        ts2.setNanos(nanos);

        Codec<com.baidu.bjf.remoting.protobuf.Timestamp> codec =
                ProtobufProxy.create(com.baidu.bjf.remoting.protobuf.Timestamp.class);

        try {
            byte[] encode = codec.encode(ts2);
            Assert.assertEquals(Arrays.toString(encode), Arrays.toString(ts.toByteArray()));
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

}
