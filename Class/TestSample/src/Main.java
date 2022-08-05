import java.util.ArrayList;
import java.util.Collections;

import dto.Member;
import service.DuplicatedException;
import service.MemberService;

public class Main {

	public static void main(String[] args) {
		Member m1 = new Member("안려환",28);
		Member m2 = new Member("홍길동",39);
		Member m3 = new Member("최효정",29);
		Member m4 = new Member("박지효",26);
		
		MemberService service =MemberService.getInstance();
		MemberService service2 = MemberService.getInstance();
		MemberService service3= MemberService.getInstance();
		System.out.println(service == service2);  // true 나온다.
		
		try {
			service.add(m1);  // 만약 여기서 throws 하면 안된다 메인에서 하는건 그냥 죽겠다는 뜻
		} catch (DuplicatedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			service.add(m2);
		} catch (DuplicatedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());  // 이걸로 변경해줘야 알 수 있따.
		}
		try {
			service.add(m3);
		} catch (DuplicatedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			service.add(m4);
		} catch (DuplicatedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		service.saveFile();
		ArrayList<Member> list = service.load();
		Collections.sort(list);  // 이걸 써서 주관적 비교를 하는 것이다.
		System.out.println(list); // toString overriding 안하면 이거 주소가 나와
	
		Object[] allMembers = service.getMembers(); // 리턴 받은 곳의 캐스팅 문제!!!!!!!!!!!!
		for(Object o : allMembers) {  // 이렇게 해야 안의 원소들을 볼 수있다.
			System.out.println(o);
		}
//		System.out.println(allMembers);  // Object[] 로 찍으면 배열의 주소가 나온다.
		
	}

}
