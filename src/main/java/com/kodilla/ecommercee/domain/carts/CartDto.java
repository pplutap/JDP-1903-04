package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.products.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDto {
    private Long id;
    private Long userId;
    private List<ItemDto> product = Collections.emptyList();
}
