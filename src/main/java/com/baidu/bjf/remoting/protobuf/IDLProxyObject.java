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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * IDL parsed proxy object
 *
 * @author xiemalin
 * @since 1.0.2
 */
public class IDLProxyObject {

    private Codec codec;
    
    private Object target;

    /**
     * default construtor to set {@link Codec} target
     */
    protected IDLProxyObject(Codec codec, Object target) {
        super();
        if (codec == null) {
            throw new IllegalArgumentException("param 'codec' is null.");
        }
        if (target == null) {
            throw new IllegalArgumentException("param 'target' is null.");
        }
        this.codec = codec;
        this.target = target;
    }
    
    public IDLProxyObject put(String field, Object value) {
        
        try {
            Field f = target.getClass().getField(field);
            f.setAccessible(true);
            f.set(target, value);
        } catch (SecurityException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
        return this;
    }
    
    public byte[] encode() throws IOException {
        return codec.encode(target);
    }
    
    public Map<String, Object> decode(byte[] bb) throws IOException {
        if (bb == null) {
            throw new IllegalArgumentException("param 'bb' is null");
        }
        Object object = codec.decode(bb);
        Field[] fields = object.getClass().getFields();
        if (fields == null) {
            return Collections.emptyMap();
        }
        Map<String, Object> ret = new HashMap<String, Object>();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                ret.put(field.getName(), field.get(object));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e.getMessage(), e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        
        return ret;
    }
    
}
