package com.pw.io.booker.repository;

import java.util.List;


public interface Repository<T> {

	public abstract List<T> findAll();
	public abstract T findById(int id);
	public abstract T save(T model);
	public abstract void delete(T model);
	
}
