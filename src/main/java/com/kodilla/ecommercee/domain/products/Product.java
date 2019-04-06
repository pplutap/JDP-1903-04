package com.kodilla.ecommercee.domain.products;


import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.groups.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "product")
public class Product {

    public Product(String name, String description, Group group) {
        this.name = name;
        this.description = description;
        this.group = group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
