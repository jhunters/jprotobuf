package com.baidu.bjf.remoting.protobuf.utils;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;

/***
 * for test
 * @author qiunet
 * 2022/8/18 09:36
 */
@ProtobufClass
public class TempObj {
    @Protobuf
    private int val;

    public TempObj() {}

    public TempObj(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
