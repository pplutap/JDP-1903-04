package com.kodilla.ecommercee.domain.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isDeleted;
}
