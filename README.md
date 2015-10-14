jprotobuf
=========

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
2. jprotobuf-2.x supports google protocol buffer v3.0.0-alpha-2. 实现对MAP结构的支持. [文档](https://github.com/jhunters/jprotobuf/tree/master/v3)<br>


## 环境要求 ##
jprotobuf-1.x  JDK 6 或以上版本

```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf</artifactId>
  <version>1.8.2</version>
</dependency>
```
[下载发行包](http://repo1.maven.org/maven2/com/baidu/jprotobuf/)


jprotobuf-2.x  JDK 7 或以上版本
```xml
<dependency>
  <groupId>com.baidu</groupId>
  <artifactId>jprotobuf</artifactId>
  <version>2.0.1-SNAPSHOT</version>
</dependency>
```
[下载发行包](https://oss.sonatype.org/content/repositories/snapshots/com/baidu/jprotobuf/2.0.1-SNAPSHOT/)


