package test2.encapsulation.p1;

public class Member {
	private String name;
	private int age;
	
	public void setName(String name) {
		if(!name.contains("x")){
			this.name = name;
		}
	}
	
	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}
	}
}
