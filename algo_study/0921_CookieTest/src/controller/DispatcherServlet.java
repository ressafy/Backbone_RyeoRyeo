package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main")
public class DispatcherServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget() 호출됨");
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		Cookie c = new Cookie("loginedName","arh");
		c.setMaxAge(60*60*24*365);
		c.setHttpOnly(true);  // js 탈취를 막는 코드 보안 키 -> f12 어플리케이션에만 뜬다.
		// c.setSecure(true); // https에서만 사용
		response.addCookie(c);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
