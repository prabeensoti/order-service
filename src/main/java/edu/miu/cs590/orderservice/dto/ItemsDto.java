package edu.miu.cs590.orderservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemsDto {

    private Long id;
    private Long productId;
    private Long quantity;
    private Double discount;
    private Double price;
    private Double tax;
}
