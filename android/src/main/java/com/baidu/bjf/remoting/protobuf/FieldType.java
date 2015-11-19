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
package com.baidu.bjf.remoting.protobuf;

import com.google.protobuf.WireFormat;


/**
 * Field type for Protobuf.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public enum FieldType {
    
    /**
     * types defined in .proto file.
     */
    DOUBLE  ("Double", "double"     , "WIRETYPE_FIXED64", ".doubleValue()", WireFormat.FieldType.DOUBLE         ,"0d"),
    FLOAT   ("Float", "float", "WIRETYPE_FIXED32"    ,    ".floatValue()",  WireFormat.FieldType.FLOAT ,"0f"),
    INT64   ("Long", "int64"      , "WIRETYPE_VARINT"    ,    ".longValue()",  WireFormat.FieldType.INT64  ,"0L"    ),
    UINT64  ("Long", "uInt64"      , "WIRETYPE_VARINT"   ,    ".longValue()",  WireFormat.FieldType.UINT64    ,"0L"  ),
    INT32   ("Integer", "int32"   , "WIRETYPE_VARINT"    ,    ".intValue()" ,  WireFormat.FieldType.INT32   ,"0" ),
    FIXED64 ("Long", "fixed64"       , "WIRETYPE_FIXED64"    ,    ".longValue()" ,  WireFormat.FieldType.FIXED64   ,"0L" ),
    FIXED32 ("Integer", "fixed32"        , "WIRETYPE_FIXED32"   ,    ".intValue()",  WireFormat.FieldType.FIXED32  ,"0"  ),
    BOOL    ("Boolean", "bool"     , "WIRETYPE_VARINT"      , ".booleanValue()",  WireFormat.FieldType.BOOL   ,"false" ),
    STRING  ("String", "string"     , "WIRETYPE_LENGTH_DELIMITED", "",  WireFormat.FieldType.STRING ,"\"\""),
    BYTES   ("byte[]", "bytes", "WIRETYPE_LENGTH_DELIMITED", "",  WireFormat.FieldType.BYTES,  "new byte[0]"),
    UINT32  ("Integer", "uInt32"        , "WIRETYPE_VARINT"    ,    ".intValue()" ,  WireFormat.FieldType.UINT32 ,"0"    ),
    SFIXED32("Integer", "sFixed32"       , "WIRETYPE_FIXED32"   ,    ".intValue()" ,  WireFormat.FieldType.SFIXED32  ,"0"  ),
    SFIXED64("Long", "sFixed64"      , "WIRETYPE_FIXED64"   ,    ".longValue()" ,  WireFormat.FieldType.SFIXED64    ,"0L" ),
    SINT32  ("Integer", "sInt32"        , "WIRETYPE_VARINT"     ,    ".intValue()" ,  WireFormat.FieldType.SINT32  ,"0"  ),
    SINT64  ("Long", "sInt64"       , "WIRETYPE_VARINT"    ,    ".longValue()" ,  WireFormat.FieldType.SINT64   ,"0L"  ),
    OBJECT  ("Object", "object"       , "WIRETYPE_LENGTH_DELIMITED"    ,    ""    ,  WireFormat.FieldType.MESSAGE ,null ),
    ENUM ("Enum", "enum"       , "WIRETYPE_VARINT"    ,    ".ordinal()"    ,  WireFormat.FieldType.ENUM , null ),
    DEFAULT("", ""       , ""    ,    ""    ,  WireFormat.FieldType.MESSAGE , null );
    
    /**
     * java original type
     */
    private final String javaType;
    /**
     * protobuf type
     */
    private final String type;
    /**
     * protobuf wire format type
     */
    private final String wireFormat;
    
    /**
     * to primitive type
     */
    private final String toPrimitiveType;
    
    /**
     * internal field type
     */
    private WireFormat.FieldType internalFieldType;
    
    /**
     * default value
     */
    private String defaultValue;

    /**
     * get the defaultValue
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * set defaultValue value to defaultValue
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * get the internalFieldType
     * @return the internalFieldType
     */
    public WireFormat.FieldType getInternalFieldType() {
        return internalFieldType;
    }

    /**
     * set internalFieldType value to internalFieldType
     * @param internalFieldType the internalFieldType to set
     */
    public void setInternalFieldType(WireFormat.FieldType internalFieldType) {
        this.internalFieldType = internalFieldType;
    }

    /**
     * get primitive type in string
     * @return primitive type in string
     */
    protected String getToPrimitiveType() {
        return toPrimitiveType;
    }

    /**
     * get protobuf wire format type
     * @return protobuf wire format type
     */
    public String getWireFormat() {
        return wireFormat;
    }

    /**
     * get protobuf type
     * @return protobuf type
     */
    public String getType() {
        return type;
    }

    /** 
     * get java original type
     * @return java original type
     */
    public String getJavaType() {
        return javaType;
    }

    /**
     * Constructor method
     * 
     * @param javaType java original type
     * @param type protobuf type
     * @param wireFormat protobuf wire format type
     */
    FieldType(String javaType, String type, String wireFormat,
            String toPrimitiveType, WireFormat.FieldType internalFieldType, String defaultValue) {
        this.javaType = javaType;
        this.type = type;
        this.wireFormat = wireFormat;
        this.toPrimitiveType = toPrimitiveType;
        this.internalFieldType = internalFieldType;
        this.defaultValue = defaultValue;
    }
    
    
}
