package com.kodilla.ecommercee.domain.product;

import com.kodilla.ecommercee.domain.cart.Cart;
import com.kodilla.ecommercee.domain.group.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id", unique = true)
    private Long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @NotNull
    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @NotNull
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_product_cart",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")}
    )
    private List<Cart> carts = new ArrayList<>();
}
