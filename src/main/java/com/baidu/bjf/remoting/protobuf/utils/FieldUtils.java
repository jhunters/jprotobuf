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
package com.baidu.bjf.remoting.protobuf.utils;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * Field utility class.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public final class FieldUtils {
    /**
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(FieldUtils.class);

    /**
     * Get the field represented by the supplied {@link Field field object} on
     * the specified {@link Object target object}. In accordance with
     * {@link Field#get(Object)} semantics, the returned value is automatically
     * wrapped if the underlying field has a primitive type.
     * <p>
     * Thrown exceptions are handled via a call to
     * {@link #handleReflectionException(Exception)}.
     * 
     * @param t
     *            the target object from which to get the field
     * @param name
     *            the field to get
     * @return the field's current value
     */
    public static Object getField(Object t, String name) {
        Field field = findField(t.getClass(), name);
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(t);
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * Set the field represented by the supplied {@link Field field object} on
     * the specified {@link Object target object} to the specified
     * <code>value</code>. In accordance with {@link Field#set(Object, Object)}
     * semantics, the new value is automatically unwrapped if the underlying
     * field has a primitive type.
     * <p>
     * Thrown exceptions are handled via a call to
     * {@link #handleReflectionException(Exception)}.
     * 
     * @param t
     *            the target object on which to set the field
     * @param name
     *            the field to set
     * @param value
     *            the value to set; may be <code>null</code>
     */
    public static void setField(Object t, String name, Object value) {
        Field field = findField(t.getClass(), name);
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(t, value);
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }
    }

    /**
     * Attempt to find a {@link Field field} on the supplied {@link Class} with
     * the supplied <code>name</code>. Searches all superclasses up to
     * {@link Object}.
     * 
     * @param clazz
     *            the class to introspect
     * @param name
     *            the name of the field
     * @return the corresponding Field object, or <code>null</code> if not found
     */
    public static Field findField(Class clazz, String name) {
        return findField(clazz, name, null);
    }

    /**
     * Attempt to find a {@link Field field} on the supplied {@link Class} with
     * the supplied <code>name</code> and/or {@link Class type}. Searches all
     * superclasses up to {@link Object}.
     * 
     * @param clazz
     *            the class to introspect
     * @param name
     *            the name of the field (may be <code>null</code> if type is
     *            specified)
     * @param type
     *            the type of the field (may be <code>null</code> if name is
     *            specified)
     * @return the corresponding Field object, or <code>null</code> if not found
     */
    public static Field findField(Class clazz, String name, Class type) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class must not be null");
        }
        if (name == null && type == null) {
            throw new IllegalArgumentException(
                    "Either name or type of the field must be specified");
        }
        Class searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = searchType.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                if ((name == null || name.equals(field.getName()))
                        && (type == null || type.equals(field.getType()))) {
                    return field;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }
}
