package edu.miu.cs590.orderservice.clients;


import edu.miu.cs590.orderservice.clients.config.PaymentFeignConfig;
import edu.miu.cs590.orderservice.entity.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url ="${payment.service.url}",configuration = PaymentFeignConfig.class)
public interface PaymentFeignClient {
    @PostMapping("/paypal")
    ResponseEntity<String> processPayPalPayment(@RequestBody PaymentRequest paymentRequest);
    @PostMapping("/cc")
    ResponseEntity<String> processCcPayment(@RequestBody PaymentRequest paymentRequest);

    @PostMapping("/bank")
    ResponseEntity<String> processBankPayment(@RequestBody PaymentRequest paymentRequest);
}
