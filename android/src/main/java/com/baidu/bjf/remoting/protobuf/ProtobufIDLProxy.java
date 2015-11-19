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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.utils.CodePrinter;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.squareup.protoparser.EnumType;
import com.squareup.protoparser.EnumType.Value;
import com.squareup.protoparser.MessageType;
import com.squareup.protoparser.MessageType.Field;
import com.squareup.protoparser.MessageType.Label;
import com.squareup.protoparser.Option;
import com.squareup.protoparser.ProtoFile;
import com.squareup.protoparser.ProtoSchemaParser;
import com.squareup.protoparser.Type;

/**
 * This class is for dynamic create protobuf utility class directly from .proto file
 * 
 * @author xiemalin
 * @since 1.0.2
 */
public class ProtobufIDLProxy {

    /**
     * 
     */
    private static final String UTF_8 = "utf-8";

    /**
     * java outer class name
     */
    private static final String JAVA_OUTER_CLASSNAME_OPTION = "java_outer_classname";

    /**
     * java package
     */
    private static final String JAVA_PACKAGE_OPTION = "java_package";

    /**
     * code line end wrap
     */
    private static final String CODE_END = ";\n";

    /**
     * default proto file name
     */
    public static final String DEFAULT_FILE_NAME = "jprotobuf_autogenerate";

    /**
     * type mapping of field type
     */
    private static final Map<String, FieldType> typeMapping;

    /**
     * type mapping of field type in string
     */
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
    }

    /**
     * auto proxied suffix class name
     */
    private static final String DEFAULT_SUFFIX_CLASSNAME = "JProtoBufProtoClass";


    public static void generateSource(String data, File sourceOutputPath) {
        ProtoFile protoFile = ProtoSchemaParser.parse(DEFAULT_FILE_NAME, data);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        doCreate(protoFile, true, false, null, true, sourceOutputPath, cds);
    }

    public static void generateSource(InputStream is, File sourceOutputPath) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parseUtf8(DEFAULT_FILE_NAME, is);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        doCreate(protoFile, true, false, null, true, sourceOutputPath, cds);
    }

    public static void generateSource(Reader reader, File sourceOutputPath) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parse(DEFAULT_FILE_NAME, reader);
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        doCreate(protoFile, true, false, null, true, sourceOutputPath, cds);
    }

    public static void generateSource(File file, File sourceOutputPath) throws IOException {
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        generateSource(file, sourceOutputPath, cds);
    }

    public static void generateSource(File file, File sourceOutputPath, List<CodeDependent> cds) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parse(file);
        Set<String> dependencyNames = new HashSet<String>();
        String parent = file.getParent();
        // parse dependency
        List<String> dependencies = protoFile.getDependencies();
        if (dependencies != null && !dependencies.isEmpty()) {
            for (String fn : dependencies) {
                if (dependencyNames.contains(fn)) {
                    continue;
                }
                File dependencyFile = new File(parent, fn);
                generateSource(dependencyFile, sourceOutputPath, cds);
            }
        }

        doCreate(protoFile, true, false, null, true, sourceOutputPath, cds);
    }

    private static Map<String, IDLProxyObject> doCreate(ProtoFile protoFile, boolean multi, boolean debug, File path,
            boolean generateSouceOnly, File sourceOutputDir, List<CodeDependent> cds) {

        List<Class> list = createClass(protoFile, multi, debug, generateSouceOnly, sourceOutputDir, cds);
        Map<String, IDLProxyObject> ret = new HashMap<String, IDLProxyObject>();
        for (Class cls : list) {
            Object newInstance;
            try {
                if (Enum.class.isAssignableFrom(cls)) {
                    continue;
                }
                newInstance = cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }

            Codec codec = ProtobufProxy.create(cls);
            IDLProxyObject idlProxyObject = new IDLProxyObject(codec, newInstance, cls);

            String name = cls.getSimpleName();
            if (name.endsWith(DEFAULT_SUFFIX_CLASSNAME)) {
                name = name.substring(0, name.length() - DEFAULT_SUFFIX_CLASSNAME.length());
            }
            ret.put(name, idlProxyObject);
        }

        return ret;
    }

    /**
     * @param protoFile
     * @param multi
     * @param debug
     * @param generateSouceOnly
     * @param sourceOutputDir
     * @return
     */
    private static List<Class> createClass(ProtoFile protoFile, boolean multi, boolean debug, boolean generateSouceOnly,
            File sourceOutputDir, List<CodeDependent> cds) {
        if (generateSouceOnly) {
            if (sourceOutputDir == null) {
                throw new RuntimeException("param 'sourceOutputDir' is null.");
            }

            if (!sourceOutputDir.isDirectory()) {
                throw new RuntimeException("param 'sourceOutputDir' should be a exist file directory.");
            }
        }

        List<Type> types = protoFile.getTypes();
        if (types == null || types.isEmpty()) {
            throw new RuntimeException("No message defined in '.proto' IDL");
        }

        int count = 0;
        Iterator<Type> iter = types.iterator();
        while (iter.hasNext()) {
            Type next = iter.next();
            if (next instanceof EnumType) {
                continue;
            }
            count++;
        }

        if (!multi && count != 1) {
            throw new RuntimeException("Only one message defined allowed in '.proto' IDL");
        }

        List<Class> ret = new ArrayList<Class>(types.size());

        List<MessageType> messageTypes = new ArrayList<MessageType>();
        Set<String> enumNames = new HashSet<String>();
        Set<String> compiledClass = new HashSet<String>();
        for (Type type : types) {
            Class checkClass = checkClass(protoFile, type);
            if (checkClass != null) {
                ret.add(checkClass);
                continue;
            }

            CodeDependent cd;
            if (type instanceof MessageType) {
                messageTypes.add((MessageType) type);
                continue;
            } else {
                cd = createCodeByType(protoFile, (EnumType) type, true);
                enumNames.add(type.getName());
            }

            if (debug) {
                CodePrinter.printCode(cd.code, "generate jprotobuf code");
            }

            if (!generateSouceOnly) {
            } else {
                // need to output source code to target path
                writeSourceCode(cd, sourceOutputDir);
            }
            compiledClass.add(cd.name);
            // all enum type class will be ingored to use directly
        }

        for (MessageType mt : messageTypes) {
            CodeDependent cd;
            cd = createCodeByType(protoFile, (MessageType) mt, enumNames, true, new ArrayList<Type>());

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
            } else {
                // need to output source code to target path
                writeSourceCode(codeDependent, sourceOutputDir);
            }
        }

        return ret;
    }

    /**
     * @param cd
     * @param sourceOutputDir
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
            fos = new FileOutputStream(new File(f, cd.name + ".java"));
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

    private static CodeDependent hasDependency(List<CodeDependent> cds, Set<String> compiledClass) {
        if (cds.isEmpty()) {
            return null;
        }

        Iterator<CodeDependent> iterator = cds.iterator();
        while (iterator.hasNext()) {
            CodeDependent next = iterator.next();
            if (!next.isDepndency()) {
                compiledClass.add(next.name);
                iterator.remove();
                return next;
            } else {
                Set<String> dependencies = next.dependencies;
                if (compiledClass.containsAll(dependencies)) {
                    compiledClass.add(next.name);
                    iterator.remove();
                    return next;
                }
            }
        }

        // if cds is not empty guess there is some message dependency is not available. so error idl protobuf defined?
        if (!cds.isEmpty()) {
            Set<String> guessLoadedClass = new HashSet<String>(compiledClass);
            iterator = cds.iterator();
            while (iterator.hasNext()) {
                guessLoadedClass.add(iterator.next().name);
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
                                + StringUtils.removeEnd(dependClass, DEFAULT_SUFFIX_CLASSNAME) + "' is missed");
                    }
                }
            }

        }

        return null;
    }

    private static CodeDependent createCodeByType(ProtoFile protoFile, EnumType type, boolean topLevelClass) {

        CodeDependent cd = new CodeDependent();

        String packageName = protoFile.getPackageName();
        String defaultClsName = type.getName();
        // to check if has "java_package" option and "java_outer_classname"
        List<Option> options = protoFile.getOptions();
        if (options != null) {
            for (Option option : options) {
                if (option.getName().equals(JAVA_PACKAGE_OPTION)) {
                    packageName = option.getValue().toString();
                }
            }
        }

        String simpleName = defaultClsName + DEFAULT_SUFFIX_CLASSNAME;

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
        code.append("public enum ").append(simpleName).append(" implements EnumReadable {\n");

        Iterator<Value> iter = type.getValues().iterator();
        while (iter.hasNext()) {
            Value value = iter.next();
            String name = value.getName();
            int tag = value.getTag();

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

    private static CodeDependent createCodeByType(ProtoFile protoFile, MessageType type, Set<String> enumNames,
            boolean topLevelClass, List<Type> parentNestedTypes) {

        CodeDependent cd = new CodeDependent();

        String packageName = protoFile.getPackageName();
        String defaultClsName = type.getName();
        // to check if has "java_package" option and "java_outer_classname"
        List<Option> options = protoFile.getOptions();
        if (options != null) {
            for (Option option : options) {
                if (option.getName().equals(JAVA_PACKAGE_OPTION)) {
                    packageName = option.getValue().toString();
                }
            }
        }

        String simpleName = defaultClsName + DEFAULT_SUFFIX_CLASSNAME;

        // To generate class
        StringBuilder code = new StringBuilder();
        if (topLevelClass) {
            // define package
            code.append("package ").append(packageName).append(CODE_END);
            code.append("\n");
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

        List<Field> fields = type.getFields();

        // get nested types
        List<Type> nestedTypes = fetchAllNestedTypes(type);
        List<Type> checkNestedTypes = new ArrayList<Type>(nestedTypes);

        // to check if has nested classes and check has Enum type
        for (Type t : nestedTypes) {
            if (t instanceof EnumType) {
                enumNames.add(t.getName());
            }
        }

        checkNestedTypes.addAll(parentNestedTypes);

        for (Field field : fields) {
            // define annotation
            generateProtobufDefinedForField(code, field, enumNames);

            FieldType fType = typeMapping.get(field.getType());
            String javaType;
            if (fType == null) {
                javaType = field.getType() + DEFAULT_SUFFIX_CLASSNAME;
                if (!isNestedTypeDependency(field.getType(), checkNestedTypes)) {
                    cd.addDependency(javaType);
                }
            } else {
                javaType = fType.getJavaType();
            }

            // check if repeated type
            if (Label.REPEATED == field.getLabel()) {
                javaType = List.class.getName() + "<" + javaType + ">";
            }

            // define field
            code.append("public ").append(javaType);
            code.append(" ").append(field.getName());

            // check if has default
            Option defaultOption = Option.findByName(field.getOptions(), "default");
            if (defaultOption != null) {
                code.append("=");
                Object defaultValue = defaultOption.getValue();
                // if is enum type
                if (defaultValue instanceof EnumType.Value) {
                    EnumType.Value enumValue = (EnumType.Value) defaultValue;
                    code.append(javaType).append(".").append(enumValue.getName());
                } else if (defaultValue instanceof String) {
                    code.append("\"").append(defaultValue).append("\"");
                } else {
                    code.append(String.valueOf(defaultValue));
                }
            }

            code.append(CODE_END);
        }

        // to check if has nested classes
        if (nestedTypes != null && topLevelClass) {
            for (Type t : nestedTypes) {
                CodeDependent nestedCd;
                if (t instanceof EnumType) {
                    nestedCd = createCodeByType(protoFile, (EnumType) t, false);
                    enumNames.add(t.getName());
                } else {
                    nestedCd = createCodeByType(protoFile, (MessageType) t, enumNames, false, checkNestedTypes);
                }

                code.append(nestedCd.code);
                // merge dependency
                cd.dependencies.addAll(nestedCd.dependencies);
            }
        }

        code.append("}\n");

        cd.name = simpleName;
        cd.pkg = packageName;
        cd.code = code.toString();

        // finally dependency should remove self
        cd.dependencies.remove(cd.name);

        return cd;
    }

    /**
     * @param type
     * @return
     */
    private static List<Type> fetchAllNestedTypes(MessageType type) {
        List<Type> ret = new ArrayList<Type>();

        List<Type> nestedTypes = type.getNestedTypes();
        ret.addAll(nestedTypes);
        for (Type t : nestedTypes) {
            if (t instanceof MessageType) {
                List<Type> subNestedTypes = fetchAllNestedTypes((MessageType) t);
                ret.addAll(subNestedTypes);
            }
        }

        return ret;
    }

    /**
     * @param type
     * @param nestedTypes
     * @return
     */
    private static boolean isNestedTypeDependency(String type, List<Type> nestedTypes) {
        if (nestedTypes == null) {
            return false;
        }

        for (Type t : nestedTypes) {
            if (type.equals(t.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * to generate @Protobuf defined code for target field.
     * 
     * @param code
     * @param field
     */
    private static void generateProtobufDefinedForField(StringBuilder code, Field field, Set<String> enumNames) {
        code.append("@").append(Protobuf.class.getSimpleName()).append("(");

        String fieldType = fieldTypeMapping.get(field.getType());
        if (fieldType == null) {
            if (enumNames.contains(field.getType())) {
                fieldType = "FieldType.ENUM";
            } else {
                fieldType = "FieldType.OBJECT";
            }
        }

        code.append("fieldType=").append(fieldType);
        code.append(", order=").append(field.getTag());
        if (Label.OPTIONAL == field.getLabel()) {
            code.append(", required=false");
        } else if (Label.REQUIRED == field.getLabel()) {
            code.append(", required=true");
        }
        code.append(")\n");

    }

    private static Class checkClass(ProtoFile protoFile, Type type) {
        String packageName = protoFile.getPackageName();
        String defaultClsName = type.getName();
        // to check if has "java_package" option and "java_outer_classname"
        List<Option> options = protoFile.getOptions();
        if (options != null) {
            for (Option option : options) {
                if (option.getName().equals(JAVA_PACKAGE_OPTION)) {
                    packageName = option.getValue().toString();
                } else if (option.getName().equals(JAVA_OUTER_CLASSNAME_OPTION)) {
                    defaultClsName = option.getValue().toString();
                }
            }
        }

        String simpleName = defaultClsName + DEFAULT_SUFFIX_CLASSNAME;
        String className = packageName + "." + simpleName;

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
     * google Protobuf IDL message dependency result
     * 
     * 
     * @author xiemalin
     * @since 1.0
     */
    private static class CodeDependent {
        private String name;
        private String pkg;
        private Set<String> dependencies = new HashSet<String>();
        private String code;

        private boolean isDepndency() {
            return !dependencies.isEmpty();
        }

        private void addDependency(String name) {
            dependencies.add(name);
        }
        
        public String getClassName() {
            if (StringUtils.isEmpty(pkg)) {
                return name;
            }
            return pkg + "." + name;
        }
    }
}
