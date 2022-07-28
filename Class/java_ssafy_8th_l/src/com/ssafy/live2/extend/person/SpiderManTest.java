package com.ssafy.live2.extend.person;

public class SpiderManTest {

	public static void main(String[] args) {
		SpiderMan sman = new SpiderMan("피터 파커",false);
		sman.eat();  //Person
		sman.jump();  //Person
		sman.fireWeb();  //SpiderMan
		sman.isSpider = true;   //SpiderMan
		sman.eat();  //Person
		sman.jump();  //Spider
		sman.fireWeb();  //SpiderMan
		sman.name="Peter Parker";  //person
		System.out.println(sman.toString());
	}

}
