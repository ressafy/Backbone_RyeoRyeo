package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.dto.Member;

public class MemberDao {
	Connection con;
	private static MemberDao instance;
	private MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "ssafy", "ssafy");
		} catch(Exception e) {
			
		}
	}
	public static MemberDao getInstance() {
		if(instance == null) instance = new MemberDao();
		return instance;

	
	}
	public Member login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}
	public int memberInsert(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}
}