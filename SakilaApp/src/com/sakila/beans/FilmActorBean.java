package com.sakila.beans;

import java.util.List;

public class FilmActorBean {

	private FilmBean film;
	private List<ActorBean> actor;
	private List<FilmBean> films;

	public List<FilmBean> getFilms() {
		return films;
	}

	public void setFilms(List<FilmBean> films) {
		this.films = films;
	}

	public FilmBean getFilm() {
		return film;
	}

	public void setFilm(FilmBean film) {
		this.film = film;
	}

	public List<ActorBean> getActor() {
		return actor;
	}

	public void setActor(List<ActorBean> actor) {
		this.actor = actor;
	}

}
