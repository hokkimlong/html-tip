package com.itstep.htmltip.model;


public class UserManager {

	public static User register(String username, String password) {
		return UserDao.create(new User(username, password));
	}

	public static User login(String username, String password) {
		User foundUser = UserDao.findOne(new User(username));
		if (foundUser != null && foundUser.getPassword().equals(password)) {
			return foundUser;
		}
		return null;
	}
}
