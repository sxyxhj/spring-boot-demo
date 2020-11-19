package org.sxyxhj.springcloudeurekarestdemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.sxyxhj.springcloudeurekarestdemo.vo.Person;

@FeignClient(name = "provider")
public interface FeignClientService {

    @RequestMapping(method = RequestMethod.GET,value = "/person")
    public Person getPerson(@RequestParam(value = "name") String name);
}
