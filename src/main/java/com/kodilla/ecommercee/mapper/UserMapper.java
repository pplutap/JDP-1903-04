package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.domain.users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private CartMapper cartMapper;

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getUsername(), userDto.isBlocked());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getUserId(), user.getUsername(), user.isBlocked());
    }
}
