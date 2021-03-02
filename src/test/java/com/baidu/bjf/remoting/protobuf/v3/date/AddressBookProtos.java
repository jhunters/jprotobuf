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
// source: date.proto

package com.baidu.bjf.remoting.protobuf.v3.date;

public final class AddressBookProtos {
  private AddressBookProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PersonOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.baidu.bjf.remoting.protobuf.v3.Person)
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
     * <code>.google.protobuf.Timestamp ts = 2;</code>
     */
    boolean hasTs();
    /**
     * <code>.google.protobuf.Timestamp ts = 2;</code>
     */
    com.google.protobuf.Timestamp getTs();
    /**
     * <code>.google.protobuf.Timestamp ts = 2;</code>
     */
    com.google.protobuf.TimestampOrBuilder getTsOrBuilder();
  }
  /**
   * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person}
   */
  public  static final class Person extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.baidu.bjf.remoting.protobuf.v3.Person)
      PersonOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
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
            case 18: {
              com.google.protobuf.Timestamp.Builder subBuilder = null;
              if (ts_ != null) {
                subBuilder = ts_.toBuilder();
              }
              ts_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(ts_);
                ts_ = subBuilder.buildPartial();
              }

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
      return com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person.class, com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person.Builder.class);
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

    public static final int TS_FIELD_NUMBER = 2;
    private com.google.protobuf.Timestamp ts_;
    /**
     * <code>.google.protobuf.Timestamp ts = 2;</code>
     */
    public boolean hasTs() {
      return ts_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp ts = 2;</code>
     */
    public com.google.protobuf.Timestamp getTs() {
      return ts_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : ts_;
    }
    /**
     * <code>.google.protobuf.Timestamp ts = 2;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getTsOrBuilder() {
      return getTs();
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
      if (ts_ != null) {
        output.writeMessage(2, getTs());
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
      if (ts_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getTs());
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
      if (!(obj instanceof com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person)) {
        return super.equals(obj);
      }
      com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person other = (com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person) obj;

      if (!getName()
          .equals(other.getName())) return false;
      if (hasTs() != other.hasTs()) return false;
      if (hasTs()) {
        if (!getTs()
            .equals(other.getTs())) return false;
      }
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
      if (hasTs()) {
        hash = (37 * hash) + TS_FIELD_NUMBER;
        hash = (53 * hash) + getTs().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parseFrom(
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
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person prototype) {
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
     * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.baidu.bjf.remoting.protobuf.v3.Person)
        com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person.class, com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person.newBuilder()
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

        if (tsBuilder_ == null) {
          ts_ = null;
        } else {
          ts_ = null;
          tsBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person.getDefaultInstance();
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person build() {
        com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person buildPartial() {
        com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person result = new com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person(this);
        result.name_ = name_;
        if (tsBuilder_ == null) {
          result.ts_ = ts_;
        } else {
          result.ts_ = tsBuilder_.build();
        }
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
        if (other instanceof com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person other) {
        if (other == com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person.getDefaultInstance()) return this;
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (other.hasTs()) {
          mergeTs(other.getTs());
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
        com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person) e.getUnfinishedMessage();
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

      private com.google.protobuf.Timestamp ts_;
      private com.google.protobuf.SingleFieldBuilderV3<
          com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> tsBuilder_;
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      public boolean hasTs() {
        return tsBuilder_ != null || ts_ != null;
      }
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      public com.google.protobuf.Timestamp getTs() {
        if (tsBuilder_ == null) {
          return ts_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : ts_;
        } else {
          return tsBuilder_.getMessage();
        }
      }
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      public Builder setTs(com.google.protobuf.Timestamp value) {
        if (tsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ts_ = value;
          onChanged();
        } else {
          tsBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      public Builder setTs(
          com.google.protobuf.Timestamp.Builder builderForValue) {
        if (tsBuilder_ == null) {
          ts_ = builderForValue.build();
          onChanged();
        } else {
          tsBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      public Builder mergeTs(com.google.protobuf.Timestamp value) {
        if (tsBuilder_ == null) {
          if (ts_ != null) {
            ts_ =
              com.google.protobuf.Timestamp.newBuilder(ts_).mergeFrom(value).buildPartial();
          } else {
            ts_ = value;
          }
          onChanged();
        } else {
          tsBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      public Builder clearTs() {
        if (tsBuilder_ == null) {
          ts_ = null;
          onChanged();
        } else {
          ts_ = null;
          tsBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      public com.google.protobuf.Timestamp.Builder getTsBuilder() {
        
        onChanged();
        return getTsFieldBuilder().getBuilder();
      }
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      public com.google.protobuf.TimestampOrBuilder getTsOrBuilder() {
        if (tsBuilder_ != null) {
          return tsBuilder_.getMessageOrBuilder();
        } else {
          return ts_ == null ?
              com.google.protobuf.Timestamp.getDefaultInstance() : ts_;
        }
      }
      /**
       * <code>.google.protobuf.Timestamp ts = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
          getTsFieldBuilder() {
        if (tsBuilder_ == null) {
          tsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                  getTs(),
                  getParentForChildren(),
                  isClean());
          ts_ = null;
        }
        return tsBuilder_;
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


      // @@protoc_insertion_point(builder_scope:com.baidu.bjf.remoting.protobuf.v3.Person)
    }

    // @@protoc_insertion_point(class_scope:com.baidu.bjf.remoting.protobuf.v3.Person)
    private static final com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person();
    }

    public static com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Person>
        PARSER = new com.google.protobuf.AbstractParser<Person>() {
      @java.lang.Override
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

    @java.lang.Override
    public com.baidu.bjf.remoting.protobuf.v3.date.AddressBookProtos.Person getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ndate.proto\022\"com.baidu.bjf.remoting.pro" +
      "tobuf.v3\0323protobuf-master/src/google/pro" +
      "tobuf/timestamp.proto\">\n\006Person\022\014\n\004name\030" +
      "\001 \001(\t\022&\n\002ts\030\002 \001(\0132\032.google.protobuf.Time" +
      "stampB<\n\'com.baidu.bjf.remoting.protobuf" +
      ".v3.dateB\021AddressBookProtosb\006proto3"
    };
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor,
        new java.lang.String[] { "Name", "Ts", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
