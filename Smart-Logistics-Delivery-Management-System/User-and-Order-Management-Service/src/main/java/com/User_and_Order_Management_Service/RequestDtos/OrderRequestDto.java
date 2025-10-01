package com.User_and_Order_Management_Service.RequestDtos;


import com.User_and_Order_Management_Service.Entites.Address;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;

@Data
public class OrderRequestDto {
    @NonNull
    private Long userId;
    @NonNull
    private Long productId;
    @NonNull
    @Min(value = 1)
    private Integer quantity;
    @NonNull
    private AddressDto address;
}
