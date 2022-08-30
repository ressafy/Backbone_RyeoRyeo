package test10.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("Banana","Apple","Melon","Grape","Strawberry"));
		System.out.println(list);
		
		// list.stream() 하면 저기 들어있는 애들이 쭉 들어온다.. 그래서 원소를 대문자로 바꾸는 매핑작업을 할건데 그것을 object 배열로 바꾸겠다.
		Object [] pro1 = list.stream().map(e->e.toUpperCase()).toArray();  // 각 원소에 다 적용하겠다.
		System.out.println(Arrays.toString(pro1));  // 배열을 출력해줄 수 있는 것이다.
		System.out.println(list); // 원본은 바뀌지 않았다.
		
		
		// 개발자 편의성 극대화하기 위해서 축약한 것이다. 성능적으로 유리함은 없다고 하신다.
		list.stream().map(String::toUpperCase).forEach(System.out::println); // 위에꺼 줄여보려고 하는 것이다.
		// 람다식을 더 줄이기 위함이 :: 표현식이다.
	}

}
