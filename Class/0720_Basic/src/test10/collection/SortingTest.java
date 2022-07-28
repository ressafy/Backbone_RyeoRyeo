package test10.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortingTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("C","A","B","a"));
		System.out.println(list);
		
		// Java 8
		list.sort(Comparator.naturalOrder());
		System.out.println(list);
		
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		// 여기부터는 대소문자 구분 x
		list.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println();
		
		list.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER)); // 대소문자 구분 없이 역순은 안되네;
		System.out.println(list);
		
		
//		// Java 7
//		Collections.sort(list);
//		System.out.println(list);
//		
//		Collections.sort(list, Collections.reverseOrder());
//		System.out.println(list);
//		
//		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
//		System.out.println(list);
//		
//		Collections.sort(list, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
//		System.out.println(list);
	}

}
