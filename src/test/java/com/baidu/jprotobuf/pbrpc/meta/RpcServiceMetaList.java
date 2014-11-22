/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.jprotobuf.pbrpc.meta;

import java.util.List;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * {@link List} collection of {@link RpcServiceMeta}
 *
 * @author xiemalin
 * @since 1.0
 */
public class RpcServiceMetaList {

    @Protobuf(fieldType = FieldType.OBJECT, description = "RPC 方法说明")
    private List<RpcServiceMeta> rpcServiceMetas;

    /**
     * get the rpcServiceMetas
     * @return the rpcServiceMetas
     */
    public List<RpcServiceMeta> getRpcServiceMetas() {
        return rpcServiceMetas;
    }

    /**
     * set rpcServiceMetas value to rpcServiceMetas
     * @param rpcServiceMetas the rpcServiceMetas to set
     */
    public void setRpcServiceMetas(List<RpcServiceMeta> rpcServiceMetas) {
        this.rpcServiceMetas = rpcServiceMetas;
    }
}
