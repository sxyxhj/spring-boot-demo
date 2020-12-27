package org.sxyxhj.springcloudsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//@EnableWebSecurity
//@EnableResourceServer
public class SpringCloudSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSecurityApplication.class, args);
    }

}
