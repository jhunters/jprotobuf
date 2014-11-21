/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.simplestring;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Single string field pojo test class
 *
 * @author xiemalin
 *
 */
public class StringTypePOJOClass {

    @Protobuf(fieldType = FieldType.STRING, order = 1, required = true)
    private String str;

    /**
     * get the str
     * @return the str
     */
    public String getStr() {
        return str;
    }

    /**
     * set str value to str
     * @param str the str to set
     */
    public void setStr(String str) {
        this.str = str;
    }
    
    
}
