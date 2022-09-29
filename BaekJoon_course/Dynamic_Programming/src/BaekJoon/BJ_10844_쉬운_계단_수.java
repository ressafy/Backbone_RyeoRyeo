package BaekJoon;

import java.util.Scanner;

public class BJ_10844_쉬운_계단_수 {
	// clear!!!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int mod = 1000000000;
		int [][] dp = new int[N+1][10];
		// dp[N][0] 마지막 수가 0인 계단 수의 최대 개수
		// 점화식은 dp[N][i] = dp[N][i-1] + dp[N][i+1]
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				dp[i][j] = 0;
				if(j-1 >= 0) dp[i][j] += dp[i-1][j-1];
				if(j+1 <= 9) dp[i][j] += dp[i-1][j+1];
				dp[i][j]= dp[i][j] % mod;
			}
		}
		
		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += dp[N][i];
		}
		
		ans = ans % mod;
		System.out.println(ans);
	}

}
