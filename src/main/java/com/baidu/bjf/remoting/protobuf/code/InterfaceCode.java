/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.bjf.remoting.protobuf.code;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * The Class InterfaceCode.
 *
 * @author xiemalin
 * @since 1.11.12
 */
public class InterfaceCode {
    
    /** The Constant GENERIC_SUF. */
    private static final String GENERIC_SUF = ">";

    /** The Constant GENERIC_PRE. */
    private static final String GENERIC_PRE = "<";

    /** The Constant SENTENCE_COMMA. */
    public static final String SENTENCE_COMMA = ",";

    /** The name. */
    private String name;

    /** The generic names. */
    private Set<String> genericNames = new HashSet<String>();

    /**
     * To code.
     *
     * @return the string
     */
    public String toCode() {
        StringBuilder code = new StringBuilder();
        code.append(name);
        if (genericNames.isEmpty()) {
            return code.toString();
        }
        code.append(GENERIC_PRE);
        Iterator<String> iterator = genericNames.iterator();
        while (iterator.hasNext()) {
            code.append(iterator.next());
            
            if (iterator.hasNext()) {
                code.append(SENTENCE_COMMA);
            }
        }
        code.append(GENERIC_SUF);

        return code.toString();
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Instantiates a new interface code.
     *
     * @param name the name
     */
    public InterfaceCode(String name) {
        super();
        this.name = name;
    }

    /**
     * Adds the generic.
     *
     * @param genericName the generic name
     */
    public void addGeneric(String genericName) {
        genericNames.add(genericName);
    }

    /**
     * Gets the generic names.
     *
     * @return the generic names
     */
    public Set<String> getGenericNames() {
        return genericNames;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((genericNames == null) ? 0 : genericNames.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        InterfaceCode other = (InterfaceCode) obj;
        if (genericNames == null) {
            if (other.genericNames != null)
                return false;
        } else if (!genericNames.equals(other.genericNames)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }
}
