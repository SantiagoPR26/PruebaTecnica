package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Prueba Tecnica Vortex",
                version = "1.0.0",
                description = "Crud"
        )
)
public class SwaggerConfig {
}
