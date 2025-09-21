package com.User_and_Order_Management_Service.ResponseBuilder;


import com.User_and_Order_Management_Service.Exceptions.DataNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class responseBuilder {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message, HttpStatus status){
     ApiResponse<T> apiResponse = new ApiResponse<>(data,message,status);
    return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }
    public static <T> ResponseEntity<ApiResponse<T>> error(T data, String message, HttpStatus status){
        ApiResponse<T> apiResponse = new ApiResponse<>(data,message,status);
        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(RuntimeException runtimeException){
        ApiResponse<T> apiResponse = new ApiResponse<>(runtimeException.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiResponse,apiResponse.getStatus());
    }
}
