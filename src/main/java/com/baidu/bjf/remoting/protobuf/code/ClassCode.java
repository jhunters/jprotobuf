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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baidu.bjf.remoting.protobuf.utils.StringUtils;

/**
 * Java class code creator.
 *
 * @author xiemalin
 * @since 1.10.3
 */
public class ClassCode {

    /** line break for editor. */
    public static final String LINE_BREAK = "\n";

    /** java line end. */
    public static final String JAVA_END = ";";

    /** line break for JAVA. */
    public static final String JAVA_LINE_BREAK = JAVA_END + LINE_BREAK;
    
    /** The Constant PACKAGE_SPLIT. */
    public static final String PACKAGE_SPLIT = ".";
    
    /** The Constant SENTENCE_COMMA. */
    public static final String SENTENCE_COMMA = ",";

    /** BLANK_STRING. */
    public static final String BLANK_STRING = " ";

    /** The Constant KEY_CLASS. */
    public static final String KEY_CLASS = "class";
    
    /** The Constant SCOPE_PUBLIC. */
    public static final String SCOPE_PUBLIC = "public";
    
    /** The Constant SCOPE_PROTECTED. */
    public static final String SCOPE_PROTECTED = "protected";
    
    /** The Constant SCOPE_DEFAULT. */
    public static final String SCOPE_DEFAULT = "private";
    
    /** The Constant CODE_FORMAT. */
    public static final String CODE_FORMAT = "    ";
    
    /** import classes. */
    private Set<String> imports = new HashSet<String>();
    
    /** The pkg. */
    private String pkg;
    
    /** The class name. */
    private String className;
    
    /** The interfaces. */
    private Set<String> interfaces = new HashSet<String>();
    
    /** The extend classes. */
    private Set<String> extendClasses = new HashSet<String>();
    

    /** The fields. */
    private Map<String, FieldCode> fields = new HashMap<String, FieldCode>();
    
    /** The methods. */
    private List<MethodCode> methods = new ArrayList<MethodCode>();

    /** The scope. */
    private String scope;



    /**
     * Adds the field.
     *
     * @param scope the scope
     * @param type the type
     * @param name the name
     * @param defaultValue the default value
     */
    public void addField(String scope, String type, String name, String defaultValue) {
        fields.put(name, new FieldCode(scope, name, type, defaultValue));
    }

    /**
     * Instantiates a new class code.
     *
     * @param scope the scope
     * @param name the name
     * @param interfaces the interfaces
     * @param extendClasses the extend classes
     */
    public ClassCode(String scope, String name, Set<String> interfaces, Set<String> extendClasses) {
        this(scope, name);
        interfaces = extendClasses;
        extendClasses = interfaces;
    }
    
    /**
     * Instantiates a new class code.
     *
     * @param scope the scope
     * @param name the name
     */
    public ClassCode(String scope, String name) {
        this.scope = scope;
        this.className = name;
    }
    
    /**
     * To code.
     *
     * @return the string
     */
    public String toCode() {
        StringBuilder code = new StringBuilder();
        // package
        if (!StringUtils.isEmpty(pkg)) {
            code.append("package ").append(pkg).append(JAVA_LINE_BREAK);
        }
               
        // import
        for (String importClass : imports) {
            code.append("import ").append(importClass).append(JAVA_LINE_BREAK);
        }
        
        // define class
        code.append(scope).append(" class ").append(className);
        if (!interfaces.isEmpty()) {
            code.append(" implements ");
            Iterator<String> iter = interfaces.iterator();
            while (iter.hasNext()) {
                code.append(iter.next());
                if (iter.hasNext()) {
                    code.append(SENTENCE_COMMA);
                }
            }
        }
        
        if (!extendClasses.isEmpty()) {
            code.append(" extends ");
            Iterator<String> iter = extendClasses.iterator();
            while (iter.hasNext()) {
                code.append(iter.next());
                if (iter.hasNext()) {
                    code.append(SENTENCE_COMMA);
                }
            }
        }
        // begin class
        code.append("{").append(LINE_BREAK);
        
        // generate fields
        for (FieldCode field : fields.values()) {
            code.append(CODE_FORMAT).append(field.toCode()).append(JAVA_LINE_BREAK);
        }
        
        // generate methods
        for (MethodCode mc : methods) {
            code.append(CODE_FORMAT).append(mc.toCode()).append(LINE_BREAK);
        }
        
        // end class
        code.append("}");
        
        return code.toString();
    }
    

    /**
     * Import java class.
     *
     * @param importClass imported java class
     * @return {@link ClassCode} instance
     */
    public void importClass(String importClass) {
        if (StringUtils.isEmpty(importClass)) {
            return;
        }
        imports.add(importClass);
        
    }

    /**
     * Add a method to java source code.
     *
     * @param mc method code
     * @return {@link ClassCode} instance
     */
    public ClassCode addMethod(MethodCode mc) {
        if (mc != null) {
            methods.add(mc);
        }
        return this;
    }
    
    /**
     * Sets the pkg.
     *
     * @param pkg the new pkg
     */
    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    /**
     * Sets the class name.
     *
     * @param className the new class name
     */
    public void setClassName(String className) {
        this.className = className;
    }
    
    /**
     * Adds the inteface.
     *
     * @param intf the intf
     */
    public void addInteface(String intf) {
        interfaces.add(intf);
    }
    
    /**
     * Adds the extend class.
     *
     * @param cls the cls
     */
    public void addExtendClass(String cls) {
        extendClasses.add(cls);
    }
    
}
