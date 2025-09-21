package com.User_and_Order_Management_Service.ResponseDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime createdAt;
}
