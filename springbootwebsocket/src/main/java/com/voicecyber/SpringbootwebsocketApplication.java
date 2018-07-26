package com.voicecyber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootwebsocketApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebsocketApplication.class, args);
	}
}
