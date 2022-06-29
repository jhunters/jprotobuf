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
package com.baidu.bjf.remoting.protobuf.descriptor;

import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;

/**
 * Enumeration type defines at {@link FieldDescriptorProto}.
 *
 * @author xiemalin
 * @since 2.0.1
 */
public enum Type implements EnumReadable {
    /**
     * <code>TYPE_DOUBLE = 1;</code>
     *
     * <pre>
     * 0 is reserved for errors.
     * Order is weird for historical reasons.
     * </pre>
     */
    TYPE_DOUBLE(1),
    
    /** <code>TYPE_FLOAT = 2;</code>. */
    TYPE_FLOAT(2),
    /**
     * <code>TYPE_INT64 = 3;</code>
     *
     * <pre>
     * Not ZigZag encoded.  Negative numbers take 10 bytes.  Use TYPE_SINT64 if
     * negative values are likely.
     * </pre>
     */
    TYPE_INT64(3),
    
    /** <code>TYPE_UINT64 = 4;</code>. */
    TYPE_UINT64(4),
    /**
     * <code>TYPE_INT32 = 5;</code>
     *
     * <pre>
     * Not ZigZag encoded.  Negative numbers take 10 bytes.  Use TYPE_SINT32 if
     * negative values are likely.
     * </pre>
     */
    TYPE_INT32(5),
    
    /** <code>TYPE_FIXED64 = 6;</code>. */
    TYPE_FIXED64(6),
    
    /** <code>TYPE_FIXED32 = 7;</code>. */
    TYPE_FIXED32(7),
    
    /** <code>TYPE_BOOL = 8;</code>. */
    TYPE_BOOL(8),
    
    /** <code>TYPE_STRING = 9;</code>. */
    TYPE_STRING(9),
    /**
     * <code>TYPE_GROUP = 10;</code>
     *
     * <pre>
     * Tag-delimited aggregate.
     * </pre>
     */
    TYPE_GROUP(10),
    /**
     * <code>TYPE_MESSAGE = 11;</code>
     *
     * <pre>
     * Length-delimited aggregate.
     * </pre>
     */
    TYPE_MESSAGE(11),
    /**
     * <code>TYPE_BYTES = 12;</code>
     *
     * <pre>
     * New in version 2.
     * </pre>
     */
    TYPE_BYTES(12),
    
    /** <code>TYPE_UINT32 = 13;</code>. */
    TYPE_UINT32(13),
    
    /** <code>TYPE_ENUM = 14;</code>. */
    TYPE_ENUM(14),
    
    /** <code>TYPE_SFIXED32 = 15;</code>. */
    TYPE_SFIXED32(15),
    
    /** <code>TYPE_SFIXED64 = 16;</code>. */
    TYPE_SFIXED64(16),
    /**
     * <code>TYPE_SINT32 = 17;</code>
     *
     * <pre>
     * Uses ZigZag encoding.
     * </pre>
     */
    TYPE_SINT32(17),
    /**
     * <code>TYPE_SINT64 = 18;</code>
     *
     * <pre>
     * Uses ZigZag encoding.
     * </pre>
     */
    TYPE_SINT64(18),
    ;
    
    /** The value. */
    private int value;

    /**
     * Instantiates a new type.
     *
     * @param value the value
     */
    private Type(int value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.EnumReadable#value()
     */
    @Override
    public int value() {
        return value;
    }
    
    /**
     * Value of.
     *
     * @param value the value
     * @return the type
     */
    public static Type valueOf(int value) {
        Type[] values = values();
        for (Type type : values) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

}
