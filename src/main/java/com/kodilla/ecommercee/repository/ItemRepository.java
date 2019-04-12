package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.orders.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
