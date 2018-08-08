package com.voicecyber.config;

import com.voicecyber.model.Staff;
import com.voicecyber.model.Student;
import com.voicecyber.model.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.support.DatabaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Sean on 2018/8/7
 *
 * @author Sean
 */

@Configuration
@EnableBatchProcessing
@ComponentScan(basePackageClasses = DefaultBatchConfigurer.class)
public class UserBatchManyDataSourceConfig {
    /**
     * 读取数据的实现  ，可以自定义实现
     *
     * @return
     * @throws Exception
     */
    @Bean
    public ItemReader<Student> reader(@Qualifier("schoolDataSource")DataSource dataSource) throws Exception {
        JdbcCursorItemReader<Student> jdbcCursorItemReader = new JdbcCursorItemReader<>();
        jdbcCursorItemReader.setDataSource(dataSource);
        jdbcCursorItemReader.setSql("select * from student");
        jdbcCursorItemReader.setRowMapper(new BeanPropertyRowMapper<>(Student.class));
        ExecutionContext executionContext = new ExecutionContext();
        jdbcCursorItemReader.open(executionContext);
        Object object = new Object();
        while (object != null) {
            object = jdbcCursorItemReader.read();
        }
        jdbcCursorItemReader.close();
        return jdbcCursorItemReader;
    }

    /**
     * 用来处理数据的接口  获取Reader 的数据 。并输出 对应的结构给writer
     *
     * @return
     */
    @Bean
    public ItemProcessor<Student, Staff> processor() {
        StudentItemProcessor userItemProcessor = new StudentItemProcessor();
        return userItemProcessor;
    }

    /**
     * 用来输出数据 ,将 processor 处理后的数据进行输出
     *
     * @return
     */
    @Bean
    public ItemWriter<Staff> writer(@Qualifier("factoryDataSource")DataSource dataSource) {
        //使用JDBC批处理的JdbcBatchItemWriter来写数据到数据库
        JdbcBatchItemWriter<Staff> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        itemWriter.setDataSource(dataSource);
        //在此设置要执行批处理的SQL语句
        String sql = "insert into staff" + " (name,sex,phone) " + "values( :name, :sex, :phone)";
        itemWriter.setSql(sql);
        return itemWriter;
    }

    /**
     * 用来注册Job 的容器
     *
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public JobRepository jobRepository(@Qualifier("schoolDataSource")DataSource dataSource,PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType(DatabaseType.MYSQL.name());
        return jobRepositoryFactoryBean.getObject();
    }

    /**
     * 用来启动job 的接口
     *
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public SimpleJobLauncher jobLauncher(@Qualifier("schoolDataSource")DataSource dataSource,PlatformTransactionManager transactionManager) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(this.jobRepository(dataSource,transactionManager));
        return jobLauncher;
    }

    /**
     * job 监听接口
     *
     * @return
     */
    @Bean
    public UserJobListener userJobListener() {
        return new UserJobListener();
    }

    /**
     * @param jobs
     * @param step
     * @return
     */
    @Bean
    public Job importJob(JobBuilderFactory jobs, Step step) {
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                //绑定对应的监听器
                .listener(userJobListener())
                .build();
    }

    /**
     * 实现任务的步骤
     *
     * @param stepBuilderFactory
     * @param reader
     * @param writer
     * @param processor
     * @return
     */
    @Bean
    public Step userStep(StepBuilderFactory stepBuilderFactory,
                         ItemReader<Student> reader, ItemWriter<Staff> writer, ItemProcessor<Student, Staff> processor) {
        return stepBuilderFactory.get("userStep")
                //批处理每次提交的数据条数
                .<Student, Staff>chunk(5000)
                //绑定 reader writer processor
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }


}
