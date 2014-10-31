jprotobuf
=========

A very useful utility library for java programmer using google protobuf<br>
jprotobuf是针对Java程序开发一套简易类库，目的是简化java语言对protobuf类库的使用<br>
使用jprotobuf可以无需再去了解.proto文件操作与语法，直接使用java注解定义字段类型即可。

#####1.0.0 支持普通类型，嵌套对象以及对象数组的Protobuf协议的序列化与反序列化实现。#####
#####1.0.1 由注解对象动态生成Protobuf的IDL描述文件内容。#####

#####1.0.3 增加由.proto 描述文件动态生成Protobuf操作对象的支持，详见下面使用说明。#####

#####1.0.7 @Protobuf 支持全部属性默认设置，详见下面使用说明。#####

#####关联项目：#####
JProtobuf-rpc-http 基于JProtobuf的RPC实现，支持直接从IDL定义脚本发布RPC服务<br>
访问地址： [https://github.com/jhunters/JProtobuf-rpc-http](https://github.com/jhunters/JProtobuf-rpc-http)
## 环境要求 ##
JDK 6 或以上版本

## API使用说明 ##

示例：假如需要定义protobuf定义一个数据接口，包含两个属性，一个是string，一个是int32

### 传统protobuf使用过程 ###

a 定义.proto说明文件. test.proto

```property
package pkg;  

option java_package = "com.baidu.bjf.remoting.protobuf";
  
//这里声明输出的java的类名  
option java_outer_classname = "SimpleTypeTest";  
  
message InterClassName {  
  required string name = 1;
  required int32  value = 2; 
}  
  
```

b 使用protoc.exe 编译.proto文件
```cmd
 protoc --java_out=src  test.proto
``` 

c 编译生成的Java文件，利用protobuf API进行序列化与反序化操作<br>
序列化操作：
```java
InterClassName icn = InterClassName.newBuilder().setName("abc")
		.setValue(100).build();
		
		byte[] bb = icn.toByteArray();
``` 

反序化操作<br>
```java
byte[] bb = ...;
InterClassName icn = InterClassName.parseFrom(bb);
``` 


### 使用jprotobuf API 简化开发 ###
a 使用注解直接使用pojo对象

```java
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;


/**
 * A simple jprotobuf pojo class just for demo.
 * 
 * @author xiemalin
 * @since 1.0.0
 */
public class SimpleTypeTest {

    @Protobuf(fieldType = FieldType.STRING, order = 1, required = true)
    private String name;
    
    @Protobuf(fieldType = FieldType.INT32, order = 2, required = false)
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
``` 

b 使用jprotobuf API进行序列化与反序列化操作
```java
        Codec<SimpleTypeTest> simpleTypeCodec = ProtobufProxy
                .create(SimpleTypeTest.class);

        SimpleTypeTest stt = new SimpleTypeTest();
        stt.name = "abc";
        stt.setValue(100);
        try {
            // 序列化
            byte[] bb = simpleTypeCodec.encode(stt);
            // 反序列化
            SimpleTypeTest newStt = simpleTypeCodec.decode(bb);
        } catch (IOException e) {
            e.printStackTrace();
        }

``` 



### 嵌套对象的开发示例 ###
```java
public class AddressBookProtosPOJO {

    @Protobuf(fieldType = FieldType.OBJECT, order=1, required = false)
    public Person person;

    @Protobuf(fieldType = FieldType.OBJECT, order=2, required = false)
    public List<Person> person;
}

public class Person {

    @Protobuf(fieldType = FieldType.STRING, order=1, required = true)
    public String name;
    @Protobuf(fieldType = FieldType.INT32, order=2, required = true)
    public int id;
    @Protobuf(fieldType = FieldType.STRING, order=3, required = false)
    public String email;
    
    @Protobuf(fieldType = FieldType.DOUBLE, order=4, required = false)
    public Double doubleF;
    
    
    @Protobuf(fieldType = FieldType.FLOAT, order=5, required = false)
    public Float floatF;
    
    @Protobuf(fieldType = FieldType.BYTES, order=6, required = false)
    public byte[] bytesF;
    
    @Protobuf(fieldType=FieldType.BOOL, order=7, required=false)
    public Boolean boolF;    
}


``` 

### 由注解对象动态生成Protobuf的IDL描述文件内容 ###
JProtobuf提供一个非常实用的功能，可以动态生成Protobuf的IDL描述文件内容

```java

//返回的内容即为 Protobuf的IDL描述文件
String code = ProtobufIDLGenerator.getIDL(SimpleTypeTest.class);

public class SimpleTypeTest {

    @Protobuf(fieldType = FieldType.STRING, order = 1, required = true)
    private String name;
    
    @Protobuf(fieldType = FieldType.INT32, order = 2, required = false)
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}


``` 



###  增加由.proto 描述文件动态生成Protobuf操作对象的支持 ###
JProtobuf提供一个更简单的功能，可支持动态Protobuf对象的生成功能，省去了注释的使用
基本使用示例如下：

```java

@Test
public void testDecode() throws Exception {
    // 通过 .proto描述文件生成动态解析对象
    String protoCotent = "package mypackage.test; " +
            "option java_package = \"com.baidu.bjf.remoting.protobuf.simplestring\";" +
            "option java_outer_classname = \"StringTypeClass\";  " +
            "message StringMessage { " +
            "  required string message = 1; }" ;
    
    IDLProxyObject object = ProtobufIDLProxy.createSingle(protoCotent);
    //if .proto IDL defines multiple messages use as follow
	//Map<String, IDLProxyObject> objects = ProtobufIDLProxy.create(protoCotent);
    // 动态设置字段值
    object.put("message", "hello你好");
	//propogation object set
	//object.put("sub.field", "hello world");
    // protobuf 序列化
    byte[] bb = object.encode();
    
    // protobuf 反序列化
    IDLProxyObject result = object.decode(bb);
    Assert.assertEquals("hello你好", result.get("message"));
	//propogation object get
	//result.get("sub.field")
}


``` 


###  @Protubuf注解支持全部属性默认设置 ###
该功能可以更方便的设置对象属性的类型定义

```java

public class AddressBookProtosPOJOWithDefault {

    @Protobuf
    public PersonPOJOWithDefault list;

    @Protobuf
    public String name;
}

```
上面的代码等同于如下设置
```java

public class AddressBookProtosPOJOWithDefault {

    @Protobuf(fieldType = FieldType.OBJECT, order=1, required = false)
    public PersonPOJO list;

    @Protobuf(fieldType = FieldType.STRING, order=2, required = false)
    public String name;
}

 

更多使用示例请参见testcase代码。


## 联系我们 ##

email: [rigel-opensource@baidu.com](mailto://rigel-opensource@baidu.com "发邮件给jprotobuf开发组")


