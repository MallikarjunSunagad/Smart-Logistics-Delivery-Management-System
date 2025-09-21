package com.User_and_Order_Management_Service.Mappers;

import com.User_and_Order_Management_Service.Entites.Users;
import com.User_and_Order_Management_Service.RequestDtos.UserRequestDto;
import com.User_and_Order_Management_Service.ResponseDtos.UserResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-22T00:28:03+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Users toEntity(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setFirstName( userRequestDto.getFirstName() );
        users.setLastName( userRequestDto.getLastName() );
        users.setPhoneNumber( userRequestDto.getPhoneNumber() );
        users.setEmail( userRequestDto.getEmail() );
        users.setPassword( userRequestDto.getPassword() );

        return users;
    }

    @Override
    public UserResponseDto toDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId( users.getId() );
        userResponseDto.setFirstName( users.getFirstName() );
        userResponseDto.setLastName( users.getLastName() );
        userResponseDto.setPhoneNumber( users.getPhoneNumber() );
        userResponseDto.setEmail( users.getEmail() );
        userResponseDto.setCreatedAt( users.getCreatedAt() );

        return userResponseDto;
    }

    @Override
    public void updateEntityFromDto(UserRequestDto userRequestDto, Users usersEntity) {
        if ( userRequestDto == null ) {
            return;
        }

        usersEntity.setFirstName( userRequestDto.getFirstName() );
        usersEntity.setLastName( userRequestDto.getLastName() );
        usersEntity.setPhoneNumber( userRequestDto.getPhoneNumber() );
        usersEntity.setEmail( userRequestDto.getEmail() );
        usersEntity.setPassword( userRequestDto.getPassword() );
    }
}
