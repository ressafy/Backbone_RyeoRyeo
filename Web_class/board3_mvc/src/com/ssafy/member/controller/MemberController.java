package com.ssafy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService;
	
	public void init() {
		memberService = MemberServiceImpl.getMemberService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println("act ==="+act);
		String path = "/index.jsp";
		if("mvjoin".equals(act)) {
			path = "/user/join.jsp";
			redirect(request,response,path);
		}else if("idcheck".equals(act)) {
			int cnt = idCheck(request,response);  // 얘만 ajax 니까 int 밑에 나머지 전체는 path
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(cnt);
		}
		else if("".equals(act)) {}
		else if("".equals(act)) {}
		else if("".equals(act)) {}
		else if("".equals(act)) {}
		else {
			redirect(request,response,path);
		}
	}
	
	

	// url 은 풀 경로
	// path 는 우리 프로젝트 기준이라서 
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath()+path);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
		// 굳이 process 하나 만들지 말고 get으로 다 처리하겠다.
	}
	
	
	// --------- 위에는 프론트 컨트롤러 -------------------
	
	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		try {
			int count = memberService.idCheck(userId);
			return count;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 500;
	}

}
