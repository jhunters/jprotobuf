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
// source: simplerepeat.proto

package com.baidu.bjf.remoting.protobuf.simplerepeat;

/**
 * The Class RequrieRepeatedType.
 */
public final class RequrieRepeatedType {
  
  /**
   * Instantiates a new requrie repeated type.
   */
  private RequrieRepeatedType() {}
  
  /**
   * Register all extensions.
   *
   * @param registry the registry
   */
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  
  /**
   * The Interface InterClassNameOrBuilder.
   */
  public interface InterClassNameOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // repeated string list = 1;
    /**
     * Gets the list list.
     *
     * @return the list list
     */
    java.util.List<java.lang.String>
    getListList();
    
    /**
     * Gets the list count.
     *
     * @return the list count
     */
    int getListCount();
    
    /**
     * <code>repeated string list = 1;</code>.
     *
     * @param index the index
     * @return the list
     */
    java.lang.String getList(int index);
    
    /**
     * <code>repeated string list = 1;</code>.
     *
     * @param index the index
     * @return the list bytes
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
    
    /**
     * Instantiates a new inter class name.
     *
     * @param builder the builder
     */
    // Use InterClassName.newBuilder() to construct.
    private InterClassName(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    
    /**
     * Instantiates a new inter class name.
     *
     * @param noInit the no init
     */
    private InterClassName(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    /** The Constant defaultInstance. */
    private static final InterClassName defaultInstance;
    
    /**
     * Gets the default instance.
     *
     * @return the default instance
     */
    public static InterClassName getDefaultInstance() {
      return defaultInstance;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
     */
    public InterClassName getDefaultInstanceForType() {
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
     * Instantiates a new inter class name.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
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
    
    /**
     * Gets the descriptor.
     *
     * @return the descriptor
     */
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_descriptor;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#internalGetFieldAccessorTable()
     */
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.class, com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.Builder.class);
    }

    /** The parser. */
    public static com.google.protobuf.Parser<InterClassName> PARSER =
        new com.google.protobuf.AbstractParser<InterClassName>() {
      public InterClassName parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new InterClassName(input, extensionRegistry);
      }
    };

    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#getParserForType()
     */
    @java.lang.Override
    public com.google.protobuf.Parser<InterClassName> getParserForType() {
      return PARSER;
    }

    /** The Constant LIST_FIELD_NUMBER. */
    // repeated string list = 1;
    public static final int LIST_FIELD_NUMBER = 1;
    
    /** The list_. */
    private com.google.protobuf.LazyStringList list_;
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassNameOrBuilder#getListList()
     */
    public java.util.List<java.lang.String>
        getListList() {
      return list_;
    }
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassNameOrBuilder#getListCount()
     */
    public int getListCount() {
      return list_.size();
    }
    
    /**
     * <code>repeated string list = 1;</code>.
     *
     * @param index the index
     * @return the list
     */
    public java.lang.String getList(int index) {
      return list_.get(index);
    }
    
    /**
     * <code>repeated string list = 1;</code>.
     *
     * @param index the index
     * @return the list bytes
     */
    public com.google.protobuf.ByteString
        getListBytes(int index) {
      return list_.getByteString(index);
    }

    /**
     * Inits the fields.
     */
    private void initFields() {
      list_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    }
    
    /** The memoized is initialized. */
    private byte memoizedIsInitialized = -1;
    
    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#isInitialized()
     */
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      memoizedIsInitialized = 1;
      return true;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.AbstractMessage#writeTo(com.google.protobuf.CodedOutputStream)
     */
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < list_.size(); i++) {
        output.writeBytes(1, list_.getByteString(i));
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
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    
    /**
     * Parses the delimited from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    
    /**
     * Parses the delimited from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName parseFrom(
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
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName prototype) {
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
     * Protobuf type {@code pkg.InterClassName}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassNameOrBuilder {
      
      /**
       * Gets the descriptor.
       *
       * @return the descriptor
       */
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_descriptor;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#internalGetFieldAccessorTable()
       */
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.class, com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.Builder.class);
      }

      /**
       * Instantiates a new builder.
       */
      // Construct using com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.newBuilder()
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
        list_ = com.google.protobuf.LazyStringArrayList.EMPTY;
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
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.internal_static_pkg_InterClassName_descriptor;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
       */
      public com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName.getDefaultInstance();
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLite.Builder#build()
       */
      public com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName build() {
        com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLite.Builder#buildPartial()
       */
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

      /* (non-Javadoc)
       * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.Message)
       */
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassName)other);
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

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#isInitialized()
       */
      public final boolean isInitialized() {
        return true;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite)
       */
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
      
      /** The bit field0_. */
      private int bitField0_;

      /** The list_. */
      // repeated string list = 1;
      private com.google.protobuf.LazyStringList list_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      
      /**
       * Ensure list is mutable.
       */
      private void ensureListIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          list_ = new com.google.protobuf.LazyStringArrayList(list_);
          bitField0_ |= 0x00000001;
         }
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassNameOrBuilder#getListList()
       */
      public java.util.List<java.lang.String>
          getListList() {
        return java.util.Collections.unmodifiableList(list_);
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedType.InterClassNameOrBuilder#getListCount()
       */
      public int getListCount() {
        return list_.size();
      }
      
      /**
       * <code>repeated string list = 1;</code>.
       *
       * @param index the index
       * @return the list
       */
      public java.lang.String getList(int index) {
        return list_.get(index);
      }
      
      /**
       * <code>repeated string list = 1;</code>.
       *
       * @param index the index
       * @return the list bytes
       */
      public com.google.protobuf.ByteString
          getListBytes(int index) {
        return list_.getByteString(index);
      }
      
      /**
       * <code>repeated string list = 1;</code>.
       *
       * @param index the index
       * @param value the value
       * @return the builder
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
       * <code>repeated string list = 1;</code>.
       *
       * @param value the value
       * @return the builder
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
       * <code>repeated string list = 1;</code>.
       *
       * @param values the values
       * @return the builder
       */
      public Builder addAllList(
          java.lang.Iterable<java.lang.String> values) {
        ensureListIsMutable();
        super.addAll(values, list_);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated string list = 1;</code>.
       *
       * @return the builder
       */
      public Builder clearList() {
        list_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated string list = 1;</code>.
       *
       * @param value the value
       * @return the builder
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

  /** The internal_static_pkg_ inter class name_descriptor. */
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_pkg_InterClassName_descriptor;
  
  /** The internal_static_pkg_ inter class name_field accessor table. */
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_pkg_InterClassName_fieldAccessorTable;

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
