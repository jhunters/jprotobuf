/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.bjf.remoting.protobuf;

/**
 * Supports to read enum element value
 * @author xiemalin
 * @since 1.4.0
 */
public interface EnumReadable {
    
    /**
     * @return the value of Enum element
     */
    int value();
}
