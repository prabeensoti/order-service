package edu.miu.cs590.orderservice.clients.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class PaymentFeignConfig {
    @Value("${payment.service.key}")
    public String serviceKey;

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            System.out.println(serviceKey);
            requestTemplate.header("API_KEY", serviceKey);
        };
    }

}
