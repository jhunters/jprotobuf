/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.v3.simplemap;

import java.util.Map;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Simple pojo use map for key/value using String, Integer, Long and Boolean
 *
 * @author xiemalin
 * @since 2.0.0
 */
public class SimpleMapPOJO {

    @Protobuf(required = true)
    public String name;
    
    @Protobuf(fieldType = FieldType.MAP)
    public Map<String, String> stringMap;
    
    @Protobuf(fieldType = FieldType.MAP)
    public Map<Integer, Integer> intMap;
    
    @Protobuf(fieldType = FieldType.MAP)
    public Map<Long, Long> longMap;
    
    @Protobuf(fieldType = FieldType.MAP)
    public Map<Boolean, Boolean> booleanMap;
}
