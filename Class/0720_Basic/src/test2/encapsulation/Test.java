package test2.encapsulation;

public class Test {

	public static void main(String[] args) {
		Member m1 = new Member("안려환",28);
		System.out.println(m1.name+" : "+m1.age);
		
		Member m2 = new Member("최효정",29);
		System.out.println(m2.name+" : "+m2.age);

	}

}

class Member{
	String name;
	int age;
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}