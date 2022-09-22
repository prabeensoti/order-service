package edu.miu.cs590.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Embeddable
public class ShippingAddress {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Number zip;
    private String country;
}