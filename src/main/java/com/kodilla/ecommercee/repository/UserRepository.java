package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//    @Override
//    List<User> findAll();
//
//    @Override
//    Optional<User> findById(Long id);
//
//    @Override
//    User save(User user);
}
