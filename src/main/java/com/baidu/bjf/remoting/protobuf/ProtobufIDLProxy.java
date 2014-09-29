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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public static IDLProxyObject create(String data) {
        ProtoFile protoFile = ProtoSchemaParser.parse(DEFAULT_FILE_NAME, data);
        return doCreate(protoFile);
    }
    
    public static IDLProxyObject create(InputStream is) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parseUtf8(DEFAULT_FILE_NAME, is);
        return doCreate(protoFile);  
    }
    
    public static IDLProxyObject create(Reader reader) throws IOException {
        ProtoFile protoFile = ProtoSchemaParser.parse(DEFAULT_FILE_NAME, reader);
        return doCreate(protoFile);   
    }
    
    private static IDLProxyObject doCreate(ProtoFile protoFile) {
        
        Class cls = createClass(protoFile);
        
        Object newInstance;
        try {
            newInstance = cls.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
        Codec codec = ProtobufProxy.create(cls);
        IDLProxyObject idlProxyObject = new IDLProxyObject(codec, newInstance);
        return idlProxyObject;
    }

    /**
     * @param protoFile
     * @return
     */
    private static Class createClass(ProtoFile protoFile) {
        
        List<Type> types = protoFile.getTypes();
        if (types == null || types.size() != 1) {
            throw new RuntimeException("Only support one message in .proto file");
        }
        Type type = types.get(0);
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
        
        if (c != null) {
            return c;
        }
        
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
            code.append("fieldType=").append(fieldTypeMapping.get(field.getType()));
            code.append(", order=").append(field.getTag());
            if (Label.OPTIONAL == field.getLabel()) {
                code.append(", required=false");
            } else if (Label.REQUIRED == field.getLabel())  {
                code.append(", required=true");
            }
            code.append(")\n");
            
            // define field
            code.append("public ").append(typeMapping.get(field.getType()).getJavaType());
            code.append(" ").append(field.getName()).append(CODE_END);
        }
        code.append("}\n");
        
        //System.out.println(code);
        Class<?> newClass = JDKCompilerHelper.COMPILER.compile(code.toString(), 
                ProtobufIDLProxy.class.getClassLoader());
        return newClass;
    }
}
