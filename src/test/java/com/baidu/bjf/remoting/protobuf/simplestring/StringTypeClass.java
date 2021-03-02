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
// source: simplestring.proto

package com.baidu.bjf.remoting.protobuf.simplestring;

public final class StringTypeClass {
  private StringTypeClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface StringMessageOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string list = 1;
    /**
     * <code>required string list = 1;</code>
     */
    boolean hasList();
    /**
     * <code>required string list = 1;</code>
     */
    java.lang.String getList();
    /**
     * <code>required string list = 1;</code>
     */
    com.google.protobuf.ByteString
        getListBytes();
  }
  /**
   * Protobuf type {@code pkg.StringMessage}
   */
  public static final class StringMessage extends
      com.google.protobuf.GeneratedMessage
      implements StringMessageOrBuilder {
    // Use StringMessage.newBuilder() to construct.
    private StringMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private StringMessage(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final StringMessage defaultInstance;
    public static StringMessage getDefaultInstance() {
      return defaultInstance;
    }

    public StringMessage getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private StringMessage(
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
              bitField0_ |= 0x00000001;
              list_ = input.readBytes();
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
      return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.class, com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.Builder.class);
    }

    public static com.google.protobuf.Parser<StringMessage> PARSER =
        new com.google.protobuf.AbstractParser<StringMessage>() {
      public StringMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new StringMessage(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<StringMessage> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string list = 1;
    public static final int LIST_FIELD_NUMBER = 1;
    private java.lang.Object list_;
    /**
     * <code>required string list = 1;</code>
     */
    public boolean hasList() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string list = 1;</code>
     */
    public java.lang.String getList() {
      java.lang.Object ref = list_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          list_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string list = 1;</code>
     */
    public com.google.protobuf.ByteString
        getListBytes() {
      java.lang.Object ref = list_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        list_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      list_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasList()) {
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
        output.writeBytes(1, getListBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getListBytes());
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

    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage prototype) {
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
     * Protobuf type {@code pkg.StringMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.class, com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.newBuilder()
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
        list_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_descriptor;
      }

      public com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.getDefaultInstance();
      }

      public com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage build() {
        com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage buildPartial() {
        com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage result = new com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.list_ = list_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage other) {
        if (other == com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.getDefaultInstance()) return this;
        if (other.hasList()) {
          bitField0_ |= 0x00000001;
          list_ = other.list_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasList()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string list = 1;
      private java.lang.Object list_ = "";
      /**
       * <code>required string list = 1;</code>
       */
      public boolean hasList() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string list = 1;</code>
       */
      public java.lang.String getList() {
        java.lang.Object ref = list_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          list_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string list = 1;</code>
       */
      public com.google.protobuf.ByteString
          getListBytes() {
        java.lang.Object ref = list_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          list_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string list = 1;</code>
       */
      public Builder setList(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        list_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string list = 1;</code>
       */
      public Builder clearList() {
        bitField0_ = (bitField0_ & ~0x00000001);
        list_ = getDefaultInstance().getList();
        onChanged();
        return this;
      }
      /**
       * <code>required string list = 1;</code>
       */
      public Builder setListBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        list_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:pkg.StringMessage)
    }

    static {
      defaultInstance = new StringMessage(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:pkg.StringMessage)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_pkg_StringMessage_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pkg_StringMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022simplestring.proto\022\003pkg\"\035\n\rStringMessa" +
      "ge\022\014\n\004list\030\001 \002(\tB?\n,com.baidu.bjf.remoti" +
      "ng.protobuf.simplestringB\017StringTypeClas" +
      "s"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_pkg_StringMessage_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_pkg_StringMessage_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_pkg_StringMessage_descriptor,
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
