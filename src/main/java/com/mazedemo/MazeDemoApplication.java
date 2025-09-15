package com.mazedemo;

import com.mazedemo.security.config.JwtConfig;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@OpenAPIDefinition(
		info = @Info(
				title = "Springdoc-openapi mazeDemo sample",
				version = "v1.0.0",
				description = "Springdoc-openapiを利用したAPIdocument作成サンプル"
				)
)
@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class)
public class MazeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MazeDemoApplication.class, args);
	}

}
