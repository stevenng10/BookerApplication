package com.sakila.manager;

import java.util.List;

import com.sakila.beans.FilmBean;
import com.sakila.repository.FilmDao;

public class FilmManager {

	public List<FilmBean> viewAllFilms() throws Exception {
		FilmDao dao = new FilmDao();
		return dao.viewAllFilms();
	}

	public int addFilm(FilmBean film) throws Exception {
		FilmDao dao = new FilmDao();
		return dao.addFilm(film);
	}

	public FilmBean searchById(int param) throws Exception {
		FilmDao dao = new FilmDao();
		return dao.searchById(param);
	}

	public int updateFilm(FilmBean film) throws Exception {
		FilmDao dao = new FilmDao();
		return dao.updateFilm(film);
	}

	public int deleteFilm(int id) throws Exception {
		FilmDao dao = new FilmDao();
		return dao.deleteFilm(id);
	}
}
