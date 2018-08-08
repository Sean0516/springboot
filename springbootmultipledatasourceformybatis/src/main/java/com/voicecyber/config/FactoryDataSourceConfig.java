package com.voicecyber.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by Sean on 2018/7/31
 *
 * @author Sean
 */
@Configuration
@MapperScan(basePackages = "com.voicecyber.mapper.factory", sqlSessionTemplateRef = "factorySqlSessionTemplate")
public class FactoryDataSourceConfig {
    @Bean(name = "factoryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.factory")
    public DataSource factoryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "factorySessionFactory")
    public SqlSessionFactory factorySqlSessionFactory(@Qualifier("factoryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/factory/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "factoryTransactionManager")
    public DataSourceTransactionManager factoryTransactionManager(@Qualifier("factoryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "factorySqlSessionTemplate")
    public SqlSessionTemplate factorySqlSessionTemplate(@Qualifier("factorySessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
