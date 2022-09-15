package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Book;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        // only once;
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // service
        response.setContentType("text/html;charset=utf-8");
        String action =  request.getParameter("action");
        if(action.equals("login")) {
            System.out.println("로그인 서비스 시작");
        } else if(action.equals("regist")) {
            System.out.println("회원가입 서비스 시작");
            String isbn  = request.getParameter("isbn");
            String title = request.getParameter("title");
            String author= request.getParameter("author");
            int price = Integer.parseInt(request.getParameter("price"));
            String desc= request.getParameter("desc");
            
            Book b = new Book(isbn,title,author,desc,price);
            response.getWriter().append("등록ok<br>").append(b.toString());
        }else if(action.equals("basket")) {
            System.out.println("장바구니 서비스 시작");
        }else if(action.equals("purchase")) {
            System.out.println("구매 서비스 시작");
        }
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

}