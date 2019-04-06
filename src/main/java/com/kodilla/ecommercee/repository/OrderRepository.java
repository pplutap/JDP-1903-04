package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.orders.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}