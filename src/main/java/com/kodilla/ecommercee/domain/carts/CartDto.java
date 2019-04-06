package com.kodilla.ecommercee.domain.carts;

import com.kodilla.ecommercee.domain.products.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CartDto {

    private Long cartId;
    private List<ProductDto> products = new ArrayList<>();
}
