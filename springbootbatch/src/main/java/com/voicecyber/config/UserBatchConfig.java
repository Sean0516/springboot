package com.voicecyber.config;

import com.voicecyber.model.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
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
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.batch.support.DatabaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Sean on 2018/8/6
 *
 * @author Sean
 */
@Configuration
@EnableBatchProcessing
public class UserBatchConfig {
    @Autowired
    DataSource dataSource;

    /**
     * 读取数据的实现  ，可以自定义实现
     * @return
     * @throws Exception
     */
    @Bean
    public ItemReader<User> reader( ) throws Exception {
        JdbcCursorItemReader<User> jdbcCursorItemReader=new JdbcCursorItemReader<>();
        jdbcCursorItemReader.setDataSource(dataSource);
        jdbcCursorItemReader.setSql("select * from user");
        jdbcCursorItemReader.setRowMapper(new BeanPropertyRowMapper<>(User.class));
        ExecutionContext executionContext=new ExecutionContext();
        jdbcCursorItemReader.open(executionContext);
        Object object=new Object();
        while (object!=null){
            object=jdbcCursorItemReader.read();
        }
        jdbcCursorItemReader.close();
        return jdbcCursorItemReader;
    }

    /**
     *  用来处理数据的接口  获取Reader 的数据 。并输出 对应的结构给writer
     * @return
     */
    @Bean
    public ItemProcessor<User,User> processor(){
        UserItemProcessor userItemProcessor = new UserItemProcessor();
        userItemProcessor.setValidator(user -> System.out.println(user.toString()));
        return userItemProcessor ;
    }

    /**
     * 用来输出数据 ,将 processor 处理后的数据进行输出
     * @return
     */
    @Bean
    public ItemWriter<User> writer(){
        //使用JDBC批处理的JdbcBatchItemWriter来写数据到数据库
        JdbcBatchItemWriter<User> itemWriter=new JdbcBatchItemWriter<>();
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        itemWriter.setDataSource(dataSource);
        //在此设置要执行批处理的SQL语句
        String sql="insert into user_1"+" (name,age,sex) "+"values( :name, :age, :sex)";
        itemWriter.setSql(sql);
        return itemWriter;
    }

    /**
     * 用来注册Job 的容器
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public JobRepository jobRepository(PlatformTransactionManager transactionManager) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType(DatabaseType.MYSQL.name());
        return jobRepositoryFactoryBean.getObject();
    }

    /**
     * 用来启动job 的接口
     * @param transactionManager
     * @return
     * @throws Exception
     */
    @Bean
    public SimpleJobLauncher jobLauncher( PlatformTransactionManager transactionManager) throws Exception{
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(this.jobRepository(transactionManager));
        return jobLauncher;
    }

    /**
     * job 监听接口
     * @return
     */
    @Bean
    public UserJobListener userJobListener(){
        return new UserJobListener();
    }

    /**
     *
     * @param jobs
     * @param step
     * @return
     */
    @Bean
    public Job importJob(JobBuilderFactory jobs, Step step){
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
     * @param stepBuilderFactory
     * @param reader
     * @param writer
     * @param processor
     * @return
     */
    @Bean
    public Step userStep(StepBuilderFactory stepBuilderFactory,
                         ItemReader<User> reader, ItemWriter<User> writer, ItemProcessor<User,User> processor){
        return stepBuilderFactory.get("userStep")
                //批处理每次提交的数据条数
                .<User, User>chunk(5000)
                //绑定 reader writer processor
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }



}
