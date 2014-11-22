/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.jprotobuf.pbrpc.meta;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;

/**
 *
 * @author xiemalin
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String code = ProtobufIDLGenerator.getIDL(RpcServiceMetaList.class);
        System.out.println(code);
    }

}
