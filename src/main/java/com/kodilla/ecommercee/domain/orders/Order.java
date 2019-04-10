package com.kodilla.ecommercee.domain.orders;

import com.kodilla.ecommercee.domain.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
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

    public Order(LocalDate date, boolean paid) {
        this.date = date;
        this.paid = paid;
    }

    public Order(LocalDate date, User user, List<Item> items, boolean paid) {
        this.date = date;
        this.user = user;
        this.items = items;
        this.paid = paid;
    }
}