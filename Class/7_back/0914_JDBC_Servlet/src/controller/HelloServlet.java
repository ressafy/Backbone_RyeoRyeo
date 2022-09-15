package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = dao.selectMember(id,pw);
		System.out.println(name);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("hello: "+ name);
		
	}

}
