package com.sakila.manager;

import com.sakila.beans.LoginBean;
import com.sakila.repository.LoginDao;

public class LoginManager {

	public boolean checkLoginCredentials(LoginBean log) throws Exception {

		LoginDao dao = new LoginDao();
		boolean isFound = false;
		LoginBean logDB = dao.getAllAccounts(log.getUsername());

		if (logDB == null) {
			return isFound;
		}

		if (logDB.getPassword().equals(log.getPassword())) {
			return isFound = true;
		}

		return isFound;
	}
}
