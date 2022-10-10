package com.example.trelloApi.configs.openApi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * @author "Elmurodov Javohir"
 * @since 19/08/22/16:46 (Friday)
 * spring-boot-features/IntelliJ IDEA
 */


@Configuration
@OpenAPIDefinition(
        info = @Info(title = "First Step Forward API", version = "v1",
                description = "This API just for learning purposes",
                contact = @Contact(name = "Dilshodbek", url = "https://pdp.uz", email = "john.lgd65@gmail.com"),
                license = @License(name = "Apache Foundation", url = "http://apache.org")
        ),
        security = {
                @SecurityRequirement(
                        name = "Bearer"
                )
        }
)
@SecurityScheme(
        name = "Bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "Bearer"
)
public class OpenApiConfigurer {

}
