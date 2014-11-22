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
package com.baidu.bjf.remoting.protobuf.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.baidu.bjf.remoting.protobuf.FieldType;


/**
 * A mapped annotation for protobuf
 * 
 * @author xiemalin
 * @since 1.0.0
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Protobuf {
    /**
     * <pre>
     * Specifying Field Rules to <code>required</code> or <code>optional</code> 
     * default is false. <code>optional</code>
     * Note: repeated is not supported now.
     * </pre>
     * 
     * @return Specifying Field Rules
     */
    boolean required() default false;

    /**
     * Set field order. It starts at 1;
     * 
     * @return field order.
     */
    int order() default 0;

    /**
     * @return field type
     */
    FieldType fieldType() default FieldType.DEFAULT;
    
    /**
     * @return description to the field
     */
    String description() default "";

}
