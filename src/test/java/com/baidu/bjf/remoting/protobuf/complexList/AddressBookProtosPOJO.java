/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
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
