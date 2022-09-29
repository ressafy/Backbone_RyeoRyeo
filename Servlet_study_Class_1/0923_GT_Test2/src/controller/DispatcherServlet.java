package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.Member;
import service.MemberService;

@WebServlet("/main")
public class DispatcherServlet extends HttpServlet {
	MemberService memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = MemberService.getInstance();
		
	}
       
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		JsonObject json = (JsonObject) JsonParser.parseReader(request.getReader());
		JsonObject reJson = new JsonObject();
		
		String sign = json.get("sign").getAsString();
		System.out.println("SIGN "+sign);
		if(sign!=null) {
			if(sign.equals("login")) {
				System.out.println("여기왔니?");
				String id = json.get("id").getAsString();
				String pw = json.get("pw").getAsString();
				Member m = memberService.login(id, pw);
				System.out.println(m);
				if(m!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("loginId", m.getName());
					reJson.addProperty("loginId", m.getName());
				}else {
					reJson.addProperty("msg", "loginFail");
				}
			} else if(sign.equals("logout")) {
				HttpSession session = request.getSession(false);
				System.out.println("SESSION "+session);
				if(session!=null) {
					session.invalidate();
					reJson.addProperty("msg", "logout");
				}else {
					reJson.addProperty("msg", "fail");
				}
			} else if(sign.equals("memberInsert")) {
				System.out.println("ID");
				String id = json.get("id").getAsString();
				String pw = json.get("pw").getAsString();
				String name = json.get("name").getAsString();
				System.out.println(id+" :"+pw+" : "+name);
				int i = memberService.memberInsert(new Member(id,pw,name));
				System.out.println(i);
				if(i>0) {
					reJson.addProperty("msg","insert Success");
				}
				else {
					reJson.addProperty("msg", "fail");
				}
			}
			
		}else { // sign 없음
			reJson.addProperty("msg", "error");
		}
		
		out.append(reJson.toString());
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
