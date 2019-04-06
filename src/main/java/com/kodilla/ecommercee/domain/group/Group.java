package com.kodilla.ecommercee.domain.group;

import com.kodilla.ecommercee.domain.order.Item;
import com.kodilla.ecommercee.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "group_id", unique = true)
    private Long groupId;
    @NotNull
    @Column(name = "group_name")
    private String groupName;
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products;
}
