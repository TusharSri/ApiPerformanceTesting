package com.example.apiperformancetesting.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class TaskExecutorConfig {
    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(
                10, // core pool size
                20, // max pool size
                60L, TimeUnit.SECONDS, // keep-alive time for idle threads
                new LinkedBlockingQueue<>(), // task queue
                new ThreadPoolExecutor.CallerRunsPolicy() // reject policy
        );
    }
}