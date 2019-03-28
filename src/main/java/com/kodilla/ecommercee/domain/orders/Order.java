package com.kodilla.ecommercee.domain.orders;

import java.util.ArrayList;
import java.util.List;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isSubmited() {
        return isSubmited;
    }

    public void setSubmited(boolean submited) {
        isSubmited = submited;
    }
}
