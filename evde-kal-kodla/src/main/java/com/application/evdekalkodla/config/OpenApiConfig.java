package com.application.evdekalkodla.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    // http://localhost:8080/swagger-ui/index.html?url=/v3/api-docs&validatorUrl=
    @Bean
    public OpenAPI customCofiguration() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Evde-Kal-Kodla API Reference")
                        .description("Sample REST API documentation"));
    }
}
