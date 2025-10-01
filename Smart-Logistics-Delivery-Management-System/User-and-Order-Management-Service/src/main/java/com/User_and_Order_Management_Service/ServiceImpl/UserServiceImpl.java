package com.User_and_Order_Management_Service.ServiceImpl;

import com.User_and_Order_Management_Service.Entites.Orders;
import com.User_and_Order_Management_Service.Entites.Users;
import com.User_and_Order_Management_Service.Exceptions.BadRequestException;
import com.User_and_Order_Management_Service.Exceptions.ConflictException;
import com.User_and_Order_Management_Service.Exceptions.DataNotFoundException;
import com.User_and_Order_Management_Service.Mappers.UserMapper;
import com.User_and_Order_Management_Service.Repository.UserRepository;
import com.User_and_Order_Management_Service.RequestDtos.UserRequestDto;
import com.User_and_Order_Management_Service.ResponseBuilder.PageResponse;
import com.User_and_Order_Management_Service.ResponseDtos.UserResponseDto;
import com.User_and_Order_Management_Service.Services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
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
        log.info("User with user id:{} created successfully!",entityUser.getId());
        return userMapper.toDto(userRepository.save(entityUser));
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        Users userById = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + id + " not found!"));
        log.info("Fetching the user details with user id:{} \n user details: {}",id,userById);
        return userMapper.toDto(userById);
    }

    @Override
    @Cacheable(value = "users")
    public PageResponse<UserResponseDto> getAllUsers(int page, int size) {
        validatePageableParams(page,size);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Users> usersPages = userRepository.findAll(pageRequest);

        List<UserResponseDto> list = usersPages.stream().map(userMapper::toDto)
                .toList();
        log.info("Fetching all the users details: {}",list);
        return new PageResponse<>(
                list,
                usersPages.getNumber(),
                usersPages.getSize(),
                usersPages.getTotalElements(),
                usersPages.getTotalPages()
        );
    }

    @Override
    public UserResponseDto updateUserById(UserRequestDto userRequestDto, Long id) {
        Users userById = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + id + " not found!"));
        userMapper.updateEntityFromDto(userRequestDto,userById);
        log.info("Updated the user details with user id:{}",id);
        return userMapper.toDto(userRepository.save(userById));
    }

    @Override
    public String deleteUserById(Long id) {
        Users userById = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + id + " not found!"));
        userRepository.delete(userById);
        log.info("User with user id: {} deleted successfully!",id);
        return "User Deleted Successfully!";
    }

    private void validatePageableParams(int page, int size){
        if (page<0 || size<1){
            throw new BadRequestException("Invalid Page and size parameters");
        }
    }
}
