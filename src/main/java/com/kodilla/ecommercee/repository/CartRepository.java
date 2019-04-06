package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.carts.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}