package com.sakila.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sakila.beans.ActorBean;
import com.sakila.beans.ActorFilmBean;
import com.sakila.beans.FilmBean;
import com.sakila.repository.ActorDao;
import com.sakila.repository.FilmDao;

public class ActorManager {

	public List<ActorFilmBean> initializeValuesLastName(String param) throws Exception {
		FilmDao film = new FilmDao();
		ActorDao actor = new ActorDao();

		return combineValues(actor.searchByLastName(param),
				film.findFullDetails(film.matchActorToFilmsId(actor.searchByLastName(param))));
	}

	public List<ActorFilmBean> initializeValuesFirstName(String param) throws Exception {
		FilmDao film = new FilmDao();
		ActorDao actor = new ActorDao();

		return combineValues(actor.searchByFirstName(param),
				film.findFullDetails(film.matchActorToFilmsId(actor.searchByFirstName(param))));
	}

	public List<ActorFilmBean> combineValues(List<ActorBean> actors, Map<String, List<FilmBean>> films) {

		List<ActorFilmBean> beans = new ArrayList<>();
		ActorFilmBean bean;

		for (int i = 0; i < actors.size(); i++) {
			bean = new ActorFilmBean();
			bean.setActor(actors.get(i));
			bean.setFilm(films.get(actors.get(i).getActorId()));
			beans.add(bean);
		}
		return beans;
	}
}
