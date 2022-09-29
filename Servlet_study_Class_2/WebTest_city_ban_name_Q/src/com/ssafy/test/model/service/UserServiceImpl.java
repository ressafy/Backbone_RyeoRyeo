package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.dto.User;
import com.ssafy.test.model.dao.UserDao;
import com.ssafy.test.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	
	private UserServiceImpl() {}
	private static UserServiceImpl instance = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		return instance;
	}
	
	private static UserDao userDao = UserDaoImpl.getInstance();
	
	@Override
	public User login(User user) throws SQLException {
		return userDao.login(user);
	}
	
	
}
