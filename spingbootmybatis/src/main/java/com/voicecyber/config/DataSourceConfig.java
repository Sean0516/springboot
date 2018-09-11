package com.voicecyber.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Sean on 2018/9/11
 *
 * @author Sean
 */
@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username("root");
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.password("123456");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/test");
        return dataSourceBuilder.build();
    }

}
