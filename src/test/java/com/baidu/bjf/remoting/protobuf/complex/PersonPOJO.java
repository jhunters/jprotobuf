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
import com.baidu.bjf.remoting.protobuf.enumeration.EnumAttrPOJO;

/**
 * The Class PersonPOJO.
 *
 * @author xiemalin
 */
public class PersonPOJO {

    /** The name. */
    @Protobuf(fieldType = FieldType.STRING, order=1, required = true)
    public String name;
    
    /** The id. */
    @Protobuf(fieldType = FieldType.INT32, order=2, required = true)
    public int id;
    
    /** The email. */
    @Protobuf(fieldType = FieldType.STRING, order=3, required = false)
    public String email;
    
    /** The double f. */
    @Protobuf(fieldType = FieldType.DOUBLE, order=4, required = false)
    public Double doubleF;
    
    
    /** The float f. */
    @Protobuf(fieldType = FieldType.FLOAT, order=5, required = false)
    public Float floatF;
    
    /** The bytes f. */
    @Protobuf(fieldType = FieldType.BYTES, order=6, required = false)
    public byte[] bytesF;
    
    /** The bool f. */
    @Protobuf(fieldType=FieldType.BOOL, order=7, required=false)
    public Boolean boolF;    
    
}
