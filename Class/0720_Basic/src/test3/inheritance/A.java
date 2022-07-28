package test3.inheritance;

public class A {
	int i = 10;
	public void printI() {
		System.out.println(i);
	}
}

class B extends A{
	int j = 20;
	public void printJ() {
		System.out.println(j);
	}
}
