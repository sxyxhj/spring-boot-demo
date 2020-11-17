package org.sxyxhj.springcloudeurekarestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEurekaRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaRestDemoApplication.class, args);
    }

}
