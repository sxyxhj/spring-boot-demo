package org.sxyxhj.springcloudeurekaclientdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sxyxhj.springcloudeurekaclientdemo.vo.Person;

/**
 * @program: spring-boot-demo
 * @description: PersonController
 * @author: @sxyxhj
 * @create: 2020-11-04 18:29
 **/
@RestController
public class PersonController {


    @GetMapping("/person")
    public Person getPerson(@RequestParam(value = "name",defaultValue = "test") String name){

        Person person = new Person();
        person.setAge(11);
        person.setName(name);
        return person;
    }

}

    
