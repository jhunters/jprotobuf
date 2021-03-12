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
package com.baidu.bjf.remoting.protobuf.code;

import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.google.protobuf.Descriptors.Descriptor;

/**
 * Code template utility class.
 * 
 * @author xiemalin
 * @since 1.10.5
 */
public class CodeTemplate {

    
    /**
     * Get getDescriptor method source by template.
     *
     * @param cls the cls
     * @return the source code for getDescriptor method
     */
    public static String descriptorMethodSource(Class cls) {
        String descriptorClsName = ClassHelper.getInternalName(Descriptor.class.getCanonicalName());
        
        String code = "if (this.descriptor != null) {" + ClassCode.LINE_BREAK  +
                            "return this.descriptor;" + ClassCode.LINE_BREAK  +
                       "}" + ClassCode.LINE_BREAK +
                       "%s descriptor = CodedConstant.getDescriptor(%s);" + ClassCode.LINE_BREAK  +
                       "return (this.descriptor = descriptor);"; 
        
        return String.format(code, descriptorClsName, 
                ClassHelper.getInternalName(cls.getCanonicalName()) + ICodeGenerator.JAVA_CLASS_FILE_SUFFIX);
        
    }
    
    
}
