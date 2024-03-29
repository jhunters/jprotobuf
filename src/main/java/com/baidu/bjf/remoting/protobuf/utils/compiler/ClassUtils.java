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
package com.baidu.bjf.remoting.protobuf.utils.compiler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassUtils. (Tool, Static, ThreadSafe)
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public class ClassUtils {

    /** class file extension. */
    public static final String CLASS_EXTENSION = ".class";

    /** java source file extension. */
    public static final String JAVA_EXTENSION = ".java";

    /**
     * To new instance by class name.
     *
     * @param name class name
     * @return new create instance
     */
    public static Object newInstance(String name) {
        try {
            return forName(name).newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * Use Class.forname to initialize class.
     * 
     * @param packages
     *            package array
     * @param className
     *            class name
     * @return loaded class
     */
    public static Class<?> forName(String[] packages, String className) {
        try {
            return doFormName(className);
        } catch (ClassNotFoundException e) {
            if (packages != null && packages.length > 0) {
                for (String pkg : packages) {
                    try {
                        return doFormName(pkg + "." + className);
                    } catch (ClassNotFoundException e2) {
                    }
                }
            }
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * Use Class.forname to initialize class.
     * 
     * @param className
     *            class name
     * @return loaded class
     */
    public static Class<?> forName(String className) {
        try {
            return doFormName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    /**
     * Use Class.forname to initialize class.
     * 
     * @param className
     *            class name
     * @return loaded class
     * @throws ClassNotFoundException
     *             if class not found
     */
    public static Class<?> doFormName(String className) throws ClassNotFoundException {
        if ("boolean".equals(className))
            return boolean.class;
        if ("byte".equals(className))
            return byte.class;
        if ("char".equals(className))
            return char.class;
        if ("short".equals(className))
            return short.class;
        if ("int".equals(className))
            return int.class;
        if ("long".equals(className))
            return long.class;
        if ("float".equals(className))
            return float.class;
        if ("double".equals(className))
            return double.class;
        if ("boolean[]".equals(className))
            return boolean[].class;
        if ("byte[]".equals(className))
            return byte[].class;
        if ("char[]".equals(className))
            return char[].class;
        if ("short[]".equals(className))
            return short[].class;
        if ("int[]".equals(className))
            return int[].class;
        if ("long[]".equals(className))
            return long[].class;
        if ("float[]".equals(className))
            return float[].class;
        if ("double[]".equals(className))
            return double[].class;
        try {
            return arrayForName(className);
        } catch (ClassNotFoundException e) {
            if (className.indexOf('.') == -1) { // 尝试java.lang包
                try {
                    return arrayForName("java.lang." + className);
                } catch (ClassNotFoundException e2) {
                    // 忽略尝试异常, 抛出原始异常
                }
            }
            throw e;
        }
    }

    /**
     * Array for name.
     *
     * @param className the class name
     * @return the class
     * @throws ClassNotFoundException the class not found exception
     */
    private static Class<?> arrayForName(String className) throws ClassNotFoundException {
        String name;
        if (className.endsWith("[]")) {
            name = "[L" + className.substring(0, className.length() - 2) + ";";
        } else {
            name = className;
        }
        
        return Class.forName(name, true, Thread.currentThread().getContextClassLoader());
    }

    /**
     * Get boxed class for primitive type.
     *
     * @param type primitive class type
     * @return Object class type
     */
    public static Class<?> getBoxedClass(Class<?> type) {
        if (type == boolean.class) {
            return Boolean.class;
        } else if (type == char.class) {
            return Character.class;
        } else if (type == byte.class) {
            return Byte.class;
        } else if (type == short.class) {
            return Short.class;
        } else if (type == int.class) {
            return Integer.class;
        } else if (type == long.class) {
            return Long.class;
        } else if (type == float.class) {
            return Float.class;
        } else if (type == double.class) {
            return Double.class;
        } else {
            return type;
        }
    }

    /**
     * Boxed primitive boolean type.
     *
     * @param v boolean primitive type
     * @return Object type of boolean
     */
    public static Boolean boxed(boolean v) {
        return Boolean.valueOf(v);
    }

    /**
     * Boxed primitive char type.
     *
     * @param v boolean char type
     * @return Object type of Character
     */
    public static Character boxed(char v) {
        return Character.valueOf(v);
    }

    /**
     * Boxed primitive byte type.
     *
     * @param v boolean byte type
     * @return Object type of Byte
     */
    public static Byte boxed(byte v) {
        return Byte.valueOf(v);
    }

    /**
     * Boxed primitive short type.
     *
     * @param v boolean short type
     * @return Object type of Short
     */
    public static Short boxed(short v) {
        return Short.valueOf(v);
    }

    /**
     * Boxed.
     *
     * @param v the v
     * @return the integer
     */
    public static Integer boxed(int v) {
        return Integer.valueOf(v);
    }

    /**
     * Boxed.
     *
     * @param v the v
     * @return the long
     */
    public static Long boxed(long v) {
        return Long.valueOf(v);
    }

    /**
     * Boxed.
     *
     * @param v the v
     * @return the float
     */
    public static Float boxed(float v) {
        return Float.valueOf(v);
    }

    /**
     * Boxed.
     *
     * @param v the v
     * @return the double
     */
    public static Double boxed(double v) {
        return Double.valueOf(v);
    }

    /**
     * Boxed.
     *
     * @param v the v
     * @return the object
     */
    public static Object boxed(Object v) {
        return v;
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return true, if successful
     */
    public static boolean unboxed(Boolean v) {
        return v == null ? false : v.booleanValue();
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return the char
     */
    public static char unboxed(Character v) {
        return v == null ? '\0' : v.charValue();
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return the byte
     */
    public static byte unboxed(Byte v) {
        return v == null ? 0 : v.byteValue();
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return the short
     */
    public static short unboxed(Short v) {
        return v == null ? 0 : v.shortValue();
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return the int
     */
    public static int unboxed(Integer v) {
        return v == null ? 0 : v.intValue();
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return the long
     */
    public static long unboxed(Long v) {
        return v == null ? 0 : v.longValue();
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return the float
     */
    public static float unboxed(Float v) {
        return v == null ? 0 : v.floatValue();
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return the double
     */
    public static double unboxed(Double v) {
        return v == null ? 0 : v.doubleValue();
    }

    /**
     * Unboxed.
     *
     * @param v the v
     * @return the object
     */
    public static Object unboxed(Object v) {
        return v;
    }

    /**
     * Checks if is not empty.
     *
     * @param object the object
     * @return true, if is not empty
     */
    public static boolean isNotEmpty(Object object) {
        return getSize(object) > 0;
    }

    /**
     * Gets the size.
     *
     * @param object the object
     * @return the size
     */
    public static int getSize(Object object) {
        if (object == null) {
            return 0;
        }
        if (object instanceof Collection<?>) {
            return ((Collection<?>) object).size();
        } else if (object instanceof Map<?, ?>) {
            return ((Map<?, ?>) object).size();
        } else if (object.getClass().isArray()) {
            return Array.getLength(object);
        } else {
            return -1;
        }
    }

    /**
     * To URI.
     *
     * @param name the name
     * @return the uri
     */
    public static URI toURI(String name) {
        try {
            return new URI(name);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the generic class.
     *
     * @param cls the cls
     * @return the generic class
     */
    public static Class<?> getGenericClass(Class<?> cls) {
        return getGenericClass(cls, 0);
    }

    /**
     * Gets the generic class.
     *
     * @param cls the cls
     * @param i the i
     * @return the generic class
     */
    public static Class<?> getGenericClass(Class<?> cls, int i) {
        try {
            ParameterizedType parameterizedType = ((ParameterizedType) cls.getGenericInterfaces()[0]);
            Object genericClass = parameterizedType.getActualTypeArguments()[i];
            if (genericClass instanceof ParameterizedType) { // 处理多级泛型
                return (Class<?>) ((ParameterizedType) genericClass).getRawType();
            } else if (genericClass instanceof GenericArrayType) { // 处理数组泛型
                return (Class<?>) ((GenericArrayType) genericClass).getGenericComponentType();
            } else if (genericClass != null) {
                return (Class<?>) genericClass;
            }
        } catch (Throwable e) {
            toString(e);
        }
        if (cls.getSuperclass() != null) {
            return getGenericClass(cls.getSuperclass(), i);
        } else {
            throw new IllegalArgumentException(cls.getName() + " generic type undefined!");
        }
    }

    /**
     * Checks if is before java 5.
     *
     * @param javaVersion the java version
     * @return true, if is before java 5
     */
    public static boolean isBeforeJava5(String javaVersion) {
        return (javaVersion == null || javaVersion.length() == 0 || "1.0".equals(javaVersion)
                || "1.1".equals(javaVersion) || "1.2".equals(javaVersion) || "1.3".equals(javaVersion) || "1.4"
                .equals(javaVersion));
    }

    /**
     * Checks if is before java 6.
     *
     * @param javaVersion the java version
     * @return true, if is before java 6
     */
    public static boolean isBeforeJava6(String javaVersion) {
        return isBeforeJava5(javaVersion) || "1.5".equals(javaVersion);
    }

    /**
     * To string.
     *
     * @param e the e
     * @return the string
     */
    public static String toString(Throwable e) {
        StringWriter w = new StringWriter();
        PrintWriter p = new PrintWriter(w);
        p.print(e.getClass().getName() + ": ");
        if (e.getMessage() != null) {
            p.print(e.getMessage() + "\n");
        }
        p.println();
        try {
            e.printStackTrace(p);
            return w.toString();
        } finally {
            p.close();
        }
    }

    /** The Constant JIT_LIMIT. */
    private static final int JIT_LIMIT = 5 * 1024;

    /**
     * Check bytecode.
     *
     * @param name the name
     * @param bytecode the bytecode
     */
    public static void checkBytecode(String name, byte[] bytecode) {
        if (bytecode.length > JIT_LIMIT) {
            System.err.println("The template bytecode too long, may be affect the JIT compiler. template class: "
                    + name);
        }
    }

    /**
     * Gets the size method.
     *
     * @param cls the cls
     * @return the size method
     */
    public static String getSizeMethod(Class<?> cls) {
        try {
            return cls.getMethod("size", new Class<?>[0]).getName() + "()";
        } catch (NoSuchMethodException e) {
            try {
                return cls.getMethod("length", new Class<?>[0]).getName() + "()";
            } catch (NoSuchMethodException e2) {
                try {
                    return cls.getMethod("getSize", new Class<?>[0]).getName() + "()";
                } catch (NoSuchMethodException e3) {
                    try {
                        return cls.getMethod("getLength", new Class<?>[0]).getName() + "()";
                    } catch (NoSuchMethodException e4) {
                        return null;
                    }
                }
            }
        }
    }

    /**
     * Gets the method name.
     *
     * @param method the method
     * @param parameterClasses the parameter classes
     * @param rightCode the right code
     * @return the method name
     */
    public static String getMethodName(Method method, Class<?>[] parameterClasses, String rightCode) {
        if (method.getParameterTypes().length > parameterClasses.length) {
            Class<?>[] types = method.getParameterTypes();
            StringBuilder buf = new StringBuilder(rightCode);
            for (int i = parameterClasses.length; i < types.length; i++) {
                if (buf.length() > 0) {
                    buf.append(",");
                }
                Class<?> type = types[i];
                String def;
                if (type == boolean.class) {
                    def = "false";
                } else if (type == char.class) {
                    def = "\'\\0\'";
                } else if (type == byte.class || type == short.class || type == int.class || type == long.class
                        || type == float.class || type == double.class) {
                    def = "0";
                } else {
                    def = "null";
                }
                buf.append(def);
            }
        }
        return method.getName() + "(" + rightCode + ")";
    }

    /**
     * Search method.
     *
     * @param currentClass the current class
     * @param name the name
     * @param parameterTypes the parameter types
     * @return the method
     * @throws NoSuchMethodException the no such method exception
     */
    public static Method searchMethod(Class<?> currentClass, String name, Class<?>[] parameterTypes)
            throws NoSuchMethodException {
        if (currentClass == null) {
            throw new NoSuchMethodException("class == null");
        }
        try {
            return currentClass.getMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            for (Method method : currentClass.getMethods()) {
                if (method.getName().equals(name) && parameterTypes.length == method.getParameterTypes().length
                        && Modifier.isPublic(method.getModifiers())) {
                    if (parameterTypes.length > 0) {
                        Class<?>[] types = method.getParameterTypes();
                        boolean match = true;
                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (!types[i].isAssignableFrom(parameterTypes[i])) {
                                match = false;
                                break;
                            }
                        }
                        if (!match) {
                            continue;
                        }
                    }
                    return method;
                }
            }
            throw e;
        }
    }

    /**
     * Gets the inits the code.
     *
     * @param type the type
     * @return the inits the code
     */
    public static String getInitCode(Class<?> type) {
        if (byte.class.equals(type) || short.class.equals(type) || int.class.equals(type) || long.class.equals(type)
                || float.class.equals(type) || double.class.equals(type)) {
            return "0";
        } else if (char.class.equals(type)) {
            return "'\\0'";
        } else if (boolean.class.equals(type)) {
            return "false";
        } else {
            return "null";
        }
    }

    /**
     * To map.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param entries the entries
     * @return the map
     */
    public static <K, V> Map<K, V> toMap(Map.Entry<K, V>[] entries) {
        Map<K, V> map = new HashMap<K, V>();
        if (entries != null && entries.length > 0) {
            for (Map.Entry<K, V> enrty : entries) {
                map.put(enrty.getKey(), enrty.getValue());
            }
        }
        return map;
    }

    /**
     * Instantiates a new class utils.
     */
    private ClassUtils() {
    }

}
