package edu.miu.cs590.orderservice.dto;

import lombok.Data;

@Data
public class ShippingAddressDto {

    private Long id;
    private Long OrderId;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Number zip;
    private String country;
}
