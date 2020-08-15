package com.lance.cache.cachedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lance.cache.cachedemo.common.mapper")
public class CacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheDemoApplication.class, args);
    }

}
