package com.lance.cache.cachedemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;

@EnableScheduling
@Configuration
@Slf4j
public class RefreshTaskScheduler {

    @Value("${repeat.key}")
    private String key;

    @PostConstruct
    public void show() {
        log.info("");
    }

    @Bean
    public TaskScheduler getTaskScheduler() {

        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        //taskScheduler.setThreadGroupName("Refresh Demo");
        taskScheduler.setThreadNamePrefix("refresher-");
        return taskScheduler;
    }
}
