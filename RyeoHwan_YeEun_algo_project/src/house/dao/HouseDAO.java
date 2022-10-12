package house.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import house.dto.House;

public class HouseDAO {
	Connection con;
	private static HouseDAO instance;
	private HouseDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "ssafy", "ssafy");
		} catch(Exception e) {
			
		}
	}
	public static HouseDAO getInstance() {
		if(instance == null) instance = new HouseDAO();
		return instance;
	}
	
	public List<String> getGugun(String sido) {
		String sql = "select distinct gugunName from dongcode where sidoName=? and gugunName is not null";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, sido);
			ResultSet rs = stmt.executeQuery();
			List<String> list = new ArrayList();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();//운영시 반드시 삭제!
			return null;
		}
	}
	public List<String> getDong(String sido, String gugun) {
		String sql = "select distinct dongName from dongcode where sidoName=? and gugunName=? and dongName is not null";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, sido);
			stmt.setString(2, gugun);
			ResultSet rs = stmt.executeQuery();
			List<String> list = new ArrayList();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();//운영시 반드시 삭제!
			return null;
		}
	}

	public List<House> getHouseDealInfo(String sido, String gugun, String dongName, String year, String month) {
		List<House> list = new ArrayList<>();
		String sql = "SELECT  i.dong, i.roadName, i.apartmentName, i.lat, i.lng, d.floor, d.area,  d.dealAmount, d.no \r\n" + 
				"from houseinfo as i \r\n" + 
				"inner join housedeal as d \r\n" + 
				"on i.aptCode = d.aptCode \r\n" + 
				"where i.dongCode=(select dongCode from dongCode where sidoname=? and gugunName=? and dongName=?) \r\n" + 
				"and d.dealYear=? and d.dealMonth=?";
		
		try (PreparedStatement stmt=con.prepareStatement(sql)) {
			
			stmt.setString(1, sido);
			stmt.setString(2, gugun);
			stmt.setString(3, dongName);
			stmt.setInt(4, Integer.parseInt(year));
			stmt.setInt(5, Integer.parseInt(month));
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				long no=rs.getLong("no");
				String dong = rs.getString("dong");
				String roadName = rs.getString("roadName");
				String apartmentName = rs.getString("apartmentName");
				String lat = rs.getString("lat");
				String lng = rs.getString("lng");
				String floor = rs.getString("floor");
				String area = rs.getString("area");				
				String dealAmount = rs.getString("dealAmount");
				
				list.add(new House(no, dong, roadName, apartmentName, lat, lng, floor, area, dealAmount));
						
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	
	
}
