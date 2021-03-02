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

import com.baidu.bjf.remoting.protobuf.EnumReadable;

/**
 * The Enum TestEnum.
 */
public enum TestEnum implements EnumReadable {
    
    /** The a type. */
    A_TYPE(1),
    /** The b type. */
    B_TYPE(2),
    /** The c type. */
    C_TYPE(3);

    /** The value. */
    private final int value;

    /**
     * Instantiates a new test enum.
     *
     * @param value the value
     */
    TestEnum(int value) {
        this.value = value;
    }

    /**
     * To value.
     *
     * @return the int
     */
    public int toValue() {
        return this.value;
    }

    /**
     * Value.
     *
     * @return the int
     */
    @Override
    public int value() {
        return value;
    }
}
