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
import java.lang.reflect.Field;

/**
 * IDL parsed proxy object
 *
 * @author xiemalin
 * @since 1.0.2
 */
public class IDLProxyObject {

    private Codec codec;
    
    private Object target;
    
    private Class<?> cls;

    /**
     * default construtor to set {@link Codec} target
     */
    protected IDLProxyObject(Codec codec, Object target, Class<?> cls) {
        super();
        if (codec == null) {
            throw new IllegalArgumentException("param 'codec' is null.");
        }
        if (target == null) {
            throw new IllegalArgumentException("param 'target' is null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("param 'cls' is null.");
        }
        this.codec = codec;
        this.target = target;
        this.cls = cls;
    }
    
    public IDLProxyObject newInstnace() {
        try {
            Object object = cls.newInstance();
            return new IDLProxyObject(codec, object, cls);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    private IDLProxyObject put(String field, Object value, Object object) {
        int index = field.indexOf('.');
        if (index != -1) {
            String parent = field.substring(0, index);
            String sub = field.substring(index + 1);
            
            try {
                Field f = object.getClass().getField(parent);
                Class<?> type = f.getType();
                f.setAccessible(true);
                Object o = f.get(object);
                if (o == null) {
                    o = type.newInstance();
                    f.set(object, o);
                }
                return put(sub, value, o);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        
        try {
            Field f = object.getClass().getField(field);
            f.setAccessible(true);
            f.set(object, value);
        } catch (SecurityException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
        return this;
    }
    
    public IDLProxyObject put(String field, Object value) {
        return put(field, value, target);
    }
    
    public Object get(String field) {
        if (target == null) {
            return null;
        }
        
        return get(field, target);
        
    }
    
    /**
     * @param field
     * @param target2
     * @return
     */
    private Object get(String field, Object object) {
        
        int index = field.indexOf('.');
        if (index != -1) {
            String parent = field.substring(0, index);
            String sub = field.substring(index + 1);
            
            try {
                Field f = object.getClass().getField(parent);
                Class<?> type = f.getType();
                f.setAccessible(true);
                Object o = f.get(object);
                if (o == null) {
                    return null;
                }
                return get(sub, o);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        
        try {
            Field f = object.getClass().getField(field);
            f.setAccessible(true);
            return f.get(object);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
    }

    public byte[] encode() throws IOException {
        return codec.encode(target);
    }
    
    public IDLProxyObject decode(byte[] bb) throws IOException {
        if (bb == null) {
            throw new IllegalArgumentException("param 'bb' is null");
        }
        Object object = codec.decode(bb);
        return new IDLProxyObject(codec, object, cls);

    }
    
}
