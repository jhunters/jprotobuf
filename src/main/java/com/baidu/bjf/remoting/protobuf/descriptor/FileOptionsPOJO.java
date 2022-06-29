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
package com.baidu.bjf.remoting.protobuf.descriptor;

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.google.protobuf.DescriptorProtos.FileOptions;

/**
 * JProtobuf supports for {@link FileOptions}.
 *
 * @author xiemalin
 * @since 2.0.1
 */
public class FileOptionsPOJO {

    /** The java package. */
    @Protobuf(order = FileOptions.JAVA_PACKAGE_FIELD_NUMBER)
    public String javaPackage;
    
    /** The java outer classname. */
    @Protobuf(order = FileOptions.JAVA_OUTER_CLASSNAME_FIELD_NUMBER)
    public String javaOuterClassname;
    
    /** The optimize for. */
    @Protobuf(order = FileOptions.OPTIMIZE_FOR_FIELD_NUMBER, fieldType = FieldType.ENUM)
    public OptimizeMode optimizeFor;
    
    /** The java multiple files. */
    @Protobuf(order = FileOptions.JAVA_MULTIPLE_FILES_FIELD_NUMBER)
    public Boolean javaMultipleFiles;
    
    /** The go package. */
    @Protobuf(order = FileOptions.GO_PACKAGE_FIELD_NUMBER)
    public String goPackage;
    
    /** The cc generic services. */
    @Protobuf(order = FileOptions.CC_GENERIC_SERVICES_FIELD_NUMBER)
    public Boolean ccGenericServices;
    
    /** The java generic services. */
    @Protobuf(order = FileOptions.JAVA_GENERIC_SERVICES_FIELD_NUMBER)
    public Boolean javaGenericServices;
    
    /** The py generic services. */
    @Protobuf(order = FileOptions.PY_GENERIC_SERVICES_FIELD_NUMBER)
    public Boolean pyGenericServices;
    
    /** The java generate equals and hash. */
    @Protobuf(order = FileOptions.JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER)
    public Boolean javaGenerateEqualsAndHash;
    
    /** The deprecated. */
    @Protobuf(order = FileOptions.DEPRECATED_FIELD_NUMBER)
    public Boolean deprecated;
    
    /** The java string check utf 8. */
    @Protobuf(order = FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER)
    public Boolean javaStringCheckUtf8;
    
    /** The cc enable arenas. */
    @Protobuf(order = FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER)
    public Boolean ccEnableArenas;
    
    /** The uninterpreted options. */
    @Protobuf(order = FileOptions.UNINTERPRETED_OPTION_FIELD_NUMBER, fieldType = FieldType.OBJECT)
    public List<UninterpretedOptionPOJO> uninterpretedOptions;
}

