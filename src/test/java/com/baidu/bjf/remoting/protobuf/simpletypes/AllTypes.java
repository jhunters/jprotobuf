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
// source: alltypes.proto

package com.baidu.bjf.remoting.protobuf.simpletypes;

public final class AllTypes {
    private AllTypes() {
    }

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    }

    public interface InterClassNameOrBuilder extends com.google.protobuf.MessageOrBuilder {

        // optional double doubleF = 1;
        /**
         * <code>optional double doubleF = 1;</code>
         */
        boolean hasDoubleF();

        /**
         * <code>optional double doubleF = 1;</code>
         */
        double getDoubleF();

        // optional float floatF = 2;
        /**
         * <code>optional float floatF = 2;</code>
         */
        boolean hasFloatF();

        /**
         * <code>optional float floatF = 2;</code>
         */
        float getFloatF();

        // optional int32 int32F = 3;
        /**
         * <code>optional int32 int32F = 3;</code>
         */
        boolean hasInt32F();

        /**
         * <code>optional int32 int32F = 3;</code>
         */
        int getInt32F();

        // optional int64 int64F = 4;
        /**
         * <code>optional int64 int64F = 4;</code>
         */
        boolean hasInt64F();

        /**
         * <code>optional int64 int64F = 4;</code>
         */
        long getInt64F();

        // optional uint32 uint32F = 5;
        /**
         * <code>optional uint32 uint32F = 5;</code>
         */
        boolean hasUint32F();

        /**
         * <code>optional uint32 uint32F = 5;</code>
         */
        int getUint32F();

        // optional uint64 uint64F = 6;
        /**
         * <code>optional uint64 uint64F = 6;</code>
         */
        boolean hasUint64F();

        /**
         * <code>optional uint64 uint64F = 6;</code>
         */
        long getUint64F();

        // optional sint32 sint32F = 7;
        /**
         * <code>optional sint32 sint32F = 7;</code>
         */
        boolean hasSint32F();

        /**
         * <code>optional sint32 sint32F = 7;</code>
         */
        int getSint32F();

        // optional sint64 sint64F = 8;
        /**
         * <code>optional sint64 sint64F = 8;</code>
         */
        boolean hasSint64F();

        /**
         * <code>optional sint64 sint64F = 8;</code>
         */
        long getSint64F();

        // optional fixed32 fixed32F = 9;
        /**
         * <code>optional fixed32 fixed32F = 9;</code>
         */
        boolean hasFixed32F();

        /**
         * <code>optional fixed32 fixed32F = 9;</code>
         */
        int getFixed32F();

        // optional fixed64 fixed64F = 10;
        /**
         * <code>optional fixed64 fixed64F = 10;</code>
         */
        boolean hasFixed64F();

        /**
         * <code>optional fixed64 fixed64F = 10;</code>
         */
        long getFixed64F();

        // optional sfixed32 sfixed32F = 11;
        /**
         * <code>optional sfixed32 sfixed32F = 11;</code>
         */
        boolean hasSfixed32F();

        /**
         * <code>optional sfixed32 sfixed32F = 11;</code>
         */
        int getSfixed32F();

        // optional sfixed64 sfixed64F = 12;
        /**
         * <code>optional sfixed64 sfixed64F = 12;</code>
         */
        boolean hasSfixed64F();

        /**
         * <code>optional sfixed64 sfixed64F = 12;</code>
         */
        long getSfixed64F();

        // optional bool boolF = 13;
        /**
         * <code>optional bool boolF = 13;</code>
         */
        boolean hasBoolF();

        /**
         * <code>optional bool boolF = 13;</code>
         */
        boolean getBoolF();

        // optional string stringF = 14;
        /**
         * <code>optional string stringF = 14;</code>
         */
        boolean hasStringF();

        /**
         * <code>optional string stringF = 14;</code>
         */
        java.lang.String getStringF();

        /**
         * <code>optional string stringF = 14;</code>
         */
        com.google.protobuf.ByteString getStringFBytes();

        // optional bytes bytesF = 15;
        /**
         * <code>optional bytes bytesF = 15;</code>
         */
        boolean hasBytesF();

        /**
         * <code>optional bytes bytesF = 15;</code>
         */
        com.google.protobuf.ByteString getBytesF();

        // optional .pkg.InterClassName.TypeDef enumT = 16;
        /**
         * <code>optional .pkg.InterClassName.TypeDef enumT = 16;</code>
         */
        boolean hasEnumT();

        /**
         * <code>optional .pkg.InterClassName.TypeDef enumT = 16;</code>
         */
        com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef getEnumT();
    }

    /**
     * Protobuf type {@code pkg.InterClassName}
     */
    public static final class InterClassName extends com.google.protobuf.GeneratedMessage implements
        InterClassNameOrBuilder {
        // Use InterClassName.newBuilder() to construct.
        private InterClassName(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.unknownFields = builder.getUnknownFields();
        }

        private InterClassName(boolean noInit) {
            this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance();
        }

        private static final InterClassName defaultInstance;

        public static InterClassName getDefaultInstance() {
            return defaultInstance;
        }

        public InterClassName getDefaultInstanceForType() {
            return defaultInstance;
        }

        private final com.google.protobuf.UnknownFieldSet unknownFields;

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InterClassName(com.google.protobuf.CodedInputStream input,
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
                    case 9: {
                        bitField0_ |= 0x00000001;
                        doubleF_ = input.readDouble();
                        break;
                    }
                    case 21: {
                        bitField0_ |= 0x00000002;
                        floatF_ = input.readFloat();
                        break;
                    }
                    case 24: {
                        bitField0_ |= 0x00000004;
                        int32F_ = input.readInt32();
                        break;
                    }
                    case 32: {
                        bitField0_ |= 0x00000008;
                        int64F_ = input.readInt64();
                        break;
                    }
                    case 40: {
                        bitField0_ |= 0x00000010;
                        uint32F_ = input.readUInt32();
                        break;
                    }
                    case 48: {
                        bitField0_ |= 0x00000020;
                        uint64F_ = input.readUInt64();
                        break;
                    }
                    case 56: {
                        bitField0_ |= 0x00000040;
                        sint32F_ = input.readSInt32();
                        break;
                    }
                    case 64: {
                        bitField0_ |= 0x00000080;
                        sint64F_ = input.readSInt64();
                        break;
                    }
                    case 77: {
                        bitField0_ |= 0x00000100;
                        fixed32F_ = input.readFixed32();
                        break;
                    }
                    case 81: {
                        bitField0_ |= 0x00000200;
                        fixed64F_ = input.readFixed64();
                        break;
                    }
                    case 93: {
                        bitField0_ |= 0x00000400;
                        sfixed32F_ = input.readSFixed32();
                        break;
                    }
                    case 97: {
                        bitField0_ |= 0x00000800;
                        sfixed64F_ = input.readSFixed64();
                        break;
                    }
                    case 104: {
                        bitField0_ |= 0x00001000;
                        boolF_ = input.readBool();
                        break;
                    }
                    case 114: {
                        bitField0_ |= 0x00002000;
                        stringF_ = input.readBytes();
                        break;
                    }
                    case 122: {
                        bitField0_ |= 0x00004000;
                        bytesF_ = input.readBytes();
                        break;
                    }
                    case 128: {
                        int rawValue = input.readEnum();
                        com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef value = com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef
                                .valueOf(rawValue);
                        if (value == null) {
                            unknownFields.mergeVarintField(16, rawValue);
                        } else {
                            bitField0_ |= 0x00008000;
                            enumT_ = value;
                        }
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
            return com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.internal_static_pkg_InterClassName_descriptor;
        }

        protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.internal_static_pkg_InterClassName_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.class,
                            com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.Builder.class);
        }

        public static com.google.protobuf.Parser<InterClassName> PARSER = new com.google.protobuf.AbstractParser<InterClassName>() {
            public InterClassName parsePartialFrom(com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
                return new InterClassName(input, extensionRegistry);
            }
        };

        @java.lang.Override
        public com.google.protobuf.Parser<InterClassName> getParserForType() {
            return PARSER;
        }

        /**
         * Protobuf enum {@code pkg.InterClassName.TypeDef}
         */
        public enum TypeDef implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <code>TEXT = 1;</code>
             */
            TEXT(0, 1),
            /**
             * <code>NUMBER = 2;</code>
             */
            NUMBER(1, 2),
            /**
             * <code>DECIMAL = 4;</code>
             */
            DECIMAL(2, 4),
            /**
             * <code>ID = 8;</code>
             */
            ID(3, 8),
            /**
             * <code>URL = 16;</code>
             */
            URL(4, 16), ;

            /**
             * <code>TEXT = 1;</code>
             */
            public static final int TEXT_VALUE = 1;
            /**
             * <code>NUMBER = 2;</code>
             */
            public static final int NUMBER_VALUE = 2;
            /**
             * <code>DECIMAL = 4;</code>
             */
            public static final int DECIMAL_VALUE = 4;
            /**
             * <code>ID = 8;</code>
             */
            public static final int ID_VALUE = 8;
            /**
             * <code>URL = 16;</code>
             */
            public static final int URL_VALUE = 16;

            public final int getNumber() {
                return value;
            }

            public static TypeDef valueOf(int value) {
                switch (value) {
                case 1:
                    return TEXT;
                case 2:
                    return NUMBER;
                case 4:
                    return DECIMAL;
                case 8:
                    return ID;
                case 16:
                    return URL;
                default:
                    return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<TypeDef> internalGetValueMap() {
                return internalValueMap;
            }

            private static com.google.protobuf.Internal.EnumLiteMap<TypeDef> internalValueMap = new com.google.protobuf.Internal.EnumLiteMap<TypeDef>() {
                public TypeDef findValueByNumber(int number) {
                    return TypeDef.valueOf(number);
                }
            };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(index);
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
                return com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.getDescriptor()
                        .getEnumTypes().get(0);
            }

            private static final TypeDef[] VALUES = values();

            public static TypeDef valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int index;
            private final int value;

            private TypeDef(int index, int value) {
                this.index = index;
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:pkg.InterClassName.TypeDef)
        }

        private int bitField0_;
        // optional double doubleF = 1;
        public static final int DOUBLEF_FIELD_NUMBER = 1;
        private double doubleF_;

        /**
         * <code>optional double doubleF = 1;</code>
         */
        public boolean hasDoubleF() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }

        /**
         * <code>optional double doubleF = 1;</code>
         */
        public double getDoubleF() {
            return doubleF_;
        }

        // optional float floatF = 2;
        public static final int FLOATF_FIELD_NUMBER = 2;
        private float floatF_;

        /**
         * <code>optional float floatF = 2;</code>
         */
        public boolean hasFloatF() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }

        /**
         * <code>optional float floatF = 2;</code>
         */
        public float getFloatF() {
            return floatF_;
        }

        // optional int32 int32F = 3;
        public static final int INT32F_FIELD_NUMBER = 3;
        private int int32F_;

        /**
         * <code>optional int32 int32F = 3;</code>
         */
        public boolean hasInt32F() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }

        /**
         * <code>optional int32 int32F = 3;</code>
         */
        public int getInt32F() {
            return int32F_;
        }

        // optional int64 int64F = 4;
        public static final int INT64F_FIELD_NUMBER = 4;
        private long int64F_;

        /**
         * <code>optional int64 int64F = 4;</code>
         */
        public boolean hasInt64F() {
            return ((bitField0_ & 0x00000008) == 0x00000008);
        }

        /**
         * <code>optional int64 int64F = 4;</code>
         */
        public long getInt64F() {
            return int64F_;
        }

        // optional uint32 uint32F = 5;
        public static final int UINT32F_FIELD_NUMBER = 5;
        private int uint32F_;

        /**
         * <code>optional uint32 uint32F = 5;</code>
         */
        public boolean hasUint32F() {
            return ((bitField0_ & 0x00000010) == 0x00000010);
        }

        /**
         * <code>optional uint32 uint32F = 5;</code>
         */
        public int getUint32F() {
            return uint32F_;
        }

        // optional uint64 uint64F = 6;
        public static final int UINT64F_FIELD_NUMBER = 6;
        private long uint64F_;

        /**
         * <code>optional uint64 uint64F = 6;</code>
         */
        public boolean hasUint64F() {
            return ((bitField0_ & 0x00000020) == 0x00000020);
        }

        /**
         * <code>optional uint64 uint64F = 6;</code>
         */
        public long getUint64F() {
            return uint64F_;
        }

        // optional sint32 sint32F = 7;
        public static final int SINT32F_FIELD_NUMBER = 7;
        private int sint32F_;

        /**
         * <code>optional sint32 sint32F = 7;</code>
         */
        public boolean hasSint32F() {
            return ((bitField0_ & 0x00000040) == 0x00000040);
        }

        /**
         * <code>optional sint32 sint32F = 7;</code>
         */
        public int getSint32F() {
            return sint32F_;
        }

        // optional sint64 sint64F = 8;
        public static final int SINT64F_FIELD_NUMBER = 8;
        private long sint64F_;

        /**
         * <code>optional sint64 sint64F = 8;</code>
         */
        public boolean hasSint64F() {
            return ((bitField0_ & 0x00000080) == 0x00000080);
        }

        /**
         * <code>optional sint64 sint64F = 8;</code>
         */
        public long getSint64F() {
            return sint64F_;
        }

        // optional fixed32 fixed32F = 9;
        public static final int FIXED32F_FIELD_NUMBER = 9;
        private int fixed32F_;

        /**
         * <code>optional fixed32 fixed32F = 9;</code>
         */
        public boolean hasFixed32F() {
            return ((bitField0_ & 0x00000100) == 0x00000100);
        }

        /**
         * <code>optional fixed32 fixed32F = 9;</code>
         */
        public int getFixed32F() {
            return fixed32F_;
        }

        // optional fixed64 fixed64F = 10;
        public static final int FIXED64F_FIELD_NUMBER = 10;
        private long fixed64F_;

        /**
         * <code>optional fixed64 fixed64F = 10;</code>
         */
        public boolean hasFixed64F() {
            return ((bitField0_ & 0x00000200) == 0x00000200);
        }

        /**
         * <code>optional fixed64 fixed64F = 10;</code>
         */
        public long getFixed64F() {
            return fixed64F_;
        }

        // optional sfixed32 sfixed32F = 11;
        public static final int SFIXED32F_FIELD_NUMBER = 11;
        private int sfixed32F_;

        /**
         * <code>optional sfixed32 sfixed32F = 11;</code>
         */
        public boolean hasSfixed32F() {
            return ((bitField0_ & 0x00000400) == 0x00000400);
        }

        /**
         * <code>optional sfixed32 sfixed32F = 11;</code>
         */
        public int getSfixed32F() {
            return sfixed32F_;
        }

        // optional sfixed64 sfixed64F = 12;
        public static final int SFIXED64F_FIELD_NUMBER = 12;
        private long sfixed64F_;

        /**
         * <code>optional sfixed64 sfixed64F = 12;</code>
         */
        public boolean hasSfixed64F() {
            return ((bitField0_ & 0x00000800) == 0x00000800);
        }

        /**
         * <code>optional sfixed64 sfixed64F = 12;</code>
         */
        public long getSfixed64F() {
            return sfixed64F_;
        }

        // optional bool boolF = 13;
        public static final int BOOLF_FIELD_NUMBER = 13;
        private boolean boolF_;

        /**
         * <code>optional bool boolF = 13;</code>
         */
        public boolean hasBoolF() {
            return ((bitField0_ & 0x00001000) == 0x00001000);
        }

        /**
         * <code>optional bool boolF = 13;</code>
         */
        public boolean getBoolF() {
            return boolF_;
        }

        // optional string stringF = 14;
        public static final int STRINGF_FIELD_NUMBER = 14;
        private java.lang.Object stringF_;

        /**
         * <code>optional string stringF = 14;</code>
         */
        public boolean hasStringF() {
            return ((bitField0_ & 0x00002000) == 0x00002000);
        }

        /**
         * <code>optional string stringF = 14;</code>
         */
        public java.lang.String getStringF() {
            java.lang.Object ref = stringF_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    stringF_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string stringF = 14;</code>
         */
        public com.google.protobuf.ByteString getStringFBytes() {
            java.lang.Object ref = stringF_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                stringF_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        // optional bytes bytesF = 15;
        public static final int BYTESF_FIELD_NUMBER = 15;
        private com.google.protobuf.ByteString bytesF_;

        /**
         * <code>optional bytes bytesF = 15;</code>
         */
        public boolean hasBytesF() {
            return ((bitField0_ & 0x00004000) == 0x00004000);
        }

        /**
         * <code>optional bytes bytesF = 15;</code>
         */
        public com.google.protobuf.ByteString getBytesF() {
            return bytesF_;
        }

        // optional .pkg.InterClassName.TypeDef enumT = 16;
        public static final int ENUMT_FIELD_NUMBER = 16;
        private com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef enumT_;

        /**
         * <code>optional .pkg.InterClassName.TypeDef enumT = 16;</code>
         */
        public boolean hasEnumT() {
            return ((bitField0_ & 0x00008000) == 0x00008000);
        }

        /**
         * <code>optional .pkg.InterClassName.TypeDef enumT = 16;</code>
         */
        public com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef getEnumT() {
            return enumT_;
        }

        private void initFields() {
            doubleF_ = 0D;
            floatF_ = 0F;
            int32F_ = 0;
            int64F_ = 0L;
            uint32F_ = 0;
            uint64F_ = 0L;
            sint32F_ = 0;
            sint64F_ = 0L;
            fixed32F_ = 0;
            fixed64F_ = 0L;
            sfixed32F_ = 0;
            sfixed64F_ = 0L;
            boolF_ = false;
            stringF_ = "";
            bytesF_ = com.google.protobuf.ByteString.EMPTY;
            enumT_ = com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef.TEXT;
        }

        private byte memoizedIsInitialized = -1;

        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
            getSerializedSize();
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeDouble(1, doubleF_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeFloat(2, floatF_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeInt32(3, int32F_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                output.writeInt64(4, int64F_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                output.writeUInt32(5, uint32F_);
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                output.writeUInt64(6, uint64F_);
            }
            if (((bitField0_ & 0x00000040) == 0x00000040)) {
                output.writeSInt32(7, sint32F_);
            }
            if (((bitField0_ & 0x00000080) == 0x00000080)) {
                output.writeSInt64(8, sint64F_);
            }
            if (((bitField0_ & 0x00000100) == 0x00000100)) {
                output.writeFixed32(9, fixed32F_);
            }
            if (((bitField0_ & 0x00000200) == 0x00000200)) {
                output.writeFixed64(10, fixed64F_);
            }
            if (((bitField0_ & 0x00000400) == 0x00000400)) {
                output.writeSFixed32(11, sfixed32F_);
            }
            if (((bitField0_ & 0x00000800) == 0x00000800)) {
                output.writeSFixed64(12, sfixed64F_);
            }
            if (((bitField0_ & 0x00001000) == 0x00001000)) {
                output.writeBool(13, boolF_);
            }
            if (((bitField0_ & 0x00002000) == 0x00002000)) {
                output.writeBytes(14, getStringFBytes());
            }
            if (((bitField0_ & 0x00004000) == 0x00004000)) {
                output.writeBytes(15, bytesF_);
            }
            if (((bitField0_ & 0x00008000) == 0x00008000)) {
                output.writeEnum(16, enumT_.getNumber());
            }
            getUnknownFields().writeTo(output);
        }

        private int memoizedSerializedSize = -1;

        public int getSerializedSize() {
            int size = memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream.computeDoubleSize(1, doubleF_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream.computeFloatSize(2, floatF_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, int32F_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, int64F_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                size += com.google.protobuf.CodedOutputStream.computeUInt32Size(5, uint32F_);
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                size += com.google.protobuf.CodedOutputStream.computeUInt64Size(6, uint64F_);
            }
            if (((bitField0_ & 0x00000040) == 0x00000040)) {
                size += com.google.protobuf.CodedOutputStream.computeSInt32Size(7, sint32F_);
            }
            if (((bitField0_ & 0x00000080) == 0x00000080)) {
                size += com.google.protobuf.CodedOutputStream.computeSInt64Size(8, sint64F_);
            }
            if (((bitField0_ & 0x00000100) == 0x00000100)) {
                size += com.google.protobuf.CodedOutputStream.computeFixed32Size(9, fixed32F_);
            }
            if (((bitField0_ & 0x00000200) == 0x00000200)) {
                size += com.google.protobuf.CodedOutputStream.computeFixed64Size(10, fixed64F_);
            }
            if (((bitField0_ & 0x00000400) == 0x00000400)) {
                size += com.google.protobuf.CodedOutputStream.computeSFixed32Size(11, sfixed32F_);
            }
            if (((bitField0_ & 0x00000800) == 0x00000800)) {
                size += com.google.protobuf.CodedOutputStream.computeSFixed64Size(12, sfixed64F_);
            }
            if (((bitField0_ & 0x00001000) == 0x00001000)) {
                size += com.google.protobuf.CodedOutputStream.computeBoolSize(13, boolF_);
            }
            if (((bitField0_ & 0x00002000) == 0x00002000)) {
                size += com.google.protobuf.CodedOutputStream.computeBytesSize(14, getStringFBytes());
            }
            if (((bitField0_ & 0x00004000) == 0x00004000)) {
                size += com.google.protobuf.CodedOutputStream.computeBytesSize(15, bytesF_);
            }
            if (((bitField0_ & 0x00008000) == 0x00008000)) {
                size += com.google.protobuf.CodedOutputStream.computeEnumSize(16, enumT_.getNumber());
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

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseFrom(
            com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseFrom(
            com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseFrom(byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseFrom(input, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseDelimitedFrom(
            java.io.InputStream input) throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseDelimitedFrom(
            java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
            return PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseFrom(
            com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return PARSER.parseFrom(input);
        }

        public static com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parseFrom(
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

        public static Builder newBuilder(com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName prototype) {
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
         * Protobuf type {@code pkg.InterClassName}
         */
        public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder<Builder> implements
            com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassNameOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.internal_static_pkg_InterClassName_descriptor;
            }

            protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.internal_static_pkg_InterClassName_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.class,
                                com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.Builder.class);
            }

            // Construct using
            // com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.newBuilder()
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
                doubleF_ = 0D;
                bitField0_ = (bitField0_ & ~0x00000001);
                floatF_ = 0F;
                bitField0_ = (bitField0_ & ~0x00000002);
                int32F_ = 0;
                bitField0_ = (bitField0_ & ~0x00000004);
                int64F_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000008);
                uint32F_ = 0;
                bitField0_ = (bitField0_ & ~0x00000010);
                uint64F_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000020);
                sint32F_ = 0;
                bitField0_ = (bitField0_ & ~0x00000040);
                sint64F_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000080);
                fixed32F_ = 0;
                bitField0_ = (bitField0_ & ~0x00000100);
                fixed64F_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000200);
                sfixed32F_ = 0;
                bitField0_ = (bitField0_ & ~0x00000400);
                sfixed64F_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000800);
                boolF_ = false;
                bitField0_ = (bitField0_ & ~0x00001000);
                stringF_ = "";
                bitField0_ = (bitField0_ & ~0x00002000);
                bytesF_ = com.google.protobuf.ByteString.EMPTY;
                bitField0_ = (bitField0_ & ~0x00004000);
                enumT_ = com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef.TEXT;
                bitField0_ = (bitField0_ & ~0x00008000);
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.internal_static_pkg_InterClassName_descriptor;
            }

            public com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName getDefaultInstanceForType() {
                return com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.getDefaultInstance();
            }

            public com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName build() {
                com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName buildPartial() {
                com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName result = new com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName(
                        this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.doubleF_ = doubleF_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.floatF_ = floatF_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.int32F_ = int32F_;
                if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
                    to_bitField0_ |= 0x00000008;
                }
                result.int64F_ = int64F_;
                if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.uint32F_ = uint32F_;
                if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
                    to_bitField0_ |= 0x00000020;
                }
                result.uint64F_ = uint64F_;
                if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
                    to_bitField0_ |= 0x00000040;
                }
                result.sint32F_ = sint32F_;
                if (((from_bitField0_ & 0x00000080) == 0x00000080)) {
                    to_bitField0_ |= 0x00000080;
                }
                result.sint64F_ = sint64F_;
                if (((from_bitField0_ & 0x00000100) == 0x00000100)) {
                    to_bitField0_ |= 0x00000100;
                }
                result.fixed32F_ = fixed32F_;
                if (((from_bitField0_ & 0x00000200) == 0x00000200)) {
                    to_bitField0_ |= 0x00000200;
                }
                result.fixed64F_ = fixed64F_;
                if (((from_bitField0_ & 0x00000400) == 0x00000400)) {
                    to_bitField0_ |= 0x00000400;
                }
                result.sfixed32F_ = sfixed32F_;
                if (((from_bitField0_ & 0x00000800) == 0x00000800)) {
                    to_bitField0_ |= 0x00000800;
                }
                result.sfixed64F_ = sfixed64F_;
                if (((from_bitField0_ & 0x00001000) == 0x00001000)) {
                    to_bitField0_ |= 0x00001000;
                }
                result.boolF_ = boolF_;
                if (((from_bitField0_ & 0x00002000) == 0x00002000)) {
                    to_bitField0_ |= 0x00002000;
                }
                result.stringF_ = stringF_;
                if (((from_bitField0_ & 0x00004000) == 0x00004000)) {
                    to_bitField0_ |= 0x00004000;
                }
                result.bytesF_ = bytesF_;
                if (((from_bitField0_ & 0x00008000) == 0x00008000)) {
                    to_bitField0_ |= 0x00008000;
                }
                result.enumT_ = enumT_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName) {
                    return mergeFrom((com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName other) {
                if (other == com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.getDefaultInstance())
                    return this;
                if (other.hasDoubleF()) {
                    setDoubleF(other.getDoubleF());
                }
                if (other.hasFloatF()) {
                    setFloatF(other.getFloatF());
                }
                if (other.hasInt32F()) {
                    setInt32F(other.getInt32F());
                }
                if (other.hasInt64F()) {
                    setInt64F(other.getInt64F());
                }
                if (other.hasUint32F()) {
                    setUint32F(other.getUint32F());
                }
                if (other.hasUint64F()) {
                    setUint64F(other.getUint64F());
                }
                if (other.hasSint32F()) {
                    setSint32F(other.getSint32F());
                }
                if (other.hasSint64F()) {
                    setSint64F(other.getSint64F());
                }
                if (other.hasFixed32F()) {
                    setFixed32F(other.getFixed32F());
                }
                if (other.hasFixed64F()) {
                    setFixed64F(other.getFixed64F());
                }
                if (other.hasSfixed32F()) {
                    setSfixed32F(other.getSfixed32F());
                }
                if (other.hasSfixed64F()) {
                    setSfixed64F(other.getSfixed64F());
                }
                if (other.hasBoolF()) {
                    setBoolF(other.getBoolF());
                }
                if (other.hasStringF()) {
                    bitField0_ |= 0x00002000;
                    stringF_ = other.stringF_;
                    onChanged();
                }
                if (other.hasBytesF()) {
                    setBytesF(other.getBytesF());
                }
                if (other.hasEnumT()) {
                    setEnumT(other.getEnumT());
                }
                this.mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
                com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName) e
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

            // optional double doubleF = 1;
            private double doubleF_;

            /**
             * <code>optional double doubleF = 1;</code>
             */
            public boolean hasDoubleF() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }

            /**
             * <code>optional double doubleF = 1;</code>
             */
            public double getDoubleF() {
                return doubleF_;
            }

            /**
             * <code>optional double doubleF = 1;</code>
             */
            public Builder setDoubleF(double value) {
                bitField0_ |= 0x00000001;
                doubleF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional double doubleF = 1;</code>
             */
            public Builder clearDoubleF() {
                bitField0_ = (bitField0_ & ~0x00000001);
                doubleF_ = 0D;
                onChanged();
                return this;
            }

            // optional float floatF = 2;
            private float floatF_;

            /**
             * <code>optional float floatF = 2;</code>
             */
            public boolean hasFloatF() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }

            /**
             * <code>optional float floatF = 2;</code>
             */
            public float getFloatF() {
                return floatF_;
            }

            /**
             * <code>optional float floatF = 2;</code>
             */
            public Builder setFloatF(float value) {
                bitField0_ |= 0x00000002;
                floatF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional float floatF = 2;</code>
             */
            public Builder clearFloatF() {
                bitField0_ = (bitField0_ & ~0x00000002);
                floatF_ = 0F;
                onChanged();
                return this;
            }

            // optional int32 int32F = 3;
            private int int32F_;

            /**
             * <code>optional int32 int32F = 3;</code>
             */
            public boolean hasInt32F() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }

            /**
             * <code>optional int32 int32F = 3;</code>
             */
            public int getInt32F() {
                return int32F_;
            }

            /**
             * <code>optional int32 int32F = 3;</code>
             */
            public Builder setInt32F(int value) {
                bitField0_ |= 0x00000004;
                int32F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional int32 int32F = 3;</code>
             */
            public Builder clearInt32F() {
                bitField0_ = (bitField0_ & ~0x00000004);
                int32F_ = 0;
                onChanged();
                return this;
            }

            // optional int64 int64F = 4;
            private long int64F_;

            /**
             * <code>optional int64 int64F = 4;</code>
             */
            public boolean hasInt64F() {
                return ((bitField0_ & 0x00000008) == 0x00000008);
            }

            /**
             * <code>optional int64 int64F = 4;</code>
             */
            public long getInt64F() {
                return int64F_;
            }

            /**
             * <code>optional int64 int64F = 4;</code>
             */
            public Builder setInt64F(long value) {
                bitField0_ |= 0x00000008;
                int64F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional int64 int64F = 4;</code>
             */
            public Builder clearInt64F() {
                bitField0_ = (bitField0_ & ~0x00000008);
                int64F_ = 0L;
                onChanged();
                return this;
            }

            // optional uint32 uint32F = 5;
            private int uint32F_;

            /**
             * <code>optional uint32 uint32F = 5;</code>
             */
            public boolean hasUint32F() {
                return ((bitField0_ & 0x00000010) == 0x00000010);
            }

            /**
             * <code>optional uint32 uint32F = 5;</code>
             */
            public int getUint32F() {
                return uint32F_;
            }

            /**
             * <code>optional uint32 uint32F = 5;</code>
             */
            public Builder setUint32F(int value) {
                bitField0_ |= 0x00000010;
                uint32F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional uint32 uint32F = 5;</code>
             */
            public Builder clearUint32F() {
                bitField0_ = (bitField0_ & ~0x00000010);
                uint32F_ = 0;
                onChanged();
                return this;
            }

            // optional uint64 uint64F = 6;
            private long uint64F_;

            /**
             * <code>optional uint64 uint64F = 6;</code>
             */
            public boolean hasUint64F() {
                return ((bitField0_ & 0x00000020) == 0x00000020);
            }

            /**
             * <code>optional uint64 uint64F = 6;</code>
             */
            public long getUint64F() {
                return uint64F_;
            }

            /**
             * <code>optional uint64 uint64F = 6;</code>
             */
            public Builder setUint64F(long value) {
                bitField0_ |= 0x00000020;
                uint64F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional uint64 uint64F = 6;</code>
             */
            public Builder clearUint64F() {
                bitField0_ = (bitField0_ & ~0x00000020);
                uint64F_ = 0L;
                onChanged();
                return this;
            }

            // optional sint32 sint32F = 7;
            private int sint32F_;

            /**
             * <code>optional sint32 sint32F = 7;</code>
             */
            public boolean hasSint32F() {
                return ((bitField0_ & 0x00000040) == 0x00000040);
            }

            /**
             * <code>optional sint32 sint32F = 7;</code>
             */
            public int getSint32F() {
                return sint32F_;
            }

            /**
             * <code>optional sint32 sint32F = 7;</code>
             */
            public Builder setSint32F(int value) {
                bitField0_ |= 0x00000040;
                sint32F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional sint32 sint32F = 7;</code>
             */
            public Builder clearSint32F() {
                bitField0_ = (bitField0_ & ~0x00000040);
                sint32F_ = 0;
                onChanged();
                return this;
            }

            // optional sint64 sint64F = 8;
            private long sint64F_;

            /**
             * <code>optional sint64 sint64F = 8;</code>
             */
            public boolean hasSint64F() {
                return ((bitField0_ & 0x00000080) == 0x00000080);
            }

            /**
             * <code>optional sint64 sint64F = 8;</code>
             */
            public long getSint64F() {
                return sint64F_;
            }

            /**
             * <code>optional sint64 sint64F = 8;</code>
             */
            public Builder setSint64F(long value) {
                bitField0_ |= 0x00000080;
                sint64F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional sint64 sint64F = 8;</code>
             */
            public Builder clearSint64F() {
                bitField0_ = (bitField0_ & ~0x00000080);
                sint64F_ = 0L;
                onChanged();
                return this;
            }

            // optional fixed32 fixed32F = 9;
            private int fixed32F_;

            /**
             * <code>optional fixed32 fixed32F = 9;</code>
             */
            public boolean hasFixed32F() {
                return ((bitField0_ & 0x00000100) == 0x00000100);
            }

            /**
             * <code>optional fixed32 fixed32F = 9;</code>
             */
            public int getFixed32F() {
                return fixed32F_;
            }

            /**
             * <code>optional fixed32 fixed32F = 9;</code>
             */
            public Builder setFixed32F(int value) {
                bitField0_ |= 0x00000100;
                fixed32F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional fixed32 fixed32F = 9;</code>
             */
            public Builder clearFixed32F() {
                bitField0_ = (bitField0_ & ~0x00000100);
                fixed32F_ = 0;
                onChanged();
                return this;
            }

            // optional fixed64 fixed64F = 10;
            private long fixed64F_;

            /**
             * <code>optional fixed64 fixed64F = 10;</code>
             */
            public boolean hasFixed64F() {
                return ((bitField0_ & 0x00000200) == 0x00000200);
            }

            /**
             * <code>optional fixed64 fixed64F = 10;</code>
             */
            public long getFixed64F() {
                return fixed64F_;
            }

            /**
             * <code>optional fixed64 fixed64F = 10;</code>
             */
            public Builder setFixed64F(long value) {
                bitField0_ |= 0x00000200;
                fixed64F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional fixed64 fixed64F = 10;</code>
             */
            public Builder clearFixed64F() {
                bitField0_ = (bitField0_ & ~0x00000200);
                fixed64F_ = 0L;
                onChanged();
                return this;
            }

            // optional sfixed32 sfixed32F = 11;
            private int sfixed32F_;

            /**
             * <code>optional sfixed32 sfixed32F = 11;</code>
             */
            public boolean hasSfixed32F() {
                return ((bitField0_ & 0x00000400) == 0x00000400);
            }

            /**
             * <code>optional sfixed32 sfixed32F = 11;</code>
             */
            public int getSfixed32F() {
                return sfixed32F_;
            }

            /**
             * <code>optional sfixed32 sfixed32F = 11;</code>
             */
            public Builder setSfixed32F(int value) {
                bitField0_ |= 0x00000400;
                sfixed32F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional sfixed32 sfixed32F = 11;</code>
             */
            public Builder clearSfixed32F() {
                bitField0_ = (bitField0_ & ~0x00000400);
                sfixed32F_ = 0;
                onChanged();
                return this;
            }

            // optional sfixed64 sfixed64F = 12;
            private long sfixed64F_;

            /**
             * <code>optional sfixed64 sfixed64F = 12;</code>
             */
            public boolean hasSfixed64F() {
                return ((bitField0_ & 0x00000800) == 0x00000800);
            }

            /**
             * <code>optional sfixed64 sfixed64F = 12;</code>
             */
            public long getSfixed64F() {
                return sfixed64F_;
            }

            /**
             * <code>optional sfixed64 sfixed64F = 12;</code>
             */
            public Builder setSfixed64F(long value) {
                bitField0_ |= 0x00000800;
                sfixed64F_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional sfixed64 sfixed64F = 12;</code>
             */
            public Builder clearSfixed64F() {
                bitField0_ = (bitField0_ & ~0x00000800);
                sfixed64F_ = 0L;
                onChanged();
                return this;
            }

            // optional bool boolF = 13;
            private boolean boolF_;

            /**
             * <code>optional bool boolF = 13;</code>
             */
            public boolean hasBoolF() {
                return ((bitField0_ & 0x00001000) == 0x00001000);
            }

            /**
             * <code>optional bool boolF = 13;</code>
             */
            public boolean getBoolF() {
                return boolF_;
            }

            /**
             * <code>optional bool boolF = 13;</code>
             */
            public Builder setBoolF(boolean value) {
                bitField0_ |= 0x00001000;
                boolF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional bool boolF = 13;</code>
             */
            public Builder clearBoolF() {
                bitField0_ = (bitField0_ & ~0x00001000);
                boolF_ = false;
                onChanged();
                return this;
            }

            // optional string stringF = 14;
            private java.lang.Object stringF_ = "";

            /**
             * <code>optional string stringF = 14;</code>
             */
            public boolean hasStringF() {
                return ((bitField0_ & 0x00002000) == 0x00002000);
            }

            /**
             * <code>optional string stringF = 14;</code>
             */
            public java.lang.String getStringF() {
                java.lang.Object ref = stringF_;
                if (!(ref instanceof java.lang.String)) {
                    java.lang.String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
                    stringF_ = s;
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>optional string stringF = 14;</code>
             */
            public com.google.protobuf.ByteString getStringFBytes() {
                java.lang.Object ref = stringF_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b = com.google.protobuf.ByteString
                            .copyFromUtf8((java.lang.String) ref);
                    stringF_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string stringF = 14;</code>
             */
            public Builder setStringF(java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00002000;
                stringF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string stringF = 14;</code>
             */
            public Builder clearStringF() {
                bitField0_ = (bitField0_ & ~0x00002000);
                stringF_ = getDefaultInstance().getStringF();
                onChanged();
                return this;
            }

            /**
             * <code>optional string stringF = 14;</code>
             */
            public Builder setStringFBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00002000;
                stringF_ = value;
                onChanged();
                return this;
            }

            // optional bytes bytesF = 15;
            private com.google.protobuf.ByteString bytesF_ = com.google.protobuf.ByteString.EMPTY;

            /**
             * <code>optional bytes bytesF = 15;</code>
             */
            public boolean hasBytesF() {
                return ((bitField0_ & 0x00004000) == 0x00004000);
            }

            /**
             * <code>optional bytes bytesF = 15;</code>
             */
            public com.google.protobuf.ByteString getBytesF() {
                return bytesF_;
            }

            /**
             * <code>optional bytes bytesF = 15;</code>
             */
            public Builder setBytesF(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00004000;
                bytesF_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional bytes bytesF = 15;</code>
             */
            public Builder clearBytesF() {
                bitField0_ = (bitField0_ & ~0x00004000);
                bytesF_ = getDefaultInstance().getBytesF();
                onChanged();
                return this;
            }

            // optional .pkg.InterClassName.TypeDef enumT = 16;
            private com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef enumT_ = com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef.TEXT;

            /**
             * <code>optional .pkg.InterClassName.TypeDef enumT = 16;</code>
             */
            public boolean hasEnumT() {
                return ((bitField0_ & 0x00008000) == 0x00008000);
            }

            /**
             * <code>optional .pkg.InterClassName.TypeDef enumT = 16;</code>
             */
            public com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef getEnumT() {
                return enumT_;
            }

            /**
             * <code>optional .pkg.InterClassName.TypeDef enumT = 16;</code>
             */
            public Builder setEnumT(com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00008000;
                enumT_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional .pkg.InterClassName.TypeDef enumT = 16;</code>
             */
            public Builder clearEnumT() {
                bitField0_ = (bitField0_ & ~0x00008000);
                enumT_ = com.baidu.bjf.remoting.protobuf.simpletypes.AllTypes.InterClassName.TypeDef.TEXT;
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

    private static com.google.protobuf.Descriptors.Descriptor internal_static_pkg_InterClassName_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_pkg_InterClassName_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
    static {
        java.lang.String[] descriptorData = {
                "\n\016alltypes.proto\022\003pkg\"\372\002\n\016InterClassName"
                        + "\022\017\n\007doubleF\030\001 \001(\001\022\016\n\006floatF\030\002 \001(\002\022\016\n\006int"
                        + "32F\030\003 \001(\005\022\016\n\006int64F\030\004 \001(\003\022\017\n\007uint32F\030\005 \001"
                        + "(\r\022\017\n\007uint64F\030\006 \001(\004\022\017\n\007sint32F\030\007 \001(\021\022\017\n\007"
                        + "sint64F\030\010 \001(\022\022\020\n\010fixed32F\030\t \001(\007\022\020\n\010fixed"
                        + "64F\030\n \001(\006\022\021\n\tsfixed32F\030\013 \001(\017\022\021\n\tsfixed64"
                        + "F\030\014 \001(\020\022\r\n\005boolF\030\r \001(\010\022\017\n\007stringF\030\016 \001(\t\022"
                        + "\016\n\006bytesF\030\017 \001(\014\022*\n\005enumT\030\020 \001(\0162\033.pkg.Int"
                        + "erClassName.TypeDef\"=\n\007TypeDef\022\010\n\004TEXT\020\001"
                        + "\022\n\n\006NUMBER\020\002\022\013\n\007DECIMAL\020\004\022\006\n\002ID\020\010\022\007\n\003URL",
                "\020\020B7\n+com.baidu.bjf.remoting.protobuf.si" + "mpletypesB\010AllTypes" };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public com.google.protobuf.ExtensionRegistry assignDescriptors(
                com.google.protobuf.Descriptors.FileDescriptor root) {
                descriptor = root;
                internal_static_pkg_InterClassName_descriptor = getDescriptor().getMessageTypes().get(0);
                internal_static_pkg_InterClassName_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable(
                        internal_static_pkg_InterClassName_descriptor, new java.lang.String[] { "DoubleF", "FloatF",
                                "Int32F", "Int64F", "Uint32F", "Uint64F", "Sint32F", "Sint64F", "Fixed32F", "Fixed64F",
                                "Sfixed32F", "Sfixed64F", "BoolF", "StringF", "BytesF", "EnumT", });
                return null;
            }
        };
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
                new com.google.protobuf.Descriptors.FileDescriptor[] {}, assigner);
    }

    // @@protoc_insertion_point(outer_class_scope)
}
