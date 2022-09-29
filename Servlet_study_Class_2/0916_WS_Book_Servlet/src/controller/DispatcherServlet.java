package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String sign = request.getParameter("sign");
		RequestDispatcher dispatcher = null;
		switch(sign) {
		case "login" : 
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			MemberDAO dao = MemberDAO.getInstance();
			String name = dao.selectMember(id, pw);
			HttpSession session = request.getSession();
			session.setAttribute("memberName", name);
			request.setAttribute("memberName",name);
			Cookie c1 = new Cookie("Ian","kr");
			Cookie c2 = new Cookie("info","20age_Female");
			c2.setMaxAge(60*60*24*365);
			response.addCookie(c1);
			response.addCookie(c2);
			dispatcher = request.getRequestDispatcher("loginOk.jsp");
			break;
		case "memberInfo":
			Cookie [] allCookies = request.getCookies();
			for(Cookie c: allCookies) {
				System.out.println(c.getName()+":"+c.getValue());
			}
			dispatcher = request.getRequestDispatcher("memberInfo.jsp");
			break;
		
		}
		dispatcher.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);

	}

}
