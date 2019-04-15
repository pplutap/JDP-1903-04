package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}