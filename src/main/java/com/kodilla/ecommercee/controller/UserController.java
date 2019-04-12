package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommercee.domain.users.GuavaCacheService;
import com.kodilla.ecommercee.domain.users.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.userDtoToUser(userDto));
    }

    @PutMapping(value = "blockUser")
    public UserDto blockUser(@RequestParam Long id) throws UserNotFoundException {
        return userMapper.userToUserDto(userService.blockUser(id));
    }

    @GetMapping(value = "getToken")
    public Long getToken(@RequestParam Long userId) throws UserNotFoundException, ExecutionException {
        return GuavaCacheService.getUserCache().get(userService.getUserById(userId));
    }
}