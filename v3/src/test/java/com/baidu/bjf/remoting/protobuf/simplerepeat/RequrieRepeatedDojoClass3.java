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
package com.baidu.bjf.remoting.protobuf.simplerepeat;

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * RequrieRepeatedDojoClass3
 * 
 * @author xiemalin
 * @since 1.0
 */
public class RequrieRepeatedDojoClass3 {

    @Protobuf(fieldType = FieldType.STRING, order = 1, required = false)
    private List<String> list;

    protected List<String> getList() {
        return list;
    }

    protected void setList(List<String> list) {
        this.list = list;
    }

}
