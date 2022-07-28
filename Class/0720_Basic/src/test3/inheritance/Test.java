package test3.inheritance;

public class Test {

	public static void main(String[] args) {
		Object o = new Object();
		System.out.println(o.toString());
		A a = new A();
		System.out.println(a.i);
		a.printI();
		System.out.println(a.toString());  //toString 은 object 의 메소드이다.
		B b = new B();
		System.out.println(b.toString());
		System.out.println(b.i+" "+b.j);

	}

}
