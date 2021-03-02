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

// Copyright 2003-2010 Christian d'Heureuse, Inventec Informatik AG, Zurich, Switzerland
// www.source-code.biz, www.inventec.ch/chdh
//
// This module is multi-licensed and may be used under the terms
// of any of the following licenses:
//
//  EPL, Eclipse Public License, http://www.eclipse.org/legal
//  LGPL, GNU Lesser General Public License, http://www.gnu.org/licenses/lgpl.html
//
// This module is provided "as is", without warranties of any kind.

package com.baidu.bjf.remoting.protobuf.utils;

import java.io.IOException;
import java.util.HashMap;

/**
 * A cache manager for MiniTemplator objects. This class is used to cache MiniTemplator objects in memory, so that each
 * template file is only read and parsed once.
 *
 * <p>
 * Example of how to use the template cache:<br>
 * 
 * <pre>
 * private static MiniTemplatorCache miniTemplatorCache = new MiniTemplatorCache();
 *
 * public static MiniTemplator getTemplate(String templateFileName, Set<String> flags) throws Exception {
 *     MiniTemplator.TemplateSpecification templateSpec = new MiniTemplator.TemplateSpecification();
 *     templateSpec.templateFileName = templateFileName;
 *     templateSpec.conditionFlags = flags;
 *     return miniTemplatorCache.get(templateSpec);
 * };
 * </pre>
 *
 * <p>
 * Home page: <a href="http://www.source-code.biz/MiniTemplator">www.source-code.biz/MiniTemplator</a><br>
 * Author: Christian d'Heureuse, Inventec Informatik AG, Zurich, Switzerland<br>
 * Multi-licensed: EPL / LGPL.
 */
public class MiniTemplatorCache {

    private HashMap<String, MiniTemplator> cache; // buffered MiniTemplator objects

    /**
     * Creates a new MiniTemplatorCache object.
     */
    public MiniTemplatorCache() {
        cache = new HashMap<String, MiniTemplator>();
    }

    /**
     * Returns a cloned MiniTemplator object from the cache. If there is not yet a MiniTemplator object with the
     * specified <code>templateFileName</code> in the cache, a new MiniTemplator object is created and stored in the
     * cache. Then the cached MiniTemplator object is cloned and the clone object is returned.
     * 
     * @param templateSpec the template specification.
     * @return a cloned and reset MiniTemplator object.
     */
    public synchronized MiniTemplator get(MiniTemplator.TemplateSpecification templateSpec)
            throws IOException, MiniTemplator.TemplateSyntaxException {
        String key = generateCacheKey(templateSpec);
        MiniTemplator mt = cache.get(key);
        if (mt == null) {
            mt = new MiniTemplator(templateSpec);
            cache.put(key, mt);
        }
        return mt.cloneReset();
    }

    private static String generateCacheKey(MiniTemplator.TemplateSpecification templateSpec) {
        StringBuilder key = new StringBuilder(128);
        if (templateSpec.templateText != null)
            key.append(templateSpec.templateText);
        else if (templateSpec.templateFileName != null) {
            key.append(templateSpec.templateFileName);
        } else
            throw new IllegalArgumentException("No templateFileName or templateText specified.");
        if (templateSpec.conditionFlags != null) {
            for (String flag : templateSpec.conditionFlags) {
                key.append('|');
                key.append(flag.toUpperCase());
            }
        }
        return key.toString();
    }

    /**
     * Clears the cache.
     */
    public synchronized void clear() {
        cache.clear();
    }

} // end class MiniTemplatorCache