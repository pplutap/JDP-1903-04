package com.kodilla.ecommercee.domain.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ITEM")
public class Item {
    private Long itemId;
    private Order order;
    private Long productId;
    private String productName;
    private String productDescription;
    private Double price;
    private Double quantity;
}
