package com.kodilla.ecommercee.domain.products;

import com.kodilla.ecommercee.domain.groups.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Column(name = "is_deleted")
    private boolean deleted;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


    public static class ProductBuilder {
        private String name;
        private String description;
        private BigDecimal price;
        private int quantity;
        private boolean deleted;


        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder deleted() {
            this.deleted = false;
            return this;
        }

        public Product build() {
            return new Product(name, description, deleted, price, quantity);
        }
    }

    private Product(String name, String description, boolean deleted, BigDecimal price, int quantity) {
        this.name = name;
        this.description = description;
        this.deleted = deleted;
        this.price = price;
        this.quantity = quantity;
    }
}