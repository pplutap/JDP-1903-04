package com.kodilla.ecommercee.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long productId) {
        super(String.format("There is no product with id equals: %s in Data Base", productId));
    }
}
