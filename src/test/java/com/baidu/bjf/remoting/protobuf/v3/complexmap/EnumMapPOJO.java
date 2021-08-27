package com.baidu.bjf.remoting.protobuf.v3.complexmap;

import java.util.Map;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.baidu.bjf.remoting.protobuf.enumeration.EnumAttrPOJO;

@ProtobufClass
public class EnumMapPOJO {

    @Protobuf(fieldType = FieldType.MAP)
    public Map<EnumAttrPOJO, String> keyEnumMap;

    @Protobuf(fieldType = FieldType.MAP)
    public Map<String, EnumAttrPOJO> valEnumMap;

    @Protobuf(fieldType = FieldType.MAP)
    public Map<EnumAttrPOJO, EnumAttrPOJO> enumMap;
}


