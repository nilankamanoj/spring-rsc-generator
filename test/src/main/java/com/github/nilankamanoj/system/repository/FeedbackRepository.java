package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}