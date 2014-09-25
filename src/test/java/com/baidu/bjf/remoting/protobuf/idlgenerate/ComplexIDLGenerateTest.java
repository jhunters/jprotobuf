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
package com.baidu.bjf.remoting.protobuf.idlgenerate;

import junit.framework.Assert;

import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.complex.AddressBookProtosPOJO;
import com.baidu.bjf.remoting.protobuf.simpletypes.AllTypesDojoClass;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Test IDL script generate tool
 *
 * @author xiemalin
 * @since 1.0.1
 */
public class ComplexIDLGenerateTest {

    @Test
    public void TestGenerateIDLComplexList() throws InvalidProtocolBufferException {
        
        String code = ProtobufIDLGenerator.getIDL(AddressBookProtosPOJO.class);
        Assert.assertNotNull(code);
        
    }
    
    @Test
    public void TestGenerateIDLSimpleType() throws InvalidProtocolBufferException {
        
        String code = ProtobufIDLGenerator.getIDL(AllTypesDojoClass.class);
        Assert.assertNotNull(code);
        
    }
}
