package BaekJoon;

import java.util.Scanner;

// top - down 방식
//public class BJ_1463_1로만들기 {
//	static int [] dp;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		dp = new int [N+1];
//		System.out.println(seperate(N));
//		
//	}
//	
//	private static int seperate(int N) {
//		if(N == 1) {
//			return 0;
//		}
//		 
//		if(dp[N] > 0) return dp[N];
//		
//		dp[N] = seperate(N - 1) + 1;
//		
//		
//		if(N % 2 == 0) {
//			int temp = seperate(N/2) + 1;
//			if(dp[N] > temp) dp[N] = temp;
//		}
//		
//		if(N % 3 == 0) {
//			int temp = seperate(N/3) + 1;
//			if(dp[N] > temp) dp[N] = temp;
//		}
//		
//		return dp[N];
//	}
//}


// Bottom up
public class BJ_1463_1로만들기 {
	static int [] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int [N+1];
		
		dp[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			
			if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
				dp[i] = dp[i/2] + 1;
			}
			
			if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
			}
			
		}
		
		System.out.println(dp[N]);
		
	}
}
