package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.orders.Item;
import com.kodilla.ecommercee.domain.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long cartId;

    @ElementCollection
    private List<Item> items = new ArrayList<>();
}