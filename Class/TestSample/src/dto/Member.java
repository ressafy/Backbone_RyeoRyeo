package dto;

import java.io.Serializable;
//2.
public class Member implements Serializable, Comparable<Member>{  // Comparable 는 정렬 후 출력 위해서 넣는다.
	private String name;
	private int age;
	
	

	// 매개변수 없는 메소드 사용하려면 같은 패키지에 있어야 한다.
	public Member(String name, int age) {//  void 라고 써있으면 super 생성자 못쓰니까 main 에 에러가 난다.
		setAge(age);
		setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	//1.
	public void setAge(int age) {
		if(age>0 && age<100) this.age = age; // 이렇게 예외처리하자!!
	}
	// 7 오버라이딩 규칙 생각하자. 예를 들어 매개를 스트링으로 다른 것을 받아들였을 때!! 근데 저 @Override 중요하다!! 꼭 있나 확인하자!!!!!
	@Override
	public String toString() {  // 이렇게 오버라이드 해야 한다.
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	// 4.
	@Override
	public int compareTo(Member o) {  // 이걸로 오버라이딩해서 사용해야 한다.
		// 그냥 빼기 해도 되는 경우: set메서드를 유효하게 해둔 상태면 해도 된다.
		if(this.age != o.getAge()) {
			return this.age - o.getAge();
		}
		return this.name.compareTo(o.getName());  // 이 코드가 언더나 오버플로우 안나게 하려면 set 메소드들에 예외처리 꼭 해주자. 인트에 들어갈 수 있는 최소 최대 값이나 타입 처리 꼭 하자 안하면 0점
		// 이 때 name 이 null 이면 널포인터 익셉션
	}
}
