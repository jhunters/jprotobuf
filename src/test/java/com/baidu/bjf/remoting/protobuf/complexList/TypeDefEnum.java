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
package com.baidu.bjf.remoting.protobuf.complexList;

import com.baidu.bjf.remoting.protobuf.EnumReadable;

/**
 * Test pojo enum class.
 *
 * @author xiemalin
 * @since 1.5.8
 */
public enum TypeDefEnum implements EnumReadable {

    /** The text. */
    TEXT(1), /** The number. */
 NUMBER(2), /** The decimal. */
 DECIMAL(4), /** The id. */
 ID(8), /** The url. */
 URL(16);
    
    /** The value. */
    private final int value;

    /**
     * Instantiates a new type def enum.
     *
     * @param value the value
     */
    TypeDefEnum(int value) { this.value = value; }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.EnumReadable#value()
     */
    public int value() { return this.value; }

}
