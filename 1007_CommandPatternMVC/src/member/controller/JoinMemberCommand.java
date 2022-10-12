package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import controller.Command;
import house.service.HouseService;
import member.dto.Member;
import member.service.MemberService;

public class JoinMemberCommand implements Command{
	MemberService memberService;

	public JoinMemberCommand() {
		memberService = MemberService.getInstance();
	}
	

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response, JsonObject json, JsonObject reJson)
			throws ServletException, IOException {
		System.out.println("가입하러 왔니?");
		
		String id=json.get("id").getAsString();
		String pw=json.get("pw").getAsString();
		String name=json.get("name").getAsString();
		
		int i =memberService.addMember(new Member(id,pw,name));
		if(i == 1) reJson.addProperty("msg", "이미 존재하는 회원입니다.");
		else if(i == 2) reJson.addProperty("msg", "회원가입 에러가 발생하였습니다.");
		else {
			reJson.addProperty("msg", "회원가입성공");
		}
	}		

}


//if(m!=null) {
//session= request.getSession();
//session.setAttribute("member", m);
//reJson.addProperty("loginId", id);
//}else {
//reJson.addProperty("msg", "loginFail");					
//}
