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
import com.google.protobuf.DescriptorProtos.DescriptorProto;

/**
 * JProtobuf POJO supports for {@link DescriptorProto}.
 *
 * @author xiemalin
 * @since 2.0.1
 */
public class DescriptorProtoPOJO {

    /** The name. */
    @Protobuf(order = DescriptorProto.NAME_FIELD_NUMBER)
    public String name;
    
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DescriptorProtoPOJO [name=" + name + ", fields=" + fields + ", nestedTypes=" + nestedTypes
                + ", enumTypes=" + enumTypes + ", extensionRanges=" + extensionRanges + ", extensions=" + extensions
                + ", options=" + options + ", oneofDecls=" + oneofDecls + "]";
    }

    /** fields. */
    @Protobuf(order = DescriptorProto.FIELD_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<FieldDescriptorProtoPOJO> fields;
    
    /** nestedTypes. */
    @Protobuf(order = DescriptorProto.NESTED_TYPE_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<DescriptorProtoPOJO> nestedTypes;
    
    /** enumTypes. */
    @Protobuf(order = DescriptorProto.ENUM_TYPE_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<EnumDescriptorProtoPOJO> enumTypes;
    
    /** extensionRanges. */
    @Protobuf(order = DescriptorProto.EXTENSION_RANGE_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<ExtensionRangePOJO> extensionRanges;
    
    /** The extensions. */
    @Protobuf(order = DescriptorProto.EXTENSION_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<FieldDescriptorProtoPOJO> extensions;
    
    /** The options. */
    @Protobuf(order = DescriptorProto.OPTIONS_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<MessageOptionsPOJO> options;
    
    /** The oneof decls. */
    @Protobuf(order = DescriptorProto.ONEOF_DECL_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<OneofDescriptorProtoPOJO> oneofDecls;
}
