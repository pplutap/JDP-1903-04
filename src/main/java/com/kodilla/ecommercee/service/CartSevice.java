package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartSevice {

    @Autowired
    CartRepository cartRepository;

    public List<Cart> getCarts() {
        return (List<Cart>) cartRepository.findAll();
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
