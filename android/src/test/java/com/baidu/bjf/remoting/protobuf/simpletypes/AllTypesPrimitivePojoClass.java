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
 * test primitive types
 *
 * @author xiemalin
 * @since 1.7.3
 */
public class AllTypesPrimitivePojoClass {
    @Protobuf(fieldType = FieldType.DOUBLE, order = 1, required = false)
    private double doubleF;
    @Protobuf(fieldType = FieldType.FLOAT, order = 2, required = false)
    private float floatF;
    @Protobuf(fieldType = FieldType.INT32, order = 3, required = false)
    private int int32F;
    @Protobuf(fieldType = FieldType.INT64, order = 4, required = false)
    private long int64F;
    @Protobuf(fieldType = FieldType.UINT32, order = 5, required = false)
    private int uint32F;
    @Protobuf(fieldType = FieldType.UINT64, order = 6, required = false)
    private long uint64F;
    @Protobuf(fieldType = FieldType.SINT32, order = 7, required = false)
    private int sint32F;
    @Protobuf(fieldType = FieldType.SINT64, order = 8, required = false)
    private long sint64F;
    @Protobuf(fieldType = FieldType.FIXED32, order = 9, required = false)
    private int fixed32F;
    @Protobuf(fieldType = FieldType.FIXED64, order = 10, required = false)
    private long fixed64F;
    @Protobuf(fieldType = FieldType.SFIXED32, order = 11, required = false)
    private int sfixed32F;
    @Protobuf(fieldType = FieldType.SFIXED64, order = 12, required = false)
    private long sfixed64F;
    @Protobuf(fieldType = FieldType.BOOL, order = 13, required = false)
    private boolean boolF;
    @Protobuf(fieldType = FieldType.STRING, order = 14, required = false)
    private String stringF;
    @Protobuf(fieldType = FieldType.BYTES, order = 15, required = false)
    private byte[] bytesF;
    @Protobuf(fieldType = FieldType.ENUM, order = 16, required = false)
    private TypeDefEnum typeDefEnum;

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
