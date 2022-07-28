package com.ssafy.live2.extend.person;

public class Person {
	String name = "Peter Parker";
	public void eat() {
		System.out.println("냠냠");
	}
	public void jump() {
		System.out.println("두 다리로 폴짝!");
	}
	public void jump(String option) {
		
	}
	public String toString() {
		return "spider: , name: "+this.name;
	}
}
