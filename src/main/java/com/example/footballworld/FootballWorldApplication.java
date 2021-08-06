package com.example.footballworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class FootballWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballWorldApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.example.footballworld.controller"))
                .build().apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfo("Football World",
                "Some custom description of API.",
                "1.00",
                null,
                new Contact("Wojciech Kostecki", "https://www.linkedin.com/in/wojciech-kostecki-7816411a4/", "wt.kostecki@gmail.com"),
                null, null, Collections.emptyList());
    }
}
