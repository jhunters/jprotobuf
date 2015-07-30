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
import com.google.protobuf.DescriptorProtos.UninterpretedOption;

/**
 * JProtobuf POJO supports for {@link UninterpretedOption}
 * @author xiemalin
 * @since 2.0.1
 */
public class UninterpretedOptionPOJO {

    @Protobuf(order = UninterpretedOption.NAME_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<NamePartPOJO> names;
    
    @Protobuf(order = UninterpretedOption.IDENTIFIER_VALUE_FIELD_NUMBER)
    public String identifierValue;
    
    @Protobuf(order = UninterpretedOption.POSITIVE_INT_VALUE_FIELD_NUMBER)
    public Long positiveIntValue;
    
    @Protobuf(order = UninterpretedOption.NEGATIVE_INT_VALUE_FIELD_NUMBER)
    public Long negativeIntValue;
    
    @Protobuf(order = UninterpretedOption.DOUBLE_VALUE_FIELD_NUMBER)
    public Double doubleValue;
    
    @Protobuf(order = UninterpretedOption.STRING_VALUE_FIELD_NUMBER)
    public String stringValue;
    
    @Protobuf(order = UninterpretedOption.AGGREGATE_VALUE_FIELD_NUMBER)
    public String aggregateValue;

    @Override
    public String toString() {
        return "UninterpretedOptionPOJO [names=" + names + ", identifierValue=" + identifierValue
                + ", positiveIntValue=" + positiveIntValue + ", negativeIntValue=" + negativeIntValue + ", doubleValue="
                + doubleValue + ", stringValue=" + stringValue + ", aggregateValue=" + aggregateValue + "]";
    }
    
    
}
