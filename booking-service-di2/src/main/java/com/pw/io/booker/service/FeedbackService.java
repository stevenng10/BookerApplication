package com.pw.io.booker.service;

import com.pw.io.booker.model.Feedback;
import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.repository.FeedbackRepository;

public class FeedbackService {

	private FeedbackRepository feedbackRepository;
	private ReservationService reservationService;
	
	public FeedbackService(FeedbackRepository feedbackRepository, ReservationService reservationService) {
		super();
		this.feedbackRepository = feedbackRepository;
		this.reservationService = reservationService;
	}

	public Feedback addFeedBack(int reservationId, String feebackMessage, int rating) {
		Reservation reservation = reservationService.findById(reservationId);
		Feedback feedback = new Feedback();
		feedback.setFeedback(feebackMessage);
		feedback.setReservation(reservation);
		feedback.setRate(rating);
		return feedbackRepository.save(feedback);
	}
}
