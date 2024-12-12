package com.baidu.bjf.remoting.protobuf.computeSize;

import autovalue.shaded.com.google.common.collect.Lists;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/***
 * size object test
 *
 * @author qiunet
 * 2022/6/16 16:16
 */
public class TestComputeSize {
    /**
     * test packed long list object
     * @throws IOException
     */
    @Test
    public void testPackedList() throws IOException {
        Codec<PackedListObject> codec = ProtobufProxy.create(PackedListObject.class);
        PackedListObject packedListObject = PackedListObject.valueOf(Lists.newArrayList(10L));

        Assert.assertEquals(10, codec.size(packedListObject));
    }

    /**
     * test non packed long list object
     * @throws IOException
     */
    @Test
    public void testNonPackedList() throws IOException {
        Codec<NonPackedListObject> codec = ProtobufProxy.create(NonPackedListObject.class);
        NonPackedListObject nonPackedListObject = NonPackedListObject.valueOf(Lists.newArrayList(10L));

        Assert.assertEquals(9, codec.size(nonPackedListObject));
    }
}
