package com.concretepage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@Configuration
public class HelloWorldConfig {
   @Bean 
   public HelloWorld helloWorld(){
      return new HelloWorld();
   }
   
   
   private ApiInfo metadata2() {
       return new ApiInfoBuilder()
               .title( "My awesome ACS API" )
               .description( "All the requests that the server will respond to." )
               .version( "1.0.0" )
               .build();
   }
}