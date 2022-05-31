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

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.ProtobufProxyUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.WireFormat;

/**
 * A reflective usage by java reflect utility tools
 * 
 * @author xiemalin
 * @since 1.1.0
 */
public class ReflectiveCodec<T> implements Codec<T> {

    private Class<T> cls;

    private Map<Integer, FieldInfo> orderFieldsMapping;
    private List<FieldInfo> fieldInfos;

    public ReflectiveCodec(Class<T> cls) {
        this.cls = cls;

        List<Field> fields = FieldUtils.findMatchedFields(cls, Protobuf.class);
        if (fields.isEmpty()) {
            throw new IllegalArgumentException("Invalid class [" + cls.getName() + "] no field use annotation @"
                    + Protobuf.class.getName() + " at class " + cls.getName());
        }

        fieldInfos = ProtobufProxyUtils.processDefaultValue(fields);

        orderFieldsMapping = new HashMap<Integer, FieldInfo>();
        for (FieldInfo fieldInfo : fieldInfos) {
            int tag = CodedConstant.makeTag(fieldInfo.getOrder(),
                    fieldInfo.getFieldType().getInternalFieldType().getWireType());
            orderFieldsMapping.put(tag, fieldInfo);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.Codec#encode(java.lang.Object)
     */
    @Override
    public byte[] encode(T t) throws IOException {
        if (t == null) {
            throw new RuntimeException("target object to encode is null.");
        }

        int size = size(t);
        byte[] bytes = new byte[size];
        CodedOutputStream out = CodedOutputStream.newInstance(bytes);
        writeTo(t, out);

        return bytes;
    }

    private int computeSize(FieldInfo fieldInfo, Object value) throws IOException {
        FieldType fieldType = fieldInfo.getFieldType();

        int size = 0;
        if (value instanceof List) {
            // if list
            size = CodedConstant.computeListSize(fieldInfo.getOrder(), (List) value, fieldInfo.getFieldType(), true,
                    null);
            return size;
        }

        int order = fieldInfo.getOrder();
        switch (fieldType) {
            case DOUBLE:
                size = CodedOutputStream.computeDoubleSize(order, (Double) value);
                break;
            case BYTES:
                ByteString bytes = ByteString.copyFrom((byte[]) value);
                size = CodedOutputStream.computeBytesSize(order, bytes);
                break;
            case STRING:
                ByteString string = ByteString.copyFromUtf8(value.toString());
                size = CodedOutputStream.computeBytesSize(order, string);
                break;
            case BOOL:
                size = CodedOutputStream.computeBoolSize(order, (Boolean) value);
                break;
            case FIXED32:
                size = CodedOutputStream.computeFixed32Size(order, (Integer) value);
                break;
            case SFIXED32:
                size = CodedOutputStream.computeSFixed32Size(order, (Integer) value);
                break;
            case SINT32:
                size = CodedOutputStream.computeSInt32Size(order, (Integer) value);
                break;
            case INT32:
                size = CodedOutputStream.computeInt32Size(order, (Integer) value);
                break;
            case UINT32:
                size = CodedOutputStream.computeUInt32Size(order, (Integer) value);
                break;
            case FIXED64:
                size = CodedOutputStream.computeFixed64Size(order, (Long) value);
                break;
            case SFIXED64:
                size = CodedOutputStream.computeSFixed64Size(order, (Long) value);
                break;
            case SINT64:
                size = CodedOutputStream.computeSInt64Size(order, (Long) value);
                break;
            case INT64:
                size = CodedOutputStream.computeInt64Size(order, (Long) value);
                break;
            case UINT64:
                size = CodedOutputStream.computeUInt64Size(order, (Long) value);
                break;
            case ENUM:
                int i;
                i = getEnumValue(value);
                size = CodedOutputStream.computeEnumSize(order, i);
                break;
            case FLOAT:
                size = CodedOutputStream.computeFloatSize(order, (Float) value);
                break;
            case OBJECT:
                Class c = value.getClass();
                ReflectiveCodec codec = new ReflectiveCodec(c);

                int objectSize = codec.size(value);

                size = size + CodedOutputStream.computeRawVarint32Size(objectSize);
                size = size + CodedOutputStream.computeTagSize(order);

                size += objectSize;
                break;
            default:
                throw new IOException("Unknown field type on field '" + fieldInfo.getField().getName() + "'");
        }

        return size;
    }

    private int getEnumValue(Object value) {
        int i;
        if (value instanceof EnumReadable) {
            i = ((EnumReadable) value).value();
        } else {
            Enum e = (Enum) value;
            i = e.ordinal();
        }
        return i;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.Codec#decode(byte[])
     */
    @Override
    public T decode(byte[] bytes) throws IOException {
        if (bytes == null) {
            throw new IOException("byte array is null.");
        }
        CodedInputStream input = CodedInputStream.newInstance(bytes, 0, bytes.length);

        return readFrom(input);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.Codec#size(java.lang.Object)
     */
    @Override
    public int size(T t) throws IOException {
        int size = 0;
        for (FieldInfo fieldInfo : fieldInfos) {
            Object value = FieldUtils.getField(t, fieldInfo.getField());
            // to check required
            if (value == null) {
                if (fieldInfo.isRequired()) {
                    throw new UninitializedMessageException(CodedConstant.asList(fieldInfo.getField().getName()));
                }
            } else {
                size += computeSize(fieldInfo, value);
            }

        }
        return size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.Codec#writeTo(java.lang.Object, com.google.protobuf.CodedOutputStream)
     */
    @Override
    public void writeTo(T t, CodedOutputStream out) throws IOException {
        for (FieldInfo fieldInfo : fieldInfos) {
            Object value = FieldUtils.getField(t, fieldInfo.getField());
            if (value != null) {
                writeTo(fieldInfo, value, out);
            }
        }

    }

    private void writeTo(FieldInfo fieldInfo, Object value, CodedOutputStream out) throws IOException {
        FieldType fieldType = fieldInfo.getFieldType();
        int order = fieldInfo.getOrder();

        if (value instanceof List) {
            // if check list
            CodedConstant.writeToList(out, order, fieldType, (List) value);
            return;
        }

        switch (fieldType) {
            case DOUBLE:
                out.writeDouble(order, (Double) value);
                break;
            case BYTES:
                ByteString bytes = ByteString.copyFrom((byte[]) value);
                out.writeBytes(order, bytes);
                break;
            case STRING:
                ByteString string = ByteString.copyFromUtf8(value.toString());
                out.writeBytes(order, string);
                break;
            case BOOL:
                out.writeBool(order, (Boolean) value);
                break;
            case FIXED32:
                out.writeFixed32(order, (Integer) value);
                break;
            case SFIXED32:
                out.writeSFixed32(order, (Integer) value);
                break;
            case SINT32:
                out.writeSInt32(order, (Integer) value);
                break;
            case INT32:
                out.writeInt32(order, (Integer) value);
                break;
            case UINT32:
                out.writeUInt32(order, (Integer) value);
                break;
            case FIXED64:
                out.writeFixed64(order, (Long) value);
                break;
            case SFIXED64:
                out.writeSFixed64(order, (Long) value);
                break;
            case SINT64:
                out.writeSInt64(order, (Long) value);
                break;
            case INT64:
                out.writeInt64(order, (Long) value);
                break;
            case UINT64:
                out.writeUInt64(order, (Long) value);
                break;
            case ENUM:
                int i;
                i = getEnumValue(value);
                out.writeEnum(order, i);
                break;
            case FLOAT:
                out.writeFloat(order, (Float) value);
                break;
            case OBJECT:
                Class c = value.getClass();
                ReflectiveCodec codec = new ReflectiveCodec(c);
                out.writeRawVarint32(CodedConstant.makeTag(order, WireFormat.WIRETYPE_LENGTH_DELIMITED));
                out.writeRawVarint32(codec.size(value));
                codec.writeTo(value, out);
                break;
            default:
                throw new IOException("Unknown field type on field '" + fieldInfo.getField().getName() + "'");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.Codec#readFrom(com.google.protobuf. CodedInputStream)
     */
    @Override
    public T readFrom(CodedInputStream input) throws IOException {
        T t;
        try {
            t = cls.newInstance();
        } catch (InstantiationException e1) {
            throw new IOException(e1.getMessage(), e1);
        } catch (IllegalAccessException e1) {
            throw new IOException(e1.getMessage(), e1);
        }
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                if (tag == 0) {
                    break;
                }

                FieldInfo fieldInfo = orderFieldsMapping.get(tag);
                if (fieldInfo == null) {
                    input.skipField(tag);
                    // maybe new field added should be ignore
                    continue;
                }

                // check list type
                Field field = fieldInfo.getField();
                Class<?> c = fieldInfo.getField().getType();
                if (List.class.isAssignableFrom(c)) {
                    List list = (List) FieldUtils.getField(t, field);
                    if (list == null) {
                        list = new ArrayList();
                        FieldUtils.setField(t, field, list);
                    }
                    list.add(readValue(input, fieldInfo));
                    continue;
                }

                FieldType fieldType = fieldInfo.getFieldType();
                switch (fieldType) {
                    case DOUBLE:
                        FieldUtils.setField(t, field, input.readDouble());
                        break;
                    case BYTES:
                        FieldUtils.setField(t, field, input.readBytes().toByteArray());
                        break;
                    case STRING:
                        FieldUtils.setField(t, field, input.readString());
                        break;
                    case BOOL:
                        FieldUtils.setField(t, field, input.readBool());
                        break;
                    case FIXED32:
                        FieldUtils.setField(t, field, input.readFixed32());
                        break;
                    case SFIXED32:
                        FieldUtils.setField(t, field, input.readSFixed32());
                        break;
                    case SINT32:
                        FieldUtils.setField(t, field, input.readSInt32());
                        break;
                    case INT32:
                        FieldUtils.setField(t, field, input.readInt32());
                        break;
                    case UINT32:
                        FieldUtils.setField(t, field, input.readUInt32());
                        break;
                    case FIXED64:
                        FieldUtils.setField(t, field, input.readFixed64());
                        break;
                    case SFIXED64:
                        FieldUtils.setField(t, field, input.readSFixed64());
                        break;
                    case SINT64:
                        FieldUtils.setField(t, field, input.readSInt64());
                        break;
                    case INT64:
                        FieldUtils.setField(t, field, input.readInt64());
                        break;
                    case UINT64:
                        FieldUtils.setField(t, field, input.readUInt64());
                        break;
                    case ENUM:
                        Class<?> type = field.getType();
                        try {
                            Method method = type.getMethod("values");
                            Enum[] inter = (Enum[]) method.invoke(null, null);

                            if (Enum.class.isAssignableFrom(type)) {
                                Enum value = CodedConstant.getEnum(inter, input.readEnum());
                                FieldUtils.setField(t, fieldInfo.getField(), value);
                            }
                        } catch (Exception e) {
                            throw new IOException(e.getMessage(), e);
                        }
                        break;
                    case FLOAT:
                        FieldUtils.setField(t, field, input.readFloat());
                        break;
                    case OBJECT:
                        ReflectiveCodec codec = new ReflectiveCodec(c);

                        int length = input.readRawVarint32();
                        final int oldLimit = input.pushLimit(length);
                        Object o = codec.readFrom(input);
                        FieldUtils.setField(t, fieldInfo.getField(), o);
                        input.checkLastTagWas(0);
                        input.popLimit(oldLimit);
                        break;
                    default:
                        throw new IOException("Unknown field type on field '" + fieldInfo.getField().getName() + "'");
                }

            }

        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e;
        } catch (java.io.IOException e) {
            throw e;
        }

        return t;
    }

    private Object readValue(CodedInputStream input, FieldInfo fieldInfo) throws IOException {
        FieldType fieldType = fieldInfo.getFieldType();
        switch (fieldType) {
            case DOUBLE:
                return input.readDouble();
            case BYTES:
                return input.readBytes().toByteArray();
            case STRING:
                return input.readString();
            case BOOL:
                return input.readBool();
            case FIXED32:
                return input.readFixed32();
            case SFIXED32:
                return input.readSFixed32();
            case SINT32:
                return input.readSInt32();
            case INT32:
                return input.readInt32();
            case UINT32:
                return input.readUInt32();
            case FIXED64:
                return input.readFixed64();
            case SFIXED64:
                return input.readSFixed64();
            case SINT64:
                return input.readSInt64();
            case INT64:
                return input.readInt64();
            case UINT64:
                return input.readUInt64();
            case ENUM:
                Class<?> type = null;
                if (fieldInfo.isList()) {
                    type = fieldInfo.getGenericKeyType();
                } else {
                    type = fieldInfo.getField().getType();
                }
                try {
                    Method method = type.getMethod("values");
                    Enum[] inter = (Enum[]) method.invoke(null, null);

                    if (Enum.class.isAssignableFrom(type)) {
                        Enum value = CodedConstant.getEnum(inter, input.readEnum());
                        return value;
                    }
                } catch (Exception e) {
                    throw new IOException(e.getMessage(), e);
                }
                break;
            case FLOAT:
                return input.readFloat();
            case OBJECT:
                if (fieldInfo.isList()) {
                    Class<?> c = fieldInfo.getGenericKeyType();
                    ReflectiveCodec codec = new ReflectiveCodec(c);

                    int length = input.readRawVarint32();
                    final int oldLimit = input.pushLimit(length);
                    Object o = codec.readFrom(input);
                    input.checkLastTagWas(0);
                    input.popLimit(oldLimit);
                    return o;
                }
                Class<?> c = fieldInfo.getField().getType();
                ReflectiveCodec codec = new ReflectiveCodec(c);

                int length = input.readRawVarint32();
                final int oldLimit = input.pushLimit(length);
                Object o = codec.readFrom(input);
                input.checkLastTagWas(0);
                input.popLimit(oldLimit);
                return o;
            default:
                throw new IOException("Unknown field type on field '" + fieldInfo.getField().getName() + "'");
        }

        return null;
    }

}
