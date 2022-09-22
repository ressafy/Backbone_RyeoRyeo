package test1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloService {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/board3_mvc/index.jsp");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			System.out.println(con);
			con.setRequestMethod("GET");
			InputStream in = con.getInputStream();
			System.out.println(in);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String oneLine = "";
			while((oneLine = br.readLine())!= null) {
				System.out.println(oneLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
