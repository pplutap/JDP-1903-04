package com.kodilla.ecommercee.domain.users;

import com.kodilla.ecommercee.domain.carts.CartDto;
import com.kodilla.ecommercee.domain.orders.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private boolean blocked;
    private CartDto cart;
    private List<OrderDto> orders = Collections.emptyList();
}