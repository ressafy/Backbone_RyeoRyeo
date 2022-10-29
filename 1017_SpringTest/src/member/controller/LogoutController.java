package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false); // 안가져왔으면 부르면 안되니 false
		if(session != null) {
			session.invalidate();
		}
		ModelAndView mav = new ModelAndView("logoutOk.jsp");
		return mav;
	}
	
}
