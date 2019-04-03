package com.kodilla.ecommercee.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ITEM")
public class Item {
    private Long itemId;
    private Order order;
    private Long productId;
    private String productName;
    private String productDescription;
    private Double price;
    private Double quantity;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ITEM_ID", unique = true)
    public Long getItemId() {
        return itemId;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    @NotNull
    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    @NotNull
    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    @NotNull
    @Column(name = "PRODUCT_DESCRIPTION")
    public String getProductDescription() {
        return productDescription;
    }

    @NotNull
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }

    @NotNull
    @Column(name = "QUANTITY")
    public Double getQuantity() {
        return quantity;
    }

}
