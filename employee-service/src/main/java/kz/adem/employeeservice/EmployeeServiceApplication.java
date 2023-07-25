package kz.adem.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(
                title = "Employee Service REST API",
                description = "Employee Service REST API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Adem",
                        email = "ademshanghai@gmail.com",
                        url = "http://github.com/kissmylala"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Department-Service doc",
                url = "http://github.com/kissmylala"
        )
)
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
