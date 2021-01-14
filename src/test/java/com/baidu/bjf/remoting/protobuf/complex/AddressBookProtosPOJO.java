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
package com.baidu.bjf.remoting.protobuf.complex;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

/**
 * The Class AddressBookProtosPOJO.
 *
 * @author xiemalin
 */
@ProtobufClass(description = "地址薄对象")
public class AddressBookProtosPOJO {

    /** The list. */
    @Protobuf(fieldType = FieldType.OBJECT, order=1, required = false, description = "成员列表")
    public PersonPOJO list;

    /** The name. */
    @Protobuf(fieldType = FieldType.STRING, order=2, required = false)
    public String name;
}
