package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {

}