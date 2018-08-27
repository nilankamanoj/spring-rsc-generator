package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Application;
import com.github.nilankamanoj.system.repository.ApplicationRepository;
import java.util.List;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;

	public List<Application> findAll() {
		List<Application> applications = applicationRepository.findAll();
		return applications;
	}

	public Application findOne(Integer id) {
		Application application = applicationRepository.findOne(id);
		return application;
	}

	public Application save(Application application) {
		applicationRepository.save(application);
		Application newApplication = applicationRepository.findOne(application.getId());
		return newApplication;
	}

}