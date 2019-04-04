package com.kodilla.ecommercee.domain.users;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.orders.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

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

    public User(String username, boolean blocked, Cart cart) {
        this.username = username;
        this.blocked = blocked;
        this.cart = cart;
    }

}
