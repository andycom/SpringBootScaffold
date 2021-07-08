package com.fancv.config;

import com.google.common.util.concurrent.RateLimiter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hamish-wu
 */
@Configuration
@Data
public class GuavaConfig {
    @Value("${guava.limit}")
    private Double limit;


    @Bean(name = "myRate")
    @ConditionalOnMissingBean
    public RateLimiter myService() {
        return RateLimiter.create(this.getLimit());
    }

}
