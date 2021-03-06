package org.sxyxhj.springcloudeurekarestdemo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.sxyxhj.springcloudeurekarestdemo.vo.Person;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: spring-boot-demo
 * @description: LicenseServiceController, 演示利用EnableDiscoveryClient 去调用服务
 * @author: @sxyxhj
 * @create: 2020-11-15 09:47
 **/
@RestController
public class LicenseServiceController {
    @Resource
    private DiscoveryClient client;

    @GetMapping("/getService")
    public ResponseEntity getServices(){

        List<ServiceInstance> list = client.getInstances("provider");
        //获取地址
        String url = list.get(0).getUri().toString()+"/person";

        RestTemplate restTemplate = new RestTemplate();
        //使用Spring restTemplate 调用服务
        ResponseEntity responseEntity = restTemplate.exchange(url, HttpMethod.GET,null, Person.class,"provider");


        return responseEntity;
    }
}

    
