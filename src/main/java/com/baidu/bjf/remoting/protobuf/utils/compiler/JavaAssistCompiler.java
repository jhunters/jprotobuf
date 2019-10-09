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
package com.baidu.bjf.remoting.protobuf.utils.compiler;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.code.ClassCode;
import com.baidu.bjf.remoting.protobuf.code.FieldCode;
import com.baidu.bjf.remoting.protobuf.code.MethodCode;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;
import com.sun.org.apache.bcel.internal.util.ClassPath;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;

/**
 * Compile source by javassist library.
 *
 * @author xiemalin
 */
public class JavaAssistCompiler implements Compiler {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaAssistCompiler.class);

    /** The class code. */
    private ClassCode classCode;
    
    /** The cached bytes. */
    private Map<String, byte[]> cachedBytes = new HashMap<String, byte[]>();

    /**
     * Instantiates a new java assist compiler.
     *
     * @param classCode the class code
     */
    public JavaAssistCompiler(ClassCode classCode) {
        this.classCode = classCode;
    }

    protected Class<?> doCompile() throws Exception {
        ClassPool classPool = new ClassPool(true);

        classCode.getImports().forEach(imports -> {
            classPool.importPackage(StringUtils.removeEnd(imports, ".*"));
        });

        String fullClassName = classCode.getClassName();
        String pkg = classCode.getPkg();
        if (!StringUtils.isEmpty(pkg)) {
            fullClassName = pkg + ClassCode.PACKAGE_SPLIT + fullClassName;
        }

        CtClass ctClass = classPool.makeClass(fullClassName);
        CtClass codecInf = classPool.get(Codec.class.getName());

        ctClass.addInterface(codecInf);

        // 添加默认构造函数
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));

        // process field
        Map<String, FieldCode> fields = classCode.getFields();
        fields.forEach((name, value) -> {
            try {
                CtField field = new CtField(classPool.get(value.getType().getName()), value.getName(), ctClass);
                ctClass.addField(field);
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error(e.getMessage(), e);
            }
        });

        // process method
        List<MethodCode> methods = classCode.getMethods();
        methods.forEach(method -> {
            String methodName = method.getName();
            List<CtClass> params = new ArrayList<>();
            method.getParameters().forEach((key, value) -> {
                try {
                    params.add(classPool.get(key));
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            });

            List<CtClass> exceptions = new ArrayList<>();
            method.getExceptions().forEach(exception -> {
                try {
                    exceptions.add(classPool.get(exception));
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            });

            try {
                String body = method.getBody();
                System.out.println(body);
                String returnType = method.getReturnType();
                
                CtMethod ctMethod = CtNewMethod.make(classPool.get(returnType), methodName,
                        params.toArray(new CtClass[params.size()]), exceptions.toArray(new CtClass[exceptions.size()]),
                        body, ctClass);

                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error(e.getMessage(), e);
            }
        });
        
        Class codecClass = ctClass.toClass();
        
        ctClass.writeFile("d:/abc.class");
        
        byte[] bytecode = ctClass.toBytecode();
        cachedBytes.put(fullClassName, bytecode);
        return codecClass;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.utils.compiler.Compiler#compile(java.lang.String, java.lang.String,
     * java.lang.ClassLoader, java.io.OutputStream, long)
     */
    @Override
    public Class<?> compile(String className, String code, ClassLoader classLoader, OutputStream os, long timestamp) {
        try {
            return doCompile();
        } catch (Throwable e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.utils.compiler.Compiler#loadBytes(java.lang.String)
     */
    @Override
    public byte[] loadBytes(String className) {
        return cachedBytes.get(className);
    }

}
