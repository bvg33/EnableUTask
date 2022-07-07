package com.interview.enableu.task.documentation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact()
                .email("savkov01@mail.ru")
                .name("Dmitry Savkov");
        Info info = new Info()
                .title("Url monitoring Api")
                .version("1.0.0")
                .contact(contact);
        return new OpenAPI().info(info);
    }
}
