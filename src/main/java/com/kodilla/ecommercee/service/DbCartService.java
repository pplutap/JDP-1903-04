package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbCartService {
    private CartRepository cartRepository;

    @Autowired
    public DbCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCartById(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
