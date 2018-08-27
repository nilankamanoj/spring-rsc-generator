package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Feedback;
import com.github.nilankamanoj.system.repository.FeedbackRepository;
import java.util.List;

@Service
public class FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;

	public List<Feedback> findAll() {
		List<Feedback> feedbacks = feedbackRepository.findAll();
		return feedbacks;
	}

	public Feedback findOne(Integer id) {
		Feedback feedback = feedbackRepository.findOne(id);
		return feedback;
	}

	public Feedback save(Feedback feedback) {
		feedbackRepository.save(feedback);
		Feedback newFeedback = feedbackRepository.findOne(feedback.getId());
		return newFeedback;
	}

}