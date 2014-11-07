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
package com.baidu.bjf.remoting.protobuf.bytestest;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Test single private byte array field
 * 
 * @author xiemalin
 * @since 1.0.9
 */
public class ByteTypeClass4 {
    @Protobuf(fieldType = FieldType.BYTES)
    private Byte[] bytes;
    
    private Byte[] bytes2;

    /**
     * get the bytes2
     * @return the bytes2
     */
    public Byte[] getBytes2() {
        return bytes2;
    }

    /**
     * set bytes2 value to bytes2
     * @param bytes2 the bytes2 to set
     */
    public void setBytes2(Byte[] bytes2) {
        this.bytes2 = bytes2;
    }
    
    public Byte[] bytes3;
}
