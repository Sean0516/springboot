package com.voicecyber.config;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

/**
 * Created by Sean on 2018/9/11
 *
 * @author Sean
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "test")
    @Primary
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username("root");
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.password("123456");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/test");
        dataSourceBuilder.type(com.zaxxer.hikari.HikariDataSource.class);
        return dataSourceBuilder.build();
    }
    @Bean(name = "userTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate(@Qualifier("test") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


    @Bean(name = "school")
    public DataSource schoolDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username("root");
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.password("123456");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/school");
        dataSourceBuilder.type(com.zaxxer.hikari.HikariDataSource.class);
        return dataSourceBuilder.build();
    }
    @Bean(name = "studentTemplate")
    public JdbcTemplate schoolJdbcTemplate(@Qualifier("school") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }



}

