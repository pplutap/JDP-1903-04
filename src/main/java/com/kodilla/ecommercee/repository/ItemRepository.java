package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.orders.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    @Override
    List<Item> findAll();
}
