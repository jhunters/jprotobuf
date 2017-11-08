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
import java.util.List;

import com.baidu.bjf.remoting.protobuf.utils.ClassHelper;
import com.baidu.bjf.remoting.protobuf.utils.FieldInfo;
import com.baidu.bjf.remoting.protobuf.utils.StringUtils;

/**
 * Abstract {@link ICodeGenerator} implements.
 *
 * @author xiemalin
 * @since 1.10.7
 */
public abstract class AbstractCodeGenerator implements ICodeGenerator {

    /** The debug. */
    protected boolean debug = false;
    
    /** The output path. */
    protected File outputPath;
    
    /** The fields. */
    protected List<FieldInfo> fields;
    
    /** The cls. */
    protected Class<?> cls;
    
    /**
     * Instantiates a new abstract code generator.
     *
     * @param fields the fields
     * @param cls the cls
     */
    public AbstractCodeGenerator(List<FieldInfo> fields, Class<?> cls) {
        this.fields = fields;
        this.cls = cls;
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


}
