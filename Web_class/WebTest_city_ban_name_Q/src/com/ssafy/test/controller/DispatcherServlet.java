package com.ssafy.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	UserService userService;
	NoteService noteService;
	public void init(ServletConfig config) throws ServletException {
		noteService = NoteServiceImpl.getInstance();
		userService = UserServiceImpl.getInstance();
	}

	// get 이나 post의 구별을 안할 때
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher disp = null;
		String sign = request.getParameter("sign");
		if(sign != null) {
			if("registNoteForm".equals(sign)) {
				disp = request.getRequestDispatcher("note/registNote.jsp");
			}else if("registNote".equals(sign)) {
				String noteCode = request.getParameter("noteCode");
				String model = request.getParameter("model");
				String price = request.getParameter("price");
				String company = request.getParameter("company");
				
				
				try {
					int i =noteService.insert(new Note(noteCode, model, Integer.parseInt(price), company));
					if(i > 0) {
						request.setAttribute("msg", "regist ok");
					}else {
						request.setAttribute("msg", "regist fail");
					}
					
				} catch (Exception e) {  // 이렇게 따로 주면 
					request.setAttribute("msg", "regist fail");
					e.printStackTrace();
				}
				disp = request.getRequestDispatcher("index.jsp");	
			}else if("listNote".equals(sign)) {
				try {
					List<Note> list = noteService.selectAll();
					request.setAttribute("noteList", list);
					disp = request.getRequestDispatcher("note/listNote.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("msg", "getting list fail");
					disp = request.getRequestDispatcher("index.jsp");
				}	
			}else if("detailNote".equals(sign)) {
				String noteCode = request.getParameter("noteCode");
				try {
					Note note = noteService.selectByNoteCode(noteCode);
					request.setAttribute("note", note);
					disp = request.getRequestDispatcher("note/detailNote.jsp");
				} catch (SQLException e) {
					request.setAttribute("msg", "detailNote fail");
					e.printStackTrace();
					disp = request.getRequestDispatcher("index.jsp");
				}
			}else if("updateNoteForm".equals(sign)) {
				String noteCode = request.getParameter("noteCode");
				try {
					Note note = noteService.selectByNoteCode(noteCode);
					request.setAttribute("note", note);
					disp = request.getRequestDispatcher("note/updateNote.jsp");
				} catch (SQLException e) {
					request.setAttribute("msg", "info load fail");
					e.printStackTrace();
					disp = request.getRequestDispatcher("index.jsp");
				}
				
			}else if("updateNote".equals(sign)) {
				
				String noteCode = request.getParameter("noteCode");
				String model = request.getParameter("model");
				String price = request.getParameter("price");
				String company = request.getParameter("company");
				try {
					int i = noteService.update(new Note(noteCode, model, Integer.parseInt(price), company));
					if(i>0) {
						request.setAttribute("msg", "update Note Okay~");
					}else {
						request.setAttribute("msg", "update Note Fail");
					}
					List<Note> list = noteService.selectAll();
					request.setAttribute("noteList", list);  // 이름만 안겹친다면 몇 개든 들어갈 수 있다.
					disp = request.getRequestDispatcher("note/listNote.jsp");
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
					request.setAttribute("msg", "update Note Error encounted");
					disp = request.getRequestDispatcher("index.jsp");
					
				}
				
			}else if("delete".equals(sign)) {
				String noteCode = request.getParameter("noteCode");
				try {
					int i = noteService.delete(noteCode);
					if(i>0) {
						request.setAttribute("msg", "deletesuccess");
					}else {
						request.setAttribute("msg", "deletfailed");
					}
					List<Note> list = noteService.selectAll();
					request.setAttribute("noteList", list);  // 이름만 안겹친다면 몇 개든 들어갈 수 있다.
					disp = request.getRequestDispatcher("note/listNote.jsp");
					
				} catch (SQLException e) {
					request.setAttribute("msg", "Error encounted");
					e.printStackTrace();
					disp = request.getRequestDispatcher("index.jsp");
				}
			}else if("loginForm".equals(sign)) {
				disp = request.getRequestDispatcher("user/login.jsp");
			}else if("login".equals(sign)) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				
				try {
					User user = userService.login(new User(id,pw));
					if(user != null) {
						HttpSession session = request.getSession();
						session.setAttribute("user", user);  // nav 에 있는 el 에서 이걸 사용한다.
						String remember = request.getParameter("remember");
						if(remember != null) {
							Cookie cookie = new Cookie("savedId",id);  // Cookie 에 담아서 준다.
							cookie.setPath(request.getContextPath());  // 이러면 context 명으로 지정되어 새 창이 열려도 괜춘
							cookie.setHttpOnly(true);  // 이러면 html 에서만 된다. 근데 로그인 jsp 에서는 자바코드로 변경되어 간거라 괜찮다고 하신다.
							response.addCookie(cookie);
						}
					}else {
						request.setAttribute("msg", "login fail, user -> null");
					}
				} catch (SQLException e) {
					request.setAttribute("msg", "login fail");
					e.printStackTrace();
				}
				disp = request.getRequestDispatcher("index.jsp");
			}else if ("logout".equals(sign)) {
				HttpSession session = request.getSession(false);  // 로그아웃인 것을 잘 생각하자
				if(session != null) {
					session.invalidate();
					
				}
				disp = request.getRequestDispatcher("index.jsp");
			}
		}else {
			request.setAttribute("msg", "잘못된 요청입니다.");
			disp = request.getRequestDispatcher("index.jsp");
		}
		
		disp.forward(request, response);
	}


}
