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
@Entity
@Table(name = "\"group\"")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> productsInGroup = new ArrayList<>();

    public Group(String groupName, List<Product> productsInGroup) {
        this.groupName = groupName;
        this.productsInGroup = productsInGroup;
    }
}