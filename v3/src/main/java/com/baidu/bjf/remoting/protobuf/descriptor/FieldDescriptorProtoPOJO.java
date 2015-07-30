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
package com.baidu.bjf.remoting.protobuf.descriptor;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;

/**
 * JProtobuf supports for {@link FieldDescriptorProto}
 * @author xiemalin
 * @since 2.0.1
 */
public class FieldDescriptorProtoPOJO {

    @Override
    public String toString() {
        return "FieldDescriptorProtoPOJO [name=" + name + ", extendee=" + extendee + ", number=" + number + ", label="
                + label + ", type=" + type + ", typeName=" + typeName + ", defaultValue=" + defaultValue + ", options="
                + options + ", oneofIndex=" + oneofIndex + "]";
    }

    @Protobuf(order = FieldDescriptorProto.NAME_FIELD_NUMBER)
    public String name;
    
    @Protobuf(order = FieldDescriptorProto.EXTENDEE_FIELD_NUMBER)
    public String extendee;
    
    @Protobuf(order = FieldDescriptorProto.NUMBER_FIELD_NUMBER)
    public Integer number;
    
    @Protobuf(order = FieldDescriptorProto.LABEL_FIELD_NUMBER, fieldType = FieldType.ENUM)
    public Label label; 
    
    @Protobuf(order = FieldDescriptorProto.TYPE_FIELD_NUMBER, fieldType = FieldType.ENUM)
    public Type type;
    
    @Protobuf(order = FieldDescriptorProto.TYPE_NAME_FIELD_NUMBER)
    public String typeName;
    
    @Protobuf(order = FieldDescriptorProto.DEFAULT_VALUE_FIELD_NUMBER)
    public String defaultValue;
    
    @Protobuf(order = FieldDescriptorProto.OPTIONS_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public FieldOptionsPOJO options;
    
    @Protobuf(order = FieldDescriptorProto.ONEOF_INDEX_FIELD_NUMBER)
    public Integer oneofIndex;
}
