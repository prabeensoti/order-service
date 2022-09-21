package edu.miu.cs590.orderservice.clients.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class NotificationFeignConfig {
    @Value("${order.notification.secret.key}")
    public String serviceKey;

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("API_KEY", serviceKey);
        };
    }
}
