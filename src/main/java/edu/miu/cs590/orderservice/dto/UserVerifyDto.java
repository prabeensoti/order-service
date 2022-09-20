package edu.miu.cs590.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVerifyDto {
    private String email;
}
