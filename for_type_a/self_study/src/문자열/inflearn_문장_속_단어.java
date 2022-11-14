package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class inflearn_문장_속_단어 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		String temp = arr[0];
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if(temp.length() < arr[i].length()) {
				temp = arr[i];
				result = i;
			}
		}
		System.out.println(arr[result]);
	}

}
