/**
 * 
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
