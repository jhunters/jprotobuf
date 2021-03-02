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
// source: simplerepeat.proto

package com.baidu.bjf.remoting.protobuf.simplerepeat;

public final class RequrieRepeatedType {
  private RequrieRepeatedType() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface InterClassNameOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // repeated string list = 1;
    /**
     * <code>repeated string list = 1;</code>
     */
    java.util.List<java.lang.String>
    getListList();
    /**
     * <code>repeated string list = 1;</code>
     */
    int getListCount();
    /**
     * <code>repeated string list = 1;</code>
     */
    java.lang.String getList(int index);
    /**
     * <code>repeated string list = 1;</code>
     */
    com.google.protobuf.ByteString
        getListBytes(int index);
  }
  /**
   * Protobuf type {@code pkg.InterClassName}
   */
  public static final class InterClassName extends
      com.google.protobuf.GeneratedMessage
      implements InterClassNameOrBuilder {
    // Use InterClassName.newBuilder() to construct.
    private InterClassName(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private InterClassName(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final InterClassName defaultInstance;
    public static InterClassName getDefaultInstance() {
      return defaultInstance;
    }

    public InterClassName getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private InterClassName(
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
                list_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000001;
              }
              list_.add(input.readBytes());
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
          list_ = new com.google.protobuf.UnmodifiableLazyStringList(list_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.class, com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.Builder.class);
    }

    public static com.google.protobuf.Parser<InterClassName> PARSER =
        new com.google.protobuf.AbstractParser<InterClassName>() {
      public InterClassName parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new InterClassName(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<InterClassName> getParserForType() {
      return PARSER;
    }

    // repeated string list = 1;
    public static final int LIST_FIELD_NUMBER = 1;
    private com.google.protobuf.LazyStringList list_;
    /**
     * <code>repeated string list = 1;</code>
     */
    public java.util.List<java.lang.String>
        getListList() {
      return list_;
    }
    /**
     * <code>repeated string list = 1;</code>
     */
    public int getListCount() {
      return list_.size();
    }
    /**
     * <code>repeated string list = 1;</code>
     */
    public java.lang.String getList(int index) {
      return list_.get(index);
    }
    /**
     * <code>repeated string list = 1;</code>
     */
    public com.google.protobuf.ByteString
        getListBytes(int index) {
      return list_.getByteString(index);
    }

    private void initFields() {
      list_ = com.google.protobuf.LazyStringArrayList.EMPTY;
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
      for (int i = 0; i < list_.size(); i++) {
        output.writeBytes(1, list_.getByteString(i));
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
        for (int i = 0; i < list_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(list_.getByteString(i));
        }
        size += dataSize;
        size += 1 * getListList().size();
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

    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName prototype) {
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
     * Protobuf type {@code pkg.InterClassName}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassNameOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.class, com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.newBuilder()
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
        list_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_descriptor;
      }

      public com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.getDefaultInstance();
      }

      public com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName build() {
        com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName buildPartial() {
        com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName result = new com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          list_ = new com.google.protobuf.UnmodifiableLazyStringList(
              list_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.list_ = list_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName other) {
        if (other == com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.getDefaultInstance()) return this;
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
        com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // repeated string list = 1;
      private com.google.protobuf.LazyStringList list_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureListIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          list_ = new com.google.protobuf.LazyStringArrayList(list_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public java.util.List<java.lang.String>
          getListList() {
        return java.util.Collections.unmodifiableList(list_);
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public int getListCount() {
        return list_.size();
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public java.lang.String getList(int index) {
        return list_.get(index);
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public com.google.protobuf.ByteString
          getListBytes(int index) {
        return list_.getByteString(index);
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public Builder setList(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureListIsMutable();
        list_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public Builder addList(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureListIsMutable();
        list_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public Builder addAllList(
          java.lang.Iterable<java.lang.String> values) {
        ensureListIsMutable();
        super.addAll(values, list_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public Builder clearList() {
        list_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string list = 1;</code>
       */
      public Builder addListBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureListIsMutable();
        list_.add(value);
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:pkg.InterClassName)
    }

    static {
      defaultInstance = new InterClassName(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:pkg.InterClassName)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_pkg_InterClassName_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pkg_InterClassName_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022simplerepeat.proto\022\003pkg\"\036\n\016InterClassN" +
      "ame\022\014\n\004list\030\001 \003(\tBC\n,com.baidu.bjf.remot" +
      "ing.protobuf.simplerepeatB\023RequrieRepeat" +
      "edType"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_pkg_InterClassName_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_pkg_InterClassName_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_pkg_InterClassName_descriptor,
              new java.lang.String[] { "List", });
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
