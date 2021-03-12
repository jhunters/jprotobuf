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
package com.baidu.bjf.remoting.protobuf;

import java.util.List;
import java.util.Map;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class SimplePoJoForGenerator.
 */
public class SimplePoJoForGenerator {

    
    /** The s. */
    @Protobuf
    public String s;
    
    /** The age. */
    @Protobuf
    private int age;
    
    /** The address. */
    @Protobuf
    private String address;
    
    /** The messages. */
    @Protobuf
    private List<String> messages;
    
    /** The email address. */
    @Protobuf
    private List<String> emailAddress;
    
    /** The others. */
    @Protobuf
    private Map<String, String> others;
    
    /** The table. */
    @Protobuf
    private Map<String, String> table;
    
    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    
    /**
     * Sets the email address.
     *
     * @param emailAddress the new email address
     */
    public void setEmailAddress(List<String> emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public List<String> getEmailAddress() {
        return emailAddress;
    }
    
    /**
     * Sets the table.
     *
     * @param table the table
     */
    public void setTable(Map<String, String> table) {
        this.table = table;
    }
    
    /**
     * Gets the table.
     *
     * @return the table
     */
    public Map<String, String> getTable() {
        return table;
    }
    
}
