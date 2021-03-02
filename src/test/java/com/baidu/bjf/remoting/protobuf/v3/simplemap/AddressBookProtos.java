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
// source: addressbook.proto

package com.baidu.bjf.remoting.protobuf.v3.simplemap;

public final class AddressBookProtos {
  private AddressBookProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PersonOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.baidu.bjf.remoting.protobuf.v3.Person)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string name = 1;</code>
     */
    boolean hasName();
    /**
     * <code>required string name = 1;</code>
     */
    java.lang.String getName();
    /**
     * <code>required string name = 1;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>map&lt;string, string&gt; stringMap = 2;</code>
     */
    java.util.Map<java.lang.String, java.lang.String>
    getStringMap();

    /**
     * <code>map&lt;int32, int32&gt; intMap = 3;</code>
     */
    java.util.Map<java.lang.Integer, java.lang.Integer>
    getIntMap();

    /**
     * <code>map&lt;int64, int64&gt; longMap = 4;</code>
     */
    java.util.Map<java.lang.Long, java.lang.Long>
    getLongMap();

    /**
     * <code>map&lt;bool, bool&gt; booleanMap = 5;</code>
     */
    java.util.Map<java.lang.Boolean, java.lang.Boolean>
    getBooleanMap();
  }
  /**
   * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person}
   */
  public  static final class Person extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.baidu.bjf.remoting.protobuf.v3.Person)
      PersonOrBuilder {
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessage.Builder builder) {
      super(builder);
    }
    private Person() {
      name_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Person(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              name_ = bs;
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                stringMap_ = com.google.protobuf.MapField.newMapField(
                    stringMapDefaultEntry);
                mutable_bitField0_ |= 0x00000002;
              }
              com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
              stringMap = input.readMessage(
                  stringMapDefaultEntry.getParserForType(), extensionRegistry);
              stringMap_.getMutableMap().put(stringMap.getKey(), stringMap.getValue());
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                intMap_ = com.google.protobuf.MapField.newMapField(
                    intMapDefaultEntry);
                mutable_bitField0_ |= 0x00000004;
              }
              com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
              intMap = input.readMessage(
                  intMapDefaultEntry.getParserForType(), extensionRegistry);
              intMap_.getMutableMap().put(intMap.getKey(), intMap.getValue());
              break;
            }
            case 34: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                longMap_ = com.google.protobuf.MapField.newMapField(
                    longMapDefaultEntry);
                mutable_bitField0_ |= 0x00000008;
              }
              com.google.protobuf.MapEntry<java.lang.Long, java.lang.Long>
              longMap = input.readMessage(
                  longMapDefaultEntry.getParserForType(), extensionRegistry);
              longMap_.getMutableMap().put(longMap.getKey(), longMap.getValue());
              break;
            }
            case 42: {
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                booleanMap_ = com.google.protobuf.MapField.newMapField(
                    booleanMapDefaultEntry);
                mutable_bitField0_ |= 0x00000010;
              }
              com.google.protobuf.MapEntry<java.lang.Boolean, java.lang.Boolean>
              booleanMap = input.readMessage(
                  booleanMapDefaultEntry.getParserForType(), extensionRegistry);
              booleanMap_.getMutableMap().put(booleanMap.getKey(), booleanMap.getValue());
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return stringMap_;
        case 3:
          return intMap_;
        case 4:
          return longMap_;
        case 5:
          return booleanMap_;
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.class, com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.Builder.class);
    }

    public static final com.google.protobuf.Parser<Person> PARSER =
        new com.google.protobuf.AbstractParser<Person>() {
      public Person parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Person(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Person> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private java.lang.Object name_;
    /**
     * <code>required string name = 1;</code>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STRINGMAP_FIELD_NUMBER = 2;
    private static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> stringMapDefaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_StringMapEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> stringMap_ =
            com.google.protobuf.MapField.emptyMapField(
                stringMapDefaultEntry);

    /**
     * <code>map&lt;string, string&gt; stringMap = 2;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getStringMap() {
      return stringMap_.getMap();
    }

    public static final int INTMAP_FIELD_NUMBER = 3;
    private static final com.google.protobuf.MapEntry<
        java.lang.Integer, java.lang.Integer> intMapDefaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, java.lang.Integer>newDefaultInstance(
                com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_IntMapEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.INT32,
                0);
    private com.google.protobuf.MapField<
        java.lang.Integer, java.lang.Integer> intMap_ =
            com.google.protobuf.MapField.emptyMapField(
                intMapDefaultEntry);

    /**
     * <code>map&lt;int32, int32&gt; intMap = 3;</code>
     */

    public java.util.Map<java.lang.Integer, java.lang.Integer> getIntMap() {
      return intMap_.getMap();
    }

    public static final int LONGMAP_FIELD_NUMBER = 4;
    private static final com.google.protobuf.MapEntry<
        java.lang.Long, java.lang.Long> longMapDefaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Long, java.lang.Long>newDefaultInstance(
                com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_LongMapEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT64,
                0L,
                com.google.protobuf.WireFormat.FieldType.INT64,
                0L);
    private com.google.protobuf.MapField<
        java.lang.Long, java.lang.Long> longMap_ =
            com.google.protobuf.MapField.emptyMapField(
                longMapDefaultEntry);

    /**
     * <code>map&lt;int64, int64&gt; longMap = 4;</code>
     */

    public java.util.Map<java.lang.Long, java.lang.Long> getLongMap() {
      return longMap_.getMap();
    }

    public static final int BOOLEANMAP_FIELD_NUMBER = 5;
    private static final com.google.protobuf.MapEntry<
        java.lang.Boolean, java.lang.Boolean> booleanMapDefaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Boolean, java.lang.Boolean>newDefaultInstance(
                com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_BooleanMapEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.BOOL,
                false,
                com.google.protobuf.WireFormat.FieldType.BOOL,
                false);
    private com.google.protobuf.MapField<
        java.lang.Boolean, java.lang.Boolean> booleanMap_ =
            com.google.protobuf.MapField.emptyMapField(
                booleanMapDefaultEntry);

    /**
     * <code>map&lt;bool, bool&gt; booleanMap = 5;</code>
     */

    public java.util.Map<java.lang.Boolean, java.lang.Boolean> getBooleanMap() {
      return booleanMap_.getMap();
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasName()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getNameBytes());
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : stringMap_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        stringMap = stringMapDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(2, stringMap);
      }
      for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry
           : intMap_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
        intMap = intMapDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(3, intMap);
      }
      for (java.util.Map.Entry<java.lang.Long, java.lang.Long> entry
           : longMap_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.Long, java.lang.Long>
        longMap = longMapDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(4, longMap);
      }
      for (java.util.Map.Entry<java.lang.Boolean, java.lang.Boolean> entry
           : booleanMap_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.Boolean, java.lang.Boolean>
        booleanMap = booleanMapDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(5, booleanMap);
      }
      unknownFields.writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getNameBytes());
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : stringMap_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        stringMap = stringMapDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(2, stringMap);
      }
      for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry
           : intMap_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.Integer, java.lang.Integer>
        intMap = intMapDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(3, intMap);
      }
      for (java.util.Map.Entry<java.lang.Long, java.lang.Long> entry
           : longMap_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.Long, java.lang.Long>
        longMap = longMapDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(4, longMap);
      }
      for (java.util.Map.Entry<java.lang.Boolean, java.lang.Boolean> entry
           : booleanMap_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.Boolean, java.lang.Boolean>
        booleanMap = booleanMapDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(5, booleanMap);
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return new Builder(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.baidu.bjf.remoting.protobuf.v3.Person)
        com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(
          int number) {
        switch (number) {
          case 2:
            return stringMap_;
          case 3:
            return intMap_;
          case 4:
            return longMap_;
          case 5:
            return booleanMap_;
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.class, com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        name_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        stringMap_.clear();
        intMap_.clear();
        longMap_.clear();
        booleanMap_.clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
      }

      public com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.getDefaultInstance();
      }

      public com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person build() {
        com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person buildPartial() {
        com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person result = new com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.name_ = name_;
        result.stringMap_ = stringMap_.copy();
        result.intMap_ = intMap_.copy();
        result.longMap_ = longMap_.copy();
        result.booleanMap_ = booleanMap_.copy();
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person other) {
        if (other == com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person.getDefaultInstance()) return this;
        if (other.hasName()) {
          bitField0_ |= 0x00000001;
          name_ = other.name_;
          onChanged();
        }
        stringMap_.mergeFrom(other.stringMap_);
        intMap_.mergeFrom(other.intMap_);
        longMap_.mergeFrom(other.longMap_);
        booleanMap_.mergeFrom(other.booleanMap_);
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasName()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object name_ = "";
      /**
       * <code>required string name = 1;</code>
       */
      public boolean hasName() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string name = 1;</code>
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            name_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string name = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string name = 1;</code>
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 1;</code>
       */
      public Builder clearName() {
        bitField0_ = (bitField0_ & ~0x00000001);
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 1;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.MapField<
          java.lang.String, java.lang.String> stringMap_ =
              com.google.protobuf.MapField.newMapField(
                  stringMapDefaultEntry);

      /**
       * <code>map&lt;string, string&gt; stringMap = 2;</code>
       */
      public java.util.Map<java.lang.String, java.lang.String> getStringMap() {
        return stringMap_.getMap();
      }
      /**
       * <code>map&lt;string, string&gt; stringMap = 2;</code>
       */
      public java.util.Map<java.lang.String, java.lang.String>
      getMutableStringMap() {
        onChanged();
        return stringMap_.getMutableMap();
      }

      private com.google.protobuf.MapField<
          java.lang.Integer, java.lang.Integer> intMap_ =
              com.google.protobuf.MapField.newMapField(
                  intMapDefaultEntry);

      /**
       * <code>map&lt;int32, int32&gt; intMap = 3;</code>
       */
      public java.util.Map<java.lang.Integer, java.lang.Integer> getIntMap() {
        return intMap_.getMap();
      }
      /**
       * <code>map&lt;int32, int32&gt; intMap = 3;</code>
       */
      public java.util.Map<java.lang.Integer, java.lang.Integer>
      getMutableIntMap() {
        onChanged();
        return intMap_.getMutableMap();
      }

      private com.google.protobuf.MapField<
          java.lang.Long, java.lang.Long> longMap_ =
              com.google.protobuf.MapField.newMapField(
                  longMapDefaultEntry);

      /**
       * <code>map&lt;int64, int64&gt; longMap = 4;</code>
       */
      public java.util.Map<java.lang.Long, java.lang.Long> getLongMap() {
        return longMap_.getMap();
      }
      /**
       * <code>map&lt;int64, int64&gt; longMap = 4;</code>
       */
      public java.util.Map<java.lang.Long, java.lang.Long>
      getMutableLongMap() {
        onChanged();
        return longMap_.getMutableMap();
      }

      private com.google.protobuf.MapField<
          java.lang.Boolean, java.lang.Boolean> booleanMap_ =
              com.google.protobuf.MapField.newMapField(
                  booleanMapDefaultEntry);

      /**
       * <code>map&lt;bool, bool&gt; booleanMap = 5;</code>
       */
      public java.util.Map<java.lang.Boolean, java.lang.Boolean> getBooleanMap() {
        return booleanMap_.getMap();
      }
      /**
       * <code>map&lt;bool, bool&gt; booleanMap = 5;</code>
       */
      public java.util.Map<java.lang.Boolean, java.lang.Boolean>
      getMutableBooleanMap() {
        onChanged();
        return booleanMap_.getMutableMap();
      }

      // @@protoc_insertion_point(builder_scope:com.baidu.bjf.remoting.protobuf.v3.Person)
    }

    // @@protoc_insertion_point(class_scope:com.baidu.bjf.remoting.protobuf.v3.Person)
    private static final com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person defaultInstance;static {
      defaultInstance = new com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person();
    }

    public static com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person getDefaultInstance() {
      return defaultInstance;
    }

    public com.baidu.bjf.remoting.protobuf.v3.simplemap.AddressBookProtos.Person getDefaultInstanceForType() {
      return defaultInstance;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_StringMapEntry_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_StringMapEntry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_IntMapEntry_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_IntMapEntry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_LongMapEntry_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_LongMapEntry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_BooleanMapEntry_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_BooleanMapEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021addressbook.proto\022\"com.baidu.bjf.remot" +
      "ing.protobuf.v3\"\212\004\n\006Person\022\014\n\004name\030\001 \002(\t" +
      "\022L\n\tstringMap\030\002 \003(\01329.com.baidu.bjf.remo" +
      "ting.protobuf.v3.Person.StringMapEntry\022F" +
      "\n\006intMap\030\003 \003(\01326.com.baidu.bjf.remoting." +
      "protobuf.v3.Person.IntMapEntry\022H\n\007longMa" +
      "p\030\004 \003(\01327.com.baidu.bjf.remoting.protobu" +
      "f.v3.Person.LongMapEntry\022N\n\nbooleanMap\030\005" +
      " \003(\0132:.com.baidu.bjf.remoting.protobuf.v" +
      "3.Person.BooleanMapEntry\0320\n\016StringMapEnt",
      "ry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\032-\n\013In" +
      "tMapEntry\022\013\n\003key\030\001 \001(\005\022\r\n\005value\030\002 \001(\005:\0028" +
      "\001\032.\n\014LongMapEntry\022\013\n\003key\030\001 \001(\003\022\r\n\005value\030" +
      "\002 \001(\003:\0028\001\0321\n\017BooleanMapEntry\022\013\n\003key\030\001 \001(" +
      "\010\022\r\n\005value\030\002 \001(\010:\0028\001BA\n,com.baidu.bjf.re" +
      "moting.protobuf.v3.simplemapB\021AddressBoo" +
      "kProtos"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor,
        new java.lang.String[] { "Name", "StringMap", "IntMap", "LongMap", "BooleanMap", });
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_StringMapEntry_descriptor =
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor.getNestedTypes().get(0);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_StringMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_StringMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_IntMapEntry_descriptor =
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor.getNestedTypes().get(1);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_IntMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_IntMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_LongMapEntry_descriptor =
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor.getNestedTypes().get(2);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_LongMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_LongMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_BooleanMapEntry_descriptor =
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor.getNestedTypes().get(3);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_BooleanMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_BooleanMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
