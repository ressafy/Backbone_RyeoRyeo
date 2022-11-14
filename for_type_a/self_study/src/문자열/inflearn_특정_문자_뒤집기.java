package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class inflearn_특정_문자_뒤집기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		char [] arr1 = new char[a.length()];
		char [] arr2 = new char[a.length()];
		Stack<Integer> s = new Stack();
		for (int i = 0; i < a.length(); i++) {
			arr1[i] = a.charAt(i);
			if(Character.isAlphabetic(arr1[i])) {
				s.add(i);
			}
		}
		for (int i = 0; i < a.length(); i++) {
			if(Character.isAlphabetic(arr1[i])) {
				arr2[s.pop()] = arr1[i];
			}else {
				arr2[i] = a.charAt(i);
			}
		}
		
		for(char c:arr2) {
			System.out.print(c);
		}
	}

}
