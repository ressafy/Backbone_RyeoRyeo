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

public class LoginCommand implements Command{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response, JsonObject json, JsonObject reJson)
			throws ServletException, IOException {
	
		// json�� �����°��� ������, �α��� ó���� �ϴ°��̴�.
		String id=json.get("id").getAsString();
		HttpSession session=request.getSession(false);
		if(id!=null && !id.trim().equals("")&& session!=null) {
			Member member=(Member)session.getAttribute("member");
			if(member!=null && member.getId().equals(id)) {
				reJson.addProperty("loginId",id);
			}else {
				reJson.addProperty("msg", "해킹 시도 감지 모니터링중");
			}
		}else {
			JsonElement pwObject=json.get("pw");
			if(pwObject!=null) {
				String pw=pwObject.getAsString();
				System.out.println(id+":"+pw);
				
				//login...
				Member member=new Member(id,pw);
				if(member!=null) {
					session=request.getSession();
					session.setAttribute("member",member);
					
					reJson.addProperty("loginId",id);
				}else {
					reJson.addProperty("msg", "login fail");
					
				}
			}else {
				reJson.addProperty("msg","세션만료됨. 다시 로그인 해주세요");
			}
		}
	
		
		
	
	}



}
