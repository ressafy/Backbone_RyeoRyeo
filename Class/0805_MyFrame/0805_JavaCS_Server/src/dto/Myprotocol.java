package dto;

import java.io.Serializable;

import util.Request;

public class Myprotocol implements Serializable{
	
	private Request sign;
	private Member m;
	private String msg;
	
	public Myprotocol(Request sign, Member m, String msg) {
		super();
		setSign(sign);
		setM(m);
		setMsg(msg);
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