package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 회문_self {
	/**
	 * 어떻게 풀어야 할까...
	 * 문자열을 뒤집어서 기존의 문자열과 동일하면 회문이다.
	 * 근데 유사 회문은 어떻게 구하냐 
	 * 하나씩 따져서 다른 인덱스를 찾아서 그 곳의 앞 뒤로 잘라볼까
	 * 
	 * **/
	private static char [] arr ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String a = br.readLine();
			arr = a.toCharArray();
			check();
			
		}
		
	}
	
	
	// 완전 회문인지만 체크하는 메소드
	private static void check() {
		char [] b = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			b[i] = arr[arr.length-i-1];
		}
		// b는 arr를 뒤집은 것
		ArrayList<Integer> diff = new ArrayList<Integer>();
		int cnt = 0;
		for (int i = 0; i < b.length; i++) {
			if(arr[i] != b[i]) {
				diff.add(i);
				cnt ++;
			}
		}
		if (cnt == 0) System.out.println(0);  // 회문이면 0
		else {
			one_check(diff,b);
		}
	}
	
	
	// 하나로 쭉 하려 했는데 너무 지저분해 보여서 그냥 나눴읍니다...
	// 유사 회문만을 체크하는 메소드
	private static void one_check(ArrayList<Integer> diff, char[] b) {
		int idx = diff.get(0);
		
	}


}
