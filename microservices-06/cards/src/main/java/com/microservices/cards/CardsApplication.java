package com.microservices.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import com.microservices.cards.dto.CardsContactInfoDto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
 * @ComponentScans({ @ComponentScan("com.microservices.cards.controller") })
 * 
 * @EnableJpaRepositories("com.microservices.cards.repository")
 * 
 * @EntityScan("com.microservices.cards.model")
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@OpenAPIDefinition(info = @Info(title = "Cards microservice REST API Documentation", description = "Bank Cards microservice REST API Documentation", version = "v1", contact = @Contact(name = "Ridho Suhaebi Arrowi", email = "ridhorezi1212@gmail.com", url = "https://ridhosuhaebiarrowi.com"), license = @License(name = "Apache 2.0", url = "https://ridhosuhaebiarrowi.me")), externalDocs = @ExternalDocumentation(description = "Bank Cards microservice REST API Documentation", url = "https://ridhosuhaebiarrowi/swagger-ui.html"))
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
