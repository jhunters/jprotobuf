/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.v3.complexmap;

import com.baidu.bjf.remoting.protobuf.EnumReadable;

/**
 * POJO test for enumeration type.
 * 
 * @author xiemalin
 * @since 2.0.0
 */
public enum PhoneTypeEnumPOJO implements EnumReadable {

    MOBILE(0), HOME(1), WORK(2);

    private int value;

    /**
     * @param value
     */
    private PhoneTypeEnumPOJO(int value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.EnumReadable#value()
     */
    @Override
    public int value() {
        return value;
    }

}
