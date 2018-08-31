package com.booker.app.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.booker.app.model.Feedback;
import com.booker.app.repository.FeedbackRepository;

public class FeedbackService {

	private FeedbackRepository feedbackRepository;

	public FeedbackService(FeedbackRepository feedbackRepository) {
		super();
		this.feedbackRepository = feedbackRepository;
	}

	public Feedback findById(int id) {
		return feedbackRepository.findById(id).get();
	}

	public List<Feedback> findAll() {
		return (List<Feedback>) feedbackRepository.findAll();
	}

	@Transactional
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	public void deleteFeedback(Feedback feedback) {
		feedbackRepository.delete(feedback);
	}
}
