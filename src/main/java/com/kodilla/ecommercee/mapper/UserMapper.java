package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.users.User;
import com.kodilla.ecommercee.domain.users.UserBuilder;
import com.kodilla.ecommercee.domain.users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private CartMapper cartMapper;
    private OrderMapper orderMapper;

    @Autowired
    public UserMapper(CartMapper cartMapper, OrderMapper orderMapper) {
        this.cartMapper = cartMapper;
        this.orderMapper = orderMapper;
    }

    public User userDtoToUser(UserDto userDto){
        return new UserBuilder().setId(userDto.getId()).setUsername(userDto.getUsername()).setBlocked(userDto.isBlocked()).setCart(cartMapper.mapToCart(userDto.getCart())).setOrders(orderMapper.orderDtoListoToOrderList(userDto.getOrders())).createUser();
    }

    public UserDto userToUserDto(User user){
        return new UserDto(user.getUserId(), user.getUsername(), user.isBlocked(), cartMapper.mapToCartDto(user.getCart()), orderMapper.orderListToOrderDtoList(user.getOrders()));
    }
}
