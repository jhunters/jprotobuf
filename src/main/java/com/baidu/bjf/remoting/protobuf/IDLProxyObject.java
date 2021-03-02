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

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;

/**
 * IDL parsed proxy object.
 *
 * @author xiemalin
 * @since 1.0.2
 */
public class IDLProxyObject {

    /** The codec. */
    private Codec codec;

    /** The target. */
    private Object target;

    /** The cls. */
    private Class<?> cls;

    /** The cached fields. */
    private final Map<String, ReflectInfo> cachedFields = new HashMap<String, ReflectInfo>();

    /** The cached. */
    private boolean cached = true;

    /**
     * Checks if is cached.
     *
     * @return true, if is cached
     */
    public boolean isCached() {
        return cached;
    }

    /**
     * Sets the cached.
     *
     * @param cached the new cached
     */
    public void setCached(boolean cached) {
        this.cached = cached;
    }

    /**
     * default construtor to set {@link Codec} target.
     *
     * @param codec the codec
     * @param target the target
     * @param cls the cls
     */
    public IDLProxyObject(Codec codec, Object target, Class<?> cls) {
        super();
        if (codec == null) {
            throw new IllegalArgumentException("param 'codec' is null.");
        }
        if (target == null) {
            throw new IllegalArgumentException("param 'target' is null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("param 'cls' is null.");
        }
        this.codec = codec;
        this.target = target;
        this.cls = cls;

    }

    /**
     * New instnace.
     *
     * @return the IDL proxy object
     */
    public IDLProxyObject newInstnace() {
        try {
            Object object = cls.newInstance();
            return new IDLProxyObject(codec, object, cls);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Do set field value.
     *
     * @param fullField the full field
     * @param field the field
     * @param value the value
     * @param object the object
     * @param useCache the use cache
     * @param cachedFields the cached fields
     * @return the IDL proxy object
     */
    private IDLProxyObject doSetFieldValue(String fullField, String field, Object value, Object object,
            boolean useCache, Map<String, ReflectInfo> cachedFields) {
        Field f;
        // check cache
        if (useCache) {
            ReflectInfo info = cachedFields.get(fullField);
            if (info != null) {
                setField(value, info.target, info.field);
                return this;
            }
        }

        int index = field.indexOf('.');
        if (index != -1) {
            String parent = field.substring(0, index);
            String sub = field.substring(index + 1);

            try {
                f = FieldUtils.findField(object.getClass(), parent);
                if (f == null) {
                    throw new RuntimeException(
                            "No field '" + parent + "' found at class " + object.getClass().getName());
                }
                Class<?> type = f.getType();
                f.setAccessible(true);
                Object o = f.get(object);
                if (o == null) {
                    boolean memberClass = type.isMemberClass();
                    if (memberClass && Modifier.isStatic(type.getModifiers())) {
                        Constructor<?> constructor = type.getConstructor(new Class[0]);
                        constructor.setAccessible(true);
                        o = constructor.newInstance(new Object[0]);
                    } else if (memberClass) {
                        Constructor<?> constructor = type.getConstructor(new Class[] { object.getClass() });
                        constructor.setAccessible(true);
                        o = constructor.newInstance(new Object[] { object });
                    } else {
                        o = type.newInstance();
                    }
                    f.set(object, o);
                }
                return put(fullField, sub, value, o);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        f = FieldUtils.findField(object.getClass(), field);
        if (f == null) {
            throw new RuntimeException("No field '" + field + "' found at class " + object.getClass().getName());
        }
        if (useCache && !cachedFields.containsKey(fullField)) {
            cachedFields.put(fullField, new ReflectInfo(f, object));
        }
        setField(value, object, f);

        return this;
    }

    /**
     * Put.
     *
     * @param fullField the full field
     * @param field the field
     * @param value the value
     * @param object the object
     * @return the IDL proxy object
     */
    private IDLProxyObject put(String fullField, String field, Object value, Object object) {
        return doSetFieldValue(fullField, field, value, object, this.cached, this.cachedFields);
    }

    /**
     * Put.
     *
     * @param field the field
     * @param value the value
     * @return the IDL proxy object
     */
    public IDLProxyObject put(String field, Object value) {
        return put(field, field, value, target);
    }

    /**
     * Sets the field.
     *
     * @param value the value
     * @param object the object
     * @param f the f
     * @throws SecurityException the security exception
     * @throws IllegalArgumentException the illegal argument exception
     */
    private void setField(Object value, Object object, Field f) {
        f.setAccessible(true);

        Object valueToSet = value;
        try {
            // check if field type is enum
            if (Enum.class.isAssignableFrom(f.getType())) {
                Enum v = Enum.valueOf((Class<Enum>) f.getType(), String.valueOf(value));
                valueToSet = v;
            }
            f.set(object, valueToSet);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Gets the.
     *
     * @param field the field
     * @return the object
     */
    public Object get(String field) {
        if (target == null) {
            return null;
        }

        return get(field, field, target);
    }

    /**
     * Do get field value.
     *
     * @param fullField the full field
     * @param field the field
     * @param object the object
     * @param useCache the use cache
     * @param cachedFields the cached fields
     * @return the object
     */
    private Object doGetFieldValue(String fullField, String field, Object object, boolean useCache,
            Map<String, ReflectInfo> cachedFields) {
        // check cache
        Field f;
        if (useCache) {
            ReflectInfo info = cachedFields.get(fullField);
            if (info != null) {
                return getField(info.target, info.field);
            }
        }

        int index = field.indexOf('.');
        if (index != -1) {
            String parent = field.substring(0, index);
            String sub = field.substring(index + 1);

            try {
                f = FieldUtils.findField(object.getClass(), parent);
                if (f == null) {
                    throw new RuntimeException(
                            "No field '" + parent + "' found at class " + object.getClass().getName());
                }
                f.setAccessible(true);
                Object o = f.get(object);
                if (o == null) {
                    return null;
                }
                return get(fullField, sub, o);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        f = FieldUtils.findField(object.getClass(), field);
        if (f == null) {
            throw new RuntimeException("No field '" + field + "' found at class " + object.getClass().getName());
        }
        if (useCache && !cachedFields.containsKey(fullField)) {
            cachedFields.put(fullField, new ReflectInfo(f, object));
        }
        return getField(object, f);
    }

    /**
     * Gets the.
     *
     * @param fullField the full field
     * @param field the field
     * @param object the object
     * @return the object
     */
    private Object get(String fullField, String field, Object object) {
        return doGetFieldValue(fullField, field, object, this.cached, this.cachedFields);

    }

    /**
     * Gets the field.
     *
     * @param object the object
     * @param f the f
     * @return the field
     */
    private Object getField(Object object, Field f) {
        f.setAccessible(true);
        try {
            return f.get(object);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Encode.
     *
     * @return the byte[]
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public byte[] encode() throws IOException {
        return codec.encode(target);
    }

    /**
     * Decode.
     *
     * @param bb the bb
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public IDLProxyObject decode(byte[] bb) throws IOException {
        if (bb == null) {
            throw new IllegalArgumentException("param 'bb' is null");
        }
        Object object = codec.decode(bb);
        return new IDLProxyObject(codec, object, cls);

    }

    /**
     * Clear field cache.
     */
    public void clearFieldCache() {
        cachedFields.clear();
    }

    /**
     * Gets the target.
     *
     * @return the target
     */
    public Object getTarget() {
        return target;
    }

    /**
     * The Class ReflectInfo.
     */
    private static class ReflectInfo {
        
        /** The field. */
        private Field field;
        
        /** The target. */
        private Object target;

        /**
         * Instantiates a new reflect info.
         *
         * @param field the field
         * @param target the target
         */
        public ReflectInfo(Field field, Object target) {
            super();
            this.field = field;
            this.target = target;
        }

    }
}
