package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.domain.users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderMapper orderMapper;

    public User userDtoToUser(UserDto userDto){
        return new User(userDto.getId(), userDto.getUsername(), userDto.isBlocked(), cartMapper.mapToCart(userDto.getCart()), orderMapper.orderDtoListoToOrderList(userDto.getOrders()));
    }

    public UserDto userToUserDto(User user){
        return new UserDto(user.getUserId(), user.getUsername(), user.isBlocked(), cartMapper.mapToCartDto(user.getCart()), orderMapper.orderListToOrderDtoList(user.getOrders()));
    }
}
