package com.baidu.bjf.remoting.protobuf.utils;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.baidu.bjf.remoting.protobuf.code.CodecOutputByteArray;

/***
 * test CodecOutputByteArray
 *
 * @author qiunet
 * 2022/8/18 09:23
 */
public class CodecOutputByteArrayTest {

    @Before
    public void clear() {
        CodecOutputByteArray.clear();
    }

    /**
     * test recycle
     *
     * @throws IOException
     */
    @Test
    public void testRecycle() throws IOException {
        CodecOutputByteArray obj1 = CodecOutputByteArray.get();
        CodecOutputByteArray obj2 = CodecOutputByteArray.get();
        obj2.getData();
        obj1.getData();
        CodecOutputByteArray obj3 = CodecOutputByteArray.get();
        CodecOutputByteArray obj4 = CodecOutputByteArray.get();

        Assert.assertSame(obj1, obj3);
        Assert.assertSame(obj2, obj4);
        // recycle
        obj3.getData();
        obj4.getData();

        Assert.assertEquals(CodecOutputByteArray.threadScopeSize(), 2);
    }

    /**
     * test reuse with codec output stream write
     * @throws IOException
     */
    @Test
    public void testReuseWithOutputStreamWrite() throws IOException {
        CodecOutputByteArray obj1 = CodecOutputByteArray.get();
        obj1.getCodedOutputStream().write((byte) 1);
        byte[] data1 = obj1.getData();
        Assert.assertArrayEquals(data1, new byte[]{1});

        CodecOutputByteArray obj2 = CodecOutputByteArray.get();
        Assert.assertSame(obj2, obj1);
        obj2.getCodedOutputStream().write((byte)2);
        byte[] data2 = obj2.getData();
        Assert.assertArrayEquals(data2, new byte[]{2});

        Assert.assertEquals(CodecOutputByteArray.threadScopeSize(), 1);
    }

    /**
     * test reuse with codec
     */
    @Test
    public void testReuseWithCodec() throws IOException {
        Codec<TempObj> codec = ProtobufProxy.create(TempObj.class);
        byte[] data1 = CodecOutputByteArray.getData(codec, new TempObj(1));
        Assert.assertArrayEquals(data1, new byte[]{8, 1});

        byte[] data2 = CodecOutputByteArray.getData(codec, new TempObj(2));
        Assert.assertArrayEquals(data2, new byte[]{8, 2});

        Assert.assertEquals(CodecOutputByteArray.threadScopeSize(), 1);
    }
}
