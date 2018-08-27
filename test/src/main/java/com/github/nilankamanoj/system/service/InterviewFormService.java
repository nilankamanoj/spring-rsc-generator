package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.InterviewForm;
import com.github.nilankamanoj.system.repository.InterviewFormRepository;
import java.util.List;

@Service
public class InterviewFormService {
	@Autowired
	private InterviewFormRepository interviewFormRepository;

	public List<InterviewForm> findAll() {
		List<InterviewForm> interviewForms = interviewFormRepository.findAll();
		return interviewForms;
	}

	public InterviewForm findOne(Integer id) {
		InterviewForm interviewForm = interviewFormRepository.findOne(id);
		return interviewForm;
	}

	public InterviewForm save(InterviewForm interviewForm) {
		interviewFormRepository.save(interviewForm);
		InterviewForm newInterviewForm = interviewFormRepository.findOne(interviewForm.getId());
		return newInterviewForm;
	}

}