package com.baidu.bjf.remoting.protobuf.complexList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.collections.map.LRUMap;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.code.CodedConstant;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.UninitializedMessageException;

public class PersonPOJO$$JProtoBufClass
        implements com.baidu.bjf.remoting.protobuf.Codec<com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO> {
    private com.google.protobuf.Descriptors.Descriptor descriptor;
    
    LRUMap lruMap = new LRUMap(50);
    
    public byte[] encode(com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO t) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(baos);
        doWriteTo(t, newInstance);
        newInstance.flush();
        return baos.toByteArray();
    }

    public com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO decode(byte[] bb) throws IOException {
        CodedInputStream input = CodedInputStream.newInstance(bb, 0, bb.length);
        return readFrom(input);
    }

    public int size(com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO t) throws IOException {
        
        Object object = lruMap.get(t);
        if (object != null) {
            return Integer.valueOf(object.toString());
        }
        
        int size = 0;

        com.google.protobuf.ByteString f_1 = null;
        if (!CodedConstant.isNull(t.name)) {
            f_1 = com.google.protobuf.ByteString.copyFromUtf8(t.name);
            size += com.google.protobuf.CodedOutputStream.computeBytesSize(1, f_1);

        }
        if (f_1 == null) {
            throw new UninitializedMessageException(CodedConstant.asList("name"));
        }

        Integer f_2 = null;
        if (!CodedConstant.isNull(t.id)) {
            f_2 = t.id;
            size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, f_2.intValue());

        }
        if (f_2 == null) {
            throw new UninitializedMessageException(CodedConstant.asList("id"));
        }

        com.google.protobuf.ByteString f_3 = null;
        if (!CodedConstant.isNull(t.email)) {
            f_3 = com.google.protobuf.ByteString.copyFromUtf8(t.email);
            size += com.google.protobuf.CodedOutputStream.computeBytesSize(3, f_3);

        }

        Double f_4 = null;
        if (!CodedConstant.isNull(t.doubleF)) {
            f_4 = t.doubleF;
            size += com.google.protobuf.CodedOutputStream.computeDoubleSize(4, f_4.doubleValue());

        }

        Float f_5 = null;
        if (!CodedConstant.isNull(t.floatF)) {
            f_5 = t.floatF;
            size += com.google.protobuf.CodedOutputStream.computeFloatSize(5, f_5.floatValue());

        }

        com.google.protobuf.ByteString f_6 = null;
        if (!CodedConstant.isNull(t.bytesF)) {
            f_6 = com.google.protobuf.ByteString.copyFrom(t.bytesF);
            size += com.google.protobuf.CodedOutputStream.computeBytesSize(6, f_6);

        }

        Boolean f_7 = null;
        if (!CodedConstant.isNull(t.boolF)) {
            f_7 = t.boolF;
            size += com.google.protobuf.CodedOutputStream.computeBoolSize(7, f_7.booleanValue());

        }
        lruMap.put(t, size);
        
        return size;
    }

    public void doWriteTo(com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO t, CodedOutputStream output)
            throws IOException {

        com.google.protobuf.ByteString f_1 = null;
        if (!CodedConstant.isNull(t.name)) {
            f_1 = com.google.protobuf.ByteString.copyFromUtf8(t.name);
            if (f_1 != null) {
                output.writeBytes(1, f_1);
            }

        }

        Integer f_2 = null;
        if (!CodedConstant.isNull(t.id)) {
            f_2 = t.id;
            if (f_2 != null) {
                output.writeInt32(2, f_2.intValue());
            }

        }

        com.google.protobuf.ByteString f_3 = null;
        if (!CodedConstant.isNull(t.email)) {
            f_3 = com.google.protobuf.ByteString.copyFromUtf8(t.email);
            if (f_3 != null) {
                output.writeBytes(3, f_3);
            }

        }

        Double f_4 = null;
        if (!CodedConstant.isNull(t.doubleF)) {
            f_4 = t.doubleF;
            if (f_4 != null) {
                output.writeDouble(4, f_4.doubleValue());
            }

        }

        Float f_5 = null;
        if (!CodedConstant.isNull(t.floatF)) {
            f_5 = t.floatF;
            if (f_5 != null) {
                output.writeFloat(5, f_5.floatValue());
            }

        }

        com.google.protobuf.ByteString f_6 = null;
        if (!CodedConstant.isNull(t.bytesF)) {
            f_6 = com.google.protobuf.ByteString.copyFrom(t.bytesF);
            if (f_6 != null) {
                output.writeBytes(6, f_6);
            }

        }

        Boolean f_7 = null;
        if (!CodedConstant.isNull(t.boolF)) {
            f_7 = t.boolF;
            if (f_7 != null) {
                output.writeBool(7, f_7.booleanValue());
            }

        }

    }

    public void writeTo(com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO t, CodedOutputStream output)
            throws IOException {
        doWriteTo(t, output);
    }

    public com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO readFrom(CodedInputStream input) throws IOException {
        com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO ret =
                new com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO();

        try {
            boolean done = false;
            Codec codec = null;
            while (!done) {
                int tag = input.readTag();
                if (tag == 0) {
                    break;
                }

                if (tag == 10) {

                    ret.name = input.readString();

                    if (CodedConstant.isNull(ret.name)) {
                        throw new UninitializedMessageException(CodedConstant.asList("name"));
                    }

                    continue;
                }

                if (tag == 16) {

                    ret.id = input.readInt32();

                    if (CodedConstant.isNull(ret.id)) {
                        throw new UninitializedMessageException(CodedConstant.asList("id"));
                    }

                    continue;
                }

                if (tag == 26) {

                    ret.email = input.readString();

                    continue;
                }

                if (tag == 33) {

                    ret.doubleF = input.readDouble();

                    continue;
                }

                if (tag == 45) {

                    ret.floatF = input.readFloat();

                    continue;
                }

                if (tag == 50) {

                    ret.bytesF = input.readBytes().toByteArray();

                    continue;
                }

                if (tag == 56) {

                    ret.boolF = input.readBool();

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

    public com.google.protobuf.Descriptors.Descriptor getDescriptor() throws IOException {
        if (this.descriptor != null) {
            return this.descriptor;
        }
        com.google.protobuf.Descriptors.Descriptor descriptor =
                CodedConstant.getDescriptor(com.baidu.bjf.remoting.protobuf.complexList.PersonPOJO.class);
        return (this.descriptor = descriptor);
    }
}
