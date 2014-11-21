/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf.simplerepeat;

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * RequrieRepeatedNumberTypePOJOClass
 * @author xiemalin
 *
 */
public class RequrieRepeatedNumberTypePOJOClass {

    @Protobuf(fieldType = FieldType.STRING, order = 3, required = false)
    public List<String> list3;
}
