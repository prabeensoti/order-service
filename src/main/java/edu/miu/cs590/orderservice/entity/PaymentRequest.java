package edu.miu.cs590.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private Long userId;
    private String paypalId;
    private String creditCardNumber;
    private Long orderId;
    private Double balance;

    private String bankAccNumber;

}
