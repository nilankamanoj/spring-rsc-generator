package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Profile;
import com.github.nilankamanoj.system.repository.ProfileRepository;
import java.util.List;

@Service
public class ProfileService {
	@Autowired
	private ProfileRepository profileRepository;

	public List<Profile> findAll() {
		List<Profile> profiles = profileRepository.findAll();
		return profiles;
	}

	public Profile findOne(Integer id) {
		Profile profile = profileRepository.findOne(id);
		return profile;
	}

	public Profile save(Profile profile) {
		profileRepository.save(profile);
		Profile newProfile = profileRepository.findOne(profile.getId());
		return newProfile;
	}

}