package test5.final_;

public class Test {

	public static void main(String[] args) {
		A a1 = new A();
		System.out.println(a1.i+1);
		
		A a2 = new A();
		System.out.println(a2.i+2);
		
	}

}

class A{
	final int i = 10;
}