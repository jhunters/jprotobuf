
jprotobuf
=========


## quick start：
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

从版本  1.11.6 and 2.2.0 开始支持 @ProtobufClass注解，支持默认字段识别能力. 下面的方式等 同于上面的配置
从版本  1.11.7 and 2.2.8 开始支持@EnableZigZap 注解，针对 未指定类型情况下，针对int和long 使用 sint32和sint64类型

注：@ProtobufClass与@Protobuf 可以混合使用

```java
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
@ProtobufClass
@EnableZigZap
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

## 预编译插件：
#### maven插件
Maven插件支持预编译功能配置，使用该功能后，所有的Jprotobuf注解标识的对象都会进行预编译操作，并生成相应的class文件到目标jar或war中， 使用示例如下：
1.2.15和2.0.11版本之后增加 generateProtoFile属性，设置true可开启proto文件生成.
1.3.1和2.1.2版本之后，增加了 compileDependencies属性，默认为true, 可以针对依赖的类进行编译，即使依赖类不在filterClassPackage的范围内.
```xml
	<plugin>
		<groupId>com.baidu</groupId>
		<artifactId>jprotobuf-precompile-plugin</artifactId>
		<version>1.3.4</version>
		<configuration>
			<skipErrorNoDescriptorsFound>true</skipErrorNoDescriptorsFound>
			<filterClassPackage>com.baidu</filterClassPackage>
			<generateProtoFile>true</generateProtoFile>
			<compileDependencies>true</compileDependencies>
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
filterClassPackage 用来指定进行预编译时需要扫描的package,目前只支持配置多个package名称，使用";"分隔<br>
                   1.3.4与2.2.4版本以后，支持通配符方式，如包名定义 com.baidu.student.pk1*<br>
generateProtoFile 设置是否开启proto文件生成，默认为false，不生成<br>
compileDependencies 开启依赖的class编译，默认为true, 开启<br>
maven执行命令如下:<br>
```property
mvn jprotobuf:precompile
or
mvn package
```

#### gradle插件
在build.gradle文件，设置内容如下：

gradle 5.6.x

```property

plugins {
    id 'com.baidu.jprotobuf' version '1.1.1'
}
```

gradle 7.5.x

```property

plugins {
    id 'com.baidu.jprotobuf' version '1.2.1'
}
```

或者使用以下方式

```property
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.baidu.jprotobuf:jprotobuf-precompile-plugin-gradle:1.0.9"
  }
}

apply plugin: "com.baidu.jprotobuf"

```

参数设置

```property
jprotobuf_precompile {
    filterClassPackage="com.mytest.pkg"  // 设置要预编译的包前缀，多个用 ";"分隔
    generateProtoFile="false" // 设置是否怎么生成proto描述文件, 默认是false, 不生成
}
```
####备注 1.0.9版本之后，gradle插件, filterClassPackage支持通配符匹配规则，例如 filterClassPackage="com.mytest.pkg*"


gradle 执行命令如下:<br>
```property
gradle compileJava jprotobuf_precompile build
```

## API使用说明

示例：假如需要定义protobuf定义一个数据接口，包含两个属性，一个是string，一个是int32

#### 传统protobuf使用过程 ###

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


#### 使用jprotobuf API 简化开发 ###
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



#### 嵌套对象的开发示例 ###
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

#### 由注解对象动态生成Protobuf的IDL描述文件内容 ###
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


####  增加由.proto 描述文件动态生成Protobuf操作对象的支持 ###
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


####  @Protubuf注解支持全部属性默认设置 ###
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

####  @Protubuf注解支持枚举类型 ###


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

####   ProtobufProxy增加生成中间编译java字节码文件功能 ###

使用示例：

```java
ProtobufProxy.create(AddressBookProtosPOJO.class, false, new File("D:/"));

ProtobufIDLProxy.create(string, false， new File("D:/"));

```
上面的示例，则会直接把生成的中间子节码文件生成到D盘根目录下。

注：目前ProtobufIDLProxy已经能完全支持含有内部类或内部枚举类型的message的动态解析。




####   ProtobufIDLProxy增加从proto文件到jprotobuf POJO源代码生成功能 ###
使用示例：

```java
InputStream fis = EnumIDLGeneratorTest.class.getResourceAsStream("si_product_biz.proto");
ProtobufIDLProxy.generateSource(fis, new File("D:\\test"));

```
上面的示例，则会直接把生成的源码文件生成到D盘test目录下。


####   开放 Compiler接口与ICodeGenerator接口，方便外部实现 代码生成与代码编译能力  ###
使用示例：

```java
ICodeGenerator codeGenerator = new ...;
Compiler compiler = new ...;
ProtobufProxy.create(clazz, compiler, codeGenerator);

```
上面的示例，会开放Compiler与ICodeGenerator实现自定能力


####  after 3.4.3 add Any Object supports  ###

使用示例：

```java
public class AnyPOJO {
    
    /** The details. */
    @Protobuf(fieldType = FieldType.OBJECT)
    private List<Any> details;
}

```


```java
    public void encodeOriginDecodeJprotobuf() throws IOException {
        StringTypePOJOClass pojo = new StringTypePOJOClass();
        pojo.setStr("hello world");
        com.baidu.bjf.remoting.protobuf.Any any = com.baidu.bjf.remoting.protobuf.Any.pack(pojo);

        String m = "hello xiemalin.";
        AnyPOJO anyPojo = new AnyPOJO();
        anyPojo.setMessage(m);
        
        List<com.baidu.bjf.remoting.protobuf.Any> details = new ArrayList<com.baidu.bjf.remoting.protobuf.Any>();
        details.add(any);
        anyPojo.setDetails(details);
        
        Codec<AnyPOJO> codec = ProtobufProxy.create(AnyPOJO.class);
        // do encode and decode
        byte[] bytes = codec.encode(anyPojo);
        AnyPOJO anyPojo2 = codec.decode(bytes);
        
        Assert.assertEquals(m, anyPojo2.getMessage());
        
        List<com.baidu.bjf.remoting.protobuf.Any> details2 = anyPojo2.getDetails();
        Assert.assertEquals(1, details2.size());
        
        for (com.baidu.bjf.remoting.protobuf.Any any3 : details2) {
            boolean b = any3.is(StringTypePOJOClass.class);
            Assert.assertTrue(b);
            if (b) {
                StringTypePOJOClass unpack = any3.unpack(StringTypePOJOClass.class);
                Assert.assertEquals(pojo.getStr(), unpack.getStr());
            }
        }
        
    }

```

问题： Any对象与原生的protobuf 类名不一致，导致 is判断失败怎么处理？

```java
 // pack方法支持，设置自定义类名
 com.baidu.bjf.remoting.protobuf.Any any = com.baidu.bjf.remoting.protobuf.Any.pack(pojo, "ur new class name");
 
 // 收到Any对象后，判断处理
 any.is("ur new class name");
```


更多使用示例请参见testcase代码。

### 沟通群号：QQ: 644867264 ###
