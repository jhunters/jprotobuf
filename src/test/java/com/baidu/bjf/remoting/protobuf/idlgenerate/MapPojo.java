package com.baidu.bjf.remoting.protobuf.idlgenerate;

import java.util.Map;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

public class MapPojo {

    @Protobuf
    private Map<String, TestObject> mapField;
    
    @Protobuf
    private TestObject testObject2;
}
