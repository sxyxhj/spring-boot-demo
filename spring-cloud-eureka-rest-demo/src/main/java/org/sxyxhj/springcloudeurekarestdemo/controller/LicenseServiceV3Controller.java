package org.sxyxhj.springcloudeurekarestdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sxyxhj.springcloudeurekarestdemo.services.FeignService;
import org.sxyxhj.springcloudeurekarestdemo.vo.Person;

import javax.annotation.Resource;

/**
 * @program: spring-boot-demo
 * @description: LicenseServiceController, 演示使用带有Ribbon功能的Spring RestTemplate调用服务
 * @author: @sxyxhj
 * @create: 2020-11-15 09:47
 **/
@RestController
public class LicenseServiceV3Controller {


    @Autowired
    FeignService feignService;

    @GetMapping("/getServiceV3")
    public Person getServices(){

        //使用Spring restTemplate 调用服务
        return feignService.getPerson("haahhaahhah");


    }
}

    
