package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;

import dto.Member;

public class MemberService {
	
	
	// 8 SingleTon
	private static MemberService instance;
	
	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();  // instance = new MemberService(); 이 구조 실수할 수 있다!!!!!!!!!!!!!
		return instance;
	}
	
	private MemberService() {} // 이거 넣어주자.
	
	ArrayList<Member> list = new ArrayList();  // 1번
	
	public boolean searchName(String name) {
		for(Member m : list) {
//			if(m.getName().equals(name)) { // 혹시 null 인 경우를 생각해보자. -> null 의 여부를 체크해줘야 한다.
			if(m.getName()!=null ||m.getName().equals(name)) {  // 이렇게 코드의 퀄리티를 높여준다. !!!!!!!!!!!!!! 이것도 중요하다 하신다.
				return true;
			}
		}
		return false;
	}
	
	// 6 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// DuplicatedException 파일 새로 만들어줘야 한다. 그래서 안에 생성자 만들어주면 그 안의 msg 를 설정해줄 수 있다. enum 을 이용하여
	public void add(Member m) throws DuplicatedException {  // 이 throws 함으로써 main의 service.add(m4); 들 빨간 줄 ->  try catch
		if(searchName(m.getName())) {
			throw new DuplicatedException(m.getName()+"이미 등록된 사용자입니다.");  // 이게 발생이 되어졌을 때 아래로 내려가지지 않는다. 그럼 main 가서 e.getMessage 부른다.
		}
		list.add(m);
		
	}
	
	public Object[] getMembers(){   // 여기서 list null 인지 체크해주자
//		return list;  // 그냥 이렇게 주는 것은 매우 위험하다!!! 그래서 copy 해서 줘야 한다. !!!!!!!!!!!!!!!!
//		return Arrays.copyOf(list ,list.size()); list 는 [] 형태가 아니라 못넣는다. 그래서 배열형태로 바꿔줘야 한다.
		// !!!!!!!!!!!!!!!!!!!!!! list null 체크 !!!!!!!!!!!!!!!!!
		return Arrays.copyOf(list.toArray(),list.size());
	}
	
	public ArrayList<Member> load() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Member.dat"));) {
			//3.
			return  (ArrayList<Member>)ois.readObject();  // 캐스팅할 때에 캐스팅 할 수 없는 상태라면.... 여기 캐스팅 형태 !!!!!!
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {  // 그냥 try catch 말고 싸고있는 것에 catch 해주는 거를 골라
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;   // 여기 리턴은 꼭 해주자.
		}
	}
	
	public void saveFile() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Member.dat"));
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
