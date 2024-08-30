package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservice REST Api Documentation",
                description = "Bank Accounts Microservice REST Api Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Mushfeque Zihan",
                        email = "zihan_666@yahoo.com",
                        url = "https://mzinfo.xyz"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://mzinfo.xyz"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Bank Accounts Microservice REST Api Documentation",
                url = "https://swagger.io/tools/swagger-ui/"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
