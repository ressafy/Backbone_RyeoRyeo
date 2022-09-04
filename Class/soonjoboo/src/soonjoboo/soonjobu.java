package soonjoboo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class soonjobu {
	static int totalCnt = 0;
	static int N,R;
	static boolean [] isVisited;
	static int [] answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());
		isVisited = new boolean[N];
		answer = new int[N];
		
		

	}
	private static void perm(int n) {  // 순열
		if(n == R) {
			totalCnt++;
			System.out.println(Arrays.toString(answer));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isVisited[i]) continue;
			
			answer[n] = i;
			isVisited[i] = true;
			perm(n+1);
			isVisited[i] = false;
		}
	}
	
	private static void comb(int n, int start) {  // 조합
		if(n == R) {
			totalCnt++;
			System.out.println(Arrays.toString(answer));
			return;
		}
		for (int i = 0; i < N; i++) {
			answer[n] = i;
			comb(n+1,start+1);
		}
	}
	
	private static void subset(int n) {  // 부분 집합
		if(n == R) {
			totalCnt++;
			System.out.println(Arrays.toString(answer));
			return;
		}
		for (int i = 0; i < N; i++) { // X 가 들어가야되는데 - 수가 없는 곳
			answer[n] = i;
			perm(n+1);
		}
		
	}
}
/** 입력 형태 **/
 