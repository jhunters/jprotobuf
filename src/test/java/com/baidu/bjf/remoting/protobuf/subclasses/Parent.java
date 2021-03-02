/*
 * Copyright (c) Baidu Inc. All rights reserved.
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.bjf.remoting.protobuf.subclasses;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class Parent.
 *
 * @author xiemalin
 * @since 2.3.1
 */
public class Parent {
    
    /** The name. */
    @Protobuf
    public String name;
    
    /** The age. */
    @Protobuf
    public int age;

    /**
     * getter method for property name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for property name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for property age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * setter method for property age.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Parent [name=" + name + ", age=" + age + "]";
    }
    
    

}
