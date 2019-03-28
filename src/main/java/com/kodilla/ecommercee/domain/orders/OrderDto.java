package com.kodilla.ecommercee.domain.orders;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private Long orderId;
    private List<Item> items = new ArrayList<>();

    public OrderDto(Long orderId, List<Item> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
