package com.kodilla.ecommercee.domain.groups;

import com.kodilla.ecommercee.domain.products.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long groupId;

    @Column(name = "name")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> productsInGroup = new ArrayList<>();

    public Group(String name, List<Product> productsInGroup) {
        this.name = name;
        this.productsInGroup = productsInGroup;
    }
}