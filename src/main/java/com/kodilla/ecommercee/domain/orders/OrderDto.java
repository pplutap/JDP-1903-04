package com.kodilla.ecommercee.domain.orders;

import com.kodilla.ecommercee.domain.products.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private Long orderId;
    private Long userId;
    private List<ProductDto> productDtos = new ArrayList<>();
}
