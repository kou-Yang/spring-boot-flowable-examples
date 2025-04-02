package com.ky.flowable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Knife4j 接口文档配置
 * 访问：http://localhost:8080/api/doc.html
 *
 * @author kouyang
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig extends BaseKnife4jConfig {

    @Override
    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                .title("flowable")
                .description("Flowable examples")
                .contact(new Contact("ky", "", ""))
                .version("1.0")
                .build())
                .select()
                // 指定 Controller 扫描包路径
                .apis(basePackage("com.ky.flowable.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}