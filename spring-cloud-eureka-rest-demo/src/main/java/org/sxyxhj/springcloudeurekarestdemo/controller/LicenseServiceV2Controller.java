package org.sxyxhj.springcloudeurekarestdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
 * @description: LicenseServiceController, 演示使用带有Ribbon功能的Spring RestTemplate调用服务
 * @author: @sxyxhj
 * @create: 2020-11-15 09:47
 **/
@RestController
public class LicenseServiceV2Controller {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getServiceV2")
    public ResponseEntity getServices(){

        //使用Spring restTemplate 调用服务
        ResponseEntity responseEntity = restTemplate.exchange("http://provider/person", HttpMethod.GET,null, Person.class,"provider");


        return responseEntity;
    }
}

    
