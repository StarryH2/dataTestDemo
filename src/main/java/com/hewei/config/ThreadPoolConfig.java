package com.hewei.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author HeWei
 * @Date: 2021/08/05/14:00
 * @Description:
 */
@Component
@Configuration
//@ConfigurationProperties(prefix = "threadpool")
@Lazy
public class ThreadPoolConfig {

    /**
     * 核心线程数
     */
    private int corenum;

    /**
     * 最大线程数
     */
    private int maxnum;

    /**
     * 超时时间
     */
    private int keeplive;

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8,14,500, TimeUnit.SECONDS,new LinkedBlockingDeque<>(2000));
        return threadPoolExecutor;
    }

}
