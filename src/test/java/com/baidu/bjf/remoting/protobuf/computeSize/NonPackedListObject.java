package com.baidu.bjf.remoting.protobuf.computeSize;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Packed;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.util.List;

/***
 *
 * 2021/11/8 10:16
 */
public class NonPackedListObject {
	@Packed(value = false)
	@Protobuf(description = "object id list", fieldType = FieldType.SFIXED64)
	private List<Long> objectIds;

	public static NonPackedListObject valueOf(List<Long> objectIds){
		NonPackedListObject data = new NonPackedListObject();
		data.objectIds = objectIds;
		return data;
	}

	public List<Long> getObjectIds() {
		return objectIds;
	}

	public void setObjectIds(List<Long> objectIds) {
		this.objectIds = objectIds;
	}
}
