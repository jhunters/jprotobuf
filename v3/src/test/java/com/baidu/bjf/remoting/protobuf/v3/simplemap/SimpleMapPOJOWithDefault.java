/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.v3.simplemap;

import java.util.Map;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

/**
 * Simple pojo use map for key/value using String
 *
 * @author xiemalin
 * @since 2.0.0
 */
@ProtobufClass
public class SimpleMapPOJOWithDefault {

    @Protobuf(required = true)
    public String name;
    
    private Map<String, String> stringMap;

    /**
     * get the stringMap
     * @return the stringMap
     */
    public Map<String, String> getStringMap() {
        return stringMap;
    }

    /**
     * set stringMap value to stringMap
     * @param stringMap the stringMap to set
     */
    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    
    
}
