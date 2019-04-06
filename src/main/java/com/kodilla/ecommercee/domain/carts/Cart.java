package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "cart_name")
    private String cartName;

    @Column(name = "user_id")
    private Long userId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "join_cart_product",
            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
    )
    private List<Product> products = new ArrayList<>();

    public Cart(String cartName, Long userId, List<Product> products) {
        this.cartName = cartName;
        this.userId = userId;
        this.products = products;
    }
}
