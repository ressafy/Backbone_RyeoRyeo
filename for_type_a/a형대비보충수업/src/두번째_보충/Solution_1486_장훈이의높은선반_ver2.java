package 두번째_보충;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1486_장훈이의높은선반_ver2 {
	static int[] cards; // 부분집합의 재료.
	static int N, B, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			ans = Integer.MAX_VALUE;
			
			cards = new int[N];
			for(int i=0; i<N; i++) { // 직원들의 키
				cards[i] = sc.nextInt();
			}
			
			subset(0, 0); // 재료 번호.
			
			System.out.println("#"+tc+" "+(ans-B));
		}
	}

	private static void subset(int idx, int sum) {
		if(sum>=B && ans>sum) {
			ans = sum;
			return;
		}
		if(idx==N) { // 앞에서 직원을 너무 다 빼가지고.. 지금 타워 높이가 B가 안됐는데 직원이 더 없어 ;; 
			return;
		}
		
		subset(idx+1, sum+cards[idx]); // idx번 직원을 탑에 세워보자! 높이 증가!
		subset(idx+1, sum); // idx번 직원을 빼면? 기존 직원들이 쌓인 높이 유지!
	}
}



