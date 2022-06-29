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

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FieldOptions.CType;

/**
 * JProtobuf POJO class for {@link FieldOptions}.
 *
 * @author xiemalin
 * @since 2.0.1
 */
public class FieldOptionsPOJO {

    /** The ctype. */
    @Protobuf(order = FieldOptions.CTYPE_FIELD_NUMBER, fieldType = FieldType.ENUM)
    public CType ctype;
    
    /** The packed. */
    @Protobuf(order = FieldOptions.PACKED_FIELD_NUMBER)
    public Boolean packed;
    
    /** The deprecated. */
    @Protobuf(order = FieldOptions.DEPRECATED_FIELD_NUMBER)
    public Boolean deprecated;
    
    /** The lazy. */
    @Protobuf(order = FieldOptions.LAZY_FIELD_NUMBER)
    public Boolean lazy;
    
    /** The weak. */
    @Protobuf(order = FieldOptions.WEAK_FIELD_NUMBER)
    public Boolean weak;

    /** The uninterpreted option. */
    @Protobuf(order = FieldOptions.UNINTERPRETED_OPTION_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<UninterpretedOptionPOJO> uninterpretedOption;
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FieldOptionsPOJO [ctype=" + ctype + ", packed=" + packed + ", deprecated=" + deprecated + ", lazy="
                + lazy + ", weak=" + weak + ", uninterpretedOption=" + uninterpretedOption + "]";
    }
}
