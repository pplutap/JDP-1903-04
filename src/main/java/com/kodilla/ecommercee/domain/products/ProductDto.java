package com.kodilla.ecommercee.domain.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean deleted;
    private int quantity;

    public static class ProductDtoBuilder {
        private long productId;
        private String name;
        private String description;
        private BigDecimal price;
        private int quantity;
        private boolean deleted;

        public ProductDtoBuilder productId(long productId) {
            this.productId = productId;
            return this;
        }

        public ProductDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductDtoBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductDtoBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductDtoBuilder deleted() {
            this.deleted = false;
            return this;
        }

        public ProductDto build() {
            return new ProductDto(name, description, deleted, price, quantity);
        }
    }

    private ProductDto(String name, String description, boolean deleted, BigDecimal price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.deleted = deleted;
        this.quantity = quantity;
    }
}