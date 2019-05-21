package com.mashreq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author jasar_jamaludheen
 * Spring boot application starting class
 */
@EnableSwagger2
@SpringBootApplication
public class RetailApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Initializing");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

}
