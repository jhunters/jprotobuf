
#### gradle插件
使用方法

```property

plugins {
    id 'com.baidu.jprotobuf' version '1.0.2'
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
    classpath "gradle.plugin.com.baidu.jprotobuf:jprotobuf-precompile-plugin-gradle:1.0.2"
  }
}

apply plugin: "com.baidu.jprotobuf"
```

[查看版本信息](https://plugins.gradle.org/plugin/com.baidu.jprotobuf)

## Document

- [Full docs](./Document.md)

## Contact us
QQ: 644867264

## License
JProtobuf is [Apache 2.0 licensed](./LICENSE).
