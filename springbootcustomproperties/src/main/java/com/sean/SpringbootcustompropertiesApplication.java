package com.sean;

import com.sean.config.UserPropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class SpringbootcustompropertiesApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootcustompropertiesApplication.class, args);
	}
}
