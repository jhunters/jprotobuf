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
package com.baidu.bjf.remoting.protobuf.enumeration;

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Simple enum test for .
 *
 * @author xiemalin
 * @since 1.4.0
 */
public class EnumPOJOClass3 {

    /** The int array value. */
    @Protobuf(fieldType = FieldType.INT32, order = 1)
    public List intArrayValue;

    /** The double array value. */
    @Protobuf(fieldType = FieldType.DOUBLE, order = 2)
    public List<Double> doubleArrayValue;

    /** The bool array value. */
    @Protobuf(fieldType = FieldType.BOOL, order = 3)
    public List<Boolean> boolArrayValue;

    /** The string array value. */
    @Protobuf(fieldType = FieldType.STRING, order = 4)
    public List<String> stringArrayValue;

    /** The enum array value. */
    @Protobuf(fieldType = FieldType.ENUM, order = 6)
    public List<TestEnum> enumArrayValue;
}
