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

import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.WireFormat;

/**
 * Utility class for codec.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public class CodedConstant {

    /**
     * get field name
     * 
     * @param order
     *            field order
     * @return field name
     */
    private static String getFieldName(int order) {
        String fieldName = "f_" + order;
        return fieldName;
    }

    /**
     * get mapped type defined java expression.
     * 
     * @param order
     *            field order
     * @param type
     *            field type
     * @param express
     *            java expression
     * @param isList
     *            is field type is a {@link List}
     * @return full java expression
     */
    public static String getMappedTypeDefined(int order, FieldType type, String express, boolean isList) {

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
        }

        String code = defineType + " " + fieldName + "=null;\n";
        code += "if (!CodedConstant.isNull(" + express + ")) {\n";

        code += fieldName + "=" + express + ";\n";
        code += "}";
        return code;
    }

    /**
     * get mapped type size compute java expression
     * 
     * @param order
     *            field order
     * @param type
     *            field type
     * @param isList
     *            is field type is a {@link List}
     * @return full java expression
     */
    public static String getMappedTypeSize(FieldInfo field, int order, FieldType type, boolean isList, 
            boolean debug, File path) {
        String fieldName = getFieldName(order);
        
        String spath = "null";
        if (path != null) {
            spath = "new java.io.File(\"" + path.getAbsolutePath().replace('\\', '/') + "\")";
        }
        
        if (isList) {
            String typeString = type.getType().toUpperCase();
            return "CodedConstant.computeListSize(" + order + "," + fieldName + ", FieldType." 
                    + typeString + "," + Boolean.valueOf(debug) + "," + spath + ");\n";
        }

        if (type == FieldType.OBJECT) {
            String typeString = type.getType().toUpperCase();
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
                String clsName = field.getField().getType().getName().replaceAll("\\$", ".");
                fieldName = "((" + clsName  + ") " + fieldName + ").value()";
                enumSpecial = true;
            }
        }
        if (!enumSpecial) {
            fieldName = fieldName + type.getToPrimitiveType();
        }
        
        return "com.google.protobuf.CodedOutputStream.compute" + t + "Size(" + order + "," + fieldName + ");\n";
    }

    /**
     * get list type field serialized size java expression
     * 
     * @param order
     *            field order
     * @param list
     *            field value
     * @param type
     *            field type of list object
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
     * @param order
     *            field order
     * @param type
     *            field type
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
                    String clsName = field.getField().getType().getName().replaceAll("\\$", ".");
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
     * @param out
     *            target output stream to write
     * @param order
     *            field order
     * @param type
     *            field type
     * @param list
     *            target list object to be serialized
     */
    public static void writeToList(CodedOutputStream out, int order, FieldType type, List list) throws IOException {
        if (list == null) {
            return;
        }
        for (Object object : list) {
            writeObject(out, order, type, object, true);
        }

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
    public static void writeObject(CodedOutputStream out, int order, FieldType type, 
            Object o, boolean list) throws IOException {
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
     * get required field check java expression
     * 
     * @param order
     *            field order
     * @param field
     *            java field
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
     * @param express
     *            java expression
     * @param field
     *            java field
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
     * @param o
     *            to check
     * @return true if is null
     */
    public static boolean isNull(Object o) {
        return o == null;
    }

    /**
     * check double is null
     * 
     * @param o
     *            to check
     * @return true if is null
     */
    public static boolean isNull(double o) {
        return false;
    }

    /**
     * check int is null
     * 
     * @param o
     *            to check
     * @return true if is null
     */
    public static boolean isNull(int o) {
        return false;
    }

    /**
     * check byte is null
     * 
     * @param o
     *            to check
     * @return true if is null
     */
    public static boolean isNull(byte o) {
        return false;
    }

    /**
     * check short is null
     * 
     * @param o
     *            to check
     * @return true if is null
     */
    public static boolean isNull(short o) {
        return false;
    }

    /**
     * check long is null
     * 
     * @param o
     *            to check
     * @return true if is null
     */
    public static boolean isNull(long o) {
        return false;
    }

    /**
     * check float is null
     * 
     * @param o
     *            to check
     * @return true if is null
     */
    public static boolean isNull(float o) {
        return false;
    }

    /**
     * check char is null
     * 
     * @param o
     *            to check
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
     * Capitalizes a String changing the first letter to title case as per
     * {@link Character#toTitleCase(char)}. No other letters are changed.
     * </p>
     * 
     * @param str
     *            the String to capitalize, may be null
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
     * @param fieldNumber
     *            field number order
     * @param wireType
     *            wireformat type
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

}
