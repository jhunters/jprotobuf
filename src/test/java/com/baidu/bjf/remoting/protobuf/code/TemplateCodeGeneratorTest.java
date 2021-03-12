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
package com.baidu.bjf.remoting.protobuf.code;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.SimplePoJoForGenerator;
import com.baidu.bjf.remoting.protobuf.complex.PersonPOJO;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.FileOptionsPOJO;
import com.baidu.bjf.remoting.protobuf.v3.complexmap.ComplexMapPOJO;


/**
 * The Class TemplateCodeGeneratorTest.
 *
 * @author xiemalin
 * @since 1.12.0
 */
public class TemplateCodeGeneratorTest {

    
    /**
     * Test code generate.
     */
    @Test
    public void testCodeGenerate() {
        
        TemplateCodeGenerator generator = new TemplateCodeGenerator(PersonPOJO.class);
        
        Assert.assertNotNull(generator.getCode());
        
    }
    
    /**
     * Test empty dependencies.
     */
    @Test
    public void testEmptyDependencies() {
        TemplateCodeGenerator generator = new TemplateCodeGenerator(PersonPOJO.class);
        Set<Class> dependenciesClasses = generator.getDependenciesClasses();
        Assert.assertTrue(dependenciesClasses.isEmpty());
    }
    
    /**
     * Test list POJO dependencies.
     */
    @Test
    public void testListPOJODependencies() {
        TemplateCodeGenerator generator = new TemplateCodeGenerator(AddressBookProtosPOJO.class);
        Set<Class> dependenciesClasses = generator.getDependenciesClasses();
        Assert.assertEquals(dependenciesClasses.size(), 2);
    }
    
    
    /**
     * Test map and sub class dependencies.
     */
    @Test
    public void testMapAndSubClassDependencies() {
        TemplateCodeGenerator generator = new TemplateCodeGenerator(ComplexMapPOJO.class);
        Set<Class> list = new HashSet<Class>();
        generator.getAllDependenciesClasses(list);
        System.out.println(list);
        Assert.assertEquals(list.size(), 3);
        
    }
    
    /**
     * Test repeat dependencies.
     */
    @Test 
    public void testRepeatDependencies() {
        TemplateCodeGenerator generator = new TemplateCodeGenerator(FileOptionsPOJO.class);
        Set<Class> list = new HashSet<Class>();
        generator.getAllDependenciesClasses(list);
        
        String pkg = FileOptionsPOJO.class.getPackage().getName();
        for (Class c : list) {
            if (c.getName().startsWith(pkg)) {
                try {
                    generator = new TemplateCodeGenerator(c);
                    Assert.assertNotNull(generator);
                } catch (Exception e) {
                }
            }
  
        }
    }
    
    /**
     * Test repeat dependencies.
     */
    @Test 
    public void testAllTypeDefinedPOJOGenerator() {
        TemplateCodeGenerator generator = new TemplateCodeGenerator(SimplePoJoForGenerator.class);
        Set<Class> list = new HashSet<Class>();
        generator.getAllDependenciesClasses(list);
        Assert.assertTrue(list.isEmpty());
    }
}
