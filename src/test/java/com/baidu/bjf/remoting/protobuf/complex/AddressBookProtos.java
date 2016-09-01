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
// source: qiantao.proto

package com.baidu.bjf.remoting.protobuf.complex;

/**
 * The Class AddressBookProtos.
 */
public final class AddressBookProtos {
    
    /**
     * Instantiates a new address book protos.
     */
    private AddressBookProtos() {
    }

    /**
     * Register all extensions.
     *
     * @param registry the registry
     */
    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    }

    /**
     * The Interface PersonOrBuilder.
     */
    public interface PersonOrBuilder extends com.google.protobuf.MessageOrBuilder {

        // required string name = 1;
        /**
         * <code>required string name = 1;</code>.
         *
         * @return true, if successful
         */
        boolean hasName();

        /**
         * Gets the name.
         *
         * @return the name
         */
        java.lang.String getName();

        /**
         * Gets the name bytes.
         *
         * @return the name bytes
         */
        com.google.protobuf.ByteString getNameBytes();

        // required int32 id = 2;
        /**
         * <code>required int32 id = 2;</code>
         * 
         * <pre>
         * Unique ID number for this person.
         * </pre>
         *
         * @return true, if successful
         */
        boolean hasId();

        /**
         * Gets the id.
         *
         * @return the id
         */
        int getId();

        // optional string email = 3;
        /**
         * <code>optional string email = 3;</code>.
         *
         * @return true, if successful
         */
        boolean hasEmail();

        /**
         * Gets the email.
         *
         * @return the email
         */
        java.lang.String getEmail();

        /**
         * Gets the email bytes.
         *
         * @return the email bytes
         */
        com.google.protobuf.ByteString getEmailBytes();

        // optional double doubleF = 4;
        /**
         * <code>optional double doubleF = 4;</code>.
         *
         * @return true, if successful
         */
        boolean hasDoubleF();

        /**
         * Gets the double f.
         *
         * @return the double f
         */
        double getDoubleF();

        // optional float floatF = 5;
        /**
         * <code>optional float floatF = 5;</code>.
         *
         * @return true, if successful
         */
        boolean hasFloatF();

        /**
         * Gets the float f.
         *
         * @return the float f
         */
        float getFloatF();

        // optional bytes bytesF = 6;
        /**
         * <code>optional bytes bytesF = 6;</code>.
         *
         * @return true, if successful
         */
        boolean hasBytesF();

        /**
         * Gets the bytes f.
         *
         * @return the bytes f
         */
        com.google.protobuf.ByteString getBytesF();

        // optional bool boolF = 7;
        /**
         * <code>optional bool boolF = 7;</code>.
         *
         * @return true, if successful
         */
        boolean hasBoolF();

        /**
         * Gets the bool f.
         *
         * @return the bool f
         */
        boolean getBoolF();
    }

    /**
     * Protobuf type {@code tutorial.Person}
     */
    public static final class Person extends com.google.protobuf.GeneratedMessage implements PersonOrBuilder {
        
        /**
         * Instantiates a new person.
         *
         * @param builder the builder
         */
        // Use Person.newBuilder() to construct.
        private Person(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        /**
         * Instantiates a new person.
         *
         * @param noInit the no init
         */
        private Person(boolean noInit) {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
        }

        /** The Constant defaultInstance. */
        private static final Person defaultInstance;

        /**
         * Gets the default instance.
         *
         * @return the default instance
         */
        public static Person getDefaultInstance() {
            return defaultInstance;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
         */
        public Person getDefaultInstanceForType() {
            return defaultInstance;
        }

        /** The unknown fields. */
        private final com.google.protobuf.UnknownFieldSet unknownFields;

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#getUnknownFields()
         */
        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /**
         * Instantiates a new person.
         *
         * @param input the input
         * @param extensionRegistry the extension registry
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
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

        /**
         * Gets the descriptor.
         *
         * @return the descriptor
         */
        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_descriptor;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#internalGetFieldAccessorTable()
         */
        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.class,
                            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder.class);
        }

        /** The parser. */
        public static com.google.protobuf.Parser<Person> PARSER = new com.google.protobuf.AbstractParser<Person>() {
            public Person parsePartialFrom(com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
                return new Person(input, extensionRegistry);
            }
        };

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#getParserForType()
         */
        @java.lang.Override
        public com.google.protobuf.Parser<Person> getParserForType() {
            return PARSER;
        }

        /** The bit field0_. */
        private int bitField0_;
        
        /** The Constant NAME_FIELD_NUMBER. */
        // required string name = 1;
        public static final int NAME_FIELD_NUMBER = 1;
        
        /** The name_. */
        private java.lang.Object name_;

        /**
         * <code>required string name = 1;</code>.
         *
         * @return true, if successful
         */
        public boolean hasName() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getName()
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

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getNameBytes()
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

        /** The Constant ID_FIELD_NUMBER. */
        // required int32 id = 2;
        public static final int ID_FIELD_NUMBER = 2;
        
        /** The id_. */
        private int id_;

        /**
         * <code>required int32 id = 2;</code>
         * 
         * <pre>
         * Unique ID number for this person.
         * </pre>
         *
         * @return true, if successful
         */
        public boolean hasId() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getId()
         */
        public int getId() {
            return id_;
        }

        /** The Constant EMAIL_FIELD_NUMBER. */
        // optional string email = 3;
        public static final int EMAIL_FIELD_NUMBER = 3;
        
        /** The email_. */
        private java.lang.Object email_;

        /**
         * <code>optional string email = 3;</code>.
         *
         * @return true, if successful
         */
        public boolean hasEmail() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getEmail()
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

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getEmailBytes()
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

        /** The Constant DOUBLEF_FIELD_NUMBER. */
        // optional double doubleF = 4;
        public static final int DOUBLEF_FIELD_NUMBER = 4;
        
        /** The double f_. */
        private double doubleF_;

        /**
         * <code>optional double doubleF = 4;</code>.
         *
         * @return true, if successful
         */
        public boolean hasDoubleF() {
            return ((bitField0_ & 0x00000008) == 0x00000008);
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getDoubleF()
         */
        public double getDoubleF() {
            return doubleF_;
        }

        /** The Constant FLOATF_FIELD_NUMBER. */
        // optional float floatF = 5;
        public static final int FLOATF_FIELD_NUMBER = 5;
        
        /** The float f_. */
        private float floatF_;

        /**
         * <code>optional float floatF = 5;</code>.
         *
         * @return true, if successful
         */
        public boolean hasFloatF() {
            return ((bitField0_ & 0x00000010) == 0x00000010);
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getFloatF()
         */
        public float getFloatF() {
            return floatF_;
        }

        /** The Constant BYTESF_FIELD_NUMBER. */
        // optional bytes bytesF = 6;
        public static final int BYTESF_FIELD_NUMBER = 6;
        
        /** The bytes f_. */
        private com.google.protobuf.ByteString bytesF_;

        /**
         * <code>optional bytes bytesF = 6;</code>.
         *
         * @return true, if successful
         */
        public boolean hasBytesF() {
            return ((bitField0_ & 0x00000020) == 0x00000020);
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getBytesF()
         */
        public com.google.protobuf.ByteString getBytesF() {
            return bytesF_;
        }

        /** The Constant BOOLF_FIELD_NUMBER. */
        // optional bool boolF = 7;
        public static final int BOOLF_FIELD_NUMBER = 7;
        
        /** The bool f_. */
        private boolean boolF_;

        /**
         * <code>optional bool boolF = 7;</code>.
         *
         * @return true, if successful
         */
        public boolean hasBoolF() {
            return ((bitField0_ & 0x00000040) == 0x00000040);
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getBoolF()
         */
        public boolean getBoolF() {
            return boolF_;
        }

        /**
         * Inits the fields.
         */
        private void initFields() {
            name_ = "";
            id_ = 0;
            email_ = "";
            doubleF_ = 0D;
            floatF_ = 0F;
            bytesF_ = com.google.protobuf.ByteString.EMPTY;
            boolF_ = false;
        }

        /** The memoized is initialized. */
        private byte memoizedIsInitialized = -1;

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#isInitialized()
         */
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

        /* (non-Javadoc)
         * @see com.google.protobuf.AbstractMessage#writeTo(com.google.protobuf.CodedOutputStream)
         */
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

        /** The memoized serialized size. */
        private int memoizedSerializedSize = -1;

        /* (non-Javadoc)
         * @see com.google.protobuf.AbstractMessage#getSerializedSize()
         */
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

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 0L;

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#writeReplace()
         */
        @java.lang.Override
        protected java.lang.Object writeReplace() throws java.io.ObjectStreamException {
            return super.writeReplace();
        }

        /**
         * Parses the from.
         *
         * @param data the data
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        /**
         * Parses the from.
         *
         * @param data the data
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        /**
         * Parses the from.
         *
         * @param data the data
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        /**
         * Parses the from.
         *
         * @param data the data
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        /**
         * Parses the from.
         *
         * @param input the input
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        /**
         * Parses the from.
         *
         * @param input the input
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        /**
         * Parses the delimited from.
         *
         * @param input the input
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseDelimitedFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        /**
         * Parses the delimited from.
         *
         * @param input the input
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        /**
         * Parses the from.
         *
         * @param input the input
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        /**
         * Parses the from.
         *
         * @param input the input
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. person
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person parseFrom(
            com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        /**
         * New builder.
         *
         * @return the builder
         */
        public static Builder newBuilder() {
            return Builder.create();
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLite#newBuilderForType()
         */
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /**
         * New builder.
         *
         * @param prototype the prototype
         * @return the builder
         */
        public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLite#toBuilder()
         */
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent)
         */
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
            
            /**
             * Gets the descriptor.
             *
             * @return the descriptor
             */
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_descriptor;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.GeneratedMessage.Builder#internalGetFieldAccessorTable()
             */
            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.class,
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder.class);
            }

            // Construct using
            /**
             * Instantiates a new builder.
             */
            // com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            /**
             * Instantiates a new builder.
             *
             * @param parent the parent
             */
            private Builder(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
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

            /* (non-Javadoc)
             * @see com.google.protobuf.GeneratedMessage.Builder#clone()
             */
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.GeneratedMessage.Builder#getDescriptorForType()
             */
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_Person_descriptor;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person getDefaultInstanceForType() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.getDefaultInstance();
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.MessageLite.Builder#build()
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person build() {
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.MessageLite.Builder#buildPartial()
             */
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

            /* (non-Javadoc)
             * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.Message)
             */
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person) {
                    return mergeFrom((com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person) other);
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

            /* (non-Javadoc)
             * @see com.google.protobuf.GeneratedMessage.Builder#isInitialized()
             */
            public final boolean isInitialized() {
                if (!hasName()) {

                    return false;
                }
                if (!hasId()) {

                    return false;
                }
                return true;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite)
             */
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

            /** The bit field0_. */
            private int bitField0_;

            /** The name_. */
            // required string name = 1;
            private java.lang.Object name_ = "";

            /**
             * <code>required string name = 1;</code>.
             *
             * @return true, if successful
             */
            public boolean hasName() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getName()
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

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getNameBytes()
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
             * <code>required string name = 1;</code>.
             *
             * @param value the value
             * @return the builder
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
             * <code>required string name = 1;</code>.
             *
             * @return the builder
             */
            public Builder clearName() {
                bitField0_ = (bitField0_ & ~0x00000001);
                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /**
             * <code>required string name = 1;</code>.
             *
             * @param value the value
             * @return the builder
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

            /** The id_. */
            // required int32 id = 2;
            private int id_;

            /**
             * <code>required int32 id = 2;</code>
             * 
             * <pre>
             * Unique ID number for this person.
             * </pre>
             *
             * @return true, if successful
             */
            public boolean hasId() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getId()
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
             *
             * @param value the value
             * @return the builder
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
             *
             * @return the builder
             */
            public Builder clearId() {
                bitField0_ = (bitField0_ & ~0x00000002);
                id_ = 0;
                onChanged();
                return this;
            }

            /** The email_. */
            // optional string email = 3;
            private java.lang.Object email_ = "";

            /**
             * <code>optional string email = 3;</code>.
             *
             * @return true, if successful
             */
            public boolean hasEmail() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getEmail()
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

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getEmailBytes()
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
             * <code>optional string email = 3;</code>.
             *
             * @param value the value
             * @return the builder
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
             * <code>optional string email = 3;</code>.
             *
             * @return the builder
             */
            public Builder clearEmail() {
                bitField0_ = (bitField0_ & ~0x00000004);
                email_ = getDefaultInstance().getEmail();
                onChanged();
                return this;
            }

            /**
             * <code>optional string email = 3;</code>.
             *
             * @param value the value
             * @return the builder
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

            /** The double f_. */
            // optional double doubleF = 4;
            private double doubleF_;

            /**
             * <code>optional double doubleF = 4;</code>.
             *
             * @return true, if successful
             */
            public boolean hasDoubleF() {
                return ((bitField0_ & 0x00000008) == 0x00000008);
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getDoubleF()
             */
            public double getDoubleF() {
                return doubleF_;
            }

            /**
             * <code>optional double doubleF = 4;</code>.
             *
             * @param value the value
             * @return the builder
             */
            public Builder setDoubleF(double value) {
                bitField0_ |= 0x00000008;
                doubleF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional double doubleF = 4;</code>.
             *
             * @return the builder
             */
            public Builder clearDoubleF() {
                bitField0_ = (bitField0_ & ~0x00000008);
                doubleF_ = 0D;
                onChanged();
                return this;
            }

            /** The float f_. */
            // optional float floatF = 5;
            private float floatF_;

            /**
             * <code>optional float floatF = 5;</code>.
             *
             * @return true, if successful
             */
            public boolean hasFloatF() {
                return ((bitField0_ & 0x00000010) == 0x00000010);
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getFloatF()
             */
            public float getFloatF() {
                return floatF_;
            }

            /**
             * <code>optional float floatF = 5;</code>.
             *
             * @param value the value
             * @return the builder
             */
            public Builder setFloatF(float value) {
                bitField0_ |= 0x00000010;
                floatF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional float floatF = 5;</code>.
             *
             * @return the builder
             */
            public Builder clearFloatF() {
                bitField0_ = (bitField0_ & ~0x00000010);
                floatF_ = 0F;
                onChanged();
                return this;
            }

            /** The bytes f_. */
            // optional bytes bytesF = 6;
            private com.google.protobuf.ByteString bytesF_ = com.google.protobuf.ByteString.EMPTY;

            /**
             * <code>optional bytes bytesF = 6;</code>.
             *
             * @return true, if successful
             */
            public boolean hasBytesF() {
                return ((bitField0_ & 0x00000020) == 0x00000020);
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getBytesF()
             */
            public com.google.protobuf.ByteString getBytesF() {
                return bytesF_;
            }

            /**
             * <code>optional bytes bytesF = 6;</code>.
             *
             * @param value the value
             * @return the builder
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
             * <code>optional bytes bytesF = 6;</code>.
             *
             * @return the builder
             */
            public Builder clearBytesF() {
                bitField0_ = (bitField0_ & ~0x00000020);
                bytesF_ = getDefaultInstance().getBytesF();
                onChanged();
                return this;
            }

            /** The bool f_. */
            // optional bool boolF = 7;
            private boolean boolF_;

            /**
             * <code>optional bool boolF = 7;</code>.
             *
             * @return true, if successful
             */
            public boolean hasBoolF() {
                return ((bitField0_ & 0x00000040) == 0x00000040);
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder#getBoolF()
             */
            public boolean getBoolF() {
                return boolF_;
            }

            /**
             * <code>optional bool boolF = 7;</code>.
             *
             * @param value the value
             * @return the builder
             */
            public Builder setBoolF(boolean value) {
                bitField0_ |= 0x00000040;
                boolF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional bool boolF = 7;</code>.
             *
             * @return the builder
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

    /**
     * The Interface AddressBookOrBuilder.
     */
    public interface AddressBookOrBuilder extends com.google.protobuf.MessageOrBuilder {

        // optional .tutorial.Person person = 1;
        /**
         * <code>optional .tutorial.Person person = 1;</code>
         *
         * @return true, if successful
         */
        boolean hasPerson();

        /**
         * Gets the person.
         *
         * @return the person
         */
        com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person getPerson();

        /**
         * Gets the person or builder.
         *
         * @return the person or builder
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
        
        /**
         * Instantiates a new address book.
         *
         * @param builder the builder
         */
        // Use AddressBook.newBuilder() to construct.
        private AddressBook(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        /**
         * Instantiates a new address book.
         *
         * @param noInit the no init
         */
        private AddressBook(boolean noInit) {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
        }

        /** The Constant defaultInstance. */
        private static final AddressBook defaultInstance;

        /**
         * Gets the default instance.
         *
         * @return the default instance
         */
        public static AddressBook getDefaultInstance() {
            return defaultInstance;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
         */
        public AddressBook getDefaultInstanceForType() {
            return defaultInstance;
        }

        /** The unknown fields. */
        private final com.google.protobuf.UnknownFieldSet unknownFields;

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#getUnknownFields()
         */
        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /**
         * Instantiates a new address book.
         *
         * @param input the input
         * @param extensionRegistry the extension registry
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
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

        /**
         * Gets the descriptor.
         *
         * @return the descriptor
         */
        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_descriptor;
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#internalGetFieldAccessorTable()
         */
        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.class,
                            com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.Builder.class);
        }

        /** The parser. */
        public static com.google.protobuf.Parser<AddressBook> PARSER = new com.google.protobuf.AbstractParser<AddressBook>() {
            public AddressBook parsePartialFrom(com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
                return new AddressBook(input, extensionRegistry);
            }
        };

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#getParserForType()
         */
        @java.lang.Override
        public com.google.protobuf.Parser<AddressBook> getParserForType() {
            return PARSER;
        }

        /** The bit field0_. */
        private int bitField0_;
        
        /** The Constant PERSON_FIELD_NUMBER. */
        // optional .tutorial.Person person = 1;
        public static final int PERSON_FIELD_NUMBER = 1;
        
        /** The person_. */
        private com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person person_;

        /**
         * <code>optional .tutorial.Person person = 1;</code>
         *
         * @return true, if successful
         */
        public boolean hasPerson() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBookOrBuilder#getPerson()
         */
        public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person getPerson() {
            return person_;
        }

        /* (non-Javadoc)
         * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBookOrBuilder#getPersonOrBuilder()
         */
        public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder getPersonOrBuilder() {
            return person_;
        }

        /**
         * Inits the fields.
         */
        private void initFields() {
            person_ = com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.getDefaultInstance();
        }

        /** The memoized is initialized. */
        private byte memoizedIsInitialized = -1;

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#isInitialized()
         */
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

        /* (non-Javadoc)
         * @see com.google.protobuf.AbstractMessage#writeTo(com.google.protobuf.CodedOutputStream)
         */
        public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
            getSerializedSize();
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeMessage(1, person_);
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
            // if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, person_);
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
        protected java.lang.Object writeReplace() throws java.io.ObjectStreamException {
            return super.writeReplace();
        }

        /**
         * Parses the from.
         *
         * @param data the data
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        /**
         * Parses the from.
         *
         * @param data the data
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        /**
         * Parses the from.
         *
         * @param data the data
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        /**
         * Parses the from.
         *
         * @param data the data
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws InvalidProtocolBufferException the invalid protocol buffer exception
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        /**
         * Parses the from.
         *
         * @param input the input
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        /**
         * Parses the from.
         *
         * @param input the input
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        /**
         * Parses the delimited from.
         *
         * @param input the input
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseDelimitedFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        /**
         * Parses the delimited from.
         *
         * @param input the input
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        /**
         * Parses the from.
         *
         * @param input the input
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        /**
         * Parses the from.
         *
         * @param input the input
         * @param extensionRegistry the extension registry
         * @return the com.baidu.bjf.remoting.protobuf.complex. address book protos. address book
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public static com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook parseFrom(
            com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        /**
         * New builder.
         *
         * @return the builder
         */
        public static Builder newBuilder() {
            return Builder.create();
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLite#newBuilderForType()
         */
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /**
         * New builder.
         *
         * @param prototype the prototype
         * @return the builder
         */
        public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.MessageLite#toBuilder()
         */
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* (non-Javadoc)
         * @see com.google.protobuf.GeneratedMessage#newBuilderForType(com.google.protobuf.GeneratedMessage.BuilderParent)
         */
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
            
            /**
             * Gets the descriptor.
             *
             * @return the descriptor
             */
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_descriptor;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.GeneratedMessage.Builder#internalGetFieldAccessorTable()
             */
            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.class,
                                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.Builder.class);
            }

            // Construct using
            /**
             * Instantiates a new builder.
             */
            // com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            /**
             * Instantiates a new builder.
             *
             * @param parent the parent
             */
            private Builder(com.google.protobuf.GeneratedMessage.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            /**
             * Maybe force builder initialization.
             */
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
                    getPersonFieldBuilder();
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
                if (personBuilder_ == null) {
                    person_ = com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.getDefaultInstance();
                } else {
                    personBuilder_.clear();
                }
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
            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.internal_static_tutorial_AddressBook_descriptor;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.MessageLiteOrBuilder#getDefaultInstanceForType()
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook getDefaultInstanceForType() {
                return com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.getDefaultInstance();
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.MessageLite.Builder#build()
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook build() {
                com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.MessageLite.Builder#buildPartial()
             */
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

            /* (non-Javadoc)
             * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.Message)
             */
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook) {
                    return mergeFrom((com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook) other);
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
            public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook other) {
                if (other == com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBook.getDefaultInstance())
                    return this;
                if (other.hasPerson()) {
                    mergePerson(other.getPerson());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.GeneratedMessage.Builder#isInitialized()
             */
            public final boolean isInitialized() {
                if (hasPerson()) {
                    if (!getPerson().isInitialized()) {

                        return false;
                    }
                }
                return true;
            }

            /* (non-Javadoc)
             * @see com.google.protobuf.AbstractMessage.Builder#mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite)
             */
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

            /** The bit field0_. */
            private int bitField0_;

            /** The person_. */
            // optional .tutorial.Person person = 1;
            private com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person person_ = com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person
                    .getDefaultInstance();
            
            /** The person builder_. */
            private com.google.protobuf.SingleFieldBuilder<com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person, com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder, com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder> personBuilder_;

            /**
             * <code>optional .tutorial.Person person = 1;</code>
             *
             * @return true, if successful
             */
            public boolean hasPerson() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBookOrBuilder#getPerson()
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
             *
             * @param value the value
             * @return the builder
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
             *
             * @param builderForValue the builder for value
             * @return the builder
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
             *
             * @param value the value
             * @return the builder
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
             *
             * @return the builder
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
             * Gets the person builder.
             *
             * @return the person builder
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.Person.Builder getPersonBuilder() {
                bitField0_ |= 0x00000001;
                onChanged();
                return getPersonFieldBuilder().getBuilder();
            }

            /* (non-Javadoc)
             * @see com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.AddressBookOrBuilder#getPersonOrBuilder()
             */
            public com.baidu.bjf.remoting.protobuf.complex.AddressBookProtos.PersonOrBuilder getPersonOrBuilder() {
                if (personBuilder_ != null) {
                    return personBuilder_.getMessageOrBuilder();
                } else {
                    return person_;
                }
            }

            /**
             * Gets the person field builder.
             *
             * @return the person field builder
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

    /** The internal_static_tutorial_ person_descriptor. */
    private static com.google.protobuf.Descriptors.Descriptor internal_static_tutorial_Person_descriptor;
    
    /** The internal_static_tutorial_ person_field accessor table. */
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_tutorial_Person_fieldAccessorTable;
    
    /** The internal_static_tutorial_ address book_descriptor. */
    private static com.google.protobuf.Descriptors.Descriptor internal_static_tutorial_AddressBook_descriptor;
    
    /** The internal_static_tutorial_ address book_field accessor table. */
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_tutorial_AddressBook_fieldAccessorTable;

    /**
     * Gets the descriptor.
     *
     * @return the descriptor
     */
    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    /** The descriptor. */
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
