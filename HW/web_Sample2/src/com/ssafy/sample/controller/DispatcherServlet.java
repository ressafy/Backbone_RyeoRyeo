package com.ssafy.sample.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.service.ProductService;
import com.ssafy.sample.model.service.MemberService;


@WebServlet("/main")
public class DispatcherServlet extends HttpServlet {
	MemberService memberService;
	ProductService productService;
	
	public void init(ServletConfig config) throws ServletException {
		memberService = MemberService.getInstance();
		productService = ProductService.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sign = request.getParameter("sign");
		RequestDispatcher disp = null;
		if(sign != null) {
			if(sign.equals("productRegistForm")) {
				disp = request.getRequestDispatcher("product/regist.jsp");
			}
			else if(sign.equals("login")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				Member member = memberService.login(id,pw);
				if(member != null) {
					HttpSession session = request.getSession();
					session.setAttribute("member", member);
					response.sendRedirect("main?sign=productList");
					return;
				}else {
					disp = request.getRequestDispatcher("error/error.jsp");
				}
			}else if(sign.equals("productList")) {
				List<Product> list = productService.listProduct();
				request.setAttribute("productList", list);
				disp = request.getRequestDispatcher("product/list.jsp");
			}else if (sign.equals("registProduct")) {
				String code = request.getParameter("productCode");
				String model = request.getParameter("model");
				String price = request.getParameter("price");
				int i = productService.registProduct(new Product(model, Integer.parseInt(code), Integer.parseInt(price)));
				if(i>0) {
					disp = request.getRequestDispatcher("index.jsp");
				}else {
					disp = request.getRequestDispatcher("error/error.jsp");
				}
				
			}
		}else {
			disp = request.getRequestDispatcher("error/error.jsp");
		}
		disp.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
