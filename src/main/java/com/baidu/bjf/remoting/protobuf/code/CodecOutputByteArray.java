package com.baidu.bjf.remoting.protobuf.code;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.google.protobuf.CodedOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Stack;

/***
 * Get byte array from codec and object.
 * Avoid create a lot of CodedOutputStream object.
 *
 * Borrow obj from this thread and recycle in this thread too.
 * It not a real object pool. Just thread scope cache.
 *
 * @author qiunet
 * 2022/8/12 14:23
 */
public class CodecOutputByteArray {
    private static final ThreadLocal<Stack<CodecOutputByteArray>> instanceGetter = ThreadLocal.withInitial(Stack::new);
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final CodedOutputStream stream = CodedOutputStream.newInstance(byteArrayOutputStream, 0);
    /**
     * max retain object count
     */
    private static final int MAX_ELEMENT = 10;

    private CodecOutputByteArray() {}
    /**
     * get CodecOutputByteArrayGetter from ThreadLocal
     * @return CodecOutputByteArrayGetter instance
     */
    public static CodecOutputByteArray get() {
        Stack<CodecOutputByteArray> stack = instanceGetter.get();
        if (stack.size() > 0) {
            return stack.pop();
        }
        return new CodecOutputByteArray();
    }

    /**
     * get thread scope size
     * @return
     */
    public static int threadScopeSize() {
        return instanceGetter.get().size();
    }

    /**
     * clear stack
     */
    public static void clear() {
        instanceGetter.get().clear();
    }
    /**
     * get CodedOutputStream instance
     * @return
     */
    public CodedOutputStream getCodedOutputStream() {
        return stream;
    }

    /**
     * get byte array data
     * @return byte array
     * @throws IOException
     */
    public byte[] getData() throws IOException {
        this.stream.flush();
        byte[] bytes = this.byteArrayOutputStream.toByteArray();
        this.recycle();
        return bytes;
    }
    /**
     * get byte array from codec and object
     * @param codec codec
     * @param obj obj
     * @return byte array
     * @param <T>
     * @throws IOException
     */
    public static <T> byte[] getData(Codec<T> codec, T obj) throws IOException {
        CodecOutputByteArray data = get();
        codec.writeTo(obj, data.stream);
        return data.getData();
    }
    /**
     * recycle instance.
     */
    private void recycle(){
        this.byteArrayOutputStream.reset();
        Stack<CodecOutputByteArray> stack = instanceGetter.get();
        if (stack.size() >= MAX_ELEMENT) {
            // drop object
            return;
        }
        stack.push(this);
    }
}
