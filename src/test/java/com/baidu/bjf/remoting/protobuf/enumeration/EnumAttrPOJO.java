/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.enumeration;

import com.baidu.bjf.remoting.protobuf.EnumReadable;

/**
 * Enum pojo class
 *
 * @author xiemalin
 * @since 1.4.0
 */
public enum EnumAttrPOJO implements EnumReadable {

    STRING(100), INT(50);
    
    private final int value;


    EnumAttrPOJO(int value) { this.value = value; }

    public int toValue() { return this.value; }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.Enumable#value()
     */
    public int value() {
        return toValue();
    }
    
}
