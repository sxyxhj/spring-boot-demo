# spring-boot-rest-demo

## 创建一个rest服务
## 并添加swagger

添加POM依赖

配置swagger页面 
配置类：
org.sxyxhj.restapidemo.swagger.SwaggerConfig

Swagger访问地址：
http://localhost:8080/swagger-ui.html


## 遇到的问题：
### 启动正常但是访问是404
原因注解@SpringBootApplication默认扫描的applicationz所在的包或者子包，所以解决方案是把controller包放到跟它同一级别或者子包中
或者添加@ComponentScan(basePackages = {})，但是会导致扫描的是指定的包，而不是application所在的包或者子包的类。