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
package com.baidu.bjf.remoting.protobuf.v3.date;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.Timestamp;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class DatePOJO.
 *
 * @author xiemalin
 * @since 3.2.0
 */
public class DatePOJO {

    /** The name. */
    @Protobuf
    private String name;
    
    @Protobuf(fieldType = FieldType.OBJECT)
    private Timestamp timeStamp;

    /**
     * getter method for property name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for property name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for property timeStamp
     * @return the timeStamp
     */
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    /**
     * setter method for property timeStamp
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "DatePOJO [name=" + name + ", timeStamp=" + timeStamp + "]";
    }
    
    
}
