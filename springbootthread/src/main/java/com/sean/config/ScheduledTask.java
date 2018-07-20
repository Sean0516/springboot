package com.sean.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Sean on 2018/7/20
 *
 * @author Sean
 */
@Component
public class ScheduledTask {
    @Scheduled(fixedRate = 2000)
    public void scheduleTaskOne() {
        System.out.println("每隔五秒执行一次的定时任务" + new Date());
    }

    @Scheduled(fixedDelay = 2000)
    public void scheduleTaskTwo() {
        System.out.println("上一次执行完毕时间点后1秒再次执行" + new Date());
    }
}
