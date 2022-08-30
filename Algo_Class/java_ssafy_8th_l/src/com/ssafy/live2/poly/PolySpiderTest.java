package com.ssafy.live2.poly;

import com.ssafy.live2.extend.person.Person;
import com.ssafy.live2.extend.person.SpiderMan;

public class PolySpiderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiderMan sman = new SpiderMan("피터파커",true);
		
		// 다형성
		SpiderMan sman2 = sman;
		Person person = sman;
		Object obj = person;
		
		//명시적 형 변환
		SpiderMan reSpider = (SpiderMan)obj;
		reSpider.fireWeb();
		
		
		
		// 뭐든지 담을 수 있는 만능 주머니
		Object [] objs = new Object[4];
		objs[0] = sman;  // obj 담는 배열이라 obj 기능만 쓸 수있다.... 그래서 이걸 강제적 기능을 사용하고 싶다면 명시적 형변환을 사용해서 쓸 수 있다.
		objs[1] = "Hello";
		objs[2] = objs;
		objs[3] = 1;  // 기본형이었는데 어케 넣었냐 기본적으로 안되지만 자동적으로 래핑이 된다. - autoboxing
		
		SpiderMan fromObjArray = (SpiderMan)objs[0];  // 이런게 명시적 형 변환이다.
		if(objs[1] instanceof SpiderMan) {
			SpiderMan fromObjArray2 = (SpiderMan)objs[1];
			fromObjArray2.fireWeb();
		}
		
		
		
		for (Object o : objs) {
			System.out.println(o.getClass().getName());
		}
		System.out.println(sman2);
		System.out.println(person);
	}

}
