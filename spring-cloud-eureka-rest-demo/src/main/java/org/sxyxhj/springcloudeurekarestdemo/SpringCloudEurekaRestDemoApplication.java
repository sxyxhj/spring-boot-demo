package org.sxyxhj.springcloudeurekarestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.sxyxhj.springcloudeurekarestdemo.feign.FeignClientService;

@SpringBootApplication
/**
 * 使用Spring DiscoveryClient
 * @EnableDiscoveryClient
 */
@EnableDiscoveryClient

//使用Netflix feign

@EnableFeignClients(clients = FeignClientService.class)
@ComponentScan(basePackages = "org.sxyxhj")

public class SpringCloudEurekaRestDemoApplication {


    // @LoadBalanced 显示标注， 使用Ribbon 和 RestTemplate。
   @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaRestDemoApplication.class, args);
    }

}
