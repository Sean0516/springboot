package com.sean;

import com.sean.config.AsyncTask;
import com.sean.config.TaskExecutorConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootthreadApplicationTests {
	@Autowired
	AsyncTask asyncTask;
	@Autowired
	TaskExecutorConfig taskExecutorConfig;

	@Test
	public void contextLoads() {
		asyncTask.sayHello("hello");
		asyncTask.getName("sean");
		try {
			Thread.sleep(1000*2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testExecutor(){
		Callable callable= () -> "hello";
		Runnable runnable= () -> System.out.println("hello world");
		ThreadPoolTaskExecutor  asyncExecutor = (ThreadPoolTaskExecutor)taskExecutorConfig.getAsyncExecutor();
		asyncExecutor.execute(runnable);
		Future<String> submit = asyncExecutor.submit(callable);
		try {
			String s = submit.get();
			System.out.println(s+"))))");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		asyncExecutor.shutdown();
	}

}
