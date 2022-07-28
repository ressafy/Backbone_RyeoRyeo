package test4.constructor;

public class Test {
	int i = 10;

	public static void main(String[] args) {
		Test t =new Test(20);
		System.out.println(t);
		System.out.println(t.i);
	}
	
	public Test(int i) { //default constructor라고 한다. non-static member 초기화
		super();
		System.out.println("생성자 호출됨");
		int i2 = 100; // local data 이다.
		System.out.println(i);
		System.out.println(i2);
		System.out.println(this.i);
	}
}
