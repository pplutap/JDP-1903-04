package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(nativeQuery = true)
    List<Order> findOpenOrders();

    @Modifying
    @Query(nativeQuery = true)
    void closeOrder(@Param("ID") Long id);
}