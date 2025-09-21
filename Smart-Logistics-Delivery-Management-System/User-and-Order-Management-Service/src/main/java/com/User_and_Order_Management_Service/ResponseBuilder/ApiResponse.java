package com.User_and_Order_Management_Service.ResponseBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private String message;
    private HttpStatus status;

    public ApiResponse(T data, String message, HttpStatus status) {
        this.success = true;
        this.data = data;
        this.message = message;
        this.status = status;
    }


    public ApiResponse(String message, HttpStatus status) {
        this.success = true;
        this.message = message;
        this.status = status;
    }
}
