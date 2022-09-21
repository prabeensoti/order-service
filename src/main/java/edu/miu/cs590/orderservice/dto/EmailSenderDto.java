package edu.miu.cs590.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailSenderDto {
    private String sender;
    private String to;
    private String subject;
    private String message;
}
