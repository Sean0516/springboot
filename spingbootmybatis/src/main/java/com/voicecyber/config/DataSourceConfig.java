package com.voicecyber.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

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

//    public DataSource dataSource1(){
//        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
//        SingleConnectionDataSource singleConnectionDataSource=new SingleConnectionDataSource();
//        singleConnectionDataSource.setDriverClassName("");
//        driverManagerDataSource.setDriverClassName("");
//        driverManagerDataSource.setUrl("");
//        //TODO
//        return driverManagerDataSource;
//    }

}
