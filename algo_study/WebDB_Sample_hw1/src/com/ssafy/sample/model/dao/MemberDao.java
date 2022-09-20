package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.util.DBUtil;


public class MemberDao {
	Connection con;
	private static MemberDao instance;
	
	MemberDao productDao;
	private DBUtil dbutil;
	
//	private MemberDao() {  // dbutil 사용 안하는 버전
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","ssafy","ssafy");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private MemberDao() {  // dbutil 사용
		dbutil = DBUtil.getInstance();
		try {
			con = dbutil.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static MemberDao getInstance() {
		if(instance == null) instance = new MemberDao();
		return instance;
	}
	
	
	
	public Member login(String id, String pw){
		String sql = "select * from member where id = ? and pw = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Member(id,pw, rs.getString("name"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
