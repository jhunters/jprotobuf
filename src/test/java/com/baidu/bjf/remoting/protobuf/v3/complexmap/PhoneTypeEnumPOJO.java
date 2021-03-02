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
package com.baidu.bjf.remoting.protobuf.v3.complexmap;

import java.io.UnsupportedEncodingException;

import com.baidu.bjf.remoting.protobuf.EnumReadable;

/**
 * POJO test for enumeration type.
 * 
 * @author xiemalin
 * @since 2.0.0
 */
public enum PhoneTypeEnumPOJO implements EnumReadable {

    MOBILE(0), HOME(1), WORK(2);

    private int value;

    /**
     * @param value
     */
    private PhoneTypeEnumPOJO(int value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.EnumReadable#value()
     */
    @Override
    public int value() {
        return value;
    }

    public static void main(String[] args) {
        try {
         // Convert from Unicode to UTF-8
         String string = "a\u7f51a";
         byte[] utf8 = string.getBytes("UTF-8");
         // Convert from UTF-8 to Unicode
         string = new String(utf8, "UTF-8");
         System.out.println(string);
         } catch (UnsupportedEncodingException e) {
         }
    }
}
