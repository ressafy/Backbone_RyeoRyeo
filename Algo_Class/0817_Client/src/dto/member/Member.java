package dto.member;

import java.io.Serializable;

public class Member implements Serializable, Comparable<Member>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int age;
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String id, int age) {
		setId(id);
		setAge(age);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Member o) {
		if(this.age != o.getAge()) {
			return this.age-o.getAge();
		}
		return this.id.compareTo(o.getId());
	}
	
	

}
