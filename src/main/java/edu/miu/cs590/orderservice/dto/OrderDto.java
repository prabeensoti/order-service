package edu.miu.cs590.orderservice.dto;

import edu.miu.cs590.orderservice.entity.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private Long id;
    private Long userId;
    private PaymentType paymentType;
    private String status;
    private List<ItemsDto> items;
    private ShippingAddressDto shippingAddress;
}
