package com.kodilla.ecommercee.domain.order;

import com.kodilla.ecommercee.domain.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private Long orderId;
    private Date date;
    private User user;
    private List<ItemDto> items;
    private Boolean paid;
}
