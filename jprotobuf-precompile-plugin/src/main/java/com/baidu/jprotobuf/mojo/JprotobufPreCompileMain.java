/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.jprotobuf.mojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.baidu.bjf.remoting.protobuf.code.ICodeGenerator;
import com.baidu.bjf.remoting.protobuf.code.TemplateCodeGenerator;
import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.JDKCompilerHelper;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.baidu.bjf.remoting.protobuf.utils.compiler.JdkCompiler;

import edu.emory.mathcs.backport.java.util.Arrays;
import jodd.io.findfile.ClassScanner;

/**
 * The Class JprotobufPreCompileMain.
 *
 * @author xiemalin
 * @since 1.0
 * @since 1.2.12 增加多个包名前缀配置支持, 用;分隔
 */
public class JprotobufPreCompileMain {

    /** The Constant MULTI_PKG_SPLIT. */
    private static final String MULTI_PKG_SPLIT = ";";

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JprotobufPreCompileMain.class);

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        if (args == null || args.length == 0 || args.length != 6) {
            throw new RuntimeException(printUsage());
        }
        
        final boolean cacheBuildResult = Boolean.valueOf(args[5]);

        final File outputPath = new File(args[0] + File.separator + "temp");
        outputPath.mkdirs();
        
        if (!cacheBuildResult) {
            try {
                FileUtils.deleteDirectory(outputPath);
            } catch (Exception e) {
                // dummy exception
            }
        }

        JDKCompilerHelper.setCompiler(new JdkCompiler(Thread.currentThread().getContextClassLoader()));

        final String filterClassPackage = args[2];
        if (filterClassPackage == null) {
            return;
        }

        final String[] split = filterClassPackage.split(MULTI_PKG_SPLIT);

        final boolean generateProtofile = Boolean.valueOf(args[3]);

        final boolean compileDependencies = Boolean.valueOf(args[4]);
        
        final Set<Class> dependenciesClasses = new HashSet<Class>();

        final Set<Class> compiledClasses = new HashSet<Class>();
        
        final Set<Class<?>> cachedIDLTypes = new HashSet<Class<?>>();
        
        final Set<Class<?>> cachedIDLEnumTypes = new HashSet<Class<?>>();

        printInfo(split, generateProtofile, compileDependencies);

        ClassScanner scanner = new ClassScanner() {

            @Override
            protected void onEntry(EntryData entryData) throws Exception {
                String name = entryData.getName();
                if (!isStartWith(name, split)) {
                    return;
                }

                Class c = toClass(name);
                if (c == null) {
                    return;
                }

                if (compiledClasses.contains(c)) {
                    return;
                }

                if (Enum.class.isAssignableFrom(c)) {
                    return;
                }

                Annotation annotation = c.getAnnotation(ProtobufClass.class);
                if (annotation != null) {
                    try {
                        compiledClasses.add(c);
                        long tartMTime = ClassHelper.getLastModifyTime(c);
                        
                        // check if need compile
                        long mtime = getClassFileMTime(outputPath, c.getSimpleName(), getPackName(c));
                        if (tartMTime <= mtime) {
                            // no modify just continue
                            LOGGER.info("no modify class '" + c.getSimpleName() + "', will skip precompile.");
                            return;
                        }
                        
                        
                        ProtobufProxy.create(c, false, outputPath);
                        if (generateProtofile) {
                            createProtoFile(c, outputPath.getCanonicalPath(), cachedIDLTypes, cachedIDLEnumTypes);
                        }

                        if (compileDependencies) {
                            TemplateCodeGenerator tcg = new TemplateCodeGenerator(c);
                            tcg.getAllDependenciesClasses(dependenciesClasses);
                        }
                    } catch (Throwable e) {
                        throw new Exception(e.getMessage(), e);
                    }
                    return;
                }

                try {
                    List<Field> fields = null;
                    try {
                        fields = FieldUtils.findMatchedFields(c, Protobuf.class);
                    } catch (Exception e) {
                        return;
                    }
                    if (!fields.isEmpty()) {
                        compiledClasses.add(c);
                        long tartMTime = ClassHelper.getLastModifyTime(c);
                        // check if need compile
                        long mtime = getClassFileMTime(outputPath, c.getSimpleName(), getPackName(c));
                        if (tartMTime <= mtime) {
                            // no modify just continue
                            LOGGER.info("no modify class '" + c.getSimpleName() + "', will skip precompile.");
                            return;
                        }
                        
                        ProtobufProxy.create(c, false, outputPath);
                        if (generateProtofile) {
                            createProtoFile(c, outputPath.getCanonicalPath(), cachedIDLTypes, cachedIDLEnumTypes);
                        }
                        if (compileDependencies) {
                            TemplateCodeGenerator tcg = new TemplateCodeGenerator(c);
                            tcg.getAllDependenciesClasses(dependenciesClasses);
                        }
                    }
                } catch (Throwable e) {
                    throw new Exception(e.getMessage(), e);
                }
            }
        };

        scanner.scanDefaultClasspath();

        if (compileDependencies) {
            compiledClasses.addAll(dependenciesClasses);
            // compile dependencies classes
            for (Class cls : dependenciesClasses) {
                try {
                    // check if need compile
                    long tartMTime = ClassHelper.getLastModifyTime(cls);
                    long mtime = getClassFileMTime(outputPath, cls.getSimpleName(), getPackName(cls));
                    if (tartMTime <= mtime) {
                        // no modify just continue
                        LOGGER.info("no modify class '" + cls.getSimpleName() + "', will skip precompile.");
                        return;
                    }
                    
                    ProtobufProxy.create(cls, false, outputPath);
                    if (generateProtofile) {
                        createProtoFile(cls, outputPath.getCanonicalPath(), cachedIDLTypes, cachedIDLEnumTypes);
                    }
                } catch (Exception e) {
                    // dummy exception
                }
            }
        }
        LOGGER.info("JProtobuf pre compile finished. " + compiledClasses.size() + " classes compiled.");

        // copy files
        try {
            FileUtils.copyDirectory(outputPath, new File(args[1]));
        } catch (IOException e) {
        }

    }

    /**
     * Prints the info.
     *
     * @param split the split
     * @param generateProtofile the generate protofile
     * @param compileDependencies the compile dependencies
     */
    private static void printInfo(String[] split, boolean generateProtofile, boolean compileDependencies) {
        LOGGER.info("* filterClassPackages='" + Arrays.toString(split) + "'");
        LOGGER.info("* generateProtofile='" + generateProtofile + "'");
        LOGGER.info("* compileDependencies='" + compileDependencies + "'");
    }

    /**
     * Creates the proto file.
     *
     * @param c the c
     * @param outputPath the output path
     * @throws UnsupportedEncodingException the unsupported encoding exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void createProtoFile(Class<?> c, String outputPath, Set<Class<?>> cachedIDLTypes, 
            Set<Class<?>> cachedIDLEnumTypes) throws UnsupportedEncodingException, IOException {
        String code = ProtobufIDLGenerator.getIDL(c, cachedIDLTypes, cachedIDLEnumTypes);

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
            if (testString.startsWith(s) || PatternMatchUtils.simpleMatch(s, testString)) {
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
    private static Class toClass(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(name);
        } catch (Throwable e) {
        }
        return null;
    }
    
    private static long getClassFileMTime(File path, String originClsName, String pkg) {
        if (path != null && path.isDirectory()) {
            
            String className = originClsName + ICodeGenerator.DEFAULT_SUFFIX_CLASSNAME;
            if (className.indexOf('.') != -1) {
                pkg = StringUtils.substringBeforeLast(className, ".");
            }

            // mkdirs
            String dir = path + File.separator + pkg.replace('.', File.separatorChar);
            File f = new File(dir);
            
            File target = new File(f, className + ".class");
            if (target.exists()) {
                return target.lastModified();
            }
        }

        return -1;
    }
    
    private static String getPackName(Class c) {
        Package pkg = c.getPackage();
        if (pkg == null) {
            return "";
        }
        return pkg.getName();
    }

}
