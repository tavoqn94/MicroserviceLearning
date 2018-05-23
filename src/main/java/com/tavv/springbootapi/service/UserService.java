package com.tavv.springbootapi.service;

import com.tavv.springbootapi.dto.UserDto;

import java.util.List;

public interface UserService {


    List<UserDto> getAllUser();

    void deleteAll();

    UserDto findOne(String userId);

    List<UserDto> findUserByName(String name);

    List<UserDto> findByDisplayName(String name);

    UserDto save(UserDto user);

    void delete(UserDto user);

}
