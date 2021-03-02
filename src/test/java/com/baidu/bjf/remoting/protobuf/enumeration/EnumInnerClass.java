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
// source: test.proto

package com.baidu.bjf.remoting.protobuf.enumeration;

public final class EnumInnerClass {
  private EnumInnerClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface EnumClassInternalOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;
    /**
     * <code>required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;</code>
     */
    boolean hasStatus();
    /**
     * <code>required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;</code>
     */
    com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr getStatus();
  }
  /**
   * Protobuf type {@code proto.smartidea.EnumClassInternal}
   */
  public static final class EnumClassInternal extends
      com.google.protobuf.GeneratedMessage
      implements EnumClassInternalOrBuilder {
    // Use EnumClassInternal.newBuilder() to construct.
    private EnumClassInternal(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private EnumClassInternal(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final EnumClassInternal defaultInstance;
    public static EnumClassInternal getDefaultInstance() {
      return defaultInstance;
    }

    public EnumClassInternal getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private EnumClassInternal(
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
            case 8: {
              int rawValue = input.readEnum();
              com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr value = com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                status_ = value;
              }
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
      return com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.internal_static_proto_smartidea_EnumClassInternal_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.internal_static_proto_smartidea_EnumClassInternal_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.class, com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.Builder.class);
    }

    public static com.google.protobuf.Parser<EnumClassInternal> PARSER =
        new com.google.protobuf.AbstractParser<EnumClassInternal>() {
      public EnumClassInternal parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new EnumClassInternal(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<EnumClassInternal> getParserForType() {
      return PARSER;
    }

    /**
     * Protobuf enum {@code proto.smartidea.EnumClassInternal.EnumAttr}
     */
    public enum EnumAttr
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>STRING = 100;</code>
       */
      STRING(0, 100),
      /**
       * <code>INT = 50;</code>
       */
      INT(1, 50),
      ;

      /**
       * <code>STRING = 100;</code>
       */
      public static final int STRING_VALUE = 100;
      /**
       * <code>INT = 50;</code>
       */
      public static final int INT_VALUE = 50;


      public final int getNumber() { return value; }

      public static EnumAttr valueOf(int value) {
        switch (value) {
          case 100: return STRING;
          case 50: return INT;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<EnumAttr>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static com.google.protobuf.Internal.EnumLiteMap<EnumAttr>
          internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<EnumAttr>() {
              public EnumAttr findValueByNumber(int number) {
                return EnumAttr.valueOf(number);
              }
            };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(index);
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.getDescriptor().getEnumTypes().get(0);
      }

      private static final EnumAttr[] VALUES = values();

      public static EnumAttr valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }

      private final int index;
      private final int value;

      private EnumAttr(int index, int value) {
        this.index = index;
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:proto.smartidea.EnumClassInternal.EnumAttr)
    }

    private int bitField0_;
    // required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;
    public static final int STATUS_FIELD_NUMBER = 1;
    private com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr status_;
    /**
     * <code>required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;</code>
     */
    public boolean hasStatus() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;</code>
     */
    public com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr getStatus() {
      return status_;
    }

    private void initFields() {
      status_ = com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr.STRING;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasStatus()) {
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
        output.writeEnum(1, status_.getNumber());
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
          .computeEnumSize(1, status_.getNumber());
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

    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal prototype) {
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
     * Protobuf type {@code proto.smartidea.EnumClassInternal}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternalOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.internal_static_proto_smartidea_EnumClassInternal_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.internal_static_proto_smartidea_EnumClassInternal_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.class, com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.emun.EnumInnerClass.EnumClassInternal.newBuilder()
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
        status_ = com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr.STRING;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.internal_static_proto_smartidea_EnumClassInternal_descriptor;
      }

      public com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.getDefaultInstance();
      }

      public com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal build() {
        com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal buildPartial() {
        com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal result = new com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.status_ = status_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal other) {
        if (other == com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.getDefaultInstance()) return this;
        if (other.hasStatus()) {
          setStatus(other.getStatus());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasStatus()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;
      private com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr status_ = com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr.STRING;
      /**
       * <code>required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;</code>
       */
      public boolean hasStatus() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;</code>
       */
      public com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr getStatus() {
        return status_;
      }
      /**
       * <code>required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;</code>
       */
      public Builder setStatus(com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        status_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required .proto.smartidea.EnumClassInternal.EnumAttr status = 1;</code>
       */
      public Builder clearStatus() {
        bitField0_ = (bitField0_ & ~0x00000001);
        status_ = com.baidu.bjf.remoting.protobuf.enumeration.EnumInnerClass.EnumClassInternal.EnumAttr.STRING;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:proto.smartidea.EnumClassInternal)
    }

    static {
      defaultInstance = new EnumClassInternal(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:proto.smartidea.EnumClassInternal)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_smartidea_EnumClassInternal_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_proto_smartidea_EnumClassInternal_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ntest.proto\022\017proto.smartidea\"q\n\021EnumCla" +
      "ssInternal\022;\n\006status\030\001 \002(\0162+.proto.smart" +
      "idea.EnumClassInternal.EnumAttr\"\037\n\010EnumA" +
      "ttr\022\n\n\006STRING\020d\022\007\n\003INT\0202B6\n$com.baidu.bj" +
      "f.remoting.protobuf.emunB\016EnumInnerClass"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_proto_smartidea_EnumClassInternal_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_proto_smartidea_EnumClassInternal_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_proto_smartidea_EnumClassInternal_descriptor,
              new java.lang.String[] { "Status", });
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
