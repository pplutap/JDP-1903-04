package com.kodilla.ecommercee.domain.users;

import com.kodilla.ecommercee.domain.carts.CartDto;
import com.kodilla.ecommercee.domain.orders.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private String userMail;
    private boolean blocked;
    private CartDto cart;
    private List<Order> orders = new ArrayList<>();

    public UserDto(String username, String userMail) {

        this.username = username;
        this.userMail = userMail;
    }
}