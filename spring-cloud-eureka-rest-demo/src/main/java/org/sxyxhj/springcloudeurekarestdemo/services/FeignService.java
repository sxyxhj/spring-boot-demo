package org.sxyxhj.springcloudeurekarestdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.sxyxhj.springcloudeurekarestdemo.feign.FeignClientService;
import org.sxyxhj.springcloudeurekarestdemo.vo.Person;

/**
 * @program: spring-boot-demo
 * @description: feign service
 * @author: @sxyxhj
 * @create: 2020-11-18 21:56
 **/
@Service
public class FeignService {

    @Autowired
    private FeignClientService feignClientService;

    public Person getPerson(String name){

        return feignClientService.getPerson(name);


    }
}

    
