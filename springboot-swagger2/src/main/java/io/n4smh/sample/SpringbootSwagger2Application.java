package io.n4smh.sample;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwagger2Application.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		// Restricting to paths based on path prefix
		docket = docket.select().paths(PathSelectors.ant("/api/*")).build();

		// Restricting to paths based on package
		docket = docket.select().apis(RequestHandlerSelectors.basePackage("io.n4smh.sample")).build();

		// API info does'nt require build
		docket = docket.apiInfo(apiDetails());

		return docket;
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Address book API", "Sample API for Swagger in SpringBoot", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Nagesh MH", "https://github.com/n4smh",
						"n4smh@outlook.com"),
				"API License", "https://github.com/n4smh", Collections.emptyList());
	}
}
