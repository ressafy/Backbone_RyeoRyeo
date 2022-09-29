package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.sample.dto.Member;

public class MemberDAO {
	Connection con;
	private static MemberDAO instance;
	
	public static MemberDAO getInstance() {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}
	
	public MemberDAO () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","ssafy","ssafy");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Member login(String id, String pw) {
		String sql = "select * from member where id = ? and pw = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Member(id,pw,rs.getString("name"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	

}
