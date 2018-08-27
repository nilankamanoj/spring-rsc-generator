package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}