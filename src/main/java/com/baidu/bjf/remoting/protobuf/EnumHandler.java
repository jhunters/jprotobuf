/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.bjf.remoting.protobuf;

/**
 * Enum value handle interface
 * 
 * @author xiemalin
 * @since 2.1.9
 */
public interface EnumHandler<V> {

    V handle(int value);
}
