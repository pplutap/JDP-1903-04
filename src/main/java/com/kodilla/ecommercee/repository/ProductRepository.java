package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();
}