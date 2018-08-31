package com.pw.io.booker.repository.impl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.Feedback;
import com.pw.io.booker.repository.FeedbackRepository;

@Repository
public class FeedbackRepositoryMap implements FeedbackRepository {

	private Map<Integer, Feedback> feedbackMap = new HashMap<>();
	private int feedbackIdGenerator = 1000;
	
	@Override
	public List<Feedback> findAll() {
		return new ArrayList<>(feedbackMap.values());
	}

	@Override
	public Feedback findById(int id) {
		return feedbackMap.get(id);
	}

	@Override
	public Feedback save(Feedback model) {
		if(findById(model.getFeedbackId()) != null) {			
			feedbackMap.put(model.getFeedbackId(), model);
			return model;
		}
		model.setFeedbackId(feedbackIdGenerator++);
		feedbackMap.put(model.getFeedbackId(), model);
		return model;	
	}

	@Override
	public void delete(Feedback model) {
		feedbackMap.remove(model.getFeedbackId());
	}

}
