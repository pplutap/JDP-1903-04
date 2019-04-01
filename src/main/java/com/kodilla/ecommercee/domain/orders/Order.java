package com.kodilla.ecommercee.domain.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private Long orderId;
    private Long userId;
    private List<Item> items = new ArrayList<>();
    private double price = 0;
    private boolean isPaid = false;
    private boolean isVerified = false;
    private boolean isSubmited = false;

    public Order(Long orderId, Long userId, List<Item> items) {
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
    }
}
