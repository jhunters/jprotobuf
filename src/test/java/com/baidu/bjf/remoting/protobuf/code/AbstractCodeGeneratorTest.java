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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class AbstractCodeGeneratorTest.
 *
 * @author xiemalin
 */
public abstract class AbstractCodeGeneratorTest {
    
    /** The code generator. */
    private ICodeGenerator codeGenerator;
    
    @Before
    public void setUp() {
        codeGenerator = getCodeGenerator();
    }
    
    /**
     * Gets the code generator.
     *
     * @return the code generator
     */
    protected abstract ICodeGenerator getCodeGenerator();
    
    /**
     * Gets the test class.
     *
     * @return the test class
     */
    protected abstract Class getTestClass();
    
    /**
     * Test get code.
     */
    @Test
    public void testGetCode() {
        Assert.assertNotNull(codeGenerator.getCode());
    }
    
    /**
     * Test get class name.
     */
    @Test
    public void testGetClassName() {
        String className = codeGenerator.getClassName();
        Assert.assertEquals(className, getTestClass().getSimpleName() + AbstractCodeGenerator.DEFAULT_SUFFIX_CLASSNAME);
    }

}
