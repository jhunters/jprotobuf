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
// source: simplerepeat2.proto

package com.baidu.bjf.remoting.protobuf.simplerepeat;

/**
 * The Class RequrieRepeatedNumberType.
 */
public final class RequrieRepeatedNumberType {
  
  /**
   * Instantiates a new requrie repeated number type.
   */
  private RequrieRepeatedNumberType() {}
  
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

    // repeated int32 list1 = 1;
    /**
     * Gets the list1 list.
     *
     * @return the list1 list
     */
    java.util.List<java.lang.Integer> getList1List();
    
    /**
     * Gets the list1 count.
     *
     * @return the list1 count
     */
    int getList1Count();
    
    /**
     * <code>repeated int32 list1 = 1;</code>.
     *
     * @param index the index
     * @return the list1
     */
    int getList1(int index);

    // repeated double list2 = 2;
    /**
     * Gets the list2 list.
     *
     * @return the list2 list
     */
    java.util.List<java.lang.Double> getList2List();
    
    /**
     * Gets the list2 count.
     *
     * @return the list2 count
     */
    int getList2Count();
    
    /**
     * <code>repeated double list2 = 2;</code>.
     *
     * @param index the index
     * @return the list2
     */
    double getList2(int index);

    // repeated string list3 = 3;
    /**
     * Gets the list3 list.
     *
     * @return the list3 list
     */
    java.util.List<java.lang.String>
    getList3List();
    
    /**
     * Gets the list3 count.
     *
     * @return the list3 count
     */
    int getList3Count();
    
    /**
     * <code>repeated string list3 = 3;</code>.
     *
     * @param index the index
     * @return the list3
     */
    java.lang.String getList3(int index);
    
    /**
     * <code>repeated string list3 = 3;</code>.
     *
     * @param index the index
     * @return the list3 bytes
     */
    com.google.protobuf.ByteString
        getList3Bytes(int index);
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
            case 8: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                list1_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              list1_.add(input.readInt32());
              break;
            }
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
                list1_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              while (input.getBytesUntilLimit() > 0) {
                list1_.add(input.readInt32());
              }
              input.popLimit(limit);
              break;
            }
            case 17: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                list2_ = new java.util.ArrayList<java.lang.Double>();
                mutable_bitField0_ |= 0x00000002;
              }
              list2_.add(input.readDouble());
              break;
            }
            case 18: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
                list2_ = new java.util.ArrayList<java.lang.Double>();
                mutable_bitField0_ |= 0x00000002;
              }
              while (input.getBytesUntilLimit() > 0) {
                list2_.add(input.readDouble());
              }
              input.popLimit(limit);
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                list3_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000004;
              }
              list3_.add(input.readBytes());
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
          list1_ = java.util.Collections.unmodifiableList(list1_);
        }
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          list2_ = java.util.Collections.unmodifiableList(list2_);
        }
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          list3_ = new com.google.protobuf.UnmodifiableLazyStringList(list3_);
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
      return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.internal_static_pkg_InterClassName_descriptor;
    }

    /* (non-Javadoc)
     * @see com.google.protobuf.GeneratedMessage#internalGetFieldAccessorTable()
     */
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.internal_static_pkg_InterClassName_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName.class, com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName.Builder.class);
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

    /** The Constant LIST1_FIELD_NUMBER. */
    // repeated int32 list1 = 1;
    public static final int LIST1_FIELD_NUMBER = 1;
    
    /** The list1_. */
    private java.util.List<java.lang.Integer> list1_;
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList1List()
     */
    public java.util.List<java.lang.Integer>
        getList1List() {
      return list1_;
    }
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList1Count()
     */
    public int getList1Count() {
      return list1_.size();
    }
    
    /**
     * <code>repeated int32 list1 = 1;</code>.
     *
     * @param index the index
     * @return the list1
     */
    public int getList1(int index) {
      return list1_.get(index);
    }

    /** The Constant LIST2_FIELD_NUMBER. */
    // repeated double list2 = 2;
    public static final int LIST2_FIELD_NUMBER = 2;
    
    /** The list2_. */
    private java.util.List<java.lang.Double> list2_;
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList2List()
     */
    public java.util.List<java.lang.Double>
        getList2List() {
      return list2_;
    }
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList2Count()
     */
    public int getList2Count() {
      return list2_.size();
    }
    
    /**
     * <code>repeated double list2 = 2;</code>.
     *
     * @param index the index
     * @return the list2
     */
    public double getList2(int index) {
      return list2_.get(index);
    }

    /** The Constant LIST3_FIELD_NUMBER. */
    // repeated string list3 = 3;
    public static final int LIST3_FIELD_NUMBER = 3;
    
    /** The list3_. */
    private com.google.protobuf.LazyStringList list3_;
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList3List()
     */
    public java.util.List<java.lang.String>
        getList3List() {
      return list3_;
    }
    
    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList3Count()
     */
    public int getList3Count() {
      return list3_.size();
    }
    
    /**
     * <code>repeated string list3 = 3;</code>.
     *
     * @param index the index
     * @return the list3
     */
    public java.lang.String getList3(int index) {
      return list3_.get(index);
    }
    
    /**
     * <code>repeated string list3 = 3;</code>.
     *
     * @param index the index
     * @return the list3 bytes
     */
    public com.google.protobuf.ByteString
        getList3Bytes(int index) {
      return list3_.getByteString(index);
    }

    /**
     * Inits the fields.
     */
    private void initFields() {
      list1_ = java.util.Collections.emptyList();
      list2_ = java.util.Collections.emptyList();
      list3_ = com.google.protobuf.LazyStringArrayList.EMPTY;
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
      for (int i = 0; i < list1_.size(); i++) {
        output.writeInt32(1, list1_.get(i));
      }
      for (int i = 0; i < list2_.size(); i++) {
        output.writeDouble(2, list2_.get(i));
      }
      for (int i = 0; i < list3_.size(); i++) {
        output.writeBytes(3, list3_.getByteString(i));
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
        for (int i = 0; i < list1_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(list1_.get(i));
        }
        size += dataSize;
        size += 1 * getList1List().size();
      }
      {
        int dataSize = 0;
        dataSize = 8 * getList2List().size();
        size += dataSize;
        size += 1 * getList2List().size();
      }
      {
        int dataSize = 0;
        for (int i = 0; i < list3_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeBytesSizeNoTag(list3_.getByteString(i));
        }
        size += dataSize;
        size += 1 * getList3List().size();
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
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    
    /**
     * Parses the from.
     *
     * @param data the data
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws InvalidProtocolBufferException the invalid protocol buffer exception
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    
    /**
     * Parses the delimited from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    
    /**
     * Parses the delimited from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    
    /**
     * Parses the from.
     *
     * @param input the input
     * @param extensionRegistry the extension registry
     * @return the com.baidu.bjf.remoting.protobuf.simplerepeat. requrie repeated number type. inter class name
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parseFrom(
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
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName prototype) {
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
       implements com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder {
      
      /**
       * Gets the descriptor.
       *
       * @return the descriptor
       */
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.internal_static_pkg_InterClassName_descriptor;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.GeneratedMessage.Builder#internalGetFieldAccessorTable()
       */
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.internal_static_pkg_InterClassName_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName.class, com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName.Builder.class);
      }

      /**
       * Instantiates a new builder.
       */
      // Construct using com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName.newBuilder()
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
        list1_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        list2_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        list3_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
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
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.internal_static_pkg_InterClassName_descriptor;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
       */
      public com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName.getDefaultInstance();
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLite.Builder#build()
       */
      public com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName build() {
        com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.MessageLite.Builder#buildPartial()
       */
      public com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName buildPartial() {
        com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName result = new com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          list1_ = java.util.Collections.unmodifiableList(list1_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.list1_ = list1_;
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          list2_ = java.util.Collections.unmodifiableList(list2_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.list2_ = list2_;
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          list3_ = new com.google.protobuf.UnmodifiableLazyStringList(
              list3_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.list3_ = list3_;
        onBuilt();
        return result;
      }

      /* (non-Javadoc)
       * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.Message)
       */
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName)other);
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
      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName other) {
        if (other == com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName.getDefaultInstance()) return this;
        if (!other.list1_.isEmpty()) {
          if (list1_.isEmpty()) {
            list1_ = other.list1_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureList1IsMutable();
            list1_.addAll(other.list1_);
          }
          onChanged();
        }
        if (!other.list2_.isEmpty()) {
          if (list2_.isEmpty()) {
            list2_ = other.list2_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureList2IsMutable();
            list2_.addAll(other.list2_);
          }
          onChanged();
        }
        if (!other.list3_.isEmpty()) {
          if (list3_.isEmpty()) {
            list3_ = other.list3_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureList3IsMutable();
            list3_.addAll(other.list3_);
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
        com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassName) e.getUnfinishedMessage();
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

      /** The list1_. */
      // repeated int32 list1 = 1;
      private java.util.List<java.lang.Integer> list1_ = java.util.Collections.emptyList();
      
      /**
       * Ensure list1 is mutable.
       */
      private void ensureList1IsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          list1_ = new java.util.ArrayList<java.lang.Integer>(list1_);
          bitField0_ |= 0x00000001;
         }
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList1List()
       */
      public java.util.List<java.lang.Integer>
          getList1List() {
        return java.util.Collections.unmodifiableList(list1_);
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList1Count()
       */
      public int getList1Count() {
        return list1_.size();
      }
      
      /**
       * <code>repeated int32 list1 = 1;</code>.
       *
       * @param index the index
       * @return the list1
       */
      public int getList1(int index) {
        return list1_.get(index);
      }
      
      /**
       * <code>repeated int32 list1 = 1;</code>.
       *
       * @param index the index
       * @param value the value
       * @return the builder
       */
      public Builder setList1(
          int index, int value) {
        ensureList1IsMutable();
        list1_.set(index, value);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated int32 list1 = 1;</code>.
       *
       * @param value the value
       * @return the builder
       */
      public Builder addList1(int value) {
        ensureList1IsMutable();
        list1_.add(value);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated int32 list1 = 1;</code>.
       *
       * @param values the values
       * @return the builder
       */
      public Builder addAllList1(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureList1IsMutable();
        super.addAll(values, list1_);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated int32 list1 = 1;</code>.
       *
       * @return the builder
       */
      public Builder clearList1() {
        list1_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }

      /** The list2_. */
      // repeated double list2 = 2;
      private java.util.List<java.lang.Double> list2_ = java.util.Collections.emptyList();
      
      /**
       * Ensure list2 is mutable.
       */
      private void ensureList2IsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          list2_ = new java.util.ArrayList<java.lang.Double>(list2_);
          bitField0_ |= 0x00000002;
         }
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList2List()
       */
      public java.util.List<java.lang.Double>
          getList2List() {
        return java.util.Collections.unmodifiableList(list2_);
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList2Count()
       */
      public int getList2Count() {
        return list2_.size();
      }
      
      /**
       * <code>repeated double list2 = 2;</code>.
       *
       * @param index the index
       * @return the list2
       */
      public double getList2(int index) {
        return list2_.get(index);
      }
      
      /**
       * <code>repeated double list2 = 2;</code>.
       *
       * @param index the index
       * @param value the value
       * @return the builder
       */
      public Builder setList2(
          int index, double value) {
        ensureList2IsMutable();
        list2_.set(index, value);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated double list2 = 2;</code>.
       *
       * @param value the value
       * @return the builder
       */
      public Builder addList2(double value) {
        ensureList2IsMutable();
        list2_.add(value);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated double list2 = 2;</code>.
       *
       * @param values the values
       * @return the builder
       */
      public Builder addAllList2(
          java.lang.Iterable<? extends java.lang.Double> values) {
        ensureList2IsMutable();
        super.addAll(values, list2_);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated double list2 = 2;</code>.
       *
       * @return the builder
       */
      public Builder clearList2() {
        list2_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }

      /** The list3_. */
      // repeated string list3 = 3;
      private com.google.protobuf.LazyStringList list3_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      
      /**
       * Ensure list3 is mutable.
       */
      private void ensureList3IsMutable() {
        if (!((bitField0_ & 0x00000004) == 0x00000004)) {
          list3_ = new com.google.protobuf.LazyStringArrayList(list3_);
          bitField0_ |= 0x00000004;
         }
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList3List()
       */
      public java.util.List<java.lang.String>
          getList3List() {
        return java.util.Collections.unmodifiableList(list3_);
      }
      
      /* (non-Javadoc)
       * @see com.baidu.bjf.remoting.protobuf.simplerepeat.RequrieRepeatedNumberType.InterClassNameOrBuilder#getList3Count()
       */
      public int getList3Count() {
        return list3_.size();
      }
      
      /**
       * <code>repeated string list3 = 3;</code>.
       *
       * @param index the index
       * @return the list3
       */
      public java.lang.String getList3(int index) {
        return list3_.get(index);
      }
      
      /**
       * <code>repeated string list3 = 3;</code>.
       *
       * @param index the index
       * @return the list3 bytes
       */
      public com.google.protobuf.ByteString
          getList3Bytes(int index) {
        return list3_.getByteString(index);
      }
      
      /**
       * <code>repeated string list3 = 3;</code>.
       *
       * @param index the index
       * @param value the value
       * @return the builder
       */
      public Builder setList3(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureList3IsMutable();
        list3_.set(index, value);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated string list3 = 3;</code>.
       *
       * @param value the value
       * @return the builder
       */
      public Builder addList3(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureList3IsMutable();
        list3_.add(value);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated string list3 = 3;</code>.
       *
       * @param values the values
       * @return the builder
       */
      public Builder addAllList3(
          java.lang.Iterable<java.lang.String> values) {
        ensureList3IsMutable();
        super.addAll(values, list3_);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated string list3 = 3;</code>.
       *
       * @return the builder
       */
      public Builder clearList3() {
        list3_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
        return this;
      }
      
      /**
       * <code>repeated string list3 = 3;</code>.
       *
       * @param value the value
       * @return the builder
       */
      public Builder addList3Bytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureList3IsMutable();
        list3_.add(value);
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
      "\n\023simplerepeat2.proto\022\003pkg\"=\n\016InterClass" +
      "Name\022\r\n\005list1\030\001 \003(\005\022\r\n\005list2\030\002 \003(\001\022\r\n\005li" +
      "st3\030\003 \003(\tBI\n,com.baidu.bjf.remoting.prot" +
      "obuf.simplerepeatB\031RequrieRepeatedNumber" +
      "Type"
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
              new java.lang.String[] { "List1", "List2", "List3", });
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
