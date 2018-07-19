package com;

import com.voicecyber.config.DemoPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		DemoPublisher bean = run.getBean(DemoPublisher.class);
		bean.publish("hello this demo event msg");
		run.close();
	}
}
