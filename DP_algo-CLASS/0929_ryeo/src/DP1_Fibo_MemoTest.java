import java.util.Arrays;
import java.util.Scanner;

public class DP1_Fibo_MemoTest {
	static long [] calls1, calls2, memo;
	static long callCnt1, callCnt2;
	static int N;
	
	static long fibo1(int n) {
		callCnt1++;
		calls1[n]++;
		
		if(n<=1) return n;  // 1항이면 1 0항이면 0
		return fibo1(n-1)+fibo1(n-2);
	}
	
	static long fibo2(int n) {
		callCnt2++;
		calls2[n]++;
		
		if(memo[n] == -1) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		calls1 = new long[N+1]; // 각 항을 계산하기 위한
		calls2 = new long[N+1];
		memo = new long[N+1];
		
		callCnt1 = callCnt2 = 0;
		Arrays.fill(memo, -1); // memo 배열을 -1 로 초기화
		
		// 처음부터 계산이 가능한 값 초기화
		memo[0] = 0;
		memo[1] = 1;
		
		System.out.println("ans: "+fibo2(N));
		System.out.println(callCnt2);
		for (int i = 0; i < N; i++) {
			System.out.println("fibo2("+i+") : "+calls2[i]);
		}
		
	
		
		System.out.println("--------------------------------------------------");
		
		
		System.out.println("ans: "+fibo1(N));
		System.out.println(callCnt1);
		for (int i = 0; i < N; i++) {
			System.out.println("fibo1("+i+") : "+calls1[i]);
		}
		
	}

}
