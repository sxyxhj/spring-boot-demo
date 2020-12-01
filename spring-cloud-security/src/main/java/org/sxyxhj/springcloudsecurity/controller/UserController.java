package org.sxyxhj.springcloudsecurity.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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


    @RequestMapping(value = {"/user"},produces = "application/json")
    public Map<String,Object> user(OAuth2Authentication user){
        Map userInfo = new HashMap();

        userInfo.put("user",user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));

        return userInfo;
    }
}

    
