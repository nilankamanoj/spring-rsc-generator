package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}