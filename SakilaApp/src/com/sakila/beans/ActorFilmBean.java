package com.sakila.beans;

import java.util.List;

public class ActorFilmBean {

	private List<FilmBean> film;
	private ActorBean actor;

	public List<FilmBean> getFilm() {
		return film;
	}

	public void setFilm(List<FilmBean> film) {
		this.film = film;
	}

	public ActorBean getActor() {
		return actor;
	}

	public void setActor(ActorBean actor) {
		this.actor = actor;
	}

}
