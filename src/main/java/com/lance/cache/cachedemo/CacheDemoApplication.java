package com.lance.cache.cachedemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Objects;

@SpringBootApplication
@MapperScan(basePackages = "com.lance.cache.cachedemo.common.mapper")
@EnableScheduling
public class CacheDemoApplication implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(CacheDemoApplication.class, args);
        ObjectMapper bean = applicationContext.getBean(ObjectMapper.class);
        Objects.nonNull(bean);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
