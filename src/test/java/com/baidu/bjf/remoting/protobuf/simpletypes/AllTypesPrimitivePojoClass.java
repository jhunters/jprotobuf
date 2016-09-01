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

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * test primitive types.
 *
 * @author xiemalin
 * @since 1.7.3
 */
public class AllTypesPrimitivePojoClass {
    
    /** The double f. */
    @Protobuf(fieldType = FieldType.DOUBLE, order = 1, required = false)
    private double doubleF;
    
    /** The float f. */
    @Protobuf(fieldType = FieldType.FLOAT, order = 2, required = false)
    private float floatF;
    
    /** The int32 f. */
    @Protobuf(fieldType = FieldType.INT32, order = 3, required = false)
    private int int32F;
    
    /** The int64 f. */
    @Protobuf(fieldType = FieldType.INT64, order = 4, required = false)
    private long int64F;
    
    /** The uint32 f. */
    @Protobuf(fieldType = FieldType.UINT32, order = 5, required = false)
    private int uint32F;
    
    /** The uint64 f. */
    @Protobuf(fieldType = FieldType.UINT64, order = 6, required = false)
    private long uint64F;
    
    /** The sint32 f. */
    @Protobuf(fieldType = FieldType.SINT32, order = 7, required = false)
    private int sint32F;
    
    /** The sint64 f. */
    @Protobuf(fieldType = FieldType.SINT64, order = 8, required = false)
    private long sint64F;
    
    /** The fixed32 f. */
    @Protobuf(fieldType = FieldType.FIXED32, order = 9, required = false)
    private int fixed32F;
    
    /** The fixed64 f. */
    @Protobuf(fieldType = FieldType.FIXED64, order = 10, required = false)
    private long fixed64F;
    
    /** The sfixed32 f. */
    @Protobuf(fieldType = FieldType.SFIXED32, order = 11, required = false)
    private int sfixed32F;
    
    /** The sfixed64 f. */
    @Protobuf(fieldType = FieldType.SFIXED64, order = 12, required = false)
    private long sfixed64F;
    
    /** The bool f. */
    @Protobuf(fieldType = FieldType.BOOL, order = 13, required = false)
    private boolean boolF;
    
    /** The string f. */
    @Protobuf(fieldType = FieldType.STRING, order = 14, required = false)
    private String stringF;
    
    /** The bytes f. */
    @Protobuf(fieldType = FieldType.BYTES, order = 15, required = false)
    private byte[] bytesF;
    
    /** The type def enum. */
    @Protobuf(fieldType = FieldType.ENUM, order = 16, required = false)
    private TypeDefEnum typeDefEnum;

    /**
     * Check.
     *
     * @param doubleF the double f
     * @param floatF the float f
     * @param int32f the int32f
     * @param int64f the int64f
     * @param uint32f the uint32f
     * @param uint64f the uint64f
     * @param sint32f the sint32f
     * @param sint64f the sint64f
     * @param fixed32f the fixed32f
     * @param fixed64f the fixed64f
     * @param sfixed32f the sfixed32f
     * @param sfixed64f the sfixed64f
     * @param boolF the bool f
     * @param stringF the string f
     * @param bytesF the bytes f
     * @param typeDefEnum the type def enum
     * @return true, if successful
     */
    public boolean check(double doubleF, float floatF, int int32f, long int64f, int uint32f, long uint64f,
            int sint32f, long sint64f, int fixed32f, long fixed64f, int sfixed32f, long sfixed64f, boolean boolF,
            String stringF, byte[] bytesF, TypeDefEnum typeDefEnum) {
        boolean result = true;
        
        result = result && this.doubleF == doubleF;
        result = result && this.floatF == floatF;
        result = result && int32F == int32f;
        result = result && int64F == int64f;
        result = result && uint32F == uint32f;
        result = result && uint64F == uint64f;
        result = result && sint32F == sint32f;
        result = result && sint64F == sint64f;
        result = result && fixed32F == fixed32f;
        result = result && fixed64F == fixed64f;
        result = result && sfixed32F == sfixed32f;
        result = result && sfixed64F == sfixed64f;
        result = result && this.boolF == boolF;
        result = result && this.stringF.equals(stringF);
        result = result && this.typeDefEnum.value() == typeDefEnum.value();
        
        return result;
    }

    
}
