package 과목평가3회차풀어보기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 암호_학습장 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Queue<Character> arr1 = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			arr1.add(arr[i]);
		}
		char [] check = {'a','e','i','o','u'};
		
		while(!arr1.isEmpty()) {
			char a = arr1.poll();
			for (int j = 0; j < check.length; j++) {
				if(check[j] == a) {
					arr1.poll();
					arr1.poll();
				}
			}
			sb.append(a);
		}
		System.out.println(sb);
	}

}
