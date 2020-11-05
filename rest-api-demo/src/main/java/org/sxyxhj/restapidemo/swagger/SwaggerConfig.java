package org.sxyxhj.restapidemo.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: spring-boot-demo
 * @description: Swagger config
 * @author: @sxyxhj
 * @create: 2020-11-05 16:26
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("在Spring boot 中使用swagger")
                .description("测试API").version("1.0").build();
    }
}

    
