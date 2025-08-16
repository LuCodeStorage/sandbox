package com.mazedemo.mazeDemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Springdoc-openapi mazeDemo sample",
				version = "v1.0.0",
				description = "Springdoc-openapiを利用したAPIdocument作成サンプル"
				)
)
@SpringBootApplication
public class MazeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MazeDemoApplication.class, args);
	}

}
