package dev.iwhrim.client.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("dev.iwhrim.client"))
                .paths(PathSelectors.any())
                .build()
//                .ignoredParameterTypes(File.class, InputStream.class, Resource.class,
//                        URL.class, URI.class, URLStreamHandler.class, Blob.class)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Client REST API",
                "This is a microservice documentation for the Fast Track's final challenge.",
                "v1",
                "Terms of service",
                new Contact("Gustavo Teixeira", "https://www.compasso.com.br", "gustavoteixeira@compasso.com.br"),
                "MIT", "https://opensource.org/licenses/MIT", Collections.emptyList());
    }

}
