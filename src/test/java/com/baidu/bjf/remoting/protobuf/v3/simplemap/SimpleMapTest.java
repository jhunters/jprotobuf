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
package com.baidu.bjf.remoting.protobuf.v3.simplemap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.descriptor.DescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.FileDescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person;
import com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.Builder;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.TextFormat;

/**
 * 
 * Simple map test class
 *
 * @author xiemalin
 * @since 2.0.0
 */
public class SimpleMapTest {

    @Test
    public void testPOJOEncode() throws IOException {

        Codec<SimpleMapPOJO> simpleMapPojoCodec = ProtobufProxy.create(SimpleMapPOJO.class, false);

        // initialize map
        SimpleMapPOJO pojo = new SimpleMapPOJO();
        pojo.name = "xiemalin";

        Map<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("hello", "world");
        stringMap.put("welcome", "China");
        pojo.setStringMap(stringMap);

        Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        intMap.put(100, 200);
        pojo.setMyIntMap(intMap);

        pojo.longMap = new HashMap<Long, Long>();
        pojo.longMap.put(Long.MIN_VALUE, Long.MAX_VALUE);

        pojo.booleanMap = new HashMap<Boolean, Boolean>();
        pojo.booleanMap.put(Boolean.TRUE, Boolean.FALSE);

        byte[] bytes = simpleMapPojoCodec.encode(pojo);

        Assert.assertNotNull(bytes);

        // to validate
        Person person = AddressBookProtos.Person.parseFrom(bytes);

        Assert.assertEquals(pojo.name, person.getName());

        Assert.assertEquals(pojo.getStringMap(), person.getStringMap());

        Assert.assertEquals(pojo.getMyIntMap(), person.getIntMap());
        Assert.assertEquals(pojo.longMap, person.getLongMap());
        Assert.assertEquals(pojo.booleanMap, person.getBooleanMap());
    }

    @Test
    public void testPOJODecode() throws IOException {

        Builder personBuilder = AddressBookProtos.Person.newBuilder().setName("xiemalin");

        // initialize map
        personBuilder.getMutableStringMap().put("hello", "world");
        personBuilder.getMutableStringMap().put("welcome", "China");

        personBuilder.getMutableIntMap().put(100, 200);

        personBuilder.getMutableLongMap().put(Long.MIN_VALUE, Long.MAX_VALUE);
        personBuilder.getMutableBooleanMap().put(Boolean.TRUE, Boolean.FALSE);

        Person person = personBuilder.build();

        byte[] bytes = person.toByteArray();
        Assert.assertNotNull(bytes);

        Codec<SimpleMapPOJO> simpleMapPojoCodec = ProtobufProxy.create(SimpleMapPOJO.class, false);

        SimpleMapPOJO pojo = simpleMapPojoCodec.decode(bytes);

        Assert.assertEquals(pojo.name, person.getName());

        Assert.assertEquals(pojo.getStringMap(), person.getStringMap());

        Assert.assertEquals(pojo.getMyIntMap(), person.getIntMap());
        Assert.assertEquals(pojo.longMap, person.getLongMap());
        Assert.assertEquals(pojo.booleanMap, person.getBooleanMap());
    }

    @Test
    public void testProtobufDynamicParser() throws IOException {
        java.lang.String[] descriptorDataParts = { "\n\021addressbook.proto\022\"com.baidu.bjf.remot"
                + "ing.protobuf.v3\"\212\004\n\006Person\022\014\n\004name\030\001 \002(\t"
                + "\022L\n\tstringMap\030\002 \003(\01329.com.baidu.bjf.remo"
                + "ting.protobuf.v3.Person.StringMapEntry\022F"
                + "\n\006intMap\030\003 \003(\01326.com.baidu.bjf.remoting."
                + "protobuf.v3.Person.IntMapEntry\022H\n\007longMa"
                + "p\030\004 \003(\01327.com.baidu.bjf.remoting.protobu"
                + "f.v3.Person.LongMapEntry\022N\n\nbooleanMap\030\005"
                + " \003(\0132:.com.baidu.bjf.remoting.protobuf.v" + "3.Person.BooleanMapEntry\0320\n\016StringMapEnt",
                "ry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\032-\n\013In"
                        + "tMapEntry\022\013\n\003key\030\001 \001(\005\022\r\n\005value\030\002 \001(\005:\0028"
                        + "\001\032.\n\014LongMapEntry\022\013\n\003key\030\001 \001(\003\022\r\n\005value\030"
                        + "\002 \001(\003:\0028\001\0321\n\017BooleanMapEntry\022\013\n\003key\030\001 \001("
                        + "\010\022\r\n\005value\030\002 \001(\010:\0028\001BA\n,com.baidu.bjf.re"
                        + "moting.protobuf.v3.simplemapB\021AddressBoo" + "kProtos" };

        StringBuilder descriptorData = new StringBuilder();
        for (String part : descriptorDataParts) {
            descriptorData.append(part);
        }

        final byte[] descriptorBytes;
        try {
            descriptorBytes = descriptorData.toString().getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Standard encoding ISO-8859-1 not supported by JVM.", e);
        }

        Codec<FileDescriptorProtoPOJO> codec = ProtobufProxy.create(FileDescriptorProtoPOJO.class, false);

        FileDescriptorProtoPOJO fileDescriptorProtoPOJO = codec.decode(descriptorBytes);

        System.out.println(fileDescriptorProtoPOJO);

    }

    @Test
    public void testest() throws IOException {

        java.lang.String[] descriptorDataParts = { "\n\021addressbook.proto\022\"com.baidu.bjf.remot"
                + "ing.protobuf.v3\"\212\004\n\006Person\022\014\n\004name\030\001 \002(\t"
                + "\022L\n\tstringMap\030\002 \003(\01329.com.baidu.bjf.remo"
                + "ting.protobuf.v3.Person.StringMapEntry\022F"
                + "\n\006intMap\030\003 \003(\01326.com.baidu.bjf.remoting."
                + "protobuf.v3.Person.IntMapEntry\022H\n\007longMa"
                + "p\030\004 \003(\01327.com.baidu.bjf.remoting.protobu"
                + "f.v3.Person.LongMapEntry\022N\n\nbooleanMap\030\005"
                + " \003(\0132:.com.baidu.bjf.remoting.protobuf.v" + "3.Person.BooleanMapEntry\0320\n\016StringMapEnt",
                "ry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\032-\n\013In"
                        + "tMapEntry\022\013\n\003key\030\001 \001(\005\022\r\n\005value\030\002 \001(\005:\0028"
                        + "\001\032.\n\014LongMapEntry\022\013\n\003key\030\001 \001(\003\022\r\n\005value\030"
                        + "\002 \001(\003:\0028\001\0321\n\017BooleanMapEntry\022\013\n\003key\030\001 \001("
                        + "\010\022\r\n\005value\030\002 \001(\010:\0028\001BA\n,com.baidu.bjf.re"
                        + "moting.protobuf.v3.simplemapB\021AddressBoo" + "kProtos" };

        FileDescriptor fileDescriptor = AddressBookProtos.getDescriptor();

        FileDescriptorProto proto = fileDescriptor.toProto();

        byte[] byteArray = proto.toByteArray();
        // System.out.println(Arrays.toString(byteArray));
        System.out.println(StringUtils.escapeBytes((descriptorDataParts[0] + descriptorDataParts[1]).getBytes()));
        System.out.println(StringUtils.escapeBytes(byteArray));

        System.out.println(TextFormat.escapeDoubleQuotesAndBackslashes(new String(byteArray)).length());
        System.out.println((descriptorDataParts[0] + descriptorDataParts[1]).length());
        System.out.println(StringUtils.escapeBytes(byteArray).equals(descriptorDataParts[0] + descriptorDataParts[1]));

        Codec<FileDescriptorProtoPOJO> codec = ProtobufProxy.create(FileDescriptorProtoPOJO.class, false);

        FileDescriptorProtoPOJO fileDescriptorProtoPOJO = codec.decode(byteArray);
        System.out.println(fileDescriptorProtoPOJO);

        FileDescriptorProto fileproto;
        try {
            fileproto = FileDescriptorProto.parseFrom(codec.encode(fileDescriptorProtoPOJO));
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        Builder personBuilder = AddressBookProtos.Person.newBuilder().setName("xiemalin");

        // initialize map
        personBuilder.getMutableStringMap().put("hello", "world");
        personBuilder.getMutableStringMap().put("welcome", "China");

        personBuilder.getMutableIntMap().put(100, 200);

        personBuilder.getMutableLongMap().put(Long.MIN_VALUE, Long.MAX_VALUE);
        personBuilder.getMutableBooleanMap().put(Boolean.TRUE, Boolean.FALSE);

        Person person = personBuilder.build();

        byte[] bytes = person.toByteArray();

        Descriptor descriptor = fileproto.getDescriptorForType();

        DynamicMessage parseFrom = DynamicMessage.parseFrom(descriptor, bytes);
        System.out.println(parseFrom.getAllFields().size());

        Map<FieldDescriptor, Object> fieldDescs = parseFrom.getAllFields();
        for (Map.Entry<FieldDescriptor, Object> entry : fieldDescs.entrySet()) {
            System.out.println(entry.getKey().getName());
            System.out.println(entry.getValue());
        }

        // System.out.println(fileDescriptorProtoPOJO);

        // System.out.println(s);

        /*
         * com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new
         * com.google.protobuf.Descriptors.FileDescriptor. InternalDescriptorAssigner() { public
         * com.google.protobuf.ExtensionRegistry assignDescriptors( com.google.protobuf.Descriptors.FileDescriptor root)
         * { return null; } };
         * 
         * com.google.protobuf.Descriptors.FileDescriptor .internalBuildGeneratedFileFrom(new String[]
         * {TextFormat.escapeDoubleQuotesAndBackslashes(new String(byteArray))} , new
         * com.google.protobuf.Descriptors.FileDescriptor[] { }, assigner);
         */

        // DynamicMessage.parseFrom(type, data)

    }

    private byte[] getProtoBytes() {
        Builder personBuilder = AddressBookProtos.Person.newBuilder().setName("xiemalin");

        // initialize map
        personBuilder.getMutableStringMap().put("hello", "world");
        personBuilder.getMutableStringMap().put("welcome", "China");

        personBuilder.getMutableIntMap().put(100, 200);

        personBuilder.getMutableLongMap().put(Long.MIN_VALUE, Long.MAX_VALUE);
        personBuilder.getMutableBooleanMap().put(Boolean.TRUE, Boolean.FALSE);

        Person person = personBuilder.build();

        byte[] bytes = person.toByteArray();
        return bytes;
    }

    private byte[] getProtoBytes2() throws IOException {
        Codec<SimpleMapPOJO> simpleMapPojoCodec = ProtobufProxy.create(SimpleMapPOJO.class, false);

        // initialize map
        SimpleMapPOJO pojo = new SimpleMapPOJO();
        pojo.name = "xiemalin";

        Map<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("hello", "world");
        stringMap.put("welcome", "China");
        pojo.setStringMap(stringMap);

        Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        intMap.put(100, 200);
        pojo.setMyIntMap(intMap);

        pojo.longMap = new HashMap<Long, Long>();
        pojo.longMap.put(Long.MIN_VALUE, Long.MAX_VALUE);

        pojo.booleanMap = new HashMap<Boolean, Boolean>();
        pojo.booleanMap.put(Boolean.TRUE, Boolean.FALSE);

        byte[] bytes = simpleMapPojoCodec.encode(pojo);
        return bytes;
    }

    @Test
    public void testGetDescriptor() throws IOException {
        Codec<SimpleMapPOJO> codec = ProtobufProxy.create(SimpleMapPOJO.class, false);

        Descriptor descriptor = codec.getDescriptor();
        
        String escapeBytes = StringUtils.escapeBytes(descriptor.toProto().toByteArray());
        System.out.println(escapeBytes);

        FieldDescriptor stringMapFD = descriptor.findFieldByName("stringMap");

        byte[] bytes = getProtoBytes2();

        DynamicMessage parseFrom = DynamicMessage.parseFrom(descriptor, bytes);

        Object field = parseFrom.getField(stringMapFD);
        Assert.assertTrue(field instanceof List);
        Assert.assertEquals(2, ((List) field).size());
        
        Descriptor descriptor2 = AddressBookProtos.Person.getDescriptor();
        
        stringMapFD = descriptor2.findFieldByName("stringMap");
        bytes = getProtoBytes2();
        parseFrom = DynamicMessage.parseFrom(descriptor2, bytes);
        field = parseFrom.getField(stringMapFD);
        Assert.assertTrue(field instanceof List);
        Assert.assertEquals(2, ((List) field).size());

    }

    @Test
    public void testPOJODescriptorWorksWell() throws IOException {
        Descriptor descriptor2 = AddressBookProtos.Person.getDescriptor();
        DescriptorProto proto = descriptor2.toProto();
        byte[] byteArray = proto.toByteArray();
        Codec<DescriptorProtoPOJO> codec = ProtobufProxy.create(DescriptorProtoPOJO.class, false);

        DescriptorProtoPOJO decode = codec.decode(byteArray);

        byte[] encode = codec.encode(decode);

        Assert.assertArrayEquals(byteArray, encode);

    }

    

}
