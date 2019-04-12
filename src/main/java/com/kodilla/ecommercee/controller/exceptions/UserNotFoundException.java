package com.kodilla.ecommercee.controller.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("User id: " + userId + " not found");
    }
}
