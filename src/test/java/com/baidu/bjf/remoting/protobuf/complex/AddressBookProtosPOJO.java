/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.complex;

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 *
 * @author xiemalin
 *
 */
public class AddressBookProtosPOJO {

    @Protobuf(fieldType = FieldType.OBJECT, order=1, required = false)
    public PersonPOJO list;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AddressBookProtosPOJO [list=" + list + "]";
    }
}
