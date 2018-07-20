package com.sean;

import com.sean.config.AsyncTask;
import com.sean.config.TaskExecutorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
/**
 * Created by Sean on 2017/11/10.
 *
 * @author Sean
 */
public class SpringbootthreadApplication {

    public static void main(String[] args) {
      SpringApplication.run(SpringbootthreadApplication.class, args);
    }
}
