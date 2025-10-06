package com.User_and_Order_Management_Service.Mappers;

import com.User_and_Order_Management_Service.Entites.Users;
import com.User_and_Order_Management_Service.RequestDtos.UserRequestDto;
import com.User_and_Order_Management_Service.ResponseDtos.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    Users toEntity(UserRequestDto userRequestDto);

    UserResponseDto toDto(Users users);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(UserRequestDto userRequestDto, @MappingTarget Users usersEntity);
}
