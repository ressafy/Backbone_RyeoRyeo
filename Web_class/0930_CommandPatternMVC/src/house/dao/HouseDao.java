package house.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HouseDao {
//	interface 주는 이유는 확장하려고 할 때 주는 것이다.
	Connection con;
	private static HouseDao instance;
	private HouseDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "ssafy", "ssafy");
		} catch(Exception e) {
			
		}
	}
	public static HouseDao getInstance() {
		if(instance == null) instance = new HouseDao();
		return instance;
	}
	
	public List<String> getGugun(String sido) {
		String sql = "select distinct gugunName from dongcode where sidoName = ? and gugunName is not null";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, sido); // 1번 ?에 sido 넣자.
			ResultSet rs = stmt.executeQuery();
			List<String> list = new ArrayList<>();
			while(rs.next()) {
				list.add(rs.getString(1));  // gugunName 하나 오니까 1로 인덱스 써주는게 훨씬 빠르다...
			}
			return list;
		}catch(Exception e) {  // exception 도 잘 하자
			e.printStackTrace();  // 운영시엔 반드시 삭제
			return null;
		}
	}
	
	public List<String> getDong(String sido, String gugun){
		String sql = "select distinct dongName from dongcode where sidoName = ? and gugunName = ? and dongName is not null";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, sido); // 1번 ?에 sido 넣자.
			stmt.setString(2, gugun);
			ResultSet rs = stmt.executeQuery();
			List<String> list = new ArrayList<>();
			while(rs.next()) {
				list.add(rs.getString(1));  // gugunName 하나 오니까 1로 인덱스 써주는게 훨씬 빠르다...
			}
			return list;
		}catch(Exception e) {  // exception 도 잘 하자
			e.printStackTrace();  // 운영시엔 반드시 삭제
			return null;
		}
	}

}
