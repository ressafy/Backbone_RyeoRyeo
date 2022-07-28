package com.ssafy.live3.inter.relation;

//TODO: HandPhone를 충전 가능하게 설정하시오.
public class HandPhone extends Phone implements Chargeable{

	@Override
	public void charge() {
		System.out.println("핸드폰 충전!!");
		
	} 
    // TODO: Chargeable을 구현하시오.
    // END:
}
