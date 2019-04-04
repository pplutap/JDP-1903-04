package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity(name = "group")
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(
            targetEntity= Product.class,
            mappedBy="group",
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY  )
    private List<Product> productsInGroup = new ArrayList<>();

    public Group(Long groupId, String groupName, List<Product> productsInGroup) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.productsInGroup = productsInGroup;
    }
}
