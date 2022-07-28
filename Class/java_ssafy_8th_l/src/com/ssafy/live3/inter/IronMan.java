package com.ssafy.live3.inter;

public class IronMan implements Heroable{
	int weaponDamage = 100;
	
	@Override
	public int fire() {
		// TODO Auto-generated method stub
		System.out.println("적의 에너지 감소: "+weaponDamage);
		return weaponDamage;
	}

	@Override
	public void changeShape(boolean isHeroMode) {
		// TODO Auto-generated method stub
		if(isHeroMode) {
			System.out.println("장갑 장착");
		}else {
			System.out.println("일반 토니 스타크");
		}
		
	}

	@Override  // 룰에 부모가 가진 접근제한자와 같거나 넓음
	public void upgrade() {
		// TODO Auto-generated method stub
		System.out.println("성능 개선");
		
	}
	// 꼭 오버라이드 해야하는 것이야. abtract 하거나( 그럼 객체 못만들어) 해야 한다.
}
