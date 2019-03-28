package com.kodilla.ecommercee.domain.orders;

import java.math.BigDecimal;

public class Item {
    private final Long productId;
    private final double quantity;
    private final BigDecimal productPrice;

    public Item(Long productId, double quantity, BigDecimal productPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }
}
