package 두번째_보충;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1486_장훈이의높은선반_ver1 {
	static int[] cards; // 부분집합의 재료.
	static boolean[] select; // cards와 같은 크기의 배열로, 특정 재료를 포함할지 뺄지 기록하는 배열
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
			
			select = new boolean[N];
			subset(0); // 재료 번호.
			
			System.out.println("#"+tc+" "+(ans-B));
		}
	}

	private static void subset(int idx) {
		if(idx==N) { // 탑 쌓을 직원을 골랐어 ! 
//			System.out.println(Arrays.toString(select));
			int sum = 0; // 높이 계산해보자
			for(int i=0; i<N; i++) {
				sum += select[i]?cards[i]: 0; // i번 직원 포함이면 해당 키를 더하고 아니면 0 더하기
			}
			if(sum>=B && sum<ans) {
				ans = sum;
			}
			return;
		}
		
		select[idx] = true;
		subset(idx+1);
		select[idx] = false;
		subset(idx+1);
	}
}



