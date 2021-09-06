package com.innteam.epicmarket.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Predicate<String> pathExclude() {
        return PathSelectors.regex("/error.*");
    }

    private Predicate<String> pathAuthRequired() {
        return Predicates.or(PathSelectors.regex("/api.*"), PathSelectors.regex(".*?\\.auth"));
    }

    private Predicate<String> pathWithoutAuth() {
        return PathSelectors.regex("/api2.*");
    }

    private Predicate<String> pathOther() {
        return Predicates.and(PathSelectors.any(),
                Predicates.not(pathExclude()),
                Predicates.not(pathAuthRequired()),
                Predicates.not(pathWithoutAuth()));
    }

    @Bean
    public Docket authRequired() {
        List<Parameter> globalParams = Lists.newArrayList(
                new ParameterBuilder().name("username").description("User name/Login")
                        .modelRef(new ModelRef("string")).parameterType("header").required(true).build()
        );
        return new Docket(DocumentationType.SWAGGER_2).groupName("api")
                //.globalOperationParameters(globalParams) enable default username header for all endpoints
                .select().paths(pathAuthRequired()).build();
    }

    @Bean
    public Docket api2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("api2")
                .select().paths(pathWithoutAuth()).build();
    }

    @Bean
    public Docket other() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("other")
                .select().paths(pathOther()).build();
    }
}
