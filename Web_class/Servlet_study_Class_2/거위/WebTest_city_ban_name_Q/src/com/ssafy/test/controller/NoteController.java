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

import com.ssafy.test.dto.Note;
import com.ssafy.test.model.service.NoteService;
import com.ssafy.test.model.service.NoteServiceImpl;



@WebServlet("/note")
public class NoteController extends HttpServlet {
	
	NoteService noteService;

	public void init(ServletConfig config) throws ServletException {
		noteService=NoteServiceImpl.getInstance();
	}

	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher disp = null;
		String action = request.getParameter("action");
		if(action != null) {
			if("registNoteForm".equals(action)) {
				disp = request.getRequestDispatcher("note/registNote.jsp");
			}else if ("registNote".equals(action)) {
				String noteCode = request.getParameter("noteCode");
				String model = request.getParameter("model");
				String price = request.getParameter("price");
				String company = request.getParameter("company");
				Note note = new Note();
				note.setCompany(company);
				note.setModel(model);
				note.setPrice(Integer.parseInt(price));
				note.setNoteCode(noteCode);
				try {
					int i = noteService.insert(note);
					if(i > 0) {
						request.setAttribute("msg", "노트북 정상 등록 완료");
					}else{
						request.setAttribute("msg", "노트북 정상 등록 실패");
					}
				}catch(Exception e) {
					request.setAttribute("msg", "노트북 정상 등록 실패");
					e.printStackTrace();
				}
				disp = request.getRequestDispatcher("index.jsp");
				
			}else if ("listNote".equals(action)) {
				try {
					List<Note>list = noteService.selectAll();
					request.setAttribute("noteList", list);
					disp = request.getRequestDispatcher("note/listNode.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("msg", "노트북 정상 조회 실패");
					disp = request.getRequestDispatcher("index.jsp");
				}
			}
		}else {
			disp = request.getRequestDispatcher("error/error.jsp");
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
