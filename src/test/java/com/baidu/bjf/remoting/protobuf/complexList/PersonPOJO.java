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
package com.baidu.bjf.remoting.protobuf.complexList;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 *
 * @author xiemalin
 *
 */
public class PersonPOJO {

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#toString()
     */

    public String toString() {
        return "PersonPOJO [name=" + name + ", id=" + id + ", email=" + email + "]";
    }

    @Protobuf(fieldType = FieldType.STRING, order = 1, required = true)
    public String name;
    @Protobuf(fieldType = FieldType.INT32, order = 2, required = true)
    public int id;
    @Protobuf(fieldType = FieldType.STRING, order = 3, required = false)
    public String email;

    @Protobuf(fieldType = FieldType.DOUBLE, order = 4, required = false)
    public Double doubleF;

    @Protobuf(fieldType = FieldType.FLOAT, order = 5, required = false)
    public Float floatF;

    @Protobuf(fieldType = FieldType.BYTES, order = 6, required = false)
    public byte[] bytesF;

    @Protobuf(fieldType = FieldType.BOOL, order = 7, required = false)
    public Boolean boolF;

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#getName()
     */

    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#setName(java.lang.String)
     */

    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#getId()
     */

    public int getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#setId(int)
     */

    public void setId(int id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#getEmail()
     */

    public String getEmail() {
        return email;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#setEmail(java.lang.String)
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#getDoubleF()
     */

    public Double getDoubleF() {
        return doubleF;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#setDoubleF(java.lang.Double)
     */

    public void setDoubleF(Double doubleF) {
        this.doubleF = doubleF;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#getFloatF()
     */

    public Float getFloatF() {
        return floatF;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#setFloatF(java.lang.Float)
     */

    public void setFloatF(Float floatF) {
        this.floatF = floatF;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#getBytesF()
     */

    public byte[] getBytesF() {
        return bytesF;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#setBytesF(byte[])
     */

    public void setBytesF(byte[] bytesF) {
        this.bytesF = bytesF;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#getBoolF()
     */

    public Boolean getBoolF() {
        return boolF;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.complexList.PersonPOJOBehavior#setBoolF(java.lang.Boolean)
     */

    public void setBoolF(Boolean boolF) {
        this.boolF = boolF;
    }

}
