package com.kodilla.ecommercee.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long itemId;
    private OrderDto order;
    private Long productId;
    private String productName;
    private String productDescription;
    private Double price;
    private Double quantity;
}
