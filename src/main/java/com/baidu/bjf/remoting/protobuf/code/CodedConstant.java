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
package com.baidu.bjf.remoting.protobuf.code;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.baidu.bjf.remoting.protobuf.Codec;
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
import com.baidu.bjf.remoting.protobuf.descriptor.ServiceDescriptorProtoPOJO;
import com.baidu.bjf.remoting.protobuf.descriptor.Type;
import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.WireFormat;
import com.squareup.protoparser.EnumType;
import com.squareup.protoparser.EnumType.Value;
import com.squareup.protoparser.MessageType;
import com.squareup.protoparser.Option;
import com.squareup.protoparser.ProtoFile;
import com.squareup.protoparser.ProtoSchemaParser;

/**
 * Utility class for codec.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public class CodedConstant {

    /** The Constant FIELD_PREFIX. */
    private static final String FIELD_PREFIX = "f_";

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
     * get mapped type defined java expression.
     * 
     * @param order field order
     * @param type field type
     * @param express java expression
     * @param isList is field type is a {@link List}
     * @return full java expression
     */
    public static String getMappedTypeDefined(int order, FieldType type, String express, boolean isList) {

        String fieldName = getFieldName(order);
        if ((type == FieldType.STRING || type == FieldType.BYTES) && !isList) {
            // add null check
            String code = "com.google.protobuf.ByteString " + fieldName + "=null" + ClassCode.JAVA_LINE_BREAK;
            code += "if (!CodedConstant.isNull(" + express + ")) {\n";

            String method = "copyFromUtf8";
            if (type == FieldType.BYTES) {
                method = "copyFrom";
            }

            code += fieldName + " = com.google.protobuf.ByteString." + method + "(" + express + ")"
                    + ClassCode.JAVA_LINE_BREAK;
            code += "}";
            return code;
        }
        // add null check
        String defineType = type.getJavaType();
        if (isList) {
            defineType = "List";
        }

        String code = defineType + " " + fieldName + "=null" + ClassCode.JAVA_LINE_BREAK;
        code += "if (!CodedConstant.isNull(" + express + ")) {\n";

        code += fieldName + "=" + express + ClassCode.JAVA_LINE_BREAK;
        code += "}";
        return code;
    }
    
    /**
     * Gets the filed type.
     *
     * @param type the type
     * @param isList the is list
     * @return the filed type
     */
    public static String getFiledType(FieldType type, boolean isList) {
        if ((type == FieldType.STRING || type == FieldType.BYTES) && !isList) {
            return "com.google.protobuf.ByteString";
        }
        
        // add null check
        String defineType = type.getJavaType();
        if (isList) {
            defineType = "List";
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
        if ((type == FieldType.STRING || type == FieldType.BYTES) && !isList) {
            String method = "copyFromUtf8";
            if (type == FieldType.BYTES) {
                method = "copyFrom";
            }

            return "com.google.protobuf.ByteString." + method + "(" + express + ")";
        }
        
        return express;
    }

    /**
     * Gets the mapped type size.
     *
     * @param field field
     * @param order field order
     * @param type field type
     * @param isList is field type is a {@link List}
     * @param debug debug mode if true enable debug.
     * @param path the path
     * @return full java expression
     */
    public static String getMappedTypeSize(FieldInfo field, int order, FieldType type, boolean isList, boolean debug,
            File path) {
        String fieldName = getFieldName(order);

        String spath = "ProtobufProxy.OUTPUT_PATH.get()";
        if (isList) {
            String typeString = type.getType().toUpperCase();
            return "CodedConstant.computeListSize(" + order + "," + fieldName + ", FieldType." + typeString + ","
                    + Boolean.valueOf(debug) + "," + spath + ");";
        }

        if (type == FieldType.OBJECT) {
            String typeString = type.getType().toUpperCase();
            return "CodedConstant.computeSize(" + order + "," + fieldName + ", FieldType." + typeString + ","
                    + Boolean.valueOf(debug) + "," + spath + ");";
        }

        String t = type.getType();
        if (type == FieldType.STRING || type == FieldType.BYTES) {
            t = "bytes";
        }
        t = capitalize(t);

        boolean enumSpecial = false;
        if (type == FieldType.ENUM) {
            if (EnumReadable.class.isAssignableFrom(field.getField().getType())) {
                String clsName = field.getField().getType().getCanonicalName();
                fieldName = "((" + clsName + ") " + fieldName + ").value()";
                enumSpecial = true;
            }
        }
        if (!enumSpecial) {
            fieldName = fieldName + type.getToPrimitiveType();
        }

        return "com.google.protobuf.CodedOutputStream.compute" + t + "Size(" + order + "," + fieldName + ")"
                + ClassCode.JAVA_END;
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
    public static int computeListSize(int order, List list, FieldType type, boolean debug, File path) {
        int size = 0;
        if (list == null || list.isEmpty()) {
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
     * get mapped object byte write java expression.
     *
     * @param field the field
     * @param prefix the prefix
     * @param order field order
     * @param type field type
     * @param isList the is list
     * @return full java expression
     */
    public static String getMappedWriteCode(FieldInfo field, String prefix, int order, FieldType type, boolean isList) {
        String fieldName = getFieldName(order);
        StringBuilder ret = new StringBuilder();
        ret.append("if (").append(fieldName).append("!=null){");

        if (isList) {
            String typeString = type.getType().toUpperCase();
            ret.append("CodedConstant.writeToList(").append(prefix).append(",");
            ret.append(order).append(",").append("FieldType.").append(typeString);
            ret.append(",").append(fieldName).append(");\n}");
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
            ret.append(order).append(",").append("FieldType.").append(typeString);
            ret.append(",").append(fieldName).append(", false)").append(ClassCode.JAVA_LINE_BREAK).append("}")
                    .append(ClassCode.LINE_BREAK);
            ;
            return ret.toString();
        }

        if (type == FieldType.STRING || type == FieldType.BYTES) {
            ret.append(prefix).append(".writeBytes(").append(order);
            ret.append(", ").append(fieldName).append(")").append(ClassCode.JAVA_LINE_BREAK).append("}")
                    .append(ClassCode.LINE_BREAK);
            ;
            return ret.toString();
        }
        String t = type.getType();
        t = capitalize(t);

        ret.append(prefix).append(".write").append(t).append("(").append(order);
        ret.append(", ").append(fieldName).append(")").append(ClassCode.JAVA_LINE_BREAK).append("}")
                .append(ClassCode.LINE_BREAK);
        ;
        return ret.toString();
    }

    /**
     * write list to {@link CodedOutputStream} object.
     *
     * @param out target output stream to write
     * @param order field order
     * @param type field type
     * @param list target list object to be serialized
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void writeToList(CodedOutputStream out, int order, FieldType type, List list) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Object object : list) {
            if (object == null) {
                throw new NullPointerException("List can not include Null value.");
            }

            writeObject(out, order, type, object, true);
        }

    }

    /**
     * Write object to byte array by {@link FieldType}.
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
        if (o == null) {
            return;
        }

        if (type == FieldType.OBJECT) {

            Class cls = o.getClass();
            Codec target = ProtobufProxy.create(cls);

            out.writeRawVarint32(makeTag(order, WireFormat.WIRETYPE_LENGTH_DELIMITED));
            out.writeRawVarint32(target.size(o));

            target.writeTo(o, out);
            return;
        }

        if (type == FieldType.BOOL) {
            out.writeBool(order, (Boolean) o);
        } else if (type == FieldType.BYTES) {
            byte[] bb = (byte[]) o;
            out.writeBytes(order, ByteString.copyFrom(bb));
        } else if (type == FieldType.DOUBLE) {
            out.writeDouble(order, (Double) o);
        } else if (type == FieldType.FIXED32) {
            out.writeFixed32(order, (Integer) o);
        } else if (type == FieldType.FIXED64) {
            out.writeFixed64(order, (Long) o);
        } else if (type == FieldType.FLOAT) {
            out.writeFloat(order, (Float) o);
        } else if (type == FieldType.INT32) {
            out.writeInt32(order, (Integer) o);
        } else if (type == FieldType.INT64) {
            out.writeInt64(order, (Long) o);
        } else if (type == FieldType.SFIXED32) {
            out.writeSFixed32(order, (Integer) o);
        } else if (type == FieldType.SFIXED64) {
            out.writeSFixed64(order, (Long) o);
        } else if (type == FieldType.SINT32) {
            out.writeSInt32(order, (Integer) o);
        } else if (type == FieldType.SINT64) {
            out.writeSInt64(order, (Long) o);
        } else if (type == FieldType.STRING) {
            out.writeBytes(order, ByteString.copyFromUtf8(String.valueOf(o)));
        } else if (type == FieldType.UINT32) {
            out.writeUInt32(order, (Integer) o);
        } else if (type == FieldType.UINT64) {
            out.writeUInt64(order, (Long) o);
        } else if (type == FieldType.ENUM) {
            int value = 0;
            if (o instanceof EnumReadable) {
                value = ((EnumReadable) o).value();
            } else if (o instanceof Enum) {
                value = ((Enum) o).ordinal();
            }
            out.writeEnum(order, value);
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
        code += "throw new UninitializedMessageException(CodedConstant.asList(\"" + field.getName() + "\"))"
                + ClassCode.JAVA_LINE_BREAK;
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
        code += "throw new UninitializedMessageException(CodedConstant.asList(\"" + field.getName() + "\"))"
                + ClassCode.JAVA_LINE_BREAK;
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
     * Gets the enumeration value.
     *
     * @param <T> the generic type
     * @param enumType the enum type
     * @param name the name
     * @return the enum value
     */
    public static <T extends Enum<T>> T getEnumValue(Class<T> enumType,
            String name) {
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
     * Gets the descriptor.
     *
     * @param cls the cls
     * @return the descriptor
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Descriptor getDescriptor(Class<?> cls) throws IOException {

        String idl = ProtobufIDLGenerator.getIDL(cls);
        ProtoFile file = ProtoSchemaParser.parse(ProtobufIDLProxy.DEFAULT_FILE_NAME, idl);

        FileDescriptorProtoPOJO fileDescriptorProto = new FileDescriptorProtoPOJO();

        fileDescriptorProto.name = ProtobufIDLProxy.DEFAULT_FILE_NAME;
        fileDescriptorProto.pkg = file.getPackageName();
        fileDescriptorProto.dependencies = file.getDependencies();
        fileDescriptorProto.publicDependency = convertList(file.getPublicDependencies());
        fileDescriptorProto.weakDependency = null; // XXX

        fileDescriptorProto.messageTypes = new ArrayList<DescriptorProtoPOJO>();
        fileDescriptorProto.enumTypes = new ArrayList<EnumDescriptorProtoPOJO>();
        fileDescriptorProto.services = new ArrayList<ServiceDescriptorProtoPOJO>();

        Set<String> messageSet = new HashSet<String>();
        Set<String> enumSet = new HashSet<String>();

        List<com.squareup.protoparser.Type> typeElements = file.getTypes();
        if (typeElements != null) {

            for (com.squareup.protoparser.Type typeElement : typeElements) {
                if (typeElement instanceof MessageType) {
                    messageSet.add(typeElement.getName());
                } else if (typeElement instanceof EnumType) {
                    enumSet.add(typeElement.getName());
                }

            }

            for (com.squareup.protoparser.Type typeElement : typeElements) {

                if (typeElement instanceof MessageType) {
                    fileDescriptorProto.messageTypes.add(
                            getDescritorProtoPOJO(fileDescriptorProto, (MessageType) typeElement, messageSet, enumSet));
                } else if (typeElement instanceof EnumType) {
                    fileDescriptorProto.enumTypes.add(
                            getDescritorProtoPOJO(fileDescriptorProto, (EnumType) typeElement, messageSet, enumSet));
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
    private static DescriptorProtoPOJO getDescritorProtoPOJO(FileDescriptorProtoPOJO fileDescriptorProto,
            MessageType typeElement, Set<String> messageSet, Set<String> enumSet) {

        DescriptorProtoPOJO ret = new DescriptorProtoPOJO();
        ret.name = typeElement.getName();
        ret.fields = new ArrayList<FieldDescriptorProtoPOJO>();
        ret.nestedTypes = new ArrayList<DescriptorProtoPOJO>();
        ret.enumTypes = new ArrayList<EnumDescriptorProtoPOJO>();
        ret.extensionRanges = new ArrayList<ExtensionRangePOJO>();
        ret.extensions = new ArrayList<FieldDescriptorProtoPOJO>();
        ret.options = new ArrayList<MessageOptionsPOJO>();

        List<com.squareup.protoparser.MessageType.Field> fields = typeElement.getFields();
        if (fields != null) {
            FieldDescriptorProtoPOJO fieldDescriptorProto;
            for (com.squareup.protoparser.MessageType.Field fieldElement : fields) {
                fieldDescriptorProto = new FieldDescriptorProtoPOJO();
                fieldDescriptorProto.name = fieldElement.getName();
                fieldDescriptorProto.extendee = null; // XXX
                fieldDescriptorProto.number = fieldElement.getTag();

                com.squareup.protoparser.MessageType.Label label = fieldElement.getLabel();
                if (label == com.squareup.protoparser.MessageType.Label.OPTIONAL) {
                    fieldDescriptorProto.label = Label.LABEL_OPTIONAL;
                } else if (label == com.squareup.protoparser.MessageType.Label.REQUIRED) {
                    fieldDescriptorProto.label = Label.LABEL_REQUIRED;
                } else if (label == com.squareup.protoparser.MessageType.Label.REPEATED) {
                    fieldDescriptorProto.label = Label.LABEL_REPEATED;
                }

                String type = fieldElement.getType();
                fieldDescriptorProto.defaultValue = fieldElement.getDefault();

                try {
                    fieldDescriptorProto.type = Type.valueOf("TYPE_" + type.toUpperCase());

                } catch (Exception e) {
                    if (messageSet.contains(type)) {
                        fieldDescriptorProto.type = Type.TYPE_MESSAGE;
                    } else {
                        fieldDescriptorProto.type = Type.TYPE_ENUM;
                    }

                    fieldDescriptorProto.typeName = "." + fileDescriptorProto.pkg + "." + type;
                }

                ret.fields.add(fieldDescriptorProto);
            }
        }

        List<com.squareup.protoparser.Type> nestedElements = typeElement.getNestedTypes();
        if (nestedElements != null) {
            for (com.squareup.protoparser.Type nestedTypeElement : nestedElements) {
                if (nestedTypeElement instanceof MessageType) {
                    ret.nestedTypes.add(getDescritorProtoPOJO(fileDescriptorProto, (MessageType) nestedTypeElement,
                            messageSet, enumSet));
                } else {
                    ret.enumTypes.add(getDescritorProtoPOJO(fileDescriptorProto, (EnumType) nestedTypeElement,
                            messageSet, enumSet));
                }
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
    private static EnumDescriptorProtoPOJO getDescritorProtoPOJO(FileDescriptorProtoPOJO fileDescriptorProto,
            EnumType typeElement, Set<String> messageSet, Set<String> enumSet) {

        EnumDescriptorProtoPOJO ret = new EnumDescriptorProtoPOJO();
        ret.name = typeElement.getName();
        ret.values = new ArrayList<EnumValueDescriptorProtoPOJO>();
        ret.options = new ArrayList<EnumOptionsPOJO>();

        List<Value> values = typeElement.getValues();
        if (values != null) {
            EnumValueDescriptorProtoPOJO fieldDescriptorProto;
            for (com.squareup.protoparser.EnumType.Value fieldElement : values) {
                fieldDescriptorProto = new EnumValueDescriptorProtoPOJO();
                fieldDescriptorProto.name = fieldElement.getName();
                fieldDescriptorProto.number = fieldElement.getTag();

                ret.values.add(fieldDescriptorProto);
            }
        }

        List<Option> options = typeElement.getOptions();
        if (options != null) {
            EnumOptionsPOJO fieldDescriptorProto;
            for (Option option : options) {
                fieldDescriptorProto = new EnumOptionsPOJO();
                ret.options.add(fieldDescriptorProto);
            }
        }

        return ret;
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
