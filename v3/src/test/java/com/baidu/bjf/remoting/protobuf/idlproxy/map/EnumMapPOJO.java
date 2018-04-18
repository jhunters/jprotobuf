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
import com.baidu.bjf.remoting.protobuf.enumeration.EnumAttrPOJO;

/**
 * Simple pojo use map for key/value using String, Integer, Long and Boolean
 *
 * @author xiemalin
 * @since 2.0.0
 */
public class EnumMapPOJO {

    @Protobuf(required = false)
    public String name;
    
    @Protobuf(fieldType = FieldType.MAP)
    private Map<String, EnumAttrPOJO> stringMap;
    
    /**
     * get the stringMap
     * @return the stringMap
     */
    public Map<String, EnumAttrPOJO> getStringMap() {
        return stringMap;
    }

    /**
     * set stringMap value to stringMap
     * @param stringMap the stringMap to set
     */
    public void setStringMap(Map<String, EnumAttrPOJO> stringMap) {
        this.stringMap = stringMap;
    }

    
    
}
