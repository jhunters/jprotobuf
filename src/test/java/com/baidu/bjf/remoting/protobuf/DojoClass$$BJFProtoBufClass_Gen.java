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

public class DojoClass$$BJFProtoBufClass_Gen implements
		com.baidu.bjf.remoting.protobuf.Codec<SingleDouleDojoClass> {
	public byte[] encode(SingleDouleDojoClass t) throws IOException {
		int size = 0;
		Double f_1 = t.gender;
		size += com.google.protobuf.CodedOutputStream.computeDoubleSize(1, f_1);
		if (f_1 == null) {
			throw new UninitializedMessageException(Arrays.asList("gender"));
		}
		final byte[] result = new byte[size];
		final CodedOutputStream output = CodedOutputStream.newInstance(result);
		output.writeDouble(1, f_1);
		return result;
	}

	public SingleDouleDojoClass decode(byte[] bb) throws IOException {
		SingleDouleDojoClass ret = new SingleDouleDojoClass();
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
					ret.gender = input.readDouble();

					continue;
				}
				input.skipField(tag);
			}
		} catch (com.google.protobuf.InvalidProtocolBufferException e) {
			throw e;
		} catch (java.io.IOException e) {
			throw e;
		}
		if (CodedConstant.isNull(ret.gender)) {
			throw new UninitializedMessageException(Arrays.asList("gender"));
		}
		return ret;
	}
}
