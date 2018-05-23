package com.tavv.springbootapi.controller;

import com.tavv.springbootapi.dto.UserDto;
import com.tavv.springbootapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<UserDto> findAll(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
    public List<UserDto> findByUserName(@RequestParam(value = "userName", required = true) String userName){
        return userService.findUserByName(userName);
    }

    @RequestMapping(value = "/findByDisplayName", method = RequestMethod.GET)
    public List<UserDto> findByDisplayName(@RequestParam(value = "displayName", required = true) String displayName){
        return userService.findByDisplayName(displayName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserDto save(@RequestBody UserDto user){
        return userService.save(user);
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody UserDto user){
        userService.delete(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserDto findByUserId(@PathVariable(value = "userId") String userId){
        return userService.findOne(userId);
    }
}
