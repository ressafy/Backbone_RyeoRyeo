package 부분집합;

import java.util.Arrays;
import java.util.Scanner;

public class 부분집합_코드 {
	private static int [] cards; // 부분 집합의 재료
	private static boolean [] select; // cards와 같은 크기의 배열로 특정 재료를 포함할지 뺄지 기록하는 배열
	private static int N,B,ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int i = 1; i <= TC; i++) {
			N = sc.nextInt();
			B = sc.nextInt();
			
			cards = new int[N];
			for (int j = 0; j < N; j++) {
				cards[j] = sc.nextInt();
			}
			select = new boolean[N];
			subset(0);
			
		}
	}
	
	private static void subset(int idx) {
		if(idx == N) {  
			System.out.println(Arrays.toString(select));
			return;
		}
		
		select[idx] = true;
		subset(idx+1);
		select[idx] = false;
		subset(idx+1);
	}

}
