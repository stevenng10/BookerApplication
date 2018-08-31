package com.sakila.repository;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sakila.beans.LoginBean;

public class LoginDao {

	Logger logger = Logger.getLogger(LoginDao.class);

	public LoginBean getAllAccounts(String username) throws Exception {

		LoginBean log = null;

		ConnectionManager mng = new ConnectionManager();
		Connection conn = mng.connect();

		String query = "select username, password from accounts where username = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				log = new LoginBean();

				log.setUsername(rs.getString("username"));
				log.setPassword(rs.getString("password"));

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
		return log;
	}
}
