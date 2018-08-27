package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Job;
import com.github.nilankamanoj.system.repository.JobRepository;
import java.util.List;

@Service
public class JobService {
	@Autowired
	private JobRepository jobRepository;

	public List<Job> findAll() {
		List<Job> jobs = jobRepository.findAll();
		return jobs;
	}

	public Job findOne(Integer id) {
		Job job = jobRepository.findOne(id);
		return job;
	}

	public Job save(Job job) {
		jobRepository.save(job);
		Job newJob = jobRepository.findOne(job.getId());
		return newJob;
	}

}