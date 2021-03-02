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
package com.baidu.bjf.remoting.protobuf.simpletypes;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class AllTypesPojoClass.
 *
 * @author xiemalin
 */
public class AllTypesPojoClass {

    /** The double F. */
    @Protobuf(fieldType = FieldType.DOUBLE, order = 1, required = false)
    public Double doubleF;
    
    /** The float F. */
    @Protobuf(fieldType = FieldType.FLOAT, order = 2, required = false)
    public Float floatF;
    
    /** The int 32 F. */
    @Protobuf(fieldType = FieldType.INT32, order = 3, required = false)
    public Integer int32F;
    
    /** The int 64 F. */
    @Protobuf(fieldType = FieldType.INT64, order = 4, required = false)
    public Long int64F;
    
    /** The uint 32 F. */
    @Protobuf(fieldType = FieldType.UINT32, order = 5, required = false)
    public Integer uint32F;
    
    /** The uint 64 F. */
    @Protobuf(fieldType = FieldType.UINT64, order = 6, required = false)
    public Long uint64F;
    
    /** The sint 32 F. */
    @Protobuf(fieldType = FieldType.SINT32, order = 7, required = false)
    public Integer sint32F;
    
    /** The sint 64 F. */
    @Protobuf(fieldType = FieldType.SINT64, order = 8, required = false)
    public Long sint64F;
    
    /** The fixed 32 F. */
    @Protobuf(fieldType = FieldType.FIXED32, order = 9, required = false)
    public Integer fixed32F;
    
    /** The fixed 64 F. */
    @Protobuf(fieldType = FieldType.FIXED64, order = 10, required = false)
    public Long fixed64F;
    
    /** The sfixed 32 F. */
    @Protobuf(fieldType = FieldType.SFIXED32, order = 11, required = false)
    public Integer sfixed32F;
    
    /** The sfixed 64 F. */
    @Protobuf(fieldType = FieldType.SFIXED64, order = 12, required = false)
    public Long sfixed64F;
    
    /** The bool F. */
    @Protobuf(fieldType = FieldType.BOOL, order = 13, required = false)
    public Boolean boolF;
    
    /** The string F. */
    @Protobuf(fieldType = FieldType.STRING, order = 14, required = false)
    public String stringF;
    
    /** The bytes F. */
    @Protobuf(fieldType = FieldType.BYTES, order = 15, required = false)
    public byte[] bytesF;
    
    /** The type def enum. */
    @Protobuf(fieldType = FieldType.ENUM, order = 16, required = false)
    public TypeDefEnum typeDefEnum;

}
