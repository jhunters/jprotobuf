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

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Proxy tools for protobuf.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public final class ProtobufProxy {
	
	private static final Map<Class<?>, Codec<?>> CACHED_CODECS = new WeakHashMap<Class<?>, Codec<?>>();
	
    /**
     * To create a protobuf proxy class for target class.
     * 
     * @param 
     * @param cls
     * @return
     */
    public static <T> Codec<T> create(Class<T> cls) {
        return create(cls, false);
    }

    private static <T> Codec<T> create(Class<T> cls, boolean debug) {
    	if (CACHED_CODECS.containsKey(cls)) {
    		return (Codec<T>) CACHED_CODECS.get(cls);
    	}
    	
    	ReflectiveCodec<T> codec = new ReflectiveCodec(cls);
    	CACHED_CODECS.put(cls, codec);
        return codec;
    	
    }


}
