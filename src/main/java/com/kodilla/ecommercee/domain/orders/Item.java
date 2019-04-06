package com.kodilla.ecommercee.domain.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id", unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @NotNull
    @Column(name = "product_id")
    private Long productId;
    @NotNull
    @Column(name = "product_name")
    private String productName;
    @NotNull
    @Column(name = "product_description")
    private String productDescription;
    @NotNull
    @Column(name = "price")
    private Double price;
    @NotNull
    @Column(name = "quantity")
    private Double quantity;
}