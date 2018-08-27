package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.ProfileField;
import com.github.nilankamanoj.system.repository.ProfileFieldRepository;
import java.util.List;

@Service
public class ProfileFieldService {
	@Autowired
	private ProfileFieldRepository profileFieldRepository;

	public List<ProfileField> findAll() {
		List<ProfileField> profileFields = profileFieldRepository.findAll();
		return profileFields;
	}

	public ProfileField findOne(Integer id) {
		ProfileField profileField = profileFieldRepository.findOne(id);
		return profileField;
	}

	public ProfileField save(ProfileField profileField) {
		profileFieldRepository.save(profileField);
		ProfileField newProfileField = profileFieldRepository.findOne(profileField.getId());
		return newProfileField;
	}

}