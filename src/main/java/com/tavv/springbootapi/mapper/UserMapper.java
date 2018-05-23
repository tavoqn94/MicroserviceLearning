package com.tavv.springbootapi.mapper;

import com.tavv.springbootapi.domain.User;
import com.tavv.springbootapi.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {

    List<User> convertToEntities(List<UserDto> dtos);

    List<UserDto> convertToDtos(List<User> entities);

    User convertToEntity(UserDto dto);

    UserDto convertToDto(User entity);

}
