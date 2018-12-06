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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.logging.Level;

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
     * @param fields the fields
     * @param cls the cls
     */
    public AbstractCodeGenerator(Class<?> cls) {
        this.cls = cls;
        
        targetProxyClassname = ClassHelper.getInternalName(cls.getCanonicalName());
        
        fields = ProtobufProxyUtils.fetchFieldInfos(cls, true);
    }
    
    
    /**
     * Gets the target proxy classname.
     *
     * @return the target proxy classname
     */
    protected String getTargetProxyClassname() {
        return targetProxyClassname;
    }

    /* (non-Javadoc)
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

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#isDebug()
     */
    @Override
    public boolean isDebug() {
        return debug;
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#setDebug(boolean)
     */
    @Override
    public void setDebug(boolean debug) {
        this.debug = debug;

    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#getClassName()
     */
    @Override
    public String getClassName() {
        return ClassHelper.getClassName(cls);
    }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.code.ICodeGenerator#getPackage()
     */
    @Override
    public String getPackage() {
        return ClassHelper.getPackage(cls);
    }

    /* (non-Javadoc)
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
            if (cls.getSimpleName().equals("int") || Integer.class.getSimpleName().equals(cls.getSimpleName())) {
                return;
            }
            throw new IllegalArgumentException(getMismatchTypeErroMessage(type, field));
        }
        if (!javaType.equalsIgnoreCase(cls.getSimpleName())) {
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
    protected String getAccessByField(String target, Field field, Class<?> cls) {
        if (field.getModifiers() == Modifier.PUBLIC) {
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
