package com.kodilla.ecommercee.domain;

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
public class GroupDto {
    private Long groupId;
    private String groupName;
    private List<ProductDto> productsInGroup = new ArrayList<>();
}
