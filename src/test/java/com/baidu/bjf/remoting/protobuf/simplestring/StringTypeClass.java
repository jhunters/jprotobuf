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
// source: simplestring.proto

package com.baidu.bjf.remoting.protobuf.simplestring;

/**
 * The Class StringTypeClass.
 */
public final class StringTypeClass {
  
  /**
   * Instantiates a new string type class.
   */
  private StringTypeClass() {}
  
  /**
   * Register all extensions.
   *
   * @param registry the registry
   */
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  
  /**
   * The Interface StringMessageOrBuilder.
   */
  public interface StringMessageOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string list = 1;
    /**
     * <code>required string list = 1;</code>.
     *
     * @return true, if successful
     */
    boolean hasList();
    
    /**
     * Gets the list.
     *
     * @return the list
     */
    java.lang.String getList();
    
    /**
     * Gets the list bytes.
     *
     * @return the list bytes
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
    
    /**
     * Instantiates a new string message.
     *
     * @param builder the builder
     */
    // Use StringMessage.newBuilder() to construct.
    private StringMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    
    /**
     * Instantiates a new string message.
     *
     * @param noInit the no init
     */
    private StringMessage(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    /** The Constant defaultInstance. */
    private static final StringMessage defaultInstance;
    
    /**
     * Gets the default instance.
     *
     * @return the default instance
     */
    public static StringMessage getDefaultInstance() {
      return defaultInstance;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
     */
    public StringMessage getDefaultInstanceForType() {
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
     * Instantiates a new string message.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
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
    
    /**
     * Gets the descriptor.
     *
     * @return the descriptor
     */
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_descriptor;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#internalGetFieldAccessorTable()
     */
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.class, com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.Builder.class);
    }

    /** The parser. */
    public static com.google.protobuf.Parser<StringMessage> PARSER =
        new com.google.protobuf.AbstractParser<StringMessage>() {
      public StringMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new StringMessage(input, extensionRegistry);
      }
    };

    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#getParserForType()
     */
    @java.lang.Override
    public com.google.protobuf.Parser<StringMessage> getParserForType() {
      return PARSER;
    }

    /** The bit field0_. */
    private int bitField0_;
    
    /** The Constant LIST_FIELD_NUMBER. */
    // required string list = 1;
    public static final int LIST_FIELD_NUMBER = 1;
    
    /** The list_. */
    private java.lang.Object list_;
    
    /**
     * <code>required string list = 1;</code>.
     *
     * @return true, if successful
     */
    public boolean hasList() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessageOrBuilder#getList()
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
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessageOrBuilder#getListBytes()
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

    /**
     * Inits the fields.
     */
    private void initFields() {
      list_ = "";
    }
    
    /** The memoized is initialized. */
    private byte memoizedIsInitialized = -1;
    
    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#isInitialized()
     */
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

    /* (non-Javadoc)
     * @see com.google.protobuf.AbstractMessage#writeTo(com.google.protobuf.CodedOutputStream)
     */
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getListBytes());
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
          .computeBytesSize(1, getListBytes());
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
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    
    /**
     * Parses the delimited from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    
    /**
     * Parses the delimited from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplestring. string type class. string message
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage parseFrom(
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
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage prototype) {
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
     * Protobuf type {@code pkg.StringMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessageOrBuilder {
      
      /**
       * Gets the descriptor.
       *
       * @return the descriptor
       */
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_descriptor;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#internalGetFieldAccessorTable()
       */
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.class, com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.Builder.class);
      }

      /**
       * Instantiates a new builder.
       */
      // Construct using com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.newBuilder()
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
        list_ = "";
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
        return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.internal_static_pkg_StringMessage_descriptor;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
       */
      public com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage.getDefaultInstance();
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLite.Builder#build()
       */
      public com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage build() {
        com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLite.Builder#buildPartial()
       */
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

      /* (non-Javadoc)
       * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.Message)
       */
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessage)other);
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

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#isInitialized()
       */
      public final boolean isInitialized() {
        if (!hasList()) {
          
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
      
      /** The bit field0_. */
      private int bitField0_;

      /** The list_. */
      // required string list = 1;
      private java.lang.Object list_ = "";
      
      /**
       * <code>required string list = 1;</code>.
       *
       * @return true, if successful
       */
      public boolean hasList() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessageOrBuilder#getList()
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
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplestring.StringTypeClass.StringMessageOrBuilder#getListBytes()
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
       * <code>required string list = 1;</code>.
       *
       * @param value the value
       * @return the builder
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
       * <code>required string list = 1;</code>.
       *
       * @return the builder
       */
      public Builder clearList() {
        bitField0_ = (bitField0_ & ~0x00000001);
        list_ = getDefaultInstance().getList();
        onChanged();
        return this;
      }
      
      /**
       * <code>required string list = 1;</code>.
       *
       * @param value the value
       * @return the builder
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

  /** The internal_static_pkg_ string message_descriptor. */
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_pkg_StringMessage_descriptor;
  
  /** The internal_static_pkg_ string message_field accessor table. */
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pkg_StringMessage_fieldAccessorTable;

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
