import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Hello {

	public static void main(String[] args) {
		// JDBC PROGRAM 6단계
		// 1. driver 등록
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 등록 ok");
			
			// 2. 연결
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "ssafy" , "ssafy");
			System.out.println("connection ok");
			
			
			// 3. Statement 생성
			Statement stmt = con.createStatement();
			
			// 4. SQL 전송
			ResultSet rs = stmt.executeQuery("select * from employees where emp_no = 10077");
			
			// 5. 결과 파싱
			if(rs.next()) {
				int emp_no = rs.getInt("emp_no");
				String first_name = rs.getString("first_name");
				Date birthday = rs.getDate(2);
				System.out.println("Hello " + first_name + " : "+ emp_no + " : "+ birthday);
			}
			
			// 6. 자원 닫기  순서 다르다고 안되진 않으나 자원 잘 관리하는 법을 배워야 한다.
			rs.close();
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
