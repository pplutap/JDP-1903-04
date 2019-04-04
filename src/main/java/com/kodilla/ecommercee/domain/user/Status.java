package com.kodilla.ecommercee.domain.user;

import com.kodilla.ecommercee.domain.order.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "STATUS;")
public class Status {
    private Long statusId;
    private String name;
    private List<User> users = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "STATUS_ID", unique = true)
    public Long getStatusId() {
        return statusId;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @OneToMany(
            targetEntity = User.class,
            mappedBy = "status",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<User> getUsers() {
        return users;
    }
}
