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
// source: addressbook.proto

package com.baidu.bjf.remoting.protobuf.v3;

public final class AddressBookProtos {
  private AddressBookProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PersonOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.baidu.bjf.remoting.protobuf.v3.Person)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string name = 1;</code>
     */
    boolean hasName();
    /**
     * <code>required string name = 1;</code>
     */
    java.lang.String getName();
    /**
     * <code>required string name = 1;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>map&lt;string, string&gt; values = 10;</code>
     */
    java.util.Map<java.lang.String, java.lang.String>
    getValues();
  }
  /**
   * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person}
   */
  public  static final class Person extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.baidu.bjf.remoting.protobuf.v3.Person)
      PersonOrBuilder {
    // Use Person.newBuilder() to construct.
    private Person(com.google.protobuf.GeneratedMessage.Builder builder) {
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
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              name_ = bs;
              break;
            }
            case 82: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                values_ = com.google.protobuf.MapField.newMapField(
                    valuesDefaultEntry);
                mutable_bitField0_ |= 0x00000002;
              }
              com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
              values = input.readMessage(
                  valuesDefaultEntry.getParserForType(), extensionRegistry);
              values_.getMutableMap().put(values.getKey(), values.getValue());
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
      return com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 10:
          return values_;
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person.class, com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person.Builder.class);
    }

    public static final com.google.protobuf.Parser<Person> PARSER =
        new com.google.protobuf.AbstractParser<Person>() {
      public Person parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Person(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Person> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private java.lang.Object name_;
    /**
     * <code>required string name = 1;</code>
     */
    public boolean hasName() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          name_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string name = 1;</code>
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

    public static final int VALUES_FIELD_NUMBER = 10;
    private static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> valuesDefaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_ValuesEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> values_ =
            com.google.protobuf.MapField.emptyMapField(
                valuesDefaultEntry);

    /**
     * <code>map&lt;string, string&gt; values = 10;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getValues() {
      return values_.getMap();
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasName()) {
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
        output.writeBytes(1, getNameBytes());
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : values_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        values = valuesDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(10, values);
      }
      unknownFields.writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getNameBytes());
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
           : values_.getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
        values = valuesDefaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(10, values);
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return new Builder(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person prototype) {
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
     * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.baidu.bjf.remoting.protobuf.v3.Person)
        com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(
          int number) {
        switch (number) {
          case 10:
            return values_;
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person.class, com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person.newBuilder()
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
      public Builder clear() {
        super.clear();
        name_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        values_.clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
      }

      public com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person.getDefaultInstance();
      }

      public com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person build() {
        com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person buildPartial() {
        com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person result = new com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.name_ = name_;
        result.values_ = values_.copy();
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person other) {
        if (other == com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person.getDefaultInstance()) return this;
        if (other.hasName()) {
          bitField0_ |= 0x00000001;
          name_ = other.name_;
          onChanged();
        }
        values_.mergeFrom(other.values_);
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasName()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object name_ = "";
      /**
       * <code>required string name = 1;</code>
       */
      public boolean hasName() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string name = 1;</code>
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            name_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string name = 1;</code>
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
       * <code>required string name = 1;</code>
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 1;</code>
       */
      public Builder clearName() {
        bitField0_ = (bitField0_ & ~0x00000001);
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>required string name = 1;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        name_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.MapField<
          java.lang.String, java.lang.String> values_ =
              com.google.protobuf.MapField.newMapField(
                  valuesDefaultEntry);

      /**
       * <code>map&lt;string, string&gt; values = 10;</code>
       */
      public java.util.Map<java.lang.String, java.lang.String> getValues() {
        return values_.getMap();
      }
      /**
       * <code>map&lt;string, string&gt; values = 10;</code>
       */
      public java.util.Map<java.lang.String, java.lang.String>
      getMutableValues() {
        onChanged();
        return values_.getMutableMap();
      }

      // @@protoc_insertion_point(builder_scope:com.baidu.bjf.remoting.protobuf.v3.Person)
    }

    // @@protoc_insertion_point(class_scope:com.baidu.bjf.remoting.protobuf.v3.Person)
    private static final com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person defaultInstance;static {
      defaultInstance = new com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person();
    }

    public static com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person getDefaultInstance() {
      return defaultInstance;
    }

    public com.baidu.bjf.remoting.protobuf.v3.AddressBookProtos.Person getDefaultInstanceForType() {
      return defaultInstance;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_ValuesEntry_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_ValuesEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021addressbook.proto\022\"com.baidu.bjf.remot" +
      "ing.protobuf.v3\"\215\001\n\006Person\022\014\n\004name\030\001 \002(\t" +
      "\022F\n\006values\030\n \003(\01326.com.baidu.bjf.remotin" +
      "g.protobuf.v3.Person.ValuesEntry\032-\n\013Valu" +
      "esEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001B" +
      "7\n\"com.baidu.bjf.remoting.protobuf.v3B\021A" +
      "ddressBookProtos"
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
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor,
        new java.lang.String[] { "Name", "Values", });
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_ValuesEntry_descriptor =
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor.getNestedTypes().get(0);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_ValuesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_ValuesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
