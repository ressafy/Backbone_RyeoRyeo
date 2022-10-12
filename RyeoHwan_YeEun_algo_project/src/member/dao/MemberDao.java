package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.controller.OpenCrypt;
import member.dto.Member;
import member.dto.SecVO;

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
		String sql = "select * from member where id=? and pw=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			stmt.setString(2, pw);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {					
				return new Member(id, pw, rs.getString("name"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insertMember(Member member) {
		String sql = "insert into member(id, pw, name) values(?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){

			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPw());
			stmt.setString(3, member.getName());
			
			return stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


	
	
	
	public Member selectMember(String id) {
		String sql = "select * from member where id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {					
				return new Member(id,rs.getString("pw"),rs.getString("name"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// shift alt r
	public int insertSecurity(SecVO sec) {
		String sql = "insert into openeg_security(userId,salt,secKey)  \r\n" + 
				"    	values(?,?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, sec.getUserId());
			stmt.setString(2, sec.getSalt());
			stmt.setString(3, sec.getSecKey());
			
			return stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public SecVO selectSecurity(String userId) {
		String sql ="select salt,secKey from openeg_security where userId=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {					
				return new SecVO(userId,rs.getString("salt"),rs.getString("secKey"));
			}
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

