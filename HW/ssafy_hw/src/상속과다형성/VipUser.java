package 상속과다형성;

public class VipUser extends User {
	// 새로 추가된 필드 접근 제한자 설정
		private String grade;
		private int point;

		public VipUser() {
			// 부모 클래스의 생성자 호출
			super();
		}

		public VipUser(String id, String password, String name, String email, int age, String grade, int point) {
			// 부모 클래스의 생성자 호출
			super(id, password, name, email, age);
			setGrade(grade);
			setPoint(point);

		}


		public String getGrade() {
			
			return grade;
		}

		public void setGrade(String grade) {
			if(grade != null) 
			this.grade = grade;
			
		}

		public int getPoint() {
			return point;
		}

		public void setPoint(int point) {
			if(point > 0)
			this.point = point;
		}

		@Override
		public String toString() {
			return "VipUser [id=" + this.getId() + ", password=" + this.getPassword() + ", name=" + this.getName()
					+ ", email=" + this.getEmail() + ", age=" + this.getAge() + ", grade=" + grade + ", point=" + point
					+ "]";
		}
}
