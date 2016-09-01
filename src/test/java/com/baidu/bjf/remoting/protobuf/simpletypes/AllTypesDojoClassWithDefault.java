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
package com.baidu.bjf.remoting.protobuf.simpletypes;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Test class for default @Protobuf annotation usage example.
 *
 * @author xiemalin
 */
public class AllTypesDojoClassWithDefault {

    /** The double f. */
    @Protobuf
    public Double doubleF;
    
    /** The float f. */
    @Protobuf
    public Float floatF;
    
    /** The int32 f. */
    @Protobuf
    public Integer int32F;
    
    /** The int64 f. */
    @Protobuf
    public Long int64F;
    
    /** The uint32 f. */
    @Protobuf
    public Integer uint32F;
    
    /** The uint64 f. */
    @Protobuf
    public Long uint64F;
    
    /** The sint32 f. */
    @Protobuf
    public Integer sint32F;
    
    /** The sint64 f. */
    @Protobuf
    public Long sint64F;
    
    /** The fixed32 f. */
    @Protobuf
    public Integer fixed32F;
    
    /** The fixed64 f. */
    @Protobuf
    public Long fixed64F;
    
    /** The sfixed32 f. */
    @Protobuf
    public Integer sfixed32F;
    
    /** The sfixed64 f. */
    @Protobuf
    public Long sfixed64F;
    
    /** The bool f. */
    @Protobuf
    public Boolean boolF;
    
    /** The string f. */
    @Protobuf
    public String stringF;
    
    /** The bytes f. */
    @Protobuf
    public byte[] bytesF;
    
    /** The type def enum. */
    @Protobuf
    public TypeDefEnum typeDefEnum;
}
