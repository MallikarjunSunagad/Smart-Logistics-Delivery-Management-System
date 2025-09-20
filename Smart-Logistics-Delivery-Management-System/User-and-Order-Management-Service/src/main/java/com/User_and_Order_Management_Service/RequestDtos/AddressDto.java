package com.User_and_Order_Management_Service.RequestDtos;


import lombok.Data;

@Data
public class AddressDto {
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
