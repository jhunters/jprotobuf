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
package com.baidu.bjf.remoting.protobuf.complexList;

import com.baidu.bjf.remoting.protobuf.EnumReadable;

/**
 * Test pojo enum class.
 *
 * @author xiemalin
 * @since 1.5.8
 */
public enum TypeDefEnum implements EnumReadable {

    TEXT(1), NUMBER(2), DECIMAL(4), ID(8), URL(16);
    
    private final int value;

    TypeDefEnum(int value) { this.value = value; }

    public int value() { return this.value; }

}
