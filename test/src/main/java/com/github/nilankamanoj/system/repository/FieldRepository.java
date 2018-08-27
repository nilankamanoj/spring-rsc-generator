package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Field;

public interface FieldRepository extends JpaRepository<Field, Integer> {

}