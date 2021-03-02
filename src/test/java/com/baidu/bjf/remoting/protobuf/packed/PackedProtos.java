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
// source: packedv3.proto

package com.baidu.bjf.remoting.protobuf.packed;

public final class PackedProtos {
  private PackedProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PersonOrBuilder extends
      // @@protoc_insertion_point(interface_extends:tutorial.Person)
      com.google.protobuf.MessageOrBuilder {

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

    /**
     * <pre>
     * Unique ID number for this person.
     * </pre>
     *
     * <code>repeated int32 id = 2;</code>
     */
    java.util.List<java.lang.Integer> getIdList();
    /**
     * <pre>
     * Unique ID number for this person.
     * </pre>
     *
     * <code>repeated int32 id = 2;</code>
     */
    int getIdCount();
    /**
     * <pre>
     * Unique ID number for this person.
     * </pre>
     *
     * <code>repeated int32 id = 2;</code>
     */
    int getId(int index);

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
  public  static final class Person extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:tutorial.Person)
      PersonOrBuilder {
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Person() {
      name_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      id_ = java.util.Collections.emptyList();
      email_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      doubleF_ = java.util.Collections.emptyList();
      floatF_ = java.util.Collections.emptyList();
      bytesF_ = java.util.Collections.emptyList();
      boolF_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Person(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                name_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000001;
              }
              name_.add(s);
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
              java.lang.String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                email_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000004;
              }
              email_.add(s);
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
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          name_ = name_.getUnmodifiableView();
        }
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          id_ = java.util.Collections.unmodifiableList(id_);
        }
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          email_ = email_.getUnmodifiableView();
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
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.packed.PackedProtos.internal_static_tutorial_Person_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.packed.PackedProtos.internal_static_tutorial_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person.class, com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person.Builder.class);
    }

    public static final int NAME_FIELD_NUMBER = 1;
    private com.google.protobuf.LazyStringList name_;
    /**
     * <code>repeated string name = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
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

    public static final int ID_FIELD_NUMBER = 2;
    private java.util.List<java.lang.Integer> id_;
    /**
     * <pre>
     * Unique ID number for this person.
     * </pre>
     *
     * <code>repeated int32 id = 2;</code>
     */
    public java.util.List<java.lang.Integer>
        getIdList() {
      return id_;
    }
    /**
     * <pre>
     * Unique ID number for this person.
     * </pre>
     *
     * <code>repeated int32 id = 2;</code>
     */
    public int getIdCount() {
      return id_.size();
    }
    /**
     * <pre>
     * Unique ID number for this person.
     * </pre>
     *
     * <code>repeated int32 id = 2;</code>
     */
    public int getId(int index) {
      return id_.get(index);
    }
    private int idMemoizedSerializedSize = -1;

    public static final int EMAIL_FIELD_NUMBER = 3;
    private com.google.protobuf.LazyStringList email_;
    /**
     * <code>repeated string email = 3;</code>
     */
    public com.google.protobuf.ProtocolStringList
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
    private int doubleFMemoizedSerializedSize = -1;

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
    private int floatFMemoizedSerializedSize = -1;

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
    private int boolFMemoizedSerializedSize = -1;

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < name_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_.getRaw(i));
      }
      if (getIdList().size() > 0) {
        output.writeUInt32NoTag(18);
        output.writeUInt32NoTag(idMemoizedSerializedSize);
      }
      for (int i = 0; i < id_.size(); i++) {
        output.writeInt32NoTag(id_.get(i));
      }
      for (int i = 0; i < email_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, email_.getRaw(i));
      }
      if (getDoubleFList().size() > 0) {
        output.writeUInt32NoTag(34);
        output.writeUInt32NoTag(doubleFMemoizedSerializedSize);
      }
      for (int i = 0; i < doubleF_.size(); i++) {
        output.writeDoubleNoTag(doubleF_.get(i));
      }
      if (getFloatFList().size() > 0) {
        output.writeUInt32NoTag(42);
        output.writeUInt32NoTag(floatFMemoizedSerializedSize);
      }
      for (int i = 0; i < floatF_.size(); i++) {
        output.writeFloatNoTag(floatF_.get(i));
      }
      for (int i = 0; i < bytesF_.size(); i++) {
        output.writeBytes(6, bytesF_.get(i));
      }
      if (getBoolFList().size() > 0) {
        output.writeUInt32NoTag(58);
        output.writeUInt32NoTag(boolFMemoizedSerializedSize);
      }
      for (int i = 0; i < boolF_.size(); i++) {
        output.writeBoolNoTag(boolF_.get(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      {
        int dataSize = 0;
        for (int i = 0; i < name_.size(); i++) {
          dataSize += computeStringSizeNoTag(name_.getRaw(i));
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
        if (!getIdList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        idMemoizedSerializedSize = dataSize;
      }
      {
        int dataSize = 0;
        for (int i = 0; i < email_.size(); i++) {
          dataSize += computeStringSizeNoTag(email_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getEmailList().size();
      }
      {
        int dataSize = 0;
        dataSize = 8 * getDoubleFList().size();
        size += dataSize;
        if (!getDoubleFList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        doubleFMemoizedSerializedSize = dataSize;
      }
      {
        int dataSize = 0;
        dataSize = 4 * getFloatFList().size();
        size += dataSize;
        if (!getFloatFList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        floatFMemoizedSerializedSize = dataSize;
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
        if (!getBoolFList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        boolFMemoizedSerializedSize = dataSize;
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person)) {
        return super.equals(obj);
      }
      com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person other = (com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person) obj;

      boolean result = true;
      result = result && getNameList()
          .equals(other.getNameList());
      result = result && getIdList()
          .equals(other.getIdList());
      result = result && getEmailList()
          .equals(other.getEmailList());
      result = result && getDoubleFList()
          .equals(other.getDoubleFList());
      result = result && getFloatFList()
          .equals(other.getFloatFList());
      result = result && getBytesFList()
          .equals(other.getBytesFList());
      result = result && getBoolFList()
          .equals(other.getBoolFList());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (getNameCount() > 0) {
        hash = (37 * hash) + NAME_FIELD_NUMBER;
        hash = (53 * hash) + getNameList().hashCode();
      }
      if (getIdCount() > 0) {
        hash = (37 * hash) + ID_FIELD_NUMBER;
        hash = (53 * hash) + getIdList().hashCode();
      }
      if (getEmailCount() > 0) {
        hash = (37 * hash) + EMAIL_FIELD_NUMBER;
        hash = (53 * hash) + getEmailList().hashCode();
      }
      if (getDoubleFCount() > 0) {
        hash = (37 * hash) + DOUBLEF_FIELD_NUMBER;
        hash = (53 * hash) + getDoubleFList().hashCode();
      }
      if (getFloatFCount() > 0) {
        hash = (37 * hash) + FLOATF_FIELD_NUMBER;
        hash = (53 * hash) + getFloatFList().hashCode();
      }
      if (getBytesFCount() > 0) {
        hash = (37 * hash) + BYTESF_FIELD_NUMBER;
        hash = (53 * hash) + getBytesFList().hashCode();
      }
      if (getBoolFCount() > 0) {
        hash = (37 * hash) + BOOLF_FIELD_NUMBER;
        hash = (53 * hash) + getBoolFList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code tutorial.Person}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:tutorial.Person)
        com.baidu.bjf.remoting.protobuf.packed.PackedProtos.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.packed.PackedProtos.internal_static_tutorial_Person_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.packed.PackedProtos.internal_static_tutorial_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person.class, com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
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

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.packed.PackedProtos.internal_static_tutorial_Person_descriptor;
      }

      public com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person.getDefaultInstance();
      }

      public com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person build() {
        com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person buildPartial() {
        com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person result = new com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          name_ = name_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.name_ = name_;
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          id_ = java.util.Collections.unmodifiableList(id_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.id_ = id_;
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          email_ = email_.getUnmodifiableView();
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

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person other) {
        if (other == com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person.getDefaultInstance()) return this;
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
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

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
      public com.google.protobuf.ProtocolStringList
          getNameList() {
        return name_.getUnmodifiableView();
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
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, name_);
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
  checkByteStringIsUtf8(value);
        ensureNameIsMutable();
        name_.add(value);
        onChanged();
        return this;
      }

      private java.util.List<java.lang.Integer> id_ = java.util.Collections.emptyList();
      private void ensureIdIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          id_ = new java.util.ArrayList<java.lang.Integer>(id_);
          bitField0_ |= 0x00000002;
         }
      }
      /**
       * <pre>
       * Unique ID number for this person.
       * </pre>
       *
       * <code>repeated int32 id = 2;</code>
       */
      public java.util.List<java.lang.Integer>
          getIdList() {
        return java.util.Collections.unmodifiableList(id_);
      }
      /**
       * <pre>
       * Unique ID number for this person.
       * </pre>
       *
       * <code>repeated int32 id = 2;</code>
       */
      public int getIdCount() {
        return id_.size();
      }
      /**
       * <pre>
       * Unique ID number for this person.
       * </pre>
       *
       * <code>repeated int32 id = 2;</code>
       */
      public int getId(int index) {
        return id_.get(index);
      }
      /**
       * <pre>
       * Unique ID number for this person.
       * </pre>
       *
       * <code>repeated int32 id = 2;</code>
       */
      public Builder setId(
          int index, int value) {
        ensureIdIsMutable();
        id_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Unique ID number for this person.
       * </pre>
       *
       * <code>repeated int32 id = 2;</code>
       */
      public Builder addId(int value) {
        ensureIdIsMutable();
        id_.add(value);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Unique ID number for this person.
       * </pre>
       *
       * <code>repeated int32 id = 2;</code>
       */
      public Builder addAllId(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureIdIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, id_);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Unique ID number for this person.
       * </pre>
       *
       * <code>repeated int32 id = 2;</code>
       */
      public Builder clearId() {
        id_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }

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
      public com.google.protobuf.ProtocolStringList
          getEmailList() {
        return email_.getUnmodifiableView();
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
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, email_);
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
  checkByteStringIsUtf8(value);
        ensureEmailIsMutable();
        email_.add(value);
        onChanged();
        return this;
      }

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
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, doubleF_);
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
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, floatF_);
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
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, bytesF_);
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
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, boolF_);
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
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:tutorial.Person)
    }

    // @@protoc_insertion_point(class_scope:tutorial.Person)
    private static final com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person();
    }

    public static com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Person>
        PARSER = new com.google.protobuf.AbstractParser<Person>() {
      public Person parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Person(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Person> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Person> getParserForType() {
      return PARSER;
    }

    public com.baidu.bjf.remoting.protobuf.packed.PackedProtos.Person getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Person_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016packedv3.proto\022\010tutorial\"q\n\006Person\022\014\n\004" +
      "name\030\001 \003(\t\022\n\n\002id\030\002 \003(\005\022\r\n\005email\030\003 \003(\t\022\017\n" +
      "\007doubleF\030\004 \003(\001\022\016\n\006floatF\030\005 \003(\002\022\016\n\006bytesF" +
      "\030\006 \003(\014\022\r\n\005boolF\030\007 \003(\010B6\n&com.baidu.bjf.r" +
      "emoting.protobuf.packedB\014PackedProtosb\006p" +
      "roto3"
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
    internal_static_tutorial_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Person_descriptor,
        new java.lang.String[] { "Name", "Id", "Email", "DoubleF", "FloatF", "BytesF", "BoolF", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
