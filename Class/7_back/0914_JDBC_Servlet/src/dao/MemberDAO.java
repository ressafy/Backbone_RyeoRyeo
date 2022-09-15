package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MemberDAO {
	private static MemberDAO dao = null;
	static public MemberDAO getInstance() {
		if(dao == null)
			try {
				dao = new MemberDAO();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return dao;
	}
	
	Connection con;
	private MemberDAO() throws Exception{
		// 1. 드라이버 등록
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 등록 ok");
		// 2. 연결
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "ssafy" , "ssafy");
		System.out.println("connection ok");
	}
	public String selectMember(String id, String pw) {
		try(
	PreparedStatement stmt = con.prepareStatement("select * from member where id=? and pw=?");
			) {
			
			stmt.setString(1, id);
			stmt.setString(2, pw);
			// 4. SQL 전송
			ResultSet rs = stmt.executeQuery();
			// 5. 결과 파싱
			if(rs.next()) {
				String name = rs.getString("name");
				return name;
			}
			
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
