package com.lance.cache.cachedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@EnableScheduling
@Configuration
public class RefreshTaskScheduler {
    @Bean
    public TaskScheduler getTaskScheduler() {

        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        //taskScheduler.setThreadGroupName("Refresh Demo");
        taskScheduler.setThreadNamePrefix("refresher-");
        return taskScheduler;
    }
}
