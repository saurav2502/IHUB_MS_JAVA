package com.ms.ihub.SwaggerConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Profile("swagger-enabled-for-qa")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		/*return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();*/
		return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors
				.basePackage("com.ms.ihub.order"))
				/*.paths(PathSelectors.regex("/.*"))*/
				.paths(PathSelectors.any())
				.build().apiInfo(apiEndPointsInfo());
	}

	/*private Predicate<String> postPaths() {
		return or(regex("/order/*.*"));
	}*/

	/*private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot's API")
				.description("API reference for developers")
				.termsOfServiceUrl("http://apiTest.com")
				.contact("Saurav").license("")
				.licenseUrl("sauravstarsk@gmail.com").version("1.0").build();
	}*/

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("REST API")
				.description("Spring.")
				.contact("")
				.license("")
				.licenseUrl("")
				.version("1.0")
				.build();
	}

}