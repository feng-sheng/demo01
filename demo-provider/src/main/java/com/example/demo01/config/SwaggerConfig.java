package com.example.demo01.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author: lifengsheng
 * @Date: 2023/1/12 09:56
 * @Desc:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.enable.switch:false}")
    private Boolean enableSwitch;

    // 配置docket以配置Swagger具体参数
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enableSwitch)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo01.controller"))
                .build();
    }

    // 配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("Three Kingdoms Story", "435421324@qq.com", "联系人邮箱");
        return new ApiInfo(
                "三国演义API",
                "About Three Kingdoms Story Swagger",
                "v0.0.1",
                "https://github.com/feng-sheng/demo01",
                contact,
                "Apache 2.0 许可",
                "许可链接",
                new ArrayList<>()
        );
    }

/*
    any() // 扫描所有，项目中的所有接口都会被扫描到
    none() // 不扫描接口
    // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
    withMethodAnnotation(final Class<? extends Annotation> annotation)
    // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
    withClassAnnotation(final Class<? extends Annotation> annotation)
    basePackage(final String basePackage) // 根据包路径扫描接口
*/
}
