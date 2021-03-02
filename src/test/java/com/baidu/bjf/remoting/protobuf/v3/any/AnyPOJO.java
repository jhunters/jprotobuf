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
package com.baidu.bjf.remoting.protobuf.v3.any;

import java.util.List;

import com.baidu.bjf.remoting.protobuf.Any;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class AnyPOJO.
 *
 * @author xiemalin
 * @since 2.4.3
 */
public class AnyPOJO {
    // string message = 1;
    // repeated google.protobuf.Any details = 2;
    
    /** The message. */
    @Protobuf
    private String message;
    
    /** The details. */
    @Protobuf(fieldType = FieldType.OBJECT)
    private List<Any> details;
    
    
    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Sets the details.
     *
     * @param details the new details
     */
    public void setDetails(List<Any> details) {
        this.details = details;
    }
    
    /**
     * Gets the details.
     *
     * @return the details
     */
    public List<Any> getDetails() {
        return details;
    }
    
    
}
