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
package com.baidu.bjf.remoting.protobuf.command;

import java.io.File;
import java.io.IOException;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;

/**
 * Command base launch class.
 * 
 * <pre>
 * Usage: java -jar  jprotobuf-jar-with-dependencies.jar  --java_out=.  test.proto
 * 
 * </pre>
 * 
 * @author xiemalin
 * @since 1.8.0
 */
public class Main {
    
    private static final String JAVA_OUT_ARG = "--java_out=";

    public static void main(String[] args) {
        // get current path
        File currentPath = new File(".");
        
        if (args == null || args.length < 1) {
            help();
            System.exit(-1);
        }
        
        // get java out path
        File javaOutPath = null;
        File protoPath = null;
        if (args.length > 1) {
         // more than 2 args
            if (args[0].startsWith(JAVA_OUT_ARG)) {
                javaOutPath = new File(StringUtils.removeStart(args[0], JAVA_OUT_ARG));
            }
            protoPath = new File(args[1]);
        } else {
            javaOutPath = currentPath;
            protoPath = new File(args[0]);
        }
        
        if (!protoPath.exists()) {
            System.out.println("proto file not found at " + protoPath.getAbsolutePath());
            System.exit(-1);
        }
        ProtobufIDLProxy.setFormatJavaField(true);
        try {
            ProtobufIDLProxy.generateSource(protoPath, javaOutPath);
            System.out.println("create success. output path=" + javaOutPath.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("create failed: " + e.getMessage());
        }
        System.exit(0);;
        
    }
    
    private static void help() {
        System.out.println(" Usage: java -jar  jprotobuf-jar-with-dependencies.jar  --java_out=.  test.proto");
    }
}
