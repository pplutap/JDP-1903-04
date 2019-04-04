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

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "group")
public class Group {
    private Long groupId;
    private String groupName;
    private List<Product> products;

    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID", unique = true)
    public Long getGroupId() {
        return groupId;
    }

    @NotNull
    @Column(name = "GROUP_NAME")
    public String getGroupName() {
        return groupName;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Product> getProducts() {
        return products;
    }
}
