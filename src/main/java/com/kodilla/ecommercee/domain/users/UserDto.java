package com.kodilla.ecommercee.domain.users;

import com.kodilla.ecommercee.domain.carts.CartDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private boolean blocked;

}