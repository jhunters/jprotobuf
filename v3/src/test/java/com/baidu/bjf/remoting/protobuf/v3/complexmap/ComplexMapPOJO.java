/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.v3.complexmap;

import java.util.Map;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Complex pojo use map for value using Enumeration and message object
 *
 * @author xiemalin
 * @since 2.0.0
 */
public class ComplexMapPOJO {

    @Protobuf(required = true) 
    public String name;
    
    @Protobuf(fieldType = FieldType.MAP)
    public Map<String, PhoneTypeEnumPOJO> phoneTypeEnumValueMap;
    
    @Protobuf(fieldType = FieldType.MAP)
    public Map<String, PhoneNumberPOJO> phoneNumberObjectValueMap;
    
}
