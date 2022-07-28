package com.ssafy.live2.extend.person;

public class SpiderMan extends Person{
	boolean isSpider;
	Spider spider = new Spider();   // 아아 여기서 선언만 되어있어서 null로 초기화 됐구나
	
	public SpiderMan(String name, boolean isSpider){
		super();
		this.isSpider = isSpider;
	}
	
	public void fireWeb() {
		if(isSpider) {
			// null pointer 가 무엇인가 -> null.xx 하고 있는 것이다.
			spider.fireWeb();  // 지금 spider 가 null 인 것이다.
		}else {
			System.out.println("사람일 떄는 참자!!");
		}
	}
	// 자식이 코드를 개선하면 자동적으로 사용하는 곳에서는 개선된 코드가 동작하다니.....
	public void jump() {
		if(isSpider) {
			spider.jump();
		} else {
			super.jump();
		}
	}
	@Override
	public String toString() {
		return super.toString()+", isSpider: "+this.isSpider;
	}
	
}
