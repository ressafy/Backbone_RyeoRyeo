package dto.member;

import java.io.Serializable;

public class Member implements Serializable, Comparable<Member>{  // 중요하다
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int age;
	
	public Member(String id, int age) {
		super();
		this.id = id;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {  //꼭 유효성 검사를 넣자!!
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int name) {  // 꼭 유효성 검사 넣자!!
		this.age = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Member o) {  // 타입을 지워서 오브젝트의 아무거나랑 비교된다.
//		if(o.getAge() - this.age < 0) {
//			return 1;
//		}else if(o.getAge() - this.age > 0) {// 순서에 따라 오름차순 내림차순 변경할 수 있다.
//			return -1;
//		}else {
//			return this.getId().compareTo(o.getId());
//		}
		
		if(this.age != o.getAge()) {  //  나이가 같을 때만 비교 후 정렬
			return this.age - o.getAge();
		}
		return this.id.compareTo(o.getId());
	}
	
	
}
