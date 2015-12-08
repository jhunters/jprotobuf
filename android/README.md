jprotobuf-android
=========


jprotobuf-android  
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf-android</artifactId>
  <version>1.1.1</version>
</dependency>
```
[下载发行包](http://repo1.maven.org/maven2/com/baidu/jprotobuf-android/)

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
    
    @Protobuf(fieldType = FieldType.String, order=3, required = false)
    public List<String> stringList;

    @Protobuf(fieldType = FieldType.INT32, order=3, required = false)
    public List<Integer> intList;
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
```
 
###  @Protubuf注解支持枚举类型 ###


```java

public class EnumPOJOClass {

    @Protobuf(fieldType = FieldType.ENUM)
    public EnumAttrPOJO enumAttr;
}


```

使用枚举类型必须注意，如果枚举类型的值不是使用默认的ordinal的方式，则必须实现EnumReadable接口，示例代码如下:


```java

public enum EnumAttrPOJO implements EnumReadable {

    STRING(100), INT(50);
    
    private final int value;


    EnumAttrPOJO(int value) { this.value = value; }

    public int toValue() { return this.value; }

    /* (non-Javadoc)
     * @see com.baidu.bjf.remoting.protobuf.Enumable#value()
     */
    public int value() {
        return toValue();
    }
    
}


```




