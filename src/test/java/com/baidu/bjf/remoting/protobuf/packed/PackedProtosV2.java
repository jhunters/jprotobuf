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
// source: packed.proto

package com.baidu.bjf.remoting.protobuf.packed;

public final class PackedProtosV2 {
  private PackedProtosV2() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PersonOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // repeated string name = 1;
    /**
     * <code>repeated string name = 1;</code>
     */
    java.util.List<java.lang.String>
    getNameList();
    /**
     * <code>repeated string name = 1;</code>
     */
    int getNameCount();
    /**
     * <code>repeated string name = 1;</code>
     */
    java.lang.String getName(int index);
    /**
     * <code>repeated string name = 1;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes(int index);

    // repeated int32 id = 2;
    /**
     * <code>repeated int32 id = 2;</code>
     *
     * <pre>
     * Unique ID number for this person.
     * </pre>
     */
    java.util.List<java.lang.Integer> getIdList();
    /**
     * <code>repeated int32 id = 2;</code>
     *
     * <pre>
     * Unique ID number for this person.
     * </pre>
     */
    int getIdCount();
    /**
     * <code>repeated int32 id = 2;</code>
     *
     * <pre>
     * Unique ID number for this person.
     * </pre>
     */
    int getId(int index);

    // repeated string email = 3;
    /**
     * <code>repeated string email = 3;</code>
     */
    java.util.List<java.lang.String>
    getEmailList();
    /**
     * <code>repeated string email = 3;</code>
     */
    int getEmailCount();
    /**
     * <code>repeated string email = 3;</code>
     */
    java.lang.String getEmail(int index);
    /**
     * <code>repeated string email = 3;</code>
     */
    com.google.protobuf.ByteString
        getEmailBytes(int index);

    // repeated double doubleF = 4;
    /**
     * <code>repeated double doubleF = 4;</code>
     */
    java.util.List<java.lang.Double> getDoubleFList();
    /**
     * <code>repeated double doubleF = 4;</code>
     */
    int getDoubleFCount();
    /**
     * <code>repeated double doubleF = 4;</code>
     */
    double getDoubleF(int index);

    // repeated float floatF = 5;
    /**
     * <code>repeated float floatF = 5;</code>
     */
    java.util.List<java.lang.Float> getFloatFList();
    /**
     * <code>repeated float floatF = 5;</code>
     */
    int getFloatFCount();
    /**
     * <code>repeated float floatF = 5;</code>
     */
    float getFloatF(int index);

    // repeated bytes bytesF = 6;
    /**
     * <code>repeated bytes bytesF = 6;</code>
     */
    java.util.List<com.google.protobuf.ByteString> getBytesFList();
    /**
     * <code>repeated bytes bytesF = 6;</code>
     */
    int getBytesFCount();
    /**
     * <code>repeated bytes bytesF = 6;</code>
     */
    com.google.protobuf.ByteString getBytesF(int index);

    // repeated bool boolF = 7;
    /**
     * <code>repeated bool boolF = 7;</code>
     */
    java.util.List<java.lang.Boolean> getBoolFList();
    /**
     * <code>repeated bool boolF = 7;</code>
     */
    int getBoolFCount();
    /**
     * <code>repeated bool boolF = 7;</code>
     */
    boolean getBoolF(int index);
  }
  /**
   * Protobuf type {@code tutorial.Person}
   */
  public static final class Person extends
      com.google.protobuf.GeneratedMessage
      implements PersonOrBuilder {
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Person(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Person defaultInstance;
    public static Person getDefaultInstance() {
      return defaultInstance;
    }

    public Person getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Person(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
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
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                name_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000001;
              }
              name_.add(input.readBytes());
              break;
            }
            case 16: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                id_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000002;
              }
              id_.add(input.readInt32());
              break;
            }
            case 18: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
                id_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000002;
              }
              while (input.getBytesUntilLimit() > 0) {
                id_.add(input.readInt32());
              }
              input.popLimit(limit);
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                email_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000004;
              }
              email_.add(input.readBytes());
              break;
            }
            case 33: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                doubleF_ = new java.util.ArrayList<java.lang.Double>();
                mutable_bitField0_ |= 0x00000008;
              }
              doubleF_.add(input.readDouble());
              break;
            }
            case 34: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008) && input.getBytesUntilLimit() > 0) {
                doubleF_ = new java.util.ArrayList<java.lang.Double>();
                mutable_bitField0_ |= 0x00000008;
              }
              while (input.getBytesUntilLimit() > 0) {
                doubleF_.add(input.readDouble());
              }
              input.popLimit(limit);
              break;
            }
            case 45: {
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
                floatF_ = new java.util.ArrayList<java.lang.Float>();
                mutable_bitField0_ |= 0x00000010;
              }
              floatF_.add(input.readFloat());
              break;
            }
            case 42: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000010) == 0x00000010) && input.getBytesUntilLimit() > 0) {
                floatF_ = new java.util.ArrayList<java.lang.Float>();
                mutable_bitField0_ |= 0x00000010;
              }
              while (input.getBytesUntilLimit() > 0) {
                floatF_.add(input.readFloat());
              }
              input.popLimit(limit);
              break;
            }
            case 50: {
              if (!((mutable_bitField0_ & 0x00000020) == 0x00000020)) {
                bytesF_ = new java.util.ArrayList<com.google.protobuf.ByteString>();
                mutable_bitField0_ |= 0x00000020;
              }
              bytesF_.add(input.readBytes());
              break;
            }
            case 56: {
              if (!((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
                boolF_ = new java.util.ArrayList<java.lang.Boolean>();
                mutable_bitField0_ |= 0x00000040;
              }
              boolF_.add(input.readBool());
              break;
            }
            case 58: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000040) == 0x00000040) && input.getBytesUntilLimit() > 0) {
                boolF_ = new java.util.ArrayList<java.lang.Boolean>();
                mutable_bitField0_ |= 0x00000040;
              }
              while (input.getBytesUntilLimit() > 0) {
                boolF_.add(input.readBool());
              }
              input.popLimit(limit);
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
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          name_ = new com.google.protobuf.UnmodifiableLazyStringList(name_);
        }
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          id_ = java.util.Collections.unmodifiableList(id_);
        }
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          email_ = new com.google.protobuf.UnmodifiableLazyStringList(email_);
        }
        if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
          doubleF_ = java.util.Collections.unmodifiableList(doubleF_);
        }
        if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
          floatF_ = java.util.Collections.unmodifiableList(floatF_);
        }
        if (((mutable_bitField0_ & 0x00000020) == 0x00000020)) {
          bytesF_ = java.util.Collections.unmodifiableList(bytesF_);
        }
        if (((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
          boolF_ = java.util.Collections.unmodifiableList(boolF_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.internal_static_tutorial_Person_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.internal_static_tutorial_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.class, com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.Builder.class);
    }

    public static com.google.protobuf.Parser<Person> PARSER =
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

    // repeated string name = 1;
    public static final int NAME_FIELD_NUMBER = 1;
    private com.google.protobuf.LazyStringList name_;
    /**
     * <code>repeated string name = 1;</code>
     */
    public java.util.List<java.lang.String>
        getNameList() {
      return name_;
    }
    /**
     * <code>repeated string name = 1;</code>
     */
    public int getNameCount() {
      return name_.size();
    }
    /**
     * <code>repeated string name = 1;</code>
     */
    public java.lang.String getName(int index) {
      return name_.get(index);
    }
    /**
     * <code>repeated string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes(int index) {
      return name_.getByteString(index);
    }

    // repeated int32 id = 2;
    public static final int ID_FIELD_NUMBER = 2;
    private java.util.List<java.lang.Integer> id_;
    /**
     * <code>repeated int32 id = 2;</code>
     *
     * <pre>
     * Unique ID number for this person.
     * </pre>
     */
    public java.util.List<java.lang.Integer>
        getIdList() {
      return id_;
    }
    /**
     * <code>repeated int32 id = 2;</code>
     *
     * <pre>
     * Unique ID number for this person.
     * </pre>
     */
    public int getIdCount() {
      return id_.size();
    }
    /**
     * <code>repeated int32 id = 2;</code>
     *
     * <pre>
     * Unique ID number for this person.
     * </pre>
     */
    public int getId(int index) {
      return id_.get(index);
    }

    // repeated string email = 3;
    public static final int EMAIL_FIELD_NUMBER = 3;
    private com.google.protobuf.LazyStringList email_;
    /**
     * <code>repeated string email = 3;</code>
     */
    public java.util.List<java.lang.String>
        getEmailList() {
      return email_;
    }
    /**
     * <code>repeated string email = 3;</code>
     */
    public int getEmailCount() {
      return email_.size();
    }
    /**
     * <code>repeated string email = 3;</code>
     */
    public java.lang.String getEmail(int index) {
      return email_.get(index);
    }
    /**
     * <code>repeated string email = 3;</code>
     */
    public com.google.protobuf.ByteString
        getEmailBytes(int index) {
      return email_.getByteString(index);
    }

    // repeated double doubleF = 4;
    public static final int DOUBLEF_FIELD_NUMBER = 4;
    private java.util.List<java.lang.Double> doubleF_;
    /**
     * <code>repeated double doubleF = 4;</code>
     */
    public java.util.List<java.lang.Double>
        getDoubleFList() {
      return doubleF_;
    }
    /**
     * <code>repeated double doubleF = 4;</code>
     */
    public int getDoubleFCount() {
      return doubleF_.size();
    }
    /**
     * <code>repeated double doubleF = 4;</code>
     */
    public double getDoubleF(int index) {
      return doubleF_.get(index);
    }

    // repeated float floatF = 5;
    public static final int FLOATF_FIELD_NUMBER = 5;
    private java.util.List<java.lang.Float> floatF_;
    /**
     * <code>repeated float floatF = 5;</code>
     */
    public java.util.List<java.lang.Float>
        getFloatFList() {
      return floatF_;
    }
    /**
     * <code>repeated float floatF = 5;</code>
     */
    public int getFloatFCount() {
      return floatF_.size();
    }
    /**
     * <code>repeated float floatF = 5;</code>
     */
    public float getFloatF(int index) {
      return floatF_.get(index);
    }

    // repeated bytes bytesF = 6;
    public static final int BYTESF_FIELD_NUMBER = 6;
    private java.util.List<com.google.protobuf.ByteString> bytesF_;
    /**
     * <code>repeated bytes bytesF = 6;</code>
     */
    public java.util.List<com.google.protobuf.ByteString>
        getBytesFList() {
      return bytesF_;
    }
    /**
     * <code>repeated bytes bytesF = 6;</code>
     */
    public int getBytesFCount() {
      return bytesF_.size();
    }
    /**
     * <code>repeated bytes bytesF = 6;</code>
     */
    public com.google.protobuf.ByteString getBytesF(int index) {
      return bytesF_.get(index);
    }

    // repeated bool boolF = 7;
    public static final int BOOLF_FIELD_NUMBER = 7;
    private java.util.List<java.lang.Boolean> boolF_;
    /**
     * <code>repeated bool boolF = 7;</code>
     */
    public java.util.List<java.lang.Boolean>
        getBoolFList() {
      return boolF_;
    }
    /**
     * <code>repeated bool boolF = 7;</code>
     */
    public int getBoolFCount() {
      return boolF_.size();
    }
    /**
     * <code>repeated bool boolF = 7;</code>
     */
    public boolean getBoolF(int index) {
      return boolF_.get(index);
    }

    private void initFields() {
      name_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      id_ = java.util.Collections.emptyList();
      email_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      doubleF_ = java.util.Collections.emptyList();
      floatF_ = java.util.Collections.emptyList();
      bytesF_ = java.util.Collections.emptyList();
      boolF_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < name_.size(); i++) {
        output.writeBytes(1, name_.getByteString(i));
      }
      for (int i = 0; i < id_.size(); i++) {
        output.writeInt32(2, id_.get(i));
      }
      for (int i = 0; i < email_.size(); i++) {
        output.writeBytes(3, email_.getByteString(i));
      }
      for (int i = 0; i < doubleF_.size(); i++) {
        output.writeDouble(4, doubleF_.get(i));
      }
      for (int i = 0; i < floatF_.size(); i++) {
        output.writeFloat(5, floatF_.get(i));
      }
      for (int i = 0; i < bytesF_.size(); i++) {
        output.writeBytes(6, bytesF_.get(i));
      }
      for (int i = 0; i < boolF_.size(); i++) {
        output.writeBool(7, boolF_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      {
        int dataSize = 0;
        for (int i = 0; i < name_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(name_.getByteString(i));
        }
        size += dataSize;
        size += 1 * getNameList().size();
      }
      {
        int dataSize = 0;
        for (int i = 0; i < id_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(id_.get(i));
        }
        size += dataSize;
        size += 1 * getIdList().size();
      }
      {
        int dataSize = 0;
        for (int i = 0; i < email_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(email_.getByteString(i));
        }
        size += dataSize;
        size += 1 * getEmailList().size();
      }
      {
        int dataSize = 0;
        dataSize = 8 * getDoubleFList().size();
        size += dataSize;
        size += 1 * getDoubleFList().size();
      }
      {
        int dataSize = 0;
        dataSize = 4 * getFloatFList().size();
        size += dataSize;
        size += 1 * getFloatFList().size();
      }
      {
        int dataSize = 0;
        for (int i = 0; i < bytesF_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(bytesF_.get(i));
        }
        size += dataSize;
        size += 1 * getBytesFList().size();
      }
      {
        int dataSize = 0;
        dataSize = 1 * getBoolFList().size();
        size += dataSize;
        size += 1 * getBoolFList().size();
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person prototype) {
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
     * Protobuf type {@code tutorial.Person}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.internal_static_tutorial_Person_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.internal_static_tutorial_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.class, com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.newBuilder()
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
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        name_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        email_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
        doubleF_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        floatF_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        bytesF_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000020);
        boolF_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000040);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.internal_static_tutorial_Person_descriptor;
      }

      public com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.getDefaultInstance();
      }

      public com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person build() {
        com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person buildPartial() {
        com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person result = new com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          name_ = new com.google.protobuf.UnmodifiableLazyStringList(
              name_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.name_ = name_;
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          id_ = java.util.Collections.unmodifiableList(id_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.id_ = id_;
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          email_ = new com.google.protobuf.UnmodifiableLazyStringList(
              email_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.email_ = email_;
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          doubleF_ = java.util.Collections.unmodifiableList(doubleF_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.doubleF_ = doubleF_;
        if (((bitField0_ & 0x00000010) == 0x00000010)) {
          floatF_ = java.util.Collections.unmodifiableList(floatF_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.floatF_ = floatF_;
        if (((bitField0_ & 0x00000020) == 0x00000020)) {
          bytesF_ = java.util.Collections.unmodifiableList(bytesF_);
          bitField0_ = (bitField0_ & ~0x00000020);
        }
        result.bytesF_ = bytesF_;
        if (((bitField0_ & 0x00000040) == 0x00000040)) {
          boolF_ = java.util.Collections.unmodifiableList(boolF_);
          bitField0_ = (bitField0_ & ~0x00000040);
        }
        result.boolF_ = boolF_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person other) {
        if (other == com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person.getDefaultInstance()) return this;
        if (!other.name_.isEmpty()) {
          if (name_.isEmpty()) {
            name_ = other.name_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureNameIsMutable();
            name_.addAll(other.name_);
          }
          onChanged();
        }
        if (!other.id_.isEmpty()) {
          if (id_.isEmpty()) {
            id_ = other.id_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureIdIsMutable();
            id_.addAll(other.id_);
          }
          onChanged();
        }
        if (!other.email_.isEmpty()) {
          if (email_.isEmpty()) {
            email_ = other.email_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureEmailIsMutable();
            email_.addAll(other.email_);
          }
          onChanged();
        }
        if (!other.doubleF_.isEmpty()) {
          if (doubleF_.isEmpty()) {
            doubleF_ = other.doubleF_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensureDoubleFIsMutable();
            doubleF_.addAll(other.doubleF_);
          }
          onChanged();
        }
        if (!other.floatF_.isEmpty()) {
          if (floatF_.isEmpty()) {
            floatF_ = other.floatF_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureFloatFIsMutable();
            floatF_.addAll(other.floatF_);
          }
          onChanged();
        }
        if (!other.bytesF_.isEmpty()) {
          if (bytesF_.isEmpty()) {
            bytesF_ = other.bytesF_;
            bitField0_ = (bitField0_ & ~0x00000020);
          } else {
            ensureBytesFIsMutable();
            bytesF_.addAll(other.bytesF_);
          }
          onChanged();
        }
        if (!other.boolF_.isEmpty()) {
          if (boolF_.isEmpty()) {
            boolF_ = other.boolF_;
            bitField0_ = (bitField0_ & ~0x00000040);
          } else {
            ensureBoolFIsMutable();
            boolF_.addAll(other.boolF_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.packed.PackedProtosV2.Person) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // repeated string name = 1;
      private com.google.protobuf.LazyStringList name_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureNameIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          name_ = new com.google.protobuf.LazyStringArrayList(name_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public java.util.List<java.lang.String>
          getNameList() {
        return java.util.Collections.unmodifiableList(name_);
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public int getNameCount() {
        return name_.size();
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public java.lang.String getName(int index) {
        return name_.get(index);
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes(int index) {
        return name_.getByteString(index);
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public Builder setName(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureNameIsMutable();
        name_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public Builder addName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureNameIsMutable();
        name_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public Builder addAllName(
          java.lang.Iterable<java.lang.String> values) {
        ensureNameIsMutable();
        super.addAll(values, name_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public Builder clearName() {
        name_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string name = 1;</code>
       */
      public Builder addNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureNameIsMutable();
        name_.add(value);
        onChanged();
        return this;
      }

      // repeated int32 id = 2;
      private java.util.List<java.lang.Integer> id_ = java.util.Collections.emptyList();
      private void ensureIdIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          id_ = new java.util.ArrayList<java.lang.Integer>(id_);
          bitField0_ |= 0x00000002;
         }
      }
      /**
       * <code>repeated int32 id = 2;</code>
       *
       * <pre>
       * Unique ID number for this person.
       * </pre>
       */
      public java.util.List<java.lang.Integer>
          getIdList() {
        return java.util.Collections.unmodifiableList(id_);
      }
      /**
       * <code>repeated int32 id = 2;</code>
       *
       * <pre>
       * Unique ID number for this person.
       * </pre>
       */
      public int getIdCount() {
        return id_.size();
      }
      /**
       * <code>repeated int32 id = 2;</code>
       *
       * <pre>
       * Unique ID number for this person.
       * </pre>
       */
      public int getId(int index) {
        return id_.get(index);
      }
      /**
       * <code>repeated int32 id = 2;</code>
       *
       * <pre>
       * Unique ID number for this person.
       * </pre>
       */
      public Builder setId(
          int index, int value) {
        ensureIdIsMutable();
        id_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 id = 2;</code>
       *
       * <pre>
       * Unique ID number for this person.
       * </pre>
       */
      public Builder addId(int value) {
        ensureIdIsMutable();
        id_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 id = 2;</code>
       *
       * <pre>
       * Unique ID number for this person.
       * </pre>
       */
      public Builder addAllId(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureIdIsMutable();
        super.addAll(values, id_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 id = 2;</code>
       *
       * <pre>
       * Unique ID number for this person.
       * </pre>
       */
      public Builder clearId() {
        id_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }

      // repeated string email = 3;
      private com.google.protobuf.LazyStringList email_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureEmailIsMutable() {
        if (!((bitField0_ & 0x00000004) == 0x00000004)) {
          email_ = new com.google.protobuf.LazyStringArrayList(email_);
          bitField0_ |= 0x00000004;
         }
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public java.util.List<java.lang.String>
          getEmailList() {
        return java.util.Collections.unmodifiableList(email_);
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public int getEmailCount() {
        return email_.size();
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public java.lang.String getEmail(int index) {
        return email_.get(index);
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public com.google.protobuf.ByteString
          getEmailBytes(int index) {
        return email_.getByteString(index);
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public Builder setEmail(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureEmailIsMutable();
        email_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public Builder addEmail(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureEmailIsMutable();
        email_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public Builder addAllEmail(
          java.lang.Iterable<java.lang.String> values) {
        ensureEmailIsMutable();
        super.addAll(values, email_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public Builder clearEmail() {
        email_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string email = 3;</code>
       */
      public Builder addEmailBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureEmailIsMutable();
        email_.add(value);
        onChanged();
        return this;
      }

      // repeated double doubleF = 4;
      private java.util.List<java.lang.Double> doubleF_ = java.util.Collections.emptyList();
      private void ensureDoubleFIsMutable() {
        if (!((bitField0_ & 0x00000008) == 0x00000008)) {
          doubleF_ = new java.util.ArrayList<java.lang.Double>(doubleF_);
          bitField0_ |= 0x00000008;
         }
      }
      /**
       * <code>repeated double doubleF = 4;</code>
       */
      public java.util.List<java.lang.Double>
          getDoubleFList() {
        return java.util.Collections.unmodifiableList(doubleF_);
      }
      /**
       * <code>repeated double doubleF = 4;</code>
       */
      public int getDoubleFCount() {
        return doubleF_.size();
      }
      /**
       * <code>repeated double doubleF = 4;</code>
       */
      public double getDoubleF(int index) {
        return doubleF_.get(index);
      }
      /**
       * <code>repeated double doubleF = 4;</code>
       */
      public Builder setDoubleF(
          int index, double value) {
        ensureDoubleFIsMutable();
        doubleF_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double doubleF = 4;</code>
       */
      public Builder addDoubleF(double value) {
        ensureDoubleFIsMutable();
        doubleF_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double doubleF = 4;</code>
       */
      public Builder addAllDoubleF(
          java.lang.Iterable<? extends java.lang.Double> values) {
        ensureDoubleFIsMutable();
        super.addAll(values, doubleF_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated double doubleF = 4;</code>
       */
      public Builder clearDoubleF() {
        doubleF_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
        return this;
      }

      // repeated float floatF = 5;
      private java.util.List<java.lang.Float> floatF_ = java.util.Collections.emptyList();
      private void ensureFloatFIsMutable() {
        if (!((bitField0_ & 0x00000010) == 0x00000010)) {
          floatF_ = new java.util.ArrayList<java.lang.Float>(floatF_);
          bitField0_ |= 0x00000010;
         }
      }
      /**
       * <code>repeated float floatF = 5;</code>
       */
      public java.util.List<java.lang.Float>
          getFloatFList() {
        return java.util.Collections.unmodifiableList(floatF_);
      }
      /**
       * <code>repeated float floatF = 5;</code>
       */
      public int getFloatFCount() {
        return floatF_.size();
      }
      /**
       * <code>repeated float floatF = 5;</code>
       */
      public float getFloatF(int index) {
        return floatF_.get(index);
      }
      /**
       * <code>repeated float floatF = 5;</code>
       */
      public Builder setFloatF(
          int index, float value) {
        ensureFloatFIsMutable();
        floatF_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float floatF = 5;</code>
       */
      public Builder addFloatF(float value) {
        ensureFloatFIsMutable();
        floatF_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float floatF = 5;</code>
       */
      public Builder addAllFloatF(
          java.lang.Iterable<? extends java.lang.Float> values) {
        ensureFloatFIsMutable();
        super.addAll(values, floatF_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated float floatF = 5;</code>
       */
      public Builder clearFloatF() {
        floatF_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
        return this;
      }

      // repeated bytes bytesF = 6;
      private java.util.List<com.google.protobuf.ByteString> bytesF_ = java.util.Collections.emptyList();
      private void ensureBytesFIsMutable() {
        if (!((bitField0_ & 0x00000020) == 0x00000020)) {
          bytesF_ = new java.util.ArrayList<com.google.protobuf.ByteString>(bytesF_);
          bitField0_ |= 0x00000020;
         }
      }
      /**
       * <code>repeated bytes bytesF = 6;</code>
       */
      public java.util.List<com.google.protobuf.ByteString>
          getBytesFList() {
        return java.util.Collections.unmodifiableList(bytesF_);
      }
      /**
       * <code>repeated bytes bytesF = 6;</code>
       */
      public int getBytesFCount() {
        return bytesF_.size();
      }
      /**
       * <code>repeated bytes bytesF = 6;</code>
       */
      public com.google.protobuf.ByteString getBytesF(int index) {
        return bytesF_.get(index);
      }
      /**
       * <code>repeated bytes bytesF = 6;</code>
       */
      public Builder setBytesF(
          int index, com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureBytesFIsMutable();
        bytesF_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes bytesF = 6;</code>
       */
      public Builder addBytesF(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureBytesFIsMutable();
        bytesF_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes bytesF = 6;</code>
       */
      public Builder addAllBytesF(
          java.lang.Iterable<? extends com.google.protobuf.ByteString> values) {
        ensureBytesFIsMutable();
        super.addAll(values, bytesF_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bytes bytesF = 6;</code>
       */
      public Builder clearBytesF() {
        bytesF_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000020);
        onChanged();
        return this;
      }

      // repeated bool boolF = 7;
      private java.util.List<java.lang.Boolean> boolF_ = java.util.Collections.emptyList();
      private void ensureBoolFIsMutable() {
        if (!((bitField0_ & 0x00000040) == 0x00000040)) {
          boolF_ = new java.util.ArrayList<java.lang.Boolean>(boolF_);
          bitField0_ |= 0x00000040;
         }
      }
      /**
       * <code>repeated bool boolF = 7;</code>
       */
      public java.util.List<java.lang.Boolean>
          getBoolFList() {
        return java.util.Collections.unmodifiableList(boolF_);
      }
      /**
       * <code>repeated bool boolF = 7;</code>
       */
      public int getBoolFCount() {
        return boolF_.size();
      }
      /**
       * <code>repeated bool boolF = 7;</code>
       */
      public boolean getBoolF(int index) {
        return boolF_.get(index);
      }
      /**
       * <code>repeated bool boolF = 7;</code>
       */
      public Builder setBoolF(
          int index, boolean value) {
        ensureBoolFIsMutable();
        boolF_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bool boolF = 7;</code>
       */
      public Builder addBoolF(boolean value) {
        ensureBoolFIsMutable();
        boolF_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bool boolF = 7;</code>
       */
      public Builder addAllBoolF(
          java.lang.Iterable<? extends java.lang.Boolean> values) {
        ensureBoolFIsMutable();
        super.addAll(values, boolF_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated bool boolF = 7;</code>
       */
      public Builder clearBoolF() {
        boolF_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000040);
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:tutorial.Person)
    }

    static {
      defaultInstance = new Person(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:tutorial.Person)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Person_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_tutorial_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014packed.proto\022\010tutorial\"q\n\006Person\022\014\n\004na" +
      "me\030\001 \003(\t\022\n\n\002id\030\002 \003(\005\022\r\n\005email\030\003 \003(\t\022\017\n\007d" +
      "oubleF\030\004 \003(\001\022\016\n\006floatF\030\005 \003(\002\022\016\n\006bytesF\030\006" +
      " \003(\014\022\r\n\005boolF\030\007 \003(\010B8\n&com.baidu.bjf.rem" +
      "oting.protobuf.packedB\016PackedProtosV2"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_tutorial_Person_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_tutorial_Person_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_tutorial_Person_descriptor,
              new java.lang.String[] { "Name", "Id", "Email", "DoubleF", "FloatF", "BytesF", "BoolF", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
