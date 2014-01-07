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

import com.google.protobuf.*;
import java.io.IOException;
import com.baidu.bjf.remoting.protobuf.utils.*;
import java.lang.reflect.*;
import com.baidu.bjf.remoting.protobuf.*;
import java.util.*;

public class RequrieRepeatedDojoClass$$BJFProtoBufClass_Gen
        implements
        com.baidu.bjf.remoting.protobuf.Codec<com.baidu.bjf.remoting.protobuf.RequrieRepeatedDojoClass> {
    public byte[] encode(
            com.baidu.bjf.remoting.protobuf.RequrieRepeatedDojoClass t)
            throws IOException {
        int size = 0;
        List f_1 = null;
        if (!CodedConstant.isNull(t.list)) {
            f_1 = t.list;
        }
        if (!CodedConstant.isNull(t.list)) {
            size += CodedConstant.computeListSize(1, f_1, FieldType.STRING);
        }
        final byte[] result = new byte[size];
        final CodedOutputStream output = CodedOutputStream.newInstance(result);
        if (f_1 != null) {
            CodedConstant.writeToList(output, 1, FieldType.STRING, f_1);
        }
        return result;
    }

    public RequrieRepeatedDojoClass decode(byte[] bb) throws IOException {
        com.baidu.bjf.remoting.protobuf.RequrieRepeatedDojoClass ret = new com.baidu.bjf.remoting.protobuf.RequrieRepeatedDojoClass();
        CodedInputStream input = CodedInputStream.newInstance(bb, 0, bb.length);
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == CodedConstant.makeTag(1,
                        WireFormat.WIRETYPE_LENGTH_DELIMITED)) {
                    if ((ret.list) == null) {
                        ret.list = new ArrayList();
                    }
                    ret.list.add(input.readString());
                    continue;
                }
                input.skipField(tag);
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e;
        } catch (java.io.IOException e) {
            throw e;
        }
        return ret;
    }
}
