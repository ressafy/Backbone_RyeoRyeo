package com.ssafy.live2.modifier.p1;

// TODO: Parent를 상속받고 Parent의 member들에 접근해보세요.
 public class SamePackageChildClass extends Parent{
    // END:
	 public void method() {
		 this.publicVar = 10;
		 this.protectVar = 10;
		 this.defaultVar = 10; // 까지만 가능하다.
	 }
}
