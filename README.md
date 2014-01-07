jprotobuf
=========

A very useful utility library for java programmer using google protobuf<br>
jprotobuf是针对Java程序开发一套简易类库，目的是简化java语言对protobuf类库的使用<br>
使用jprotobuf可以无需再去了解.proto文件操作与语法，直接使用java注解定义字段类型即可。

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
## 联系我们 ##

email: [rigelarch_sh@baidu.com](mailto://email:rigelarch_sh@baidu.com "发邮件给jprotobuf开发组")


