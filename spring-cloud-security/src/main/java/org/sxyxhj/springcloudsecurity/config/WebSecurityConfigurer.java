package org.sxyxhj.springcloudsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: spring-boot-demo
 * @description: 配置用户名和密码
 * @author: @sxyxhj
 * @create: 2020-12-01 22:22
 **/
@Configuration
@EnableWebSecurity
//对全部方法进行验证
@EnableGlobalMethodSecurity(prePostEnabled = true , securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2Config config;

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("test")
                .password(config.getPasswordEncoder().encode("test"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(config.getPasswordEncoder().encode("admin"))
                .roles("USER","ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
// 决定那些请求被拦截
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll() //都可以访问
// .antMatchers("").permitAll()// 主路径放行
                .anyRequest().permitAll()// 其他请求需经过验证
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()// 表单登录允许任意权限访问
                .and()
                .logout().permitAll();// 注销操作允许任意权限访问
*/

        //http.csrf().disable();// 关闭默认的csrf认证

        /*http.authorizeRequests()
                .antMatchers("/oauth/*").authenticated()
                .antMatchers("/user")
                .hasRole("USER")
                .antMatchers("/admin/**")
                .hasRole("ADMIN");*/

        http.authorizeRequests()
                .antMatchers("/user").hasRole("USER").antMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest().permitAll()
        .and()
        .formLogin()
        .loginProcessingUrl("/login")
        .permitAll()
        .and()
        .logout().permitAll();

        http.csrf().disable();// 关闭默认的csrf认证

    }


}

    
