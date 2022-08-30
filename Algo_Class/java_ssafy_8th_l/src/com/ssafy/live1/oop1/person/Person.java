package com.ssafy.live1.oop1.person;
// 클래스: 타입, 붕어빵 틀 얘가 메모리에 돌아다니지 않는다. 객체가 아니니까.
public class Person {
	// 멤버 변수 - 속성, 데이터
	String name;
	int age;
	boolean isHungry;
	static String org;
	
	// 멤버 메서드 - 동작
	void eat() {
		System.out.println("냠냠");
		isHungry = false;
	}
	
	void work() {
		System.out.println("열심히 일해");
		isHungry = true;
	}


}
