
jprotobuf
=========

## Build status

[![Build Status](https://travis-ci.org/jhunters/jprotobuf.svg?branch=master)](https://travis-ci.org/jhunters/jprotobuf)
[![Coverage Status](https://coveralls.io/repos/github/jhunters/jprotobuf/badge.svg?branch=master)](https://coveralls.io/github/jhunters/jprotobuf?branch=master)

#####What is jprotobuf#####

A very useful utility library for java programmer using google protobuf<br>
jprotobuf是针对Java程序开发一套简易类库，目的是简化java语言对protobuf类库的使用<br>
使用jprotobuf可以无需再去了解proto文件操作与语法，直接使用java注解定义字段类型即可。


#####How it works#####
jprotobuf工作原理如下：<br>
1. 扫描类上的注解的信息，进行分析(与protobuf读取proto文件进行分析过程相似)<br>
2. 根据注解分析的结果，动态生成java代码进行protobuf序列化与反序列化的功能实现<br>
3. 使用JDK6及以上的 code compile API进行编译后加载到classloader


#####Performace#####
jprotobuf 主要性能消耗在 扫描类上注解，动态生成代码编译的过程。<br>
在执行序列化与反序列化的过程中，几乎与protobuf生成的代码效率等同。

#####Features#####
1. 无需编写proto文件及繁琐的手工编译过程，支持基于POJO对象的注解方式，方便快捷。<br>
   支持protobuf所有类型，包括对象嵌套，数组，枚举类型<br>
2. 提供根据proto文件，动态生成代理对象，可省去POJO对象的编写工作。<br>
   完整支持proto文件所有功能，包括内联对象，匿名对象，枚举类型<br>
3. 提供从POJO对象的注解方式自动生成proto文件的功能， 方便proto描述文件的管理与维护<br>

#####Which version#####
1. jprotobuf-1.x supports google protocol buffer v2.5.x<br>
2. jprotobuf-2.x supports google protocol buffer v3.0.0. 实现对MAP结构的支持. [文档](https://github.com/jhunters/jprotobuf/tree/master/v3)<br>
3. jprotobuf-android Android development supports

#####关联项目：#####
JProtobuf-rpc-socket 基于socket的高性能RPC实现<br>
访问地址： [https://github.com/jhunters/Jprotobuf-rpc-socket](https://github.com/Baidu-ecom/Jprotobuf-rpc-socket)<br>
JProtobuf-rpc-http 基于JProtobuf的RPC实现，支持直接从IDL定义脚本发布RPC服务<br>
访问地址： [https://github.com/jhunters/JProtobuf-rpc-http](https://github.com/jhunters/JProtobuf-rpc-http)

## 环境要求 ##
jprotobuf-1.x  JDK 6 或以上版本

```xml 
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf</artifactId>
  <version>1.11.4</version>
</dependency>
```
[下载发行包](http://repo1.maven.org/maven2/com/baidu/jprotobuf/)


jprotobuf-2.x  JDK 7 或以上版本
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf</artifactId>
  <version>2.2.5</version> 
</dependency> 
```
[下载发行包](https://oss.sonatype.org/content/repositories/snapshots/com/baidu/jprotobuf/2.0.1-SNAPSHOT/)

jprotobuf-android  
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf-android</artifactId>
  <version>1.1.2</version>
</dependency>
```
[下载发行包](http://repo1.maven.org/maven2/com/baidu/jprotobuf-android/)

jprotobuf-precompile-plugin 支持maven编译时同时进行jprotobuf对象的预编译操作. 注：plugin版本建议使用>=1.2.0， jprotobuf 支持版本>=1.9.4  
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf-precompile-plugin</artifactId>
  <version>1.2.8</version>
</dependency>

// 2.x支持版本
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf-precompile-plugin</artifactId>
  <version>2.0.4</version>
</dependency>
```
[下载发行包](http://repo1.maven.org/maven2/com/baidu/jprotobuf-precompile-plugin/)

#####quick start：#####
Compiling .proto files
```property
java -jar  jprotobuf-jar-with-dependencies.jar  --java_out=.  test.proto

create success. output path=D:\jprotobuf_local\source\.

--java_out 指定的生成java源代码目录
```

生成的代码示例如下：
```java
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
public class PersonJProtoBufProtoClass {
	@Protobuf(fieldType=FieldType.STRING, order=1, required=false)
	public String name;
	@Protobuf(fieldType=FieldType.INT32, order=2, required=false)
	public Integer id;
	@Protobuf(fieldType=FieldType.STRING, order=3, required=false)
	public String email;
	@Protobuf(fieldType=FieldType.DOUBLE, order=4, required=false)
	public Double doubleF;
	@Protobuf(fieldType=FieldType.FLOAT, order=5, required=false)
	public Float floatF;
	@Protobuf(fieldType=FieldType.BYTES, order=6, required=false)
	public byte[] bytesF;
	@Protobuf(fieldType=FieldType.BOOL, order=7, required=false)
	public Boolean boolF;
}
```

从版本  1.12.0 and 2.2.0 开始支持 @ProtobufClass注解，支持默认字段识别能力. 下面的方式等 同于上面的配置

注：@ProtobufClass与@Protobuf 可以混合使用

```java
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
@ProtobufClass
public class PersonJProtoBufProtoClass {
	public String name;
	public Integer id;
	public String email;
	public Double doubleF;
	public Float floatF;
	public byte[] bytesF;
	public Boolean boolF;
}
```


Maven插件支持预编译功能配置，使用该功能后，所有的Jprotobuf注解标识的对象都会进行预编译操作，并生成相应的class文件到目标jar或war中， 使用示例如下：
```xml
	<plugin>
		<groupId>com.baidu</groupId>
		<artifactId>jprotobuf-precompile-plugin</artifactId>
		<version>1.2.1</version>
		<configuration>
			<skipErrorNoDescriptorsFound>true</skipErrorNoDescriptorsFound>
			<filterClassPackage>com.baidu</filterClassPackage>
		</configuration>
		<executions>
			<execution>
				<phase>compile</phase>
				<goals>
					<goal>precompile</goal>
				</goals>
			</execution>
		</executions>
	</plugin>
```
filterClassPackage 用来指定进行预编译时需要扫描的package,目前只支持配置一个package名称<br>
maven执行命令如下:<br>
```property
mvn jprotobuf:precompile
or
mvn package 
```

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
    public PersonPOJO list;

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

###   ProtobufProxy增加生成中间编译java字节码文件功能 ###

使用示例：

```java
ProtobufProxy.create(AddressBookProtosPOJO.class, false, new File("D:/"));

ProtobufIDLProxy.create(string, false， new File("D:/"));

```
上面的示例，则会直接把生成的中间子节码文件生成到D盘根目录下。

注：目前ProtobufIDLProxy已经能完全支持含有内部类或内部枚举类型的message的动态解析。




###   ProtobufIDLProxy增加从proto文件到jprotobuf POJO源代码生成功能 ###
使用示例：

```java
InputStream fis = EnumIDLGeneratorTest.class.getResourceAsStream("si_product_biz.proto");
ProtobufIDLProxy.generateSource(fis, new File("D:\\test"));

```
上面的示例，则会直接把生成的源码文件生成到D盘test目录下。


###   开放 Compiler接口与ICodeGenerator接口，方便外部实现 代码生成与代码编译能力  ###
使用示例：

```java
ICodeGenerator codeGenerator = new ...;
Compiler compiler = new ...;
ProtobufProxy.create(clazz, compiler, codeGenerator);

```
上面的示例，会开放Compiler与ICodeGenerator实现自定能力

更多使用示例请参见testcase代码。

### 沟通群号：QQ: 644867264 ### 

