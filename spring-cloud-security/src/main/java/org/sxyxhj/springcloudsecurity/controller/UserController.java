package org.sxyxhj.springcloudsecurity.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring-boot-demo
 * @description: 用户验证类
 * @author: @sxyxhj
 * @create: 2020-12-01 21:42
 **/
@RestController
public class UserController {


    @GetMapping(value = {"/user"},produces = "application/json")
    public Map<String,Object> user(){
        Map userInfo = new HashMap();

        userInfo.put("user","test");
        userInfo.put("authorities", "test");

        return userInfo;
    }
}

    
