package com.kodilla.ecommercee.domain.orders;

import com.kodilla.ecommercee.domain.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;
    @NotNull
    @Column(name = "date")
    private Date date;
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
    @NotNull
    @Column(name = "isPaid")
    private Boolean paid;
}