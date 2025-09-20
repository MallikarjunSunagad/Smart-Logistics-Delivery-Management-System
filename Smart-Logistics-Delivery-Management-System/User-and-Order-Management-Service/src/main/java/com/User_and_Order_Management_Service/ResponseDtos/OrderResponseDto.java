package com.User_and_Order_Management_Service.ResponseDtos;

import com.User_and_Order_Management_Service.Entites.Address;
import com.User_and_Order_Management_Service.Entites.Products;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDto {

    private UserResponseDto userResponseDto;
    private Products products;
    private Address address;
    private LocalDateTime createdAt;
}
