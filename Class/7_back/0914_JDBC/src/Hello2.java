
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hello2 {

	public static void main(String[] args) throws Exception {  
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","ssafy","ssafy");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employees where last_name='"+args[0]+"' and emp_no="+args[1]);
		while(rs.next()) {
			String name = rs.getString(1);
			System.out.println(name);
		}
		rs.close();
		stmt.close();
		con.close();
		

	}

}
