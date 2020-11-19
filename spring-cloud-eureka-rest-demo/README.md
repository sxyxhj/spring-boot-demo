# Spring Cloud Eureka Client Demo

创建Eureka Client 端代码 此项目为服务调用者
书中的授权服务

三种方式去调用服务：

1. 使用Spring DiscoveryClient (LicenseServiceController)

2. 使用带有Ribbon功能的Spring RestTemplate调用服务 (LicenseServiceV2Controller)

3. 使用NetflixFeign客户端 (LicenseServiceV3Controller)