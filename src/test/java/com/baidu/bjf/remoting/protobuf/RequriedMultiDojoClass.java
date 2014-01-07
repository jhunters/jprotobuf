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

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

/**
 * @author xiemalin
 *
 */
public class RequriedMultiDojoClass {

	@Protobuf(fieldType = FieldType.DOUBLE, order=1, required=false)
	public double doubleF;
	
	@Protobuf(fieldType = FieldType.STRING, order=2, required=true)
	private String stringF;
	@Protobuf(fieldType=FieldType.BOOL, order=3, required=true)
	private boolean sex;
	public boolean isSex() {
		return sex;
	}
	public void setStringF(String stringF) {
		this.stringF = stringF;
	}
	protected String getStringF() {
		return stringF;
	}
	protected void setSex(boolean sex) {
		this.sex = sex;
	}
	
	
}
