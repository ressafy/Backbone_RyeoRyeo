package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class inflearn_대소문자_변환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		char [] arr = new char [inp.length()];
		for (int i = 0; i < inp.length(); i++) {
			if(Character.isLowerCase(inp.charAt(i))){
				arr[i] = Character.toUpperCase(inp.charAt(i));
			}else {
				arr[i] = Character.toLowerCase(inp.charAt(i));
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}
