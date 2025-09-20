package com.User_and_Order_Management_Service.RequestDtos;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}
