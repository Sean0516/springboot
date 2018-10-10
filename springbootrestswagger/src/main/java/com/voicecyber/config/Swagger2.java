package com.voicecyber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Sean on 2018/10/10
 *Api 文档页面 基本信息
 * 可以通过注解注入相关配置。
 * 通过这些配置可以指定在spring-boot启动时扫描哪些controller层的文件夹，
 * 另外可以指定API文档页的标题和描述信息等内容
 * @author Sean
 */
@Configuration
@EnableSwagger2
public class Swagger2 {


    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.voicecyber"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(" RESTful APIs")
                .description(" Rest  Server api接口文档")
                .version("1.0")
                .build();
    }
}
