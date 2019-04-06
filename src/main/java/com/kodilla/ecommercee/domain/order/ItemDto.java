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
<<<<<<< HEAD
    private OrderDto order;
=======
    private Order order;
>>>>>>> 1f8caf8cd7ad7c4f02648906c5c592607332b89f
    private Long productId;
    private String productName;
    private String productDescription;
    private Double price;
    private Double quantity;
}
