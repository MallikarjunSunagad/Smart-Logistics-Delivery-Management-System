package com.User_and_Order_Management_Service.RequestDtos;


import com.User_and_Order_Management_Service.Entites.Address;
import lombok.Data;

@Data
public class OrderRequestDto {
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Address address;
}
