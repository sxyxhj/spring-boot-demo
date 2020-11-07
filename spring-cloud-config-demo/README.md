# spring-cloud-config-demo

## 使用两种不同的机制来提供应用程序配置
### 文件系统
### Git存储库

### Config server 配置访问地址：

http://localhost:8888/licensingservice/default
http://localhost:8888/licensingservice/dev
http://localhost:8888/licensingservice/prod



如果配置更改,Actuator提供了@RefreshScope去刷新应用程序配置
@RefreshScope



## 保护敏感信息：

### Server端增加的配置:

encrypt=imsymmetric

在加密字符串之前加上{cipher}，它告诉SpringCLoud配置服务器正在处理加密数据
{cipher}

禁用服务端的属性解密(通过地址获取是显示为加密数据)：
在bootstrap.yml文件中配置如下信息：
spring:
  cloud:
    config:
      server:
        encrypt:
          enabled: false



### Client端需要加的配置：

1. 添加依赖

<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-rsa</artifactId>
</dependency>

2. 增加加密key

	encrypt:
	  key: 123456

## 遇到的问题:

问题1：

{
    "description": "The encryption algorithm is not strong enough",
    "status": "INVALID"
}

encrypt:
  key: 123456

问题2：

{
    "timestamp": "2020-11-07T06:35:19.550+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "",
    "path": "/encrypt"
}

从 Oracle 官网下载对应 JCE，下载链接：https://www.oracle.com/java/technologies/javase-jce-all-downloads.html
放到%JAVA_HOME%\jre\lib\security

问题3：

如果客户端显示不能解密
Cannot decrypt:XXXXX

解决方案：

在Client的bootstarp.yml里面增加这个配置，与Config server保证一致

encrypt:
  key: 123456
