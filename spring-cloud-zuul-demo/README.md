# Spring Cloud Zuul Demo

创建Eureka Client 端代码 此项目为服务调用者
书中的授权服务

@EnableZuulProxy：开启Zuul服务
@EnableZuulServer：使用此注解将创建一个Zuul服务器，它不会加载任何Zuul反向代理过滤器，也不会使用Eureka进行服务发现。
开发人员想要构建自己的路由服务，而不使用任何Zuul预置的功能时使用它

Zuul的核心是反向代理

返回服务中所有映射的列表
http://localhost:5555/actuator/routes

## 配置路由

### 自动映射路由

### 手动映射路由

### 使用静态URL手工映射路由
路由那些不受Eureka管理的服务


```
# 将许可证服务映射静态路由
zuul:
  routes:
    test: /test/**
    licensestatic:
      path: /licensestatic/**
      url: http://licenseservice-static:8083
```
```
#  将许可证服务映射到多个静态路由
zuul:
  routes:
    test: /test/**
    # 映射静态路由
    licensestatic:
      path: /licensestatic/**
      #定义一个服务ID，该服务ID用于在Ribbon中查找服务
      serviceId: licensestatic
  prefix: /api
# 在ribbon中禁用Eureka
ribbon:
  eureka:
    enabled: false
    
# 指定请求会路由到指定的服务列表
licensestatic:
  ribbon:
    listOfServices: http://licenseservice-static:8083, http://licenseservice-static2:8083

```


### 动态重新加载路由配置

使用Spring cloud config 来外部化Zuul路由

## 过滤器

### 前置过滤器

### 后置过滤器

### 路由过滤器


## 问题
```
Caused by: com.netflix.client.ClientException: Load balancer does not have available server for client:
```

解决方法是设置为true
```
ribbon:
  eureka:
    enabled: true
```
