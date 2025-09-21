package com.User_and_Order_Management_Service.ServiceImpl;

import com.User_and_Order_Management_Service.Entites.Users;
import com.User_and_Order_Management_Service.Exceptions.ConflictException;
import com.User_and_Order_Management_Service.Exceptions.DataNotFoundException;
import com.User_and_Order_Management_Service.Mappers.UserMapper;
import com.User_and_Order_Management_Service.Repository.UserRepository;
import com.User_and_Order_Management_Service.RequestDtos.UserRequestDto;
import com.User_and_Order_Management_Service.ResponseDtos.UserResponseDto;
import com.User_and_Order_Management_Service.UserService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        if (userRepository.findByPhoneNumber(userRequestDto.getPhoneNumber()).isPresent()) {
            throw new ConflictException("Phone number already exists.");
        }

        if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new ConflictException("Email address already exists.");
        }
        Users entityUser = userMapper.toEntity(userRequestDto);
        return userMapper.toDto(userRepository.save(entityUser));
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        Users userById = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + id + " not found!"));
        return userMapper.toDto(userById);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<Users> all = userRepository.findAll();
        return all.stream().map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateUserById(UserRequestDto userRequestDto, Long id) {
        Users userById = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + id + " not found!"));
        userMapper.updateEntityFromDto(userRequestDto,userById);
        return userMapper.toDto(userRepository.save(userById));
    }

    @Override
    public String deleteUserById(Long id) {
        Users userById = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + id + " not found!"));
        userRepository.delete(userById);
        return "User Deleted Successfully!";
    }
}
