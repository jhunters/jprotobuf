/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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

/**
 * The Class EnumClass.
 */
public final class EnumClass {
  
  /**
   * Instantiates a new enum class.
   */
  private EnumClass() {}
  
  /**
   * Register all extensions.
   *
   * @param registry the registry
   */
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  /**
   * Protobuf enum {@code proto.smartidea.EnumAttr}
   */
  public enum EnumAttr
      implements com.google.protobuf.ProtocolMessageEnum {
    
    /** <code>STRING = 100;</code>. */
    STRING(0, 0),
    
    /** <code>INT = 50;</code>. */
    INT(1, 1),
    ;

    /** <code>STRING = 100;</code>. */
    public static final int STRING_VALUE = 0;
    
    /** <code>INT = 50;</code>. */
    public static final int INT_VALUE = 1;


    /* (non-Javadoc)
     * @see com.google.protobuf.ProtocolMessageEnum#getNumber()
     */
    public final int getNumber() { return value; }

    /**
     * Value of.
     *
     * @param value the value
     * @return the enum attr
     */
    public static EnumAttr valueOf(int value) {
      switch (value) {
        case 0: return STRING;
        case 1: return INT;
        default: return null;
      }
    }

    /**
     * Internal get value map.
     *
     * @return the com.google.protobuf. internal. enum lite map
     */
    public static com.google.protobuf.Internal.EnumLiteMap<EnumAttr>
        internalGetValueMap() {
      return internalValueMap;
    }
    
    /** The internal value map. */
    private static com.google.protobuf.Internal.EnumLiteMap<EnumAttr>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<EnumAttr>() {
            public EnumAttr findValueByNumber(int number) {
              return EnumAttr.valueOf(number);
            }
          };

    /* (non-Javadoc)
     * @see com.google.protobuf.ProtocolMessageEnum#getValueDescriptor()
     */
    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    
    /* (non-Javadoc)
     * @see com.google.protobuf.ProtocolMessageEnum#getDescriptorForType()
     */
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    
    /**
     * Gets the descriptor.
     *
     * @return the descriptor
     */
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.getDescriptor().getEnumTypes().get(0);
    }

    /** The Constant VALUES. */
    private static final EnumAttr[] VALUES = values();

    /**
     * Value of.
     *
     * @param desc the desc
     * @return the enum attr
     */
    public static EnumAttr valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    /** The index. */
    private final int index;
    
    /** The value. */
    private final int value;

    /**
     * Instantiates a new enum attr.
     *
     * @param index the index
     * @param value the value
     */
    private EnumAttr(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:proto.smartidea.EnumAttr)
  }

  /**
   * The Interface EnumClassInternalOrBuilder.
   */
  public interface EnumClassInternalOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required .proto.smartidea.EnumAttr status = 1;
    /**
     * <code>required .proto.smartidea.EnumAttr status = 1;</code>
     *
     * @return true, if successful
     */
    boolean hasStatus();
    
    /**
     * Gets the status.
     *
     * @return the status
     */
    com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr getStatus();
  }
  /**
   * Protobuf type {@code proto.smartidea.EnumClassInternal}
   */
  public static final class EnumClassInternal extends
      com.google.protobuf.GeneratedMessage
      implements EnumClassInternalOrBuilder {
    
    /**
     * Instantiates a new enum class internal.
     *
     * @param builder the builder
     */
    // Use EnumClassInternal.newBuilder() to construct.
    private EnumClassInternal(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    
    /**
     * Instantiates a new enum class internal.
     *
     * @param noInit the no init
     */
    private EnumClassInternal(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    /** The Constant defaultInstance. */
    private static final EnumClassInternal defaultInstance;
    
    /**
     * Gets the default instance.
     *
     * @return the default instance
     */
    public static EnumClassInternal getDefaultInstance() {
      return defaultInstance;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
     */
    public EnumClassInternal getDefaultInstanceForType() {
      return defaultInstance;
    }

    /** The unknown fields. */
    private final com.google.protobuf.UnknownFieldSet unknownFields;
    
    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#getUnknownFields()
     */
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    
    /**
     * Instantiates a new enum class internal.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
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
              com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr value = com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.valueOf(rawValue);
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
    
    /**
     * Gets the descriptor.
     *
     * @return the descriptor
     */
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.internal_static_proto_smartidea_EnumClassInternal_descriptor;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#internalGetFieldAccessorTable()
     */
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.internal_static_proto_smartidea_EnumClassInternal_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.class, com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.Builder.class);
    }

    /** The parser. */
    public static com.google.protobuf.Parser<EnumClassInternal> PARSER =
        new com.google.protobuf.AbstractParser<EnumClassInternal>() {
      public EnumClassInternal parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new EnumClassInternal(input, extensionRegistry);
      }
    };

    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#getParserForType()
     */
    @java.lang.Override
    public com.google.protobuf.Parser<EnumClassInternal> getParserForType() {
      return PARSER;
    }

    /** The bit field0_. */
    private int bitField0_;
    
    /** The Constant STATUS_FIELD_NUMBER. */
    // required .proto.smartidea.EnumAttr status = 1;
    public static final int STATUS_FIELD_NUMBER = 1;
    
    /** The status_. */
    private com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr status_;
    
    /**
     * <code>required .proto.smartidea.EnumAttr status = 1;</code>
     *
     * @return true, if successful
     */
    public boolean hasStatus() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternalOrBuilder#getStatus()
     */
    public com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr getStatus() {
      return status_;
    }

    /**
     * Inits the fields.
     */
    private void initFields() {
      status_ = com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.STRING;
    }
    
    /** The memoized is initialized. */
    private byte memoizedIsInitialized = -1;
    
    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#isInitialized()
     */
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

    /* (non-Javadoc)
     * @see com.google.protobuf.AbstractMessage#writeTo(com.google.protobuf.CodedOutputStream)
     */
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, status_.getNumber());
      }
      getUnknownFields().writeTo(output);
    }

    /** The memoized serialized size. */
    private int memoizedSerializedSize = -1;
    
    /* (non-Javadoc)
     * @see com.google.protobuf.AbstractMessage#getSerializedSize()
     */
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

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 0L;
    
    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#writeReplace()
     */
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    /**
     * Parses the from.
     *
     * @param data the data
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    
    /**
     * Parses the delimited from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    
    /**
     * Parses the delimited from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.enumeration. enum class. enum class internal
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    /**
     * New builder.
     *
     * @return the builder
     */
    public static Builder newBuilder() { return Builder.create(); }
    
    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLite#newBuilderForType()
     */
    public Builder newBuilderForType() { return newBuilder(); }
    
    /**
     * New builder.
     *
     * @param prototype the prototype
     * @return the builder
     */
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    
    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLite#toBuilder()
     */
    public Builder toBuilder() { return newBuilder(this); }

    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent)
     */
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
       implements com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternalOrBuilder {
      
      /**
       * Gets the descriptor.
       *
       * @return the descriptor
       */
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.internal_static_proto_smartidea_EnumClassInternal_descriptor;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#internalGetFieldAccessorTable()
       */
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.internal_static_proto_smartidea_EnumClassInternal_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.class, com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.Builder.class);
      }

      /**
       * Instantiates a new builder.
       */
      // Construct using com.baidu.bjf.remoting.protobuf.emun.EnumClass.EnumClassInternal.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      /**
       * Instantiates a new builder.
       *
       * @param parent the parent
       */
      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      
      /**
       * Maybe force builder initialization.
       */
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      
      /**
       * Creates the.
       *
       * @return the builder
       */
      private static Builder create() {
        return new Builder();
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#clear()
       */
      public Builder clear() {
        super.clear();
        status_ = com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.STRING;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#clone()
       */
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#getDescriptorForType()
       */
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.internal_static_proto_smartidea_EnumClassInternal_descriptor;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
       */
      public com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.getDefaultInstance();
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLite.Builder#build()
       */
      public com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal build() {
        com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLite.Builder#buildPartial()
       */
      public com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal buildPartial() {
        com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal result = new com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal(this);
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

      /* (non-Javadoc)
       * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.Message)
       */
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      /**
       * Merge from.
       *
       * @param other the other
       * @return the builder
       */
      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal other) {
        if (other == com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal.getDefaultInstance()) return this;
        if (other.hasStatus()) {
          setStatus(other.getStatus());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#isInitialized()
       */
      public final boolean isInitialized() {
        if (!hasStatus()) {
          
          return false;
        }
        return true;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite)
       */
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternal) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      
      /** The bit field0_. */
      private int bitField0_;

      /** The status_. */
      // required .proto.smartidea.EnumAttr status = 1;
      private com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr status_ = com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.STRING;
      
      /**
       * <code>required .proto.smartidea.EnumAttr status = 1;</code>
       *
       * @return true, if successful
       */
      public boolean hasStatus() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumClassInternalOrBuilder#getStatus()
       */
      public com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr getStatus() {
        return status_;
      }
      
      /**
       * <code>required .proto.smartidea.EnumAttr status = 1;</code>
       *
       * @param value the value
       * @return the builder
       */
      public Builder setStatus(com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        status_ = value;
        onChanged();
        return this;
      }
      
      /**
       * <code>required .proto.smartidea.EnumAttr status = 1;</code>
       *
       * @return the builder
       */
      public Builder clearStatus() {
        bitField0_ = (bitField0_ & ~0x00000001);
        status_ = com.baidu.bjf.remoting.protobuf.enumeration.EnumClass.EnumAttr.STRING;
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

  /** The internal_static_proto_smartidea_ enum class internal_descriptor. */
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_smartidea_EnumClassInternal_descriptor;
  
  /** The internal_static_proto_smartidea_ enum class internal_field accessor table. */
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_proto_smartidea_EnumClassInternal_fieldAccessorTable;

  /**
   * Gets the descriptor.
   *
   * @return the descriptor
   */
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  
  /** The descriptor. */
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ntest.proto\022\017proto.smartidea\">\n\021EnumCla" +
      "ssInternal\022)\n\006status\030\001 \002(\0162\031.proto.smart" +
      "idea.EnumAttr*\037\n\010EnumAttr\022\n\n\006STRING\020d\022\007\n" +
      "\003INT\0202B1\n$com.baidu.bjf.remoting.protobu" +
      "f.emunB\tEnumClass"
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
