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
import java.util.AbstractMap;
import java.util.Map;

import com.baidu.bjf.remoting.protobuf.code.CodedConstant;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.WireFormat;

/**
 * Implements the lite version of map entry messages.
 * 
 * This class serves as an utility class to help do serialization/parsing of map entries. It's used in generated code
 * and also in the full version MapEntry message.
 * 
 * Protobuf internal. Users shouldn't use.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class MapEntryLite<K, V> {

    /**
     * The Class Metadata.
     *
     * @param <K> the key type
     * @param <V> the value type
     */
    static class Metadata<K, V> {
        
        /** The key type. */
        public final WireFormat.FieldType keyType;
        
        /** The default key. */
        public final K defaultKey;
        
        /** The value type. */
        public final WireFormat.FieldType valueType;
        
        /** The default value. */
        public final V defaultValue;

        /**
         * Instantiates a new metadata.
         *
         * @param keyType the key type
         * @param defaultKey the default key
         * @param valueType the value type
         * @param defaultValue the default value
         */
        public Metadata(WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
            this.keyType = keyType;
            this.defaultKey = defaultKey;
            this.valueType = valueType;
            this.defaultValue = defaultValue;
        }
    }

    /** The Constant KEY_FIELD_NUMBER. */
    private static final int KEY_FIELD_NUMBER = 1;
    
    /** The Constant VALUE_FIELD_NUMBER. */
    private static final int VALUE_FIELD_NUMBER = 2;

    /** The metadata. */
    private final Metadata<K, V> metadata;
    
    /** The key. */
    private final K key;
    
    /** The value. */
    private final V value;

    /**
     *  Creates a default MapEntryLite message instance.
     *
     * @param keyType the key type
     * @param defaultKey the default key
     * @param valueType the value type
     * @param defaultValue the default value
     */
    private MapEntryLite(WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
        this.metadata = new Metadata<K, V>(keyType, defaultKey, valueType, defaultValue);
        this.key = defaultKey;
        this.value = defaultValue;
    }

    /**
     *  Creates a new MapEntryLite message.
     *
     * @param metadata the metadata
     * @param key the key
     * @param value the value
     */
    private MapEntryLite(Metadata<K, V> metadata, K key, V value) {
        this.metadata = metadata;
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * Creates a default MapEntryLite message instance.
     * 
     * This method is used by generated code to create the default instance for a map entry message. The created default
     * instance should be used to create new map entry messages of the same type. For each map entry message, only one
     * default instance should be created.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param keyType the key type
     * @param defaultKey the default key
     * @param valueType the value type
     * @param defaultValue the default value
     * @return the map entry lite
     */
    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType keyType, K defaultKey,
            WireFormat.FieldType valueType, V defaultValue) {
        return new MapEntryLite<K, V>(keyType, defaultKey, valueType, defaultValue);
    }

    /**
     * Write to.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param output the output
     * @param metadata the metadata
     * @param key the key
     * @param value the value
     * @throws IOException Signals that an I/O exception has occurred.
     */
    static <K, V> void writeTo(CodedOutputStream output, Metadata<K, V> metadata, K key, V value) throws IOException {
        CodedConstant.writeElement(output, metadata.keyType, KEY_FIELD_NUMBER, key);
        CodedConstant.writeElement(output, metadata.valueType, VALUE_FIELD_NUMBER, value);
    }

    /**
     * Compute serialized size.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param metadata the metadata
     * @param key the key
     * @param value the value
     * @return the int
     */
    static <K, V> int computeSerializedSize(Metadata<K, V> metadata, K key, V value) {
        return CodedConstant.computeElementSize(metadata.keyType, KEY_FIELD_NUMBER, key)
                + CodedConstant.computeElementSize(metadata.valueType, VALUE_FIELD_NUMBER, value);
    }

    /**
     * Parses the field.
     *
     * @param <T> the generic type
     * @param input the input
     * @param extensionRegistry the extension registry
     * @param type the type
     * @param value the value
     * @return the t
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @SuppressWarnings("unchecked")
    static <T> T parseField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, WireFormat.FieldType type,
            T value) throws IOException {
        switch (type) {
            case MESSAGE:
                int length = input.readRawVarint32();
                final int oldLimit = input.pushLimit(length);
                Codec<? extends Object> codec = ProtobufProxy.create(value.getClass());
                T ret = (T) codec.decode(input.readRawBytes(length));
                input.popLimit(oldLimit);
                return ret;
            case ENUM:
                return (T) (java.lang.Integer) input.readEnum();
            case GROUP:
                throw new RuntimeException("Groups are not allowed in maps.");
            default:
                return (T) CodedConstant.readPrimitiveField(input, type, true);
        }
    }

    /**
     * Serializes the provided key and value as though they were wrapped by a {@link MapEntryLite} to the output stream.
     * This helper method avoids allocation of a {@link MapEntryLite} built with a key and value and is called from
     * generated code directly.
     *
     * @param output the output
     * @param fieldNumber the field number
     * @param key the key
     * @param value the value
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void serializeTo(CodedOutputStream output, int fieldNumber, K key, V value) throws IOException {
        output.writeTag(fieldNumber, WireFormat.WIRETYPE_LENGTH_DELIMITED);
        output.writeUInt32NoTag(computeSerializedSize(metadata, key, value));
        writeTo(output, metadata, key, value);
    }

    /**
     * Computes the message size for the provided key and value as though they were wrapped by a {@link MapEntryLite}.
     * This helper method avoids allocation of a {@link MapEntryLite} built with a key and value and is called from
     * generated code directly.
     *
     * @param fieldNumber the field number
     * @param key the key
     * @param value the value
     * @return the int
     */
    public int computeMessageSize(int fieldNumber, K key, V value) {
        return CodedOutputStream.computeTagSize(fieldNumber)
                + CodedConstant.computeLengthDelimitedFieldSize(computeSerializedSize(metadata, key, value));
    }

    /**
     * Parses an entry off of the input as a {@link Map.Entry}. This helper requires an allocation so using
     * {@link #parseInto} is preferred if possible.
     *
     * @param bytes the bytes
     * @param extensionRegistry the extension registry
     * @return the map. entry
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Map.Entry<K, V> parseEntry(ByteString bytes, ExtensionRegistryLite extensionRegistry) throws IOException {
        return parseEntry(bytes.newCodedInput(), metadata, extensionRegistry);
    }

    /**
     * Parses the entry.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param input the input
     * @param metadata the metadata
     * @param extensionRegistry the extension registry
     * @return the map. entry
     * @throws IOException Signals that an I/O exception has occurred.
     */
    static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream input, Metadata<K, V> metadata,
            ExtensionRegistryLite extensionRegistry) throws IOException {
        K key = metadata.defaultKey;
        V value = metadata.defaultValue;
        while (true) {
            int tag = input.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == CodedConstant.makeTag(KEY_FIELD_NUMBER, metadata.keyType.getWireType())) {
                key = parseField(input, extensionRegistry, metadata.keyType, key);
            } else if (tag == CodedConstant.makeTag(VALUE_FIELD_NUMBER, metadata.valueType.getWireType())) {
                value = parseField(input, extensionRegistry, metadata.valueType, value);
            } else {
                if (!input.skipField(tag)) {
                    break;
                }
            }
        }
        return new AbstractMap.SimpleImmutableEntry<K, V>(key, value);
    }

    /**
     * Parses an entry off of the input into the map. This helper avoids allocaton of a {@link MapEntryLite} by parsing
     * directly into the provided {@link MapFieldLite}.
     *
     * @param map the map
     * @param input the input
     * @param extensionRegistry the extension registry
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void parseInto(MapFieldLite<K, V> map, CodedInputStream input, ExtensionRegistryLite extensionRegistry)
            throws IOException {
        int length = input.readRawVarint32();
        final int oldLimit = input.pushLimit(length);
        K key = metadata.defaultKey;
        V value = metadata.defaultValue;

        while (true) {
            int tag = input.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == CodedConstant.makeTag(KEY_FIELD_NUMBER, metadata.keyType.getWireType())) {
                key = parseField(input, extensionRegistry, metadata.keyType, key);
            } else if (tag == CodedConstant.makeTag(VALUE_FIELD_NUMBER, metadata.valueType.getWireType())) {
                value = parseField(input, extensionRegistry, metadata.valueType, value);
            } else {
                if (!input.skipField(tag)) {
                    break;
                }
            }
        }

        input.checkLastTagWas(0);
        input.popLimit(oldLimit);
        map.put(key, value);
    }
}
