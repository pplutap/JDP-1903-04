package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.domain.users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private CartMapper cartMapper;

    @Autowired
    public UserMapper(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public User userDtoToUser(UserDto userDto){
        return new User(userDto.getUsername());
    }

    public UserDto userToUserDto(User user){
        return new UserDto(user.getUserId(), user.getUsername(), user.isBlocked(), cartMapper.mapToCartDto(user.getCart()), user.getOrders());
    }
}
