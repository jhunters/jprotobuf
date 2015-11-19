/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.complex;

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

    @Protobuf(fieldType = FieldType.STRING, order=2, required = false)
    public String name;
}
