package com.voicecyber.controller;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Sean on 2018/10/22
 *
 * @author Sean
 */
@RestController
public class TestController {
    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("test")
    public String test() throws SQLException {
        HikariDataSource hikariDataSource = (HikariDataSource) applicationContext.getBean("dataSource");
        return hikariDataSource.getConnection().getMetaData().getURL();
    }

    @RequestMapping("test2")
    public String test2() throws SQLException {
        HikariDataSource hikariDataSource = (HikariDataSource) applicationContext.getBean("dataSource");
        hikariDataSource.getConnection().close();
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        hikariDataSource.setUsername("root");
        hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        hikariDataSource.setPassword("123456");
        hikariDataSource.getConnection();
        return "change dataSource";
    }
}
