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
package com.baidu.bjf.remoting.protobuf.packed;

import java.util.ArrayList;
import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Packed;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * The Class PackedProtosPOJO.
 * 
 * @author xiemalin
 * @since 2.0.5
 */
public class PackedProtosPOJO {

    @Protobuf(fieldType = FieldType.STRING, order = 1)
    private List<String> name = new ArrayList<String>();
    
    @Packed
    @Protobuf(fieldType = FieldType.INT32, order = 2)
    private List<Integer> id = new ArrayList<Integer>();
    
    @Packed
    @Protobuf(fieldType = FieldType.INT32, order = 12)
    public List<Integer> id2 = new ArrayList<Integer>();

    @Protobuf(fieldType = FieldType.STRING, order = 3)
    private List<String> email = new ArrayList<String>();

    @Protobuf(fieldType = FieldType.DOUBLE, order = 4)
    private List<Double> doubleF = new ArrayList<Double>();

    @Protobuf(fieldType = FieldType.FLOAT, order = 5)
    private List<Float> floatF = new ArrayList<Float>();

    @Protobuf(fieldType = FieldType.BYTES, order = 6)
    private List<byte[]> bytesF = new ArrayList<byte[]>();

    @Protobuf(fieldType = FieldType.BOOL, order = 7)
    private List<Boolean> boolF = new ArrayList<Boolean>();

    /**
     * @return the name
     */
    public List<String> getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(List<String> name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public List<String> getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(List<String> email) {
        this.email = email;
    }


    /**
     * @return the doubleF
     */
    public List<Double> getDoubleF() {
        return doubleF;
    }

    /**
     * @param doubleF the doubleF to set
     */
    public void setDoubleF(List<Double> doubleF) {
        this.doubleF = doubleF;
    }

    /**
     * @return the floatF
     */
    public List<Float> getFloatF() {
        return floatF;
    }

    /**
     * @param floatF the floatF to set
     */
    public void setFloatF(List<Float> floatF) {
        this.floatF = floatF;
    }

    /**
     * @return the bytesF
     */
    public List<byte[]> getBytesF() {
        return bytesF;
    }

    /**
     * @param bytesF the bytesF to set
     */
    public void setBytesF(List<byte[]> bytesF) {
        this.bytesF = bytesF;
    }

    /**
     * @return the boolF
     */
    public List<Boolean> getBoolF() {
        return boolF;
    }

    /**
     * @param boolF the boolF to set
     */
    public void setBoolF(List<Boolean> boolF) {
        this.boolF = boolF;
    }

    /**
     * @return the floatF
     */
    public List<Integer> getId() {
        return id;
    }

    /**
     * @param floatF the floatF to set
     */
    public void setId(List<Integer> id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PackedProtosPOJO [name=");
        builder.append(name);
        builder.append(", id=");
        builder.append(id);
        builder.append(", email=");
        builder.append(email);
        builder.append(", doubleF=");
        builder.append(doubleF);
        builder.append(", floatF=");
        builder.append(floatF);
        builder.append(", bytesF=");
        builder.append(bytesF);
        builder.append(", boolF=");
        builder.append(boolF);
        builder.append("]");
        return builder.toString();
    }

}
