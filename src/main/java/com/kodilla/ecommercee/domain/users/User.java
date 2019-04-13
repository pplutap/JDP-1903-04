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

    private User(Long id, String username, boolean blocked, Cart cart, List<Order> orders) {
        this.userId = id;
        this.username = username;
        this.blocked = blocked;
        this.cart = cart;
        this.orders = orders;
    }


    private User(String username, boolean blocked, Cart cart, List<Order> orders) {
        this.username = username;
        this.blocked = blocked;
        this.cart = cart;
        this.orders = orders;
    }


    public static class UserBuilder {
        private Long id;
        private String username;
        private boolean blocked;
        private Cart cart;
        private List<Order> orders;

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder blocked(boolean blocked) {
            this.blocked = blocked;
            return this;
        }

        public UserBuilder cart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public UserBuilder orders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        public User build() {
            if (orders == null){
                orders = new ArrayList<>();
            }
            if(id==null){
                return new User(username, blocked, cart, orders);
            }
            return new User(id, username, blocked, cart, orders);
        }
    }
}