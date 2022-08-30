package com.ssafy.live1.oop1.person;

//Person 을 사용하는 주체 정도
public class PersonTest {

	public static void main(String[] args) {
		Person.org = "SSAFY2";
		// 붕어빵 틀로 붕어빵을 만드는 작업
		int a = 10;
		Person p = new Person();
		// 인트처럼 person 즉 클래스의 이름이 타입이 되는 구나!! 
		p.name = "홍길동";
		p.age = 30;
		p.isHungry = true;
		p.eat();
		System.out.println(p.name+" : "+p.isHungry);
		
		Person p2 = new Person();
		p2.name = "안려환";
		System.out.println(p2.name+" : "+p2.isHungry);
	}

}
