package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.JobDescription;

public interface JobDescriptionRepository extends JpaRepository<JobDescription, Integer> {

}