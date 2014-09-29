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
import com.baidu.bjf.remoting.protobuf.utils.JDKCompilerHelper;
import com.squareup.protoparser.MessageType;
import com.squareup.protoparser.MessageType.Field;
import com.squareup.protoparser.MessageType.Label;
import com.squareup.protoparser.Option;
import com.squareup.protoparser.ProtoFile;
import com.squareup.protoparser.ProtoSchemaParser;
import com.squareup.protoparser.Type;

/**
 * This class is for dynamic create protobuf utitily class directly from .proto file
 *
 * @author xiemalin
 * @since 1.0.2
 */
public class ProtobufIDLProxy {
    
    /**
     * code line end wrap
     */
    private static final String CODE_END = ";\n";

    /**
     * default proto file name
     */
    private static final String DEFAULT_FILE_NAME = "jprotobuf_autogenerate";
    
    
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
    }
    
    
    /**
     * auto proxied suffix class name
     */
    private static final String DEFAULT_SUFFIX_CLASSNAME = "JProtoBufProtoClass";
    
    public static IDLProxyObject createSingle(String data) {
        ProtoFile protoFile = ProtoSchemaParser.parse(DEFAULT_FILE_NAME, data);
        
        Map<String, IDLProxyObject> map = doCreate(protoFile, false);
        return map.entrySet().iterator().next().getValue();
    }
    
    public static IDLProxyObject createSingle(InputStream is) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parseUtf8(DEFAULT_FILE_NAME, is);
        
        Map<String, IDLProxyObject> map = doCreate(protoFile, false);
        return map.entrySet().iterator().next().getValue();
    }
    
    public static IDLProxyObject createSingle(Reader reader) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parse(DEFAULT_FILE_NAME, reader);
        
        Map<String, IDLProxyObject> map = doCreate(protoFile, false);
        return map.entrySet().iterator().next().getValue();
    }
    
    
    public static Map<String, IDLProxyObject> create(String data) {
        ProtoFile protoFile = ProtoSchemaParser.parse(DEFAULT_FILE_NAME, data);
        return doCreate(protoFile, true);
    }
    
    public static Map<String, IDLProxyObject> create(InputStream is) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parseUtf8(DEFAULT_FILE_NAME, is);
        return doCreate(protoFile, true);  
    }
    
    public static Map<String, IDLProxyObject> create(Reader reader) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parse(DEFAULT_FILE_NAME, reader);
        return doCreate(protoFile, true);   
    }
    
    private static Map<String, IDLProxyObject> doCreate(ProtoFile protoFile, boolean multi) {
        
        List<Class> list = createClass(protoFile, multi);
        Map<String, IDLProxyObject> ret = new HashMap<String, IDLProxyObject>();
        for (Class cls : list) {
            Object newInstance;
            try {
                newInstance = cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            
            Codec codec = ProtobufProxy.create(cls);
            IDLProxyObject idlProxyObject = new IDLProxyObject(codec, newInstance);
            
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
     * @return
     */
    private static List<Class> createClass(ProtoFile protoFile, boolean multi) {
        
        List<Type> types = protoFile.getTypes();
        if (types == null || types.isEmpty()) {
            throw new RuntimeException("No message defined in '.proto' IDL");
        }
        
        if (!multi && types.size() > 1) {
            throw new RuntimeException("Only one message defined allowed in '.proto' IDL");
        }
        
        
        List<Class> ret = new ArrayList<Class>(types.size());
        List<CodeDependent> cds = new ArrayList<CodeDependent>();
        for (Type type : types) {
            Class checkClass = checkClass(protoFile, type);
            if (checkClass != null) {
                ret.add(checkClass);
                continue;
            }
            
            CodeDependent cd = createCodeByType(protoFile, type);
            if (cd.isDepndency()) {
                cds.add(cd);
            } else {
                cds.add(0, cd);
            }
        }
        
        Set<String> compiledClass = new HashSet<String>(); 
        
        CodeDependent codeDependent;
        
        while ((codeDependent = hasDependency(cds, compiledClass)) != null) {
            Class<?> newClass = JDKCompilerHelper.COMPILER.compile(codeDependent.code, 
                    ProtobufIDLProxy.class.getClassLoader());
            ret.add(newClass);
        }
        
        return ret;
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
        return null;
    }
    
    private static CodeDependent createCodeByType(ProtoFile protoFile, Type type) {
        
        CodeDependent cd = new CodeDependent();
        
        String packageName = protoFile.getPackageName();
        String defaultClsName = type.getName();
        // to check if has "java_package" option and "java_outer_classname"
        List<Option> options = protoFile.getOptions();
        if (options != null) {
            for (Option option : options) {
                if (option.getName().equals("java_package")) {
                    packageName = option.getValue().toString();
                }
            }
        }
        
        String simpleName = defaultClsName + DEFAULT_SUFFIX_CLASSNAME;
        
        // To generate class
        StringBuilder code = new StringBuilder();
        // define pack
        code.append("package ").append(packageName).append(CODE_END);
        code.append("\n");
        // add import;
        code.append("import com.baidu.bjf.remoting.protobuf.FieldType;\n");
        code.append("import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;\n");
        
        // define class
        code.append("public class ").append(simpleName).append(" {\n");
        
        MessageType messageType = (MessageType) type;
        
        List<Field> fields = messageType.getFields();
        
        for (Field field : fields) {
            // define annotation
            code.append("@").append(Protobuf.class.getSimpleName()).append("(");
            
            String fieldType = fieldTypeMapping.get(field.getType());
            if (fieldType == null) {
                fieldType = "FieldType.OBJECT";
            }
            
            code.append("fieldType=").append(fieldType);
            code.append(", order=").append(field.getTag());
            if (Label.OPTIONAL == field.getLabel()) {
                code.append(", required=false");
            } else if (Label.REQUIRED == field.getLabel())  {
                code.append(", required=true");
            }
            code.append(")\n");
            
            FieldType fType = typeMapping.get(field.getType());
            String javaType;
            if (fType == null) {
                javaType = field.getType() + DEFAULT_SUFFIX_CLASSNAME;
                cd.addDependency(javaType);
            } else {
                javaType = fType.getJavaType();
            }
            
            // define field
            code.append("public ").append(javaType);
            code.append(" ").append(field.getName()).append(CODE_END);
        }
        code.append("}\n");
        
        
        cd.name = simpleName;
        cd.code = code.toString();
        
        return cd;
    }
    
    private static Class checkClass(ProtoFile protoFile, Type type) {
        String packageName = protoFile.getPackageName();
        String defaultClsName = type.getName();
        // to check if has "java_package" option and "java_outer_classname"
        List<Option> options = protoFile.getOptions();
        if (options != null) {
            for (Option option : options) {
                if (option.getName().equals("java_package")) {
                    packageName = option.getValue().toString();
                } else if (option.getName().equals("java_outer_classname")) {
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
    
    
    private static class CodeDependent {
        private String name;
        private Set<String> dependencies = new HashSet<String>();
        private String code;
        
        private boolean isDepndency() {
            return !dependencies.isEmpty();
        }
        
        private void addDependency(String name) {
            dependencies.add(name);
        }
    }
}
