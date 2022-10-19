
<h1 align="center">JProtobuf</h1>

<p align="center">
A useful utility library for java programmer to use google protobuf library.
</p>


[![Build Status](https://travis-ci.org/jhunters/jprotobuf.svg?branch=master)](https://travis-ci.org/jhunters/jprotobuf)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.baidu/jprotobuf/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.baidu/jprotobuf)
[![codecov](https://codecov.io/gh/jhunters/jprotobuf/branch/master/graph/badge.svg)](https://codecov.io/gh/jhunters/jprotobuf)


## What is jprotobuf
jprotobuf是针对Java程序开发一套简易类库，目的是简化java语言对protobuf类库的使用<br>
使用jprotobuf可以无需再去了解proto文件操作与语法，直接使用java注解定义字段类型即可。<br>


## How it works
jprotobuf工作原理如下：<br>
1. 扫描类上的注解的信息，进行分析(与protobuf读取proto文件进行分析过程相似)<br>
2. 根据注解分析的结果，动态生成java代码进行protobuf序列化与反序列化的功能实现<br>
3. 使用JDK6及以上的 code compile API进行编译后加载到classloader

## Performace
jprotobuf 主要性能消耗在 扫描类上注解，动态生成代码编译的过程。<br>
在执行序列化与反序列化的过程中，几乎与protobuf生成的代码效率等同。<br>
如果使用预编译插件，则无需在运行中进行代码生成与编译，效率更高

## Features
1. 无需编写proto文件及繁琐的手工编译过程，支持基于POJO对象的注解方式，方便快捷。<br>
   支持protobuf所有类型，包括对象嵌套，数组，枚举类型<br>
2. 提供根据proto文件，动态生成代理对象，可省去POJO对象的编写工作。<br>
   完整支持proto文件所有功能，包括内联对象，匿名对象，枚举类型<br>
3. 提供从POJO对象的注解方式自动生成proto文件的功能， 方便proto描述文件的管理与维护<br>
4. 提供预编译Maven插件，进一步提升运行性能
5. 新增预编译gradle插件
6. 2.x版本。 支持TimeStamp类型, 与原生protobuf保持一致。 支持Date类型，使用long类型传递 [docs](./v3/README.md)

## Which version
1. jprotobuf-1.x supports google protocol buffer v2.5.x<br>
2. jprotobuf-2.x supports google protocol buffer v3.0.0. 实现对MAP结构的支持. [文档](https://github.com/jhunters/jprotobuf/tree/master/v3)<br>
3. jprotobuf-android Android development supports

## 关联项目：
JProtobuf-rpc-socket 基于socket的高性能RPC实现<br>
访问地址：[https://github.com/jhunters/Jprotobuf-rpc-socket](https://github.com/Baidu-ecom/Jprotobuf-rpc-socket)<br>
JProtobuf-rpc-http 基于JProtobuf的RPC实现，支持直接从IDL定义脚本发布RPC服务<br>
访问地址：[https://github.com/jhunters/JProtobuf-rpc-http](https://github.com/jhunters/JProtobuf-rpc-http)<br>
golang 协议实现: [https://github.com/baidu-golang/baidurpc](https://github.com/baidu-golang/baidurpc "https://github.com/baidu-golang/baidurpc")

## Quick Start

```java
@ProtobufClass
public class SimpleTypeTest {
    private String name;
    private int value;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}


// example code for usage
Codec<SimpleTypeTest> simpleTypeCodec = ProtobufProxy
        .create(SimpleTypeTest.class);

SimpleTypeTest stt = new SimpleTypeTest();
stt.name = "abc";
stt.value = 100
try {
    // 序列化
    byte[] bb = simpleTypeCodec.encode(stt);
    // 反序列化
    SimpleTypeTest newStt = simpleTypeCodec.decode(bb);
} catch (IOException e) {
    e.printStackTrace();
}


```


## Download
jprotobuf-1.x  JDK 6 或以上版本

```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf</artifactId>
  <version>1.13.3</version>
</dependency>
```
[下载发行包](https://repo1.maven.org/maven2/com/baidu/jprotobuf/)

jprotobuf-2.x  JDK 7 或以上版本
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf</artifactId>
  <version>2.4.17</version>
</dependency>
```
[下载发行包](https://repo1.maven.org/maven2/com/baidu/jprotobuf/2.4.3/)

jprotobuf-android  
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf-android</artifactId>
  <version>1.1.3</version>
</dependency>
```
[下载发行包](https://repo1.maven.org/maven2/com/baidu/jprotobuf-android/)


## Download plugin
插件使用方法，请阅读文档[Full docs](./Document.md)
#### maven插件
jprotobuf-precompile-plugin 支持maven编译时同时进行jprotobuf对象的预编译操作. <br>
注：plugin版本建议使用>=1.2.0， jprotobuf 支持版本>=1.9.4   
1.2.15和2.0.11版本之后，支持在预编译阶段生成 proto声明文件的功能， 文件生成位置在当前类的相同目录下。具体使用方式详见下面插件使用说明
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf-precompile-plugin</artifactId>
  <version>1.4.4</version>
</dependency>
```
|插件版本1.x | 支持的jprotobuf版本 | 说明 |
|---|---|---|
|<=1.2.10|<=1.11.4||
|>=1.2.11|>=1.11.5||

 
// 2.x支持版本
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf-precompile-plugin</artifactId>
  <version>2.2.8</version>
</dependency>
```

|插件版本2.x | 支持的jprotobuf版本 | 说明 |
|---|---|---|
|<=2.2.5|<=2.0.4||
|>=2.2.6|>=2.0.5||


#### gradle插件
```property

plugins {
    id 'com.baidu.jprotobuf' version '1.1.1'
}
```
[查看版本信息](https://plugins.gradle.org/plugin/com.baidu.jprotobuf)

## Document

- [Full docs](./Document.md)

## Contact us
QQ: 644867264 (入群口号： jprotobuf)

## License
JProtobuf is [Apache 2.0 licensed](./LICENSE).
