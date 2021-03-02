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
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;

/**
 * Implements MapEntry messages.
 * 
 * In reflection API, map fields will be treated as repeated message fields and each map entry is accessed as a message.
 * This MapEntry class is used to represent these map entry messages in reflection API.
 * 
 * Protobuf internal. Users shouldn't use this class.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public final class MapEntry<K, V> extends AbstractMessage {

    /**
     * The Class Metadata.
     *
     * @param <K> the key type
     * @param <V> the value type
     */
    private static final class Metadata<K, V> extends MapEntryLite.Metadata<K, V> {

        /** The descriptor. */
        public final Descriptor descriptor;
        
        /** The parser. */
        public final Parser<MapEntry<K, V>> parser;

        /**
         * Instantiates a new metadata.
         *
         * @param descriptor the descriptor
         * @param defaultInstance the default instance
         * @param keyType the key type
         * @param valueType the value type
         */
        public Metadata(Descriptor descriptor, MapEntry<K, V> defaultInstance, WireFormat.FieldType keyType,
                WireFormat.FieldType valueType) {
            super(keyType, defaultInstance.key, valueType, defaultInstance.value);
            this.descriptor = descriptor;
            this.parser = new AbstractParser<MapEntry<K, V>>() {

                @Override
                public MapEntry<K, V> parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)
                        throws InvalidProtocolBufferException {
                    return new MapEntry<K, V>(Metadata.this, input, extensionRegistry);
                }
            };
        }
    }

    /** The key. */
    private final K key;
    
    /** The value. */
    private final V value;
    
    /** The metadata. */
    private final Metadata<K, V> metadata;

    /**
     *  Create a default MapEntry instance.
     *
     * @param descriptor the descriptor
     * @param keyType the key type
     * @param defaultKey the default key
     * @param valueType the value type
     * @param defaultValue the default value
     */
    private MapEntry(Descriptor descriptor, WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType,
            V defaultValue) {
        this.key = defaultKey;
        this.value = defaultValue;
        this.metadata = new Metadata<K, V>(descriptor, this, keyType, valueType);
    }

    /**
     *  Create a MapEntry with the provided key and value.
     *
     * @param metadata the metadata
     * @param key the key
     * @param value the value
     */
    private MapEntry(Metadata metadata, K key, V value) {
        this.key = key;
        this.value = value;
        this.metadata = metadata;
    }

    /**
     *  Parsing constructor.
     *
     * @param metadata the metadata
     * @param input the input
     * @param extensionRegistry the extension registry
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    private MapEntry(Metadata<K, V> metadata, CodedInputStream input, ExtensionRegistryLite extensionRegistry)
            throws InvalidProtocolBufferException {
        try {
            this.metadata = metadata;
            Map.Entry<K, V> entry = MapEntryLite.parseEntry(input, metadata, extensionRegistry);
            this.key = entry.getKey();
            this.value = entry.getValue();
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
        }
    }

    /**
     * Create a default MapEntry instance. A default MapEntry instance should be created only once for each map entry
     * message type. Generated code should store the created default instance and use it later to create new MapEntry
     * messages of the same type.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param descriptor the descriptor
     * @param keyType the key type
     * @param defaultKey the default key
     * @param valueType the value type
     * @param defaultValue the default value
     * @return the map entry
     */
    public static <K, V> MapEntry<K, V> newDefaultInstance(Descriptor descriptor, WireFormat.FieldType keyType,
            K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
        return new MapEntry<K, V>(descriptor, keyType, defaultKey, valueType, defaultValue);
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

    /** The cached serialized size. */
    private volatile int cachedSerializedSize = -1;

    /* (non-Javadoc)
     * @see com.google.protobuf.AbstractMessage#getSerializedSize()
     */
    @Override
    public int getSerializedSize() {
        if (cachedSerializedSize != -1) {
            return cachedSerializedSize;
        }

        int size = MapEntryLite.computeSerializedSize(metadata, key, value);
        cachedSerializedSize = size;
        return size;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.AbstractMessage#writeTo(com.google.protobuf.CodedOutputStream)
     */
    @Override
    public void writeTo(CodedOutputStream output) throws IOException {
        MapEntryLite.writeTo(output, metadata, key, value);
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.AbstractMessage#isInitialized()
     */
    @Override
    public boolean isInitialized() {
        return isInitialized(metadata, value);
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLite#getParserForType()
     */
    @Override
    public Parser<MapEntry<K, V>> getParserForType() {
        return metadata.parser;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLite#newBuilderForType()
     */
    @Override
    public Builder<K, V> newBuilderForType() {
        return new Builder<K, V>(metadata);
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLite#toBuilder()
     */
    @Override
    public Builder<K, V> toBuilder() {
        return new Builder<K, V>(metadata, key, value);
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
     */
    @Override
    public MapEntry<K, V> getDefaultInstanceForType() {
        return new MapEntry<K, V>(metadata, metadata.defaultKey, metadata.defaultValue);
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageOrBuilder#getDescriptorForType()
     */
    @Override
    public Descriptor getDescriptorForType() {
        return metadata.descriptor;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageOrBuilder#getAllFields()
     */
    @Override
    public Map<FieldDescriptor, Object> getAllFields() {
        TreeMap<FieldDescriptor, Object> result = new TreeMap<FieldDescriptor, Object>();
        for (final FieldDescriptor field : metadata.descriptor.getFields()) {
            if (hasField(field)) {
                result.put(field, getField(field));
            }
        }
        return Collections.unmodifiableMap(result);
    }

    /**
     * Check field descriptor.
     *
     * @param field the field
     */
    private void checkFieldDescriptor(FieldDescriptor field) {
        if (field.getContainingType() != metadata.descriptor) {
            throw new RuntimeException("Wrong FieldDescriptor \"" + field.getFullName() + "\" used in message \""
                    + metadata.descriptor.getFullName());
        }
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageOrBuilder#hasField(com.google.protobuf.Descriptors.FieldDescriptor)
     */
    @Override
    public boolean hasField(FieldDescriptor field) {
        checkFieldDescriptor(field);
        ;
        // A MapEntry always contains two fields.
        return true;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageOrBuilder#getField(com.google.protobuf.Descriptors.FieldDescriptor)
     */
    @Override
    public Object getField(FieldDescriptor field) {
        checkFieldDescriptor(field);
        Object result = field.getNumber() == 1 ? getKey() : getValue();
        // Convert enums to EnumValueDescriptor.
        if (field.getType() == FieldDescriptor.Type.ENUM) {
            result = field.getEnumType().findValueByNumberCreatingIfUnknown((java.lang.Integer) result);
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageOrBuilder#getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor)
     */
    @Override
    public int getRepeatedFieldCount(FieldDescriptor field) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageOrBuilder#getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor, int)
     */
    @Override
    public Object getRepeatedField(FieldDescriptor field, int index) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageOrBuilder#getUnknownFields()
     */
    @Override
    public UnknownFieldSet getUnknownFields() {
        return UnknownFieldSet.getDefaultInstance();
    }

    /**
     * Builder to create {@link MapEntry} messages.
     *
     * @param <K> the key type
     * @param <V> the value type
     */
    public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {
        
        /** The metadata. */
        private final Metadata<K, V> metadata;
        
        /** The key. */
        private K key;
        
        /** The value. */
        private V value;

        /**
         * Instantiates a new builder.
         *
         * @param metadata the metadata
         */
        private Builder(Metadata<K, V> metadata) {
            this(metadata, metadata.defaultKey, metadata.defaultValue);
        }

        /**
         * Instantiates a new builder.
         *
         * @param metadata the metadata
         * @param key the key
         * @param value the value
         */
        private Builder(Metadata<K, V> metadata, K key, V value) {
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
         * Sets the key.
         *
         * @param key the key
         * @return the builder
         */
        public Builder<K, V> setKey(K key) {
            this.key = key;
            return this;
        }

        /**
         * Clear key.
         *
         * @return the builder
         */
        public Builder<K, V> clearKey() {
            this.key = metadata.defaultKey;
            return this;
        }

        /**
         * Sets the value.
         *
         * @param value the value
         * @return the builder
         */
        public Builder<K, V> setValue(V value) {
            this.value = value;
            return this;
        }

        /**
         * Clear value.
         *
         * @return the builder
         */
        public Builder<K, V> clearValue() {
            this.value = metadata.defaultValue;
            return this;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLite.Builder#build()
         */
        @Override
        public MapEntry<K, V> build() {
            MapEntry<K, V> result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLite.Builder#buildPartial()
         */
        @Override
        public MapEntry<K, V> buildPartial() {
            return new MapEntry<K, V>(metadata, key, value);
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.Message.Builder#getDescriptorForType()
         */
        @Override
        public Descriptor getDescriptorForType() {
            return metadata.descriptor;
        }

        /**
         * Check field descriptor.
         *
         * @param field the field
         */
        private void checkFieldDescriptor(FieldDescriptor field) {
            if (field.getContainingType() != metadata.descriptor) {
                throw new RuntimeException("Wrong FieldDescriptor \"" + field.getFullName() + "\" used in message \""
                        + metadata.descriptor.getFullName());
            }
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.Message.Builder#newBuilderForField(com.google.protobuf.Descriptors.FieldDescriptor)
         */
        @Override
        public Message.Builder newBuilderForField(FieldDescriptor field) {
            checkFieldDescriptor(field);
            ;
            // This method should be called for message fields and in a MapEntry
            // message only the value field can possibly be a message field.
            if (field.getNumber() != 2 || field.getJavaType() != FieldDescriptor.JavaType.MESSAGE) {
                throw new RuntimeException("\"" + field.getFullName() + "\" is not a message value field.");
            }
            return ((Message) value).newBuilderForType();
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.Message.Builder#setField(com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object)
         */
        @SuppressWarnings("unchecked")
        @Override
        public Builder<K, V> setField(FieldDescriptor field, Object value) {
            checkFieldDescriptor(field);
            if (field.getNumber() == 1) {
                setKey((K) value);
            } else {
                if (field.getType() == FieldDescriptor.Type.ENUM) {
                    value = ((EnumValueDescriptor) value).getNumber();
                }
                setValue((V) value);
            }
            return this;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.Message.Builder#clearField(com.google.protobuf.Descriptors.FieldDescriptor)
         */
        @Override
        public Builder<K, V> clearField(FieldDescriptor field) {
            checkFieldDescriptor(field);
            if (field.getNumber() == 1) {
                clearKey();
            } else {
                clearValue();
            }
            return this;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.Message.Builder#setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor, int, java.lang.Object)
         */
        @Override
        public Builder<K, V> setRepeatedField(FieldDescriptor field, int index, Object value) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.Message.Builder#addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object)
         */
        @Override
        public Builder<K, V> addRepeatedField(FieldDescriptor field, Object value) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.Message.Builder#setUnknownFields(com.google.protobuf.UnknownFieldSet)
         */
        @Override
        public Builder<K, V> setUnknownFields(UnknownFieldSet unknownFields) {
            // Unknown fields are discarded for MapEntry message.
            return this;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
         */
        @Override
        public MapEntry<K, V> getDefaultInstanceForType() {
            return new MapEntry<K, V>(metadata, metadata.defaultKey, metadata.defaultValue);
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLiteOrBuilder#isInitialized()
         */
        @Override
        public boolean isInitialized() {
            return MapEntry.isInitialized(metadata, value);
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageOrBuilder#getAllFields()
         */
        @Override
        public Map<FieldDescriptor, Object> getAllFields() {
            final TreeMap<FieldDescriptor, Object> result = new TreeMap<FieldDescriptor, Object>();
            for (final FieldDescriptor field : metadata.descriptor.getFields()) {
                if (hasField(field)) {
                    result.put(field, getField(field));
                }
            }
            return Collections.unmodifiableMap(result);
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageOrBuilder#hasField(com.google.protobuf.Descriptors.FieldDescriptor)
         */
        @Override
        public boolean hasField(FieldDescriptor field) {
            checkFieldDescriptor(field);
            return true;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageOrBuilder#getField(com.google.protobuf.Descriptors.FieldDescriptor)
         */
        @Override
        public Object getField(FieldDescriptor field) {
            checkFieldDescriptor(field);
            Object result = field.getNumber() == 1 ? getKey() : getValue();
            // Convert enums to EnumValueDescriptor.
            if (field.getType() == FieldDescriptor.Type.ENUM) {
                result = field.getEnumType().findValueByNumberCreatingIfUnknown((Integer) result);
            }
            return result;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageOrBuilder#getRepeatedFieldCount(com.google.protobuf.Descriptors.FieldDescriptor)
         */
        @Override
        public int getRepeatedFieldCount(FieldDescriptor field) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageOrBuilder#getRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor, int)
         */
        @Override
        public Object getRepeatedField(FieldDescriptor field, int index) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageOrBuilder#getUnknownFields()
         */
        @Override
        public UnknownFieldSet getUnknownFields() {
            return UnknownFieldSet.getDefaultInstance();
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.AbstractMessage.Builder#clone()
         */
        @Override
        public Builder<K, V> clone() {
            return new Builder(metadata, key, value);
        }
    }

    /**
     * Checks if is initialized.
     *
     * @param <V> the value type
     * @param metadata the metadata
     * @param value the value
     * @return true, if is initialized
     */
    private static <V> boolean isInitialized(Metadata metadata, V value) {
        if (metadata.valueType.getJavaType() == WireFormat.JavaType.MESSAGE) {
            return value != null;
        }
        return true;
    }
}
