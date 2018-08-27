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
import com.github.nilankamanoj.system.model.InterviewForm;
import com.github.nilankamanoj.system.service.InterviewFormService;

@Controller
@RequestMapping(path = "/interviewForm")
public class InterviewFormController{
	@Autowired
	private InterviewFormService interviewFormService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<InterviewForm> interviewForms = interviewFormService.findAll();
		return new ResponseEntity<>(interviewForms, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		InterviewForm interviewForm = interviewFormService.findOne(id);
		return new ResponseEntity<>(interviewForm, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody InterviewForm interviewForm) {
		InterviewForm newInterviewForm = interviewFormService.save(interviewForm);
		return new ResponseEntity<>( newInterviewForm, HttpStatus.OK);
	}
}