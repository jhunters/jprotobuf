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
package com.baidu.bjf.remoting.protobuf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.annotation.Ignore;
import com.baidu.bjf.remoting.protobuf.code.ICodeGenerator;
import com.baidu.bjf.remoting.protobuf.code.TemplateCodeGenerator;
import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.CodePrinter;
import com.baidu.bjf.remoting.protobuf.utils.JDKCompilerHelper;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.baidu.bjf.remoting.protobuf.utils.compiler.Compiler;

/**
 * A simple protocol buffer encode and decode utility tool.
 * 
 * <pre>
 *   example code as follow:
 *   
 *   User user = new User();
 *   ...
 *   Codec<User> codec = ProtobufProxy.create(User.class);
 *   
 *   // do encode
 *   byte[] result = codec.encode(user);
 *   // do decode
 *   User user2 = codec.decode(result);
 * 
 * </pre>
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public final class ProtobufProxy {

    /** The Constant DEBUG_CONTROLLER. */
    public static final ThreadLocal<Boolean> DEBUG_CONTROLLER = new ThreadLocal<Boolean>();

    /** Logger for this class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProtobufProxy.class.getName());

    /**
     * cached {@link Codec} instance by class name.
     */
    private static final Map<String, Codec> CACHED = new ConcurrentHashMap<String, Codec>();

    /** The Constant OUTPUT_PATH for target directory to create generated source code out. */
    public static final ThreadLocal<File> OUTPUT_PATH = new ThreadLocal<File>();

    /** The Constant OUTPUT_PATH for target directory to create generated source code out. */
    public static final ThreadLocal<Boolean> CACHE_ENABLED = new ThreadLocal<Boolean>();

    /** The Constant for debug control from environment. */
    private static final String DEBUG_CONTROL = "X_DEBUG_ENABLE";

    /**
     * Clear cache.
     */
    public static void clearCache() {
        CACHED.clear();
    }

    /**
     * Compile.
     *
     * @param cls target class to be compiled
     * @param outputPath compile byte files output stream
     */
    public static void compile(Class<?> cls, File outputPath) {
        if (outputPath == null) {
            throw new NullPointerException("Param 'outputPath' is null.");
        }
        if (!outputPath.isDirectory()) {
            throw new RuntimeException("Param 'outputPath' value should be a path directory. path=" + outputPath);
        }

    }

    /**
     * To create a protobuf proxy class for target class.
     * 
     * @param <T> generic type
     * @param cls target class to parse <code>@Protobuf</code> annotation
     * @return {@link Codec} instance proxy
     */
    public static <T> Codec<T> create(Class<T> cls) {
        return create(cls, isDebugEnabled());
    }

    /**
     * Creates the.
     *
     * @param <T> the generic type
     * @param cls the cls
     * @param debug the debug
     * @return the codec
     */
    public static <T> Codec<T> create(Class<T> cls, boolean debug) {
        return create(cls, debug, null);
    }

    /**
     * To create a protobuf proxy class for target class.
     *
     * @param <T> target object type to be proxied.
     * @param cls target object class
     * @param debug true will print generate java source code
     * @param path the path
     * @return proxy instance object.
     */
    public static <T> Codec<T> create(Class<T> cls, boolean debug, File path) {
        String uniClsName = cls.getName();
        // to check cache early
        if (isCacheEnabled()) {
            Codec<T> codec = CACHED.get(uniClsName);
            if (codec != null) {
                return codec;
            }
        }
        String className = getFullClassName(cls);
        Codec<T> codec = loadCompiledClass(uniClsName, className);
        if (codec != null) {
            return codec;
        }

        return create(cls, debug, path, null, getCodeGenerator(cls));
    }

    /**
     * To create a protobuf proxy class for target class.
     *
     * @param <T> target object type to be proxied.
     * @param cls target object class
     * @param debug true will print generate java source code
     * @param path the path
     * @param compiler the compiler
     * @param codeGenerator the code generator
     * @return proxy instance object.
     */
    public static <T> Codec<T> create(Class<T> cls, boolean debug, File path, Compiler compiler,
            ICodeGenerator codeGenerator) {
        DEBUG_CONTROLLER.set(debug);
        OUTPUT_PATH.set(path);
        try {
            return doCreate(cls, isDebugEnabled(), compiler, codeGenerator);
        } finally {
            DEBUG_CONTROLLER.remove();
            OUTPUT_PATH.remove();
        }

    }

    /**
     * To create a protobuf proxy class for target class.
     *
     * @param <T> generic type
     * @param cls target class to parse <code>@Protobuf</code> annotation
     * @param compiler the compiler
     * @param codeGenerator the code generator
     * @return {@link Codec} instance proxy
     */
    public static <T> Codec<T> create(Class<T> cls, Compiler compiler, ICodeGenerator codeGenerator) {
        return create(cls, isDebugEnabled(), null, compiler, codeGenerator);
    }

    /**
     * To create a protobuf proxy class for target class.
     *
     * @param <T> target object type to be proxied.
     * @param cls target object class
     * @param debug true will print generate java source code
     * @param compiler the compiler
     * @param cg the cg
     * @return proxy instance object.
     */
    protected static <T> Codec<T> doCreate(Class<T> cls, boolean debug, Compiler compiler, ICodeGenerator cg) {
        if (cls == null) {
            throw new NullPointerException("Parameter cls is null");
        }

        Ignore ignore = cls.getAnnotation(Ignore.class);
        if (ignore != null) {
            LOGGER.info("class '{}' marked as @Ignore annotation, proxy ignored.", cls.getName());
            return null;
        }

        String uniClsName = cls.getName();
        if (isCacheEnabled()) {
            Codec codec = CACHED.get(uniClsName);
            if (codec != null) {
                return codec;
            }
        }

        // crate code generator
        cg.setDebug(debug);
        File path = OUTPUT_PATH.get();
        cg.setOutputPath(path);

        // try to load first
        String className = cg.getFullClassName();
        Codec<T> codec = loadCompiledClass(uniClsName, className);
        if (codec != null) {
            return codec;
        }

        String code = cg.getCode();
        if (debug) {
            String printCode = code;
            CodePrinter.printCode(printCode, "generate protobuf proxy code");
        }

        FileOutputStream fos = null;
        if (path != null && path.isDirectory()) {
            String pkg = "";
            if (className.indexOf('.') != -1) {
                pkg = StringUtils.substringBeforeLast(className, ".");
            }

            // mkdirs
            String dir = path + File.separator + pkg.replace('.', File.separatorChar);
            File f = new File(dir);
            f.mkdirs();

            try {
                fos = new FileOutputStream(new File(f, cg.getClassName() + ".class"));
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }

        }

        if (compiler == null) {
            compiler = JDKCompilerHelper.getJdkCompiler();
        }
        Class<?> newClass;

        // get last modify time
        long lastModify = ClassHelper.getLastModifyTime(cls);

        try {
            newClass = compiler.compile(className, code, cls.getClassLoader(), fos, lastModify);
        } catch (Exception e) {
            compiler = JDKCompilerHelper.getJdkCompiler(cls.getClassLoader());
            newClass = compiler.compile(className, code, cls.getClassLoader(), fos, lastModify);
        }

        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        try {
            Codec<T> newInstance = (Codec<T>)newClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!CACHED.containsKey(uniClsName)) {
                CACHED.put(uniClsName, newInstance);
            }

            try {
                // try to eagle load
                Set<Class<?>> relativeProxyClasses = cg.getRelativeProxyClasses();
                for (Class<?> relativeClass : relativeProxyClasses) {
                    ProtobufProxy.create(relativeClass, debug, path, compiler, cg);
                }
            } catch (Exception e) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug(e.getMessage(), e);
                }
            }

            return newInstance;
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * To generate a protobuf proxy java source code for target class.
     * 
     * @param os to generate java source code
     * @param cls target class
     * @param charset charset type
     * @throws IOException in case of any io relative exception.
     */
    public static void dynamicCodeGenerate(OutputStream os, Class cls, Charset charset) throws IOException {
        dynamicCodeGenerate(os, cls, charset, getCodeGenerator(cls));
    }

    /**
     * To generate a protobuf proxy java source code for target class.
     *
     * @param os to generate java source code
     * @param cls target class
     * @param charset charset type
     * @param codeGenerator the code generator
     * @throws IOException in case of any io relative exception.
     */
    public static void dynamicCodeGenerate(OutputStream os, Class cls, Charset charset, ICodeGenerator codeGenerator)
            throws IOException {
        if (cls == null) {
            throw new NullPointerException("Parameter 'cls' is null");
        }
        if (os == null) {
            throw new NullPointerException("Parameter 'os' is null");
        }
        if (charset == null) {
            charset = Charset.defaultCharset();
        }
        String code = codeGenerator.getCode();

        os.write(code.getBytes(charset));
    }

    /**
     * Enable cache.
     *
     * @param enabled the enabled
     */
    public static void enableCache(boolean enabled) {
        CACHE_ENABLED.set(enabled);
    }

    /**
     * Gets the class loader.
     *
     * @return the class loader
     */
    private static ClassLoader getClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader;
    }

    /**
     * Gets the code generator.
     *
     * @param cls the cls
     * @return the code generator
     */
    private static ICodeGenerator getCodeGenerator(Class cls) {
        // check if has default constructor

        if (!cls.isMemberClass()) {
            try {
                cls.getConstructor(new Class<?>[0]);
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException(
                        "Class '" + cls.getName() + "' must has default constructor method with no parameters.", e2);
            } catch (SecurityException e2) {
                throw new IllegalArgumentException(e2.getMessage(), e2);
            }
        }

        ICodeGenerator cg = new TemplateCodeGenerator(cls);

        return cg;
    }

    /**
     * Gets the full class name.
     *
     * @param cls the cls
     * @return the full class name
     */
    public static String getFullClassName(Class cls) {
        String pkg = ClassHelper.getPackage(cls);
        String className = ClassHelper.getClassName(cls) + ICodeGenerator.DEFAULT_SUFFIX_CLASSNAME;
        if (StringUtils.isEmpty(pkg)) {
            return className;
        }

        return pkg + ClassHelper.PACKAGE_SEPARATOR + className;
    }

    /**
     * Checks if is cache enabled.
     *
     * @return true, if is cache enabled
     */
    public static boolean isCacheEnabled() {
        Boolean b = CACHE_ENABLED.get();
        if (b == null) {
            return true;
        }

        return b;
    }

    /**
     * Checks if is debug enabled.
     *
     * @return true, if is debug enabled
     */
    public static boolean isDebugEnabled() {
        String debugEnv = System.getenv(DEBUG_CONTROL);
        if (debugEnv != null && Boolean.parseBoolean(debugEnv)) {
            return true;
        }

        Boolean debug = DEBUG_CONTROLLER.get();
        if (debug == null) {
            debug = false; // set default to close debug info
        }

        return debug;
    }

    /**
     * Load compiled class.
     *
     * @param <T> the generic type
     * @param uniClsName the uni cls name
     * @param className the class name
     * @return the codec
     */
    private static <T> Codec<T> loadCompiledClass(String uniClsName, String className) {
        Class<?> c = null;
        try {
            c = Class.forName(className, true, getClassLoader());
        } catch (ClassNotFoundException e1) {
            try {
                c = Class.forName(className, true, ProtobufProxy.class.getClassLoader());
            } catch (ClassNotFoundException e2) {
                // if class not found so should generate a new java source class.
                c = null;
            }
        }

        if (c != null) {
            try {
                Codec<T> newInstance = (Codec<T>) c.newInstance();
                if (!CACHED.containsKey(uniClsName)) {
                    CACHED.put(uniClsName, newInstance);
                }
                return newInstance;
            } catch (InstantiationException e) {
                throw new RuntimeException(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        return null;
    }

}
