package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import controller.Command;
import member.dto.Member;
import member.service.MemberService;

public class LoginCommand implements Command{

	MemberService memberService;
	public LoginCommand() {
		memberService=MemberService.getInstance();
	}

	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response, JsonObject json, JsonObject reJson)
			throws ServletException, IOException {
		System.out.println("로그인하러 왔니?");
//		String id=json.get("id").getAsString();
//		String pw=json.get("pw").getAsString();


		
		
		String id= json.get("id").getAsString();
		HttpSession session = request.getSession(false);
		//로그인 되어 있는 경우
		if(id!=null && !id.trim().equals("")&& session!=null) {
			Member member = (Member)session.getAttribute("member");
			if(member!=null && member.getId().equals(id)) {
				reJson.addProperty("loginId", id);				
			}else {
				reJson.addProperty("msg", "해킹 모니터링 중");					
			}
		}else {
			JsonElement pwObject = json.get("pw");
			if(pwObject!=null) {
				String pw = pwObject.getAsString();
				System.out.println(id+"&"+pw);
				
				//login
				Member member = memberService.login(id,pw);
				if(member!=null) {
				session= request.getSession();
				session.setAttribute("member", member);
				reJson.addProperty("loginId", id);
			}else {
				reJson.addProperty("msg", "loginFail");					
			}
			}else {
				//session.invalidate();
				reJson.addProperty("msg", "session만료. 다시 로그인해주세요");
			}
		
		
		
		

	}
		}
	}


//// TODO 로그인처리
//String id= json.get("id").getAsString();
//HttpSession session = request.getSession(false);
////로그인 되어 있는 경우
//if(id!=null && !id.trim().equals("")&& session!=null) {
//	Member member = (Member)session.getAttribute("member");
//	if(member!=null && member.getId().equals(id)) {
//		reJson.addProperty("loginId", id);				
//	}else {
//		reJson.addProperty("msg", "해킹 모니터링 중");					
//	}
//}else {
//	JsonElement pwObject = json.get("pw");
//	if(pwObject!=null) {
//		String pw = pwObject.getAsString();
//		System.out.println(id+"&"+pw);
//		
//		//login
//		Member member = memberService.login(id,pw);
//		if(member!=null) {
//			session= request.getSession();
//			session.setAttribute("member", member);
//			reJson.addProperty("loginId", id);
//		}else {
//			reJson.addProperty("msg", "loginFail");					
//		}
//	}else {
//		//session.invalidate();
//		reJson.addProperty("msg", "session만료. 다시 로그인해주세요");
//	}

//String pw= json.get("pw").getAsString();
