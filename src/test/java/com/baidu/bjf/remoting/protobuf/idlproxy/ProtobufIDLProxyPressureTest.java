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
package com.baidu.bjf.remoting.protobuf.idlproxy;

import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.IDLProxyObject;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJOWithDefault;
import com.baidu.bjf.remoting.protobuf.complex.PersonPOJO;
import com.baidu.bjf.remoting.protobuf.complex.PersonPOJOWithDefault;

/**
 * Test class for {@link ProtobufIDLProxy}
 * 
 * @author xiemalin
 * @since 1.0.8
 */
public class ProtobufIDLProxyPressureTest {

    int times = 500;

    @Test
    public void testPressureWithCached() throws IOException {
        String code = ProtobufIDLGenerator.getIDL(AddressBookProtosPOJOWithDefault.class);
        Map<String, IDLProxyObject> idlProxyObjects = ProtobufIDLProxy.create(code, false, null, false);

        IDLProxyObject idlProxyObject = idlProxyObjects.get(AddressBookProtosPOJOWithDefault.class.getSimpleName());

        testPressureOfCacheControl(idlProxyObject, true);
    }

    @Test
    public void testPressureWithoutCached() throws IOException {
        String code = ProtobufIDLGenerator.getIDL(AddressBookProtosPOJO.class);
        Map<String, IDLProxyObject> idlProxyObjects = ProtobufIDLProxy.create(code, false, null, false);

        IDLProxyObject idlProxyObject = idlProxyObjects.get(AddressBookProtosPOJO.class.getSimpleName());

        testPressureOfCacheControl(idlProxyObject, false);
    }

    @Test
    public void testSimplePressureWithCached() throws IOException {
        String code = ProtobufIDLGenerator.getIDL(PersonPOJOWithDefault.class);
        Map<String, IDLProxyObject> idlProxyObjects = ProtobufIDLProxy.create(code, false, null, false);

        IDLProxyObject idlProxyObject = idlProxyObjects.get(PersonPOJOWithDefault.class.getSimpleName());

        testSimpleObjectPressureOfCacheControl(idlProxyObject, true);
    }

    @Test
    public void testSimplePressureWithoutCached() throws IOException {
        String code = ProtobufIDLGenerator.getIDL(PersonPOJO.class);
        Map<String, IDLProxyObject> idlProxyObjects = ProtobufIDLProxy.create(code);

        IDLProxyObject idlProxyObject = idlProxyObjects.get(PersonPOJO.class.getSimpleName());

        testSimpleObjectPressureOfCacheControl(idlProxyObject, false);
    }

    private void testSimpleObjectPressureOfCacheControl(IDLProxyObject idlProxyObject, boolean cached)
            throws IOException {

        idlProxyObject.setCached(cached);
        long averageDecode = 0;
        long averageEncode = 0;
        for (int i = 0; i < times; i++) {
            idlProxyObject.put("name", "hello");
            idlProxyObject.put("id", i);

            try {
                idlProxyObject.put("notexitfield", null);
                Assert.fail();
            } catch (Exception e) {
                Assert.assertNotNull(e);
            }

            long time = System.currentTimeMillis();
            byte[] bb = idlProxyObject.encode();
            averageEncode += System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            IDLProxyObject newObject = idlProxyObject.decode(bb);
            averageDecode += System.currentTimeMillis() - time;

            Assert.assertEquals("hello", newObject.get("name"));
            Assert.assertEquals(i, newObject.get("id"));

        }

    }

    private void testPressureOfCacheControl(IDLProxyObject idlProxyObject, boolean cached) throws IOException {

        idlProxyObject.setCached(cached);
        long averageDecode = 0;
        long averageEncode = 0;
        for (int i = 0; i < times; i++) {
            idlProxyObject.put("name", "hello");
            idlProxyObject.put("list.name", "yes");
            idlProxyObject.put("list.id", 10);

            /*
             * try { idlProxyObject.put("notexitfield", null); Assert.fail(); }
             * catch (Exception e) { Assert.assertNotNull(e); }
             */
            long time = System.currentTimeMillis();
            byte[] bb = idlProxyObject.encode();
            averageEncode += System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            IDLProxyObject newObject = idlProxyObject.decode(bb);
            averageDecode += System.currentTimeMillis() - time;

            Assert.assertEquals("hello", newObject.get("name"));
            Assert.assertEquals("yes", newObject.get("list.name"));

        }

    }
}
