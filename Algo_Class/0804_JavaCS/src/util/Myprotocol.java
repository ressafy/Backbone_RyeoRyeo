package util;

import java.io.Serializable;
import java.util.List;

import dto.member.Member;
import dto.books.*;
public class Myprotocol implements Serializable{
	
	private Request sign;
	private Member m;
	private String msg;
	private List<Book> books;
	
	public Myprotocol(Request sign, Member m, String msg) {
		super();
		setSign(sign);
		setM(m);
		setMsg(msg);
	}
	
	
	
	public Myprotocol(Request sign, List<Book> books) {
		super();
		setSign(sign);
		setBooks(books);
	}



	public List<Book> getBooks() {
		return books;
	}



	public void setBooks(List<Book> books) {
		if(books!=null)
		this.books = books;
		else System.out.println("Books 가 null 이다.");
	}



	public Request getSign() {
		return sign;
	}
	
	public void setSign(Request sign) {
		this.sign = sign;
	}
	
	public Member getM() {
		return m;
	}
	
	public void setM(Member m) {
		this.m = m;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
	
}
