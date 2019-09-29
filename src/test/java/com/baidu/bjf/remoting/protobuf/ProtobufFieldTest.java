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
package com.baidu.bjf.remoting.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;

/**
 * The Class ProtobufFieldTest.
 */
public class ProtobufFieldTest {

    /** The name. */
    @Protobuf
    private String name;
    
    /** The protobuf field. */
    private ProtobufField protobufField;
    
    
    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        Field field = FieldUtils.findField(ProtobufFieldTest.class, "name");
        protobufField = new ProtobufField(field);
    }
    
    /**
     * Test get annotation.
     */
    @Test
    public void testGetAnnotation() {
        Protobuf annotation = protobufField.getAnnotation();
        Assert.assertNotNull(annotation);
        
    }
    
    /**
     * Test get name.
     */
    @Test
    public void testGetName() {
        String name = protobufField.getName();
        Assert.assertEquals(name, "name");
    }

    /**
     * Test get type.
     */
    @Test
    public void testGetType() {
        Class<?> type = protobufField.getType();
        Assert.assertEquals(type, String.class);
    }

    /**
     * Test get declared class.
     */
    @Test
    public void testGetDeclaredClass() {
        Class<?> declaredClass = protobufField.getDeclaredClass();
        Assert.assertEquals(declaredClass, ProtobufFieldTest.class);
    }

    /**
     * Test get generic type.
     */
    @Test
    public void testGetGenericType() {
        Type genericType = protobufField.getGenericType();
        Assert.assertEquals(genericType, String.class);
    }
    
}
