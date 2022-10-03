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

    @Override
    public void init(ServletConfig config) throws ServletException {
    	memberDao = MemberDAO.getInstance();
    }
    

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher disp = null;
		String sign = request.getParameter("sign");
		if(sign!=null) {
			if(sign.equals("login")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				Member m = memberDao.login(id,pw);
				if(m!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("member", m);
					disp = request.getRequestDispatcher("loginOk.jsp");
				}else {
					disp = request.getRequestDispatcher("index.html");
				}
			}else if(sign.equals("logout")) {
				HttpSession session = request.getSession(false);
				if(session != null) {
					session.invalidate();
					disp = request.getRequestDispatcher("index.html");
				}else {
					System.out.println("해킹 공격 감지");
					disp = request.getRequestDispatcher("hack.jsp");
				}
			}
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
