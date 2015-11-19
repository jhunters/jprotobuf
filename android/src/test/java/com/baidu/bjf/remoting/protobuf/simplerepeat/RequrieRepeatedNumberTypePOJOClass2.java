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
 * RequrieRepeatedNumberTypePOJOClass2
 * @author xiemalin
 *
 */
public class RequrieRepeatedNumberTypePOJOClass2 {

    @Protobuf(fieldType = FieldType.INT32, order = 1, required = false)
    public List<Integer> list1;
}
