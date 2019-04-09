package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.products.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    @Override
    List<Cart> findAll();

}