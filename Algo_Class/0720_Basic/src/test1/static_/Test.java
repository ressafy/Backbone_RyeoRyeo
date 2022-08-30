package test1.static_;

public class Test {

	public static void main(String[] args) {
		Admin a1 = new Admin();
		a1.connect();
	}

}

final class Admin{
	final int i = 10;
	public void connect() {  // 오버라이딩 못하게 막는 것이다.
		System.out.println(1);
	}
}

