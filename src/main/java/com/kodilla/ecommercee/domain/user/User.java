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
@Getter
@Entity(name = "\"order\"")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true)
    private Long id;
    @NotNull
    @Column(name = "user_name")
    private String userName;
    @NotNull
    @Column(name = "user_key")
    private Long userKey;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @Column(name = "status")
    private Status status;
    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders = new ArrayList<>();


    enum Status{
        BANNED,
        NOT_BANNED
    }
}
