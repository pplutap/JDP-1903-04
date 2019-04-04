package com.kodilla.ecommercee.domain.users;

import com.kodilla.ecommercee.domain.carts.Cart;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity(name = "user")
@Setter
public class User {
    private Long id;
    private String username;
    private boolean status;
    private Cart cart;

    public User(String username, boolean status, Cart cart) {
        this.username = username;
        this.status = status;
        this.cart = cart;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    @Column(name = "status")
    public boolean isStatus() {
        return status;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }
}
