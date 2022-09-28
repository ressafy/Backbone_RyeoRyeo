package controller;

import java.io.IOException;
import java.sql.SQLException;

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
        try {
			memberDao=MemberDAO.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sign=request.getParameter("sign");
        RequestDispatcher dispatcher=null;
        if(sign!=null) {
            switch(sign) {
            case "login": 
                String id=request.getParameter("id");
                String pw=request.getParameter("pw");
                Member m=memberDao.login(id, pw);
                HttpSession session=request.getSession();
                session.setAttribute("member", m);
                dispatcher=request.getRequestDispatcher("loginOk.jsp");
            break;
            case "logout":
                HttpSession session2=request.getSession(false);
                if(session2!=null) {
                    session2.invalidate();//무효화
                }
                dispatcher=request.getRequestDispatcher("index.html");
            break;
            case "memberUpdateForm":
                dispatcher=request.getRequestDispatcher("memberUpdateForm.jsp");
            break;
            case "memberUpdate" :
                String name=request.getParameter("name");
                HttpSession session3=request.getSession(false);
                if(session3!=null) {
                    Member m2=(Member)session3.getAttribute("member");
                    Member m3=new Member(m2.getId(),m2.getPw(), name);
                    if(memberDao.updateMember(m3)) {
                        session3.setAttribute("member", m3);
                        dispatcher=request.getRequestDispatcher("memberUpdateOk.jsp");
                    }else {
                        dispatcher=request.getRequestDispatcher("memberUpdateFail.jsp");
                    }
                }else {
                    dispatcher=request.getRequestDispatcher("index.html");
                }
            }
            
        }else {
            dispatcher=request.getRequestDispatcher("error.html");
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