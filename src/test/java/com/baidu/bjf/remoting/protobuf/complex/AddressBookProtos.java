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
// source: qiantao.proto

package com.baidu.bjf.remoting.protobuf.complex;

public final class AddressBookProtos {
    private AddressBookProtos() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    }

    public interface PersonOrBuilder extends com.google.protobuf.MessageOrBuilder {

        // required string name = 1;
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
        com.google.protobuf.ByteString getNameBytes();

        // required int32 id = 2;
        /**
         * <code>required int32 id = 2;</code>
         * 
         * <pre>
         * Unique ID number for this person.
         * </pre>
         */
        boolean hasId();

        /**
         * <code>required int32 id = 2;</code>
         * 
         * <pre>
         * Unique ID number for this person.
         * </pre>
         */
        int getId();

        // optional string email = 3;
        /**
         * <code>optional string email = 3;</code>
         */
        boolean hasEmail();

        /**
         * <code>optional string email = 3;</code>
         */
        java.lang.String getEmail();

        /**
         * <code>optional string email = 3;</code>
         */
        com.google.protobuf.ByteString getEmailBytes();

        // optional double doubleF = 4;
        /**
         * <code>optional double doubleF = 4;</code>
         */
        boolean hasDoubleF();

        /**
         * <code>optional double doubleF = 4;</code>
         */
        double getDoubleF();

        // optional float floatF = 5;
        /**
         * <code>optional float floatF = 5;</code>
         */
        boolean hasFloatF();

        /**
         * <code>optional float floatF = 5;</code>
         */
        float getFloatF();

        // optional bytes bytesF = 6;
        /**
         * <code>optional bytes bytesF = 6;</code>
         */
        boolean hasBytesF();

        /**
         * <code>optional bytes bytesF = 6;</code>
         */
        com.google.protobuf.ByteString getBytesF();

        // optional bool boolF = 7;
        /**
         * <code>optional bool boolF = 7;</code>
         */
        boolean hasBoolF();

        /**
         * <code>optional bool boolF = 7;</code>
         */
        boolean getBoolF();
    }

    /**
     * Protobuf type {@code tutorial.Person}
     */
    public static final class Person extends com.google.protobuf.GeneratedMessage implements PersonOrBuilder {
        // Use Person.newBuilder() to construct.
        private Person(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private Person(boolean noInit) {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
        }

        private static final Person defaultInstance;

        public static Person getDefaultInstance() {
            return defaultInstance;
        }

        public Person getDefaultInstanceForType() {
            return defaultInstance;
        }

        private final com.google.protobuf.UnknownFieldSet unknownFields;

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Person(com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet
                    .newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                    case 0:
                        done = true;
                        break;
                    default: {
                        if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                            done = true;
                        }
                        break;
                    }
                    case 10: {
                        bitField0_ |= 0x00000001;
                        name_ = input.readBytes();
                        break;
                    }
                    case 16: {
                        bitField0_ |= 0x00000002;
                        id_ = input.readInt32();
                        break;
                    }
                    case 26: {
                        bitField0_ |= 0x00000004;
                        email_ = input.readBytes();
                        break;
                    }
                    case 33: {
                        bitField0_ |= 0x00000008;
                        doubleF_ = input.readDouble();
                        break;
                    }
                    case 45: {
                        bitField0_ |= 0x00000010;
                        floatF_ = input.readFloat();
                        break;
                    }
                    case 50: {
                        bitField0_ |= 0x00000020;
                        bytesF_ = input.readBytes();
                        break;
                    }
                    case 56: {
                        bitField0_ |= 0x00000040;
                        boolF_ = input.readBool();
                        break;
                    }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_descriptor;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.class,
                            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder.class);
        }

        public static com.google.protobuf.Parser<Person> PARSER = new com.google.protobuf.AbstractParser<Person>() {
            public Person parsePartialFrom(com.google.protobuf.CodedInputStream input,
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
        // required string name = 1;
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
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
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
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object ref = name_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        // required int32 id = 2;
        public static final int ID_FIELD_NUMBER = 2;
        private int id_;

        /**
         * <code>required int32 id = 2;</code>
         * 
         * <pre>
         * Unique ID number for this person.
         * </pre>
         */
        public boolean hasId() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }

        /**
         * <code>required int32 id = 2;</code>
         * 
         * <pre>
         * Unique ID number for this person.
         * </pre>
         */
        public int getId() {
            return id_;
        }

        // optional string email = 3;
        public static final int EMAIL_FIELD_NUMBER = 3;
        private java.lang.Object email_;

        /**
         * <code>optional string email = 3;</code>
         */
        public boolean hasEmail() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }

        /**
         * <code>optional string email = 3;</code>
         */
        public java.lang.String getEmail() {
            java.lang.Object ref = email_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    email_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string email = 3;</code>
         */
        public com.google.protobuf.ByteString getEmailBytes() {
            java.lang.Object ref = email_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                email_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        // optional double doubleF = 4;
        public static final int DOUBLEF_FIELD_NUMBER = 4;
        private double doubleF_;

        /**
         * <code>optional double doubleF = 4;</code>
         */
        public boolean hasDoubleF() {
            return ((bitField0_ & 0x00000008) == 0x00000008);
        }

        /**
         * <code>optional double doubleF = 4;</code>
         */
        public double getDoubleF() {
            return doubleF_;
        }

        // optional float floatF = 5;
        public static final int FLOATF_FIELD_NUMBER = 5;
        private float floatF_;

        /**
         * <code>optional float floatF = 5;</code>
         */
        public boolean hasFloatF() {
            return ((bitField0_ & 0x00000010) == 0x00000010);
        }

        /**
         * <code>optional float floatF = 5;</code>
         */
        public float getFloatF() {
            return floatF_;
        }

        // optional bytes bytesF = 6;
        public static final int BYTESF_FIELD_NUMBER = 6;
        private com.google.protobuf.ByteString bytesF_;

        /**
         * <code>optional bytes bytesF = 6;</code>
         */
        public boolean hasBytesF() {
            return ((bitField0_ & 0x00000020) == 0x00000020);
        }

        /**
         * <code>optional bytes bytesF = 6;</code>
         */
        public com.google.protobuf.ByteString getBytesF() {
            return bytesF_;
        }

        // optional bool boolF = 7;
        public static final int BOOLF_FIELD_NUMBER = 7;
        private boolean boolF_;

        /**
         * <code>optional bool boolF = 7;</code>
         */
        public boolean hasBoolF() {
            return ((bitField0_ & 0x00000040) == 0x00000040);
        }

        /**
         * <code>optional bool boolF = 7;</code>
         */
        public boolean getBoolF() {
            return boolF_;
        }

        private void initFields() {
            name_ = "";
            id_ = 0;
            email_ = "";
            doubleF_ = 0D;
            floatF_ = 0F;
            bytesF_ = com.google.protobuf.ByteString.EMPTY;
            boolF_ = false;
        }

        private byte memoizedIsInitialized = -1;

        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasName()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasId()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
            getSerializedSize();
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeBytes(1, getNameBytes());
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeInt32(2, id_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeBytes(3, getEmailBytes());
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                output.writeDouble(4, doubleF_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                output.writeFloat(5, floatF_);
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                output.writeBytes(6, bytesF_);
            }
            if (((bitField0_ & 0x00000040) == 0x00000040)) {
                output.writeBool(7, boolF_);
            }
            getUnknownFields().writeTo(output);
        }

        private int memoizedSerializedSize = -1;

        public int getSerializedSize() {
            int size = memoizedSerializedSize;
            // if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream.computeBytesSize(1, getNameBytes());
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, id_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream.computeBytesSize(3, getEmailBytes());
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                size += com.google.protobuf.CodedOutputStream.computeDoubleSize(4, doubleF_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                size += com.google.protobuf.CodedOutputStream.computeFloatSize(5, floatF_);
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                size += com.google.protobuf.CodedOutputStream.computeBytesSize(6, bytesF_);
            }
            if (((bitField0_ & 0x00000040) == 0x00000040)) {
                size += com.google.protobuf.CodedOutputStream.computeBoolSize(7, boolF_);
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;

        @java.lang.Override
        protected java.lang.Object writeReplace() throws java.io.ObjectStreamException {
            return super.writeReplace();
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseDelimitedFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code tutorial.Person}
         */
        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_descriptor;
            }

            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.class,
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder.class);
            }

            // Construct using
            // com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
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
                name_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                id_ = 0;
                bitField0_ = (bitField0_ & ~0x00000002);
                email_ = "";
                bitField0_ = (bitField0_ & ~0x00000004);
                doubleF_ = 0D;
                bitField0_ = (bitField0_ & ~0x00000008);
                floatF_ = 0F;
                bitField0_ = (bitField0_ & ~0x00000010);
                bytesF_ = com.google.protobuf.ByteString.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000020);
                boolF_ = false;
                bitField0_ = (bitField0_ & ~0x00000040);
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_descriptor;
            }

            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person getDefaultInstanceForType() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.getDefaultInstance();
            }

            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person build() {
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person buildPartial() {
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person result;
                result = new com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person(
                        this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.name_ = name_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.id_ = id_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.email_ = email_;
                if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
                    to_bitField0_ |= 0x00000008;
                }
                result.doubleF_ = doubleF_;
                if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.floatF_ = floatF_;
                if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
                    to_bitField0_ |= 0x00000020;
                }
                result.bytesF_ = bytesF_;
                if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
                    to_bitField0_ |= 0x00000040;
                }
                result.boolF_ = boolF_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person) {
                    return mergeFrom((com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person other) {
                if (other == com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.getDefaultInstance())
                    return this;
                if (other.hasName()) {
                    bitField0_ |= 0x00000001;
                    name_ = other.name_;
                    onChanged();
                }
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasEmail()) {
                    bitField0_ |= 0x00000004;
                    email_ = other.email_;
                    onChanged();
                }
                if (other.hasDoubleF()) {
                    setDoubleF(other.getDoubleF());
                }
                if (other.hasFloatF()) {
                    setFloatF(other.getFloatF());
                }
                if (other.hasBytesF()) {
                    setBytesF(other.getBytesF());
                }
                if (other.hasBoolF()) {
                    setBoolF(other.getBoolF());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasName()) {

                    return false;
                }
                if (!hasId()) {

                    return false;
                }
                return true;
            }

            public Builder mergeFrom(com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person) e
                            .getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            // required string name = 1;
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
                    java.lang.String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
                    name_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>required string name = 1;</code>
             */
            public com.google.protobuf.ByteString getNameBytes() {
                java.lang.Object ref = name_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b = com.google.protobuf.ByteString
                            .copyFromUtf8((java.lang.String) ref);
                    name_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>required string name = 1;</code>
             */
            public Builder setName(java.lang.String value) {
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
            public Builder setNameBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }

            // required int32 id = 2;
            private int id_;

            /**
             * <code>required int32 id = 2;</code>
             * 
             * <pre>
             * Unique ID number for this person.
             * </pre>
             */
            public boolean hasId() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }

            /**
             * <code>required int32 id = 2;</code>
             * 
             * <pre>
             * Unique ID number for this person.
             * </pre>
             */
            public int getId() {
                return id_;
            }

            /**
             * <code>required int32 id = 2;</code>
             * 
             * <pre>
             * Unique ID number for this person.
             * </pre>
             */
            public Builder setId(int value) {
                bitField0_ |= 0x00000002;
                id_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>required int32 id = 2;</code>
             * 
             * <pre>
             * Unique ID number for this person.
             * </pre>
             */
            public Builder clearId() {
                bitField0_ = (bitField0_ & ~0x00000002);
                id_ = 0;
                onChanged();
                return this;
            }

            // optional string email = 3;
            private java.lang.Object email_ = "";

            /**
             * <code>optional string email = 3;</code>
             */
            public boolean hasEmail() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }

            /**
             * <code>optional string email = 3;</code>
             */
            public java.lang.String getEmail() {
                java.lang.Object ref = email_;
                if (!(ref instanceof java.lang.String)) {
                    java.lang.String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
                    email_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>optional string email = 3;</code>
             */
            public com.google.protobuf.ByteString getEmailBytes() {
                java.lang.Object ref = email_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b = com.google.protobuf.ByteString
                            .copyFromUtf8((java.lang.String) ref);
                    email_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string email = 3;</code>
             */
            public Builder setEmail(java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                email_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string email = 3;</code>
             */
            public Builder clearEmail() {
                bitField0_ = (bitField0_ & ~0x00000004);
                email_ = getDefaultInstance().getEmail();
                onChanged();
                return this;
            }

            /**
             * <code>optional string email = 3;</code>
             */
            public Builder setEmailBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                email_ = value;
                onChanged();
                return this;
            }

            // optional double doubleF = 4;
            private double doubleF_;

            /**
             * <code>optional double doubleF = 4;</code>
             */
            public boolean hasDoubleF() {
                return ((bitField0_ & 0x00000008) == 0x00000008);
            }

            /**
             * <code>optional double doubleF = 4;</code>
             */
            public double getDoubleF() {
                return doubleF_;
            }

            /**
             * <code>optional double doubleF = 4;</code>
             */
            public Builder setDoubleF(double value) {
                bitField0_ |= 0x00000008;
                doubleF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional double doubleF = 4;</code>
             */
            public Builder clearDoubleF() {
                bitField0_ = (bitField0_ & ~0x00000008);
                doubleF_ = 0D;
                onChanged();
                return this;
            }

            // optional float floatF = 5;
            private float floatF_;

            /**
             * <code>optional float floatF = 5;</code>
             */
            public boolean hasFloatF() {
                return ((bitField0_ & 0x00000010) == 0x00000010);
            }

            /**
             * <code>optional float floatF = 5;</code>
             */
            public float getFloatF() {
                return floatF_;
            }

            /**
             * <code>optional float floatF = 5;</code>
             */
            public Builder setFloatF(float value) {
                bitField0_ |= 0x00000010;
                floatF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional float floatF = 5;</code>
             */
            public Builder clearFloatF() {
                bitField0_ = (bitField0_ & ~0x00000010);
                floatF_ = 0F;
                onChanged();
                return this;
            }

            // optional bytes bytesF = 6;
            private com.google.protobuf.ByteString bytesF_ = com.google.protobuf.ByteString.EMPTY;

            /**
             * <code>optional bytes bytesF = 6;</code>
             */
            public boolean hasBytesF() {
                return ((bitField0_ & 0x00000020) == 0x00000020);
            }

            /**
             * <code>optional bytes bytesF = 6;</code>
             */
            public com.google.protobuf.ByteString getBytesF() {
                return bytesF_;
            }

            /**
             * <code>optional bytes bytesF = 6;</code>
             */
            public Builder setBytesF(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                bytesF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional bytes bytesF = 6;</code>
             */
            public Builder clearBytesF() {
                bitField0_ = (bitField0_ & ~0x00000020);
                bytesF_ = getDefaultInstance().getBytesF();
                onChanged();
                return this;
            }

            // optional bool boolF = 7;
            private boolean boolF_;

            /**
             * <code>optional bool boolF = 7;</code>
             */
            public boolean hasBoolF() {
                return ((bitField0_ & 0x00000040) == 0x00000040);
            }

            /**
             * <code>optional bool boolF = 7;</code>
             */
            public boolean getBoolF() {
                return boolF_;
            }

            /**
             * <code>optional bool boolF = 7;</code>
             */
            public Builder setBoolF(boolean value) {
                bitField0_ |= 0x00000040;
                boolF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional bool boolF = 7;</code>
             */
            public Builder clearBoolF() {
                bitField0_ = (bitField0_ & ~0x00000040);
                boolF_ = false;
                onChanged();
                return this;
            }

            // @@protoc_insertion_point(builder_scope:tutorial.Person)
        }

        static {
            defaultInstance = new Person(true);
            defaultInstance.initFields();
        }

        // @@protoc_insertion_point(class_scope:tutorial.Person)
    }

    public interface AddressBookOrBuilder extends com.google.protobuf.MessageOrBuilder {

        // optional .tutorial.Person person = 1;
        /**
         * <code>optional .tutorial.Person person = 1;</code>
         */
        boolean hasPerson();

        /**
         * <code>optional .tutorial.Person person = 1;</code>
         */
        com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person getPerson();

        /**
         * <code>optional .tutorial.Person person = 1;</code>
         */
        com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder getPersonOrBuilder();
    }

    /**
     * Protobuf type {@code tutorial.AddressBook}
     * 
     * <pre>
     * Our address book file is just one of these.
     * </pre>
     */
    public static final class AddressBook extends com.google.protobuf.GeneratedMessage implements AddressBookOrBuilder {
        // Use AddressBook.newBuilder() to construct.
        private AddressBook(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private AddressBook(boolean noInit) {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
        }

        private static final AddressBook defaultInstance;

        public static AddressBook getDefaultInstance() {
            return defaultInstance;
        }

        public AddressBook getDefaultInstanceForType() {
            return defaultInstance;
        }

        private final com.google.protobuf.UnknownFieldSet unknownFields;

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AddressBook(com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet
                    .newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                    case 0:
                        done = true;
                        break;
                    default: {
                        if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                            done = true;
                        }
                        break;
                    }
                    case 10: {
                        com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder subBuilder = null;
                        if (((bitField0_ & 0x00000001) == 0x00000001)) {
                            subBuilder = person_.toBuilder();
                        }
                        person_ = input.readMessage(
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.PARSER,
                                extensionRegistry);
                        if (subBuilder != null) {
                            subBuilder.mergeFrom(person_);
                            person_ = subBuilder.buildPartial();
                        }
                        bitField0_ |= 0x00000001;
                        break;
                    }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_descriptor;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.class,
                            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.Builder.class);
        }

        public static com.google.protobuf.Parser<AddressBook> PARSER = new com.google.protobuf.AbstractParser<AddressBook>() {
            public AddressBook parsePartialFrom(com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
                return new AddressBook(input, extensionRegistry);
            }
        };

        @java.lang.Override
        public com.google.protobuf.Parser<AddressBook> getParserForType() {
            return PARSER;
        }

        private int bitField0_;
        // optional .tutorial.Person person = 1;
        public static final int PERSON_FIELD_NUMBER = 1;
        private com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person person_;

        /**
         * <code>optional .tutorial.Person person = 1;</code>
         */
        public boolean hasPerson() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }

        /**
         * <code>optional .tutorial.Person person = 1;</code>
         */
        public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person getPerson() {
            return person_;
        }

        /**
         * <code>optional .tutorial.Person person = 1;</code>
         */
        public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder getPersonOrBuilder() {
            return person_;
        }

        private void initFields() {
            person_ = com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.getDefaultInstance();
        }

        private byte memoizedIsInitialized = -1;

        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (hasPerson()) {
                if (!getPerson().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
            getSerializedSize();
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeMessage(1, person_);
            }
            getUnknownFields().writeTo(output);
        }

        private int memoizedSerializedSize = -1;

        public int getSerializedSize() {
            int size = memoizedSerializedSize;
            // if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, person_);
            }
            size += getUnknownFields().getSerializedSize();
            memoizedSerializedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;

        @java.lang.Override
        protected java.lang.Object writeReplace() throws java.io.ObjectStreamException {
            return super.writeReplace();
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseDelimitedFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code tutorial.AddressBook}
         * 
         * <pre>
         * Our address book file is just one of these.
         * </pre>
         */
        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBookOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_descriptor;
            }

            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.class,
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.Builder.class);
            }

            // Construct using
            // com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
                    getPersonFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (personBuilder_ == null) {
                    person_ = com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.getDefaultInstance();
                } else {
                    personBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_descriptor;
            }

            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook getDefaultInstanceForType() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.getDefaultInstance();
            }

            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook build() {
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook buildPartial() {
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook result;
                result = new com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook(
                        this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                if (personBuilder_ == null) {
                    result.person_ = person_;
                } else {
                    result.person_ = personBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook) {
                    return mergeFrom((com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook other) {
                if (other == com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.getDefaultInstance())
                    return this;
                if (other.hasPerson()) {
                    mergePerson(other.getPerson());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (hasPerson()) {
                    if (!getPerson().isInitialized()) {

                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook) e
                            .getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            // optional .tutorial.Person person = 1;
            private com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person person_ = com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person
                    .getDefaultInstance();
            private com.google.protobuf.SingleFieldBuilder<com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person, com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder, com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder> personBuilder_;

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            public boolean hasPerson() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person getPerson() {
                if (personBuilder_ == null) {
                    return person_;
                } else {
                    return personBuilder_.getMessage();
                }
            }

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            public Builder setPerson(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person value) {
                if (personBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    person_ = value;
                    onChanged();
                } else {
                    personBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            public Builder setPerson(
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder builderForValue) {
                if (personBuilder_ == null) {
                    person_ = builderForValue.build();
                    onChanged();
                } else {
                    personBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            public Builder mergePerson(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person value) {
                if (personBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) == 0x00000001)
                            && person_ != com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person
                                    .getDefaultInstance()) {
                        person_ = com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.newBuilder(person_)
                                .mergeFrom(value).buildPartial();
                    } else {
                        person_ = value;
                    }
                    onChanged();
                } else {
                    personBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            public Builder clearPerson() {
                if (personBuilder_ == null) {
                    person_ = com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.getDefaultInstance();
                    onChanged();
                } else {
                    personBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                return this;
            }

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder getPersonBuilder() {
                bitField0_ |= 0x00000001;
                onChanged();
                return getPersonFieldBuilder().getBuilder();
            }

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder getPersonOrBuilder() {
                if (personBuilder_ != null) {
                    return personBuilder_.getMessageOrBuilder();
                } else {
                    return person_;
                }
            }

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             */
            private com.google.protobuf.SingleFieldBuilder<com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person, com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder, com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder> getPersonFieldBuilder() {
                if (personBuilder_ == null) {
                    personBuilder_ = new com.google.protobuf.SingleFieldBuilder<com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person, com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder, com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder>(
                            person_, getParentForChildren(), isClean());
                    person_ = null;
                }
                return personBuilder_;
            }

            // @@protoc_insertion_point(builder_scope:tutorial.AddressBook)
        }

        static {
            defaultInstance = new AddressBook(true);
            defaultInstance.initFields();
        }

        // @@protoc_insertion_point(class_scope:tutorial.AddressBook)
    }

    private static com.google.protobuf.Descriptors.Descriptor internal_static_tutorial_Person_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_tutorial_Person_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.Descriptor internal_static_tutorial_AddressBook_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_tutorial_AddressBook_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
    static {
        java.lang.String[] descriptorData = { "\n\rqiantao.proto\022\010tutorial\"q\n\006Person\022\014\n\004n"
                + "ame\030\001 \002(\t\022\n\n\002id\030\002 \002(\005\022\r\n\005email\030\003 \001(\t\022\017\n\007"
                + "doubleF\030\004 \001(\001\022\016\n\006floatF\030\005 \001(\002\022\016\n\006bytesF\030"
                + "\006 \001(\014\022\r\n\005boolF\030\007 \001(\010\"/\n\013AddressBook\022 \n\006p"
                + "erson\030\001 \001(\0132\020.tutorial.PersonB<\n\'com.bai"
                + "du.bjf.remoting.protobuf.complexB\021Addres" + "sBookProtos" };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public com.google.protobuf.ExtensionRegistry assignDescriptors(
                com.google.protobuf.Descriptors.FileDescriptor root) {
                descriptor = root;
                internal_static_tutorial_Person_descriptor = getDescriptor().getMessageTypes().get(0);
                internal_static_tutorial_Person_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(
                        internal_static_tutorial_Person_descriptor, new java.lang.String[] { "Name", "Id", "Email",
                                "DoubleF", "FloatF", "BytesF", "BoolF", });
                internal_static_tutorial_AddressBook_descriptor = getDescriptor().getMessageTypes().get(1);
                internal_static_tutorial_AddressBook_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(
                        internal_static_tutorial_AddressBook_descriptor, new java.lang.String[] { "Person", });
                return null;
            }
        };
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
                new com.google.protobuf.Descriptors.FileDescriptor[] {}, assigner);
    }

    // @@protoc_insertion_point(outer_class_scope)
}
