package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}