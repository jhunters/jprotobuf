/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.v3;

import java.util.Map;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * 
 * POJO class for demonstrate {@link Map} usage.
 *
 * @author xiemalin
 * @since 2.0.0
 */
public class AddressBookPOJO {

    @Protobuf(fieldType = FieldType.STRING, required = true, order = 1)
    private String name;
    
    @Protobuf(fieldType = FieldType.MAP)
    public Map<String, String> map;
}
