package com.pw.io.booker.repository.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pw.io.booker.model.Feedback;

public class FeedbackRepositoryList {

	private List<Feedback> feedbackList = new ArrayList<>();
	private int feedbackIdGenerator = 1000;

	public List<Feedback> findAll() {
		return feedbackList;
	}

	public Feedback find(int id) {
		for (Feedback feedback : feedbackList) {
			if (id == feedback.getFeedbackId()) {
				return feedback;
			}
		}
		return null;
	}

	public Feedback save(Feedback model) {
		if (find(model.getFeedbackId()) != null) {
			feedbackList.add(model);
		}
		model.setFeedbackId(feedbackIdGenerator++);
		feedbackList.add(model);
		return model;
	}

	public Feedback delete(Feedback model) {
		for (Iterator<Feedback> iter = feedbackList.iterator(); iter.hasNext();) {
			Feedback feedback = iter.next();
			if (model.getFeedbackId() == feedback.getFeedbackId()) {
				iter.remove();
				return feedback;
			}
		}
		return null;
	}

}
