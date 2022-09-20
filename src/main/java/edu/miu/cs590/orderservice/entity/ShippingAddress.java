package edu.miu.cs590.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Embeddable
public class ShippingAddress {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    private Long OrderId;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Number zip;
    private String country;

}