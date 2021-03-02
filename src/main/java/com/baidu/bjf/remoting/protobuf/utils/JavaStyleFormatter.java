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
package com.baidu.bjf.remoting.protobuf.utils;

/**
 * The Class JavaStyleFormatter.
 *
 * @author xiemalin
 * @since 1.11.13
 */
public class JavaStyleFormatter {

    
    /**
     * Format java field name.
     *
     * @param fieldName the field name
     * @return the string
     */
    public static String formatJavaFieldName(String fieldName) {
        if (StringUtils.isEmpty(fieldName)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        // remove _ and $ char
        int length = fieldName.length();
        boolean isJoinStart = false;
        for (int i = 0; i < length; i++) {
            char charAt = fieldName.charAt(i);
            if (charAt == '_' || charAt == '$') {
                isJoinStart = true;
            } else {
                if (i == 0) { // first char
                    charAt = Character.toLowerCase(charAt);
                    builder.append(charAt);
                } else {
                    if (isJoinStart) {
                        charAt = Character.toUpperCase(charAt);
                        builder.append(charAt);
                        isJoinStart = false;
                    } else {
                        builder.append(charAt);
                    }
                }
            }
            
        }
        
        return StringUtils.uncapitalize(builder.toString());
    }
    
}
