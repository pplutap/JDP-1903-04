package com.kodilla.ecommercee.domain.orders;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @NotNull
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private Integer quantity;

    public static class ItemBuilder {

        private Long productId;
        private String productName;
        private String productDescription;
        private BigDecimal price;
        private int quantity;

        public ItemBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public ItemBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ItemBuilder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public ItemBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ItemBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Item build() {
            return new Item(productId, productName, productDescription, price, quantity);
        }

    }

    private Item(@NotNull Long productId, String productName, String productDescription, BigDecimal price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
}
