package com.booker.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booker.app.model.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {

}
