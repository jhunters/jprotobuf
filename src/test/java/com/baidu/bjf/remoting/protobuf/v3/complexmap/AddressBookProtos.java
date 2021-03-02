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

package com.baidu.bjf.remoting.protobuf.v3.complexmap;

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
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */
    int getPhoneTypeEnumValueMapCount();
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */
    boolean containsPhoneTypeEnumValueMap(
        java.lang.String key);
    /**
     * Use {@link #getPhoneTypeEnumValueMapMap()} instead.
     */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType>
    getPhoneTypeEnumValueMap();
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */
    java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType>
    getPhoneTypeEnumValueMapMap();
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */
    com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getPhoneTypeEnumValueMapOrDefault(
        java.lang.String key,
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType defaultValue);
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */
    com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getPhoneTypeEnumValueMapOrThrow(
        java.lang.String key);

    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */
    int getPhoneNumberObjectValueMapCount();
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */
    boolean containsPhoneNumberObjectValueMap(
        java.lang.String key);
    /**
     * Use {@link #getPhoneNumberObjectValueMapMap()} instead.
     */
    @java.lang.Deprecated
    java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
    getPhoneNumberObjectValueMap();
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */
    java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
    getPhoneNumberObjectValueMapMap();
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */

    com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getPhoneNumberObjectValueMapOrDefault(
        java.lang.String key,
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber defaultValue);
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */

    com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getPhoneNumberObjectValueMapOrThrow(
        java.lang.String key);
  }
  /**
   * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person}
   */
  public  static final class Person extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.baidu.bjf.remoting.protobuf.v3.Person)
      PersonOrBuilder {
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
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                phoneTypeEnumValueMap_ = com.google.protobuf.MapField.newMapField(
                    PhoneTypeEnumValueMapDefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000002;
              }
              com.google.protobuf.ByteString bytes = input.readBytes();
              com.google.protobuf.MapEntry<java.lang.String, java.lang.Integer>
              phoneTypeEnumValueMap = PhoneTypeEnumValueMapDefaultEntryHolder.defaultEntry.getParserForType().parseFrom(bytes);
              if (com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.forNumber(phoneTypeEnumValueMap.getValue()) == null) {
                unknownFields.mergeLengthDelimitedField(2, bytes);
              } else {
                phoneTypeEnumValueMap_.getMutableMap().put(phoneTypeEnumValueMap.getKey(), phoneTypeEnumValueMap.getValue());
              }
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                phoneNumberObjectValueMap_ = com.google.protobuf.MapField.newMapField(
                    PhoneNumberObjectValueMapDefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000004;
              }
              com.google.protobuf.MapEntry<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
              phoneNumberObjectValueMap = input.readMessage(
                  PhoneNumberObjectValueMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              phoneNumberObjectValueMap_.getMutableMap().put(phoneNumberObjectValueMap.getKey(), phoneNumberObjectValueMap.getValue());
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
      return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetPhoneTypeEnumValueMap();
        case 3:
          return internalGetPhoneNumberObjectValueMap();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.class, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.Builder.class);
    }

    /**
     * Protobuf enum {@code com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType}
     */
    public enum PhoneType
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>MOBILE = 0;</code>
       */
      MOBILE(0),
      /**
       * <code>HOME = 1;</code>
       */
      HOME(1),
      /**
       * <code>WORK = 2;</code>
       */
      WORK(2),
      ;

      /**
       * <code>MOBILE = 0;</code>
       */
      public static final int MOBILE_VALUE = 0;
      /**
       * <code>HOME = 1;</code>
       */
      public static final int HOME_VALUE = 1;
      /**
       * <code>WORK = 2;</code>
       */
      public static final int WORK_VALUE = 2;


      public final int getNumber() {
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static PhoneType valueOf(int value) {
        return forNumber(value);
      }

      public static PhoneType forNumber(int value) {
        switch (value) {
          case 0: return MOBILE;
          case 1: return HOME;
          case 2: return WORK;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<PhoneType>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          PhoneType> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<PhoneType>() {
              public PhoneType findValueByNumber(int number) {
                return PhoneType.forNumber(number);
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
        return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.getDescriptor().getEnumTypes().get(0);
      }

      private static final PhoneType[] VALUES = values();

      public static PhoneType valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }

      private final int value;

      private PhoneType(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType)
    }

    public interface PhoneNumberOrBuilder extends
        // @@protoc_insertion_point(interface_extends:com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber)
        com.google.protobuf.MessageOrBuilder {

      /**
       * <code>required string number = 1;</code>
       */
      boolean hasNumber();
      /**
       * <code>required string number = 1;</code>
       */
      java.lang.String getNumber();
      /**
       * <code>required string number = 1;</code>
       */
      com.google.protobuf.ByteString
          getNumberBytes();

      /**
       * <code>optional .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType type = 2 [default = HOME];</code>
       */
      boolean hasType();
      /**
       * <code>optional .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType type = 2 [default = HOME];</code>
       */
      com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getType();
    }
    /**
     * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber}
     */
    public  static final class PhoneNumber extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber)
        PhoneNumberOrBuilder {
      // Use PhoneNumber.newBuilder() to construct.
      private PhoneNumber(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
      }
      private PhoneNumber() {
        number_ = "";
        type_ = 1;
      }

      @java.lang.Override
      public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
        return this.unknownFields;
      }
      private PhoneNumber(
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
                number_ = bs;
                break;
              }
              case 16: {
                int rawValue = input.readEnum();
                com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType value = com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.valueOf(rawValue);
                if (value == null) {
                  unknownFields.mergeVarintField(2, rawValue);
                } else {
                  bitField0_ |= 0x00000002;
                  type_ = rawValue;
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
        return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber.class, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber.Builder.class);
      }

      private int bitField0_;
      public static final int NUMBER_FIELD_NUMBER = 1;
      private volatile java.lang.Object number_;
      /**
       * <code>required string number = 1;</code>
       */
      public boolean hasNumber() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string number = 1;</code>
       */
      public java.lang.String getNumber() {
        java.lang.Object ref = number_;
        if (ref instanceof java.lang.String) {
          return (java.lang.String) ref;
        } else {
          com.google.protobuf.ByteString bs = 
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            number_ = s;
          }
          return s;
        }
      }
      /**
       * <code>required string number = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNumberBytes() {
        java.lang.Object ref = number_;
        if (ref instanceof java.lang.String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          number_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }

      public static final int TYPE_FIELD_NUMBER = 2;
      private int type_;
      /**
       * <code>optional .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType type = 2 [default = HOME];</code>
       */
      public boolean hasType() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType type = 2 [default = HOME];</code>
       */
      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getType() {
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType result = com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.valueOf(type_);
        return result == null ? com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.HOME : result;
      }

      private byte memoizedIsInitialized = -1;
      public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) return true;
        if (isInitialized == 0) return false;

        if (!hasNumber()) {
          memoizedIsInitialized = 0;
          return false;
        }
        memoizedIsInitialized = 1;
        return true;
      }

      public void writeTo(com.google.protobuf.CodedOutputStream output)
                          throws java.io.IOException {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          com.google.protobuf.GeneratedMessageV3.writeString(output, 1, number_);
        }
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          output.writeEnum(2, type_);
        }
        unknownFields.writeTo(output);
      }

      public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, number_);
        }
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          size += com.google.protobuf.CodedOutputStream
            .computeEnumSize(2, type_);
        }
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return size;
      }

      private static final long serialVersionUID = 0L;
      @java.lang.Override
      public boolean equals(final java.lang.Object obj) {
        if (obj == this) {
         return true;
        }
        if (!(obj instanceof com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber)) {
          return super.equals(obj);
        }
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber other = (com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber) obj;

        boolean result = true;
        result = result && (hasNumber() == other.hasNumber());
        if (hasNumber()) {
          result = result && getNumber()
              .equals(other.getNumber());
        }
        result = result && (hasType() == other.hasType());
        if (hasType()) {
          result = result && type_ == other.type_;
        }
        result = result && unknownFields.equals(other.unknownFields);
        return result;
      }

      @java.lang.Override
      public int hashCode() {
        if (memoizedHashCode != 0) {
          return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptorForType().hashCode();
        if (hasNumber()) {
          hash = (37 * hash) + NUMBER_FIELD_NUMBER;
          hash = (53 * hash) + getNumber().hashCode();
        }
        if (hasType()) {
          hash = (37 * hash) + TYPE_FIELD_NUMBER;
          hash = (53 * hash) + type_;
        }
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
      }

      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseFrom(java.io.InputStream input)
          throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
      }
      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
      }

      public Builder newBuilderForType() { return newBuilder(); }
      public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
      }
      public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
      }
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
       * Protobuf type {@code com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber}
       */
      public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber)
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumberOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
          return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
          return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                  com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber.class, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber.Builder.class);
        }

        // Construct using com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber.newBuilder()
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
        public Builder clear() {
          super.clear();
          number_ = "";
          bitField0_ = (bitField0_ & ~0x00000001);
          type_ = 1;
          bitField0_ = (bitField0_ & ~0x00000002);
          return this;
        }

        public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
          return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_descriptor;
        }

        public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getDefaultInstanceForType() {
          return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber.getDefaultInstance();
        }

        public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber build() {
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber result = buildPartial();
          if (!result.isInitialized()) {
            throw newUninitializedMessageException(result);
          }
          return result;
        }

        public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber buildPartial() {
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber result = new com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber(this);
          int from_bitField0_ = bitField0_;
          int to_bitField0_ = 0;
          if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
            to_bitField0_ |= 0x00000001;
          }
          result.number_ = number_;
          if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
            to_bitField0_ |= 0x00000002;
          }
          result.type_ = type_;
          result.bitField0_ = to_bitField0_;
          onBuilt();
          return result;
        }

        public Builder clone() {
          return (Builder) super.clone();
        }
        public Builder setField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            Object value) {
          return (Builder) super.setField(field, value);
        }
        public Builder clearField(
            com.google.protobuf.Descriptors.FieldDescriptor field) {
          return (Builder) super.clearField(field);
        }
        public Builder clearOneof(
            com.google.protobuf.Descriptors.OneofDescriptor oneof) {
          return (Builder) super.clearOneof(oneof);
        }
        public Builder setRepeatedField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            int index, Object value) {
          return (Builder) super.setRepeatedField(field, index, value);
        }
        public Builder addRepeatedField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            Object value) {
          return (Builder) super.addRepeatedField(field, value);
        }
        public Builder mergeFrom(com.google.protobuf.Message other) {
          if (other instanceof com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber) {
            return mergeFrom((com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber)other);
          } else {
            super.mergeFrom(other);
            return this;
          }
        }

        public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber other) {
          if (other == com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber.getDefaultInstance()) return this;
          if (other.hasNumber()) {
            bitField0_ |= 0x00000001;
            number_ = other.number_;
            onChanged();
          }
          if (other.hasType()) {
            setType(other.getType());
          }
          this.mergeUnknownFields(other.unknownFields);
          onChanged();
          return this;
        }

        public final boolean isInitialized() {
          if (!hasNumber()) {
            return false;
          }
          return true;
        }

        public Builder mergeFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber parsedMessage = null;
          try {
            parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            parsedMessage = (com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber) e.getUnfinishedMessage();
            throw e.unwrapIOException();
          } finally {
            if (parsedMessage != null) {
              mergeFrom(parsedMessage);
            }
          }
          return this;
        }
        private int bitField0_;

        private java.lang.Object number_ = "";
        /**
         * <code>required string number = 1;</code>
         */
        public boolean hasNumber() {
          return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>required string number = 1;</code>
         */
        public java.lang.String getNumber() {
          java.lang.Object ref = number_;
          if (!(ref instanceof java.lang.String)) {
            com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
              number_ = s;
            }
            return s;
          } else {
            return (java.lang.String) ref;
          }
        }
        /**
         * <code>required string number = 1;</code>
         */
        public com.google.protobuf.ByteString
            getNumberBytes() {
          java.lang.Object ref = number_;
          if (ref instanceof String) {
            com.google.protobuf.ByteString b = 
                com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref);
            number_ = b;
            return b;
          } else {
            return (com.google.protobuf.ByteString) ref;
          }
        }
        /**
         * <code>required string number = 1;</code>
         */
        public Builder setNumber(
            java.lang.String value) {
          if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
          number_ = value;
          onChanged();
          return this;
        }
        /**
         * <code>required string number = 1;</code>
         */
        public Builder clearNumber() {
          bitField0_ = (bitField0_ & ~0x00000001);
          number_ = getDefaultInstance().getNumber();
          onChanged();
          return this;
        }
        /**
         * <code>required string number = 1;</code>
         */
        public Builder setNumberBytes(
            com.google.protobuf.ByteString value) {
          if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
          number_ = value;
          onChanged();
          return this;
        }

        private int type_ = 1;
        /**
         * <code>optional .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType type = 2 [default = HOME];</code>
         */
        public boolean hasType() {
          return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>optional .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType type = 2 [default = HOME];</code>
         */
        public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getType() {
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType result = com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.valueOf(type_);
          return result == null ? com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.HOME : result;
        }
        /**
         * <code>optional .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType type = 2 [default = HOME];</code>
         */
        public Builder setType(com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType value) {
          if (value == null) {
            throw new NullPointerException();
          }
          bitField0_ |= 0x00000002;
          type_ = value.getNumber();
          onChanged();
          return this;
        }
        /**
         * <code>optional .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType type = 2 [default = HOME];</code>
         */
        public Builder clearType() {
          bitField0_ = (bitField0_ & ~0x00000002);
          type_ = 1;
          onChanged();
          return this;
        }
        public final Builder setUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields) {
          return super.setUnknownFields(unknownFields);
        }

        public final Builder mergeUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields) {
          return super.mergeUnknownFields(unknownFields);
        }


        // @@protoc_insertion_point(builder_scope:com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber)
      }

      // @@protoc_insertion_point(class_scope:com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber)
      private static final com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber DEFAULT_INSTANCE;
      static {
        DEFAULT_INSTANCE = new com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber();
      }

      public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }

      @java.lang.Deprecated public static final com.google.protobuf.Parser<PhoneNumber>
          PARSER = new com.google.protobuf.AbstractParser<PhoneNumber>() {
        public PhoneNumber parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return new PhoneNumber(input, extensionRegistry);
        }
      };

      public static com.google.protobuf.Parser<PhoneNumber> parser() {
        return PARSER;
      }

      @java.lang.Override
      public com.google.protobuf.Parser<PhoneNumber> getParserForType() {
        return PARSER;
      }

      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
      }

    }

    private int bitField0_;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile java.lang.Object name_;
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

    public static final int PHONETYPEENUMVALUEMAP_FIELD_NUMBER = 2;
    private static final class PhoneTypeEnumValueMapDefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          java.lang.String, java.lang.Integer> defaultEntry =
              com.google.protobuf.MapEntry
              .<java.lang.String, java.lang.Integer>newDefaultInstance(
                  com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneTypeEnumValueMapEntry_descriptor, 
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.ENUM,
                  com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.MOBILE.getNumber());
    }
    private com.google.protobuf.MapField<
        java.lang.String, java.lang.Integer> phoneTypeEnumValueMap_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.Integer>
    internalGetPhoneTypeEnumValueMap() {
      if (phoneTypeEnumValueMap_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            PhoneTypeEnumValueMapDefaultEntryHolder.defaultEntry);
      }
      return phoneTypeEnumValueMap_;
    }
    private static final
    com.google.protobuf.Internal.MapAdapter.Converter<
        java.lang.Integer, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType> phoneTypeEnumValueMapValueConverter =
            com.google.protobuf.Internal.MapAdapter.newEnumConverter(
                com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.internalGetValueMap(),
                com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType.MOBILE);

    public int getPhoneTypeEnumValueMapCount() {
      return internalGetPhoneTypeEnumValueMap().getMap().size();
    }
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */

    public boolean containsPhoneTypeEnumValueMap(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetPhoneTypeEnumValueMap().getMap().containsKey(key);
    }
    /**
     * Use {@link #getPhoneTypeEnumValueMapMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType>
    getPhoneTypeEnumValueMap() {
      return getPhoneTypeEnumValueMapMap();
    }
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */

    public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType>
    getPhoneTypeEnumValueMapMap() {
      return new com.google.protobuf.Internal.MapAdapter<
          java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType, java.lang.Integer>(
              internalGetPhoneTypeEnumValueMap().getMap(),
              phoneTypeEnumValueMapValueConverter);
    }
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */

    public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getPhoneTypeEnumValueMapOrDefault(
        java.lang.String key,
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.Integer> map =
          internalGetPhoneTypeEnumValueMap().getMap();
      return map.containsKey(key)
             ? phoneTypeEnumValueMapValueConverter.doForward(map.get(key))
             : defaultValue;
    }
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
     */

    public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getPhoneTypeEnumValueMapOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.Integer> map =
          internalGetPhoneTypeEnumValueMap().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return phoneTypeEnumValueMapValueConverter.doForward(map.get(key));
    }

    public static final int PHONENUMBEROBJECTVALUEMAP_FIELD_NUMBER = 3;
    private static final class PhoneNumberObjectValueMapDefaultEntryHolder {
      static final com.google.protobuf.MapEntry<
          java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> defaultEntry =
              com.google.protobuf.MapEntry
              .<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>newDefaultInstance(
                  com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumberObjectValueMapEntry_descriptor, 
                  com.google.protobuf.WireFormat.FieldType.STRING,
                  "",
                  com.google.protobuf.WireFormat.FieldType.MESSAGE,
                  com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber.getDefaultInstance());
    }
    private com.google.protobuf.MapField<
        java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> phoneNumberObjectValueMap_;
    private com.google.protobuf.MapField<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
    internalGetPhoneNumberObjectValueMap() {
      if (phoneNumberObjectValueMap_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            PhoneNumberObjectValueMapDefaultEntryHolder.defaultEntry);
      }
      return phoneNumberObjectValueMap_;
    }

    public int getPhoneNumberObjectValueMapCount() {
      return internalGetPhoneNumberObjectValueMap().getMap().size();
    }
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */

    public boolean containsPhoneNumberObjectValueMap(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetPhoneNumberObjectValueMap().getMap().containsKey(key);
    }
    /**
     * Use {@link #getPhoneNumberObjectValueMapMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> getPhoneNumberObjectValueMap() {
      return getPhoneNumberObjectValueMapMap();
    }
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */

    public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> getPhoneNumberObjectValueMapMap() {
      return internalGetPhoneNumberObjectValueMap().getMap();
    }
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */

    public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getPhoneNumberObjectValueMapOrDefault(
        java.lang.String key,
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> map =
          internalGetPhoneNumberObjectValueMap().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
     */

    public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getPhoneNumberObjectValueMapOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> map =
          internalGetPhoneNumberObjectValueMap().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
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
      for (com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber item : getPhoneNumberObjectValueMap().values()) {
        if (!item.isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry
           : internalGetPhoneTypeEnumValueMap().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.Integer>
        phoneTypeEnumValueMap = PhoneTypeEnumValueMapDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(2, phoneTypeEnumValueMap);
      }
      for (java.util.Map.Entry<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> entry
           : internalGetPhoneNumberObjectValueMap().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
        phoneNumberObjectValueMap = PhoneNumberObjectValueMapDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        output.writeMessage(3, phoneNumberObjectValueMap);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
      }
      for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry
           : internalGetPhoneTypeEnumValueMap().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, java.lang.Integer>
        phoneTypeEnumValueMap = PhoneTypeEnumValueMapDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(2, phoneTypeEnumValueMap);
      }
      for (java.util.Map.Entry<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> entry
           : internalGetPhoneNumberObjectValueMap().getMap().entrySet()) {
        com.google.protobuf.MapEntry<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
        phoneNumberObjectValueMap = PhoneNumberObjectValueMapDefaultEntryHolder.defaultEntry.newBuilderForType()
            .setKey(entry.getKey())
            .setValue(entry.getValue())
            .build();
        size += com.google.protobuf.CodedOutputStream
            .computeMessageSize(3, phoneNumberObjectValueMap);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person)) {
        return super.equals(obj);
      }
      com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person other = (com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person) obj;

      boolean result = true;
      result = result && (hasName() == other.hasName());
      if (hasName()) {
        result = result && getName()
            .equals(other.getName());
      }
      result = result && internalGetPhoneTypeEnumValueMap().equals(
          other.internalGetPhoneTypeEnumValueMap());
      result = result && internalGetPhoneNumberObjectValueMap().equals(
          other.internalGetPhoneNumberObjectValueMap());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      if (hasName()) {
        hash = (37 * hash) + NAME_FIELD_NUMBER;
        hash = (53 * hash) + getName().hashCode();
      }
      if (!internalGetPhoneTypeEnumValueMap().getMap().isEmpty()) {
        hash = (37 * hash) + PHONETYPEENUMVALUEMAP_FIELD_NUMBER;
        hash = (53 * hash) + internalGetPhoneTypeEnumValueMap().hashCode();
      }
      if (!internalGetPhoneNumberObjectValueMap().getMap().isEmpty()) {
        hash = (37 * hash) + PHONENUMBEROBJECTVALUEMAP_FIELD_NUMBER;
        hash = (53 * hash) + internalGetPhoneNumberObjectValueMap().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
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
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.PersonOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
      }

      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMapField(
          int number) {
        switch (number) {
          case 2:
            return internalGetPhoneTypeEnumValueMap();
          case 3:
            return internalGetPhoneNumberObjectValueMap();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      @SuppressWarnings({"rawtypes"})
      protected com.google.protobuf.MapField internalGetMutableMapField(
          int number) {
        switch (number) {
          case 2:
            return internalGetMutablePhoneTypeEnumValueMap();
          case 3:
            return internalGetMutablePhoneNumberObjectValueMap();
          default:
            throw new RuntimeException(
                "Invalid map field number: " + number);
        }
      }
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.class, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.Builder.class);
      }

      // Construct using com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.newBuilder()
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
      public Builder clear() {
        super.clear();
        name_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        internalGetMutablePhoneTypeEnumValueMap().clear();
        internalGetMutablePhoneNumberObjectValueMap().clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
      }

      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person getDefaultInstanceForType() {
        return com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.getDefaultInstance();
      }

      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person build() {
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person buildPartial() {
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person result = new com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.name_ = name_;
        result.phoneTypeEnumValueMap_ = internalGetPhoneTypeEnumValueMap();
        result.phoneTypeEnumValueMap_.makeImmutable();
        result.phoneNumberObjectValueMap_ = internalGetPhoneNumberObjectValueMap();
        result.phoneNumberObjectValueMap_.makeImmutable();
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person) {
          return mergeFrom((com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person other) {
        if (other == com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.getDefaultInstance()) return this;
        if (other.hasName()) {
          bitField0_ |= 0x00000001;
          name_ = other.name_;
          onChanged();
        }
        internalGetMutablePhoneTypeEnumValueMap().mergeFrom(
            other.internalGetPhoneTypeEnumValueMap());
        internalGetMutablePhoneNumberObjectValueMap().mergeFrom(
            other.internalGetPhoneNumberObjectValueMap());
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasName()) {
          return false;
        }
        for (com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber item : getPhoneNumberObjectValueMap().values()) {
          if (!item.isInitialized()) {
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person) e.getUnfinishedMessage();
          throw e.unwrapIOException();
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
          java.lang.String, java.lang.Integer> phoneTypeEnumValueMap_;
      private com.google.protobuf.MapField<java.lang.String, java.lang.Integer>
      internalGetPhoneTypeEnumValueMap() {
        if (phoneTypeEnumValueMap_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              PhoneTypeEnumValueMapDefaultEntryHolder.defaultEntry);
        }
        return phoneTypeEnumValueMap_;
      }
      private com.google.protobuf.MapField<java.lang.String, java.lang.Integer>
      internalGetMutablePhoneTypeEnumValueMap() {
        onChanged();;
        if (phoneTypeEnumValueMap_ == null) {
          phoneTypeEnumValueMap_ = com.google.protobuf.MapField.newMapField(
              PhoneTypeEnumValueMapDefaultEntryHolder.defaultEntry);
        }
        if (!phoneTypeEnumValueMap_.isMutable()) {
          phoneTypeEnumValueMap_ = phoneTypeEnumValueMap_.copy();
        }
        return phoneTypeEnumValueMap_;
      }

      public int getPhoneTypeEnumValueMapCount() {
        return internalGetPhoneTypeEnumValueMap().getMap().size();
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
       */

      public boolean containsPhoneTypeEnumValueMap(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        return internalGetPhoneTypeEnumValueMap().getMap().containsKey(key);
      }
      /**
       * Use {@link #getPhoneTypeEnumValueMapMap()} instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType>
      getPhoneTypeEnumValueMap() {
        return getPhoneTypeEnumValueMapMap();
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
       */

      public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType>
      getPhoneTypeEnumValueMapMap() {
        return new com.google.protobuf.Internal.MapAdapter<
            java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType, java.lang.Integer>(
                internalGetPhoneTypeEnumValueMap().getMap(),
                phoneTypeEnumValueMapValueConverter);
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
       */

      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getPhoneTypeEnumValueMapOrDefault(
          java.lang.String key,
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType defaultValue) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.Integer> map =
            internalGetPhoneTypeEnumValueMap().getMap();
        return map.containsKey(key)
               ? phoneTypeEnumValueMapValueConverter.doForward(map.get(key))
               : defaultValue;
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
       */

      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType getPhoneTypeEnumValueMapOrThrow(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, java.lang.Integer> map =
            internalGetPhoneTypeEnumValueMap().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return phoneTypeEnumValueMapValueConverter.doForward(map.get(key));
      }

      public Builder clearPhoneTypeEnumValueMap() {
        getMutablePhoneTypeEnumValueMap().clear();
        return this;
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
       */

      public Builder removePhoneTypeEnumValueMap(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        getMutablePhoneTypeEnumValueMap().remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType>
      getMutablePhoneTypeEnumValueMap() {
        return new com.google.protobuf.Internal.MapAdapter<
            java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType, java.lang.Integer>(
                internalGetMutablePhoneTypeEnumValueMap().getMutableMap(),
                phoneTypeEnumValueMapValueConverter);
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
       */
      public Builder putPhoneTypeEnumValueMap(
          java.lang.String key,
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType value) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        if (value == null) { throw new java.lang.NullPointerException(); }
        getMutablePhoneTypeEnumValueMap().put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneType&gt; phoneTypeEnumValueMap = 2;</code>
       */
      public Builder putAllPhoneTypeEnumValueMap(
          java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneType> values) {
        getMutablePhoneTypeEnumValueMap().putAll(values);
        return this;
      }

      private com.google.protobuf.MapField<
          java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> phoneNumberObjectValueMap_;
      private com.google.protobuf.MapField<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
      internalGetPhoneNumberObjectValueMap() {
        if (phoneNumberObjectValueMap_ == null) {
          return com.google.protobuf.MapField.emptyMapField(
              PhoneNumberObjectValueMapDefaultEntryHolder.defaultEntry);
        }
        return phoneNumberObjectValueMap_;
      }
      private com.google.protobuf.MapField<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
      internalGetMutablePhoneNumberObjectValueMap() {
        onChanged();;
        if (phoneNumberObjectValueMap_ == null) {
          phoneNumberObjectValueMap_ = com.google.protobuf.MapField.newMapField(
              PhoneNumberObjectValueMapDefaultEntryHolder.defaultEntry);
        }
        if (!phoneNumberObjectValueMap_.isMutable()) {
          phoneNumberObjectValueMap_ = phoneNumberObjectValueMap_.copy();
        }
        return phoneNumberObjectValueMap_;
      }

      public int getPhoneNumberObjectValueMapCount() {
        return internalGetPhoneNumberObjectValueMap().getMap().size();
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
       */

      public boolean containsPhoneNumberObjectValueMap(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        return internalGetPhoneNumberObjectValueMap().getMap().containsKey(key);
      }
      /**
       * Use {@link #getPhoneNumberObjectValueMapMap()} instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> getPhoneNumberObjectValueMap() {
        return getPhoneNumberObjectValueMapMap();
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
       */

      public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> getPhoneNumberObjectValueMapMap() {
        return internalGetPhoneNumberObjectValueMap().getMap();
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
       */

      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getPhoneNumberObjectValueMapOrDefault(
          java.lang.String key,
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber defaultValue) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> map =
            internalGetPhoneNumberObjectValueMap().getMap();
        return map.containsKey(key) ? map.get(key) : defaultValue;
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
       */

      public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber getPhoneNumberObjectValueMapOrThrow(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> map =
            internalGetPhoneNumberObjectValueMap().getMap();
        if (!map.containsKey(key)) {
          throw new java.lang.IllegalArgumentException();
        }
        return map.get(key);
      }

      public Builder clearPhoneNumberObjectValueMap() {
        getMutablePhoneNumberObjectValueMap().clear();
        return this;
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
       */

      public Builder removePhoneNumberObjectValueMap(
          java.lang.String key) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        getMutablePhoneNumberObjectValueMap().remove(key);
        return this;
      }
      /**
       * Use alternate mutation accessors instead.
       */
      @java.lang.Deprecated
      public java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber>
      getMutablePhoneNumberObjectValueMap() {
        return internalGetMutablePhoneNumberObjectValueMap().getMutableMap();
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
       */
      public Builder putPhoneNumberObjectValueMap(
          java.lang.String key,
          com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber value) {
        if (key == null) { throw new java.lang.NullPointerException(); }
        if (value == null) { throw new java.lang.NullPointerException(); }
        getMutablePhoneNumberObjectValueMap().put(key, value);
        return this;
      }
      /**
       * <code>map&lt;string, .com.baidu.bjf.remoting.protobuf.v3.Person.PhoneNumber&gt; phoneNumberObjectValueMap = 3;</code>
       */

      public Builder putAllPhoneNumberObjectValueMap(
          java.util.Map<java.lang.String, com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person.PhoneNumber> values) {
        getMutablePhoneNumberObjectValueMap().putAll(values);
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.baidu.bjf.remoting.protobuf.v3.Person)
    }

    // @@protoc_insertion_point(class_scope:com.baidu.bjf.remoting.protobuf.v3.Person)
    private static final com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person();
    }

    public static com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<Person>
        PARSER = new com.google.protobuf.AbstractParser<Person>() {
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

    public com.baidu.bjf.remoting.protobuf.v3.complexmap.AddressBookProtos.Person getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneTypeEnumValueMapEntry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneTypeEnumValueMapEntry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumberObjectValueMapEntry_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumberObjectValueMapEntry_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021addressbook.proto\022\"com.baidu.bjf.remot" +
      "ing.protobuf.v3\"\356\004\n\006Person\022\014\n\004name\030\001 \002(\t" +
      "\022d\n\025phoneTypeEnumValueMap\030\002 \003(\0132E.com.ba" +
      "idu.bjf.remoting.protobuf.v3.Person.Phon" +
      "eTypeEnumValueMapEntry\022l\n\031phoneNumberObj" +
      "ectValueMap\030\003 \003(\0132I.com.baidu.bjf.remoti" +
      "ng.protobuf.v3.Person.PhoneNumberObjectV" +
      "alueMapEntry\032r\n\032PhoneTypeEnumValueMapEnt" +
      "ry\022\013\n\003key\030\001 \001(\t\022C\n\005value\030\002 \001(\01624.com.bai" +
      "du.bjf.remoting.protobuf.v3.Person.Phone",
      "Type:\0028\001\032x\n\036PhoneNumberObjectValueMapEnt" +
      "ry\022\013\n\003key\030\001 \001(\t\022E\n\005value\030\002 \001(\01326.com.bai" +
      "du.bjf.remoting.protobuf.v3.Person.Phone" +
      "Number:\0028\001\032g\n\013PhoneNumber\022\016\n\006number\030\001 \002(" +
      "\t\022H\n\004type\030\002 \001(\01624.com.baidu.bjf.remoting" +
      ".protobuf.v3.Person.PhoneType:\004HOME\"+\n\tP" +
      "honeType\022\n\n\006MOBILE\020\000\022\010\n\004HOME\020\001\022\010\n\004WORK\020\002" +
      "BB\n-com.baidu.bjf.remoting.protobuf.v3.c" +
      "omplexmapB\021AddressBookProtos"
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
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor,
        new java.lang.String[] { "Name", "PhoneTypeEnumValueMap", "PhoneNumberObjectValueMap", });
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneTypeEnumValueMapEntry_descriptor =
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor.getNestedTypes().get(0);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneTypeEnumValueMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneTypeEnumValueMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumberObjectValueMapEntry_descriptor =
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor.getNestedTypes().get(1);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumberObjectValueMapEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumberObjectValueMapEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_descriptor =
      internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_descriptor.getNestedTypes().get(2);
    internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_baidu_bjf_remoting_protobuf_v3_Person_PhoneNumber_descriptor,
        new java.lang.String[] { "Number", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
