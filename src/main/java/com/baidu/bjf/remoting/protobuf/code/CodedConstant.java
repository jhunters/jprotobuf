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
package com.baidu.bjf.remoting.protobuf.code;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.EnumHandler;
import com.baidu.bjf.remoting.protobuf.EnumReadable;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLGenerator;
import com.baidu.bjf.remoting.protobuf.ProtobufIDLProxy;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.descriptor.DescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.EnumDescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.EnumOptionsPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.EnumValueDescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.ExtensionRangePOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.FieldDescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.FileDescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.Label;
import com.baidu.bjf.remoting.protobuf.descriptor.MessageOptionsPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.OneofDescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.ServiceDescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.Type;
import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.ProtobufProxyUtils;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.baidu.jprotobuf.com.squareup.protoparser.DataType;
import com.baidu.jprotobuf.com.squareup.protoparser.DataType.Kind;
import com.baidu.jprotobuf.com.squareup.protoparser.DataType.MapType;
import com.baidu.jprotobuf.com.squareup.protoparser.EnumConstantElement;
import com.baidu.jprotobuf.com.squareup.protoparser.EnumElement;
import com.baidu.jprotobuf.com.squareup.protoparser.FieldElement;
import com.baidu.jprotobuf.com.squareup.protoparser.FieldElement.Builder;
import com.baidu.jprotobuf.com.squareup.protoparser.MessageElement;
import com.baidu.jprotobuf.com.squareup.protoparser.OptionElement;
import com.baidu.jprotobuf.com.squareup.protoparser.ProtoFile;
import com.baidu.jprotobuf.com.squareup.protoparser.ProtoParser;
import com.baidu.jprotobuf.com.squareup.protoparser.TypeElement;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;

/**
 * Utility class for codec.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public class CodedConstant {

    private static final String FIELD_PREFIX = "f_";

    /** The Constant MAP_ENTRY_SUFFIX. */
    private static final String MAP_ENTRY_SUFFIX = "Entry";

    /** The Constant WIREFORMAT_CLSNAME. */
    private static final String WIREFORMAT_CLSNAME =
            ClassHelper.getInternalName(com.google.protobuf.WireFormat.FieldType.class.getCanonicalName());

    /**
     * get field name.
     *
     * @param order field order
     * @return field name
     */
    public static String getFieldName(int order) {
        String fieldName = FIELD_PREFIX + order;
        return fieldName;
    }

    /**
     * Compute the number of bytes that would be needed to encode a single tag/value pair of arbitrary type.
     *
     * @param type The field's type.
     * @param number The field's number.
     * @param value Object representing the field's value. Must be of the exact type which would be returned by
     *            {@link Message#getField(Descriptors.FieldDescriptor)} for this field.
     * @return the int
     */
    public static int computeElementSize(final WireFormat.FieldType type, final int number, final Object value) {
        int tagSize = CodedOutputStream.computeTagSize(number);
        if (type == WireFormat.FieldType.GROUP) {
            // Only count the end group tag for proto2 messages as for proto1 the end
            // group tag will be counted as a part of getSerializedSize().
            tagSize *= 2;
        }
        return tagSize + computeElementSizeNoTag(type, value);
    }

    /**
     * get mapped type defined java expression.
     * 
     * @param order field order
     * @param type field type
     * @param express java expression
     * @param isList is field type is a {@link List}
     * @param isMap is field type is a {@link Map}
     * @return full java expression
     */
    public static String getMappedTypeDefined(int order, FieldType type, String express, boolean isList,
            boolean isMap) {
        StringBuilder code = new StringBuilder();
        String fieldName = getFieldName(order);
        if ((type == FieldType.STRING || type == FieldType.BYTES) && !isList) {
            // add null check
            code.append("com.google.protobuf.ByteString ").append(fieldName).append(" = null")
                    .append(ICodeGenerator.JAVA_LINE_BREAK);
            code.append("if (!CodedConstant.isNull(").append(express).append(")) {").append(ICodeGenerator.LINE_BREAK);

            String method = "copyFromUtf8";
            if (type == FieldType.BYTES) {
                method = "copyFrom";
            }
            code.append(fieldName).append(" = com.google.protobuf.ByteString.").append(method).append("(")
                    .append(express).append(")").append(ICodeGenerator.JAVA_LINE_BREAK);
            code.append("}").append(ICodeGenerator.LINE_BREAK);
            return code.toString();
        }
        // add null check
        String defineType = type.getJavaType();
        if (isList) {
            defineType = "List";
        } else if (isMap) {
            defineType = "Map";
        }
        code.setLength(0);
        code.append(defineType).append(" ").append(fieldName).append(" = null").append(ICodeGenerator.JAVA_LINE_BREAK);
        code.append("if (!CodedConstant.isNull(").append(express).append(")) {").append(ICodeGenerator.LINE_BREAK);
        code.append(fieldName).append(" = ").append(express).append(ICodeGenerator.JAVA_LINE_BREAK);
        code.append("}").append(ICodeGenerator.LINE_BREAK);
        return code.toString();
    }

    /**
     * Gets the filed type.
     *
     * @param type the type
     * @param isList the is list
     * @return the filed type
     */
    public static String getFiledType(FieldType type, boolean isList) {
        // add null check
        String defineType = type.getJavaType();
        if (isList) {
            defineType = "Collection";
        }

        return defineType;

    }

    /**
     * Gets the write value to field.
     *
     * @param type the type
     * @param express the express
     * @param isList the is list
     * @return the write value to field
     */
    public static String getWriteValueToField(FieldType type, String express, boolean isList) {
        return express;
    }

    /**
     * Gets the mapped type size.
     *
     * @param field field
     * @param order field order
     * @param type field type
     * @param isList is field type is a {@link List}
     * @param isMap the is map
     * @param debug debug mode if true enable debug.
     * @param path the path
     * @return full java expression
     */
    public static String getMappedTypeSize(FieldInfo field, int order, FieldType type, boolean isList, boolean isMap,
            boolean debug, File path) {
        String fieldName = getFieldName(order);

        String spath = "null";
        if (path != null) {
            spath = "ProtobufProxy.OUTPUT_PATH.get()";
        }

        String typeString = type.getType().toUpperCase();
        if (isList) {
            return "CodedConstant.computeListSize(" + order + ", " + fieldName + ", " + FieldType.class.getName() + "."
                    + typeString + ", " + Boolean.valueOf(debug) + ", " + spath + ","
                    + Boolean.valueOf(field.isPacked()) + ")" + ICodeGenerator.JAVA_LINE_BREAK;
        } else if (isMap) {

            String joinedSentence = getMapFieldGenericParameterString(field);
            return "CodedConstant.computeMapSize(" + order + ", " + fieldName + ", " + joinedSentence + ")"
                    + ICodeGenerator.JAVA_LINE_BREAK;
        }

        if (type == FieldType.OBJECT) {
            return "CodedConstant.computeSize(" + order + "," + fieldName + ", " + FieldType.class.getName() + "."
                    + typeString + "," + Boolean.valueOf(debug) + "," + spath + ")" + ICodeGenerator.JAVA_LINE_BREAK;
        }

        String t = type.getType();
        if (type == FieldType.STRING) {
            t = "String";
        }

        if (type == FieldType.BYTES) {
            t = "ByteArray";
        }
        t = capitalize(t);

        boolean enumSpecial = false;
        if (type == FieldType.ENUM) {
            if (EnumReadable.class.isAssignableFrom(field.getField().getType())) {
                String clsName = ClassHelper.getInternalName(field.getField().getType().getCanonicalName());
                fieldName = "((" + clsName + ") " + fieldName + ").value()";
                enumSpecial = true;
            }
        }
        if (!enumSpecial) {
            fieldName = fieldName + type.getToPrimitiveType();
        }

        return "com.google.protobuf.CodedOutputStream.compute" + t + "Size(" + order + "," + fieldName + ")"
                + ICodeGenerator.JAVA_LINE_BREAK;
    }

    /**
     * Gets the map field generic parameter string.
     *
     * @param field the field
     * @return the map field generic parameter string
     */
    public static String getMapFieldGenericParameterString(FieldInfo field) {
        FieldType fieldType = ProtobufProxyUtils.TYPE_MAPPING.get(field.getGenericKeyType());
        String keyClass;
        String defaultKeyValue;
        if (fieldType == null) {
            // may be object or enum
            if (Enum.class.isAssignableFrom(field.getGenericKeyType())) {
                keyClass = WIREFORMAT_CLSNAME + ".ENUM";
                Class<?> declaringClass = field.getGenericKeyType();
                Field[] fields = declaringClass.getFields();
                if (fields != null && fields.length > 0) {
                    defaultKeyValue = ClassHelper.getInternalName(field.getGenericKeyType().getCanonicalName()) + "."
                            + fields[0].getName();
                } else {
                    defaultKeyValue = "0";
                }

            } else {
                keyClass = WIREFORMAT_CLSNAME + ".MESSAGE";
                // check constructor
                boolean hasDefaultConstructor = ClassHelper.hasDefaultConstructor(field.getGenericKeyType());
                if (!hasDefaultConstructor) {
                    throw new IllegalArgumentException("Class '" + field.getGenericKeyType().getCanonicalName()
                            + "' must has default constructor method with no parameters.");
                }
                defaultKeyValue =
                        "new " + ClassHelper.getInternalName(field.getGenericKeyType().getCanonicalName()) + "()";
            }
        } else {
            keyClass = WIREFORMAT_CLSNAME + "." + fieldType.toString();
            // check type

            defaultKeyValue = fieldType.getDefaultValue();
        }

        fieldType = ProtobufProxyUtils.TYPE_MAPPING.get(field.getGenericeValueType());
        String valueClass;
        String defaultValueValue;
        if (fieldType == null) {
            // may be object or enum
            if (Enum.class.isAssignableFrom(field.getGenericeValueType())) {
                valueClass = WIREFORMAT_CLSNAME + ".ENUM";
                Class<?> declaringClass = field.getGenericeValueType();
                Field[] fields = declaringClass.getFields();
                if (fields != null && fields.length > 0) {
                    defaultValueValue = ClassHelper.getInternalName(field.getGenericeValueType().getCanonicalName())
                            + "." + fields[0].getName();
                } else {
                    defaultValueValue = "0";
                }

            } else {
                valueClass = WIREFORMAT_CLSNAME + ".MESSAGE";
                // check constructor
                boolean hasDefaultConstructor = ClassHelper.hasDefaultConstructor(field.getGenericeValueType());
                if (!hasDefaultConstructor) {
                    throw new IllegalArgumentException("Class '" + field.getGenericeValueType().getCanonicalName()
                            + "' must has default constructor method with no parameters.");
                }
                defaultValueValue =
                        "new " + ClassHelper.getInternalName(field.getGenericeValueType().getCanonicalName()) + "()";
            }
        } else {
            valueClass = WIREFORMAT_CLSNAME + "." + fieldType.toString();
            defaultValueValue = fieldType.getDefaultValue();
        }
        String joinedSentence = keyClass + "," + defaultKeyValue + "," + valueClass + "," + defaultValueValue;
        return joinedSentence;
    }

    /**
     * Compute list size.
     *
     * @param order field order
     * @param list field value
     * @param type field type of list obj
     * @param debug the debug
     * @param path the path
     * @return full java expression
     */
    public static int computeListSize(int order, Collection<?> list, FieldType type, boolean debug, File path) {
        return computeListSize(order, list, type, debug, path, false, false);
    }

    /**
     * Compute list size.
     *
     * @param order the order
     * @param list the list
     * @param type the type
     * @param debug the debug
     * @param path the path
     * @param packed the packed
     * @return the int
     */
    public static int computeListSize(int order, Collection list, FieldType type, boolean debug, File path,
            boolean packed) {
        return computeListSize(order, list, type, debug, path, packed, false);
    }

    /**
     * Compute list size.
     *
     * @param order the order
     * @param list the list
     * @param type the type
     * @param debug the debug
     * @param path the path
     * @param packed the packed
     * @param sizeOnly the size only if true will not include order size and tag size
     * @return the int
     */
    public static int computeListSize(int order, Collection list, FieldType type, boolean debug, File path,
            boolean packed, boolean sizeOnly) {
        int size = 0;
        if (list == null || list.isEmpty()) {
            return size;
        }

        int dataSize = 0;
        for (Object object : list) {
            dataSize += computeSize(order, object, type, debug, path);
        }
        size += dataSize;
        if (type != FieldType.OBJECT) {
            if (packed) {
                if (!sizeOnly) {
                    size += com.google.protobuf.CodedOutputStream.computeInt32SizeNoTag(dataSize);
                    int tag = CodedConstant.makeTag(order, WireFormat.WIRETYPE_LENGTH_DELIMITED);
                    size += com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(tag);
                }
            } else {
                size += list.size() * CodedOutputStream.computeTagSize(order);
            }
        }
        return size;
    }

    /**
     * Compute map size.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param order the order
     * @param map the map
     * @param keyType the key type
     * @param defaultKey the default key
     * @param valueType the value type
     * @param defalutValue the defalut value
     * @return the int
     */
    public static <K, V> int computeMapSize(int order, Map<K, V> map, com.google.protobuf.WireFormat.FieldType keyType,
            K defaultKey, com.google.protobuf.WireFormat.FieldType valueType, V defalutValue) {
        int size = 0;
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            com.baidu.bjf.remoting.protobuf.MapEntry<K, V> valuesDefaultEntry = com.baidu.bjf.remoting.protobuf.MapEntry
                    .<K, V> newDefaultInstance(null, keyType, defaultKey, valueType, defalutValue);

            com.baidu.bjf.remoting.protobuf.MapEntry<K, V> values =
                    valuesDefaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build();

            size += com.google.protobuf.CodedOutputStream.computeMessageSize(order, values);
        }
        return size;
    }

    /**
     * Put map value.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param input the input
     * @param map the map
     * @param keyType the key type
     * @param defaultKey the default key
     * @param valueType the value type
     * @param defalutValue the defalut value
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static <K, V> void putMapValue(CodedInputStream input, Map<K, V> map,
            com.google.protobuf.WireFormat.FieldType keyType, K defaultKey,
            com.google.protobuf.WireFormat.FieldType valueType, V defalutValue) throws IOException {
        putMapValue(input, map, keyType, defaultKey, valueType, defalutValue, null);

    }

    public static <K, V> void putMapValue(CodedInputStream input, Map<K, V> map,
            com.google.protobuf.WireFormat.FieldType keyType, K defaultKey,
            com.google.protobuf.WireFormat.FieldType valueType, V defalutValue, EnumHandler<V> handler)
            throws IOException {
        putMapValue(input, map, keyType, defaultKey, valueType, defalutValue, null, handler);

    }
    
    
    public static <K, V> void putMapValue(CodedInputStream input, Map<K, V> map,
            com.google.protobuf.WireFormat.FieldType keyType, K defaultKey,
            com.google.protobuf.WireFormat.FieldType valueType, V defalutValue, EnumHandler<K> keyHandler, EnumHandler<V> valHandler)
            throws IOException {
        com.baidu.bjf.remoting.protobuf.MapEntry<K, V> valuesDefaultEntry = com.baidu.bjf.remoting.protobuf.MapEntry
                .<K, V> newDefaultInstance(null, keyType, defaultKey, valueType, defalutValue);

        com.baidu.bjf.remoting.protobuf.MapEntry<K, V> values =
                input.readMessage(valuesDefaultEntry.getParserForType(), null);

        Object value = values.getValue();
        Object key = values.getKey();
        if (keyHandler != null) {
            key = keyHandler.handle((int) key);
        }
        
        if (valHandler != null) {
            value = valHandler.handle((int) value);
        }
        map.put((K) key, (V) value);
    }

    /**
     * Write to map.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param output the output
     * @param order the order
     * @param map the map
     * @param keyType the key type
     * @param defaultKey the default key
     * @param valueType the value type
     * @param defalutValue the defalut value
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static <K, V> void writeToMap(CodedOutputStream output, int order, Map<K, V> map,
            com.google.protobuf.WireFormat.FieldType keyType, K defaultKey,
            com.google.protobuf.WireFormat.FieldType valueType, V defalutValue) throws IOException {
        com.baidu.bjf.remoting.protobuf.MapEntry<K, V> valuesDefaultEntry = com.baidu.bjf.remoting.protobuf.MapEntry
                .<K, V> newDefaultInstance(null, keyType, defaultKey, valueType, defalutValue);
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            com.baidu.bjf.remoting.protobuf.MapEntry<K, V> values =
                    valuesDefaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build();
            output.writeMessage(order, values);
        }
    }

    /**
     * get object size by {@link FieldType}.
     *
     * @param order the order
     * @param o the o
     * @param type the type
     * @param debug the debug
     * @param path the path
     * @return the int
     */
    public static int computeSize(int order, Object o, FieldType type, boolean debug, File path) {
        return computeSize(order, o, type, false, debug, path);
    }

    /**
     * Compute object size no tag.
     *
     * @param o the o
     * @return the int
     */
    public static int computeObjectSizeNoTag(Object o) {
        int size = 0;
        if (o == null) {
            return size;
        }

        Class cls = o.getClass();
        Codec target = ProtobufProxy.create(cls, ProtobufProxy.isDebugEnabled());
        try {
            size = target.size(o);
            size = size + CodedOutputStream.computeRawVarint32Size(size);
            return size;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * get object size by {@link FieldType}.
     *
     * @param order the order
     * @param o the o
     * @param type the type
     * @param list the list
     * @param debug the debug
     * @param path the path
     * @return the int
     */
    public static int computeSize(int order, Object o, FieldType type, boolean list, boolean debug, File path) {
        int size = 0;
        if (o == null) {
            return size;
        }

        if (type == FieldType.OBJECT) {
            Class cls = o.getClass();
            Codec target = ProtobufProxy.create(cls, debug, path);
            try {
                size = target.size(o);
                size = size + CodedOutputStream.computeRawVarint32Size(size);
                return size + CodedOutputStream.computeTagSize(order);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        if (type == FieldType.STRING) {
            size = CodedOutputStream.computeStringSizeNoTag(String.valueOf(o));
        } else if (type == FieldType.BOOL) {
            size = CodedOutputStream.computeBoolSizeNoTag(Boolean.valueOf(String.valueOf(o)));
        } else if (type == FieldType.BYTES) {
            byte[] bb = (byte[]) o;
            size = CodedOutputStream.computeBytesSizeNoTag(ByteString.copyFrom(bb));
        } else if (type == FieldType.DOUBLE) {
            size = CodedOutputStream.computeDoubleSizeNoTag(Double.valueOf(o.toString()));
        } else if (type == FieldType.FIXED32 || type == FieldType.SFIXED32) {
            size = CodedOutputStream.computeFixed32SizeNoTag(Integer.valueOf(o.toString()));
        } else if (type == FieldType.INT32 || type == FieldType.SINT32 || type == FieldType.UINT32) {
            size = CodedOutputStream.computeInt32SizeNoTag(Integer.valueOf(o.toString()));
        }else if (type == FieldType.FIXED64|| type == FieldType.SFIXED64) {
            size = CodedOutputStream.computeSFixed64SizeNoTag(Long.valueOf(o.toString()));
        }   else if (type == FieldType.INT64 || type == FieldType.SINT64 || type == FieldType.UINT64) {
            size = CodedOutputStream.computeInt64SizeNoTag(Long.valueOf(o.toString()));
        } else if (type == FieldType.FLOAT) {
            size = CodedOutputStream.computeFloatSizeNoTag(Float.valueOf(o.toString()));
        } else if (type == FieldType.ENUM) {
            if (o instanceof EnumReadable) {
                size = CodedOutputStream.computeInt32SizeNoTag(((EnumReadable) o).value());
            } else if (o instanceof Enum) {
                size = CodedOutputStream.computeInt32SizeNoTag(((Enum) o).ordinal());
            }
        }

        return size;
    }

    /**
     * get mapped object byte write java expression.
     *
     * @param field the field
     * @param prefix the prefix
     * @param order field order
     * @param type field type
     * @param isList the is list
     * @param isMap the is map
     * @return full java expression
     */
    public static String getMappedWriteCode(FieldInfo field, String prefix, int order, FieldType type, boolean isList,
            boolean isMap) {
        String fieldName = getFieldName(order);
        StringBuilder ret = new StringBuilder();
        ret.append("if (").append(fieldName).append(" != null){").append(ICodeGenerator.LINE_BREAK);

        if (isList) {
            String typeString = type.getType().toUpperCase();
            ret.append("CodedConstant.writeToList(").append(prefix).append(",");
            ret.append(order).append(",").append(FieldType.class.getName()).append(".").append(typeString);
            ret.append(",").append(fieldName).append(",").append(Boolean.valueOf(field.isPacked())).append(")")
                    .append(ICodeGenerator.JAVA_LINE_BREAK).append("}").append(ICodeGenerator.LINE_BREAK);
            return ret.toString();
        } else if (isMap) {
            ret.append("CodedConstant.writeToMap(").append(prefix).append(",");
            ret.append(order).append(",").append(fieldName);

            String joinedSentence = getMapFieldGenericParameterString(field);
            ret.append(",").append(joinedSentence);

            ret.append(")").append(ICodeGenerator.JAVA_LINE_BREAK).append("}").append(ICodeGenerator.LINE_BREAK);
            return ret.toString();

        } else {
            // not list so should add convert to primitive type
            boolean enumSpecial = false;
            if (type == FieldType.ENUM) {
                if (EnumReadable.class.isAssignableFrom(field.getField().getType())) {
                    String clsName = ClassHelper.getInternalName(field.getField().getType().getCanonicalName());
                    fieldName = "((" + clsName + ") " + fieldName + ").value()";
                    enumSpecial = true;
                }
            }
            if (!enumSpecial) {
                fieldName = fieldName + type.getToPrimitiveType();
            }
        }

        if (type == FieldType.OBJECT) {
            String typeString = type.getType().toUpperCase();
            ret.append("CodedConstant.writeObject(").append(prefix).append(",");
            ret.append(order).append(",").append(FieldType.class.getName()).append(".").append(typeString);
            ret.append(",").append(fieldName).append(", false)").append(ICodeGenerator.JAVA_LINE_BREAK).append("}")
                    .append(ICodeGenerator.LINE_BREAK);
            return ret.toString();
        }

        if (type == FieldType.STRING) {
            ret.append(prefix).append(".writeString(").append(order);
            ret.append(", ").append(fieldName).append(")").append(ICodeGenerator.JAVA_LINE_BREAK).append("}")
                    .append(ICodeGenerator.LINE_BREAK);
            return ret.toString();
        }

        if (type == FieldType.BYTES) {
            ret.append(prefix).append(".writeByteArray(").append(order);
            ret.append(", ").append(fieldName).append(")").append(ICodeGenerator.JAVA_LINE_BREAK).append("}")
                    .append(ICodeGenerator.LINE_BREAK);
            return ret.toString();
        }

        String t = type.getType();
        t = capitalize(t);

        ret.append(prefix).append(".write").append(t).append("(").append(order);
        ret.append(", ").append(fieldName).append(")").append(ICodeGenerator.JAVA_LINE_BREAK).append("}")
                .append(ICodeGenerator.LINE_BREAK);
        return ret.toString();
    }

    /**
     * Write to list.
     *
     * @param out the out
     * @param order the order
     * @param type the type
     * @param list the list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void writeToList(CodedOutputStream out, int order, FieldType type, Collection list)
            throws IOException {
        writeToList(out, order, type, list, false);
    }

    /**
     * write list to {@link CodedOutputStream} object.
     *
     * @param out target output stream to write
     * @param order field order
     * @param type field type
     * @param list target list object to be serialized
     * @param packed the packed
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void writeToList(CodedOutputStream out, int order, FieldType type, Collection list, boolean packed)
            throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }

        CodecOutputByteArray output = CodecOutputByteArray.get();
        for (Object object : list) {
            if (object == null) {
                throw new NullPointerException("List can not include Null value.");
            }
            writeObject(output.getCodedOutputStream(), order, type, object, true, !packed);
        }
        byte[] byteArray = output.getData();

        if (packed) {
            out.writeUInt32NoTag(makeTag(order, WireFormat.WIRETYPE_LENGTH_DELIMITED));
            out.writeUInt32NoTag(byteArray.length);
        }

        out.write(byteArray, 0, byteArray.length);

    }

    /**
     * Write object.
     *
     * @param out the out
     * @param order the order
     * @param type the type
     * @param o the o
     * @param list the list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void writeObject(CodedOutputStream out, int order, FieldType type, Object o, boolean list)
            throws IOException {
        writeObject(out, order, type, o, list, true);
    }

    /**
     * Write object to byte array by {@link FieldType}.
     *
     * @param out the out
     * @param order the order
     * @param type the type
     * @param o the o
     * @param list the list
     * @param withTag the with tag
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void writeObject(CodedOutputStream out, int order, FieldType type, Object o, boolean list,
            boolean withTag) throws IOException {
        if (o == null) {
            return;
        }

        if (type == FieldType.OBJECT) {

            Class cls = o.getClass();
            Codec target = ProtobufProxy.create(cls, ProtobufProxy.isDebugEnabled());

            if (withTag) {
                out.writeUInt32NoTag(makeTag(order, WireFormat.WIRETYPE_LENGTH_DELIMITED));
            }

            byte[] byteArray = CodecOutputByteArray.getData(target, o);
            out.writeUInt32NoTag(byteArray.length);
            out.write(byteArray, 0, byteArray.length);

            return;
        }

        if (type == FieldType.BOOL) {
            if (withTag) {
                out.writeBool(order, (Boolean) o);
            } else {
                out.writeBoolNoTag((Boolean) o);
            }
        } else if (type == FieldType.BYTES) {
            byte[] bb = (byte[]) o;
            if (withTag) {
                out.writeBytes(order, ByteString.copyFrom(bb));
            } else {
                out.writeBytesNoTag(ByteString.copyFrom(bb));
            }
        } else if (type == FieldType.DOUBLE) {
            if (withTag) {
                out.writeDouble(order, (Double) o);
            } else {
                out.writeDoubleNoTag((Double) o);
            }
        } else if (type == FieldType.FIXED32) {
            if (withTag) {
                out.writeFixed32(order, (Integer) o);
            } else {
                out.writeFixed32NoTag((Integer) o);
            }
        } else if (type == FieldType.FIXED64) {
            if (withTag) {
                out.writeFixed64(order, (Long) o);
            } else {
                out.writeFixed64NoTag((Long) o);
            }
        } else if (type == FieldType.FLOAT) {
            if (withTag) {
                out.writeFloat(order, (Float) o);
            } else {
                out.writeFloatNoTag((Float) o);
            }
        } else if (type == FieldType.INT32) {
            if (withTag) {
                out.writeInt32(order, (Integer) o);
            } else {
                out.writeInt32NoTag((Integer) o);
            }
        } else if (type == FieldType.INT64) {
            if (withTag) {
                out.writeInt64(order, (Long) o);
            } else {
                out.writeInt64NoTag((Long) o);
            }
        } else if (type == FieldType.SFIXED32) {
            if (withTag) {
                out.writeSFixed32(order, (Integer) o);
            } else {
                out.writeSFixed32NoTag((Integer) o);
            }
        } else if (type == FieldType.SFIXED64) {
            if (withTag) {
                out.writeSFixed64(order, (Long) o);
            } else {
                out.writeSFixed64NoTag((Long) o);
            }
        } else if (type == FieldType.SINT32) {
            if (withTag) {
                out.writeSInt32(order, (Integer) o);
            } else {
                out.writeSInt32NoTag((Integer) o);
            }
        } else if (type == FieldType.SINT64) {
            if (withTag) {
                out.writeSInt64(order, (Long) o);
            } else {
                out.writeSInt64NoTag((Long) o);
            }
        } else if (type == FieldType.STRING) {
            if (withTag) {
                out.writeBytes(order, ByteString.copyFromUtf8(String.valueOf(o)));
            } else {
                out.writeBytesNoTag(ByteString.copyFromUtf8(String.valueOf(o)));
            }
        } else if (type == FieldType.UINT32) {
            if (withTag) {
                out.writeUInt32(order, (Integer) o);
            } else {
                out.writeUInt32NoTag((Integer) o);
            }
        } else if (type == FieldType.UINT64) {
            if (withTag) {
                out.writeUInt64(order, (Long) o);
            } else {
                out.writeUInt64NoTag((Long) o);
            }
        } else if (type == FieldType.ENUM) {
            int value = 0;
            if (o instanceof EnumReadable) {
                value = ((EnumReadable) o).value();
            } else if (o instanceof Enum) {
                value = ((Enum) o).ordinal();
            }
            if (withTag) {
                out.writeEnum(order, value);

            } else {
                out.writeEnumNoTag(value);
            }
        }
    }

    /**
     * get required field check java expression.
     *
     * @param order field order
     * @param field java field
     * @return full java expression
     */
    public static String getRequiredCheck(int order, Field field) {
        String fieldName = getFieldName(order);
        String code = "if (" + fieldName + "== null) {\n";
        code += "throw new UninitializedMessageException(CodedConstant.asList(\"" + field.getName() + "\"));\n";
        code += "}\n";

        return code;
    }

    /**
     * get return required field check java expression.
     *
     * @param express java expression
     * @param field java field
     * @return full java expression
     */
    public static String getRetRequiredCheck(String express, Field field) {
        String code = "if (CodedConstant.isNull(" + express + ")) {\n";
        code += "throw new UninitializedMessageException(CodedConstant.asList(\"" + field.getName() + "\"));\n";
        code += "}\n";

        return code;
    }

    /**
     * check object is null.
     *
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(Object o) {
        return o == null;
    }

    /**
     * check double is null.
     *
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(double o) {
        return false;
    }

    /**
     * check int is null.
     *
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(int o) {
        return false;
    }

    /**
     * check byte is null.
     *
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(byte o) {
        return false;
    }

    /**
     * check short is null.
     *
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(short o) {
        return false;
    }

    /**
     * check long is null.
     *
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(long o) {
        return false;
    }

    /**
     * check float is null.
     *
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(float o) {
        return false;
    }

    /**
     * check char is null.
     *
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(char o) {
        return false;
    }

    /**
     * As list.
     *
     * @param value the value
     * @return the list
     */
    public static List asList(String value) {
        return Arrays.asList(value);
    }

    /**
     * <p>
     * Capitalizes a String changing the first letter to title case as per {@link Character#toTitleCase(char)}. No other
     * letters are changed.
     * </p>
     * 
     * @param str the String to capitalize, may be null
     * @return the capitalized String, <code>null</code> if null String input
     */
    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuilder(strLen).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1))
                .toString();
    }

    /** bit type tag value. */
    static final int TAG_TYPE_BITS = 3;

    /**
     * make protobuf tag.
     *
     * @param fieldNumber field number order
     * @param wireType wireformat type
     * @return tag id
     */
    public static int makeTag(final int fieldNumber, final int wireType) {
        return (fieldNumber << TAG_TYPE_BITS) | wireType;
    }

    /**
     * Gets the enum name.
     *
     * @param e the e
     * @param value the value
     * @return the enum name
     */
    public static String getEnumName(Enum[] e, int value) {
        if (e != null) {
            int toCompareValue;
            for (Enum en : e) {
                if (en instanceof EnumReadable) {
                    toCompareValue = ((EnumReadable) en).value();
                } else {
                    toCompareValue = en.ordinal();
                }
                if (value == toCompareValue) {
                    return en.name();
                }
            }
        }
        return "";
    }

    /**
     * Gets the enum value.
     *
     * @param en the en
     * @return the enum value
     */
    public static int getEnumValue(Enum en) {
        if (en != null) {
            int toCompareValue;
            if (en instanceof EnumReadable) {
                toCompareValue = ((EnumReadable) en).value();
            } else {
                toCompareValue = en.ordinal();
            }
            return toCompareValue;
        }

        return -1;
    }

    /**
     * Gets the enumeration value.
     *
     * @param <T> the generic type
     * @param enumType the enum type
     * @param name the name
     * @return the enum value
     */
    public static <T extends Enum<T>> T getEnumValue(Class<T> enumType, String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }

        try {
            T v = Enum.valueOf(enumType, name);
            return v;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Read a field of any primitive type for immutable messages from a CodedInputStream. Enums, groups, and embedded
     * messages are not handled by this method.
     *
     * @param input The stream from which to read.
     * @param type Declared type of the field.
     * @param checkUtf8 When true, check that the input is valid utf8.
     * @return An object representing the field's value, of the exact type which would be returned by
     *         {@link Message#getField(Descriptors.FieldDescriptor)} for this field.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Object readPrimitiveField(CodedInputStream input, final WireFormat.FieldType type, boolean checkUtf8)
            throws IOException {
        switch (type) {
            case DOUBLE:
                return input.readDouble();
            case FLOAT:
                return input.readFloat();
            case INT64:
                return input.readInt64();
            case UINT64:
                return input.readUInt64();
            case INT32:
                return input.readInt32();
            case FIXED64:
                return input.readFixed64();
            case FIXED32:
                return input.readFixed32();
            case BOOL:
                return input.readBool();
            case STRING:
                if (checkUtf8) {
                    return input.readStringRequireUtf8();
                } else {
                    return input.readString();
                }
            case BYTES:
                return input.readByteArray();
            case UINT32:
                return input.readUInt32();
            case SFIXED32:
                return input.readSFixed32();
            case SFIXED64:
                return input.readSFixed64();
            case SINT32:
                return input.readSInt32();
            case SINT64:
                return input.readSInt64();

            case GROUP:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case MESSAGE:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case ENUM:
                // We don't handle enums because we don't know what to do if the
                // value is not recognized.
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
        }

        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    }

    /**
     * Write a single tag-value pair to the stream.
     *
     * @param output The output stream.
     * @param type The field's type.
     * @param number The field's number.
     * @param value Object representing the field's value. Must be of the exact type which would be returned by
     *            {@link Message#getField(Descriptors.FieldDescriptor)} for this field.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void writeElement(final CodedOutputStream output, final WireFormat.FieldType type, final int number,
            final Object value) throws IOException {
        // Special case for groups, which need a start and end tag; other fields
        // can just use writeTag() and writeFieldNoTag().
        if (type == WireFormat.FieldType.GROUP) {
            output.writeGroup(number, (MessageLite) value);
        } else {
            output.writeTag(number, getWireFormatForFieldType(type, false));
            writeElementNoTag(output, type, value);
        }
    }

    /**
     * Given a field type, return the wire type.
     *
     * @param type the type
     * @param isPacked the is packed
     * @return the wire format for field type
     * @returns One of the {@code WIRETYPE_} constants defined in {@link WireFormat}.
     */
    static int getWireFormatForFieldType(final WireFormat.FieldType type, boolean isPacked) {
        if (isPacked) {
            return WireFormat.WIRETYPE_LENGTH_DELIMITED;
        } else {
            return type.getWireType();
        }
    }

    static byte[] toByteArray(Byte[] bb) {
        byte[] ret = new byte[bb.length];
        int i = 0;
        for (Byte b : bb) {
            ret[i++] = b.byteValue();
        }
        return ret;
    }

    /**
     * Write a field of arbitrary type, without its tag, to the stream.
     *
     * @param output The output stream.
     * @param type The field's type.
     * @param value Object representing the field's value. Must be of the exact type which would be returned by
     *            {@link Message#getField(Descriptors.FieldDescriptor)} for this field.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void writeElementNoTag(final CodedOutputStream output, final WireFormat.FieldType type,
            final Object value) throws IOException {
        switch (type) {
            case DOUBLE:
                output.writeDoubleNoTag((Double) value);
                break;
            case FLOAT:
                output.writeFloatNoTag((Float) value);
                break;
            case INT64:
                output.writeInt64NoTag((Long) value);
                break;
            case UINT64:
                output.writeUInt64NoTag((Long) value);
                break;
            case INT32:
                output.writeInt32NoTag((Integer) value);
                break;
            case FIXED64:
                output.writeFixed64NoTag((Long) value);
                break;
            case FIXED32:
                output.writeFixed32NoTag((Integer) value);
                break;
            case BOOL:
                output.writeBoolNoTag((Boolean) value);
                break;
            case STRING:
                output.writeStringNoTag((String) value);
                break;
            // group not support yet
            // case GROUP : output.writeGroupNoTag ((MessageLite) value); break;
            case MESSAGE:
                writeObject(output, 0, FieldType.OBJECT, value, false, false);
                break;
            case BYTES:
                if (value instanceof ByteString) {
                    output.writeBytesNoTag((ByteString) value);
                } else {
                    byte[] v;
                    if (value instanceof Byte[]) {
                        v = toByteArray((Byte[]) value);
                    } else {
                        v = (byte[]) value;
                    }
                    output.writeByteArrayNoTag(v);
                }
                break;
            case UINT32:
                output.writeUInt32NoTag((Integer) value);
                break;
            case SFIXED32:
                output.writeSFixed32NoTag((Integer) value);
                break;
            case SFIXED64:
                output.writeSFixed64NoTag((Long) value);
                break;
            case SINT32:
                output.writeSInt32NoTag((Integer) value);
                break;
            case SINT64:
                output.writeSInt64NoTag((Long) value);
                break;

            case ENUM:
                if (value instanceof Internal.EnumLite) {
                    output.writeEnumNoTag(((Internal.EnumLite) value).getNumber());
                } else {

                    if (value instanceof EnumReadable) {
                        output.writeEnumNoTag(((EnumReadable) value).value());
                    } else if (value instanceof Enum) {
                        output.writeEnumNoTag(((Enum) value).ordinal());
                    } else {
                        output.writeEnumNoTag(((Integer) value).intValue());
                    }

                }
                break;
        }
    }

    /**
     * Compute length delimited field size.
     *
     * @param fieldLength the field length
     * @return the int
     */
    public static int computeLengthDelimitedFieldSize(int fieldLength) {
        return CodedOutputStream.computeUInt32SizeNoTag(fieldLength) + fieldLength;
    }

    /**
     * Compute the number of bytes that would be needed to encode a particular value of arbitrary type, excluding tag.
     *
     * @param type The field's type.
     * @param value Object representing the field's value. Must be of the exact type which would be returned by
     *            {@link Message#getField(Descriptors.FieldDescriptor)} for this field.
     * @return the int
     */
    public static int computeElementSizeNoTag(final WireFormat.FieldType type, final Object value) {
        switch (type) {
            // Note: Minor violation of 80-char limit rule here because this would
            // actually be harder to read if we wrapped the lines.
            case DOUBLE:
                return CodedOutputStream.computeDoubleSizeNoTag((Double) value);
            case FLOAT:
                return CodedOutputStream.computeFloatSizeNoTag((Float) value);
            case INT64:
                return CodedOutputStream.computeInt64SizeNoTag((Long) value);
            case UINT64:
                return CodedOutputStream.computeUInt64SizeNoTag((Long) value);
            case INT32:
                return CodedOutputStream.computeInt32SizeNoTag((Integer) value);
            case FIXED64:
                return CodedOutputStream.computeFixed64SizeNoTag((Long) value);
            case FIXED32:
                return CodedOutputStream.computeFixed32SizeNoTag((Integer) value);
            case BOOL:
                return CodedOutputStream.computeBoolSizeNoTag((Boolean) value);
            case STRING:
                return CodedOutputStream.computeStringSizeNoTag((String) value);
            case GROUP:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
            case BYTES:
                if (value instanceof ByteString) {
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
                } else {
                    if (value instanceof Byte[]) {
                        return computeLengthDelimitedFieldSize(((Byte[]) value).length);
                    }
                    return CodedOutputStream.computeByteArraySizeNoTag((byte[]) value);
                }
            case UINT32:
                return CodedOutputStream.computeUInt32SizeNoTag((Integer) value);
            case SFIXED32:
                return CodedOutputStream.computeSFixed32SizeNoTag((Integer) value);
            case SFIXED64:
                return CodedOutputStream.computeSFixed64SizeNoTag((Long) value);
            case SINT32:
                return CodedOutputStream.computeSInt32SizeNoTag((Integer) value);
            case SINT64:
                return CodedOutputStream.computeSInt64SizeNoTag((Long) value);

            case MESSAGE:
                if (value instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) value);
                } else {
                    return computeObjectSizeNoTag(value);
                }

            case ENUM:
                if (value instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) value).getNumber());
                } else {
                    if (value instanceof EnumReadable) {
                        return CodedOutputStream.computeEnumSizeNoTag(((EnumReadable) value).value());
                    } else if (value instanceof Enum) {
                        return CodedOutputStream.computeEnumSizeNoTag(((Enum) value).ordinal());
                    }

                    return CodedOutputStream.computeEnumSizeNoTag((Integer) value);
                }
        }

        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    }

    /**
     * Gets the descriptor.
     *
     * @param cls the cls
     * @return the descriptor
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Descriptor getDescriptor(Class<?> cls) throws IOException {
        String idl = ProtobufIDLGenerator.getIDL(cls);
        ProtoFile file = ProtoParser.parse(ProtobufIDLProxy.DEFAULT_FILE_NAME, idl);

        FileDescriptorProtoPOJO fileDescriptorProto = new FileDescriptorProtoPOJO();

        fileDescriptorProto.name = ProtobufIDLProxy.DEFAULT_FILE_NAME;
        fileDescriptorProto.pkg = file.packageName();
        fileDescriptorProto.dependencies = file.dependencies();
        fileDescriptorProto.publicDependency = convertList(file.publicDependencies());
        fileDescriptorProto.weakDependency = null; // XXX

        fileDescriptorProto.messageTypes = new ArrayList<DescriptorProtoPOJO>();
        fileDescriptorProto.enumTypes = new ArrayList<EnumDescriptorProtoPOJO>();
        fileDescriptorProto.services = new ArrayList<ServiceDescriptorProtoPOJO>();

        Set<String> messageSet = new HashSet<String>();
        Set<String> enumSet = new HashSet<String>();

        List<TypeElement> typeElements = file.typeElements();
        if (typeElements != null) {

            for (TypeElement typeElement : typeElements) {
                if (typeElement instanceof MessageElement) {
                    messageSet.add(typeElement.name());
                } else if (typeElement instanceof EnumElement) {
                    enumSet.add(typeElement.name());
                }
            }

            for (TypeElement typeElement : typeElements) {
                if (typeElement instanceof MessageElement) {
                    fileDescriptorProto.messageTypes.add(getDescritorProtoPOJO(fileDescriptorProto,
                            (MessageElement) typeElement, messageSet, enumSet));
                } else if (typeElement instanceof EnumElement) {
                    fileDescriptorProto.enumTypes.add(
                            getDescritorProtoPOJO(fileDescriptorProto, (EnumElement) typeElement, messageSet, enumSet));
                }

            }
        }

        FileDescriptorProto fileproto;
        try {
            Codec<FileDescriptorProtoPOJO> descriptorCodec = ProtobufProxy.create(FileDescriptorProtoPOJO.class,
                    ProtobufProxy.isCacheEnabled(), ProtobufProxy.OUTPUT_PATH.get());
            byte[] bs = descriptorCodec.encode(fileDescriptorProto);
            fileproto = FileDescriptorProto.parseFrom(bs);
        } catch (InvalidProtocolBufferException e) {
            throw new IOException("Failed to parse protocol buffer descriptor for generated code.", e);
        }

        FileDescriptor fileDescriptor;
        try {
            fileDescriptor =
                    FileDescriptor.buildFrom(fileproto, new com.google.protobuf.Descriptors.FileDescriptor[] {});
        } catch (DescriptorValidationException e) {
            throw new IOException(e.getMessage(), e);
        }

        return fileDescriptor.getMessageTypes().get(0);
    }

    /**
     * Gets the descritor proto pojo.
     *
     * @param fileDescriptorProto the file descriptor proto
     * @param typeElement the type element
     * @param messageSet the message set
     * @param enumSet the enum set
     * @return the descritor proto pojo
     */
    private static EnumDescriptorProtoPOJO getDescritorProtoPOJO(FileDescriptorProtoPOJO fileDescriptorProto,
            EnumElement typeElement, Set<String> messageSet, Set<String> enumSet) {

        EnumDescriptorProtoPOJO ret = new EnumDescriptorProtoPOJO();
        ret.name = typeElement.name();
        ret.values = new ArrayList<EnumValueDescriptorProtoPOJO>();
        ret.options = new ArrayList<EnumOptionsPOJO>();

        List<EnumConstantElement> values = typeElement.constants();
        if (values != null) {
            EnumValueDescriptorProtoPOJO fieldDescriptorProto;
            for (EnumConstantElement fieldElement : values) {
                fieldDescriptorProto = new EnumValueDescriptorProtoPOJO();
                fieldDescriptorProto.name = fieldElement.name();
                fieldDescriptorProto.number = fieldElement.tag();

                ret.values.add(fieldDescriptorProto);
            }
        }

        List<OptionElement> options = typeElement.options();
        if (options != null) {
            EnumOptionsPOJO fieldDescriptorProto;
            for (OptionElement option : options) {
                fieldDescriptorProto = new EnumOptionsPOJO();
                ret.options.add(fieldDescriptorProto);
            }
        }

        return ret;
    }

    /**
     * Gets the descritor proto pojo.
     *
     * @param fileDescriptorProto the file descriptor proto
     * @param typeElement the type element
     * @param messageSet the message set
     * @param enumSet the enum set
     * @return the descritor proto pojo
     */
    private static DescriptorProtoPOJO getDescritorProtoPOJO(FileDescriptorProtoPOJO fileDescriptorProto,
            MessageElement typeElement, Set<String> messageSet, Set<String> enumSet) {

        DescriptorProtoPOJO ret = new DescriptorProtoPOJO();
        ret.name = typeElement.name();
        ret.fields = new ArrayList<FieldDescriptorProtoPOJO>();
        ret.nestedTypes = new ArrayList<DescriptorProtoPOJO>();
        ret.enumTypes = new ArrayList<EnumDescriptorProtoPOJO>();
        ret.extensionRanges = new ArrayList<ExtensionRangePOJO>();
        ret.extensions = new ArrayList<FieldDescriptorProtoPOJO>();
        ret.options = new ArrayList<MessageOptionsPOJO>();
        ret.oneofDecls = new ArrayList<OneofDescriptorProtoPOJO>();

        List<FieldElement> fields = typeElement.fields();
        if (fields != null) {
            FieldDescriptorProtoPOJO fieldDescriptorProto;
            for (FieldElement fieldElement : fields) {
                fieldDescriptorProto = new FieldDescriptorProtoPOJO();
                fieldDescriptorProto.name = fieldElement.name();
                fieldDescriptorProto.extendee = null; // XXX
                fieldDescriptorProto.number = fieldElement.tag();

                FieldElement.Label label = fieldElement.label();
                if (label == FieldElement.Label.OPTIONAL) {
                    fieldDescriptorProto.label = Label.LABEL_OPTIONAL;
                } else if (label == FieldElement.Label.REQUIRED) {
                    fieldDescriptorProto.label = Label.LABEL_REQUIRED;
                } else if (label == FieldElement.Label.REPEATED) {
                    fieldDescriptorProto.label = Label.LABEL_REPEATED;
                }

                DataType type = fieldElement.type();
                if (type.kind() == Kind.MAP) {
                    String messageName = StringUtils.capitalize(fieldDescriptorProto.name) + MAP_ENTRY_SUFFIX;
                    fieldDescriptorProto.type = Type.TYPE_MESSAGE;
                    fieldDescriptorProto.typeName = ICodeGenerator.PACKAGE_SPLIT + fileDescriptorProto.pkg
                            + ICodeGenerator.PACKAGE_SPLIT + ret.name + ICodeGenerator.PACKAGE_SPLIT + messageName;
                    // refix label type
                    fieldDescriptorProto.label = Label.LABEL_REPEATED;

                    // here should add key and value type message type
                    DataType.MapType mapType = (DataType.MapType) type;

                    MessageElement messageElement = getMapKVMessageElements(messageName, mapType);

                    ret.nestedTypes
                            .add(getDescritorProtoPOJO(fileDescriptorProto, messageElement, messageSet, enumSet));

                } else if (type.kind() == Kind.MAP || type.kind() == Kind.NAMED) {
                    fieldDescriptorProto.typeName = ((DataType.NamedType) type).name();
                    if (messageSet.contains(fieldDescriptorProto.typeName)) {
                        fieldDescriptorProto.type = Type.TYPE_MESSAGE;
                    } else {
                        fieldDescriptorProto.type = Type.TYPE_ENUM;
                    }
                } else {
                    fieldDescriptorProto.type = Type.valueOf("TYPE_" + ((DataType.ScalarType) type).name());
                }

                ret.fields.add(fieldDescriptorProto);
            }
        }

        List<TypeElement> nestedElements = typeElement.nestedElements();
        if (nestedElements != null) {

            for (TypeElement nestedTypeElement : nestedElements) {
                if (nestedTypeElement instanceof MessageElement) {
                    ret.nestedTypes.add(getDescritorProtoPOJO(fileDescriptorProto, (MessageElement) nestedTypeElement,
                            messageSet, enumSet));
                } else if (nestedTypeElement instanceof EnumElement) {
                    ret.enumTypes.add(getDescritorProtoPOJO(fileDescriptorProto, (EnumElement) nestedTypeElement,
                            messageSet, enumSet));
                }
            }
        }

        return ret;
    }

    /**
     * Gets the map kv message elements.
     *
     * @param name the name
     * @param mapType the map type
     * @return the map kv message elements
     */
    private static MessageElement getMapKVMessageElements(String name, MapType mapType) {
        MessageElement.Builder ret = MessageElement.builder();
        ret.name(name);

        DataType keyType = mapType.keyType();
        Builder fieldBuilder = FieldElement.builder().name("key").tag(1);
        fieldBuilder.type(keyType).label(FieldElement.Label.OPTIONAL);
        ret.addField(fieldBuilder.build());

        DataType valueType = mapType.valueType();
        fieldBuilder = FieldElement.builder().name("value").tag(2);
        fieldBuilder.type(valueType).label(FieldElement.Label.OPTIONAL);
        ret.addField(fieldBuilder.build());

        return ret.build();
    }

    /**
     * Convert list.
     *
     * @param list the list
     * @return the list
     */
    private static List<Integer> convertList(List<String> list) {
        if (list == null) {
            return null;
        }
        List<Integer> ret = new ArrayList<Integer>(list.size());
        for (String v : list) {
            ret.add(StringUtils.toInt(v));
        }

        return ret;
    }

}
