package com.github.nilankamanoj.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import com.github.nilankamanoj.system.model.JobDescription;
import com.github.nilankamanoj.system.service.JobDescriptionService;

@Controller
@RequestMapping(path = "/jobDescription")
public class JobDescriptionController{
	@Autowired
	private JobDescriptionService jobDescriptionService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<JobDescription> jobDescriptions = jobDescriptionService.findAll();
		return new ResponseEntity<>(jobDescriptions, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		JobDescription jobDescription = jobDescriptionService.findOne(id);
		return new ResponseEntity<>(jobDescription, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody JobDescription jobDescription) {
		JobDescription newJobDescription = jobDescriptionService.save(jobDescription);
		return new ResponseEntity<>( newJobDescription, HttpStatus.OK);
	}
}