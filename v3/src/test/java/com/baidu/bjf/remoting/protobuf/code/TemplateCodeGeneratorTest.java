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
package com.baidu.bjf.remoting.protobuf.code;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.complex.PersonPOJO;
import com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.v3.complexmap.ComplexMapPOJO;

import junit.framework.Assert;

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
    
    @Test
    public void testListPOJODependencies() {
        TemplateCodeGenerator generator = new TemplateCodeGenerator(AddressBookProtosPOJO.class);
        Set<Class> dependenciesClasses = generator.getDependenciesClasses();
        Assert.assertEquals(dependenciesClasses.size(), 2);
    }
    
    
    @Test
    public void testMapAndSubClassDependencies() {
        TemplateCodeGenerator generator = new TemplateCodeGenerator(ComplexMapPOJO.class);
        Set<Class> list = new HashSet<Class>();
        generator.getAllDependenciesClasses(list);
        System.out.println(list);
        Assert.assertEquals(list.size(), 3);
        
    }
}
