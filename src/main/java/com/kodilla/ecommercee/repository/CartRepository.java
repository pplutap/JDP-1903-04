package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.carts.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CartRepository extends CrudRepository<Cart, Long > {
    @Override
    Cart save(Cart cart);

    @Override
    void deleteById(Long cartId);
}
