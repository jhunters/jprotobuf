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

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.FieldUtils;
import com.baidu.bjf.remoting.protobuf.utils.ProtobufProxyUtils;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;

/**
 * Abstract {@link ICodeGenerator} implements.
 *
 * @author xiemalin
 * @since 1.10.7
 */
public abstract class AbstractCodeGenerator implements ICodeGenerator {

    /** Logger for this class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCodeGenerator.class.getCanonicalName());

    /** The debug. */
    protected boolean debug = false;

    /** The output path. */
    protected File outputPath;

    /** The cls. */
    protected Class<?> cls;

    /** The target proxy classname. */
    private String targetProxyClassname;

    /** The fields. */
    protected List<FieldInfo> fields;

    /**
     * Instantiates a new abstract code generator.
     *
     * @param cls the cls
     */
    public AbstractCodeGenerator(Class<?> cls) {
        this.cls = cls;

        targetProxyClassname = ClassHelper.getInternalName(cls.getCanonicalName());

        fields = ProtobufProxyUtils.fetchFieldInfos(cls, true);
    }

    /**
     * Gets the all dependencies classes.
     *
     * @param list the list
     * @return the all dependencies classes
     */
    public void getAllDependenciesClasses(Set<Class> list) {
        if (list == null) {
            throw new RuntimeException("param 'list' is null.");
        }

        getAllDependenciesClasses(cls, list);

    }

    /**
     * Gets the all dependencies classes.
     *
     * @param cls the cls
     * @param list the list
     * @return the all dependencies classes
     */
    private void getAllDependenciesClasses(Class cls, Set<Class> list) {
        if (list == null) {
            throw new RuntimeException("param 'list' is null.");
        }

        Set<Class> dependenciesClasses = getDependenciesClasses(cls);
        if (dependenciesClasses.isEmpty()) {
            return;
        }

        for (Class dependencyClass : dependenciesClasses) {
            if (list.contains(dependencyClass)) {
                continue;
            }
            list.add(dependencyClass);

            Set<Class> subDependenciesClasses = getDependenciesClasses(dependencyClass);
            if (subDependenciesClasses.isEmpty()) {
                continue;
            }

            for (Class subClass : subDependenciesClasses) {
                if (list.contains(subClass)) {
                    continue;
                }
                list.add(subClass);
                getAllDependenciesClasses(subClass, list);
            }

        }
    }

    /**
     * Gets the dependencies classes.
     *
     * @param cls the cls
     * @return the dependencies classes
     */
    public Set<Class> getDependenciesClasses(Class cls) {
        List<FieldInfo> fields = null;
        try {
            fields = ProtobufProxyUtils.fetchFieldInfos(cls, true);
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }
        if (fields == null) {
            return Collections.emptySet();
        }

        Set<Class> dependenciesClasses = getDependenciesClasses(fields);
        return dependenciesClasses;
    }

    /**
     * Gets the dependencies classes.
     *
     * @return the dependencies classes
     */
    public Set<Class> getDependenciesClasses() {
        return getDependenciesClasses(fields);
    }

    /**
     * Gets the dependencies classes.
     *
     * @param fields the fields
     * @return the dependencies classes
     */
    public Set<Class> getDependenciesClasses(List<FieldInfo> fields) {
        if (fields == null) {
            return Collections.emptySet();
        }

        Set<Class> ret = new HashSet<Class>();

        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.isObjectType()) {
                if (fieldInfo.isList()) {
                    Class<?> genericKeyType = fieldInfo.getGenericKeyType();
                    if (!FieldInfo.isPrimitiveType(genericKeyType)) {
                        ret.add(genericKeyType);
                    }
                } else {
                    ret.add(fieldInfo.getField().getType());
                }

            } else if (fieldInfo.isMap()) {
                Class<?> genericKeyType = fieldInfo.getGenericKeyType();
                if (!FieldInfo.isPrimitiveType(genericKeyType)) {
                    ret.add(genericKeyType);
                }
                Class<?> genericeValueType = fieldInfo.getGenericeValueType();
                if (!FieldInfo.isPrimitiveType(genericeValueType)) {
                    ret.add(genericeValueType);
                }
            } else if (fieldInfo.isList()) {
                Class<?> genericKeyType = fieldInfo.getGenericKeyType();
                if (!FieldInfo.isPrimitiveType(genericKeyType)) {
                    ret.add(genericKeyType);
                }
            } else if (fieldInfo.getFieldType().isEnum()) {
                ret.add(fieldInfo.getField().getType());
            }
        }

        return ret;
    }

    /**
     * Gets the target proxy classname.
     *
     * @return the target proxy classname
     */
    protected String getTargetProxyClassname() {
        return targetProxyClassname;
    }

    /**
     * Sets the output path.
     *
     * @param outputPath the new output path
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#setOutputPath(java.io.File)
     */
    @Override
    public void setOutputPath(File outputPath) {
        this.outputPath = outputPath;
    }

    /**
     * Gets the output path.
     *
     * @return the output path
     */
    protected File getOutputPath() {
        return outputPath;
    }

    /**
     * Checks if is debug.
     *
     * @return true, if is debug
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#isDebug()
     */
    @Override
    public boolean isDebug() {
        return debug;
    }

    /**
     * Sets the debug.
     *
     * @param debug the new debug
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#setDebug(boolean)
     */
    @Override
    public void setDebug(boolean debug) {
        this.debug = debug;

    }

    /**
     * Gets the class name.
     *
     * @return the class name
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#getClassName()
     */
    @Override
    public String getClassName() {
        return ClassHelper.getClassName(cls);
    }

    /**
     * Gets the package.
     *
     * @return the package
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#getPackage()
     */
    @Override
    public String getPackage() {
        return ClassHelper.getPackage(cls);
    }

    /**
     * Gets the full class name.
     *
     * @return the full class name
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#getFullClassName()
     */
    @Override
    public String getFullClassName() {
        if (StringUtils.isEmpty(getPackage())) {
            return getClassName();
        }

        return getPackage() + ClassHelper.PACKAGE_SEPARATOR + getClassName();
    }

    /**
     * Check {@link FieldType} is validate to class type of {@link Field}.
     *
     * @param type the type
     * @param field the field
     */
    protected void checkType(FieldType type, Field field) {
        Class<?> cls = field.getType();

        if (type == FieldType.OBJECT || type == FieldType.ENUM) {
            return;
        }

        String javaType = type.getJavaType();
        if (Integer.class.getSimpleName().equals(javaType)) {
            if (cls.getSimpleName().equals("int") || cls.getSimpleName().equals("short")
                    || Integer.class.getSimpleName().equals(cls.getSimpleName())) {
                return;
            }
            throw new IllegalArgumentException(getMismatchTypeErroMessage(type, field));
        }
        if (!javaType.equalsIgnoreCase(cls.getSimpleName()) && !javaType.equalsIgnoreCase(cls.getName())) {
            throw new IllegalArgumentException(getMismatchTypeErroMessage(type, field));
        }
    }

    /**
     * get error message info by type not matched.
     *
     * @param type the type
     * @param field the field
     * @return error message for mismatch type
     */
    private String getMismatchTypeErroMessage(FieldType type, Field field) {
        return "Type mismatch. @Protobuf required type '" + type.getJavaType() + "' but field type is '"
                + field.getType().getSimpleName() + "' of field name '" + field.getName() + "' on class "
                + field.getDeclaringClass().getCanonicalName();
    }

    /**
     * get field access code.
     *
     * @param target target instance name
     * @param field java field instance
     * @param cls mapped class
     * @return full field access java code
     */
    protected String getAccessByField(String target, Field field, Class<?> cls, boolean wildcardType) {
        if (field.getModifiers() == Modifier.PUBLIC && !wildcardType) {
            return target + ClassHelper.PACKAGE_SEPARATOR + field.getName();
        }
        // check if has getter method
        String getter;
        if ("boolean".equalsIgnoreCase(field.getType().getCanonicalName())) {
            getter = "is" + CodedConstant.capitalize(field.getName());
        } else {
            getter = "get" + CodedConstant.capitalize(field.getName());
        }
        // check method exist
        try {
            cls.getMethod(getter, new Class<?>[0]);
            return target + ClassHelper.PACKAGE_SEPARATOR + getter + "()";
        } catch (Exception e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(e.getMessage(), e);
            }
        }

        String type = field.getType().getCanonicalName();
        if ("[B".equals(type) || "[Ljava.lang.Byte;".equals(type) || "java.lang.Byte[]".equals(type)) {
            type = "byte[]";
        }

        // use reflection to get value
        String code = "(" + FieldUtils.toObjectType(type) + ") ";
        code += "FieldUtils.getField(" + target + ", \"" + field.getName() + "\")";

        return code;
    }

}
