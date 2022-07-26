package com.baidu.bjf.remoting.protobuf.computeSize;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.util.List;

/***
 *
 * 2021/11/8 10:16
 */
public class PackedListObject {

	@Protobuf(description = "object id list", fieldType = FieldType.SFIXED64)
	private List<Long> objectIds;

	public static PackedListObject valueOf(List<Long> objectIds){
		PackedListObject data = new PackedListObject();
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
