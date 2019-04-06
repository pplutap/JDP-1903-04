package com.kodilla.ecommercee.domain.products;

import com.kodilla.ecommercee.domain.carts.Cart;
import com.kodilla.ecommercee.domain.groups.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long productId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "isDeleted")
    private boolean deleted;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Product(String name, String description, BigDecimal price, boolean deleted) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.deleted = deleted;
    }

}
