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

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto;

/**
 * JProtobuf POJO supports for {@link EnumDescriptorProto}
 * @author xiemalin
 * @since 2.0.1
 */
public class EnumDescriptorProtoPOJO {

    @Protobuf(order = EnumDescriptorProto.NAME_FIELD_NUMBER)
    public String name;
    
    
    @Protobuf(order = EnumDescriptorProto.VALUE_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<EnumValueDescriptorProtoPOJO> values;
    
    @Protobuf(order = EnumDescriptorProto.OPTIONS_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<EnumOptionsPOJO> options;

    @Override
    public String toString() {
        return "EnumDescriptorProtoPOJO [name=" + name + ", values=" + values + ", options=" + options + "]";
    }
    
    
}
