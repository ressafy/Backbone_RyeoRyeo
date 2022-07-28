package com.ssafy.live3.inter;

public class IronmanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IronMan iman = new IronMan();
		Object obj = iman;
		// 인터페이스도 하나의 타입 -> 다형성이 가능하다.
		Transformable tf = iman;
	}

}
