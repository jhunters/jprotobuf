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
 * Test class for default @Protobuf annotation usage example
 * 
 * @author xiemalin
 * 
 */
public class AllTypesDojoClassWithDefault {

    @Protobuf
    public Double doubleF;
    @Protobuf
    public Float floatF;
    @Protobuf
    public Integer int32F;
    @Protobuf
    public Long int64F;
    @Protobuf
    public Integer uint32F;
    @Protobuf
    public Long uint64F;
    @Protobuf
    public Integer sint32F;
    @Protobuf
    public Long sint64F;
    @Protobuf
    public Integer fixed32F;
    @Protobuf
    public Long fixed64F;
    @Protobuf
    public Integer sfixed32F;
    @Protobuf
    public Long sfixed64F;
    @Protobuf
    public Boolean boolF;
    @Protobuf
    public String stringF;
    @Protobuf
    public byte[] bytesF;
    @Protobuf
    public TypeDefEnum typeDefEnum;
}
