package com.kodilla.ecommercee.domain.group;

import com.kodilla.ecommercee.domain.product.ProductDto;
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
public class GroupDto {
    private Long id;
    private String groupName;
    private List<ProductDto> productsInGroup = new ArrayList<>();
}
