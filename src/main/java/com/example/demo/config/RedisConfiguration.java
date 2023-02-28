package com.example.demo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jj
 */
@Configuration
public class RedisConfiguration {
    @Bean
    public RedissonClient redissonClient() {
        return Redisson.create();
    }
}
