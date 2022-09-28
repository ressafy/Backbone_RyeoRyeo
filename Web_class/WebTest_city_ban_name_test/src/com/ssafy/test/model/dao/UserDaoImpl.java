package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.test.dto.User;
import com.ssafy.test.util.DBUtil;

public class UserDaoImpl implements UserDao{
	
	private UserDaoImpl() {}
	private static UserDaoImpl instance = new UserDaoImpl();
	public static UserDaoImpl getInstance() {
		return instance;
	}
	
	private DBUtil dbUtil = DBUtil.getInstance();
	
	/**
	 * 로그인
	 */
	@Override
	public User login(User user) throws SQLException {
		String sql = "select id, pw from user where id=? and pw=?";
		User userInfo = null;
		
		try(
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					String id=rs.getString("id");
					String pw= rs.getString("pw");
					userInfo = new User();
					userInfo.setId(id);
					userInfo.setPw(pw);
				}
			}
		}
		
		return userInfo;
	}
}
