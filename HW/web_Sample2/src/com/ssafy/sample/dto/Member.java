package com.ssafy.sample.dto;

public class Member {
	String id,pw,name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(id != null) this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Member(String id, String pw, String name) {
		setId(id);
		setPw(pw);
		setName(name);
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	

}
