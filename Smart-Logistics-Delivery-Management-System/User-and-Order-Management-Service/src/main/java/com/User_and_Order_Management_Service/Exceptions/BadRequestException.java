package com.User_and_Order_Management_Service.Exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
