package com.kodilla.ecommercee.domain.orders;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.users.User;
import lombok.*;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Order.findOpenOrders",
        query = "SELECT * FROM `ORDER` WHERE is_closed = FALSE",
        resultClass = Order.class
)

@NamedNativeQuery(
        name = "Order.closeOrder",
        query = "UPDATE `ORDER` SET is_closed = TRUE WHERE id = :ID",

        resultClass = Order.class
)

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Item> items = new ArrayList<>();
    @Column(name = "is_paid")
    private boolean paid;
    @Column(name = "is_closed")
    private boolean closed;

    public static class OrderBuilder {

        private LocalDate date;
        private boolean closed;
        private boolean paid;
        private List<Item> items = new ArrayList<>();
        private User user;

        public OrderBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public OrderBuilder closed(boolean closed) {
            this.closed = closed;
            return this;
        }

        public OrderBuilder paid(boolean paid) {
            this.paid = paid;
            return this;
        }

        public OrderBuilder items(List<Item> items) {
            this.items = items;
            return this;
        }

        public OrderBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Order buldWithoutUser() {
            return new Order(date, items, paid, closed);
        }

        public Order buildWithUser() {
            return new Order(date, user, items, paid, closed);
        }

    }

    private Order(LocalDate date, List<Item> items, boolean paid, boolean closed) {
        this.date = date;
        this.paid = paid;
        this.closed = closed;
    }

    private Order(LocalDate date, User user, List<Item> items, boolean paid, boolean closed) {
        this.date = date;
        this.user = user;
        this.items = items;
        this.paid = paid;
        this.closed = closed;
    }
}