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
import java.util.Arrays;
import com.baidu.bjf.remoting.protobuf.utils.*;
import java.lang.reflect.*;

public class RequriedMultiDojoClass$$BJFProtoBufClass_Gen implements
		com.baidu.bjf.remoting.protobuf.Codec<RequriedMultiDojoClass> {
	public byte[] encode(RequriedMultiDojoClass t) throws IOException {
		int size = 0;
		Double f_1 = null;
		if (!CodedConstant.isNull(t.doubleF)) {
			f_1 = t.doubleF;
		}
		if (!CodedConstant.isNull(t.doubleF))
			size += com.google.protobuf.CodedOutputStream.computeDoubleSize(1,
					f_1);
		com.google.protobuf.ByteString f_2 = null;
		if (!CodedConstant.isNull((java.lang.String) FieldUtils.getField(t,
				"stringF"))) {
			f_2 = com.google.protobuf.ByteString
					.copyFromUtf8((java.lang.String) FieldUtils.getField(t,
							"stringF"));
		}
		if (!CodedConstant.isNull((java.lang.String) FieldUtils.getField(t,
				"stringF")))
			size += com.google.protobuf.CodedOutputStream.computeBytesSize(2,
					f_2);
		if (f_2 == null) {
			throw new UninitializedMessageException(Arrays.asList("stringF"));
		}
		Boolean f_3 = null;
		if (!CodedConstant.isNull(t.isSex())) {
			f_3 = t.isSex();
		}
		if (!CodedConstant.isNull(t.isSex()))
			size += com.google.protobuf.CodedOutputStream.computeBoolSize(3,
					f_3);
		if (f_3 == null) {
			throw new UninitializedMessageException(Arrays.asList("sex"));
		}
		final byte[] result = new byte[size];
		final CodedOutputStream output = CodedOutputStream.newInstance(result);
		output.writeDouble(1, f_1);
		output.writeBytes(2, f_2);
		output.writeBool(3, f_3);
		return result;
	}

	public RequriedMultiDojoClass decode(byte[] bb) throws IOException {
		RequriedMultiDojoClass ret = new RequriedMultiDojoClass();
		CodedInputStream input = CodedInputStream.newInstance(bb, 0, bb.length);
		try {
			boolean done = false;
			while (!done) {
				int tag = input.readTag();
				if (tag == 0) {
					break;
				}
				if (tag == CodedConstant
						.makeTag(1, WireFormat.WIRETYPE_FIXED64)) {
					ret.doubleF = input.readDouble();
					continue;
				}
				if (tag == CodedConstant.makeTag(2,
						WireFormat.WIRETYPE_LENGTH_DELIMITED)) {
					FieldUtils.setField(ret, "stringF", input.readString());
					continue;
				}
				if (tag == CodedConstant.makeTag(3, WireFormat.WIRETYPE_VARINT)) {
					FieldUtils.setField(ret, "sex", input.readBool());
					continue;
				}
				input.skipField(tag);
			}
		} catch (com.google.protobuf.InvalidProtocolBufferException e) {
			throw e;
		} catch (java.io.IOException e) {
			throw e;
		}
		if (CodedConstant.isNull((java.lang.String) FieldUtils.getField(ret,
				"stringF"))) {
			throw new UninitializedMessageException(Arrays.asList("stringF"));
		}
		if (CodedConstant.isNull(ret.isSex())) {
			throw new UninitializedMessageException(Arrays.asList("sex"));
		}
		return ret;
	}
}