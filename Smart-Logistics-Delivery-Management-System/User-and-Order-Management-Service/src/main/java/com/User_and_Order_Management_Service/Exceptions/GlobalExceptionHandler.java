package com.User_and_Order_Management_Service.Exceptions;


import com.User_and_Order_Management_Service.ResponseBuilder.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.User_and_Order_Management_Service.ResponseBuilder.responseBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public @ResponseBody ResponseEntity<ApiResponse<Object>> handleDataNotFoundException(DataNotFoundException exception){
        log.error(exception.getMessage(),exception);
        return responseBuilder.error(exception);
    }

    @ExceptionHandler(ConflictException.class)
    public @ResponseBody ResponseEntity<ApiResponse<Object>> handleConflictException(ConflictException exception){
        log.error(exception.getMessage(),exception);
        return responseBuilder.error(exception);
    }
}
