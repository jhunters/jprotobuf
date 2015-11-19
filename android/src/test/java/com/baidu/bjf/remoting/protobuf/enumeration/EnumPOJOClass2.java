/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.enumeration;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Simple enum test for 
 *
 * @author xiemalin
 * @since 1.4.0
 */
public class EnumPOJOClass2 {

    @Protobuf(fieldType = FieldType.ENUM)
    private EnumAttrPOJO enumAttr;

    /**
     * get the enumAttr
     * @return the enumAttr
     */
    public EnumAttrPOJO getEnumAttr() {
        return enumAttr;
    }

    /**
     * set enumAttr value to enumAttr
     * @param enumAttr the enumAttr to set
     */
    public void setEnumAttr(EnumAttrPOJO enumAttr) {
        this.enumAttr = enumAttr;
    }
    
    
}
