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

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * 
 * @author xiemalin
 * 
 */
public class AddressBookProtosPOJO {

    @Protobuf(fieldType = FieldType.OBJECT, order = 1, required = false)
    private List<PersonPOJO> list;

    @Protobuf(fieldType = FieldType.ENUM, order = 2, required = false)
    public List<TypeDefEnum> typeList;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AddressBookProtosPOJO [list=" + list + "]";
    }

    /**
     * get the list
     * @return the list
     */
    public List<PersonPOJO> getList() {
        return list;
    }

    /**
     * set list value to list
     * @param list the list to set
     */
    public void setList(List<PersonPOJO> list) {
        this.list = list;
    }
    
    
}
