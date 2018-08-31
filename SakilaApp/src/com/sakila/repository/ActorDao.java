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

public class ActorDao {

	Logger logger = Logger.getLogger(ActorDao.class);

	public Map<String, List<String>> matchFilmsToActorId(List<FilmBean> films) throws Exception {
		File inputFile = new File("film-actor-table.txt");
		Scanner in;

		Map<String, List<String>> hmap = new HashMap<>();

		String[] actorDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				actorDetails = in.nextLine().split("\\|");

				for (int i = 0; i < films.size(); i++) {
					if (!hmap.containsKey(films.get(i).getFilmId())) {
						hmap.put(films.get(i).getFilmId(), new ArrayList<>());
					}
					if (actorDetails[0].equals(films.get(i).getFilmId())) {
						hmap.get(films.get(i).getFilmId()).add(actorDetails[1]);
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

	public Map<String, List<ActorBean>> findFullDetails(Map<String, List<String>> hmap) throws Exception {
		File inputFile = new File("actor-table.txt");
		Scanner in;

		String[] actorDetails;

		ActorBean actor;
		List<ActorBean> actors;
		Map<String, List<ActorBean>> hashActors = new HashMap<>();
		Map<String, ActorBean> hashActor = new HashMap<>();

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				actorDetails = in.nextLine().split("\\|");

				actor = new ActorBean();

				actor.setActorId(actorDetails[0]);
				actor.setFname(actorDetails[1]);
				actor.setLname(actorDetails[2]);

				hashActor.put(actorDetails[0], actor);
			}

			for (Map.Entry<String, List<String>> entry : hmap.entrySet()) {
				String filmId = entry.getKey();
				List<String> actorId = entry.getValue();
				actors = new ArrayList<>();
				for (int i = 0; i < actorId.size(); i++) {
					actor = hashActor.get(actorId.get(i));
					actors.add(actor);
				}
				hashActors.put(filmId, actors);
			}

		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return hashActors;
	}

	public List<ActorBean> searchByLastName(String param) throws Exception {
		File inputFile = new File("actor-table.txt");
		Scanner in;

		List<ActorBean> actors = new ArrayList<>();
		ActorBean actor;
		String[] actorDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				actorDetails = in.nextLine().split("\\|");
				if (actorDetails[2].toLowerCase().indexOf(param) != -1) {
					actor = new ActorBean();

					actor.setActorId(actorDetails[0]);
					actor.setFname(actorDetails[1]);
					actor.setLname(actorDetails[1]);

					actors.add(actor);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return actors;
	}

	public List<ActorBean> searchByFirstName(String param) throws Exception {
		File inputFile = new File("actor-table.txt");
		Scanner in;

		List<ActorBean> actors = new ArrayList<>();
		ActorBean actor;
		String[] actorDetails;

		try {
			in = new Scanner(inputFile);
			String nxtln = in.nextLine();
			while (in.hasNext()) {
				actorDetails = in.nextLine().split("\\|");
				if (actorDetails[1].toLowerCase().indexOf(param) != -1) {
					actor = new ActorBean();

					actor.setActorId(actorDetails[0]);
					actor.setFname(actorDetails[1]);
					actor.setLname(actorDetails[1]);

					actors.add(actor);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException occurred - input file not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		}
		return actors;
	}
}
