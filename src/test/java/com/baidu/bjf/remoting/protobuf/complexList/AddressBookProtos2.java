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
// source: address.proto

package com.baidu.bjf.remoting.protobuf.complexList;

public final class AddressBookProtos2 {
  private AddressBookProtos2() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum}
   */
  public enum TypeDefEnum
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>NULL = 0;</code>
     */
    NULL(0),
    /**
     * <code>TEXT = 1;</code>
     */
    TEXT(1),
    /**
     * <code>NUMBER = 2;</code>
     */
    NUMBER(2),
    /**
     * <code>DECIMAL = 4;</code>
     */
    DECIMAL(4),
    /**
     * <code>ID = 8;</code>
     */
    ID(8),
    /**
     * <code>URL = 16;</code>
     */
    URL(16),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>NULL = 0;</code>
     */
    public static final int NULL_VALUE = 0;
    /**
     * <code>TEXT = 1;</code>
     */
    public static final int TEXT_VALUE = 1;
    /**
     * <code>NUMBER = 2;</code>
     */
    public static final int NUMBER_VALUE = 2;
    /**
     * <code>DECIMAL = 4;</code>
     */
    public static final int DECIMAL_VALUE = 4;
    /**
     * <code>ID = 8;</code>
     */
    public static final int ID_VALUE = 8;
    /**
     * <code>URL = 16;</code>
     */
    public static final int URL_VALUE = 16;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static TypeDefEnum valueOf(int value) {
      return forNumber(value);
    }

    public static TypeDefEnum forNumber(int value) {
      switch (value) {
        case 0: return NULL;
        case 1: return TEXT;
        case 2: return NUMBER;
        case 4: return DECIMAL;
        case 8: return ID;
        case 16: return URL;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<TypeDefEnum>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        TypeDefEnum> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<TypeDefEnum>() {
            public TypeDefEnum findValueByNumber(int number) {
              return TypeDefEnum.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.getDescriptor().getEnumTypes().get(0);
    }

    private static final TypeDefEnum[] VALUES = values();

    public static TypeDefEnum valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private TypeDefEnum(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum)
  }

  public interface AddressBookProtosPOJOOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO> 
        getListList();
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO getList(int index);
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    int getListCount();
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    java.util.List<? extends com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder> 
        getListOrBuilderList();
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder getListOrBuilder(
        int index);

    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum> getTypeListList();
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    int getTypeListCount();
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum getTypeList(int index);
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    java.util.List<java.lang.Integer>
    getTypeListValueList();
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    int getTypeListValue(int index);
  }
  /**
   * Protobuf type {@code com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO}
   */
  public  static final class AddressBookProtosPOJO extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO)
      AddressBookProtosPOJOOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AddressBookProtosPOJO.newBuilder() to construct.
    private AddressBookProtosPOJO(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AddressBookProtosPOJO() {
      list_ = java.util.Collections.emptyList();
      typeList_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AddressBookProtosPOJO(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                list_ = new java.util.ArrayList<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO>();
                mutable_bitField0_ |= 0x00000001;
              }
              list_.add(
                  input.readMessage(com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.parser(), extensionRegistry));
              break;
            }
            case 16: {
              int rawValue = input.readEnum();
              if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                typeList_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000002;
              }
              typeList_.add(rawValue);
              break;
            }
            case 18: {
              int length = input.readRawVarint32();
              int oldLimit = input.pushLimit(length);
              while(input.getBytesUntilLimit() > 0) {
                int rawValue = input.readEnum();
                if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                  typeList_ = new java.util.ArrayList<java.lang.Integer>();
                  mutable_bitField0_ |= 0x00000002;
                }
                typeList_.add(rawValue);
              }
              input.popLimit(oldLimit);
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
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
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          list_ = java.util.Collections.unmodifiableList(list_);
        }
        if (((mutable_bitField0_ & 0x00000002) != 0)) {
          typeList_ = java.util.Collections.unmodifiableList(typeList_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO.class, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO.Builder.class);
    }

    public static final int LIST_FIELD_NUMBER = 1;
    private java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO> list_;
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    public java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO> getListList() {
      return list_;
    }
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    public java.util.List<? extends com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder> 
        getListOrBuilderList() {
      return list_;
    }
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    public int getListCount() {
      return list_.size();
    }
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO getList(int index) {
      return list_.get(index);
    }
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
     */
    public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder getListOrBuilder(
        int index) {
      return list_.get(index);
    }

    public static final int TYPELIST_FIELD_NUMBER = 2;
    private java.util.List<java.lang.Integer> typeList_;
    private static final com.google.protobuf.Internal.ListAdapter.Converter<
        java.lang.Integer, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum> typeList_converter_ =
            new com.google.protobuf.Internal.ListAdapter.Converter<
                java.lang.Integer, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum>() {
              public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum convert(java.lang.Integer from) {
                @SuppressWarnings("deprecation")
                com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum result = com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum.valueOf(from);
                return result == null ? com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum.UNRECOGNIZED : result;
              }
            };
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    public java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum> getTypeListList() {
      return new com.google.protobuf.Internal.ListAdapter<
          java.lang.Integer, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum>(typeList_, typeList_converter_);
    }
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    public int getTypeListCount() {
      return typeList_.size();
    }
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum getTypeList(int index) {
      return typeList_converter_.convert(typeList_.get(index));
    }
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    public java.util.List<java.lang.Integer>
    getTypeListValueList() {
      return typeList_;
    }
    /**
     * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
     */
    public int getTypeListValue(int index) {
      return typeList_.get(index);
    }
    private int typeListMemoizedSerializedSize;

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < list_.size(); i++) {
        output.writeMessage(1, list_.get(i));
      }
      if (getTypeListList().size() > 0) {
        output.writeUInt32NoTag(18);
        output.writeUInt32NoTag(typeListMemoizedSerializedSize);
      }
      for (int i = 0; i < typeList_.size(); i++) {
        output.writeEnumNoTag(typeList_.get(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < list_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, list_.get(i));
      }
      {
        int dataSize = 0;
        for (int i = 0; i < typeList_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeEnumSizeNoTag(typeList_.get(i));
        }
        size += dataSize;
        if (!getTypeListList().isEmpty()) {  size += 1;
          size += com.google.protobuf.CodedOutputStream
            .computeUInt32SizeNoTag(dataSize);
        }typeListMemoizedSerializedSize = dataSize;
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO)) {
        return super.equals(obj);
      }
      com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO other = (com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO) obj;

      if (!getListList()
          .equals(other.getListList())) return false;
      if (!typeList_.equals(other.typeList_)) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (getListCount() > 0) {
        hash = (37 * hash) + LIST_FIELD_NUMBER;
        hash = (53 * hash) + getListList().hashCode();
      }
      if (getTypeListCount() > 0) {
        hash = (37 * hash) + TYPELIST_FIELD_NUMBER;
        hash = (53 * hash) + typeList_.hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     * Protobuf type {@code com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO)
        com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJOOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO.class, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO.newBuilder()
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
          getListFieldBuilder();
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (listBuilder_ == null) {
          list_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          listBuilder_.clear();
        }
        typeList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_descriptor;
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO.getDefaultInstance();
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO build() {
        com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO buildPartial() {
        com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO result = new com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO(this);
        int from_bitField0_ = bitField0_;
        if (listBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            list_ = java.util.Collections.unmodifiableList(list_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.list_ = list_;
        } else {
          result.list_ = listBuilder_.build();
        }
        if (((bitField0_ & 0x00000002) != 0)) {
          typeList_ = java.util.Collections.unmodifiableList(typeList_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.typeList_ = typeList_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO other) {
        if (other == com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO.getDefaultInstance()) return this;
        if (listBuilder_ == null) {
          if (!other.list_.isEmpty()) {
            if (list_.isEmpty()) {
              list_ = other.list_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureListIsMutable();
              list_.addAll(other.list_);
            }
            onChanged();
          }
        } else {
          if (!other.list_.isEmpty()) {
            if (listBuilder_.isEmpty()) {
              listBuilder_.dispose();
              listBuilder_ = null;
              list_ = other.list_;
              bitField0_ = (bitField0_ & ~0x00000001);
              listBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getListFieldBuilder() : null;
            } else {
              listBuilder_.addAllMessages(other.list_);
            }
          }
        }
        if (!other.typeList_.isEmpty()) {
          if (typeList_.isEmpty()) {
            typeList_ = other.typeList_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureTypeListIsMutable();
            typeList_.addAll(other.typeList_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO> list_ =
        java.util.Collections.emptyList();
      private void ensureListIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          list_ = new java.util.ArrayList<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO>(list_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder> listBuilder_;

      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO> getListList() {
        if (listBuilder_ == null) {
          return java.util.Collections.unmodifiableList(list_);
        } else {
          return listBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public int getListCount() {
        if (listBuilder_ == null) {
          return list_.size();
        } else {
          return listBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO getList(int index) {
        if (listBuilder_ == null) {
          return list_.get(index);
        } else {
          return listBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder setList(
          int index, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO value) {
        if (listBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureListIsMutable();
          list_.set(index, value);
          onChanged();
        } else {
          listBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder setList(
          int index, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder builderForValue) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          list_.set(index, builderForValue.build());
          onChanged();
        } else {
          listBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder addList(com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO value) {
        if (listBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureListIsMutable();
          list_.add(value);
          onChanged();
        } else {
          listBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder addList(
          int index, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO value) {
        if (listBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureListIsMutable();
          list_.add(index, value);
          onChanged();
        } else {
          listBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder addList(
          com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder builderForValue) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          list_.add(builderForValue.build());
          onChanged();
        } else {
          listBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder addList(
          int index, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder builderForValue) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          list_.add(index, builderForValue.build());
          onChanged();
        } else {
          listBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder addAllList(
          java.lang.Iterable<? extends com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO> values) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, list_);
          onChanged();
        } else {
          listBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder clearList() {
        if (listBuilder_ == null) {
          list_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          listBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public Builder removeList(int index) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          list_.remove(index);
          onChanged();
        } else {
          listBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder getListBuilder(
          int index) {
        return getListFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder getListOrBuilder(
          int index) {
        if (listBuilder_ == null) {
          return list_.get(index);  } else {
          return listBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public java.util.List<? extends com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder> 
           getListOrBuilderList() {
        if (listBuilder_ != null) {
          return listBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(list_);
        }
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder addListBuilder() {
        return getListFieldBuilder().addBuilder(
            com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.getDefaultInstance());
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder addListBuilder(
          int index) {
        return getListFieldBuilder().addBuilder(
            index, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.getDefaultInstance());
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO list = 1;</code>
       */
      public java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder> 
           getListBuilderList() {
        return getListFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder> 
          getListFieldBuilder() {
        if (listBuilder_ == null) {
          listBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder>(
                  list_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          list_ = null;
        }
        return listBuilder_;
      }

      private java.util.List<java.lang.Integer> typeList_ =
        java.util.Collections.emptyList();
      private void ensureTypeListIsMutable() {
        if (!((bitField0_ & 0x00000002) != 0)) {
          typeList_ = new java.util.ArrayList<java.lang.Integer>(typeList_);
          bitField0_ |= 0x00000002;
        }
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public java.util.List<com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum> getTypeListList() {
        return new com.google.protobuf.Internal.ListAdapter<
            java.lang.Integer, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum>(typeList_, typeList_converter_);
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public int getTypeListCount() {
        return typeList_.size();
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum getTypeList(int index) {
        return typeList_converter_.convert(typeList_.get(index));
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public Builder setTypeList(
          int index, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTypeListIsMutable();
        typeList_.set(index, value.getNumber());
        onChanged();
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public Builder addTypeList(com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum value) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTypeListIsMutable();
        typeList_.add(value.getNumber());
        onChanged();
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public Builder addAllTypeList(
          java.lang.Iterable<? extends com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum> values) {
        ensureTypeListIsMutable();
        for (com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.TypeDefEnum value : values) {
          typeList_.add(value.getNumber());
        }
        onChanged();
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public Builder clearTypeList() {
        typeList_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public java.util.List<java.lang.Integer>
      getTypeListValueList() {
        return java.util.Collections.unmodifiableList(typeList_);
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public int getTypeListValue(int index) {
        return typeList_.get(index);
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public Builder setTypeListValue(
          int index, int value) {
        ensureTypeListIsMutable();
        typeList_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public Builder addTypeListValue(int value) {
        ensureTypeListIsMutable();
        typeList_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated .com.baidu.bjf.remoting.protobuf.complexList.TypeDefEnum typeList = 2;</code>
       */
      public Builder addAllTypeListValue(
          java.lang.Iterable<java.lang.Integer> values) {
        ensureTypeListIsMutable();
        for (int value : values) {
          typeList_.add(value);
        }
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO)
    }

    // @@protoc_insertion_point(class_scope:com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtosPOJO)
    private static final com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO();
    }

    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AddressBookProtosPOJO>
        PARSER = new com.google.protobuf.AbstractParser<AddressBookProtosPOJO>() {
      @java.lang.Override
      public AddressBookProtosPOJO parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AddressBookProtosPOJO(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AddressBookProtosPOJO> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AddressBookProtosPOJO> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.AddressBookProtosPOJO getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface PersonPOJOOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string name = 1;</code>
     */
    java.lang.String getName();
    /**
     * <code>string name = 1;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>int32 id = 2;</code>
     */
    int getId();

    /**
     * <code>string email = 3;</code>
     */
    java.lang.String getEmail();
    /**
     * <code>string email = 3;</code>
     */
    com.google.protobuf.ByteString
        getEmailBytes();

    /**
     * <code>double doubleF = 4;</code>
     */
    double getDoubleF();

    /**
     * <code>float floatF = 5;</code>
     */
    float getFloatF();

    /**
     * <code>bytes bytesF = 6;</code>
     */
    com.google.protobuf.ByteString getBytesF();

    /**
     * <code>bool boolF = 7;</code>
     */
    boolean getBoolF();
  }
  /**
   * Protobuf type {@code com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO}
   */
  public  static final class PersonPOJO extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO)
      PersonPOJOOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use PersonPOJO.newBuilder() to construct.
    private PersonPOJO(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PersonPOJO() {
      name_ = "";
      email_ = "";
      bytesF_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private PersonPOJO(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 16: {

              id_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              email_ = s;
              break;
            }
            case 33: {

              doubleF_ = input.readDouble();
              break;
            }
            case 45: {

              floatF_ = input.readFloat();
              break;
            }
            case 50: {

              bytesF_ = input.readBytes();
              break;
            }
            case 56: {

              boolF_ = input.readBool();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.class, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder.class);
    }

    public static final int NAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object name_;
    /**
     * <code>string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <code>string name = 1;</code>
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

    public static final int ID_FIELD_NUMBER = 2;
    private int id_;
    /**
     * <code>int32 id = 2;</code>
     */
    public int getId() {
      return id_;
    }

    public static final int EMAIL_FIELD_NUMBER = 3;
    private volatile java.lang.Object email_;
    /**
     * <code>string email = 3;</code>
     */
    public java.lang.String getEmail() {
      java.lang.Object ref = email_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        email_ = s;
        return s;
      }
    }
    /**
     * <code>string email = 3;</code>
     */
    public com.google.protobuf.ByteString
        getEmailBytes() {
      java.lang.Object ref = email_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        email_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DOUBLEF_FIELD_NUMBER = 4;
    private double doubleF_;
    /**
     * <code>double doubleF = 4;</code>
     */
    public double getDoubleF() {
      return doubleF_;
    }

    public static final int FLOATF_FIELD_NUMBER = 5;
    private float floatF_;
    /**
     * <code>float floatF = 5;</code>
     */
    public float getFloatF() {
      return floatF_;
    }

    public static final int BYTESF_FIELD_NUMBER = 6;
    private com.google.protobuf.ByteString bytesF_;
    /**
     * <code>bytes bytesF = 6;</code>
     */
    public com.google.protobuf.ByteString getBytesF() {
      return bytesF_;
    }

    public static final int BOOLF_FIELD_NUMBER = 7;
    private boolean boolF_;
    /**
     * <code>bool boolF = 7;</code>
     */
    public boolean getBoolF() {
      return boolF_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
      }
      if (id_ != 0) {
        output.writeInt32(2, id_);
      }
      if (!getEmailBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, email_);
      }
      if (doubleF_ != 0D) {
        output.writeDouble(4, doubleF_);
      }
      if (floatF_ != 0F) {
        output.writeFloat(5, floatF_);
      }
      if (!bytesF_.isEmpty()) {
        output.writeBytes(6, bytesF_);
      }
      if (boolF_ != false) {
        output.writeBool(7, boolF_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
      }
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, id_);
      }
      if (!getEmailBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, email_);
      }
      if (doubleF_ != 0D) {
        size += com.google.protobuf.CodedOutputStream
          .computeDoubleSize(4, doubleF_);
      }
      if (floatF_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(5, floatF_);
      }
      if (!bytesF_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(6, bytesF_);
      }
      if (boolF_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(7, boolF_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO)) {
        return super.equals(obj);
      }
      com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO other = (com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO) obj;

      if (!getName()
          .equals(other.getName())) return false;
      if (getId()
          != other.getId()) return false;
      if (!getEmail()
          .equals(other.getEmail())) return false;
      if (java.lang.Double.doubleToLongBits(getDoubleF())
          != java.lang.Double.doubleToLongBits(
              other.getDoubleF())) return false;
      if (java.lang.Float.floatToIntBits(getFloatF())
          != java.lang.Float.floatToIntBits(
              other.getFloatF())) return false;
      if (!getBytesF()
          .equals(other.getBytesF())) return false;
      if (getBoolF()
          != other.getBoolF()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      hash = (37 * hash) + EMAIL_FIELD_NUMBER;
      hash = (53 * hash) + getEmail().hashCode();
      hash = (37 * hash) + DOUBLEF_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          java.lang.Double.doubleToLongBits(getDoubleF()));
      hash = (37 * hash) + FLOATF_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getFloatF());
      hash = (37 * hash) + BYTESF_FIELD_NUMBER;
      hash = (53 * hash) + getBytesF().hashCode();
      hash = (37 * hash) + BOOLF_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getBoolF());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     * Protobuf type {@code com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO)
        com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJOOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.class, com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.newBuilder()
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
      @java.lang.Override
      public Builder clear() {
        super.clear();
        name_ = "";

        id_ = 0;

        email_ = "";

        doubleF_ = 0D;

        floatF_ = 0F;

        bytesF_ = com.google.protobuf.ByteString.EMPTY;

        boolF_ = false;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_descriptor;
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.getDefaultInstance();
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO build() {
        com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO buildPartial() {
        com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO result = new com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO(this);
        result.name_ = name_;
        result.id_ = id_;
        result.email_ = email_;
        result.doubleF_ = doubleF_;
        result.floatF_ = floatF_;
        result.bytesF_ = bytesF_;
        result.boolF_ = boolF_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO other) {
        if (other == com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO.getDefaultInstance()) return this;
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (other.getId() != 0) {
          setId(other.getId());
        }
        if (!other.getEmail().isEmpty()) {
          email_ = other.email_;
          onChanged();
        }
        if (other.getDoubleF() != 0D) {
          setDoubleF(other.getDoubleF());
        }
        if (other.getFloatF() != 0F) {
          setFloatF(other.getFloatF());
        }
        if (other.getBytesF() != com.google.protobuf.ByteString.EMPTY) {
          setBytesF(other.getBytesF());
        }
        if (other.getBoolF() != false) {
          setBoolF(other.getBoolF());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object name_ = "";
      /**
       * <code>string name = 1;</code>
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string name = 1;</code>
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
       * <code>string name = 1;</code>
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string name = 1;</code>
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>string name = 1;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private int id_ ;
      /**
       * <code>int32 id = 2;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>int32 id = 2;</code>
       */
      public Builder setId(int value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 id = 2;</code>
       */
      public Builder clearId() {
        
        id_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object email_ = "";
      /**
       * <code>string email = 3;</code>
       */
      public java.lang.String getEmail() {
        java.lang.Object ref = email_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          email_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string email = 3;</code>
       */
      public com.google.protobuf.ByteString
          getEmailBytes() {
        java.lang.Object ref = email_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          email_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string email = 3;</code>
       */
      public Builder setEmail(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        email_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string email = 3;</code>
       */
      public Builder clearEmail() {
        
        email_ = getDefaultInstance().getEmail();
        onChanged();
        return this;
      }
      /**
       * <code>string email = 3;</code>
       */
      public Builder setEmailBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        email_ = value;
        onChanged();
        return this;
      }

      private double doubleF_ ;
      /**
       * <code>double doubleF = 4;</code>
       */
      public double getDoubleF() {
        return doubleF_;
      }
      /**
       * <code>double doubleF = 4;</code>
       */
      public Builder setDoubleF(double value) {
        
        doubleF_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double doubleF = 4;</code>
       */
      public Builder clearDoubleF() {
        
        doubleF_ = 0D;
        onChanged();
        return this;
      }

      private float floatF_ ;
      /**
       * <code>float floatF = 5;</code>
       */
      public float getFloatF() {
        return floatF_;
      }
      /**
       * <code>float floatF = 5;</code>
       */
      public Builder setFloatF(float value) {
        
        floatF_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>float floatF = 5;</code>
       */
      public Builder clearFloatF() {
        
        floatF_ = 0F;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString bytesF_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes bytesF = 6;</code>
       */
      public com.google.protobuf.ByteString getBytesF() {
        return bytesF_;
      }
      /**
       * <code>bytes bytesF = 6;</code>
       */
      public Builder setBytesF(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        bytesF_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes bytesF = 6;</code>
       */
      public Builder clearBytesF() {
        
        bytesF_ = getDefaultInstance().getBytesF();
        onChanged();
        return this;
      }

      private boolean boolF_ ;
      /**
       * <code>bool boolF = 7;</code>
       */
      public boolean getBoolF() {
        return boolF_;
      }
      /**
       * <code>bool boolF = 7;</code>
       */
      public Builder setBoolF(boolean value) {
        
        boolF_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool boolF = 7;</code>
       */
      public Builder clearBoolF() {
        
        boolF_ = false;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO)
    }

    // @@protoc_insertion_point(class_scope:com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO)
    private static final com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO();
    }

    public static com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PersonPOJO>
        PARSER = new com.google.protobuf.AbstractParser<PersonPOJO>() {
      @java.lang.Override
      public PersonPOJO parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PersonPOJO(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PersonPOJO> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PersonPOJO> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.baidu.bjf.remoting.protobuf.complexList.AddressBookProtos2.PersonPOJO getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\raddress.proto\022+com.baidu.bjf.remoting." +
      "protobuf.complexList\"\252\001\n\025AddressBookProt" +
      "osPOJO\022E\n\004list\030\001 \003(\01327.com.baidu.bjf.rem" +
      "oting.protobuf.complexList.PersonPOJO\022J\n" +
      "\010typeList\030\002 \003(\01628.com.baidu.bjf.remoting" +
      ".protobuf.complexList.TypeDefEnum\"u\n\nPer" +
      "sonPOJO\022\014\n\004name\030\001 \001(\t\022\n\n\002id\030\002 \001(\005\022\r\n\005ema" +
      "il\030\003 \001(\t\022\017\n\007doubleF\030\004 \001(\001\022\016\n\006floatF\030\005 \001(" +
      "\002\022\016\n\006bytesF\030\006 \001(\014\022\r\n\005boolF\030\007 \001(\010*K\n\013Type" +
      "DefEnum\022\010\n\004NULL\020\000\022\010\n\004TEXT\020\001\022\n\n\006NUMBER\020\002\022" +
      "\013\n\007DECIMAL\020\004\022\006\n\002ID\020\010\022\007\n\003URL\020\020B\024B\022Address" +
      "BookProtos2b\006proto3"
    };
    internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_complexList_AddressBookProtosPOJO_descriptor,
        new java.lang.String[] { "List", "TypeList", });
    internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_complexList_PersonPOJO_descriptor,
        new java.lang.String[] { "Name", "Id", "Email", "DoubleF", "FloatF", "BytesF", "BoolF", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
