package com.kodilla.ecommercee.domain.users;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.orders.Order;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "is_blocked")
    private boolean blocked;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Order> orders = new ArrayList<>();

    public User(Long id, String username, boolean blocked, Cart cart, List<Order> orders) {
        this.userId = id;
        this.username = username;
        this.blocked = blocked;
        this.cart = cart;
        this.orders = orders;
    }
}