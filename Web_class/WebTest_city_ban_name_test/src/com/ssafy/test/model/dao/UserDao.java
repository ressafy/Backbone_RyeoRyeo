package com.ssafy.test.model.dao;

import java.sql.SQLException;

import com.ssafy.test.dto.User;

public interface UserDao {


	
	/**
	 * 로그인
	 */
	User login(User user) throws SQLException;
	
}
