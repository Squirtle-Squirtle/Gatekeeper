package com.gatekeeper.dynamicgatewayservice;

import org.springframework.cloud.gateway.filter.ratelimit.*;
import org.springframework.context.annotation.*;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(5, 10);  // 5 req/sec, burst 10
    }

    @Bean
    public KeyResolver userKeyResolver() {
        return exchange ->
                Mono.just(exchange.getRequest().getHeaders().getFirst("X-User-ID"));
    }
}
