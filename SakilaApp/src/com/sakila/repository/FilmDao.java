package com.sakila.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sakila.beans.ActorBean;
import com.sakila.beans.FilmBean;

public class FilmDao {

	Logger logger = Logger.getLogger(FilmDao.class);

	public List<FilmBean> searchByTitle(String param) throws Exception {
		File inputFile = new File("film-table.txt");
		Scanner in;

		List<FilmBean> films = new ArrayList<>();
		FilmBean film;
		String[] filmLineDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				filmLineDetails = in.nextLine().split("\\|");
				if (filmLineDetails[1].toLowerCase().indexOf(param) != -1) {
					film = new FilmBean();

					film.setFilmId(filmLineDetails[0]);
					film.setTitle(filmLineDetails[1]);
					film.setDescription(filmLineDetails[2]);
					film.setRentalRate(Double.parseDouble(filmLineDetails[3]));
					film.setRating(filmLineDetails[4]);
					film.setSpecialFeatures(filmLineDetails[5]);
					film.setGenre(filmLineDetails[6]);

					films.add(film);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return films;
	}

	public List<FilmBean> searchByGenre(String param) throws Exception {
		File inputFile = new File("film-table.txt");
		Scanner in;

		List<FilmBean> films = new ArrayList<>();
		FilmBean film;
		String[] filmLineDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				filmLineDetails = in.nextLine().split("\\|");
				if (filmLineDetails[6].toLowerCase().indexOf(param) != -1) {
					film = new FilmBean();

					film.setFilmId(filmLineDetails[0]);
					film.setTitle(filmLineDetails[1]);
					film.setDescription(filmLineDetails[2]);
					film.setRentalRate(Double.parseDouble(filmLineDetails[3]));
					film.setRating(filmLineDetails[4]);
					film.setSpecialFeatures(filmLineDetails[5]);
					film.setGenre(filmLineDetails[6]);

					films.add(film);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return films;
	}

	public List<FilmBean> getAllMovies() throws Exception {
		File inputFile = new File("film-table.txt");
		Scanner in;

		List<FilmBean> films = new ArrayList<>();
		FilmBean film;
		String[] filmLineDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				filmLineDetails = in.nextLine().split("\\|");
				film = new FilmBean();

				film.setFilmId(filmLineDetails[0]);
				film.setTitle(filmLineDetails[1]);
				film.setDescription(filmLineDetails[2]);
				film.setRentalRate(Double.parseDouble(filmLineDetails[3]));
				film.setRating(filmLineDetails[4]);
				film.setSpecialFeatures(filmLineDetails[5]);
				film.setGenre(filmLineDetails[6]);

				films.add(film);
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return films;
	}

	public Map<String, List<String>> matchActorToFilmsId(List<ActorBean> actors) throws Exception {
		File inputFile = new File("film-actor-table.txt");
		Scanner in;

		Map<String, List<String>> hmap = new HashMap<>();

		String[] filmDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				filmDetails = in.nextLine().split("\\|");

				for (int j = 0; j < actors.size(); j++) {
					if (!hmap.containsKey(actors.get(j).getActorId())) {
						hmap.put(actors.get(j).getActorId(), new ArrayList<>());
					}
					if (filmDetails[1].equals(actors.get(j).getActorId())) {
						hmap.get(actors.get(j).getActorId()).add(filmDetails[0]);
					}
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return hmap;
	}

	public List<String> processHashMap(Map<String, List<String>> hmap) {
		List<String> filmList = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : hmap.entrySet()) {
			List<String> filmId = entry.getValue();
			for (int i = 0; i < filmId.size(); i++) {
				filmList.add(filmId.get(i));
			}
		}
		return filmList;
	}

	public List<FilmBean> filterMovies(List<String> filmList) throws Exception {

		List<FilmBean> films = getAllMovies();
		List<FilmBean> filteredFilms = new ArrayList<>();
		FilmBean film;

		for (int i = 0; i < films.size(); i++) {
			for (int j = 0; j < filmList.size(); j++) {
				if (films.get(i).getFilmId().equals(filmList.get(j))) {
					film = new FilmBean();
					film.setFilmId(films.get(i).getFilmId());
					film.setTitle(films.get(i).getTitle());
					film.setDescription(films.get(i).getDescription());
					film.setRentalRate(films.get(i).getRentalRate());
					film.setRating(films.get(i).getRating());
					film.setSpecialFeatures(films.get(i).getSpecialFeatures());
					film.setGenre(films.get(i).getGenre());
					filteredFilms.add(film);
				}
			}
		}
		return filteredFilms;
	}

	public Map<String, List<FilmBean>> findFullDetails(Map<String, List<String>> hmap) throws Exception {
		File inputFile = new File("film-table.txt");
		Scanner in;

		String[] filmDetails;

		FilmBean film;
		List<FilmBean> films;
		Map<String, List<FilmBean>> hashFilms = new HashMap<>();
		Map<String, FilmBean> hashFilm = new HashMap<>();

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				filmDetails = in.nextLine().split("\\|");

				film = new FilmBean();

				film.setFilmId(filmDetails[0]);
				film.setTitle(filmDetails[1]);
				film.setDescription(filmDetails[2]);
				film.setRentalRate(Double.parseDouble(filmDetails[3]));
				film.setRating(filmDetails[4]);
				film.setSpecialFeatures(filmDetails[5]);
				film.setGenre(filmDetails[6]);

				hashFilm.put(filmDetails[0], film);
			}

			for (Map.Entry<String, List<String>> entry : hmap.entrySet()) {
				String actorId = entry.getKey();
				List<String> filmId = entry.getValue();
				films = new ArrayList<>();
				for (int i = 0; i < filmId.size(); i++) {
					film = hashFilm.get(filmId.get(i));
					films.add(film);
				}
				hashFilms.put(actorId, films);
			}

		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return hashFilms;
	}
}
