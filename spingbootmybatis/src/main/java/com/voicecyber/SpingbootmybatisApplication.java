package com.voicecyber;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.voicecyber.mapper")
@EnableTransactionManagement
@EnableCaching
public class SpingbootmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingbootmybatisApplication.class, args);
	}
}
