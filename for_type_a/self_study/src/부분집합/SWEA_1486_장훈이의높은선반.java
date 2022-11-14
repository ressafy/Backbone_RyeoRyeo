package 부분집합;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반 {
	private static int [] cards; // 부분 집합의 재료
	private static boolean [] select; // cards와 같은 크기의 배열로 특정 재료를 포함할지 뺄지 기록하는 배열
	private static int N,B,ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int i = 1; i <= TC; i++) {
			N = sc.nextInt();
			B = sc.nextInt();
			ans = Integer.MAX_VALUE;
			
			cards = new int[N];
			for (int j = 0; j < N; j++) {
				cards[j] = sc.nextInt();
			}
			select = new boolean[N];
			subset(0);
			System.out.println("#"+i+" "+(ans-B));
		}
	}
	
	private static void subset(int idx) {
		if(idx == N) {  
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += select[i] ? cards[i]:0;
			}
			if(sum >= B && sum <ans) {
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
