package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.State;

public interface StateRepository extends JpaRepository<State, Integer> {

}