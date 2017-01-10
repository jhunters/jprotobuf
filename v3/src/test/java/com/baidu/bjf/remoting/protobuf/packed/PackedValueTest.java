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
package com.baidu.bjf.remoting.protobuf.packed;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person;
import com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person.Builder;
import com.google.protobuf.ByteString;

/**
 * The Class PackedValueTest.
 *
 * @author xiemalin
 * @since 2.0.5
 */
public class PackedValueTest {

    @Test
    public void testIncludeEmptyList() {
        PackedProtosPOJO pojo = new PackedProtosPOJO();
        Codec<PackedProtosPOJO> codec = ProtobufProxy.create(PackedProtosPOJO.class, true);

        List<Integer> list = Arrays.asList(62, 218, 254, 849, 288, 591, 277, 374, 318, 263, 244, 944, 220, 310, 751,
                323, 317, 497, 55, 635, 58, 962, 426, 597, 778, 685, 652, 614, 467, 554, 306, 581, 426, 831, 789, 613,
                879, 75, 312, 35, 710, 811, 200, 388, 16, 275, 386, 892, 554, 136, 163, 334, 475, 756, 579, 554, 977,
                271, 551, 547, 229, 62, 363, 22, 586, 622, 195, 168, 224, 837, 928, 857, 680, 880, 753, 500, 511, 610,
                268, 408, 298, 643, 500, 586, 220, 857, 525, 2, 892, 852, 824, 593, 846, 687, 283, 625, 984, 450, 468,
                110);
        pojo.setId(list);

        Builder b1 = Person.newBuilder();
        b1.addAllId(list);
        Person person = b1.build();


        try {
            byte[] byteArray1 = person.toByteArray();
            byte[] byteArray2 = codec.encode(pojo);
            System.out.println(Arrays.toString(byteArray1));
            System.out.println(Arrays.toString(byteArray2));
            Assert.assertArrayEquals(byteArray1, byteArray2);
            
            PackedProtosPOJO pojo2 = codec.decode(person.toByteArray());
            Assert.assertEquals(pojo.getId(), pojo2.getId());
            
            codec.decode(person.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test float value encode.
     */
    @Test
    public void testFloatValueEncode() {

        Builder b1 = Person.newBuilder();
        com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.Builder b2 =
                com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.newBuilder();

        PackedProtosPOJO pojo = new PackedProtosPOJO();
        PackedProtosPOJO2 pojo2 = new PackedProtosPOJO2();
        for (int i = 0; i < 10; i++) {
            b1.addId(i);
            b1.addName("name中文" + i);
            b1.addBoolF(i % 2 == 0);
            b1.addBytesF(ByteString.copyFrom(new byte[] { 'a', 'b', 'c' }));
            b1.addDoubleF(101.1d * i);
            b1.addEmail("xiemalin" + i + "@baidu.com");
            b1.addFloatF(102.1f * i);

            b2.addId(i);
            b2.addName("name中文" + i);
            b2.addBoolF(i % 2 == 0);
            b2.addBytesF(ByteString.copyFrom(new byte[] { 'a', 'b', 'c' }));
            b2.addDoubleF(101.1d * i);
            b2.addEmail("xiemalin" + i + "@baidu.com");
            b2.addFloatF(102.1f * i);

            pojo.getId().add(i);
            pojo.getName().add("name中文" + i);
            pojo.getBoolF().add(i % 2 == 0);
            pojo.getBytesF().add(new byte[] { 'a', 'b', 'c' });
            pojo.getDoubleF().add(101.1d * i);
            pojo.getEmail().add("xiemalin" + i + "@baidu.com");
            pojo.getFloatF().add(102.1f * i);

            pojo2.getId().add(i);
            pojo2.getName().add("name中文" + i);
            pojo2.getBoolF().add(i % 2 == 0);
            pojo2.getBytesF().add(new byte[] { 'a', 'b', 'c' });
            pojo2.getDoubleF().add(101.1d * i);
            pojo2.getEmail().add("xiemalin" + i + "@baidu.com");
            pojo2.getFloatF().add(102.1f * i);
        }
        Person person = b1.build();
        com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person person2;
        person2 = b2.build();
        Codec<PackedProtosPOJO> codec = ProtobufProxy.create(PackedProtosPOJO.class);
        Codec<PackedProtosPOJO2> codec2 = ProtobufProxy.create(PackedProtosPOJO2.class);

        try {
            byte[] bytes = codec.encode(pojo); // packed bytes
            Assert.assertArrayEquals(person.toByteArray(), bytes);

            byte[] bytes2 = codec2.encode(pojo2);
            Assert.assertArrayEquals(person2.toByteArray(), bytes2);

            PackedProtosPOJO pojoNew = codec.decode(bytes);
            Assert.assertEquals(pojo.getId(), pojoNew.getId());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
