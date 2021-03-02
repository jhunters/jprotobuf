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
 * The Class SubOne.
 *
 * @author xiemalin
 * @since 2.3.1
 */
public class SubOne extends Parent {

    /** The sub one name. */
    @Protobuf
    private String subOneName;

    /**
     * getter method for property subOneName.
     *
     * @return the subOneName
     */
    public String getSubOneName() {
        return subOneName;
    }

    /**
     * setter method for property subOneName.
     *
     * @param subOneName the subOneName to set
     */
    public void setSubOneName(String subOneName) {
        this.subOneName = subOneName;
    }

    @Override
    public String toString() {
        return "SubOne [subOneName=" + subOneName + ", name=" + name + ", age=" + age + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((subOneName == null) ? 0 : subOneName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SubOne other = (SubOne) obj;
        if (subOneName == null) {
            if (other.subOneName != null)
                return false;
        } else if (!subOneName.equals(other.subOneName))
            return false;
        return true;
    }
    
    
}
