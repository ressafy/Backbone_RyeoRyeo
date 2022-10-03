package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.Member;


@WebServlet("/main")
public class DispatcherServlet extends HttpServlet {
	MemberDAO memberDao;

	public void init(ServletConfig config) throws ServletException {
		memberDao = MemberDAO.getInstance();
	}


	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sign = request.getParameter("sign");
		RequestDispatcher disp = null;
		if(sign!= null) {
			if(sign.equals("login")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				Member m = memberDao.login(id,pw);
				if(m != null) {
					HttpSession session = request.getSession();  // 새로 할당하거나 가져온거 쓰거나 false는 새로할당 x 때
					session.setAttribute("member",m);
					disp = request.getRequestDispatcher("loginOk.jsp");
			
				}else {
					System.out.println("login failed!");
					disp = request.getRequestDispatcher("index.html");
					
				}
			}else if (sign.equals("logout")) {
				HttpSession session = request.getSession(false);
				if(session != null) {
					session.invalidate();
					disp = request.getRequestDispatcher("index.html");
				}else {
					// 여기가 침해 대응 코드가 들어가야 한다. 비정상적인 접근이기에
					System.out.println("해킹시도 감지...!!!!!!");
					disp = request.getRequestDispatcher("hack.jsp");
				}
			}
			
		}else {
			disp = request.getRequestDispatcher("error.html");
		}
		
		disp.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
