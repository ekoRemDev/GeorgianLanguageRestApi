package com.flyingpigstuios;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .paths(PathSelectors.ant("/"))
//                .paths(regex("/v1.*"))
                .apis(RequestHandlerSelectors.basePackage("com.flyingpigstuios"))
                .build().apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Georgian Language App Rest Api", //title
                "Georgian Language App Rest Api", //description
                "0.0.1", //version
                "Terms of service", //terms of service URL
                new Contact("Georgian Language App","flyingpigstuios.com","ekoremdev@gmail.com"),
                "License of API", "API license URL", Collections.emptyList()
        ); // contact info
    }
}