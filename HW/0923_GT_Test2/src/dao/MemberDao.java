package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDao {
	private static MemberDao instance;
	Connection con;
	private MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","ssafy","ssafy");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {
		if(instance==null) {
			instance= new MemberDao();
		}
		return instance;
	}

	public Member login(String id, String pw) {
		String sql = "select * from member where id=? and pw =?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Member(id,pw,rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public int memberInsert(Member m) {
		String sql  = "insert into member(id,pw,name) value(?,?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, m.getId());
			stmt.setString(2, m.getPw());
			stmt.setString(3, m.getName());
			return stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	

}
