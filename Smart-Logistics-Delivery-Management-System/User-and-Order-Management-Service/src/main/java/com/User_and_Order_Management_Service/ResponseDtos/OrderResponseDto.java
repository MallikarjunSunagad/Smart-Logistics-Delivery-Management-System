package com.User_and_Order_Management_Service.ResponseDtos;

import com.User_and_Order_Management_Service.RequestDtos.AddressDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDto {

    private UserResponseDto userDetails;
    private ProductResponseDto product;
    private Integer quantity;
    private AddressDto address;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private LocalDateTime createdAt;
}
