package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/main")
public class DispatcherServlet extends HttpServlet {
	HashMap<String,Command> beans; 

	public void init(ServletConfig config) throws ServletException {
		String path = config.getServletContext().getRealPath("/WEB-INF/beans.xml");
		try {
			XmlBeanFactory factory = new XmlBeanFactory(path);
			beans = factory.getBeans();
			System.out.println(beans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JsonObject reJson = new JsonObject();
		
		//  들어오는 json data를 얻어올 수 있다.
		JsonObject json = (JsonObject) JsonParser.parseReader(request.getReader());
		String sign = json.get("sign").getAsString();
		System.out.println(sign);
		if(sign != null) {
			beans.get(sign).service(request, response, json, reJson);
			// 이렇게 하면 전에 했던 else if 막 추가하던거 안하고 xml 에 추가만 해주면 된다.
			// 우리 만의 frame work 처럼 만든 것이다.
			
		}else {
			reJson.addProperty("msg", "해킹 모니터링중...");
		}
		out.append(reJson.toString());
	}

	

}
