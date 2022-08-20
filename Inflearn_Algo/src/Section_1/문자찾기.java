package Section_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		inp = inp.toLowerCase();
		char a = br.readLine().charAt(0);
		a = Character.toLowerCase(a);
		int cnt = 0;
		for (int i = 0; i < inp.length(); i++) {
			if(inp.charAt(i)==a) {
				cnt ++;
			}
		}
		System.out.println(cnt);
		// 이렇게 찾으면 된다. 찾아보자.
	}

}
