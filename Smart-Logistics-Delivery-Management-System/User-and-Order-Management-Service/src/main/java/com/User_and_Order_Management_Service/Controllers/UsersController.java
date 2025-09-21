package com.User_and_Order_Management_Service.Controllers;


import com.User_and_Order_Management_Service.RequestDtos.UserRequestDto;
import com.User_and_Order_Management_Service.ResponseBuilder.ApiResponse;
import com.User_and_Order_Management_Service.ResponseDtos.UserResponseDto;
import com.User_and_Order_Management_Service.UserService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.User_and_Order_Management_Service.ResponseBuilder.responseBuilder;

import java.util.List;

import static com.User_and_Order_Management_Service.constants.UserConfigurationConstants.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user-management")
public class UsersController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto user = userService.createUser(userRequestDto);
        return responseBuilder.success(user,USER_CREATED, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getAllUsers(){
        List<UserResponseDto> allUsers = userService.getAllUsers();
        return responseBuilder.success(allUsers,RETRIEVE_USERS,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUsersById(@PathVariable Long id){
        UserResponseDto userById = userService.getUserById(id);
        return responseBuilder.success(userById,RETRIEVE_USERS_BY_ID,HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUserById(@RequestBody UserRequestDto userRequestDto, @PathVariable Long id){
        UserResponseDto updatedUserById = userService.updateUserById(userRequestDto, id);
        return responseBuilder.success(updatedUserById,UPDATED_USERS_BY_ID,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUserById(@PathVariable Long id){
        String deletedUserMessage = userService.deleteUserById(id);
        return responseBuilder.success(deletedUserMessage,DELETED_USERS_BY_ID,HttpStatus.OK);
    }
}
