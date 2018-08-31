package com.sakila.repository;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sakila.beans.FilmBean;

public class FilmDao {

	Logger logger = Logger.getLogger(FilmDao.class);

	public List<FilmBean> viewAllFilms() throws Exception {

		List<FilmBean> films = new ArrayList<>();
		FilmBean film;

		ConnectionManager mng = new ConnectionManager();
		Connection conn = mng.connect();

		String query = "select title, description, rental_rate, rating, special_features, genre from film";

		try {

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				film = new FilmBean();

				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setRentalRate(rs.getFloat("rental_rate"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setGenre(rs.getString("genre"));

				films.add(film);
			}
		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return films;
	}

	public int addFilm(FilmBean film) throws Exception {

		int result = 0;

		ConnectionManager mng = new ConnectionManager();
		Connection conn = mng.connect();

		String sql = "insert into film(id, title, description, rental_rate, rating, special_features, genre)"
				+ " values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, film.getFilmId());
			ps.setString(2, film.getTitle());
			ps.setString(3, film.getDescription());
			ps.setDouble(4, film.getRentalRate());
			ps.setString(5, film.getRating());
			ps.setString(6, film.getSpecialFeatures());
			ps.setString(7, film.getGenre());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public FilmBean searchById(int param) throws Exception {

		FilmBean film = null;

		ConnectionManager mng = new ConnectionManager();
		Connection conn = mng.connect();

		String query = "select title, description, rental_rate, rating, special_features, genre "
				+ "from film where id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, param);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				film = new FilmBean();

				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setRentalRate(rs.getFloat("rental_rate"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setGenre(rs.getString("genre"));

			}
		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return film;
	}

	public int updateFilm(FilmBean film) throws Exception {

		int result = 0;

		ConnectionManager mng = new ConnectionManager();
		Connection conn = mng.connect();

		String sql = "update film "
				+ "set title = ?, description = ?, rental_rate = ?, rating = ?, special_features = ?, genre = ? "
				+ "where id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setDouble(3, film.getRentalRate());
			ps.setString(4, film.getRating());
			ps.setString(5, film.getSpecialFeatures());
			ps.setString(6, film.getGenre());
			ps.setInt(7, film.getFilmId());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteFilm(int id) throws Exception {

		int result = 0;

		ConnectionManager mng = new ConnectionManager();
		Connection conn = mng.connect();

		String sql = "delete from film where id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			logger.error("SQLException occurred - databse connection not found: " + e.getMessage());
			throw new FileNotFoundException("File not found.");
		} catch (Exception e) {
			logger.error("Exception occured: " + e.getMessage());
			throw new Exception("Error occurred. Please try again later...");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
