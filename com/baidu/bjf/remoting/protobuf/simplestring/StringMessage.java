package com.baidu.bjf.remoting.protobuf.simplestring;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class StringMessage {
/**
* 
* required string message=1
*/
@Protobuf(fieldType=FieldType.STRING, order=1, required=true)
public String message="hello";
}
