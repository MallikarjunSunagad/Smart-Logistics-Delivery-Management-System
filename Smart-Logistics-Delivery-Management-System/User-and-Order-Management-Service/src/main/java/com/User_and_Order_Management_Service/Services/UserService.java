package com.User_and_Order_Management_Service.Services;

import com.User_and_Order_Management_Service.RequestDtos.UserRequestDto;
import com.User_and_Order_Management_Service.ResponseBuilder.PageResponse;
import com.User_and_Order_Management_Service.ResponseDtos.UserResponseDto;

import java.util.List;

public interface UserService {

    public UserResponseDto createUser(UserRequestDto userRequestDto);
    public UserResponseDto getUserById(Long id);
    public PageResponse<UserResponseDto> getAllUsers(int page, int size);
    public UserResponseDto updateUserById(UserRequestDto userRequestDto, Long id);
    public String deleteUserById(Long id);
}
