package com.springdata.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@Configuration
//@EnableAsync
//public class AsyncConfiguration {
//	
//    @Bean(name = "threadPoolTaskExecutor")
//    Executor aSyncExecutor() {
//        final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(3);
//        threadPoolTaskExecutor.setMaxPoolSize(3);
//        threadPoolTaskExecutor.setQueueCapacity(100);    
//        threadPoolTaskExecutor.setThreadNamePrefix("threadNamePrefix");
//        threadPoolTaskExecutor.initialize();
//        return threadPoolTaskExecutor;
//    }
//	
//
//
//}
