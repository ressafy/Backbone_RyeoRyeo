package 문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class inflearn_단어_뒤집기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String a;
		String b = "";
		for (int i = 0; i < N; i++) {
			a = br.readLine();
			b = "";
			for (int j = a.length()-1; j >= 0; j--) {
				b += a.charAt(j);
			}
			System.out.println(b);
		} 
	}

}
