package com.booker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booker.app.model.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

}
