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
package com.baidu.bjf.remoting.protobuf.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class JavaStyleFormatterTest.
 *
 * @author xiemalin
 * @since 1.11.13
 */
public class JavaStyleFormatterTest {

    
    /**
     * Test start with upper case char.
     */
    @Test
    public void testStartWithUpperCaseChar() {
        
        String name = "HelloWorld";
        String newName = JavaStyleFormatter.formatJavaFieldName(name);
        Assert.assertEquals("helloWorld", newName);
    }
    
    /**
     * Test start with lower case char.
     */
    @Test
    public void testStartWithLowerCaseChar() {
        
        String name = "helloWorld";
        String newName = JavaStyleFormatter.formatJavaFieldName(name);
        Assert.assertEquals("helloWorld", newName);
    }
    
    /**
     * Test with split char.
     */
    @Test
    public void testWithSplitChar() {
        
        String name = "he$llo_Wo$rl_d";
        String newName = JavaStyleFormatter.formatJavaFieldName(name);
        Assert.assertEquals("heLloWoRlD", newName);
    }
    
    /**
     * Test with split char common.
     */
    @Test
    public void testWithSplitCharCommon() {
        
        String name = "Can$write_name";
        String newName = JavaStyleFormatter.formatJavaFieldName(name);
        Assert.assertEquals("canWriteName", newName);
    }
    
    /**
     * Test with split char common.
     */
    @Test
    public void testWithInvalidName() {
        
        String name = "_$";
        String newName = JavaStyleFormatter.formatJavaFieldName(name);
        Assert.assertEquals("", newName);
    }
    
    /**
     * Test start with invalid name.
     */
    @Test
    public void testStartWithInvalidName() {
        
        String name = "_$Name";
        String newName = JavaStyleFormatter.formatJavaFieldName(name);
        Assert.assertEquals("name", newName);
    }
    
    /**
     * Test start with invalid name.
     */
    @Test
    public void testStartWithInvalidName2() {
        
        String name = "_$name";
        String newName = JavaStyleFormatter.formatJavaFieldName(name);
        Assert.assertEquals("name", newName);
    }
    
}
