/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.jprotobuf.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;

/**
 * Simple utility class for working with the reflection API and handling reflection exceptions.
 *
 *
 * @author xiemalin
 * @since 1.0
 */
public class ReflectionUtils {

    /**
     * Perform the given callback operation on all matching methods of the given class and superclasses.
     * <p>
     * The same named method occurring on subclass and superclass will appear twice, unless excluded by a
     * {@link MethodFilter}.
     *
     * @param targetClass class to start looking at
     * @param mc the callback to invoke for each method
     * @throws IllegalArgumentException the illegal argument exception
     * @see #doWithMethods(Class, MethodCallback, MethodFilter)
     */
    public static void doWithMethods(Class<?> targetClass, MethodCallback mc) throws IllegalArgumentException {
        doWithMethods(targetClass, mc, null);
    }

    /**
     * Perform the given callback operation on all matching methods of the given class and superclasses.
     * <p>
     * The same named method occurring on subclass and superclass will appear twice, unless excluded by the specified
     * {@link MethodFilter}.
     *
     * @param targetClass class to start looking at
     * @param mc the callback to invoke for each method
     * @param mf the filter that determines the methods to apply the callback to
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static void doWithMethods(Class<?> targetClass, MethodCallback mc, MethodFilter mf)
            throws IllegalArgumentException {

        // Keep backing up the inheritance hierarchy.
        do {
            Method[] methods = targetClass.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                if (mf != null && !mf.matches(methods[i])) {
                    continue;
                }
                try {
                    mc.doWith(methods[i]);
                } catch (IllegalAccessException ex) {
                    throw new IllegalStateException(
                            "Shouldn't be illegal to access method '" + methods[i].getName() + "': " + ex);
                }
            }
            targetClass = targetClass.getSuperclass();
        } while (targetClass != null);
    }

    /**
     * Checks if is void.
     *
     * @param cls the cls
     * @return true, if is void
     */
    public static boolean isVoid(Class<?> cls) {
        if (cls == Void.class || cls == void.class) {
            return true;
        }
        return false;
    }

    /**
     * Action to take on each method.
     */
    public static interface MethodCallback {

        /**
         * Perform an operation using the given method.
         *
         * @param method the method to operate on
         * @throws IllegalArgumentException the illegal argument exception
         * @throws IllegalAccessException the illegal access exception
         */
        void doWith(Method method) throws IllegalArgumentException, IllegalAccessException;
    }

    /**
     * Callback optionally used to method fields to be operated on by a method callback.
     */
    public static interface MethodFilter {

        /**
         * Determine whether the given method matches.
         *
         * @param method the method to check
         * @return true, if successful
         */
        boolean matches(Method method);
    }

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name and no parameters. Searches all
     * superclasses up to <code>Object</code>.
     * <p>
     * Returns <code>null</code> if no {@link Method} can be found.
     * 
     * @param clazz the class to introspect
     * @param name the name of the method
     * @return the Method object, or <code>null</code> if none found
     */
    public static Method findMethod(Class<?> clazz, String name) {
        return findMethod(clazz, name, new Class[0]);
    }

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name and parameter types. Searches all
     * superclasses up to <code>Object</code>.
     * <p>
     * Returns <code>null</code> if no {@link Method} can be found.
     * 
     * @param clazz the class to introspect
     * @param name the name of the method
     * @param paramTypes the parameter types of the method (may be <code>null</code> to indicate any signature)
     * @return the Method object, or <code>null</code> if none found
     */
    public static Method findMethod(Class<?> clazz, String name, Class<?>...paramTypes) {
        Class<?> searchType = clazz;
        while (searchType != null) {
            Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
            for (Method method : methods) {
                if (name.equals(method.getName())
                        && (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
                    return method;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * Invoke the specified {@link Method} against the supplied target object with no arguments. The target object can
     * be <code>null</code> when invoking a static {@link Method}.
     * <p>
     * Thrown exceptions are handled via a call to {@link #handleReflectionException}.
     * 
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @return the invocation result, if any
     * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeMethod(Method method, Object target) {
        return invokeMethod(method, target, new Object[0]);
    }

    /**
     * Invoke the specified {@link Method} against the supplied target object with the supplied arguments. The target
     * object can be <code>null</code> when invoking a static {@link Method}.
     * <p>
     * Thrown exceptions are handled via a call to {@link #handleReflectionException}.
     * 
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @param args the invocation arguments (may be <code>null</code>)
     * @return the invocation result, if any
     */
    public static Object invokeMethod(Method method, Object target, Object...args) {
        try {
            return method.invoke(target, args);
        } catch (Exception ex) {
            handleReflectionException(ex);
        }
        throw new IllegalStateException("Should never get here");
    }

    /**
     * Handle the given reflection exception. Should only be called if no checked exception is expected to be thrown by
     * the target method.
     * <p>
     * Throws the underlying RuntimeException or Error in case of an InvocationTargetException with such a root cause.
     * Throws an IllegalStateException with an appropriate message else.
     * 
     * @param ex the reflection exception to handle
     */
    public static void handleReflectionException(Exception ex) {
        if (ex instanceof NoSuchMethodException) {
            throw new IllegalStateException("Method not found: " + ex.getMessage());
        }
        if (ex instanceof IllegalAccessException) {
            throw new IllegalStateException("Could not access method: " + ex.getMessage());
        }
        if (ex instanceof InvocationTargetException) {
            handleInvocationTargetException((InvocationTargetException) ex);
        }
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        throw new UndeclaredThrowableException(ex);
    }

    /**
     * Handle the given invocation target exception. Should only be called if no checked exception is expected to be
     * thrown by the target method.
     * <p>
     * Throws the underlying RuntimeException or Error in case of such a root cause. Throws an IllegalStateException
     * else.
     * 
     * @param ex the invocation target exception to handle
     */
    public static void handleInvocationTargetException(InvocationTargetException ex) {
        rethrowRuntimeException(ex.getTargetException());
    }

    /**
     * Rethrow the given {@link Throwable exception}, which is presumably the <em>target exception</em> of an
     * {@link InvocationTargetException}. Should only be called if no checked exception is expected to be thrown by the
     * target method.
     * <p>
     * Rethrows the underlying exception cast to an {@link RuntimeException} or {@link Error} if appropriate; otherwise,
     * throws an {@link IllegalStateException}.
     * 
     * @param ex the exception to rethrow
     * @throws RuntimeException the rethrown exception
     */
    public static void rethrowRuntimeException(Throwable ex) {
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        throw new UndeclaredThrowableException(ex);
    }
}
