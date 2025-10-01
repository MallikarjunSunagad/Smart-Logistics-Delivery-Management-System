package com.User_and_Order_Management_Service.RequestDtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDto {
    private String productName;
    private BigDecimal price;
}
