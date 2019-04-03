package com.kodilla.ecommercee.domain.cart;

import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CART")
public class Cart {
    private Long cartId;
    private List<Product> products = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID", unique = true)
    public Long getCartId() {
        return cartId;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    public List<Product> getProducts() {
        return products;
    }
}
