/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.jprotobuf.pbrpc.meta;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * Rpc service description info
 * 
 * @author xiemalin
 * @since 2.1
 */
public class RpcServiceMeta {

    @Protobuf(description = "RPC 服务名称")
    private String serviceName;
    
    @Protobuf
    private String methodName;
    
    @Protobuf
    private String inputProto;
    
    @Protobuf
    private String outputProto;

    /**
     * get the serviceName
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * set serviceName value to serviceName
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * get the methodName
     * @return the methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * set methodName value to methodName
     * @param methodName the methodName to set
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * get the inputProto
     * @return the inputProto
     */
    public String getInputProto() {
        return inputProto;
    }

    /**
     * set inputProto value to inputProto
     * @param inputProto the inputProto to set
     */
    public void setInputProto(String inputProto) {
        this.inputProto = inputProto;
    }

    /**
     * get the outputProto
     * @return the outputProto
     */
    public String getOutputProto() {
        return outputProto;
    }

    /**
     * set outputProto value to outputProto
     * @param outputProto the outputProto to set
     */
    public void setOutputProto(String outputProto) {
        this.outputProto = outputProto;
    }
    
    
}
