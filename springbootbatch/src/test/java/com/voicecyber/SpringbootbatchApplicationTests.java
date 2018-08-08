package com.voicecyber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootbatchApplicationTests {
	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job importJob;
	@Test
	public void contextLoads() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
		System.out.println("test 进行batch 任务手动调用");
		JobParameters jobParameters=new JobParameters();
		jobLauncher.run(importJob,jobParameters);
		System.out.println("test 进行batch 任务手动调用结束");
	}

}
