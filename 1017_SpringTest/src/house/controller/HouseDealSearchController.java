package house.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HouseDealSearchController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String search = request.getParameter("search");
		// house search 
		ArrayList list = new ArrayList();
		ModelAndView mav = new ModelAndView("houseDealSearchOk.jsp");
		mav.addObject("list",list);
		return mav;
	}

}
