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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Group group;
    private Boolean deleted;
    private List<Cart> carts = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID", unique = true)
    public Long getProductId() {
        return productId;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    public Group getGroup() {
        return group;
    }

    @NotNull
    @Column(name = "DELETED")
    public Boolean getDeleted() {
        return deleted;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_PRODUCT_CART",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")}
    )
    public List<Cart> getCarts() {
        return carts;
    }
}
