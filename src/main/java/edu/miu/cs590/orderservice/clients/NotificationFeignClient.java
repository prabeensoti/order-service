package edu.miu.cs590.orderservice.clients;

import edu.miu.cs590.orderservice.clients.config.NotificationFeignConfig;
import edu.miu.cs590.orderservice.dto.EmailSenderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url ="${notification.service.url}",configuration = NotificationFeignConfig.class)
public interface NotificationFeignClient {

    @PostMapping("/email/push")
    String paymentNotification(@RequestBody EmailSenderDto emailSenderDto);
}
