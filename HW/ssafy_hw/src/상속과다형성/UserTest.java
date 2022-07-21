package 상속과다형성;

public class UserTest {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setId("user1");
		user1.setPassword("user1");
		user1.setName("김싸피");
		user1.setEmail("ssafy1@ssafy.com");
		user1.setAge(27);

		User user2 = new User("user2", "user2", "박싸피", "ssafy2@ssafy.com", 28);
		VipUser vuser = new VipUser("vip1", "vip1", "김싸피" , "ssafy3@ssafy.com", 29, "Gold", 300);
		
		UserManager um = new UserManager();
		
		um.add(user1);
		um.add(user2);
		um.add(vuser);
		
		System.out.println("****************김씨 사용자******************");
		User[] searchName = um.searchByName("김");
		if(searchName != null) {
			for(int i = 0; i<searchName.length; i++) {
				System.out.println(searchName[i]);
			}
		}
		
		
		System.out.println("****************일반 사용자 목록******************");
		User[] genUser = um.getUsers();
		if(genUser != null) {
			for(int i = 0; i<genUser.length; i++) {
				System.out.println(genUser[i]);
			}
		}

		
		System.out.println("****************평균 나이******************");
		System.out.println(um.getAgeAvg());

	}

}
