package com.ssafy.live3.abs;

public class HorseCart extends Vehicle{

	@Override
	public void addFuel() {
		// TODO Auto-generated method stub
		System.out.println("말은 건초를 먹인다");
	}
	// 상속해서 하려했는데 왜 안되냐? -> 재정의해야한다.
}
