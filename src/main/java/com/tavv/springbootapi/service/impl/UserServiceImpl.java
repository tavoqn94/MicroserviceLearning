package com.tavv.springbootapi.service.impl;

import com.tavv.springbootapi.domain.User;
import com.tavv.springbootapi.dto.UserDto;
import com.tavv.springbootapi.mapper.UserMapper;
import com.tavv.springbootapi.repository.UserRepository;
import com.tavv.springbootapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAllUser() {
        return userMapper.convertToDtos(userRepository.findAll());
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UserDto  findOne(String userId) {
        return userMapper.convertToDto(userRepository.findByUserId(userId));
    }

    @Override
    public List<UserDto> findUserByName(String name) {
        return userMapper.convertToDtos(userRepository.findByUserName(name));
    }

    @Override
    public List<UserDto> findByDisplayName(String name) {
        return userMapper.convertToDtos(userRepository.findByDisplayName(name));
    }

    @Override
    @Transactional(readOnly = false)
    public UserDto save(UserDto user) {
        User model = userMapper.convertToEntity(user);
        model = userRepository.save(model);
        return userMapper.convertToDto(model);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(UserDto user) {
        User model = userMapper.convertToEntity(user);
    }


}