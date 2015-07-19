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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.ProtobufProxyUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
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

    private static final String WIREFORMAT_CLSNAME = ClassHelper
            .getInternalName(com.google.protobuf.WireFormat.FieldType.class.getName());

    /**
     * get field name
     * 
     * @param order field order
     * @return field name
     */
    private static String getFieldName(int order) {
        String fieldName = "f_" + order;
        return fieldName;
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
    public static String getMappedTypeDefined(int order, FieldType type, String express, boolean isList, boolean isMap) {

        String fieldName = getFieldName(order);
        if ((type == FieldType.STRING || type == FieldType.BYTES) && !isList) {
            // add null check
            String code = "com.google.protobuf.ByteString " + fieldName + "=null;\n";
            code += "if (!CodedConstant.isNull(" + express + ")) {\n";

            String method = "copyFromUtf8";
            if (type == FieldType.BYTES) {
                method = "copyFrom";
            }

            code += fieldName + " = com.google.protobuf.ByteString." + method + "(" + express + ");\n";
            code += "}";
            return code;
        }
        // add null check
        String defineType = type.getJavaType();
        if (isList) {
            defineType = "List";
        } else if (isMap) {
            defineType = "Map";
        }

        String code = defineType + " " + fieldName + "=null;\n";
        code += "if (!CodedConstant.isNull(" + express + ")) {\n";

        code += fieldName + "=" + express + ";\n";
        code += "}";
        return code;
    }

    /**
     * @param field field
     * @param order field order
     * @param type field type
     * @param isList is field type is a {@link List}
     * @param debug debug mode if true enable debug.
     * @param path
     * @return full java expression
     */
    public static String getMappedTypeSize(FieldInfo field, int order, FieldType type, boolean isList, boolean isMap,
            boolean debug, File path) {
        String fieldName = getFieldName(order);

        String spath = "null";
        if (path != null) {
            spath = "new java.io.File(\"" + path.getAbsolutePath().replace('\\', '/') + "\")";
        }

        String typeString = type.getType().toUpperCase();
        if (isList) {
            return "CodedConstant.computeListSize(" + order + "," + fieldName + ", FieldType." + typeString + ","
                    + Boolean.valueOf(debug) + "," + spath + ");\n";
        } else if (isMap) {

            String joinedSentence = getMapFieldGenericParameterString(field);
            return "CodedConstant.computeMapSize(" + order + "," + fieldName + "," + joinedSentence + ");\n";
        }

        if (type == FieldType.OBJECT) {
            return "CodedConstant.computeSize(" + order + "," + fieldName + ", FieldType." + typeString + ","
                    + Boolean.valueOf(debug) + "," + spath + ");\n";
        }

        String t = type.getType();
        if (type == FieldType.STRING || type == FieldType.BYTES) {
            t = "bytes";
        }
        t = capitalize(t);

        boolean enumSpecial = false;
        if (type == FieldType.ENUM) {
            if (EnumReadable.class.isAssignableFrom(field.getField().getType())) {
                String clsName = ClassHelper.getInternalName(field.getField().getType().getName());
                fieldName = "((" + clsName + ") " + fieldName + ").value()";
                enumSpecial = true;
            }
        }
        if (!enumSpecial) {
            fieldName = fieldName + type.getToPrimitiveType();
        }

        return "com.google.protobuf.CodedOutputStream.compute" + t + "Size(" + order + "," + fieldName + ");\n";
    }

    /**
     * @param field
     * @return
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
                    defaultKeyValue =
                            ClassHelper.getInternalName(field.getGenericKeyType().getName()) + "."
                                    + fields[0].getName();
                } else {
                    defaultKeyValue = "0";
                }

            } else {
                keyClass = WIREFORMAT_CLSNAME + ".MESSAGE";
                defaultKeyValue = "new " + ClassHelper.getInternalName(field.getGenericKeyType().getName()) + "()";
            }
        } else {
            keyClass = WIREFORMAT_CLSNAME + "." + fieldType.toString();
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
                    defaultValueValue =
                            ClassHelper.getInternalName(field.getGenericeValueType().getName()) + "."
                                    + fields[0].getName();
                } else {
                    defaultValueValue = "0";
                }

            } else {
                valueClass = WIREFORMAT_CLSNAME + ".MESSAGE";
                defaultValueValue = "new " + ClassHelper.getInternalName(field.getGenericeValueType().getName()) + "()";
            }
        } else {
            valueClass = WIREFORMAT_CLSNAME + "." + fieldType.toString();
            defaultValueValue = fieldType.getDefaultValue();
        }
        String joinedSentence = keyClass + "," + defaultKeyValue + "," + valueClass + "," + defaultValueValue;
        return joinedSentence;
    }

    /**
     * @param order field order
     * @param list field value
     * @param type field type of list obj
     * @param debug
     * @param path
     * @return full java expression
     */
    public static int computeListSize(int order, List list, FieldType type, boolean debug, File path) {
        int size = 0;
        if (list == null) {
            return size;
        }

        for (Object object : list) {
            size += computeSize(order, object, type, debug, path);
        }
        if (type != FieldType.OBJECT) {
            size += list.size() * CodedOutputStream.computeTagSize(order);
        }
        return size;
    }

    public static <K, V> int computeMapSize(int order, Map<K, V> map, com.google.protobuf.WireFormat.FieldType keyType,
            K defaultKey, com.google.protobuf.WireFormat.FieldType valueType, V defalutValue) {
        int size = 0;
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            com.baidu.bjf.remoting.protobuf.MapEntry<K, V> valuesDefaultEntry =
                    com.baidu.bjf.remoting.protobuf.MapEntry.<K, V> newDefaultInstance(null, keyType, defaultKey,
                            valueType, defalutValue);

            com.baidu.bjf.remoting.protobuf.MapEntry<K, V> values =
                    valuesDefaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build();

            size += com.google.protobuf.CodedOutputStream.computeMessageSize(order, values);
        }
        return size;
    }

    /**
     * @throws IOException
     * 
     */
    public static <K, V> void putMapValue(CodedInputStream input, Map<K, V> map,
            com.google.protobuf.WireFormat.FieldType keyType, K defaultKey,
            com.google.protobuf.WireFormat.FieldType valueType, V defalutValue) throws IOException {
        com.baidu.bjf.remoting.protobuf.MapEntry<K, V> valuesDefaultEntry =
                com.baidu.bjf.remoting.protobuf.MapEntry.<K, V> newDefaultInstance(null, keyType, defaultKey,
                        valueType, defalutValue);

        com.baidu.bjf.remoting.protobuf.MapEntry<K, V> values =
                input.readMessage(valuesDefaultEntry.getParserForType(), null);
        map.put(values.getKey(), values.getValue());

    }

    public static <K, V> void writeToMap(CodedOutputStream output, int order, Map<K, V> map,
            com.google.protobuf.WireFormat.FieldType keyType, K defaultKey,
            com.google.protobuf.WireFormat.FieldType valueType, V defalutValue) throws IOException {
        com.baidu.bjf.remoting.protobuf.MapEntry<K, V> valuesDefaultEntry =
                com.baidu.bjf.remoting.protobuf.MapEntry.<K, V> newDefaultInstance(null, keyType, defaultKey,
                        valueType, defalutValue);
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            com.baidu.bjf.remoting.protobuf.MapEntry<K, V> values =
                    valuesDefaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build();
            output.writeMessage(order, values);
        }
    }

    /**
     * get object size by {@link FieldType}
     * 
     * @param order
     * @param o
     * @param type
     * @return
     */
    public static int computeSize(int order, Object o, FieldType type, boolean debug, File path) {
        return computeSize(order, o, type, false, debug, path);
    }

    public static int computeObjectSizeNoTag(Object o) {
        int size = 0;
        if (o == null) {
            return size;
        }

        Class cls = o.getClass();
        Codec target = ProtobufProxy.create(cls, false, null);
        try {
            size = target.size(o);
            size = size + CodedOutputStream.computeRawVarint32Size(size);
            return size;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * get object size by {@link FieldType}
     * 
     * @param o
     * @param type
     * @return
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
        } else if (type == FieldType.FIXED32 || type == FieldType.INT32 || type == FieldType.SFIXED32
                || type == FieldType.SINT32 || type == FieldType.UINT32) {
            size = CodedOutputStream.computeInt32SizeNoTag(Integer.valueOf(o.toString()));
        } else if (type == FieldType.FIXED64 || type == FieldType.INT64 || type == FieldType.SFIXED64
                || type == FieldType.SINT64 || type == FieldType.UINT64) {
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
     * get mapped object byte write java expression
     * 
     * @param order field order
     * @param type field type
     * @return full java expression
     */
    public static String getMappedWriteCode(FieldInfo field, String prefix, int order, FieldType type, boolean isList,
            boolean isMap) {
        String fieldName = getFieldName(order);
        StringBuilder ret = new StringBuilder();
        ret.append("if (").append(fieldName).append("!=null){");

        if (isList) {
            String typeString = type.getType().toUpperCase();
            ret.append("CodedConstant.writeToList(").append(prefix).append(",");
            ret.append(order).append(",").append("FieldType.").append(typeString);
            ret.append(",").append(fieldName).append(");\n}");
            return ret.toString();
        } else if (isMap) {
            ret.append("CodedConstant.writeToMap(").append(prefix).append(",");
            ret.append(order).append(",").append(fieldName);

            String joinedSentence = getMapFieldGenericParameterString(field);
            ret.append(",").append(joinedSentence);

            ret.append(");\n}");
            return ret.toString();

        } else {
            // not list so should add convert to primitive type
            boolean enumSpecial = false;
            if (type == FieldType.ENUM) {
                if (EnumReadable.class.isAssignableFrom(field.getField().getType())) {
                    String clsName = ClassHelper.getInternalName(field.getField().getType().getName());
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
            ret.append(order).append(",").append("FieldType.").append(typeString);
            ret.append(",").append(fieldName).append(", false);\n}");
            return ret.toString();
        }

        if (type == FieldType.STRING || type == FieldType.BYTES) {
            ret.append(prefix).append(".writeBytes(").append(order);
            ret.append(", ").append(fieldName).append(");\n}");
            return ret.toString();
        }
        String t = type.getType();
        t = capitalize(t);

        ret.append(prefix).append(".write").append(t).append("(").append(order);
        ret.append(", ").append(fieldName).append(");\n}");
        return ret.toString();
    }

    /**
     * write list to {@link CodedOutputStream} object.
     * 
     * @param out target output stream to write
     * @param order field order
     * @param type field type
     * @param list target list object to be serialized
     */
    public static void writeToList(CodedOutputStream out, int order, FieldType type, List list) throws IOException {
        if (list == null) {
            return;
        }
        for (Object object : list) {
            writeObject(out, order, type, object, true, true);
        }

    }

    public static void writeObject(CodedOutputStream out, int order, FieldType type, Object o, boolean list)
            throws IOException {
        writeObject(out, order, type, o, list, true);
    }

    /**
     * Write object to byte array by {@link FieldType}
     * 
     * @param out
     * @param order
     * @param type
     * @param o
     * @throws IOException
     */
    public static void writeObject(CodedOutputStream out, int order, FieldType type, Object o, boolean list,
            boolean withTag) throws IOException {
        if (o == null) {
            return;
        }

        if (type == FieldType.OBJECT) {

            Class cls = o.getClass();
            Codec target = ProtobufProxy.create(cls);

            if (withTag) {
                out.writeRawVarint32(makeTag(order, WireFormat.WIRETYPE_LENGTH_DELIMITED));
            }
            out.writeRawVarint32(target.size(o));

            target.writeTo(o, out);
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
     * get required field check java expression
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
     * get return required field check java expression
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
     * check object is null
     * 
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(Object o) {
        return o == null;
    }

    /**
     * check double is null
     * 
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(double o) {
        return false;
    }

    /**
     * check int is null
     * 
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(int o) {
        return false;
    }

    /**
     * check byte is null
     * 
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(byte o) {
        return false;
    }

    /**
     * check short is null
     * 
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(short o) {
        return false;
    }

    /**
     * check long is null
     * 
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(long o) {
        return false;
    }

    /**
     * check float is null
     * 
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(float o) {
        return false;
    }

    /**
     * check char is null
     * 
     * @param o to check
     * @return true if is null
     */
    public static boolean isNull(char o) {
        return false;
    }

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

    /**
     * bit type tag value
     */
    static final int TAG_TYPE_BITS = 3;

    /**
     * make protobuf tag
     * 
     * @param fieldNumber field number order
     * @param wireType wireformat type
     * @return tag id
     */
    public static int makeTag(final int fieldNumber, final int wireType) {
        return (fieldNumber << TAG_TYPE_BITS) | wireType;
    }

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
     * Read a field of any primitive type for immutable messages from a CodedInputStream. Enums, groups, and embedded
     * messages are not handled by this method.
     * 
     * @param input The stream from which to read.
     * @param type Declared type of the field.
     * @param checkUtf8 When true, check that the input is valid utf8.
     * @return An object representing the field's value, of the exact type which would be returned by
     *         {@link Message#getField(Descriptors.FieldDescriptor)} for this field.
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
                return input.readBytes();
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
     * Write a field of arbitrary type, without its tag, to the stream.
     * 
     * @param output The output stream.
     * @param type The field's type.
     * @param value Object representing the field's value. Must be of the exact type which would be returned by
     *            {@link Message#getField(Descriptors.FieldDescriptor)} for this field.
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
                    output.writeByteArrayNoTag((byte[]) value);
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
     * Compute the number of bytes that would be needed to encode a particular value of arbitrary type, excluding tag.
     * 
     * @param type The field's type.
     * @param value Object representing the field's value. Must be of the exact type which would be returned by
     *            {@link Message#getField(Descriptors.FieldDescriptor)} for this field.
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

}
