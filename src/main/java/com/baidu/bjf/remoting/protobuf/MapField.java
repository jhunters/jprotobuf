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
// Copyright 2008 Google Inc.  All rights reserved.
// https://developers.google.com/protocol-buffers/
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
//     * Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above
// copyright notice, this list of conditions and the following disclaimer
// in the documentation and/or other materials provided with the
// distribution.
//     * Neither the name of Google Inc. nor the names of its
// contributors may be used to endorse or promote products derived from
// this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package com.baidu.bjf.remoting.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.protobuf.Message;

/**
 * Internal representation of map fields in generated messages.
 * 
 * This class supports accessing the map field as a {@link Map} to be used in generated API and also supports accessing
 * the field as a {@link List} to be used in reflection API. It keeps track of where the data is currently stored and do
 * necessary conversions between map and list.
 * 
 * This class is a protobuf implementation detail. Users shouldn't use this class directly.
 * 
 * THREAD-SAFETY NOTE: Read-only access is thread-safe. Users can call getMap() and getList() concurrently in multiple
 * threads. If write-access is needed, all access must be synchronized.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class MapField<K, V> {
    /**
     * Indicates where the data of this map field is currently stored.
     * 
     * MAP: Data is stored in mapData. LIST: Data is stored in listData. BOTH: mapData and listData have the same data.
     *
     * When the map field is accessed (through generated API or reflection API), it will shift between these 3 modes:
     * 
     * getMap() getList() getMutableMap() getMutableList() MAP MAP BOTH MAP LIST LIST BOTH LIST MAP LIST BOTH BOTH BOTH
     * MAP LIST
     * 
     * As the map field changes its mode, the list/map reference returned in a previous method call may be invalidated.
     */
    private enum StorageMode {

        /** The map. */
        MAP,
        /** The list. */
        LIST,
        /** The both. */
        BOTH
    }

    /** The mode. */
    private volatile StorageMode mode;

    /** The map data. */
    private Map<K, V> mapData;

    /** The list data. */
    private List<Message> listData;

    /**
     * The Interface Converter.
     *
     * @param <K> the key type
     * @param <V> the value type
     */
    // Convert between a map entry Message and a key-value pair.
    private static interface Converter<K, V> {

        /**
         * Convert key and value to message.
         *
         * @param key the key
         * @param value the value
         * @return the message
         */
        Message convertKeyAndValueToMessage(K key, V value);

        /**
         * Convert message to key and value.
         *
         * @param message the message
         * @param map the map
         */
        void convertMessageToKeyAndValue(Message message, Map<K, V> map);

        /**
         * Gets the message default instance.
         *
         * @return the message default instance
         */
        Message getMessageDefaultInstance();
    }

    /**
     * The Class ImmutableMessageConverter.
     *
     * @param <K> the key type
     * @param <V> the value type
     */
    private static class ImmutableMessageConverter<K, V> implements Converter<K, V> {

        /** The default entry. */
        private final MapEntry<K, V> defaultEntry;

        /**
         * Instantiates a new immutable message converter.
         *
         * @param defaultEntry the default entry
         */
        public ImmutableMessageConverter(MapEntry<K, V> defaultEntry) {
            this.defaultEntry = defaultEntry;
        }

        /*
         * (non-Javadoc)
         * 
         * @see com.baidu.bjf.remoting.protobuf.MapField.Converter#convertKeyAndValueToMessage(java.lang.Object,
         * java.lang.Object)
         */
        public Message convertKeyAndValueToMessage(K key, V value) {
            return defaultEntry.newBuilderForType().setKey(key).setValue(value).buildPartial();
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * com.baidu.bjf.remoting.protobuf.MapField.Converter#convertMessageToKeyAndValue(com.google.protobuf.Message,
         * java.util.Map)
         */
        public void convertMessageToKeyAndValue(Message message, Map<K, V> map) {
            MapEntry<K, V> entry = (MapEntry<K, V>) message;
            map.put(entry.getKey(), entry.getValue());
        }

        /*
         * (non-Javadoc)
         * 
         * @see com.baidu.bjf.remoting.protobuf.MapField.Converter#getMessageDefaultInstance()
         */
        public Message getMessageDefaultInstance() {
            return defaultEntry;
        }
    }

    /** The converter. */
    private final Converter<K, V> converter;

    /**
     * Instantiates a new map field.
     *
     * @param converter the converter
     * @param mode the mode
     * @param mapData the map data
     * @param listData the list data
     */
    private MapField(Converter<K, V> converter, StorageMode mode, Map<K, V> mapData, List<Message> listData) {
        this.converter = converter;
        this.mode = mode;
        this.mapData = mapData;
        this.listData = listData;
    }

    /**
     * Instantiates a new map field.
     *
     * @param defaultEntry the default entry
     * @param mode the mode
     * @param mapData the map data
     * @param listData the list data
     */
    private MapField(MapEntry<K, V> defaultEntry, StorageMode mode, Map<K, V> mapData, List<Message> listData) {
        this(new ImmutableMessageConverter<K, V>(defaultEntry), mode, mapData, listData);
    }

    /**
     * Returns an immutable empty MapField.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param defaultEntry the default entry
     * @return the map field
     */
    public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> defaultEntry) {
        return new MapField<K, V>(defaultEntry, StorageMode.MAP, Collections.<K, V> emptyMap(), null);
    }

    /**
     * Creates a new mutable empty MapField.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param defaultEntry the default entry
     * @return the map field
     */
    public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> defaultEntry) {
        return new MapField<K, V>(defaultEntry, StorageMode.MAP, new HashMap<K, V>(), null);
    }

    /**
     * Convert key and value to message.
     *
     * @param key the key
     * @param value the value
     * @return the message
     */
    private Message convertKeyAndValueToMessage(K key, V value) {
        return converter.convertKeyAndValueToMessage(key, value);
    }

    /**
     * Convert message to key and value.
     *
     * @param message the message
     * @param map the map
     */
    @SuppressWarnings("unchecked")
    private void convertMessageToKeyAndValue(Message message, Map<K, V> map) {
        converter.convertMessageToKeyAndValue(message, map);
    }

    /**
     * Convert map to list.
     *
     * @param mapData the map data
     * @return the list
     */
    private List<Message> convertMapToList(Map<K, V> mapData) {
        List<Message> listData = new ArrayList<Message>();
        for (Map.Entry<K, V> entry : mapData.entrySet()) {
            listData.add(convertKeyAndValueToMessage(entry.getKey(), entry.getValue()));
        }
        return listData;
    }

    /**
     * Convert list to map.
     *
     * @param listData the list data
     * @return the map
     */
    private Map<K, V> convertListToMap(List<Message> listData) {
        Map<K, V> mapData = new HashMap<K, V>();
        for (Message item : listData) {
            convertMessageToKeyAndValue(item, mapData);
        }
        return mapData;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public Map<K, V> getMap() {
        if (mode == StorageMode.LIST) {
            synchronized (this) {
                if (mode == StorageMode.LIST) {
                    mapData = convertListToMap(listData);
                    mode = StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(mapData);
    }

    /**
     * Gets the mutable map.
     *
     * @return the mutable map
     */
    public Map<K, V> getMutableMap() {
        if (mode != StorageMode.MAP) {
            if (mode == StorageMode.LIST) {
                mapData = convertListToMap(listData);
            }
            listData = null;
            mode = StorageMode.MAP;
        }
        return mapData;
    }

    /**
     * Merge from.
     *
     * @param other the other
     */
    public void mergeFrom(MapField<K, V> other) {
        getMutableMap().putAll(MapFieldLite.copy(other.getMap()));
    }

    /**
     * Clear.
     */
    public void clear() {
        mapData = new HashMap<K, V>();
        mode = StorageMode.MAP;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MapField)) {
            return false;
        }
        MapField<K, V> other = (MapField<K, V>) object;
        return MapFieldLite.<K, V> equals(getMap(), other.getMap());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return MapFieldLite.<K, V> calculateHashCodeForMap(getMap());
    }

    /**
     * Returns a deep copy of this MapField.
     *
     * @return the map field
     */
    public MapField<K, V> copy() {
        return new MapField<K, V>(converter, StorageMode.MAP, MapFieldLite.copy(getMap()), null);
    }

    /**
     * Gets the list.
     *
     * @return the list
     */
    List<Message> getList() {
        if (mode == StorageMode.MAP) {
            synchronized (this) {
                if (mode == StorageMode.MAP) {
                    listData = convertMapToList(mapData);
                    mode = StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(listData);
    }

    /**
     * Gets the mutable list.
     *
     * @return the mutable list
     */
    List<Message> getMutableList() {
        if (mode != StorageMode.LIST) {
            if (mode == StorageMode.MAP) {
                listData = convertMapToList(mapData);
            }
            mapData = null;
            mode = StorageMode.LIST;
        }
        return listData;
    }

    /**
     * Gets the map entry message default instance.
     *
     * @return the map entry message default instance
     */
    Message getMapEntryMessageDefaultInstance() {
        return converter.getMessageDefaultInstance();
    }
}
