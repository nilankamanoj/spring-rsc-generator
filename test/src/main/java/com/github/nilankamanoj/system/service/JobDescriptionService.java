package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.JobDescription;
import com.github.nilankamanoj.system.repository.JobDescriptionRepository;
import java.util.List;

@Service
public class JobDescriptionService {
	@Autowired
	private JobDescriptionRepository jobDescriptionRepository;

	public List<JobDescription> findAll() {
		List<JobDescription> jobDescriptions = jobDescriptionRepository.findAll();
		return jobDescriptions;
	}

	public JobDescription findOne(Integer id) {
		JobDescription jobDescription = jobDescriptionRepository.findOne(id);
		return jobDescription;
	}

	public JobDescription save(JobDescription jobDescription) {
		jobDescriptionRepository.save(jobDescription);
		JobDescription newJobDescription = jobDescriptionRepository.findOne(jobDescription.getId());
		return newJobDescription;
	}

}