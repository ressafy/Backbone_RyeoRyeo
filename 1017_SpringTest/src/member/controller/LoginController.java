package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//스프링에서 제공하는 mvc 컨트롤러를 implements 해서
public class LoginController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		// login
		ModelAndView mav = new ModelAndView("loginOk.jsp");
//		mav.setViewName("loginOk.html");  // 이게 어디로 가라 인데 이거 안해도  위에 넣어줘서 쓸 수 있음
		mav.addObject("id", id); // 좌측에 이름주고 우측에 객체
		return mav;  // 이게 전에 하던 forward 이다...
	}
	
	
}
