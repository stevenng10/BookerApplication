package com.sakila.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sakila.beans.ActorBean;
import com.sakila.beans.FilmActorBean;
import com.sakila.beans.FilmBean;
import com.sakila.repository.ActorDao;
import com.sakila.repository.FilmDao;

public class FilmManager {

	public List<FilmActorBean> initializeValuesTitle(String param) throws Exception {
		FilmDao film = new FilmDao();
		ActorDao actor = new ActorDao();

		return combineValues(film.searchByTitle(param),
				actor.findFullDetails(actor.matchFilmsToActorId(film.searchByTitle(param))));

	}

	public List<FilmActorBean> initializeValuesGenre(String param) throws Exception {
		FilmDao film = new FilmDao();
		ActorDao actor = new ActorDao();

		return combineValues(film.searchByGenre(param),
				actor.findFullDetails(actor.matchFilmsToActorId(film.searchByGenre(param))));

	}

	public List<FilmActorBean> initializeValuesLastName(String param) throws Exception {
		FilmDao film = new FilmDao();
		ActorDao actor = new ActorDao();

		return combineValues(
				film.filterMovies(film.processHashMap(film.matchActorToFilmsId(actor.searchByLastName(param)))),
				actor.findFullDetails(actor.matchFilmsToActorId(film
						.filterMovies(film.processHashMap(film.matchActorToFilmsId(actor.searchByLastName(param)))))));
	}

	public List<FilmActorBean> combineValues(List<FilmBean> films, Map<String, List<ActorBean>> actors) {

		List<FilmActorBean> beans = new ArrayList<>();
		FilmActorBean bean;

		for (int i = 0; i < films.size(); i++) {
			bean = new FilmActorBean();
			bean.setFilm(films.get(i));
			bean.setActor(actors.get(films.get(i).getFilmId()));
			beans.add(bean);
		}
		return beans;
	}

}
