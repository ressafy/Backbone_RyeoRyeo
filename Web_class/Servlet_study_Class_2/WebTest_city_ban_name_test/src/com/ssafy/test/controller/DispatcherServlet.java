package com.ssafy.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.test.dto.Note;
import com.ssafy.test.dto.User;
import com.ssafy.test.model.service.NoteService;
import com.ssafy.test.model.service.NoteServiceImpl;
import com.ssafy.test.model.service.UserService;
import com.ssafy.test.model.service.UserServiceImpl;


@WebServlet("/main")
public class DispatcherServlet extends HttpServlet {
	NoteService noteService;
	UserService userService;

	public void init(ServletConfig config) throws ServletException {
		noteService = NoteServiceImpl.getInstance();
		userService = UserServiceImpl.getInstance();
	}
	
	/**
	 * 
	 * 교수님 제가 사용한 컴퓨터 db 에서 계정을 root 비번을 ssafy 로 해서 사용하였읍니다....ㅠㅠ 
	 * 
	 * **/


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher disp = null;
		String sign = request.getParameter("sign");
		if(sign != null) {
			if("registProductForm".equals(sign)) {
				System.out.println("등록하러 왔니");
				disp = request.getRequestDispatcher("note/registNote.jsp");
			}
			else if ("registForm".equals(sign)) {
				System.out.println("뭐 등록하러왔니?");
				String noteCode = request.getParameter("noteCode");
				String model = request.getParameter("model");
				String price = request.getParameter("price");
				String company = request.getParameter("company");
				Note note = new Note(noteCode, model, Integer.parseInt(price), company);
				try {
					int i = noteService.insert(note);
					if(i>0) {
						request.setAttribute("msg", "note insert success");
						disp = request.getRequestDispatcher("note/listNote.jsp");
					}else {
						request.setAttribute("msg", "no note!");
						disp = request.getRequestDispatcher("index.jsp");
					}
				} catch (SQLException e) {
					request.setAttribute("msg", "note insert failed");
					disp = request.getRequestDispatcher("index.jsp");
					e.printStackTrace();
				} // note 등록 완료
			}else if("noteList".equals(sign)) {
				try {
					List<Note> list = noteService.selectAll();
					request.setAttribute("list", list);
					disp = request.getRequestDispatcher("note/listNote.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if ("login".equals(sign)) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				try {
					User user = userService.login(new User(id,pw));
					if(user != null) {
						request.setAttribute("msg", "login success!");
						HttpSession session = request.getSession();
						session.setAttribute("login", user);
						disp = request.getRequestDispatcher("index.jsp");
					}else {
						request.setAttribute("msg", "there is no user!");
						disp = request.getRequestDispatcher("index.jsp");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					request.setAttribute("msg", "login failed!");
					disp = request.getRequestDispatcher("index.jsp");
				};
			}
			disp.forward(request, response);
		}
	}



}
