package edu.miu.cs590.orderservice.dto;

import edu.miu.cs590.orderservice.entity.Items;
import edu.miu.cs590.orderservice.entity.PaymentType;
import edu.miu.cs590.orderservice.entity.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

    private Long id;
    private String userId;
    private PaymentType paymentType;
    private String status;
    private List<Items> items;
    private ShippingAddress shippingAddressId;

}
