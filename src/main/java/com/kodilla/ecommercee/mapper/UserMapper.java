package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.users.User;
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
        return new User.UserBuilder().id(userDto.getId()).username(userDto.getUsername()).blocked(userDto.isBlocked()).cart(cartMapper.mapToCart(userDto.getCart())).orders(orderMapper.orderDtoListoToOrderList(userDto.getOrders())).build();
    }

    public UserDto userToUserDto(User user){
        return new UserDto(user.getUserId(), user.getUsername(), user.isBlocked(), cartMapper.mapToCartDto(user.getCart()), orderMapper.orderListToOrderDtoList(user.getOrders()));
    }
}
