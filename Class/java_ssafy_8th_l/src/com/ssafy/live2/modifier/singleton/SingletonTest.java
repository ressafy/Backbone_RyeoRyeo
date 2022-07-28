package com.ssafy.live2.modifier.singleton;

class SingletonClass{
    // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
	private static SingletonClass sc = new SingletonClass();  // 내부에서 객체를 만들고
	private SingletonClass() {} //stateless 한 클래스 - 상태를 가지지 않고 기능만 가진 클래스
    // END:
	
	public static SingletonClass getSingleTonClass() {  // 메모리에 바로 올려둬서 쓰게 하자.
		return sc;
	}
    public void sayHello() {
      System.out.println("Hello");
    }
    
  }

  public class SingletonTest {
    public static void main(String[] args) {
      // TODO:SingletonClass를 사용해보세요.  
    	SingletonClass sc = SingletonClass.getSingleTonClass();
    	sc.sayHello();
    	
    	SingletonClass sc2 = SingletonClass.getSingleTonClass();
    	sc2.sayHello();
      // END:
    }
  }
