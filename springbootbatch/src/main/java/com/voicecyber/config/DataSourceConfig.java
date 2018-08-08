package com.voicecyber.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Sean on 2018/8/7
 *
 * @author Sean
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "schoolDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.school")
    @Primary
    /**
     * Primary 标志这个 Bean 如果在多个同类 Bean 候选时，该 Bean 优先被考虑。「多数据源配置的时候注意，必须要有一个主数据源，用 @Primary 标志该 BEan
     */
    public DataSource schoolDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "schoolTransactionManager")
    @Primary
    public DataSourceTransactionManager schoolDataSourceTransactionManager(@Qualifier("schoolDataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "factoryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.factory")
    public DataSource factoryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "factoryTransactionManager")
    public DataSourceTransactionManager factoryTransactionManager(@Qualifier("factoryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }



}
