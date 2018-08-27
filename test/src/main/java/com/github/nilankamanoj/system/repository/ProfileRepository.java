package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}