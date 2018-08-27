package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}