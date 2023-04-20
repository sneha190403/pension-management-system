package com.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PmsJwtAuthenticationApplication {

	@Value("${cross.site.url}")
	private String crossOriginUrl;

	public static void main(String[] args) {
		SpringApplication.run(PmsJwtAuthenticationApplication.class, args);
	}

	// cross-origin configuration
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(crossOriginUrl).allowCredentials(true);
			}
		};
	}

}
