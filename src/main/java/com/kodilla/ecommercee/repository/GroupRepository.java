package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.groups.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}