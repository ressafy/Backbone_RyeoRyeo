package test4.polymorphism;

public class Test {

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a1 == a2); // 주소값 비교
		System.out.println(a1.equals(a2)); // 오브젝트의 equals 비교를 하는데 
										   // 주소값 비교를 한다.
	}

}

class A {
	String name;
	int model;
	int price;  // 이 변수들이 다 같으면 같은 것으로 처리하고싶다.
	// 이렇게 해야할 상완은 언제인가? -> set을 사용할 때 중복되어서 덮어쓰기 해버리기 
	// 수강신청할 때 국어 신청했는데 또 국어를 실수로 신청하면 자꾸 있는게 쌓이기에 그걸 피하기 위해

	@Override
	public String toString() {
		return "A:" + hashCode();
	}
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}
}
