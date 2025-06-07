package com.microservices.accounts;

import com.microservices.accounts.dto.AccountsContactInfoDto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

/**
 * @author Ridho Suhaebi Arrowi
 */

@SpringBootApplication
/*
 * @ComponentScans({ @ComponentScan("com.microservices.accounts.controller") })
 * 
 * @EnableJpaRepositories("com.microservices.accounts.repository")
 * 
 * @EntityScan("com.microservices.accounts.model")
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(info = @Info(title = "Accounts microservice REST API Documentation", description = "Bank Accounts microservice REST API Documentation", version = "v1", contact = @Contact(name = "Ridho Suhaebi Arrowi", email = "ridhorezi1212@gmail.com", url = "https://ridhosuhaebiarrowi.me"), license = @License(name = "Apache 2.0", url = "https://ridhosuhaebiarrowi.me")), externalDocs = @ExternalDocumentation(description = "Bank Accounts microservice REST API Documentation", url = "https://ridhosuhaebiarrowi.me/swagger-ui.html"))
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
