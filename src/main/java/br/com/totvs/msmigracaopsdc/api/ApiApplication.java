package br.com.totvs.msmigracaopsdc.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe principal de starter com configuração de CORS
 * 
 * @author rsdelia
 *
 */
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	/**
	 * Configuração de CORS
	 * 
	 * @author rsdelia
	 * @return {@link WebMvcConfigurer}
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS",
						"HEAD", "TRACE", "CONNECT");
			}
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}