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

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

/**
 * The Class AllTypesDojoClass.
 *
 * @author xiemalin
 */
@ProtobufClass
public class AllTypesWithProtobufClassDojoClass {

    /** The double f. */
    public Double doubleF;
    
    /** The float f. */
    public Float floatF;
    
    /** The int32 f. */
    public Integer int32F;
    
    /** The int64 f. */
    public Long int64F;
    
    /** The uint32 f. */
    public Integer uint32F;
    
    /** The uint64 f. */
    public Long uint64F;
    
    /** The sint32 f. */
    public Integer sint32F;
    
    /** The sint64 f. */
    public Long sint64F;
    
    /** The fixed32 f. */
    public Integer fixed32F;
    
    /** The fixed64 f. */
    public Long fixed64F;
    
    /** The sfixed32 f. */
    public Integer sfixed32F;
    
    /** The sfixed64 f. */
    public Long sfixed64F;
    
    /** The bool f. */
    public Boolean boolF;
    
    /** The string f. */
    public String stringF;
    
    /** The bytes f. */
    public byte[] bytesF;
    
    /** The type def enum. */
    public TypeDefEnum typeDefEnum;
    
    public List<String> strings;
    
    public List<Integer> intergers;
    
    public List<AllTypesDojoClass> allTypesDojoClasses;

    public double getDoubleF() {
        return doubleF;
    }

    public float getFloatF() {
        return floatF;
    }

    public int getInt32F() {
        return int32F;
    }

    public long getInt64F() {
        return int64F;
    }

    public int getUint32F() {
        return uint32F;
    }

    public long getUint64F() {
        return uint64F;
    }

    public int getSint32F() {
        return sint32F;
    }

    public long getSint64F() {
        return sint64F;
    }

    public int getFixed32F() {
        return fixed32F;
    }

    public long getFixed64F() {
        return fixed64F;
    }

    public int getSfixed32F() {
        return sfixed32F;
    }

    public long getSfixed64F() {
        return sfixed64F;
    }

    public boolean getBoolF() {
        return boolF;
    }

    public String getStringF() {
        return stringF;
    }

    public byte[] getBytesF() {
        return bytesF;
    }

    public TypeDefEnum getTypeDefEnum() {
        return typeDefEnum;
    }

}
