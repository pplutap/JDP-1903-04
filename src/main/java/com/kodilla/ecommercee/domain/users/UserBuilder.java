package com.kodilla.ecommercee.domain.users;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.orders.Order;

import java.util.List;

public class UserBuilder {
    private Long id;
    private String username;
    private boolean blocked;
    private Cart cart;
    private List<Order> orders;

    public UserBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setBlocked(boolean blocked) {
        this.blocked = blocked;
        return this;
    }

    public UserBuilder setCart(Cart cart) {
        this.cart = cart;
        return this;
    }

    public UserBuilder setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public User createUser() {
        return new User(id, username, blocked, cart, orders);
    }
}