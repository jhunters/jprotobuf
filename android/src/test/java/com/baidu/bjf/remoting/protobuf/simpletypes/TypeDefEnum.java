/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.simpletypes;

import com.baidu.bjf.remoting.protobuf.EnumReadable;

/**
 * Test pojo enum class.
 * 
 * @author xiemalin
 * @since 1.5.8 
 */
public enum TypeDefEnum implements EnumReadable {

    TEXT(1), NUMBER(2), DECIMAL(4), ID(8), URL(16);

    private final int value;

    TypeDefEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
