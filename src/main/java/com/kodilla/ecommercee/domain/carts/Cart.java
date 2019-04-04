package com.kodilla.ecommercee.domain.carts;


import com.kodilla.ecommercee.domain.products.Product;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;


@NoArgsConstructor
@Entity(name = "cart")
@Setter
public class Cart {

    private Long cartId;
    private List<Product> products = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getCartId() {
        return cartId;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_cart_product",
            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}
    )
    public List<Product> getProducts() {
        return products;
    }




}
