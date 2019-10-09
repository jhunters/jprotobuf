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
package com.baidu.bjf.remoting.protobuf.bytestest;

import java.io.IOException;
import java.util.Arrays;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.code.ClassCode;
import com.baidu.bjf.remoting.protobuf.code.CodeGenerator;
import com.baidu.bjf.remoting.protobuf.utils.compiler.JavaAssistCompiler;

/**
 * Test single private byte array field.
 *
 * @author xiemalin
 * @since 1.0.9
 */
public class ByteTypeClass4 {

    /** The bytes. */
    @Protobuf(fieldType = FieldType.BYTES)
    private byte[] bytes;

    /** The bytes2. */
    private Byte[] bytes2;

    /**
     * Gets the bytes2.
     *
     * @return the bytes2
     */
    public Byte[] getBytes2() {
        return bytes2;
    }

    /**
     * Sets the bytes2.
     *
     * @param bytes2 the new bytes2
     */
    public void setBytes2(Byte[] bytes2) {
        this.bytes2 = bytes2;
    }

    /** The bytes3. */
    public Byte[] bytes3;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        CodeGenerator cg = new CodeGenerator(ByteTypeClass4.class);
        ClassCode classCode = cg.getClassCode();

        JavaAssistCompiler compiler = new JavaAssistCompiler(classCode);
        Class<?> cls = compiler.compile(null, null, null, null, 0L);
        System.out.println(cls);

        Object newInstance = cls.newInstance();
        Codec<ByteTypeClass4> codec = (Codec<ByteTypeClass4>) newInstance;

        ByteTypeClass4 btc = new ByteTypeClass4();
        btc.bytes = new byte[] { 1, 2, 3 };

        try {
            byte[] encode = codec.encode(btc);
            System.out.println(Arrays.toString(encode));
            ByteTypeClass4 decode = codec.decode(encode);
            System.out.println(decode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ByteTypeClass4 [bytes=" + Arrays.toString(bytes) + ", bytes2=" + Arrays.toString(bytes2) + ", bytes3="
                + Arrays.toString(bytes3) + "]";
    }
}
