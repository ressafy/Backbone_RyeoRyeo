package dao;

import java.sql.*;

import dto.Member;

public class MemberDAO {
	private static MemberDAO instance;
	private Connection con;
	private MemberDAO() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","ssafy","ssafy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static MemberDAO getInstance() throws SQLException {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}
	
	public Member login(String id, String pw) {
		String sql = "select * from member where id = ? amd pw = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				return new Member(id,pw,name);
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateMember(Member m) {
		String sql = "update member set name =? where id = ? ";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, m.getName());
			stmt.setString(2, m.getId());
			int i = stmt.executeUpdate();
			System.out.println(i+"행이 update 되었읍니다...");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
