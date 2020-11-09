package org.sxyxhj.springcloudeurekaserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 在Spring服务中启动Eureka服务器
public class SpringCloudEurekaServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerDemoApplication.class, args);
    }

}
