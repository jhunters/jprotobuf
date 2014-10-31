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


/**
 * Field type for Protobuf.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public enum FieldType {
	
	/**
	 * double type defined in .proto file.
	 */
    DOUBLE  ("Double", "double"     , "WIRETYPE_FIXED64", ".doubleValue()"         ),
    FLOAT   ("Float", "float", "WIRETYPE_FIXED32"    ,    ".floatValue()"),
    INT64   ("Long", "int64"      , "WIRETYPE_VARINT"    ,    ".longValue()"      ),
    UINT64  ("Long", "uInt64"      , "WIRETYPE_VARINT"   ,    ".longValue()"       ),
    INT32   ("Integer", "int32"   , "WIRETYPE_VARINT"    ,    ".intValue()"     ),
    FIXED64 ("Long", "fixed64"       , "WIRETYPE_FIXED64"    ,    ".longValue()"     ),
    FIXED32 ("Integer", "fixed32"        , "WIRETYPE_FIXED32"   ,    ".intValue()"      ),
    BOOL    ("Boolean", "bool"     , "WIRETYPE_VARINT"      , ".booleanValue()"    ),
    STRING  ("String", "string"     , "WIRETYPE_LENGTH_DELIMITED", ""),
    BYTES   ("byte[]", "bytes", "WIRETYPE_LENGTH_DELIMITED", ""),
    UINT32  ("Integer", "uInt32"        , "WIRETYPE_VARINT"    ,    ".intValue()"      ),
    SFIXED32("Integer", "sFixed32"       , "WIRETYPE_FIXED32"   ,    ".intValue()"      ),
    SFIXED64("Long", "sFixed64"      , "WIRETYPE_FIXED64"   ,    ".longValue()"      ),
    SINT32  ("Integer", "sInt32"        , "WIRETYPE_VARINT"     ,    ".intValue()"     ),
    SINT64  ("Long", "sInt64"       , "WIRETYPE_VARINT"    ,    ".longValue()"      ),
    OBJECT  ("Object", "object"       , "WIRETYPE_LENGTH_DELIMITED"    ,    ""      ),
    DEFAULT("", ""       , ""    ,    ""      );
	
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
	        String toPrimitiveType) {
		this.javaType = javaType;
		this.type = type;
		this.wireFormat = wireFormat;
		this.toPrimitiveType = toPrimitiveType;
	}
}
