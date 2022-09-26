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

	public void init() throws ServletException {
		memberService = MemberService.getInstance();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		JsonObject json = (JsonObject) JsonParser.parseReader(request.getReader());
		JsonObject reJson = new JsonObject();

		String sign = json.get("sign").getAsString();
		System.out.println(sign);

		if (sign != null) {
			if (sign.equals("login")) {
				String id = json.get("id").getAsString();
				String pw = json.get("pw").getAsString();
				Member m = memberService.login(id, pw);
				if (m != null) {
					HttpSession session = request.getSession();
					session.setAttribute("member", m);
					reJson.addProperty("loginId", m.getName());
				} else {
					reJson.addProperty("msg", "loginFail");
				}
			} else if (sign.equals("logout")) {
				HttpSession session = request.getSession(false);
				System.out.println("SESSION " + session);
				if (session != null) {
					session.invalidate();
					reJson.addProperty("msg", "logout");
				} else {
					reJson.addProperty("msg", "fail");
				}

			} else if (sign.equals("memberInsert")) {
				String id = json.get("id").getAsString();
				String pw = json.get("pw").getAsString();
				String name = json.get("name").getAsString();
				System.out.println(id + " :" + pw + " : " + name);
				int i = memberService.memberInsert(new Member(id, pw, name));
				System.out.println(i);
				if (i > 0) {
					reJson.addProperty("msg", "insert Success");
				} else {
					reJson.addProperty("msg", "fail");
				}

			} else if (sign.equals("getInfo")) {
				HttpSession session = request.getSession(false);

				if (session != null) {
					Member m = (Member) session.getAttribute("member");
					if (m != null) {
						String id = m.getId();
						String pw = m.getPw();
						String name = m.getName();

						reJson.addProperty("infoId", id);
						reJson.addProperty("infoPw", pw);
						reJson.addProperty("infoName", name);
					} else {
						System.out.println("MEMBER NULL");
						reJson.addProperty("msg", "member fail");
					}
				} else {
					reJson.addProperty("msg", "info fail");
				}
			} else if (sign.equals("memberUpdate")) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					Member m = (Member) session.getAttribute("member"); // 멤버를 갖고옴
					String uId = json.get("uId").getAsString();
					String uPw = json.get("uPw").getAsString();
					String uName = json.get("uName").getAsString();
					Member uMember = new Member(uId, uPw, uName);

					String id = m.getId();
					if (m.getId().equals(uId)) {
						// 사용자가 동일한 경우에만 실행
						int i = memberService.update(id, uMember);
						if (i > 0) { // 성공
							reJson.addProperty("msg", "update Success");
							memberService.login(uId, uPw);

						} else { // 실패
							reJson.addProperty("msg", "update Fail");
						}
					} else {
						reJson.addProperty("msg", "different!!!!");
					}

				} else {
					reJson.addProperty("msg", "update error");
				}

			} else if (sign.equals("memberDelete")) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					Member m = (Member) session.getAttribute("member"); // 멤버를 갖고옴
					String uId = json.get("uId").getAsString();
					String id = m.getId();
					if (m.getId().equals(uId)) {
						// 사용자가 동일한 경우에만 실행
						int i = memberService.delete(id);
						if (i > 0) { // 성공
							session.invalidate();
							reJson.addProperty("msg", "delete Success");
						} else { // 실패
							reJson.addProperty("msg", "delete Fail");
						}
					} else {
						reJson.addProperty("msg", "different!!!!");
					}
				} else {
					reJson.addProperty("msg", "update error");
				}
			} else if (sign.equals("memberIdCheck")) {
				String id = json.get("id").getAsString();
				int i = memberService.idCheck(id);
				if(i==1) {
					reJson.addProperty("msg","중복된 id입니다!");
					reJson.addProperty("code","impossible");
				}else {
					reJson.addProperty("msg","사용가능한 id입니다!");
					reJson.addProperty("code","possible");
				}

			}

		} else {
			// sign null
			reJson.addProperty("msg", "error");
		}
		out.append(reJson.toString());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

}