package test10.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Test {
	
//	@Override
//	public int hashCode() {
//		return 1;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		return this.hashCode() == obj.hashCode();
//	}
//	

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		System.out.println(set);
		// 이거 중복되는 값 어케 지웠냐...?
		
		Iterator<Test> it = set.iterator();
		while(it.hasNext()) {
			Test t = it.next();
			System.out.println(t);
		}
		
//		System.out.println("서울".hashCode());  // 내용값을 가지고 인트값 가지게 만들기 때문에 그렇다신다.
//		System.out.println(new String("서울").hashCode());  // 둘이 같은 해쉬코드 나오네?
//		
//		System.out.println(new Test().hashCode());  // 이건 둘이 다르게 나온다.
//		System.out.println(new Test().hashCode());	// 주소값을 기반으로 만든다. new 할 때마다 주소가 다르게 나온다. 
		
		
		
		
		
		
		
		
		
		
//		ArrayList<String> list = new ArrayList<>();
//		list.add("java");
//		list.add("Busan");
//		list.add("Seoul");
//		list.add("java");
//		list.add(new Integer(1));
//		list.add(1);   // auto-boxing, unboxing 자제해달라. 
//		// 그럼 알아서 해석해서 위의 코드로 바꾸기 때문에 성능에 영향을 준다.(해석하는 인스트럭터까지 들어가기에)
		
//		
//		for(int i = 0; i< list.size();i++) {
//			Object o = list.get(i); // object타입으로 리턴을 해준다. 
//			if(o instanceof String) {
//				String s = (String) o;
//				System.out.println(s.charAt(0));
//			}else if(o instanceof Integer) {  // 타입 서칭 타입 캐스팅에 조건문 심각한 성능의 문제를 끼침
//				Integer in =(Integer)o;
//				int i2 = in.intValue();
//				System.out.println(i2++);
//			}
//		}
		
//		System.out.println(list);  // toString 메서드가 오버라이딩 해줘서 그렇다.
//		
//		for(String s:list) {
//			System.out.println(s);
//		}
	}

}
