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

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLite;

/**
 * Internal representation of map fields in generated lite-runtime messages.
 * 
 * This class is a protobuf implementation detail. Users shouldn't use this class directly.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {

    /** The is mutable. */
    private boolean isMutable;

    /**
     * Instantiates a new map field lite.
     */
    private MapFieldLite() {
        this.isMutable = true;
    }

    /**
     * Instantiates a new map field lite.
     *
     * @param mapData the map data
     */
    private MapFieldLite(Map<K, V> mapData) {
        super(mapData);
        this.isMutable = true;
    }

    /** The Constant EMPTY_MAP_FIELD. */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final MapFieldLite EMPTY_MAP_FIELD = new MapFieldLite(Collections.emptyMap());

    static {
        EMPTY_MAP_FIELD.makeImmutable();
    }

    /**
     *  Returns an singleton immutable empty MapFieldLite instance.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @return the map field lite
     */
    @SuppressWarnings({ "unchecked", "cast" })
    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return (MapFieldLite<K, V>) EMPTY_MAP_FIELD;
    }

    /**
     * Merge from.
     *
     * @param other the other
     */
    public void mergeFrom(MapFieldLite<K, V> other) {
        ensureMutable();
        if (!other.isEmpty()) {
            putAll(other);
        }
    }

    /* (non-Javadoc)
     * @see java.util.HashMap#entrySet()
     */
    @SuppressWarnings({ "unchecked", "cast" })
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.<Map.Entry<K, V>> emptySet() : super.entrySet();
    }

    /* (non-Javadoc)
     * @see java.util.LinkedHashMap#clear()
     */
    @Override
    public void clear() {
        ensureMutable();
        clear();
    }

    /* (non-Javadoc)
     * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public V put(K key, V value) {
        ensureMutable();
        return super.put(key, value);
    }

    /**
     * Put.
     *
     * @param entry the entry
     * @return the v
     */
    public V put(Map.Entry<K, V> entry) {
        return put(entry.getKey(), entry.getValue());
    }

    /* (non-Javadoc)
     * @see java.util.HashMap#putAll(java.util.Map)
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        ensureMutable();
        super.putAll(m);
    }

    /* (non-Javadoc)
     * @see java.util.HashMap#remove(java.lang.Object)
     */
    @Override
    public V remove(Object key) {
        ensureMutable();
        return super.remove(key);
    }

    /**
     * Equals.
     *
     * @param a the a
     * @param b the b
     * @return true, if successful
     */
    private static boolean equals(Object a, Object b) {
        if (a instanceof byte[] && b instanceof byte[]) {
            return Arrays.equals((byte[]) a, (byte[]) b);
        }
        return a.equals(b);
    }

    /**
     * Checks whether two {@link Map}s are equal. We don't use the default equals method of {@link Map} because it
     * compares by identity not by content for byte arrays.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param a the a
     * @param b the b
     * @return true, if successful
     */
    static <K, V> boolean equals(Map<K, V> a, Map<K, V> b) {
        if (a == b) {
            return true;
        }
        if (a.size() != b.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : a.entrySet()) {
            if (!b.containsKey(entry.getKey())) {
                return false;
            }
            if (!equals(entry.getValue(), b.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether two map fields are equal.
     *
     * @param object the object
     * @return true, if successful
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        return (object instanceof Map) && equals(this, (Map<K, V>) object);
    }

    /**
     * Calculate hash code for object.
     *
     * @param a the a
     * @return the int
     */
    private static int calculateHashCodeForObject(Object a) {
        if (a instanceof byte[]) {
            return Internal.hashCode((byte[]) a);
        }
        // Enums should be stored as integers internally.
        if (a instanceof EnumLite) {
            throw new UnsupportedOperationException();
        }
        return a.hashCode();
    }

    /**
     * Calculates the hash code for a {@link Map}. We don't use the default hash code method of {@link Map} because for
     * byte arrays and protobuf enums it use {@link Object#hashCode()}.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param a the a
     * @return the int
     */
    static <K, V> int calculateHashCodeForMap(Map<K, V> a) {
        int result = 0;
        for (Map.Entry<K, V> entry : a.entrySet()) {
            result += calculateHashCodeForObject(entry.getKey()) ^ calculateHashCodeForObject(entry.getValue());
        }
        return result;
    }

    /* (non-Javadoc)
     * @see java.util.AbstractMap#hashCode()
     */
    @Override
    public int hashCode() {
        return calculateHashCodeForMap(this);
    }

    /**
     * Copy.
     *
     * @param object the object
     * @return the object
     */
    private static Object copy(Object object) {
        if (object instanceof byte[]) {
            byte[] data = (byte[]) object;
            return Arrays.copyOf(data, data.length);
        }
        return object;
    }

    /**
     * Makes a deep copy of a {@link Map}. Immutable objects in the map will be shared (e.g., integers, strings,
     * immutable messages) and mutable ones will have a copy (e.g., byte arrays, mutable messages).
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param map the map
     * @return the map
     */
    @SuppressWarnings("unchecked")
    static <K, V> Map<K, V> copy(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.put(entry.getKey(), (V) copy(entry.getValue()));
        }
        return result;
    }

    /**
     *  Returns a deep copy of this map field.
     *
     * @return the map field lite
     */
    public MapFieldLite<K, V> mutableCopy() {
        return isEmpty() ? new MapFieldLite<K, V>() : new MapFieldLite<K, V>(this);
    }

    /**
     * Makes this field immutable. All subsequent modifications will throw an {@link UnsupportedOperationException}.
     */
    public void makeImmutable() {
        isMutable = false;
    }

    /**
     * Checks if is mutable.
     *
     * @return true, if is mutable
     */
    public boolean isMutable() {
        return isMutable;
    }

    /**
     * Ensure mutable.
     */
    private void ensureMutable() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }
}
