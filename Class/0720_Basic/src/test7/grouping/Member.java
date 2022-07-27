package test7.grouping;

public class Member implements Order8, Subwayer{  // 다른 인터페이스 추가하고 싶으면 , 써서 추가 가능하다.
	private String name,Phone;
	
	//메소드 새로 짜기 불편하니까 생성자 오버로딩
	public Member(String name, String phone) {
		super();
		setName(name);
		setPhone(phone);
	}
	
	public Member(){
		super();
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		// 유효성 감시...
		this.name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		// 유효성 감시 ( 패턴이 맞는지)
		Phone = phone;
	}
	
}
