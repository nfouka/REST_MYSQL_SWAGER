package com.concretepage.conf;



import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.concretepage.controller"))
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "My REST API", 
          "Some custom description of API.", 
          "API TOS", 
          "Terms of service", 
          new Contact("John Doe", "www.example.com", "myeaddress@company.com"), 
          "License of API", "API license URL", Collections.emptyList());
   }
    

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title( "My awesome ACS API" )
                .description( "All the requests that the server will respond to." )
                .version( "1.0.0" )
                .build();
    }
    
    
    
    @Bean
    public Docket orderApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("spec2")
                .apiInfo(metadata())
                .select()
                .paths(PathSelectors.ant("/spec2/**"))
                .build();
    }

    @Bean
    public Docket orderValidationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("spec3")
                .apiInfo(metadata())
                .select()
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }
    
}