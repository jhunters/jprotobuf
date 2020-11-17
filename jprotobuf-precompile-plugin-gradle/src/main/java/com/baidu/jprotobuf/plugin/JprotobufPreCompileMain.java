/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.jprotobuf.plugin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.tools.SimpleJavaFileObject;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.baidu.bjf.remoting.protobuf.code.TemplateCodeGenerator;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;

import jodd.io.findfile.ClassScanner;

/**
 * The Class JprotobufPreCompileMain.
 *
 * @author xiemalin
 * @since 1.0
 */
public class JprotobufPreCompileMain {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JprotobufPreCompileMain.class);

    /** The Constant MULTI_PKG_SPLIT. */
    private static final String MULTI_PKG_SPLIT = ";";

    protected static List<File> classFiles;
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        if (args == null || args.length == 0 || args.length != 4) {
            throw new RuntimeException(printUsage());
        }

        final File outputPath = new File(args[0] + File.separator + PrecompilePlugin.CLASSES_PATH);
        final File outputTempPath =
                new File(args[0] + File.separator + "temp" + File.separator + PrecompilePlugin.CLASSES_PATH);

        try {
            FileUtils.deleteDirectory(outputTempPath);
        } catch (Exception e) {
            // dummy exception
        }
        outputPath.mkdirs();

        // JDKCompilerHelper.setCompiler(new JdkCompiler(classLoader));

        final String filterClassPackage = args[2];
        if (filterClassPackage == null) {
            LOGGER.error("filterClassPackage setting is null.");
            return;
        }

        final String[] split = filterClassPackage.split(MULTI_PKG_SPLIT);

        final boolean generateProtofile = Boolean.valueOf(args[3]);

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

                if (Enum.class.isAssignableFrom(c)) {
                    return;
                }
                JdkCompiler jdkCompiler = new JdkCompiler(Protobuf.class.getClassLoader(), classFiles);

                Annotation annotation = c.getAnnotation(ProtobufClass.class);
                if (annotation != null) {
                    try {
                        // compile to target path
                        doCompile(outputTempPath, generateProtofile, jdkCompiler, c);
                        if (generateProtofile) {
                            createProtoFile(c, outputPath.getCanonicalPath());
                        }
                    } catch (Throwable e) {
                        throw new Exception(e.getMessage(), e);
                    }
                    return;
                }

                try {
                    List<Field> fields = findMatchedFields(c, Protobuf.class);
                    if (!fields.isEmpty()) {
                        // compile to target path
                        doCompile(outputTempPath, generateProtofile, jdkCompiler, c);
                    }
                } catch (Throwable e) {
                    throw new Exception(e.getMessage(), e);
                }
            }

            private void doCompile(final File outputTempPath, final boolean generateProtofile, JdkCompiler jdkCompiler,
                    Class c) throws FileNotFoundException, UnsupportedEncodingException, IOException {
                TemplateCodeGenerator source = new TemplateCodeGenerator(c);
                String pkg = "";
                String className = c.getName();
                if (className.indexOf('.') != -1) {
                    pkg = StringUtils.substringBeforeLast(className, ".");
                }
                String dir = outputTempPath + File.separator + pkg.replace('.', File.separatorChar);
                new File(dir).mkdirs();

                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(new File(dir, source.getClassName() + ".class"));
                    jdkCompiler.compile(source.getFullClassName(), source.getCode(),
                            Protobuf.class.getClassLoader(), fileOutputStream, 0L);

                } finally {
                    try {
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e) {
                    }
                }

                if (generateProtofile) {
                    createProtoFile(c, outputTempPath.getCanonicalPath());
                }
            }

        };

        scanner.scanDefaultClasspath();
        
        // copy files
        try {
            FileUtils.copyDirectory(outputTempPath, outputPath);
        } catch (IOException e) {
        }

    }

    /**
     * Creates the proto file.
     *
     * @param c the c
     * @param outputPath the output path
     * @throws UnsupportedEncodingException the unsupported encoding exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void createProtoFile(Class c, String outputPath) throws UnsupportedEncodingException, IOException {
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
     * Checks if is start with or pattern match with.
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
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }
        return null;
    }

    public static List<Field> findMatchedFields(Class targetClass, Class ann) {

        List<Field> ret = new ArrayList<Field>();
        if (targetClass == null) {
            return ret;
        }

        // Keep backing up the inheritance hierarchy.
        do {
            // Copy each field declared on this class unless it's static or
            // file.
            Field[] fields = targetClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (ann == null) {
                    ret.add(fields[i]);
                    continue;
                }
                Annotation protobuf = fields[i].getAnnotation(ann);
                if (protobuf != null) {
                    ret.add(fields[i]);
                }
            }
            targetClass = targetClass.getSuperclass();
        } while (targetClass != null && targetClass != Object.class);

        return ret;
    }


    private static final class JavaFileObjectImpl extends SimpleJavaFileObject {

        /** The bytecode. */
        private ByteArrayOutputStream bytecode;

        /** The source. */
        private final CharSequence source;

        /**
         * Instantiates a new java file object impl.
         *
         * @param baseName the base name
         * @param source the source
         */
        public JavaFileObjectImpl(final String baseName, final CharSequence source) {
            super(ClassUtils.toURI(baseName + ClassUtils.JAVA_EXTENSION), Kind.SOURCE);
            this.source = source;
        }

        /**
         * Instantiates a new java file object impl.
         *
         * @param name the name
         * @param kind the kind
         */
        JavaFileObjectImpl(final String name, final Kind kind) {
            super(ClassUtils.toURI(name), kind);
            source = null;
        }

        /**
         * Instantiates a new java file object impl.
         *
         * @param uri the uri
         * @param kind the kind
         */
        public JavaFileObjectImpl(URI uri, Kind kind) {
            super(uri, kind);
            source = null;
        }

        /*
         * (non-Javadoc)
         * 
         * @see javax.tools.SimpleJavaFileObject#getCharContent(boolean)
         */
        @Override
        public CharSequence getCharContent(final boolean ignoreEncodingErrors) throws UnsupportedOperationException {
            if (source == null) {
                throw new UnsupportedOperationException("source == null");
            }
            return source;
        }

        /*
         * (non-Javadoc)
         * 
         * @see javax.tools.SimpleJavaFileObject#openInputStream()
         */
        @Override
        public InputStream openInputStream() {
            return new ByteArrayInputStream(getByteCode());
        }

        /*
         * (non-Javadoc)
         * 
         * @see javax.tools.SimpleJavaFileObject#openOutputStream()
         */
        @Override
        public OutputStream openOutputStream() {
            return bytecode = new ByteArrayOutputStream();
        }

        /**
         * Gets the byte code.
         *
         * @return the byte code
         */
        public byte[] getByteCode() {
            if (bytecode == null) {
                return null;
            }
            return bytecode.toByteArray();
        }
    }

}
