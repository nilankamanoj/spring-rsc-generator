package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}