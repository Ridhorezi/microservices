package com.microservices.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import com.microservices.loans.dto.LoansContactInfoDto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
 * @ComponentScans({ @ComponentScan("com.microservices.loans.controller") })
 * 
 * @EnableJpaRepositories("com.microservices.loans.repository")
 * 
 * @EntityScan("com.microservices.loans.model")
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@OpenAPIDefinition(info = @Info(title = "Loans microservice REST API Documentation", description = "Bank Loans microservice REST API Documentation", version = "v1", contact = @Contact(name = "Ridho Suhaebi Arrowi", email = "ridhorezi1212@gmail.com", url = "https://ridhosuhaebiarrowi.me"), license = @License(name = "Apache 2.0", url = "https://ridhosuhaebiarrowi.me")), externalDocs = @ExternalDocumentation(description = "Bank Loans microservice REST API Documentation", url = "https://ridhosuhaebiarrowi/swagger-ui.html"))
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}
