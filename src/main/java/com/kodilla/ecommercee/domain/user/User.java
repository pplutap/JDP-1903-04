package com.kodilla.ecommercee.domain.user;

import com.kodilla.ecommercee.domain.cart.Cart;
import com.kodilla.ecommercee.domain.order.Item;
import com.kodilla.ecommercee.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "USER")
public class User {
    private Long userId;
    private String userName;
    private Long userKey;
    private Cart cart;
    private List<Order> orders = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    public Long getUserId() {
        return userId;
    }

    @NotNull
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    @NotNull
    @Column(name = "USER_KEY")
    public Long getUserKey() {
        return userKey;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Order> getOrders() {
        return orders;
    }
}
