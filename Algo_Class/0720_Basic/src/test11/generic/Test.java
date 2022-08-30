package test11.generic;

import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<A> list = new ArrayList<>();
		list.add(new A());
		list.add(new B());
		
		ArrayList<B> list2 = new ArrayList<>();
		list2.add(new B());
		
		Biz.service(list);
	}

}

class A{}
class B extends A{}

class Biz{
	public static void service(List<? super B> list) {  // 와일드 카드는 여기서 쓰는 것이다. 써내서 쓰는 service가 중요하다.
		for(A o : list) {  // 안되는건가보다.....
			System.out.println(o);
		}
	}
}