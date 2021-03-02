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

import java.util.Date;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class SimpleDatePOJO.
 *
 * @author xiemalin
 * @since 3.2.1
 */
public class SimpleDatePOJO {

    /** The date. */
    @Protobuf
    public Date date;
    
    /** The date 1. */
    @Protobuf
    private Date date1;
    

    /**
     * Sets the date 1.
     *
     * @param date1 the new date 1
     */
    public void setDate1(Date date1) {
        this.date1 = date1;
    }
    
    /**
     * Gets the date 1.
     *
     * @return the date 1
     */
    public Date getDate1() {
        return date1;
    }
    
}
