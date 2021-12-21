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
package com.baidu.bjf.remoting.protobuf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.code.ClassCode;
import com.baidu.bjf.remoting.protobuf.utils.CodePrinter;
import com.baidu.bjf.remoting.protobuf.utils.JDKCompilerHelper;
import com.baidu.bjf.remoting.protobuf.utils.JavaStyleFormatter;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.baidu.jprotobuf.com.squareup.protoparser.DataType;
import com.baidu.jprotobuf.com.squareup.protoparser.DataType.ScalarType;
import com.baidu.jprotobuf.com.squareup.protoparser.EnumConstantElement;
import com.baidu.jprotobuf.com.squareup.protoparser.EnumElement;
import com.baidu.jprotobuf.com.squareup.protoparser.FieldElement;
import com.baidu.jprotobuf.com.squareup.protoparser.FieldElement.Label;
import com.baidu.jprotobuf.com.squareup.protoparser.MessageElement;
import com.baidu.jprotobuf.com.squareup.protoparser.OptionElement;
import com.baidu.jprotobuf.com.squareup.protoparser.OptionElement.Kind;
import com.baidu.jprotobuf.com.squareup.protoparser.ProtoFile;
import com.baidu.jprotobuf.com.squareup.protoparser.ProtoParser;
import com.baidu.jprotobuf.com.squareup.protoparser.TypeElement;

/**
 * This class is for dynamic create protobuf utility class directly from .proto file
 * 
 * @author xiemalin
 * @since 1.0.2
 */
public class ProtobufIDLProxy {

    /** The Constant JAVA_SUFFIX. */
    private static final String JAVA_SUFFIX = ".java";

    /** The Constant formatJavaField. */
    private static boolean formatJavaField = false;

    /**
     * Sets the Constant formatJavaField.
     *
     * @param needFormatJavaField the new Constant formatJavaField
     */
    public static void setFormatJavaField(boolean needFormatJavaField) {
        formatJavaField = needFormatJavaField;
    }

    /**
     * google Protobuf IDL message dependency result.
     *
     * @author xiemalin
     * @since 1.0
     */
    private static class CodeDependent {

        /** The name. */
        private String name;

        /** The pkg. */
        private String pkg;

        /** The dependencies. */
        private Set<String> dependencies = new HashSet<String>();

        /** The code. */
        private String code;

        /** The sub classes. */
        private Set<String> subClasses = new HashSet<String>();

        /**
         * Adds the dependency.
         *
         * @param name the name
         */
        private void addDependency(String name) {
            dependencies.add(name);
        }

        /**
         * Adds the sub class.
         *
         * @param name the name
         */
        private void addSubClass(String name) {
            subClasses.add(name);
        }

        /**
         * Gets the class name.
         *
         * @return the class name
         */
        public String getClassName() {
            if (StringUtils.isEmpty(pkg)) {
                return name;
            }
            return pkg + PACKAGE_SPLIT_CHAR + name;
        }

        /**
         * Checks if is depndency.
         *
         * @return true, if is depndency
         */
        private boolean isDepndency() {
            return !dependencies.isEmpty();
        }
    }

    /** The Constant PACKAGE_SPLIT_CHAR. */
    private static final char PACKAGE_SPLIT_CHAR = '.';

    /** The Constant PACKAGE_SPLIT. */
    private static final String PACKAGE_SPLIT = PACKAGE_SPLIT_CHAR + "";

    /** The Constant UTF_8. */
    private static final String UTF_8 = "utf-8";

    /** java outer class name. */
    private static final String JAVA_OUTER_CLASSNAME_OPTION = "java_outer_classname";

    /** java package. */
    private static final String JAVA_PACKAGE_OPTION = "java_package";

    /** code line end wrap. */
    private static final String CODE_END = ";\n";

    /** default proto file name. */
    public static final String DEFAULT_FILE_NAME = "jprotobuf_autogenerate";

    /** type mapping of field type. */
    private static final Map<String, FieldType> typeMapping;

    /** type mapping of field type in string. */
    private static final Map<String, String> fieldTypeMapping;

    static {

        typeMapping = new HashMap<String, FieldType>();

        typeMapping.put("double", FieldType.DOUBLE);
        typeMapping.put("float", FieldType.FLOAT);
        typeMapping.put("int64", FieldType.INT64);
        typeMapping.put("uint64", FieldType.UINT64);
        typeMapping.put("int32", FieldType.INT32);
        typeMapping.put("fixed64", FieldType.FIXED64);
        typeMapping.put("fixed32", FieldType.FIXED32);
        typeMapping.put("bool", FieldType.BOOL);
        typeMapping.put("string", FieldType.STRING);
        typeMapping.put("bytes", FieldType.BYTES);
        typeMapping.put("uint32", FieldType.UINT32);
        typeMapping.put("sfixed32", FieldType.SFIXED32);
        typeMapping.put("sfixed64", FieldType.SFIXED64);
        typeMapping.put("sint64", FieldType.SINT64);
        typeMapping.put("sint32", FieldType.SINT32);

        fieldTypeMapping = new HashMap<String, String>();

        fieldTypeMapping.put("double", "FieldType.DOUBLE");
        fieldTypeMapping.put("float", "FieldType.FLOAT");
        fieldTypeMapping.put("int64", "FieldType.INT64");
        fieldTypeMapping.put("uint64", "FieldType.UINT64");
        fieldTypeMapping.put("int32", "FieldType.INT32");
        fieldTypeMapping.put("fixed64", "FieldType.FIXED64");
        fieldTypeMapping.put("fixed32", "FieldType.FIXED32");
        fieldTypeMapping.put("bool", "FieldType.BOOL");
        fieldTypeMapping.put("string", "FieldType.STRING");
        fieldTypeMapping.put("bytes", "FieldType.BYTES");
        fieldTypeMapping.put("uint32", "FieldType.UINT32");
        fieldTypeMapping.put("sfixed32", "FieldType.SFIXED32");
        fieldTypeMapping.put("sfixed64", "FieldType.SFIXED64");
        fieldTypeMapping.put("sint64", "FieldType.SINT64");
        fieldTypeMapping.put("sint32", "FieldType.SINT32");
        fieldTypeMapping.put("enum", "FieldType.ENUM");
        fieldTypeMapping.put("map", "FieldType.MAP");
    }

    /** auto proxied suffix class name. */
    private static final String DEFAULT_SUFFIX_CLASSNAME = "JProtoBufProtoClass";

    /**
     * Check class.
     *
     * @param protoFile the proto file
     * @param type the type
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the class
     */
    private static Class checkClass(ProtoFile protoFile, TypeElement type, Map<String, String> mappedUniName,
            boolean isUniName) {
        String packageName = protoFile.packageName();
        String defaultClsName = type.name();
        // to check if has "java_package" option and "java_outer_classname"
        List<OptionElement> options = protoFile.options();
        if (options != null) {
            for (OptionElement option : options) {
                if (option.name().equals(JAVA_PACKAGE_OPTION)) {
                    packageName = option.value().toString();
                } else if (option.name().equals(JAVA_OUTER_CLASSNAME_OPTION)) {
                    defaultClsName = option.value().toString();
                }
            }
        }

        String simpleName = getProxyClassName(defaultClsName, mappedUniName, isUniName);
        String className = packageName + PACKAGE_SPLIT_CHAR + simpleName;

        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e1) {
            // if class not found so should generate a new java source class.
            c = null;
        }

        return c;
    }

    /**
     * Check class.
     *
     * @param packageName the package name
     * @param type the type
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the class
     */
    private static Class checkClass(String packageName, TypeElement type, Map<String, String> mappedUniName,
            boolean isUniName) {
        String simpleName = getProxyClassName(type.name(), mappedUniName, isUniName);
        String className = packageName + PACKAGE_SPLIT_CHAR + simpleName;

        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e1) {
            // if class not found so should generate a new java source class.
            c = null;
        }

        return c;
    }

    /**
     * Check directory.
     *
     * @param generateSouceOnly the generate souce only
     * @param sourceOutputDir the source output dir
     */
    protected static void checkDirectory(boolean generateSouceOnly, File sourceOutputDir) {
        if (generateSouceOnly) {
            if (sourceOutputDir == null) {
                throw new RuntimeException("param 'sourceOutputDir' is null.");
            }

            if (!sourceOutputDir.isDirectory()) {
                throw new RuntimeException("param 'sourceOutputDir' should be a exist file directory.");
            }
        }
    }

    /**
     * Creates the.
     *
     * @param file the file
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(File file) throws IOException {
        return create(file, false, null, true);
    }

    /**
     * Creates the.
     *
     * @param file the file
     * @param debug the debug
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(File file, boolean debug, boolean isUniName) throws IOException {
        return create(file, debug, isUniName);
    }

    /**
     * Creates the.
     *
     * @param file the file
     * @param debug the debug
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(File file, boolean debug) throws IOException {
        return create(file, debug, null);
    }

    /**
     * Creates the.
     *
     * @param file the file
     * @param debug the debug
     * @param path the path
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(File file, boolean debug, File path) throws IOException {
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        return create(file, debug, path, cds, new HashSet<String>());
    }

    /**
     * Creates the.
     *
     * @param file the file
     * @param debug the debug
     * @param path the path
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(File file, boolean debug, File path, boolean isUniName)
            throws IOException {
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        return create(file, debug, path, cds, new HashSet<String>(), isUniName);
    }

    /**
     * Creates the.
     *
     * @param file the file
     * @param debug the debug
     * @param path the path
     * @param cds the cds
     * @param compiledClass the compiled class
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(File file, boolean debug, File path, List<CodeDependent> cds,
            Set<String> compiledClass) throws IOException {

        return create(file, debug, path, cds, compiledClass, true);
    }

    /**
     * Creates the.
     *
     * @param file the file
     * @param debug the debug
     * @param path the path
     * @param cds the cds
     * @param compiledClass the compiled class
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(File file, boolean debug, File path, List<CodeDependent> cds,
            Set<String> compiledClass, boolean isUniName) throws IOException {

        return doCreatePro(file, true, debug, path, false, null, cds, compiledClass, new HashMap<String, String>(),
                isUniName);
    }

    /**
     * Creates the.
     *
     * @param is the is
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(InputStream is) throws IOException {
        return create(is, false);
    }

    /**
     * Creates the.
     *
     * @param is the is
     * @param debug the debug
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(InputStream is, boolean debug) throws IOException {
        return create(is, debug, null, true);
    }

    /**
     * Creates the.
     *
     * @param is the is
     * @param debug the debug
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(InputStream is, boolean debug, boolean isUniName)
            throws IOException {
        return create(is, debug, null, isUniName);
    }

    /**
     * Creates the.
     *
     * @param is the is
     * @param debug the debug
     * @param path the path
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(InputStream is, boolean debug, File path) throws IOException {
        return create(is, debug, path, true);
    }

    /**
     * Creates the.
     *
     * @param is the is
     * @param debug the debug
     * @param path the path
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(InputStream is, boolean debug, File path, boolean isUniName)
            throws IOException {
        ProtoFile protoFile = ProtoParser.parseUtf8(DEFAULT_FILE_NAME, is);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        return doCreate(protoFile, true, debug, path, false, null, cds, new HashMap<String, String>(), isUniName);
    }

    /**
     * Creates the.
     *
     * @param reader the reader
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(Reader reader) throws IOException {
        return create(reader, false);
    }

    /**
     * Creates the.
     *
     * @param reader the reader
     * @param debug the debug
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(Reader reader, boolean debug) throws IOException {
        return create(reader, debug, null, true);
    }

    /**
     * Creates the.
     *
     * @param reader the reader
     * @param debug the debug
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(Reader reader, boolean debug, boolean isUniName)
            throws IOException {
        return create(reader, debug, null, isUniName);
    }

    /**
     * Creates the.
     *
     * @param reader the reader
     * @param debug the debug
     * @param path the path
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(Reader reader, boolean debug, File path) throws IOException {
        return create(reader, debug, path, true);
    }

    /**
     * Creates the.
     *
     * @param reader the reader
     * @param debug the debug
     * @param path the path
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, IDLProxyObject> create(Reader reader, boolean debug, File path, boolean isUniName)
            throws IOException {
        ProtoFile protoFile = ProtoParser.parse(DEFAULT_FILE_NAME, reader);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        return doCreate(protoFile, true, debug, path, false, null, cds, new HashMap<String, String>(), isUniName);
    }

    /**
     * Creates the.
     *
     * @param data the data
     * @return the map
     */
    public static Map<String, IDLProxyObject> create(String data) {
        return create(data, false);
    }

    /**
     * Creates the.
     *
     * @param data the data
     * @param debug the debug
     * @return the map
     */
    public static Map<String, IDLProxyObject> create(String data, boolean debug) {
        return create(data, debug, null, true);
    }

    /**
     * Creates the.
     *
     * @param data the data
     * @param debug the debug
     * @param isUniName the is uni name
     * @return the map
     */
    public static Map<String, IDLProxyObject> create(String data, boolean debug, boolean isUniName) {
        return create(data, debug, null, isUniName);
    }

    /**
     * Creates the.
     *
     * @param data the data
     * @param debug the debug
     * @param path the path
     * @return the map
     */
    public static Map<String, IDLProxyObject> create(String data, boolean debug, File path) {
        return create(data, debug, path, true);
    }

    /**
     * Creates the.
     *
     * @param data the data
     * @param debug the debug
     * @param path the path
     * @param isUniName the is uni name
     * @return the map
     */
    public static Map<String, IDLProxyObject> create(String data, boolean debug, File path, boolean isUniName) {
        ProtoFile protoFile = ProtoParser.parse(DEFAULT_FILE_NAME, data);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        try {
            return doCreate(protoFile, true, debug, path, false, null, cds, new HashMap<String, String>(), isUniName);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Creates the code by type.
     *
     * @param type the type
     * @param topLevelClass the top level class
     * @param packageName the package name
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the code dependent
     */
    private static CodeDependent createCodeByType(EnumElement type, boolean topLevelClass, String packageName,
            Map<String, String> mappedUniName, boolean isUniName) {

        CodeDependent cd = new CodeDependent();

        String defaultClsName = type.name();
        String simpleName = getProxyClassName(defaultClsName, mappedUniName, isUniName);

        // To generate class
        StringBuilder code = new StringBuilder();
        if (topLevelClass) {
            // define package
            code.append("package ").append(packageName).append(CODE_END);
            code.append("\n");
            // add import;
            code.append("import com.baidu.bjf.remoting.protobuf.EnumReadable;\n");
        }

        // define class
        // define class
        if (topLevelClass) {
            code.append("public enum ");
        } else {
            code.append("public static enum ");
        }
        code.append(simpleName).append(" implements EnumReadable {\n");

        Iterator<EnumConstantElement> iter = type.constants().iterator();
        while (iter.hasNext()) {
            EnumConstantElement value = iter.next();
            String name = value.name();
            int tag = value.tag();

            code.append(name).append("(").append(tag).append(")");
            if (iter.hasNext()) {
                code.append(",");
            } else {
                code.append(";\n");
            }
        }

        code.append("private final int value;\n");
        code.append(simpleName).append("(int value) { this.value = value;  }\n");
        code.append("public int value() { return value; }\n");
        code.append("}\n");

        cd.name = simpleName;
        cd.pkg = packageName;
        cd.code = code.toString();

        return cd;
    }

    /**
     * Creates the code by type.
     *
     * @param protoFile the proto file
     * @param type the type
     * @param enumNames the enum names
     * @param topLevelClass the top level class
     * @param parentNestedTypes the parent nested types
     * @param cds the cds
     * @param packages the packages
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the code dependent
     */
    private static CodeDependent createCodeByType(ProtoFile protoFile, MessageElement type, Set<String> enumNames,
            boolean topLevelClass, List<TypeElement> parentNestedTypes, List<CodeDependent> cds, Set<String> packages,
            Map<String, String> mappedUniName, boolean isUniName) {

        CodeDependent cd = new CodeDependent();

        String packageName = protoFile.packageName();
        String defaultClsName = type.name();
        // to check if has "java_package" option and "java_outer_classname"
        List<OptionElement> options = protoFile.options();
        if (options != null) {
            for (OptionElement option : options) {
                if (option.name().equals(JAVA_PACKAGE_OPTION)) {
                    packageName = option.value().toString();
                }
            }
        }

        String simpleName = getProxyClassName(defaultClsName, mappedUniName, isUniName);

        // To generate class
        StringBuilder code = new StringBuilder();
        if (topLevelClass) {
            // define package
            if (!StringUtils.isEmpty(packageName)) {
                code.append("package ").append(packageName).append(CODE_END);
                code.append("\n");
            }
            // add import;
            code.append("import com.baidu.bjf.remoting.protobuf.FieldType;\n");
            code.append("import com.baidu.bjf.remoting.protobuf.EnumReadable;\n");
            code.append("import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;\n");
        }

        // define class
        String clsName;
        if (topLevelClass) {
            clsName = "public class ";
        } else {
            clsName = "public static class ";
        }
        code.append(clsName).append(simpleName).append(" {\n");

        List<FieldElement> fields = type.fields();

        // get nested types
        List<TypeElement> nestedTypes = fetchAllNestedTypes(type);
        List<TypeElement> checkNestedTypes = new ArrayList<TypeElement>(nestedTypes);

        // to check if has nested classes and check has Enum type
        for (TypeElement t : nestedTypes) {
            if (t instanceof EnumElement) {
                enumNames.add(t.name());
                enumNames.add(getQualifiedName(t, protoFile.packageName()));
            } else {
                checkNestedTypes.add(t);
            }
        }

        checkNestedTypes.addAll(parentNestedTypes);

        for (FieldElement field : fields) {
            // generate comments
            generateCommentsForField(code, field, enumNames);

            // define annotation
            generateProtobufDefinedForField(code, field, enumNames);

            DataType dataType = field.type();
            String typeName;
            if (dataType.kind() == DataType.Kind.MAP) {
                typeName = getTypeName(((DataType.MapType) dataType).keyType());
            } else {
                typeName = getTypeName(field);
            }

            FieldType fType = typeMapping.get(typeName);
            String javaType;
            if (fType == null) {

                // check if Any type
                if (typeName.equals(ProtobufIDLGenerator.GOOGLE_PROTOBUF_ANY_DEF)) {
                    javaType = Any.class.getName();
                } else {
                    javaType = getProxyClassName(getTypeName(field), packages, mappedUniName, isUniName);

                    if (!isNestedTypeDependency(javaType, checkNestedTypes, mappedUniName, isUniName)) {
                        cd.addDependency(javaType);

                        // fixed add package prefix
                        if (packages.size() > 0) {
                            String pkg = packages.iterator().next();
                            if (pkg != null) {
                                javaType = pkg + "." + javaType;
                            }
                        }
                    }
                }
            } else {
                javaType = fType.getJavaType();
            }

            // fix java type for map type
            if (dataType.kind() == DataType.Kind.MAP) {
                DataType.MapType mapType = (DataType.MapType) dataType;
                String keyType = mapType.keyType().toString();
                FieldType subType = typeMapping.get(keyType);
                String keyJavaType;
                if (subType == null) {
                    keyJavaType = keyType;
                } else {
                    keyJavaType = subType.getJavaType();
                }

                String valueType = mapType.valueType().toString();
                subType = typeMapping.get(valueType);

                String valueJavaType;
                if (subType == null) {
                    valueJavaType = getProxyClassName(valueType, packages, mappedUniName, isUniName);

                    if (!isNestedTypeDependency(valueJavaType, checkNestedTypes, mappedUniName, isUniName)) {
                        cd.addDependency(valueJavaType);
                    }
                } else {
                    valueJavaType = subType.getJavaType();
                }

                javaType = Map.class.getName() + "<" + keyJavaType + ", " + valueJavaType + ">";
            }

            // check if repeated type
            if (Label.REPEATED == field.label()) {
                javaType = List.class.getName() + "<" + javaType + ">";
            }

            // define field
            code.append("public ").append(javaType);

            String fieldName = field.name();
            // format java style
            if (formatJavaField) {
                fieldName = JavaStyleFormatter.formatJavaFieldName(fieldName);
            }

            code.append(" ").append(fieldName);

            // check if has default
            OptionElement defaultOption = OptionElement.findByName(field.options(), "default");
            if (defaultOption != null) {
                code.append("=");
                Object defaultValue = defaultOption.value();

                // fix int64 SINT64 FIXED64 default value
                if (dataType == ScalarType.INT64 || dataType == ScalarType.SFIXED64 || dataType == ScalarType.SINT64
                        || dataType == ScalarType.UINT64) {
                    if (!defaultValue.toString().toLowerCase().endsWith("l")) {
                        defaultValue = defaultValue + "L";
                    }
                } else if (dataType == ScalarType.DOUBLE) { //
                    if (!defaultValue.toString().toLowerCase().endsWith("d")) {
                        defaultValue = defaultValue + "D";
                    }
                } else if (dataType == ScalarType.FLOAT) { //
                    if (!defaultValue.toString().toLowerCase().endsWith("f")) {
                        defaultValue = defaultValue + "F";
                    }
                }

                // if is enum type
                if (defaultOption.kind() == Kind.ENUM) {
                    code.append(javaType).append(".").append(defaultValue);
                } else if (defaultOption.kind() == Kind.STRING) {
                    code.append("\"").append(defaultValue).append("\"");
                } else {
                    code.append(String.valueOf(defaultValue));
                }
            }

            code.append(CODE_END);

            // add getter and setter method
            generateSetter(code, javaType, fieldName);
            generateGetter(code, javaType, fieldName);
        }

        // to check if has nested classes
        if (nestedTypes != null) {
            for (TypeElement t : nestedTypes) {
                CodeDependent nestedCd;
                String fqname = getQualifiedName(t, protoFile.packageName());
                String subClsName = getProxyClassName(fqname, mappedUniName, isUniName);
                if (t instanceof EnumElement) {
                    nestedCd = createCodeByType((EnumElement) t, false, packageName, mappedUniName, isUniName);
                    enumNames.add(t.name());
                } else {
                    nestedCd = createCodeByType(protoFile, (MessageElement) t, enumNames, false, checkNestedTypes, cds,
                            getPackages(cds), mappedUniName, isUniName);
                }
                nestedCd.addSubClass(subClsName);
                nestedCd.addSubClass(packageName + PACKAGE_SPLIT_CHAR + subClsName);

                code.append(nestedCd.code);
                // merge dependency
                cd.dependencies.addAll(nestedCd.dependencies);

                cd.subClasses.addAll(nestedCd.subClasses);
            }
        }

        code.append("}\n");

        cd.name = simpleName;
        cd.pkg = packageName;
        cd.code = code.toString();

        // finally dependency should remove self
        cd.dependencies.remove(cd.name);

        // also remove parent include
        if (!parentNestedTypes.isEmpty()) {
            for (TypeElement t : checkNestedTypes) {
                Iterator<String> iterator = cd.dependencies.iterator();
                while (iterator.hasNext()) {
                    String dependName = iterator.next().replaceAll(DEFAULT_SUFFIX_CLASSNAME, "");
                    if (t.qualifiedName().endsWith(dependName)) {
                        iterator.remove();
                    }
                }
            }
        }

        return cd;
    }

    /**
     * Generate getter.
     *
     * @param code the code
     * @param javaType the java type
     * @param fieldName the field name
     */
    private static void generateSetter(StringBuilder code, String javaType, String fieldName) {
        code.append("public void set").append(StringUtils.capitalize(fieldName)).append("(");
        code.append(javaType).append(" ").append(fieldName).append(") {").append(ClassCode.LINE_BREAK);
        code.append("this.").append(fieldName).append("=").append(fieldName).append(ClassCode.JAVA_LINE_BREAK);
        code.append("}").append(ClassCode.JAVA_LINE_BREAK);
    }

    /**
     * Generate getter.
     *
     * @param code the code
     * @param javaType the java type
     * @param fieldName the field name
     */
    private static void generateGetter(StringBuilder code, String javaType, String fieldName) {

        String action = "get";
        if (javaType.toLowerCase().equals("boolean")) {
            action = "is";
        }

        code.append("public ").append(javaType).append(" ").append(action).append(StringUtils.capitalize(fieldName))
                .append("() {").append(ClassCode.LINE_BREAK);
        code.append("return this.").append(fieldName).append(ClassCode.JAVA_LINE_BREAK);
        code.append("}").append(ClassCode.JAVA_LINE_BREAK);
    }

    /**
     * Generate comments for field.
     *
     * @param code the code
     * @param field the field
     * @param enumNames the enum names
     */
    private static void generateCommentsForField(StringBuilder code, FieldElement field, Set<String> enumNames) {
        code.append("/**").append(ClassCode.LINE_BREAK);
        code.append("* ").append(field.documentation()).append(ClassCode.LINE_BREAK);
        code.append("* ");
        if (field.label() != null) {
            code.append(StringUtils.toLowerCase(field.label().toString())).append(" ");
        }
        code.append(field.type().toString()).append(" ").append(field.name().toString());
        code.append("=").append(field.tag()).append(ClassCode.LINE_BREAK);
        code.append("*/").append(ClassCode.LINE_BREAK);
    }

    /**
     * Creates the enum classes.
     *
     * @param enumTypes the enum types
     * @param packageMapping the package mapping
     * @param generateSouceOnly the generate souce only
     * @param sourceOutputDir the source output dir
     * @param compiledClass the compiled class
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the list
     */
    private static List<Class<?>> createEnumClasses(Map<String, EnumElement> enumTypes,
            Map<String, String> packageMapping, boolean debug, boolean generateSouceOnly, File sourceOutputDir,
            Set<String> compiledClass, Map<String, String> mappedUniName, boolean isUniName) {

        List<Class<?>> ret = new ArrayList<Class<?>>();
        Set<String> enumNames = new HashSet<String>();
        Collection<EnumElement> enums = enumTypes.values();
        for (EnumElement enumType : enums) {
            String name = enumType.name();
            if (enumNames.contains(name)) {
                continue;
            }
            enumNames.add(name);
            String packageName = packageMapping.get(name);
            Class cls = checkClass(packageName, enumType, mappedUniName, isUniName);
            if (cls != null) {
                ret.add(cls);
                continue;
            }
            CodeDependent codeDependent = createCodeByType(enumType, true, packageName, mappedUniName, isUniName);
            compiledClass.add(codeDependent.name);
            compiledClass.add(packageName + PACKAGE_SPLIT_CHAR + codeDependent.name);

            if (debug) {
                CodePrinter.printCode(codeDependent.code, "generate jprotobuf code");
            }

            if (!generateSouceOnly) {
                Class<?> newClass = JDKCompilerHelper.getJdkCompiler().compile(codeDependent.getClassName(),
                        codeDependent.code, ProtobufIDLProxy.class.getClassLoader(), null, -1);
                ret.add(newClass);
            } else {
                // need to output source code to target path
                writeSourceCode(codeDependent, sourceOutputDir);
            }
        }

        return ret;
    }

    /**
     * Creates the message class.
     *
     * @param protoFile the proto file
     * @param multi the multi
     * @param debug the debug
     * @param generateSouceOnly the generate souce only
     * @param sourceOutputDir the source output dir
     * @param cds the cds
     * @param compiledClass the compiled class
     * @param enumNames the enum names
     * @param packages the packages
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the list
     */
    private static List<Class<?>> createMessageClass(ProtoFile protoFile, boolean multi, boolean debug,
            boolean generateSouceOnly, File sourceOutputDir, List<CodeDependent> cds, Set<String> compiledClass,
            Set<String> enumNames, Set<String> packages, Map<String, String> mappedUniName, boolean isUniName) {

        List<TypeElement> types = protoFile.typeElements();
        if (types == null || types.isEmpty()) {
            throw new RuntimeException("No message defined in '.proto' IDL");
        }

        int count = 0;
        Iterator<TypeElement> iter = types.iterator();
        while (iter.hasNext()) {
            TypeElement next = iter.next();
            if (next instanceof EnumElement) {
                continue;
            }
            count++;
        }

        if (!multi && count != 1) {
            throw new RuntimeException("Only one message defined allowed in '.proto' IDL");
        }

        List<Class<?>> ret = new ArrayList<Class<?>>(types.size());

        List<MessageElement> messageTypes = new ArrayList<MessageElement>();
        for (TypeElement type : types) {
            Class checkClass = checkClass(protoFile, type, mappedUniName, isUniName);
            if (checkClass != null) {
                ret.add(checkClass);
                continue;
            }

            CodeDependent cd;
            if (type instanceof MessageElement) {
                messageTypes.add((MessageElement) type);
                continue;
            }
        }

        for (MessageElement mt : messageTypes) {
            CodeDependent cd;
            cd = createCodeByType(protoFile, (MessageElement) mt, enumNames, true, new ArrayList<TypeElement>(), cds,
                    packages, mappedUniName, isUniName);

            if (cd.isDepndency()) {
                cds.add(cd);
            } else {
                cds.add(0, cd);
            }
        }
        CodeDependent codeDependent;
        // copy cds
        List<CodeDependent> copiedCds = new ArrayList<ProtobufIDLProxy.CodeDependent>(cds);
        while ((codeDependent = hasDependency(copiedCds, compiledClass)) != null) {
            if (debug) {
                CodePrinter.printCode(codeDependent.code, "generate jprotobuf code");
            }
            if (!generateSouceOnly) {
                Class<?> newClass = JDKCompilerHelper.getJdkCompiler().compile(codeDependent.getClassName(),
                        codeDependent.code, ProtobufIDLProxy.class.getClassLoader(), null, -1);
                ret.add(newClass);
            } else {
                // need to output source code to target path
                writeSourceCode(codeDependent, sourceOutputDir);
            }
        }

        return ret;
    }

    /**
     * Creates the single.
     *
     * @param is the is
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(InputStream is) throws IOException {
        return createSingle(is, false);
    }

    /**
     * Creates the single.
     *
     * @param is the is
     * @param debug the debug
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(InputStream is, boolean debug) throws IOException {
        return createSingle(is, debug, null, true);
    }

    /**
     * Creates the single.
     *
     * @param is the is
     * @param debug the debug
     * @param isUniName the is uni name
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(InputStream is, boolean debug, boolean isUniName) throws IOException {
        return createSingle(is, debug, null, isUniName);
    }

    /**
     * Creates the single.
     *
     * @param is the is
     * @param debug the debug
     * @param path the path
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(InputStream is, boolean debug, File path) throws IOException {
        return createSingle(is, debug, path, true);
    }

    /**
     * Creates the single.
     *
     * @param is the is
     * @param debug the debug
     * @param path the path
     * @param isUniName the is uni name
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(InputStream is, boolean debug, File path, boolean isUniName)
            throws IOException {
        ProtoFile protoFile = ProtoParser.parseUtf8(DEFAULT_FILE_NAME, is);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        Map<String, IDLProxyObject> map =
                doCreate(protoFile, false, debug, path, false, null, cds, new HashMap<String, String>(), isUniName);
        return map.entrySet().iterator().next().getValue();
    }

    /**
     * Creates the single.
     *
     * @param reader the reader
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(Reader reader) throws IOException {
        return createSingle(reader, false);
    }

    /**
     * Creates the single.
     *
     * @param reader the reader
     * @param debug the debug
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(Reader reader, boolean debug) throws IOException {
        return createSingle(reader, debug, null, true);
    }

    /**
     * Creates the single.
     *
     * @param reader the reader
     * @param debug the debug
     * @param isUniName the is uni name
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(Reader reader, boolean debug, boolean isUniName) throws IOException {
        return createSingle(reader, debug, null, isUniName);
    }

    /**
     * Creates the single.
     *
     * @param reader the reader
     * @param debug the debug
     * @param path the path
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(Reader reader, boolean debug, File path) throws IOException {
        return createSingle(reader, debug, path, true);
    }

    /**
     * Creates the single.
     *
     * @param reader the reader
     * @param debug the debug
     * @param path the path
     * @param isUniName the is uni name
     * @return the IDL proxy object
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static IDLProxyObject createSingle(Reader reader, boolean debug, File path, boolean isUniName)
            throws IOException {
        ProtoFile protoFile = ProtoParser.parse(DEFAULT_FILE_NAME, reader);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        Map<String, IDLProxyObject> map =
                doCreate(protoFile, false, debug, path, false, null, cds, new HashMap<String, String>(), isUniName);
        return map.entrySet().iterator().next().getValue();
    }

    /**
     * Creates the single.
     *
     * @param data the data
     * @return the IDL proxy object
     */
    public static IDLProxyObject createSingle(String data) {
        return createSingle(data, false);
    }

    /**
     * Creates the single.
     *
     * @param data the data
     * @param debug the debug
     * @return the IDL proxy object
     */
    public static IDLProxyObject createSingle(String data, boolean debug) {
        return createSingle(data, debug, null, true);
    }

    /**
     * Creates the single.
     *
     * @param data the data
     * @param debug the debug
     * @param isUniName set true will create a unique different class name
     * @return the IDL proxy object
     */
    public static IDLProxyObject createSingle(String data, boolean debug, boolean isUniName) {
        return createSingle(data, debug, null, isUniName);
    }

    /**
     * Creates the single.
     *
     * @param data the data
     * @param debug the debug
     * @param path the path
     * @return the IDL proxy object
     */
    public static IDLProxyObject createSingle(String data, boolean debug, File path) {
        return createSingle(data, debug, path, true);
    }

    /**
     * Creates the single.
     *
     * @param data the data
     * @param debug the debug
     * @param path the path
     * @param isUniName the is uni name
     * @return the IDL proxy object
     */
    public static IDLProxyObject createSingle(String data, boolean debug, File path, boolean isUniName) {
        ProtoFile protoFile = ProtoParser.parse(DEFAULT_FILE_NAME, data);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        Map<String, IDLProxyObject> map;
        try {
            map = doCreate(protoFile, false, debug, path, false, null, cds, new HashMap<String, String>(), isUniName);
            return map.entrySet().iterator().next().getValue();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    /**
     * Do create.
     *
     * @param protoFile the proto file
     * @param multi the multi
     * @param debug the debug
     * @param path the path
     * @param generateSouceOnly the generate souce only
     * @param sourceOutputDir the source output dir
     * @param cds the cds
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static Map<String, IDLProxyObject> doCreate(ProtoFile protoFile, boolean multi, boolean debug, File path,
            boolean generateSouceOnly, File sourceOutputDir, List<CodeDependent> cds, Map<String, String> mappedUniName,
            boolean isUniName) throws IOException {
        return doCreatePro(Arrays.asList(protoFile), multi, debug, path, generateSouceOnly, sourceOutputDir, cds,
                new HashSet<String>(), mappedUniName, isUniName);
    }

    /**
     * Do create pro.
     *
     * @param file the file
     * @param multi the multi
     * @param debug the debug
     * @param path the path
     * @param generateSouceOnly the generate souce only
     * @param sourceOutputDir the source output dir
     * @param cds the cds
     * @param compiledClass the compiled class
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static Map<String, IDLProxyObject> doCreatePro(File file, boolean multi, boolean debug, File path,
            boolean generateSouceOnly, File sourceOutputDir, List<CodeDependent> cds, Set<String> compiledClass,
            Map<String, String> mappedUniName, boolean isUniName) throws IOException {

        checkDirectory(generateSouceOnly, sourceOutputDir);

        // to find all PROTO file if using import command
        List<ProtoFile> protoFiles = findRelateProtoFiles(file, new HashSet<String>());
        Collections.reverse(protoFiles);
        return doCreatePro(protoFiles, multi, debug, path, generateSouceOnly, sourceOutputDir, cds, compiledClass,
                mappedUniName, isUniName);

    }

    /**
     * Do create pro.
     *
     * @param protoFiles the proto files
     * @param multi the multi
     * @param debug the debug
     * @param path the path
     * @param generateSouceOnly the generate souce only
     * @param sourceOutputDir the source output dir
     * @param cds the cds
     * @param compiledClass the compiled class
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the map
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static Map<String, IDLProxyObject> doCreatePro(List<ProtoFile> protoFiles, boolean multi, boolean debug,
            File path, boolean generateSouceOnly, File sourceOutputDir, List<CodeDependent> cds,
            Set<String> compiledClass, Map<String, String> mappedUniName, boolean isUniName) throws IOException {

        int count = 0;

        Map<String, EnumElement> enumTypes = new HashMap<String, EnumElement>();
        // package mapping
        Map<String, String> packageMapping = new HashMap<String, String>();

        Set<String> packages = new HashSet<String>();
        for (ProtoFile protoFile : protoFiles) {

            List<TypeElement> types = protoFile.typeElements();
            if (types == null || types.isEmpty()) {
                continue;
            }

            String packageName = protoFile.packageName();
            // to check if option has "java_package"
            List<OptionElement> options = protoFile.options();
            if (options != null) {
                for (OptionElement option : options) {
                    if (option.name().equals(JAVA_PACKAGE_OPTION)) {
                        packageName = option.value().toString();
                    }
                }
            }
            packages.add(packageName);

            for (TypeElement type : types) {
                packageMapping.put(type.name(), packageName);
                packageMapping.put(getQualifiedName(type, protoFile.packageName()), packageName);

                if (type instanceof MessageElement) {
                    count++;
                } else {
                    enumTypes.put(type.name(), (EnumElement) type);
                    enumTypes.put(getQualifiedName(type, protoFile.packageName()), (EnumElement) type);
                }
            }
        }

        if (!multi && count != 1) {
            throw new RuntimeException("Only one message defined allowed in '.proto' IDL");
        }

        // create enum type classes
        List<Class<?>> clsList = createEnumClasses(enumTypes, packageMapping, debug, generateSouceOnly, sourceOutputDir,
                compiledClass, mappedUniName, isUniName);

        for (ProtoFile protoFile : protoFiles) {
            // create message type classes
            List<Class<?>> messageClasses =
                    createMessageClass(protoFile, multi, debug, generateSouceOnly, sourceOutputDir, cds, compiledClass,
                            new HashSet<String>(enumTypes.keySet()), packages, mappedUniName, isUniName);
            clsList.addAll(messageClasses);

        }

        Map<String, IDLProxyObject> ret = new HashMap<String, IDLProxyObject>();
        for (Class cls : clsList) {
            Object newInstance;
            try {
                if (Enum.class.isAssignableFrom(cls)) {
                    continue;
                }
                newInstance = cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }

            ProtobufProxy.enableCache(false);
            try {
                Codec codec = ProtobufProxy.create(cls, debug, path);
                IDLProxyObject idlProxyObject = new IDLProxyObject(codec, newInstance, cls);
                String name = cls.getSimpleName();
                if (name.indexOf(DEFAULT_SUFFIX_CLASSNAME) != -1) {
                    name = StringUtils.substringBefore(name, DEFAULT_SUFFIX_CLASSNAME);
                }
                ret.put(name, idlProxyObject);
            } finally {
                ProtobufProxy.enableCache(true);
            }
        }

        return ret;
    }

    /**
     * Fetch all nested types.
     *
     * @param type the type
     * @return the list
     */
    private static List<TypeElement> fetchAllNestedTypes(MessageElement type) {
        List<TypeElement> ret = new ArrayList<TypeElement>();

        List<TypeElement> nestedTypes = type.nestedElements();
        ret.addAll(nestedTypes);
        for (TypeElement t : nestedTypes) {
            if (t instanceof MessageElement) {
                List<TypeElement> subNestedTypes = fetchAllNestedTypes((MessageElement) t);
                ret.addAll(subNestedTypes);
            }
        }
        return ret;
    }

    /**
     * Find relate proto files.
     *
     * @param file the file
     * @param dependencyNames the dependency names
     * @return the list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static List<ProtoFile> findRelateProtoFiles(File file, Set<String> dependencyNames) throws IOException {
        LinkedList<ProtoFile> protoFiles = new LinkedList<ProtoFile>();
        ProtoFile protoFile = ProtoParser.parseUtf8(file);
        protoFiles.addFirst(protoFile);

        String parent = file.getParent();
        // parse dependency, to find all PROTO file if using import command
        List<String> dependencies = protoFile.dependencies();
        if (dependencies != null && !dependencies.isEmpty()) {
            for (String fn : dependencies) {
                if (fn.startsWith("google/protobuf/")) {
                    // to ignore google internal defined proto file
                    continue;
                }

                if (dependencyNames.contains(fn)) {
                    continue;
                }
                File dependencyFile = new File(parent, fn);
                protoFiles.addAll(findRelateProtoFiles(dependencyFile, dependencyNames));
            }
        }

        List<String> publicDependencies = protoFile.publicDependencies();
        if (publicDependencies != null && !publicDependencies.isEmpty()) {
            for (String fn : publicDependencies) {
                if (dependencyNames.contains(fn)) {
                    continue;
                }
                File dependencyFile = new File(parent, fn);
                protoFiles.addAll(findRelateProtoFiles(dependencyFile, dependencyNames));
            }
        }

        return protoFiles;
    }

    /**
     * to generate @Protobuf defined code for target field.
     *
     * @param code the code
     * @param field the field
     * @param enumNames the enum names
     */
    private static void generateProtobufDefinedForField(StringBuilder code, FieldElement field, Set<String> enumNames) {
        code.append("@").append(Protobuf.class.getSimpleName()).append("(");

        String fieldType = fieldTypeMapping.get(getTypeName(field));
        if (fieldType == null) {
            if (enumNames.contains(getTypeName(field))) {
                fieldType = "FieldType.ENUM";
            } else {
                if (field.type().kind() == DataType.Kind.MAP) {
                    fieldType = "FieldType.MAP";
                } else {
                    fieldType = "FieldType.OBJECT";
                }

            }
        }

        code.append("fieldType=").append(fieldType);
        code.append(", order=").append(field.tag());
        if (FieldElement.Label.OPTIONAL == field.label()) {
            code.append(", required=false");
        } else if (Label.REQUIRED == field.label()) {
            code.append(", required=true");
        }
        code.append(")\n");

    }

    /**
     * Generate source.
     *
     * @param file the file
     * @param sourceOutputPath the source output path
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void generateSource(File file, File sourceOutputPath) throws IOException {
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        generateSource(file, sourceOutputPath, cds, new HashSet<String>());
    }

    /**
     * Generate source.
     *
     * @param file the file
     * @param sourceOutputPath the source output path
     * @param cds the cds
     * @param compiledClass the compiled class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void generateSource(File file, File sourceOutputPath, List<CodeDependent> cds,
            Set<String> compiledClass) throws IOException {

        doCreatePro(file, true, false, null, true, sourceOutputPath, cds, compiledClass, new HashMap<String, String>(),
                false);
    }

    /**
     * Generate source.
     *
     * @param is the is
     * @param sourceOutputPath the source output path
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void generateSource(InputStream is, File sourceOutputPath) throws IOException {
        ProtoFile protoFile = ProtoParser.parseUtf8(DEFAULT_FILE_NAME, is);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        doCreate(protoFile, true, false, null, true, sourceOutputPath, cds, new HashMap<String, String>(), false);
    }

    /**
     * Generate source.
     *
     * @param reader the reader
     * @param sourceOutputPath the source output path
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void generateSource(Reader reader, File sourceOutputPath) throws IOException {
        ProtoFile protoFile = ProtoParser.parse(DEFAULT_FILE_NAME, reader);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        doCreate(protoFile, true, false, null, true, sourceOutputPath, cds, new HashMap<String, String>(), false);
    }

    /**
     * Generate source.
     *
     * @param data the data
     * @param sourceOutputPath the source output path
     */
    public static void generateSource(String data, File sourceOutputPath) {
        ProtoFile protoFile = ProtoParser.parse(DEFAULT_FILE_NAME, data);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        try {
            doCreate(protoFile, true, false, null, true, sourceOutputPath, cds, new HashMap<String, String>(), false);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * Gets the packages.
     *
     * @param cds the cds
     * @return the packages
     */
    private static Set<String> getPackages(List<CodeDependent> cds) {
        Set<String> ret = new HashSet<String>();
        if (cds == null) {
            return ret;
        }
        for (CodeDependent cd : cds) {
            ret.add(cd.pkg);
        }

        return ret;
    }

    /**
     * Gets the proxy class name.
     *
     * @param name the name
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the proxy class name
     */
    private static String getProxyClassName(String name, Map<String, String> mappedUniName, boolean isUniName) {
        Set<String> emptyPkgs = Collections.emptySet();
        return getProxyClassName(name, emptyPkgs, mappedUniName, isUniName);
    }

    /**
     * Gets the proxy class name.
     *
     * @param name the name
     * @param pkgs the pkgs
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return the proxy class name
     */
    private static String getProxyClassName(String name, Set<String> pkgs, Map<String, String> mappedUniName,
            boolean isUniName) {

        String ret = "";
        if (name.indexOf(PACKAGE_SPLIT_CHAR) != -1) {
            String[] split = name.split("\\.");
            boolean classFound = false;
            for (String string : split) {
                if (pkgs.contains(string) && !classFound) {
                    ret += string + PACKAGE_SPLIT_CHAR;
                } else {
                    classFound = true;
                    ret += getProxyClassName(string, mappedUniName, isUniName) + PACKAGE_SPLIT_CHAR;
                }
            }
            ret = StringUtils.removeEnd(ret, PACKAGE_SPLIT);
        } else {
            String clsName = name;

            String uniName = mappedUniName.get(clsName);
            if (uniName == null) {
                uniName = clsName + getUniNameSuffix(isUniName);
                mappedUniName.put(clsName, uniName);
            }
            clsName = uniName;
            ret = clsName;
        }
        return ret;
    }

    /**
     * Gets the type name.
     *
     * @param type the type
     * @return the type name
     */
    private static String getTypeName(DataType type) {
        return type.toString();
    }

    /**
     * Gets the type name.
     *
     * @param field the field
     * @return the type name
     */
    private static String getTypeName(FieldElement field) {
        DataType type = field.type();
        return type.toString();
    }

    /**
     * Gets the uni name suffix.
     *
     * @param uniName the uni name
     * @return the uni name suffix
     */
    private static String getUniNameSuffix(boolean uniName) {
        if (!uniName) {
            return "";
        }
        return DEFAULT_SUFFIX_CLASSNAME + UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Checks for dependency.
     *
     * @param cds the cds
     * @param compiledClass the compiled class
     * @return the code dependent
     */
    private static CodeDependent hasDependency(List<CodeDependent> cds, Set<String> compiledClass) {
        if (cds.isEmpty()) {
            return null;
        }

        Iterator<CodeDependent> iterator = cds.iterator();
        while (iterator.hasNext()) {
            CodeDependent next = iterator.next();
            compiledClass.addAll(next.subClasses);
            if (!next.isDepndency()) {
                compiledClass.add(next.name);
                compiledClass.add(next.pkg + PACKAGE_SPLIT_CHAR + next.name);
                iterator.remove();
                return next;
            } else {
                Set<String> dependencies = next.dependencies;
                if (compiledClass.containsAll(dependencies)) {
                    compiledClass.add(next.name);
                    compiledClass.add(next.pkg + PACKAGE_SPLIT_CHAR + next.name);
                    iterator.remove();
                    return next;
                }
            }
        }

        // if cds is not empty guess there is some message dependency is not
        // available. so error idl protobuf defined?
        Set<String> guessLoadedClass = new HashSet<String>(compiledClass);
        if (!cds.isEmpty()) {
            iterator = cds.iterator();
            while (iterator.hasNext()) {
                CodeDependent codeDependent = iterator.next();
                guessLoadedClass.add(codeDependent.name);
            }

            // to check while message's dependency is missed
            iterator = cds.iterator();
            while (iterator.hasNext()) {
                CodeDependent next = iterator.next();
                if (!next.isDepndency()) {
                    continue;
                }

                if (guessLoadedClass.containsAll(next.dependencies)) {
                    continue;
                }

                for (String dependClass : next.dependencies) {
                    if (!guessLoadedClass.contains(dependClass)) {
                        throw new RuntimeException("Message '"
                                + StringUtils.removeEnd(next.name, DEFAULT_SUFFIX_CLASSNAME) + "' depend on message '"
                                + dependClass.replace(DEFAULT_SUFFIX_CLASSNAME, "") + "' is missed");
                    }
                }
            }

        }

        return null;
    }

    /**
     * Checks if is nested type dependency.
     *
     * @param type the type
     * @param nestedTypes the nested types
     * @param mappedUniName the mapped uni name
     * @param isUniName the is uni name
     * @return true, if is nested type dependency
     */
    private static boolean isNestedTypeDependency(String type, List<TypeElement> nestedTypes,
            Map<String, String> mappedUniName, boolean isUniName) {
        if (nestedTypes == null) {
            return false;
        }

        for (TypeElement t : nestedTypes) {
            if (type.equals(t.name()) || type.equals(getProxyClassName(t.name(), mappedUniName, isUniName))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Write source code.
     *
     * @param cd the cd
     * @param sourceOutputDir the source output dir
     */
    private static void writeSourceCode(CodeDependent cd, File sourceOutputDir) {
        if (cd.pkg == null) {
            cd.pkg = "";
        }

        // mkdirs
        String dir = sourceOutputDir + File.separator + cd.pkg.replace('.', File.separatorChar);
        File f = new File(dir);
        f.mkdirs();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(f, cd.name + JAVA_SUFFIX));
            fos.write(cd.code.getBytes(UTF_8));
            fos.flush();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }

    }

    /**
     * Gets the qualified name.
     *
     * @param e the e
     * @param customizePackageName the customize package name
     * @return the qualified name
     */
    private static String getQualifiedName(TypeElement e, String customizePackageName) {
        if (StringUtils.isEmpty(customizePackageName)) {
            return e.qualifiedName();
        }
        return StringUtils.removeStart(e.qualifiedName(), customizePackageName + PACKAGE_SPLIT);
    }
}
