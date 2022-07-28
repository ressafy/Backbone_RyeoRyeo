package 파일입출력;

import java.io.Serializable;

//직렬화에 필요한 인터페이스 사용하기
public class User implements Serializable  {

	private String id;
	private String password;
	private String name;
	private String email;
	private int age;
	
	public User() {}

	public User(String id, String password, String name, String email, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {  // id 예외처리
		if(id.length() > 0) {
			this.id = id;
		}
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password.length() > 0) {
			this.password = password;
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() > 0) {
			this.name = name;
		}
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null) {   // email 예외처리
			this.email = email;
		}
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {   // 나이 예외처리
		if (age > 0) {
			this.age = age;
		}
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ "]";
	}
	
}