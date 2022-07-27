package test1.static_;

public class Shop {
	static int count;  // class data
	private static Shop s;
	
	public static Shop getInstance() {
		if(s == null)
		s = new Shop();  // 이럼 호출할 때마다 생성이 된다. 조건을 걸자!
		return s;
	}
	
	private Shop() {
		super();
	}
	
	public void addPrint() {   // instance method (shop 객체를 호출해야 쓸 수 있다.)
		System.out.println(++count);
	}
}
