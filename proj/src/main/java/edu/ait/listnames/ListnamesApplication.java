package edu.ait.listnames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ListnamesApplication {

	// We are injecting the react base-uri from the application.properties file using @Value annotation
	@Value("${react.base-uri}")
	private String reactBaseURI;

	public static void main(String[] args) {
		SpringApplication.run(ListnamesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedOrigins(reactBaseURI)
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.exposedHeaders("*"); // required as frontend is a different port/website
			}
		};
	}
}
