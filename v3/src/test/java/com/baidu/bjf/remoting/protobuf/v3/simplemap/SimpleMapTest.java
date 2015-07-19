/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.v3.simplemap;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person;
import com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.Builder;

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
        
        Codec<SimpleMapPOJO> simpleMapPojoCodec = ProtobufProxy.create(SimpleMapPOJO.class, true);
        
        // initialize map
        SimpleMapPOJO pojo = new SimpleMapPOJO();
        pojo.name = "xiemalin";
        
        pojo.stringMap = new HashMap<String, String>();
        pojo.stringMap.put("hello", "world");
        pojo.stringMap.put("welcome", "China");
        
        pojo.intMap = new HashMap<Integer, Integer>();
        pojo.intMap.put(100, 200);
        
        pojo.longMap = new HashMap<Long, Long>();
        pojo.longMap.put(Long.MIN_VALUE, Long.MAX_VALUE);
        
        pojo.booleanMap = new HashMap<Boolean, Boolean>();
        pojo.booleanMap.put(Boolean.TRUE, Boolean.FALSE);
        
        byte[] bytes = simpleMapPojoCodec.encode(pojo);
        
        Assert.assertNotNull(bytes);
        
        // to validate
        Person person = AddressBookProtos.Person.parseFrom(bytes);
        
        Assert.assertEquals(pojo.name, person.getName());
        
        Assert.assertEquals(pojo.stringMap, person.getStringMap());
        
        Assert.assertEquals(pojo.intMap, person.getIntMap());
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
        
        Codec<SimpleMapPOJO> simpleMapPojoCodec = ProtobufProxy.create(SimpleMapPOJO.class, true);
        
        SimpleMapPOJO pojo = simpleMapPojoCodec.decode(bytes);
        
        Assert.assertEquals(pojo.name, person.getName());
        
        Assert.assertEquals(pojo.stringMap, person.getStringMap());
        
        Assert.assertEquals(pojo.intMap, person.getIntMap());
        Assert.assertEquals(pojo.longMap, person.getLongMap());
        Assert.assertEquals(pojo.booleanMap, person.getBooleanMap());
    }
}
