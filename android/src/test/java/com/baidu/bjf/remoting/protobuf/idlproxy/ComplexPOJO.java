/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.bjf.remoting.protobuf.idlproxy;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Simple POJO class without sub object type field.
 *
 * @author xiemalin
 * @since 1.0.6
 */
public class ComplexPOJO {

    @Protobuf(fieldType = FieldType.STRING, order = 1, required = false)
    private String name;
    
    @Protobuf(fieldType = FieldType.INT32, order = 2, required = false)
    private int age;
    
    @Protobuf(fieldType = FieldType.OBJECT, order = 3, required = false)
    private SimplePOJO simplePOJO;

    /**
     * get the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * set name value to name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the age
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * set age value to age
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * get the simplePOJO
     * @return the simplePOJO
     */
    public SimplePOJO getSimplePOJO() {
        return simplePOJO;
    }

    /**
     * set simplePOJO value to simplePOJO
     * @param simplePOJO the simplePOJO to set
     */
    public void setSimplePOJO(SimplePOJO simplePOJO) {
        this.simplePOJO = simplePOJO;
    }
    
    
}
