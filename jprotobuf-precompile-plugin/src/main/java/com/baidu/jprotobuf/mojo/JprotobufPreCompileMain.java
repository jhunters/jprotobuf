/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.jprotobuf.mojo;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.JDKCompilerHelper;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.baidu.bjf.remoting.protobuf.utils.compiler.JdkCompiler;

import jodd.io.findfile.ClassScanner;

/**
 * The Class JprotobufPreCompileMain.
 *
 * @author xiemalin
 * @since 1.0
 * @since 1.2.12 增加多个包名前缀配置支持, 用;分隔
 */
public class JprotobufPreCompileMain {
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JprotobufPreCompileMain.class);

    /** The Constant MULTI_PKG_SPLIT. */
    private static final String MULTI_PKG_SPLIT = ";";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        if (args == null || args.length == 0 || args.length != 4) {
            throw new RuntimeException(printUsage());
        }

        final File outputPath = new File(args[0] + File.separator + "temp");
        try {
            FileUtils.deleteDirectory(outputPath);
        } catch (Exception e) {
            // dummy exception
        }
        outputPath.mkdirs();

        JDKCompilerHelper.setCompiler(new JdkCompiler(Thread.currentThread().getContextClassLoader()));

        final String filterClassPackage = args[2];
        if (filterClassPackage == null) {
            LOGGER.error("filterClassPackage setting is null.");
            return;
        }

        final String[] split = filterClassPackage.split(MULTI_PKG_SPLIT);
        
        final boolean generateProtofile = Boolean .valueOf(args[3]);

        ClassScanner scanner = new ClassScanner() {

            @Override
            protected void onEntry(EntryData entryData) throws Exception {
                String name = entryData.getName();
                if (!isStartWith(name, split)) {
                    return;
                }

                Class c = getByClass(name);
                if (c == null) {
                    return;
                }
                
                
                if (Enum.class.isAssignableFrom(c)) {
                    return;
                }
                
                Annotation annotation = c.getAnnotation(ProtobufClass.class);
                if (annotation != null) {
                    try {
                            ProtobufProxy.create(c, false, outputPath);
                            if (generateProtofile) {
                                createProtoFile(c, outputPath.getCanonicalPath());
                            }
                    } catch (Throwable e) {
                        throw new Exception(e.getMessage(), e);
                    }
                    return;
                }
                

                try {
                    List<Field> fields = FieldUtils.findMatchedFields(c, Protobuf.class);
                    if (!fields.isEmpty()) {
                        ProtobufProxy.create(c, false, outputPath);
                        if (generateProtofile) {
                            createProtoFile(c, outputPath.getCanonicalPath());
                        }
                    }
                } catch (Throwable e) {
                    throw new Exception(e.getMessage(), e);
                }
            }
        };

        scanner.scanDefaultClasspath();

        // copy files
        try {
            FileUtils.copyDirectory(outputPath, new File(args[1]));
        } catch (IOException e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }

    }
    
    private static void createProtoFile(Class c,  String outputPath) throws UnsupportedEncodingException, IOException {
        String code = ProtobufIDLGenerator.getIDL(c);
        
        String pkg = "";
        String className = c.getName();
        if (className.indexOf('.') != -1) {
            pkg = StringUtils.substringBeforeLast(className, ".");
        }
        
        // mkdirs
        String dir = outputPath + File.separator + pkg.replace('.', File.separatorChar);
        File f = new File(dir);
        f.mkdirs();
        String fileName = c.getSimpleName() + ".proto";
        File file = new File(dir, fileName);
        LOGGER.info("Generate proto file to " + file.getAbsolutePath());
        FileUtils.writeByteArrayToFile(file, code.getBytes("utf-8"));
    }

    /**
     * Prints the usage.
     *
     * @return the string
     */
    private static String printUsage() {
        return "Usage: " + JprotobufPreCompileMain.class.getName() + " outputFile";
    }

    /**
     * Checks if is start with.
     *
     * @param testString the test string
     * @param targetStrings the target strings
     * @return true, if is start with
     */
    private static boolean isStartWith(String testString, String[] targetStrings) {
        for (String s : targetStrings) {
            if (testString.startsWith(s)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Gets the by class.
     *
     * @param name the name
     * @return the by class
     */
    private static Class getByClass(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(name);
        } catch (Throwable e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }
        return null;
    }

}
