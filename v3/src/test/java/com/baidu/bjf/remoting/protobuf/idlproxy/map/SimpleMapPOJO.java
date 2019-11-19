/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.idlproxy.map;

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
    private Map<String, String> stringMap;
    
    @Protobuf(fieldType = FieldType.MAP)
    private Map<String, byte[]>  bytesMap;
    
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

    /**
     * getter method for property bytesMap
     * @return the bytesMap
     */
    public Map<String, byte[]> getBytesMap() {
        return bytesMap;
    }

    /**
     * setter method for property bytesMap
     * @param bytesMap the bytesMap to set
     */
    public void setBytesMap(Map<String, byte[]> bytesMap) {
        this.bytesMap = bytesMap;
    }

    
    
}
