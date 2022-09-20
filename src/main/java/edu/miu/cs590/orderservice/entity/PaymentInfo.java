package edu.miu.cs590.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {

 private String paypalId;
 private String creditCardNumber;
 private String bankAccNumber;
}
