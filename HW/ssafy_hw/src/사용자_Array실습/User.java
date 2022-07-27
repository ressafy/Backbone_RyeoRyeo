package 사용자_Array실습;

public class User {

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

	public void setId(String id) {
		if(id != null) {  // 간단한 예외처리를 해보았습니다.
			this.id = id;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password != null) {
			this.password = password;
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name !=  null) {
			this.name = name;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null) {
			this.email = email;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >0) {
			this.age = age;
		}
		
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", age=" + age
				+ "]";
	}
	
}