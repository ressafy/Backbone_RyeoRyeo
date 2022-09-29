package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.dto.User;

public interface UserService {

	/**
	 * 로그인
	 */
	User login(User user) throws SQLException;
	
}
