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
package com.baidu.bjf.remoting.protobuf;

import com.google.protobuf.*;
import java.io.IOException;
import java.util.Arrays;
import com.baidu.bjf.remoting.protobuf.utils.*;
import java.lang.reflect.*;

public class AllTypesDojoClass$$BJFProtoBufClass_Gen implements
        com.baidu.bjf.remoting.protobuf.Codec<AllTypesDojoClass> {
    public byte[] encode(AllTypesDojoClass t) throws IOException {
        int size = 0;
        Double f_1 = null;
        if (!CodedConstant.isNull(t.doubleF)) {
            f_1 = t.doubleF;
        }
        if (!CodedConstant.isNull(t.doubleF)) {
            size += com.google.protobuf.CodedOutputStream.computeDoubleSize(1,
                    f_1);
        }
        Float f_2 = null;
        if (!CodedConstant.isNull(t.floatF)) {
            f_2 = t.floatF;
        }
        if (!CodedConstant.isNull(t.floatF)) {
            size += com.google.protobuf.CodedOutputStream.computeFloatSize(2,
                    f_2);
        }
        Integer f_3 = null;
        if (!CodedConstant.isNull(t.int32F)) {
            f_3 = t.int32F;
        }
        if (!CodedConstant.isNull(t.int32F)) {
            size += com.google.protobuf.CodedOutputStream.computeInt32Size(3,
                    f_3);
        }
        Long f_4 = null;
        if (!CodedConstant.isNull(t.int64F)) {
            f_4 = t.int64F;
        }
        if (!CodedConstant.isNull(t.int64F)) {
            size += com.google.protobuf.CodedOutputStream.computeInt64Size(4,
                    f_4);
        }
        Integer f_5 = null;
        if (!CodedConstant.isNull(t.uint32F)) {
            f_5 = t.uint32F;
        }
        if (!CodedConstant.isNull(t.uint32F)) {
            size += com.google.protobuf.CodedOutputStream.computeUInt32Size(5,
                    f_5);
        }
        Long f_6 = null;
        if (!CodedConstant.isNull(t.uint64F)) {
            f_6 = t.uint64F;
        }
        if (!CodedConstant.isNull(t.uint64F)) {
            size += com.google.protobuf.CodedOutputStream.computeUInt64Size(6,
                    f_6);
        }
        Integer f_7 = null;
        if (!CodedConstant.isNull(t.sint32F)) {
            f_7 = t.sint32F;
        }
        if (!CodedConstant.isNull(t.sint32F)) {
            size += com.google.protobuf.CodedOutputStream.computeSInt32Size(7,
                    f_7);
        }
        Long f_8 = null;
        if (!CodedConstant.isNull(t.sint64F)) {
            f_8 = t.sint64F;
        }
        if (!CodedConstant.isNull(t.sint64F)) {
            size += com.google.protobuf.CodedOutputStream.computeSInt64Size(8,
                    f_8);
        }
        Integer f_9 = null;
        if (!CodedConstant.isNull(t.fixed32F)) {
            f_9 = t.fixed32F;
        }
        if (!CodedConstant.isNull(t.fixed32F)) {
            size += com.google.protobuf.CodedOutputStream.computeFixed32Size(9,
                    f_9);
        }
        Long f_10 = null;
        if (!CodedConstant.isNull(t.fixed64F)) {
            f_10 = t.fixed64F;
        }
        if (!CodedConstant.isNull(t.fixed64F)) {
            size += com.google.protobuf.CodedOutputStream.computeFixed64Size(
                    10, f_10);
        }
        Integer f_11 = null;
        if (!CodedConstant.isNull(t.sfixed32F)) {
            f_11 = t.sfixed32F;
        }
        if (!CodedConstant.isNull(t.sfixed32F)) {
            size += com.google.protobuf.CodedOutputStream.computeSFixed32Size(
                    11, f_11);
        }
        Long f_12 = null;
        if (!CodedConstant.isNull(t.sfixed64F)) {
            f_12 = t.sfixed64F;
        }
        if (!CodedConstant.isNull(t.sfixed64F)) {
            size += com.google.protobuf.CodedOutputStream.computeSFixed64Size(
                    12, f_12);
        }
        Boolean f_13 = null;
        if (!CodedConstant.isNull(t.boolF)) {
            f_13 = t.boolF;
        }
        if (!CodedConstant.isNull(t.boolF)) {
            size += com.google.protobuf.CodedOutputStream.computeBoolSize(13,
                    f_13);
        }
        com.google.protobuf.ByteString f_14 = null;
        if (!CodedConstant.isNull(t.stringF)) {
            f_14 = com.google.protobuf.ByteString.copyFromUtf8(t.stringF);
        }
        if (!CodedConstant.isNull(t.stringF)) {
            size += com.google.protobuf.CodedOutputStream.computeBytesSize(14,
                    f_14);
        }
        com.google.protobuf.ByteString f_15 = null;
        if (!CodedConstant.isNull(t.bytesF)) {
            f_15 = com.google.protobuf.ByteString.copyFrom(t.bytesF);
        }
        if (!CodedConstant.isNull(t.bytesF)) {
            size += com.google.protobuf.CodedOutputStream.computeBytesSize(15,
                    f_15);
        }
        final byte[] result = new byte[size];
        final CodedOutputStream output = CodedOutputStream.newInstance(result);
        output.writeDouble(1, f_1);
        output.writeFloat(2, f_2);
        output.writeInt32(3, f_3);
        output.writeInt64(4, f_4);
        output.writeUInt32(5, f_5);
        output.writeUInt64(6, f_6);
        output.writeSInt32(7, f_7);
        output.writeSInt64(8, f_8);
        output.writeFixed32(9, f_9);
        output.writeFixed64(10, f_10);
        output.writeSFixed32(11, f_11);
        output.writeSFixed64(12, f_12);
        output.writeBool(13, f_13);
        output.writeBytes(14, f_14);
        output.writeBytes(15, f_15);
        return result;
    }

    public AllTypesDojoClass decode(byte[] bb) throws IOException {
        AllTypesDojoClass ret = new AllTypesDojoClass();
        CodedInputStream input = CodedInputStream.newInstance(bb, 0, bb.length);
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == CodedConstant
                        .makeTag(1, WireFormat.WIRETYPE_FIXED64)) {
                    ret.doubleF = input.readDouble();
                    continue;
                }
                if (tag == CodedConstant
                        .makeTag(2, WireFormat.WIRETYPE_FIXED32)) {
                    ret.floatF = input.readFloat();
                    continue;
                }
                if (tag == CodedConstant.makeTag(3, WireFormat.WIRETYPE_VARINT)) {
                    ret.int32F = input.readInt32();
                    continue;
                }
                if (tag == CodedConstant.makeTag(4, WireFormat.WIRETYPE_VARINT)) {
                    ret.int64F = input.readInt64();
                    continue;
                }
                if (tag == CodedConstant.makeTag(5, WireFormat.WIRETYPE_VARINT)) {
                    ret.uint32F = input.readUInt32();
                    continue;
                }
                if (tag == CodedConstant.makeTag(6, WireFormat.WIRETYPE_VARINT)) {
                    ret.uint64F = input.readUInt64();
                    continue;
                }
                if (tag == CodedConstant.makeTag(7, WireFormat.WIRETYPE_VARINT)) {
                    ret.sint32F = input.readSInt32();
                    continue;
                }
                if (tag == CodedConstant.makeTag(8, WireFormat.WIRETYPE_VARINT)) {
                    ret.sint64F = input.readSInt64();
                    continue;
                }
                if (tag == CodedConstant
                        .makeTag(9, WireFormat.WIRETYPE_FIXED32)) {
                    ret.fixed32F = input.readFixed32();
                    continue;
                }
                if (tag == CodedConstant.makeTag(10,
                        WireFormat.WIRETYPE_FIXED64)) {
                    ret.fixed64F = input.readFixed64();
                    continue;
                }
                if (tag == CodedConstant.makeTag(11,
                        WireFormat.WIRETYPE_FIXED32)) {
                    ret.sfixed32F = input.readSFixed32();
                    continue;
                }
                if (tag == CodedConstant.makeTag(12,
                        WireFormat.WIRETYPE_FIXED64)) {
                    ret.sfixed64F = input.readSFixed64();
                    continue;
                }
                if (tag == CodedConstant
                        .makeTag(13, WireFormat.WIRETYPE_VARINT)) {
                    ret.boolF = input.readBool();
                    continue;
                }
                if (tag == CodedConstant.makeTag(14,
                        WireFormat.WIRETYPE_LENGTH_DELIMITED)) {
                    ret.stringF = input.readString();
                    continue;
                }
                if (tag == CodedConstant.makeTag(15,
                        WireFormat.WIRETYPE_LENGTH_DELIMITED)) {
                    ret.bytesF = input.readBytes().toByteArray();
                    continue;
                }
                input.skipField(tag);
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e;
        } catch (java.io.IOException e) {
            throw e;
        }
        return ret;
    }
}
