
#### gradle插件
使用方法

```property

plugins {
    id 'com.baidu.jprotobuf' version '1.1.0'
}
```

Using legacy plugin application:

```property
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.baidu.jprotobuf:jprotobuf-precompile-plugin-gradle:1.1.0"
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

使用命令示例

```property
gradle compileJava jprotobuf_precompile build
```

[查看版本信息](https://plugins.gradle.org/plugin/com.baidu.jprotobuf)

## Document

- [Full docs](./Document.md)

## Contact us
QQ: 644867264

## License
JProtobuf is [Apache 2.0 licensed](./LICENSE).
